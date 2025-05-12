package manuelklyukvin.in_good_hands.feed.repositories

import manuelklyukvin.in_good_hands.feed.models.DomainFeedPost

interface FeedPostRepository {
    suspend fun getFeedPosts(
        postCount: Int,
        offset: Long,
        languageId: Int,
        searchQuery: String?
    ): List<DomainFeedPost>
}