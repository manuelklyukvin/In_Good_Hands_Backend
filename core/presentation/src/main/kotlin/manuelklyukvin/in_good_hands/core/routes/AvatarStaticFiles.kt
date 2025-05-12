package manuelklyukvin.in_good_hands.core.routes

import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import java.io.File

fun Route.avatarStaticFiles() {
    staticFiles("avatar", File("uploads/avatars"))
}