plugins {
    kotlin("android")
    kotlin("kapt")

    id ("com.android.application")
    id ("com.google.gms.google-services")
    id ("androidx.navigation.safeargs.kotlin")
    id ("dagger.hilt.android.plugin")

    id("com.google.android.gms.oss-licenses-plugin")
    id("com.google.firebase.appdistribution")

    id("de.mannodermaus.android-junit5")
}

android {
    namespace = Apps.APP_NAME
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion = Apps.buildTools

    defaultConfig {
        applicationId = Apps.APP_NAME
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = 1
        versionName = "1.0.0"
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = Apps.ANDROID_JUNIT_RUNNER
    }

    buildTypes {
        release {
            isDebuggable = false
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    dataBinding {
        isEnabled = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    packagingOptions {
        resources {
            excludes += setOf(
                "META-INF/DEPENDENCIES",
                "META-INF/DEPENDENCIES.txt",
                "META-INF/dependencies.txt",
                "META-INF/LICENSE",
                "META-INF/LICENSE.txt",
                "META-INF/license.txt",
                "META-INF/NOTICE",
                "META-INF/NOTICE.txt",
                "META-INF/notice.txt",
                "META-INF/LGPL2.1",
                "META-INF/ASL2.0",
                "build.xml",
                "META-INF/rxjava.properties",
                "META-INF/proguard/androidx-annotations.pro",
            )
        }
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Hilt dependencies
    implementation(Dagger.HILT)
    kapt(Dagger.COMPILER)

    // Add other dependencies here
    implementation(AndroidX.WINDOW)
    implementation(AndroidX.CORE)
    implementation(AndroidX.WORK)
    implementation(AndroidX.ACTIVITY)
    implementation(AndroidX.FRAGMENT)
    implementation(AndroidX.LIFECYCLE_VIEWMODEL)
    implementation(AndroidX.LIFECYCLE_LIVEDATA)
    implementation(AndroidX.APPCOMPAT)
    implementation(AndroidX.MULTIDEX)
    implementation(AndroidX.BROWSER)
    implementation(AndroidX.CONSTRAINT_LAYOUT)
    implementation(AndroidX.VIEWPAGER)
    implementation(AndroidX.VIEWPAGER2)
    implementation(AndroidX.LIFECYCLE_EXTENSIONS)
    implementation(AndroidX.COMMON)
    implementation(AndroidX.DATABINDING)
    implementation(AndroidX.SWIPEREFRESH)
    implementation(AndroidX.SPLASHCREEN)
    implementation(AndroidX.BIOMETRIC)
    implementation(AndroidX.BIOMETRIC_KTX)
    implementation(Google.MATERIAL)
    implementation(Kotlin.COROUTINES)

    implementation(Compose.COMPOSE_LOTTIE)
    implementation(Compose.COMPOSE_COIL)
    implementation(Compose.COMPOSE_COIL_GIF)
    implementation(Compose.COMPOSE_GLIDE)
    implementation(Compose.COMPOSE_PAGING)
    implementation(Compose.COMPOSE_PAGING_RUNTIME)
    implementation(Compose.COMPOSE_PAGING_COMMON)
    testImplementation(Compose.COMPOSE_PAGING_COMMON)
    implementation(Compose.COMPOSE_PAGING_GUAVA)

    // Firebase
    implementation(platform(Firebase.FIREBASE_BOM))
    implementation(Firebase.FIREBASE_ANALYTICS_KTX)
    implementation(Firebase.MESSAGING)
    implementation(Firebase.DATABASE)
    implementation(Firebase.CORE)

    // Navigation
    implementation(Navigation.NAVIGATION_FRAGMENT_KTX)
    implementation(Navigation.NAVIGATION_FRAGMENT_UI_KTX)
}

kapt {
    correctErrorTypes = true
}
