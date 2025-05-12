package manuelklyukvin.in_good_hands.build_src.modules

import manuelklyukvin.in_good_hands.build_src.utils.dataModule
import manuelklyukvin.in_good_hands.build_src.utils.presentationModule
import org.gradle.api.artifacts.dsl.DependencyHandler

private const val MODULE = ":core"

fun DependencyHandler.corePresentation() = presentationModule(MODULE)
fun DependencyHandler.coreData() = dataModule(MODULE)