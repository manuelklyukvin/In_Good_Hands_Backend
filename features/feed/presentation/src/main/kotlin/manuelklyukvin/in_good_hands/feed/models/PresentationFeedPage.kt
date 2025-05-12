package manuelklyukvin.in_good_hands.feed.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PresentationFeedPage(
    @SerialName("feed_posts") val feedPosts: List<PresentationFeedPost>,
    @SerialName("has_next_page") val hasNextPage: Boolean
)

fun DomainFeedPage.toPresentation() = PresentationFeedPage(
    feedPosts = feedPosts.map { it.toPresentation() },
    hasNextPage = hasNextPage
)