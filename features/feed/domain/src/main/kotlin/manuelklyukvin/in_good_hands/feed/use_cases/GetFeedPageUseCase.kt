package manuelklyukvin.in_good_hands.feed.use_cases

import manuelklyukvin.in_good_hands.feed.models.DomainFeedPage
import manuelklyukvin.in_good_hands.feed.repositories.FeedPostRepository

class GetFeedPageUseCase(
    private val validateFeedPageParamsUseCase: ValidateFeedPageParamsUseCase,
    private val feedPostRepository: FeedPostRepository,
    private val getFeedPageOffsetUseCase: GetFeedPageOffsetUseCase
) {
    suspend operator fun invoke(
        postCount: Int,
        currentPage: Int,
        languageId: Int,
        searchQuery: String?
    ): DomainFeedPage {
        validateFeedPageParamsUseCase(
            postCount = postCount,
            currentPage = currentPage,
            languageId = languageId,
            searchQuery = searchQuery
        )

        val feedPosts = feedPostRepository.getFeedPosts(
            postCount = postCount + 1,
            offset = getFeedPageOffsetUseCase(postCount, currentPage),
            languageId = languageId,
            searchQuery = searchQuery
        )
        val hasNextPage = feedPosts.size > postCount

        return DomainFeedPage(
            feedPosts = if (hasNextPage) feedPosts.dropLast(1) else feedPosts,
            hasNextPage = hasNextPage
        )
    }
}