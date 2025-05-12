package manuelklyukvin.in_good_hands.app.configs

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.utils.io.*

fun Application.statusPagesConfig() {
    install(StatusPages) {
        exception<CancellationException> { call, e ->
            call.application.log.error("CancellationException", e)
            throw e
        }
        exception<IllegalArgumentException> { call, e ->
            call.application.log.error("IllegalArgumentException", e)
            call.respond(HttpStatusCode.BadRequest, e.localizedMessage)
        }
        exception<BadRequestException> { call, e ->
            call.application.log.error("BadRequestException", e)
            call.respond(HttpStatusCode.BadRequest, e.localizedMessage)
        }
        exception<NotFoundException> { call, e ->
            call.application.log.error("NotFoundException", e)
            call.respond(HttpStatusCode.NotFound, e.localizedMessage)
        }
        exception<Exception> { call, e ->
            call.application.log.error("Exception", e)
            call.respond(HttpStatusCode.InternalServerError, e.localizedMessage)
        }
    }
}