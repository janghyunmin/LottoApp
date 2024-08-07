package dev.kkjang.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.kkjang.data.module.display.DisplayManager
import dev.kkjang.data.module.network.NetworkConnection
import dev.kkjang.data.module.provider.ResourcesProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideDisplayManager() : DisplayManager = DisplayManager()

    @Singleton
    @Provides
    fun provideNetworkConnection(@ApplicationContext context: Context): NetworkConnection = NetworkConnection(context)

    @Singleton
    @Provides
    fun provideResourcesProvider(@ApplicationContext context: Context): ResourcesProvider = ResourcesProvider(context)

    @Provides
    fun provideApplicationContext(@ApplicationContext context: Context): Context {
        return context
    }

}