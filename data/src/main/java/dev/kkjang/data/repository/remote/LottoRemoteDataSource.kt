package dev.kkjang.data.repository.remote

import dev.kkjang.data.dto.LottoDto

interface LottoRemoteDataSource {

    // 로또 번호 조회
    suspend fun getLotto(method: String, drwNo: Int) : LottoDto

}