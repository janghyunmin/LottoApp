package dev.kkjang.lotto

import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Firebase Init
        FirebaseApp.initializeApp(this@App)
    }

}
