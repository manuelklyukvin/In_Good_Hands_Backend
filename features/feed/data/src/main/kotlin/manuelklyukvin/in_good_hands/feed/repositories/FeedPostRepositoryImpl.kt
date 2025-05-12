package manuelklyukvin.in_good_hands.feed.repositories

import manuelklyukvin.in_good_hands.feed.data_sources.FeedPostDataSource
import manuelklyukvin.in_good_hands.feed.models.toDomain

class FeedPostRepositoryImpl(private val feedPostDataSource: FeedPostDataSource) : FeedPostRepository {
    override suspend fun getFeedPosts(
        postCount: Int,
        offset: Long,
        languageId: Int,
        searchQuery: String?
    ) = feedPostDataSource.getFeedPosts(
        postCount = postCount,
        offset = offset,
        languageId = languageId,
        searchQuery = searchQuery
    ).map { it.toDomain() }
}