package manuelklyukvin.in_good_hands.app.configs

import io.ktor.server.application.*
import manuelklyukvin.in_good_hands.feed.di.feedModule
import manuelklyukvin.in_good_hands.post.di.postModule
import org.koin.ktor.plugin.Koin

fun Application.koinConfig() {
    install(Koin) {
        modules(
            feedModule, postModule
        )
    }
}