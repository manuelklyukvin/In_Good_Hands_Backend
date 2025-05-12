package manuelklyukvin.in_good_hands.feed.use_cases

class GetFeedPageOffsetUseCase {
    operator fun invoke(postCount: Int, currentPage: Int) = (postCount * currentPage).toLong()
}