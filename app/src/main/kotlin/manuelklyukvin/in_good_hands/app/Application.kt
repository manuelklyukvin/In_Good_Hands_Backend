package manuelklyukvin.in_good_hands.app

import io.ktor.server.application.*
import io.ktor.server.netty.*
import manuelklyukvin.in_good_hands.app.configs.*

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.modules() {
    serializationConfig()
    koinConfig()
    databaseConfig()
    statusPagesConfig()
    routingConfig()
}