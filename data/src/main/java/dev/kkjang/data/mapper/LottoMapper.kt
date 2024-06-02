package dev.kkjang.data.mapper

import dev.kkjang.data.dto.LottoDto
import dev.kkjang.data.util.default
import dev.kkjang.domain.model.LottoVo

fun LottoDto.mapperToLottoVo(): LottoVo = LottoVo(
    totSellamnt = totSellamnt.default(),
    returnValue = returnValue.default(),
    drwNoDate = returnValue.default(),
    firstAccumamnt = firstAccumamnt.default(),
    drwtNo1 = drwtNo1.default(),
    drwtNo2 = drwtNo2.default(),
    drwtNo3 = drwtNo3.default(),
    drwtNo4 = drwtNo4.default(),
    drwtNo5 = drwtNo5.default(),
    drwtNo6 = drwtNo6.default(),
    bnusNo = bnusNo.default(),
    drwNo = drwNo.default(),
    firstPrzwnerCo = firstPrzwnerCo.default(),
)