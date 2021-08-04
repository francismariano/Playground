object Libraries {

    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINE}"
    const val KTOR = "io.ktor:ktor-client-core:${Versions.KTOR}"
    const val KTOR_SERIALIZATION = "io.ktor:ktor-client-serialization:${Versions.KTOR}"

    // MVIKOTLIN
    fun MVIKOTLIN(module: String): String =
        "com.arkivanov.mvikotlin:$module:${Versions.MVIKOTLIN}"

    // Test
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
}