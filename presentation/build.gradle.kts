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
    id("com.google.devtools.ksp")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class).configureEach {
        kotlinOptions {
            jvmTarget = "17"
            freeCompilerArgs = freeCompilerArgs + "-Xjvm-default=all"
        }
    }

    buildFeatures {
        compose = true
        viewBinding = true
        dataBinding = true
    }

    kotlinOptions {
        jvmTarget = "17"
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

    // Compose Options
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
}


kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(":data"))
    implementation(project(":domain"))

    // compose
    implementation(Compose.BOM)
    androidTestImplementation(Compose.BOM)
    implementation(Compose.MATERIAL)
    implementation(Compose.MATERIAL3)
    implementation(Compose.FOUNDATION)
    implementation(Compose.UI)
    implementation(Compose.PREVIEW)
    debugImplementation(Compose.UI_TOOLING)
    androidTestImplementation(Compose.UI_TEST)
    debugImplementation(Compose.TEST_MANIFEST)
    implementation(Compose.ICONS_CORE)
    implementation(Compose.ICONS_EXTENDED)
    implementation(Compose.WINDOW)
    implementation(Compose.ACTIVITY)
    implementation(Compose.VIEWMODEL)
    implementation(Compose.LIVEDATA)
    implementation(Compose.RXJAVA2)


    implementation(Compose.COMPOSE_LOTTIE)
    implementation(Compose.COMPOSE_COIL)
    implementation(Compose.COMPOSE_COIL_GIF)
    implementation(Compose.COMPOSE_GLIDE)
    implementation(Compose.COMPOSE_PAGING)
    implementation(Compose.COMPOSE_PAGING_RUNTIME)
    implementation(Compose.COMPOSE_PAGING_COMMON)
    testImplementation(Compose.COMPOSE_PAGING_COMMON)
    implementation(Compose.COMPOSE_PAGING_GUAVA)

    implementation(Google.MATERIAL)
    implementation(AndroidX.CONSTRAINT_LAYOUT)
    implementation(AndroidX.APPCOMPAT)

    // (Required) Writing and executing Unit Tests on the JUnit Platform
    testImplementation(Test.JUNIT_5_API)
    testRuntimeOnly(Test.JUNIT_5_ENGINE)

    // (Optional) If you need "Parameterized Tests"
    testImplementation(Test.JUNIT_5_PARAMS)

    // (Optional) If you also have JUnit 4-based tests
    testImplementation(Test.JUNIT_4)
    testRuntimeOnly(Test.JUNIT_5_VINTAGE)

    testImplementation(Test.MOCKK)

    testImplementation(Test.TEST_KOTLIN)

    androidTestImplementation(Test.ESPRESSO_CORE)

    implementation(Kotlin.COROUTINES_CORE)
    implementation(Kotlin.COROUTINES)

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

    implementation(Navigation.NAVIGATION_FRAGMENT_KTX)
    implementation(Navigation.NAVIGATION_FRAGMENT_UI_KTX)

    implementation(Google.MATERIAL)
    implementation(Google.GSON)
    implementation(Google.PLAY)
    implementation(Google.PLAY_KTX)
//    implementation(Google.APP_UPDATE)
//    implementation(Google.APP_UPDATE_KTX)

    implementation(RxJava2.ANDROID)
    implementation(RxJava2.BINDING)

    implementation(platform(Firebase.FIREBASE_BOM))
    implementation(Firebase.MESSAGING)
    implementation(Firebase.DATABASE)
    implementation(Firebase.CORE)
//    implementation(Firebase.FIREBASE_ANALYTICS)
    implementation(Firebase.FIREBASE_ANALYTICS_KTX)

    implementation(Compose.COMPOSE_COIL)
    implementation(Compose.COMPOSE_COIL_GIF)
    implementation(Dagger.HILT)
    kapt(Dagger.COMPILER)

    implementation(OkHttp.OKHTTP_3)
    implementation(OkHttp.OKHTTP_3_URLCONNECTION)
    implementation(OkHttp.OKHTTP_3_INTERCEPTOR)

    implementation(Retrofit.RETROFIT_2)
    implementation(Retrofit.RETROFIT_2_GSON)
    implementation(Retrofit.RETROFIT_2_SCALARS)
    implementation(Retrofit.RETROFIT_2_SIMPLEXML)
    implementation(Retrofit.CONVERTER_JAXB)
    implementation(Lottie.LOTTIE)

    implementation(Jetpack.PAGING)



}

