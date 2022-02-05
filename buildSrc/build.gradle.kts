plugins {
    `kotlin-dsl`
}



repositories {
    google()
    jcenter()
    maven ( "https://jitpack.io" )
    gradlePluginPortal()
}

object PluginVersion {
    const val GRADLE = "7.1.0-beta05"
    const val KOTLIN = "1.6.10"
    const val GRADLE_PLUGIN = "0.41.0"
    const val HILT = "2.38.1"
}


dependencies {
    implementation("com.android.tools.build:gradle:7.1.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginVersion.KOTLIN}")
    implementation("com.github.ben-manes:gradle-versions-plugin:${PluginVersion.GRADLE_PLUGIN}")
    implementation("com.google.dagger:hilt-android-gradle-plugin:${PluginVersion.HILT}")
}



