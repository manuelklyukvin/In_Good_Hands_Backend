package manuelklyukvin.in_good_hands.feed.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PresentationFeedPost(
    val id: Long,
    @SerialName("image_name") val imageName: String,
    val title: String,
    @SerialName("pet_type_id") val petTypeId: Int,
    val city: String
)

fun DomainFeedPost.toPresentation() = PresentationFeedPost(
    id = id,
    imageName = imageName,
    title = title,
    petTypeId = petTypeId,
    city = city
)