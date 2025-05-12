package manuelklyukvin.in_good_hands.post.models

data class DataAddress(
    val country: String,
    val region: String,
    val city: String
)

fun DataAddress.toDomain() = DomainAddress(
    country = country,
    region = region,
    city = city
)