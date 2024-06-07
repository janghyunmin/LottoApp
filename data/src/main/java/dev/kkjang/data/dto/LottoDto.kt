package dev.kkjang.data.dto

import com.google.gson.annotations.SerializedName

class LottoDto (
    @SerializedName("totSellamnt") var totSellamnt: Long?, // 총상금액
    @SerializedName("returnValue") var returnValue: String?, // 요청 결과
    @SerializedName("drwNoDate") var drwNoDate: String?, // 날짜
    @SerializedName("drwtNo6") var drwtNo6: Int?, // 로또 번호 6
    @SerializedName("drwtNo4") var drwtNo4: Int?, // 로또 번호 4
    @SerializedName("firstPrzwnerCo") var firstPrzwnerCo: Long?, // 1등 상금액
    @SerializedName("drwtNo5") var drwtNo5: Int?, // 로또 번호 5
    @SerializedName("bnusNo") var bnusNo: Int?, // 로또 보너스 번호
    @SerializedName("firstAccumamnt") var firstAccumamnt: Long?, //
    @SerializedName("drwNo") var drwNo: Int?, // 로또 회차
    @SerializedName("drwtNo2") var drwtNo2: Int?, // 로또 번호 2
    @SerializedName("drwtNo3") var drwtNo3: Int?, // 로또 번호 3
    @SerializedName("drwtNo1") var drwtNo1: Int? // 로또 번호 1
)

