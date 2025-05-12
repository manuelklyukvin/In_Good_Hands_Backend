package manuelklyukvin.in_good_hands.feed.models

data class DataFeedPost(
    val id: Long,
    val imageName: String,
    val title: String,
    val petTypeId: Int,
    val city: String
)

fun DataFeedPost.toDomain() = DomainFeedPost(
    id = id,
    imageName = imageName,
    title = title,
    petTypeId = petTypeId,
    city = city
)