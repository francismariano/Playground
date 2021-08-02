plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))
    implementation(Libraries.MATERIAL)
    implementation(Libraries.APPCOMPAT)
    implementation(Libraries.CONSTRAINT_LAYOUT)
}

android {
    compileSdk = Configs.COMPILE_SDK
    defaultConfig {
        applicationId = Configs.APPLICATION_ID
        minSdk = Configs.MIN_SDK
        targetSdk = Configs.TARGET_SDK
        versionCode = Configs.VERSION_CODE
        versionName = Configs.VERSION_NAME
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}