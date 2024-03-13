plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.22" apply false
    id("androidx.navigation.safeargs") version "2.5.3" apply false
    id("com.google.dagger.hilt.android") version "2.46.1" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}