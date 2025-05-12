import manuelklyukvin.in_good_hands.build_src.dependencies.*
import manuelklyukvin.in_good_hands.build_src.modules.bundles.diBundle
import manuelklyukvin.in_good_hands.build_src.modules.bundles.presentationBundle

plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.ktor)
}

group = "manuelklyukvin.in_good_hands"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

dependencies {
    ktor()
    koin()
    exposed()
    serialization()
    statusPages()

    presentationBundle()
    diBundle()
}