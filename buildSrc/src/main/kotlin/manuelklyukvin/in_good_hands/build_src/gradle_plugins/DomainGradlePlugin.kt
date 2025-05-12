package manuelklyukvin.in_good_hands.build_src.gradle_plugins

import manuelklyukvin.in_good_hands.build_src.plugins.Plugins
import org.gradle.api.Project

class DomainGradlePlugin : CoreGradlePlugin() {
    override fun applyPlugins(project: Project) {
        project.apply { plugin(Plugins.JVM) }
    }
}