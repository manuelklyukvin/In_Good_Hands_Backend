package manuelklyukvin.in_good_hands.post.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PresentationUser(
    val id: Long,
    @SerialName("avatar_name") val avatarName: String?,
    val name: String
)