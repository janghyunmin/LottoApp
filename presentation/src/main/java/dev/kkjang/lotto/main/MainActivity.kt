package dev.kkjang.lotto.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import dagger.hilt.android.AndroidEntryPoint
import dev.kkjang.lotto.R
import dev.kkjang.lotto.ui.theme.LottoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val vm: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            LottoTheme {

                val backgroundColor = MaterialTheme.colors.background.toArgb()

                // Set the status bar color
                SideEffect {
                    val window = window
                    WindowCompat.setDecorFitsSystemWindows(window, false)
                    WindowInsetsControllerCompat(window, window.decorView).apply {
                        isAppearanceLightStatusBars = true // or false depending on your theme
                    }
                    window.statusBarColor = backgroundColor
                }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    vm.getLotto("getLottoNumber", 1000)

                    vm.getFbLotto("data")
                    Log.d("fbLotto : ", "${vm.getFbLotto("data")}")
                    val fbLottoState = vm.fbResponse.collectAsState().value
                    getFbLottoState(fbState = fbLottoState)

                    Log.d("getLotto : ", "${vm.getLotto("getLottoNumber", 1000)}")
                    val lottoState = vm.lottoResponse.collectAsState().value
                    getLottoState(lottoState = lottoState)


                    CombinedScreen()
                }
            }
        }
    }
}

