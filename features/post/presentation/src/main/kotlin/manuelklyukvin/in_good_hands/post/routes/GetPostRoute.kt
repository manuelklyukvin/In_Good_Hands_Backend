package manuelklyukvin.in_good_hands.post.routes

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import manuelklyukvin.in_good_hands.post.mappers.PostMapper
import manuelklyukvin.in_good_hands.post.use_cases.GetPostUseCase
import org.koin.ktor.ext.inject

internal fun Route.getPostRoute() {
    val getPostUseCase by inject<GetPostUseCase>()
    val postMapper by inject<PostMapper>()

    get {
        val postId = call.parameters.getOrFail<Long>("post_id")
        val languageId = call.parameters.getOrFail<Int>("language_id")

        val post = postMapper.toPresentation(
            getPostUseCase(postId, languageId)
        )
        if (post != null) {
            call.respond(post)
        } else {
            call.respond(HttpStatusCode.NotFound, "Post not found")
        }
    }
}