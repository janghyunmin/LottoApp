package dev.kkjang.data.repository.remote

import dev.kkjang.data.api.RetrofitService
import dev.kkjang.data.dto.LottoDto

class LottoRemoteDataSourceImpl(private val retrofitService: RetrofitService): LottoRemoteDataSource {
    override suspend fun getLotto(method: String, drwNo: Int): LottoDto =
        retrofitService.getLottoNumbers(method = method,drwNo = drwNo)
}