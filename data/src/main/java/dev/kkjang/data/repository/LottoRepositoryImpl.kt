package dev.kkjang.data.repository

import dev.kkjang.data.mapper.mapperToLottoVo
import dev.kkjang.data.repository.local.LottoLocalDataSource
import dev.kkjang.data.repository.remote.LottoRemoteDataSource
import dev.kkjang.domain.model.LottoVo
import dev.kkjang.domain.repository.LottoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LottoRepositoryImpl(private val lottoLocalDataSource: LottoLocalDataSource,
    private val lottoRemoteDataSource: LottoRemoteDataSource) : LottoRepository {
    override fun getLotto(method: String, drwNo: Int): Flow<LottoVo> = flow {
        emit(lottoRemoteDataSource.getLotto(method = method, drwNo = drwNo).mapperToLottoVo())
    }
}