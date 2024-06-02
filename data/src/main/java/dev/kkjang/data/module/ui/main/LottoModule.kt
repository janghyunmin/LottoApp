package dev.kkjang.data.module.ui.main

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.kkjang.data.api.RetrofitService
import dev.kkjang.data.module.AppModule
import dev.kkjang.data.module.NetModule
import dev.kkjang.data.repository.LottoRepositoryImpl
import dev.kkjang.data.repository.local.LottoLocalDataSource
import dev.kkjang.data.repository.local.LottoLocalDataSourceImpl
import dev.kkjang.data.repository.remote.LottoRemoteDataSource
import dev.kkjang.data.repository.remote.LottoRemoteDataSourceImpl
import dev.kkjang.domain.repository.LottoRepository
import dev.kkjang.domain.usecase.GetLottoUseCase
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetModule::class, AppModule::class])
@InstallIn(SingletonComponent::class)
object LottoModule {
    @Singleton
    @Provides
    fun provideRetrofitService(retrofit: Retrofit): RetrofitService =
        retrofit.create(RetrofitService::class.java)

    @Singleton
    @Provides
    fun provideLottoLocalDataSource(): LottoLocalDataSource = LottoLocalDataSourceImpl()

    @Singleton
    @Provides
    fun provideLottoRemoteDataSource(retrofitService: RetrofitService): LottoRemoteDataSource =
        LottoRemoteDataSourceImpl(retrofitService = retrofitService)

    @Singleton
    @Provides
    fun provideLottoRepository(
        lottoLocalDataSource: LottoLocalDataSource,
        lottoRemoteDataSource: LottoRemoteDataSource
    ): LottoRepository = LottoRepositoryImpl(lottoLocalDataSource, lottoRemoteDataSource)

    @Singleton
    @Provides
    fun provideGetLottoUseCase(lottoRepository: LottoRepository): GetLottoUseCase =
        GetLottoUseCase(repository = lottoRepository)

}