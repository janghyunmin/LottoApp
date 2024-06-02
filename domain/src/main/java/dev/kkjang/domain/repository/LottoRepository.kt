package dev.kkjang.domain.repository

import dev.kkjang.domain.model.LottoVo
import kotlinx.coroutines.flow.Flow

interface LottoRepository {
    fun getLotto(
        method: String,
        drwNo: Int
    ) : Flow<LottoVo>
}