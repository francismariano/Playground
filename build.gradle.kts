buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Classpaths.ANDROID_GRADLE_PLUGIN)
        classpath(Classpaths.KOTLIN_GRADLE_PLUGIN)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}