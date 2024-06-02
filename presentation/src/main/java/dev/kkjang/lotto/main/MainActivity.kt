package dev.kkjang.lotto.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
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

                    Log.d("Loggo : ","${vm.getLotto("getLottoNumber",1000)}")
                    val lottoState = vm.lottoResponse.collectAsState().value
                    getLottoState(lottoState = lottoState)


                    Greeting("Android")
                }
            }
        }
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

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LottoTheme {
        Greeting("Android")
    }
}