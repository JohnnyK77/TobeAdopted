plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.DAGGER_HILT)
}

android {
    namespace = "${DefaultConfig.NAME_SPACE}.data"
    compileSdk = DefaultConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = DefaultConfig.MIN_SDK_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":domain"))
    // Android
    implementation(Dependencies.ANDROID_CORE_KTX)
    implementation(Dependencies.ANDROID_APPCOMPAT)
    implementation(Dependencies.ANDROID_MATERIAL)
    // Test
    testImplementation(Dependencies.JUNIT)
    androidTestImplementation(Dependencies.ANDROID_TEST_JUNIT)
    androidTestImplementation(Dependencies.ANDROID_TEST_ESPRESSO)
    // DI
    implementation(Dependencies.DAGGER_HILT)
    kapt(Dependencies.DAGGER_COMPILER)
    implementation(Dependencies.ANDROID_HILT_WORK)
    kapt(Dependencies.ANDROID_HILT_COMPILER)
    implementation(Dependencies.ANDROID_WORK_RUNTIME_KTX)
    implementation(Dependencies.ANDROID_HILT_NAVIGATION_COMPOSE)
    // Network
    implementation(Dependencies.RETROFIT2)
    implementation(Dependencies.RETROFIT2_CONVERTOR_GSON)
    // Logger
    implementation(Dependencies.Logger)
}