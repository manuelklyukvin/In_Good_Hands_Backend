package manuelklyukvin.in_good_hands.feed.use_cases

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetFeedPageOffsetUseCaseTest {
    private val getFeedPageOffsetUseCase = GetFeedPageOffsetUseCase()

    @Test
    fun `should return 0 when postCount is 10 and currentPage is 0`() {
        val result = getFeedPageOffsetUseCase(
            postCount = 10,
            currentPage = 0
        )
        val expectedResult = 0L
        assertEquals(expectedResult, result)
    }

    @Test
    fun `should return 10 when postCount is 10 and currentPage is 1`() {
        val result = getFeedPageOffsetUseCase(
            postCount = 10,
            currentPage = 1
        )
        val expectedResult = 10L
        assertEquals(expectedResult, result)
    }

    @Test
    fun `should return 30 when postCount is 10 and currentPage is 3`() {
        val result = getFeedPageOffsetUseCase(
            postCount = 10,
            currentPage = 3
        )
        val expectedResult = 30L
        assertEquals(expectedResult, result)
    }

    @Test
    fun `should return 0 when postCount is 0 and currentPage is 0`() {
        val result = getFeedPageOffsetUseCase(
            postCount = 0,
            currentPage = 0
        )
        val expectedResult = 0L
        assertEquals(expectedResult, result)
    }

    @Test
    fun `should handle large numbers correctly`() {
        val result = getFeedPageOffsetUseCase(
            postCount = Int.MAX_VALUE,
            currentPage = 1
        )
        val expectedResult = Int.MAX_VALUE.toLong()
        assertEquals(expectedResult, result)
    }
}