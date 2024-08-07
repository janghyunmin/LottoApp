package dev.kkjang.domain.usecase

import dev.kkjang.domain.CoroutineDispatcherProvider
import dev.kkjang.domain.IOUseCase
import dev.kkjang.domain.model.LottoVo
import dev.kkjang.domain.repository.LottoRepository

class GetLottoUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val repository: LottoRepository) : IOUseCase<GetLottoUseCase.Params, LottoVo>(coroutineDispatcherProvider = coroutineDispatcherProvider) {
    override suspend fun execute(params: Params): LottoVo {
        return repository.getLotto(method = params.method, drwNo = params.drwNo)
    }

    data class Params(
        val method: String,
        val drwNo: Int
    )
}