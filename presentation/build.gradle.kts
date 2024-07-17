plugins {
    id(Plugins.ANDROID_APPLICATION)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.DAGGER_HILT)
}

android {
    namespace = DefaultConfig.NAME_SPACE
    compileSdk = DefaultConfig.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = DefaultConfig.APPLICATION_ID
        minSdk = DefaultConfig.MIN_SDK_VERSION
        targetSdk = DefaultConfig.TARGET_SDK_VERSION
        versionCode = DefaultConfig.VERSION_CODE
        versionName = DefaultConfig.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    // Android
    implementation(Dependencies.ANDROID_CORE_KTX)
    implementation(Dependencies.ANDROID_LIFECYCLE_RUNTIME_KTX)
    // Compose
    implementation(Dependencies.ANDROID_ACTIVITY_COMPOSE)
    implementation(platform(Dependencies.ANDROID_COMPOSE_BOM))
    implementation(Dependencies.ANDROID_COMPOSE_UI_UI)
    implementation(Dependencies.ANDROID_COMPOSE_UI_GRAPHICS)
    implementation(Dependencies.ANDROID_COMPOSE_UI_TOOLING_PREVIEW)
    implementation(Dependencies.ANDROID_COMPOSE_MATERIAL3)
    androidTestImplementation(platform(Dependencies.ANDROID_COMPOSE_BOM))
    androidTestImplementation(Dependencies.ANDROID_COMPOSE_UI_TEST_JUNIT4)
    debugImplementation(Dependencies.ANDROID_COMPOSE_UI_TOOLING)
    debugImplementation(Dependencies.ANDROID_COMPOSE_UI_TEST_MANIFEST)
    // DI
    implementation(Dependencies.DAGGER_HILT)
    kapt(Dependencies.DAGGER_COMPILER)
    implementation(Dependencies.ANDROID_HILT_WORK)
    kapt(Dependencies.ANDROID_HILT_COMPILER)
    implementation(Dependencies.ANDROID_WORK_RUNTIME_KTX)
    implementation(Dependencies.ANDROID_HILT_NAVIGATION_COMPOSE)
    // Logger
    implementation(Dependencies.Logger)
    // Test
    testImplementation(Dependencies.JUNIT)
    androidTestImplementation(Dependencies.ANDROID_TEST_JUNIT)
    androidTestImplementation(Dependencies.ANDROID_TEST_ESPRESSO)
    // Image Loader
    implementation(Dependencies.Coil)
    // Youtube player
    implementation(Dependencies.YOUTUBE_PLAYER)
    // Splash
    implementation (Dependencies.SPLASH)
}