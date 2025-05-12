package manuelklyukvin.in_good_hands.build_src.modules.bundles

import manuelklyukvin.in_good_hands.build_src.modules.feedDi
import manuelklyukvin.in_good_hands.build_src.modules.postDi
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.diBundle() {
    feedDi()
    postDi()
}