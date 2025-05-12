package manuelklyukvin.in_good_hands.app.configs

import io.ktor.server.application.*
import io.ktor.server.routing.*
import manuelklyukvin.in_good_hands.core.routes.avatarStaticFiles
import manuelklyukvin.in_good_hands.core.routes.postImageStaticFiles
import manuelklyukvin.in_good_hands.feed.routes.feedRoutes
import manuelklyukvin.in_good_hands.post.routes.postRoutes

fun Application.routingConfig() {
    routing {
        route("api") {
            avatarStaticFiles()
            postImageStaticFiles()

            feedRoutes()
            postRoutes()
        }
    }
}