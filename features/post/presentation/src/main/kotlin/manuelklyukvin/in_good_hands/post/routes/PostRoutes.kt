package manuelklyukvin.in_good_hands.post.routes

import io.ktor.server.routing.*

fun Route.postRoutes() {
    route("post") {
        getPostRoute()
    }
}