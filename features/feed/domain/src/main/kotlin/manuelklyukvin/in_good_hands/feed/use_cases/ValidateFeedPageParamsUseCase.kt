package manuelklyukvin.in_good_hands.feed.use_cases

class ValidateFeedPageParamsUseCase {
    operator fun invoke(
        postCount: Int,
        currentPage: Int,
        languageId: Int,
        searchQuery: String?
    ) {
        validatePostCount(postCount)
        validateCurrentPage(currentPage)
        validateLanguageId(languageId)
        validateSearchQuery(searchQuery)
    }

    private fun validatePostCount(postCount: Int) = require(postCount > 0) { "post_count must be greater than 0" }
    private fun validateCurrentPage(currentPage: Int) = require(currentPage >= 0) { "current_page must be positive" }
    private fun validateLanguageId(languageId: Int) = require(languageId >= 0) { "language_id must be positive" }
    private fun validateSearchQuery(searchQuery: String?) = searchQuery?.let {
        require(searchQuery.isNotBlank()) { "search_query must be not blank" }
        require(!containsSqlInjection(searchQuery) && !containsXssAttempt(searchQuery)) {
            "search_query contains forbidden characters"
        }
    }

    private fun containsSqlInjection(searchQuery: String) = sqlKeywords.any {
        searchQuery.contains(it, ignoreCase = true)
    }
    private fun containsXssAttempt(searchQuery: String) = xssKeywords.any {
        searchQuery.contains(it, ignoreCase = true)
    }

    private companion object {
        val sqlKeywords = setOf(
            "SELECT",
            "INSERT",
            "UPDATE",
            "DELETE",
            "DROP",
            "UNION",
            "/*",
            "*/",
            "OR 1=1"
        )

        val xssKeywords = setOf(
            "<script>",
            "</script>",
            "javascript:",
            "onerror=",
            "onload=",
            "eval(",
            "alert(",
            "document.cookie"
        )
    }
}