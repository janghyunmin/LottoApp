buildscript {
    repositories {
        google()
        jcenter()
        maven {
            url = uri("https://dl.google.com/dl/android/maven2")
        }
        maven {
            url = uri("https://oss.jfrog.org/libs-snapshot")
        }
        maven {
            url = uri("https://naver.jfrog.io/artifactory/maven/")
        }
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_PLGUIN}") // 코틀린 플러그인 적용
        classpath("com.google.gms:google-services:${Versions.GOOGLE_GMS}")
        classpath("com.neenbedankt.gradle.plugins:android-apt:${Versions.ANDROID_APT}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.DAGGER_HILT}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION_SAFE}")
        classpath("com.google.android.gms:oss-licenses-plugin:0.10.6")
        classpath("com.google.firebase.appdistribution:com.google.firebase.appdistribution.gradle.plugin:4.0.1")
        classpath("de.mannodermaus.gradle.plugins:android-junit5:1.8.2.0")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven {
            url = uri("https://dl.google.com/dl/android/maven2")
        }
        maven {
            url = uri("https://jitpack.io")
        }
        maven {
            url = uri("https://devrepo.kakao.com/nexus/content/groups/public/")
        }
        maven {
            url = uri("https://naver.jfrog.io/artifactory/maven/")
        }
        mavenCentral()
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
