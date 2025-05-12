package manuelklyukvin.in_good_hands.feed.use_cases

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidateFeedPageParamsUseCaseTest {
    private val validateFeedPageParamsUseCase = ValidateFeedPageParamsUseCase()

    @Test
    fun `should throw IllegalArgumentException when postCount is negative`() {
        assertThrows<IllegalArgumentException> {
            validateFeedPageParamsUseCase(
                postCount = -10,
                currentPage = 0,
                languageId = 0,
                searchQuery = null
            )
        }
    }

    @Test
    fun `should throw IllegalArgumentException when postCount is 0`() {
        assertThrows<IllegalArgumentException> {
            validateFeedPageParamsUseCase(
                postCount = 0,
                currentPage = 0,
                languageId = 0,
                searchQuery = null
            )
        }
    }

    @Test
    fun `should throw IllegalArgumentException when currentPage is negative`() {
        assertThrows<IllegalArgumentException> {
            validateFeedPageParamsUseCase(
                postCount = 10,
                currentPage = -1,
                languageId = 0,
                searchQuery = null
            )
        }
    }

    @Test
    fun `should throw IllegalArgumentException when languageId is negative`() {
        assertThrows<IllegalArgumentException> {
            validateFeedPageParamsUseCase(
                postCount = 10,
                currentPage = 0,
                languageId = -1,
                searchQuery = null
            )
        }
    }

    @Test
    fun `should throw IllegalArgumentException when searchQuery is empty`() {
        assertThrows<IllegalArgumentException> {
            validateFeedPageParamsUseCase(
                postCount = 10,
                currentPage = 0,
                languageId = 0,
                searchQuery = ""
            )
        }
    }

    @Test
    fun `should throw IllegalArgumentException when searchQuery is blank`() {
        assertThrows<IllegalArgumentException> {
            validateFeedPageParamsUseCase(
                postCount = 10,
                currentPage = 0,
                languageId = 0,
                searchQuery = "   "
            )
        }
    }

    @Test
    fun `should throw IllegalArgumentException when searchQuery contains SQL injection in lowercase`() {
        assertThrows<IllegalArgumentException> {
            validateFeedPageParamsUseCase(
                postCount = 10,
                currentPage = 0,
                languageId = 0,
                searchQuery = "select *"
            )
        }
    }

    @Test
    fun `should throw IllegalArgumentException when searchQuery contains SQL injection in uppercase`() {
        assertThrows<IllegalArgumentException> {
            validateFeedPageParamsUseCase(
                postCount = 10,
                currentPage = 0,
                languageId = 0,
                searchQuery = "SELECT *"
            )
        }
    }

    @Test
    fun `should throw IllegalArgumentException when searchQuery contains XSS attempt in lowercase`() {
        assertThrows<IllegalArgumentException> {
            validateFeedPageParamsUseCase(
                postCount = 10,
                currentPage = 0,
                languageId = 0,
                searchQuery = "<script>"
            )
        }
    }

    @Test
    fun `should throw IllegalArgumentException when searchQuery contains XSS attempt in uppercase`() {
        assertThrows<IllegalArgumentException> {
            validateFeedPageParamsUseCase(
                postCount = 10,
                currentPage = 0,
                languageId = 0,
                searchQuery = "<SCRIPT>"
            )
        }
    }

    @Test
    fun `should pass with valid params`() = validateFeedPageParamsUseCase(
        postCount = 10,
        currentPage = 0,
        languageId = 0,
        searchQuery = "test"
    )
}