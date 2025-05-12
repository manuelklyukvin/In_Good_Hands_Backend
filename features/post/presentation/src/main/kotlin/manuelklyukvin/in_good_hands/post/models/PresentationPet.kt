package manuelklyukvin.in_good_hands.post.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PresentationPet(
    val nickname: String?,
    @SerialName("type_id") val typeId: Int,
    @SerialName("gender_id") val genderId: Int,
    @SerialName("age_id") val ageId: Int,
    val breed: String?
)