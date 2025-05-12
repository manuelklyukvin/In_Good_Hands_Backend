package manuelklyukvin.in_good_hands.post.use_cases

import manuelklyukvin.in_good_hands.post.models.DomainPost
import manuelklyukvin.in_good_hands.post.repositories.PostRepository

class GetPostUseCase(
    private val postRepository: PostRepository,
    private val validatePostParamsUseCase: ValidatePostParamsUseCase
) {
    suspend operator fun invoke(postId: Long, languageId: Int): DomainPost? {
        validatePostParamsUseCase(postId, languageId)
        return postRepository.getPost(postId, languageId)
    }
}