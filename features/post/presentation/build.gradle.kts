import manuelklyukvin.in_good_hands.build_src.gradle_plugins.PresentationGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.postDomain

apply<PresentationGradlePlugin>()

dependencies {
    postDomain()
}