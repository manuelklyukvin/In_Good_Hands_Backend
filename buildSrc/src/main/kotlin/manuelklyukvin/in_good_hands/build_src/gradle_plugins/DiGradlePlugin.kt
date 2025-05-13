package manuelklyukvin.in_good_hands.build_src.gradle_plugins

import manuelklyukvin.in_good_hands.build_src.dependencies.koin
import manuelklyukvin.in_good_hands.build_src.modules.coreData
import manuelklyukvin.in_good_hands.build_src.modules.corePresentation
import manuelklyukvin.in_good_hands.build_src.plugins.Plugins
import org.gradle.api.Project

class DiGradlePlugin : CoreGradlePlugin() {
    override fun applyPlugins(project: Project) {
        project.apply { plugin(Plugins.JVM) }
    }

    override fun applyDependencies(project: Project) {
        project.dependencies.apply {
            koin()

            coreData()
            corePresentation()
        }
    }

    override fun applyTesting(project: Project) = Unit
}