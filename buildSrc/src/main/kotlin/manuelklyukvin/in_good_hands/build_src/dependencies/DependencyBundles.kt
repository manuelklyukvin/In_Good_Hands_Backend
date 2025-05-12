package manuelklyukvin.in_good_hands.build_src.dependencies

import manuelklyukvin.in_good_hands.build_src.utils.implementation
import manuelklyukvin.in_good_hands.build_src.utils.testImplementation
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.kotlin

fun DependencyHandler.ktor() = implementation(Dependencies.KTOR)

fun DependencyHandler.koin() = implementation(Dependencies.KOIN)

fun DependencyHandler.serialization() {
    implementation(Dependencies.SERIALIZATION)
    implementation(Dependencies.CONTENT_NEGOTIATION)
}

fun DependencyHandler.statusPages() = implementation(Dependencies.STATUS_PAGES)

fun DependencyHandler.exposed() {
    implementation(Dependencies.EXPOSED_CORE)
    implementation(Dependencies.EXPOSED_JDBC)
    implementation(Dependencies.EXPOSED_TIME)
    implementation(Dependencies.MYSQL)
    implementation(Dependencies.LOGBACK)
}

fun DependencyHandler.testing() {
    testImplementation(kotlin("test"))
    testImplementation(Dependencies.MOCKK)
    testImplementation(Dependencies.COROUTINES_TEST)
}