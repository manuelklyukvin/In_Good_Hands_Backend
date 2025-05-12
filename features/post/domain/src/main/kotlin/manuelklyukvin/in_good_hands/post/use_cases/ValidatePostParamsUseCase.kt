package manuelklyukvin.in_good_hands.post.use_cases

class ValidatePostParamsUseCase {
    operator fun invoke(postId: Long, languageId: Int) {
        validatePostId(postId)
        validateLanguageId(languageId)
    }

    private fun validatePostId(postId: Long) = require(postId >= 0) { "post_id must be positive" }
    private fun validateLanguageId(languageId: Int) = require(languageId >= 0) { "language_id must be positive" }
}