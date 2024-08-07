package dev.kkjang.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.kkjang.data.CoroutineDispatcherProviderImpl
import dev.kkjang.domain.CoroutineDispatcherProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object SystemModule {
    @Provides
    @Singleton
    fun provideCoroutineDispathcerProvider(): CoroutineDispatcherProvider = CoroutineDispatcherProviderImpl()
}