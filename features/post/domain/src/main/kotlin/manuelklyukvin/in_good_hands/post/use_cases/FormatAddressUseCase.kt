package manuelklyukvin.in_good_hands.post.use_cases

import manuelklyukvin.in_good_hands.post.models.DomainAddress

class FormatAddressUseCase {
    operator fun invoke(address: DomainAddress) = with(address) {
        if (city.contentEquals(region)) {
            listOf(country, city).joinToString()
        } else {
            listOf(country, region, city).joinToString()
        }
    }
}