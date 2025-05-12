import manuelklyukvin.in_good_hands.build_src.gradle_plugins.DataGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.postDomain

apply<DataGradlePlugin>()

dependencies {
    postDomain()
}