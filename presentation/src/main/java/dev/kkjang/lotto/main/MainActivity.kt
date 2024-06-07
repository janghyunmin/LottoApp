package dev.kkjang.lotto.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint
import dev.kkjang.lotto.R
import dev.kkjang.lotto.ui.theme.LottoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val vm : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    vm.getLotto("getLottoNumber",1000)

                    vm.getFbLotto("data")
                    Log.d("fbLotto : ", "${vm.getFbLotto("data")}")
                    val fbLottoState = vm.fbResponse.collectAsState().value
                    getFbLottoState(fbState = fbLottoState)

                    Log.d("getLotto : ","${vm.getLotto("getLottoNumber",1000)}")
                    val lottoState = vm.lottoResponse.collectAsState().value
                    getLottoState(lottoState = lottoState)


                    TopScreen()
                }
            }
        }
    }
}

@Composable
fun getFbLottoState(fbState: MainViewModel.GetFbLottoState) {
    when(fbState) {
        is MainViewModel.GetFbLottoState.Init -> {}
        is MainViewModel.GetFbLottoState.IsLoading -> {}
        is MainViewModel.GetFbLottoState.Success -> {
            fbState.fbResponse.forEach {
                Log.d("getFirebaseBase Data : ", it.toString())
            }
        }
        is MainViewModel.GetFbLottoState.Failure -> {}
    }
}
@Composable
fun getLottoState(lottoState : MainViewModel.GetLottoState) {
    when(lottoState) {
        is MainViewModel.GetLottoState.Init -> { Log.i("Init","Init") }
        is MainViewModel.GetLottoState.IsLoading -> { Log.v("isLoading","isLoading") }
        is MainViewModel.GetLottoState.Success -> { Log.v("Success ","${lottoState.lottoResponse}")}
        is MainViewModel.GetLottoState.Failure -> { Log.e("Fail ","${lottoState.message} ")}
    }
}


// TopScreen PreView
@Preview
@Composable
fun TopScreen() {
    Row(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = stringResource(id = R.string.main_title_week_number),
            style = TextStyle(
                fontSize = 26.sp,
                lineHeight = 34.sp,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.black),
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 16.dp, top = 24.dp, bottom = 24.dp)
        )
    }
}