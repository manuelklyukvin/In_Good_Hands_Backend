package manuelklyukvin.in_good_hands.feed.data_sources

import manuelklyukvin.in_good_hands.core.tables.addresses.Cities
import manuelklyukvin.in_good_hands.core.tables.addresses.CityTranslations
import manuelklyukvin.in_good_hands.core.tables.pets.Pets
import manuelklyukvin.in_good_hands.core.tables.posts.PostImages
import manuelklyukvin.in_good_hands.core.tables.posts.Posts
import manuelklyukvin.in_good_hands.feed.models.DataFeedPost
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.SqlExpressionBuilder.like
import org.jetbrains.exposed.sql.SqlExpressionBuilder.rowNumber
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class FeedPostDataSource {
    suspend fun getFeedPosts(
        postCount: Int,
        offset: Long,
        languageId: Int,
        searchQuery: String?
    ) = newSuspendedTransaction {
        val rowNumberAlias = rowNumber()
            .over()
            .partitionBy(PostImages.postId)
            .orderBy(PostImages.id)
            .alias("row_number_alias")
        val postImagesAlias = PostImages
            .select(
                PostImages.postId,
                PostImages.imageName,
                rowNumberAlias
            )
            .alias("post_images_alias")

        val statusCondition = Posts.statusId eq 1
        val languageCondition = CityTranslations.languageId eq languageId
        val searchQueryCondition = buildSearchQueryCondition(searchQuery)

        val query = Posts
            .innerJoin(
                otherTable = postImagesAlias,
                onColumn = { id },
                otherColumn = { postImagesAlias[PostImages.postId] },
                additionalConstraint = { postImagesAlias[rowNumberAlias] eq 1 }
            )
            .innerJoin(Pets)
            .innerJoin(Cities)
            .innerJoin(CityTranslations)
            .select(
                Posts.id,
                postImagesAlias[PostImages.imageName],
                Posts.title,
                Pets.typeId,
                CityTranslations.name
            )
            .where { statusCondition and languageCondition and searchQueryCondition }
            .orderBy(Posts.publicationDate, SortOrder.DESC)
            .limit(postCount)
            .offset(offset)

        query.map {
            DataFeedPost(
                id = it[Posts.id],
                imageName = it[postImagesAlias[PostImages.imageName]],
                title = it[Posts.title],
                petTypeId = it[Pets.typeId],
                city = it[CityTranslations.name]
            )
        }
    }

    private fun buildSearchQueryCondition(searchQuery: String?) = if (!searchQuery.isNullOrBlank()) {
        searchQuery
            .split(" ")
            .filter { it.isNotBlank() }
            .map { it.lowercase() }
            .map { word ->
                (Posts.title.lowerCase() like "%$word%") or
                (Posts.description.lowerCase() like "%$word%") or
                (Pets.breed.lowerCase() like "%$word%")
            }
            .reduce { acc, condition -> acc and condition }
    } else Op.TRUE
}