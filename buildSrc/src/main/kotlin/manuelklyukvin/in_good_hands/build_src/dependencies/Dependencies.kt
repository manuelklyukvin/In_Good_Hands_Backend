package manuelklyukvin.in_good_hands.build_src.dependencies

internal object Dependencies {
    const val KTOR = "io.ktor:ktor-server-netty:${DependencyVersions.KTOR}"

    const val KOIN = "io.insert-koin:koin-ktor:${DependencyVersions.KOIN}"

    const val SERIALIZATION = "io.ktor:ktor-serialization-kotlinx-json:${DependencyVersions.KTOR}"
    const val CONTENT_NEGOTIATION = "io.ktor:ktor-server-content-negotiation:${DependencyVersions.KTOR}"

    const val STATUS_PAGES = "io.ktor:ktor-server-status-pages:${DependencyVersions.KTOR}"

    const val EXPOSED_CORE = "org.jetbrains.exposed:exposed-core:${DependencyVersions.EXPOSED}"
    const val EXPOSED_JDBC = "org.jetbrains.exposed:exposed-jdbc:${DependencyVersions.EXPOSED}"
    const val EXPOSED_TIME = "org.jetbrains.exposed:exposed-java-time:${DependencyVersions.EXPOSED}"
    const val MYSQL = "com.mysql:mysql-connector-j:${DependencyVersions.MYSQL}"
    const val LOGBACK = "ch.qos.logback:logback-classic:${DependencyVersions.LOGBACK}"

    const val MOCKK = "io.mockk:mockk:${DependencyVersions.MOCKK}"
    const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${DependencyVersions.COROUTINES_TEST}"
}