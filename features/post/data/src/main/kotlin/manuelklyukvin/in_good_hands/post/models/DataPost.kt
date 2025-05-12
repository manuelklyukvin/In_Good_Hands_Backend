package manuelklyukvin.in_good_hands.post.models

import java.time.Instant

data class DataPost(
    val id: Long,
    val imageNames: List<String>,
    val user: DataUser,
    val title: String,
    val description: String?,
    val pet: DataPet,
    val address: DataAddress,
    val publicationDate: Instant
)

fun DataPost.toDomain() = DomainPost(
    id = id,
    imageNames = imageNames,
    user = user.toDomain(),
    title = title,
    description = description,
    pet = pet.toDomain(),
    address = address.toDomain(),
    publicationDate = publicationDate
)