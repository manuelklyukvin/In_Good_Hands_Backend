package manuelklyukvin.in_good_hands.feed.routes

import io.ktor.server.routing.*

fun Route.feedRoutes() {
    route("feed") {
        getFeedPageRoute()
    }
}