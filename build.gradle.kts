plugins {
    alias(libs.plugins.jvm) apply false
    alias(libs.plugins.ktor) apply false
    alias(libs.plugins.serialization) apply false
}

allprojects {
    repositories {
        mavenCentral()
    }
}