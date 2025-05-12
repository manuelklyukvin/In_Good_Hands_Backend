package manuelklyukvin.in_good_hands.post.use_cases

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatePostParamsUseCaseTest {
    private val validatePostParamsUseCase = ValidatePostParamsUseCase()

    @Test
    fun `should throw IllegalArgumentException when postId is negative`() {
        assertThrows<IllegalArgumentException> { validatePostParamsUseCase(-1, 0) }
    }

    @Test
    fun `should throw IllegalArgumentException when languageId is negative`() {
        assertThrows<IllegalArgumentException> { validatePostParamsUseCase(0, -1) }
    }

    @Test
    fun `should pass with valid params`() = validatePostParamsUseCase(0, 0)
}