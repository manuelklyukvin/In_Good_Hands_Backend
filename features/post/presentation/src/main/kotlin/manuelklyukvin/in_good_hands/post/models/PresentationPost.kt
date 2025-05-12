package manuelklyukvin.in_good_hands.post.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PresentationPost(
    val id: Long,
    @SerialName("image_names") val imageNames: List<String>,
    val user: PresentationUser,
    val title: String,
    val description: String?,
    val pet: PresentationPet,
    val address: String,
    @SerialName("publication_date") val publicationDate: String
)