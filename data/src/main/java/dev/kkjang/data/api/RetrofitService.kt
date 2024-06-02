package dev.kkjang.data.api

import dev.kkjang.data.dto.LottoDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// Lotto Service
interface RetrofitService {
    // common.do?method=getLottoNumber&drwNo={drwNo}
    @GET("common.do")
    suspend fun getLottoNumbers(
        @Query("method") method: String,
        @Query("drwNo") drwNo: Int)
    : LottoDto

    companion object {
        const val BASE_URL = "https://dhlottery.co.kr/"
    }
}