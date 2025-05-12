package manuelklyukvin.in_good_hands.build_src.gradle_plugins

import manuelklyukvin.in_good_hands.build_src.dependencies.koin
import manuelklyukvin.in_good_hands.build_src.dependencies.ktor
import manuelklyukvin.in_good_hands.build_src.dependencies.serialization
import manuelklyukvin.in_good_hands.build_src.modules.corePresentation
import manuelklyukvin.in_good_hands.build_src.plugins.Plugins
import org.gradle.api.Project

class PresentationGradlePlugin : CoreGradlePlugin() {
    override fun applyPlugins(project: Project) {
        project.apply {
            plugin(Plugins.JVM)
            plugin(Plugins.SERIALIZATION)
        }
    }

    override fun applyDependencies(project: Project) {
        project.dependencies.apply {
            ktor()
            koin()
            serialization()

            corePresentation()
        }
    }
}