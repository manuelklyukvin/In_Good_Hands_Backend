package manuelklyukvin.in_good_hands.app.configs

import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database

fun Application.databaseConfig() {
    val databaseConfig = environment.config.config("ktor.database")

    val url = databaseConfig.property("url").getString()
    val driver = databaseConfig.property("driver").getString()
    val user = databaseConfig.property("user").getString()
    val password = databaseConfig.property("password").getString()

    Database.connect(
        url = url,
        driver = driver,
        user = user,
        password = password
    )
}