package dev.kkjang.lotto.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.kkjang.lotto.R

// Font 설정
val notosanKR = FontFamily(
    Font(R.font.pretendard_thin, FontWeight.W100, FontStyle.Normal),
    Font(R.font.pretendard_light, FontWeight.W200, FontStyle.Normal),
    Font(R.font.pretendard_regular, FontWeight.W400, FontStyle.Normal),
    Font(R.font.pretendard_medium, FontWeight.W500, FontStyle.Normal),
    Font(R.font.pretendard_semibold, FontWeight.W600, FontStyle.Normal),
    Font(R.font.pretendard_bold, FontWeight.W700, FontStyle.Normal),
    Font(R.font.pretendard_extrabold, FontWeight.W800, FontStyle.Normal),
    Font(R.font.pretendard_black, FontWeight.W900, FontStyle.Normal),
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = notosanKR,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),

    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
//     Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)