package manuelklyukvin.in_good_hands.post.models

data class DataPet(
    val nickname: String?,
    val typeId: Int,
    val genderId: Int,
    val ageId: Int,
    val breed: String?
)

fun DataPet.toDomain() = DomainPet(
    nickname = nickname,
    typeId = typeId,
    genderId = genderId,
    ageId = ageId,
    breed = breed
)