package manuelklyukvin.in_good_hands.post.models

data class DataUser(
    val id: Long,
    val avatarName: String?,
    val name: String
)

fun DataUser.toDomain() = DomainUser(
    id = id,
    avatarName = avatarName,
    name = name
)