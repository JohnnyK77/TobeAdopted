plugins {
    id(Plugins.JAVA_LIBRARY)
    id(Plugins.KOTLIN_JVM)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation (Dependencies.COROUTINES_CORE)
    implementation (Dependencies.COROUTINES_ANDROID)
}