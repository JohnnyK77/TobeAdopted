// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.ANDROID_APPLICATION) version Versions.ANDROID_APPLICATION apply false
    id(Plugins.KOTLIN_ANDROID) version Versions.KOTLIN_ANDROID apply false
    id(Plugins.ANDROID_LIBRARY) version Versions.ANDROID_LIBRARY apply false
    id(Plugins.DAGGER_HILT) version Versions.DAGGER_HILT apply false
}