package manuelklyukvin.in_good_hands.post.data_sources

import manuelklyukvin.in_good_hands.core.tables.addresses.*
import manuelklyukvin.in_good_hands.core.tables.pets.Pets
import manuelklyukvin.in_good_hands.core.tables.posts.PostImages
import manuelklyukvin.in_good_hands.core.tables.posts.Posts
import manuelklyukvin.in_good_hands.core.tables.users.Users
import manuelklyukvin.in_good_hands.post.models.DataAddress
import manuelklyukvin.in_good_hands.post.models.DataPet
import manuelklyukvin.in_good_hands.post.models.DataPost
import manuelklyukvin.in_good_hands.post.models.DataUser
import org.jetbrains.exposed.sql.innerJoin
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class PostDataSource {
    suspend fun getPost(postId: Long, languageId: Int) = newSuspendedTransaction {
        val postQuery = Posts
            .innerJoin(Users)
            .innerJoin(Pets)
            .innerJoin(Cities)
            .innerJoin(
                otherTable = CityTranslations,
                onColumn = { Cities.id },
                otherColumn = { cityId },
                additionalConstraint = { CityTranslations.languageId eq languageId }
            )
            .innerJoin(Regions)
            .innerJoin(
                otherTable = RegionTranslations,
                onColumn = { Regions.id },
                otherColumn = { regionId },
                additionalConstraint = { RegionTranslations.languageId eq languageId }
            )
            .innerJoin(Countries)
            .innerJoin(
                otherTable = CountryTranslations,
                onColumn = { Countries.id },
                otherColumn = { countryId },
                additionalConstraint = { CountryTranslations.languageId eq languageId }
            )
            .select(
                Posts.id,
                Users.id, Users.avatarName, Users.name,
                Posts.title,
                Posts.description,
                Pets.nickname, Pets.typeId, Pets.genderId, Pets.ageId, Pets.breed,
                CountryTranslations.name, RegionTranslations.name, CityTranslations.name,
                Posts.publicationDate
            )
            .where { Posts.id eq postId }
            .limit(1)
        val postImagesQuery = PostImages
            .select(PostImages.imageName)
            .where { PostImages.postId eq postId }

        val postResult = postQuery.firstOrNull() ?: return@newSuspendedTransaction null
        val postImagesResult = postImagesQuery.map { it[PostImages.imageName] }

        DataPost(
            id = postResult[Posts.id],
            imageNames = postImagesResult,
            user = DataUser(
                id = postResult[Users.id],
                avatarName = postResult[Users.avatarName],
                name = postResult[Users.name]
            ),
            title = postResult[Posts.title],
            description = postResult[Posts.description],
            pet = DataPet(
                nickname = postResult[Pets.nickname],
                typeId = postResult[Pets.typeId],
                genderId = postResult[Pets.genderId],
                ageId = postResult[Pets.ageId],
                breed = postResult[Pets.breed]
            ),
            address = DataAddress(
                country = postResult[CountryTranslations.name],
                region = postResult[RegionTranslations.name],
                city = postResult[CityTranslations.name]
            ),
            publicationDate = postResult[Posts.publicationDate]
        )
    }
}