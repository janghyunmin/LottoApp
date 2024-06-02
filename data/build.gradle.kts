plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("com.google.devtools.ksp")
    id ("com.google.dagger.hilt.android")
    id ("kotlin-kapt")
}

android {
    namespace = "dev.kkjang.lotto.data"

    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles ("consumer-rules.pro")
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
        jvmTarget = "17"
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementation ("androidx.core:core-ktx:1.13.1")
    implementation ("androidx.appcompat:appcompat:1.7.0")
    implementation ("com.google.android.material:material:1.12.0")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

    implementation(project(":domain"))

    implementation(AndroidX.CORE)
    implementation(AndroidX.WORK)
    implementation(AndroidX.LIFECYCLE_VIEWMODEL)
    implementation(AndroidX.LIFECYCLE_LIVEDATA)
    implementation(AndroidX.CORE)

    implementation(OkHttp.OKHTTP_3)
    implementation(OkHttp.OKHTTP_3_URLCONNECTION)
    implementation(OkHttp.OKHTTP_3_INTERCEPTOR)

    implementation(Retrofit.RETROFIT_2_ADAPTER)
    implementation(Retrofit.RETROFIT_2_GSON)

    implementation(Kotlin.COROUTINES_CORE)
    implementation(Kotlin.COROUTINES)

//    implementation(Dagger.HILT)
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    implementation(Room.RUNTIME)

    implementation(SQLITE.SQLITE)
    implementation(SQLITE.SQLITE_CIPHER)

    implementation(Google.GSON)

    implementation(Jetpack.PAGING)

    coreLibraryDesugaring(Android.DESUGARING)

    implementation(DataStore.DATA_STORE)
    implementation(DataStore.DATA_STORE_CORE)
}