@Composable
fun getFbLottoState(fbState: MainViewModel.GetFbLottoState) {
    when (fbState) {
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
fun getLottoState(lottoState: MainViewModel.GetLottoState) {
    when (lottoState) {
        is MainViewModel.GetLottoState.Init -> {
            Log.i("Init", "Init")
        }

        is MainViewModel.GetLottoState.IsLoading -> {
            Log.v("isLoading", "isLoading")
        }

        is MainViewModel.GetLottoState.Success -> {
            Log.v("Success ", "${lottoState.lottoResponse}")
        }

        is MainViewModel.GetLottoState.Failure -> {
            Log.e("Fail ", "${lottoState.message} ")
        }
    }
}


// TopScreen PreView
@Preview
@Composable
fun TopScreen() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = stringResource(id = R.string.main_title_week_number),
            style = TextStyle(
                fontSize = 22.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(id = R.color.black),
                textAlign = TextAlign.Start
            ),
            modifier = Modifier
                .wrapContentHeight()
                .align(Alignment.CenterVertically)
                .padding(start = 16.dp, top = 44.dp, bottom = 24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Shadow() {
    Column(
        modifier = Modifier
            .width(120.dp)
            .height(120.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(8.dp)
                )
                .background(Color.White)
                .size(110.dp),
            contentAlignment = Alignment.Center
        ) {

            Text(text = "Hello World")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LottoScreen() {
    val numbers = listOf("1", "2", "3", "4", "5", "6")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 16.dp, end = 16.dp, bottom = 10.dp)
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(16.dp)
            )
         
            .clip(
                RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp,
                    bottomStart = 16.dp,
                    bottomEnd = 16.dp
                )
            )
            .background(colorResource(id = R.color.bg_lotto_content_layout))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 13.dp, start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = "1023회차",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.white),
                    textAlign = TextAlign.Start
                ),
                modifier = Modifier.padding(bottom = 8.dp) // 두 텍스트 사이에 간격을 주기 위해 padding 추가
            )

            Text(
                modifier = Modifier.padding(top = 2.dp),
                text = stringResource(id = R.string.main_title_celebration),
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.W400,
                    color = colorResource(id = R.color.white),
                    textAlign = TextAlign.Start
                )
            )

            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(top = 25.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    numbers.forEach { number ->
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(28.dp)
                                .clip(CircleShape)
                                .background(Color.DarkGray)
                        ) {
                            Text(
                                text = number,
                                color = Color.White,
                                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            )
                        }
                    }
                    Image(
                        painter = painterResource(R.drawable.ic_x_24_plus_icon),
                        contentDescription = null, // 필수 param
                        modifier = Modifier.size(28.dp)
                    )
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(Color.Red)
                    ) {
                        Text(
                            text = "7",
                            color = Color.White,
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        )
                    }
                }
            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, bottom = 15.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .height(IntrinsicSize.Min),
                        text = stringResource(id = R.string.main_title_first_title),
                        color = Color.White,
                        style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                    )

                    // 1등 당첨자 수
                    Text(
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .height(IntrinsicSize.Min),
                        text = "13",
                        color = colorResource(id = R.color.lotto_first_place), // 원하는 색상으로 설정
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                    )

                    // "명" 텍스트
                    Text(
                        modifier = Modifier.padding(end = 5.dp),
                        text = "명",
                        color = Color.White, // 흰색으로 설정
                        style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                    )

                    // 1등 당첨 금액
                    Text(
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .height(IntrinsicSize.Min),
                        text = "2,123,456,234",
                        color = colorResource(id = R.color.lotto_first_place), // 원하는 색상으로 설정
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                    )

                    // "원" 텍스트
                    Text(
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .height(IntrinsicSize.Min),
                        text = "원",
                        color = Color.White, // 흰색으로 설정
                        style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                    )

                    // "자동" 텍스트
                    Text(
                        modifier = Modifier.padding(end = 5.dp),
                        text = "자동",
                        color = Color.White, // 흰색으로 설정
                        style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                    )

                    // 자동 , 수동 , 반자동 수
                    Text(
                        modifier = Modifier.padding(end = 5.dp),
                        text = "9",
                        color = colorResource(id = R.color.lotto_first_place), // 원하는 색상으로 설정
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                    )

                    // "자동" 텍스트
                    Text(
                        modifier = Modifier.padding(end = 5.dp),
                        text = "수동",
                        color = Color.White, // 흰색으로 설정
                        style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                    )

                    // 자동 , 수동 , 반자동 수
                    Text(
                        text = "2",
                        color = colorResource(id = R.color.lotto_first_place), // 원하는 색상으로 설정
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ContentScreen() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(modifier = Modifier.align(Alignment.CenterVertically)) {
            /** QR 확인하기 **/
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
                    .background(colorResource(id = R.color.bg_item_layout))

            ) {
                Row(
                    modifier = Modifier.padding(start = 14.dp, top = 14.dp, bottom = 14.dp),
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_x24_qr_icon),
                        contentDescription = null, // 필수 param
                        modifier = Modifier
                            .wrapContentHeight()
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        modifier = Modifier
                            .wrapContentHeight()
                            .padding(start = 20.dp)
                            .alignByBaseline(),
                        text = "QR 확인하기",
                        color = colorResource(id = R.color.black), // 원하는 색상으로 설정
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.white),
                            textAlign = TextAlign.Start
                        ),
                    )
                }
            }

            /** 주변 판매점 확인하기 **/
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
                    .background(colorResource(id = R.color.bg_item_layout))

            ) {
                Row(
                    modifier = Modifier.padding(start = 14.dp, top = 14.dp, bottom = 14.dp),
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_x24_pin_icon),
                        contentDescription = null, // 필수 param
                        modifier = Modifier
                            .wrapContentHeight()
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        modifier = Modifier
                            .wrapContentHeight()
                            .padding(start = 20.dp)
                            .alignByBaseline(),
                        text = "주변 판매점 확인하기",
                        color = colorResource(id = R.color.black), // 원하는 색상으로 설정
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.white),
                            textAlign = TextAlign.Start
                        ),
                    )
                }
            }


            /** 분석하기 **/
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
                    .background(colorResource(id = R.color.bg_item_layout))

            ) {
                Row(
                    modifier = Modifier.padding(start = 14.dp, top = 14.dp, bottom = 14.dp),
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_x24_analysing_icon),
                        contentDescription = null, // 필수 param
                        modifier = Modifier
                            .wrapContentHeight()
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        modifier = Modifier
                            .wrapContentHeight()
                            .padding(start = 20.dp)
                            .alignByBaseline(),
                        text = "분석하기",
                        color = colorResource(id = R.color.black), // 원하는 색상으로 설정
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.white),
                            textAlign = TextAlign.Start
                        ),
                    )
                }
            }


            /** 내가 만든 번호 **/
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
                    .background(colorResource(id = R.color.bg_item_layout))

            ) {
                Row(
                    modifier = Modifier.padding(start = 14.dp, top = 14.dp, bottom = 14.dp),
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_x24_star_icon),
                        contentDescription = null, // 필수 param
                        modifier = Modifier
                            .wrapContentHeight()
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        modifier = Modifier
                            .wrapContentHeight()
                            .padding(start = 20.dp)
                            .alignByBaseline(),
                        text = "내가 만든 번호 확인하기",
                        color = colorResource(id = R.color.black), // 원하는 색상으로 설정
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.white),
                            textAlign = TextAlign.Start
                        ),
                    )
                }
            }


            Spacer(modifier = Modifier.padding(top = 18.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .padding(start = 16.dp, end = 16.dp)
                    .background(color = colorResource(id = R.color.divider_color))
            )



            /** 나의 번호 만들기 **/
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
            ) {
                Text(
                    modifier = Modifier
                        .wrapContentHeight(),
                    text = "나의 번호 만들기",
                    color = colorResource(id = R.color.black), // 원하는 색상으로 설정
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = colorResource(id = R.color.white),
                        textAlign = TextAlign.Start
                    ),
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp)
                        .padding(top = 12.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 16.dp,
                                topEnd = 16.dp,
                                bottomStart = 16.dp,
                                bottomEnd = 16.dp
                            )
                        )
                        .background(colorResource(id = R.color.bg_item_layout))
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .padding(top = 12.dp, start = 12.dp, bottom = 12.dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = 16.dp,
                                    topEnd = 16.dp,
                                    bottomStart = 16.dp,
                                    bottomEnd = 16.dp
                                )
                            )
                            .background(Color.White)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_x48_auto_icon), // 이미지 리소스 사용
                                contentDescription = "Auto",
                                modifier = Modifier.size(40.dp) // 이미지 크기 조정
                            )
                            Spacer(modifier = Modifier.height(8.dp)) // 이미지와 텍스트 사이에 간격 추가
                            Text(
                                text = "자동",
                                color = Color.Black, // 텍스트 색상 설정
                                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                                textAlign = TextAlign.Center // 텍스트 중앙 정렬
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .padding(top = 12.dp, end = 12.dp, bottom = 12.dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = 16.dp,
                                    topEnd = 16.dp,
                                    bottomStart = 16.dp,
                                    bottomEnd = 16.dp
                                )
                            )
                            .background(Color.White)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_x48_choice_icon), // 이미지 리소스 사용
                                contentDescription = "Auto",
                                modifier = Modifier.size(40.dp) // 이미지 크기 조정
                            )
                            Spacer(modifier = Modifier.height(8.dp)) // 이미지와 텍스트 사이에 간격 추가
                            Text(
                                text = "수동",
                                color = Color.Black, // 텍스트 색상 설정
                                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                                textAlign = TextAlign.Center // 텍스트 중앙 정렬
                            )
                        }
                    }
                }
            }



        }
    }
}

@Preview
@Composable
fun CombinedScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopScreen()
        LottoScreen()
        ContentScreen()
    }
}