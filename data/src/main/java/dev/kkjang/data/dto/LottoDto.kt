package dev.kkjang.data.dto

import com.google.gson.annotations.SerializedName

class LottoDto (
    @SerializedName("totSellamnt") var totSellamnt: Long?,
    @SerializedName("returnValue") var returnValue: String?,
    @SerializedName("drwNoDate") var drwNoDate: String?,
    @SerializedName("drwtNo6") var drwtNo6: Int?,
    @SerializedName("drwtNo4") var drwtNo4: Int?,
    @SerializedName("firstPrzwnerCo") var firstPrzwnerCo: Long?,
    @SerializedName("drwtNo5") var drwtNo5: Int?,
    @SerializedName("bnusNo") var bnusNo: Int?,
    @SerializedName("firstAccumamnt") var firstAccumamnt: Long?,
    @SerializedName("drwNo") var drwNo: Int?,
    @SerializedName("drwtNo2") var drwtNo2: Int?,
    @SerializedName("drwtNo3") var drwtNo3: Int?,
    @SerializedName("drwtNo1") var drwtNo1: Int?
)

