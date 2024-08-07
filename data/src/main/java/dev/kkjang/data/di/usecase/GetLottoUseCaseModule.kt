package dev.kkjang.data.di.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dev.kkjang.domain.CoroutineDispatcherProvider
import dev.kkjang.domain.repository.LottoRepository
import dev.kkjang.domain.usecase.GetLottoUseCase

@Module
@InstallIn(ViewModelComponent::class)
internal object GetLottoUseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideGetLottoUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        getLottoRepository: LottoRepository
    ) = GetLottoUseCase(
        coroutineDispatcherProvider = coroutineDispatcherProvider,
        repository = getLottoRepository
    )
}