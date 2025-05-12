package manuelklyukvin.in_good_hands.post.use_cases

import manuelklyukvin.in_good_hands.post.models.DomainAddress
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FormatAddressUseCaseTest {
    private val formatAddressUseCase = FormatAddressUseCase()

    @Test
    fun `should return address with no region when region is called as city`() {
        val result = formatAddressUseCase(
            DomainAddress(
                country = "country",
                region = "city",
                city = "city"
            )
        )
        val expectedResult = "country, city"
        assertEquals(expectedResult, result)
    }

    @Test
    fun `should return full address with valid params`() {
        val result = formatAddressUseCase(
            DomainAddress(
                country = "country",
                region = "region",
                city = "city"
            )
        )
        val expectedResult = "country, region, city"
        assertEquals(expectedResult, result)
    }
}