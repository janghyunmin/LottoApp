package dev.kkjang.domain.usecase

import dev.kkjang.domain.repository.LottoRepository

class GetLottoUseCase(private val repository: LottoRepository) {
    operator fun invoke(
        method: String,
        drwNo: Int
    ) = repository.getLotto(method = method, drwNo = drwNo)
}