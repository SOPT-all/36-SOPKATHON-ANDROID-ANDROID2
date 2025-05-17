package org.sopt.sopkathon.core.designsystem.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

val black = Color(0xFF121212)
val white = Color(0xFFFFFFFF)

// Gray scale
val gray100 = Color(0xFFF5F5F5)
val gray200 = Color(0xFFD9D9D9)
val gray300 = Color(0xFFCCCCCC)
val gray400 = Color(0xFFBABABA)
val gray500 = Color(0xFFA6A6A6)
val gray600 = Color(0xFF858585)
val gray700 = Color(0xFF646464)
val gray800 = Color(0xFF5C5C5C)
val gray900 = Color(0xFF212121)

// Green
val green1 = Color(0xFFA0C878)
val green2 = Color(0xFFDDEB9D)
val green3 = Color(0xFF95EF9C)

val background = Color(0xFFFFFDF6)
val beige = Color(0xFFFAF6E9)

val linearGray1 = Color(0xFFFFFFFF)
val linearGray2 = Color(0xFFC1C1C1)

val linearGreen1 = Color(0xFFEAF7AD)
val linearGreen2 = Color(0xFFFFFBEC)

@Stable
class SopkathonColors(
    black: Color,
    white: Color,
    gray100: Color,
    gray200: Color,
    gray300: Color,
    gray400: Color,
    gray500: Color,
    gray600: Color,
    gray700: Color,
    gray800: Color,
    gray900: Color,
    green1: Color,
    green2: Color,
    green3: Color,
    background: Color,
    beige: Color,
    linearGray1: Color,
    linearGray2: Color,
    linearGreen1: Color,
    linearGreen2: Color,
    isLight: Boolean,
) {
    var black by mutableStateOf(black)
        private set
    var white by mutableStateOf(white)
        private set
    var gray100 by mutableStateOf(gray100)
        private set
    var gray200 by mutableStateOf(gray200)
        private set
    var gray300 by mutableStateOf(gray300)
        private set
    var gray400 by mutableStateOf(gray400)
        private set
    var gray500 by mutableStateOf(gray500)
        private set
    var gray600 by mutableStateOf(gray600)
        private set
    var gray700 by mutableStateOf(gray700)
        private set
    var gray800 by mutableStateOf(gray800)
        private set
    var gray900 by mutableStateOf(gray900)
        private set
    var green1 by mutableStateOf(green1)
        private set
    var green2 by mutableStateOf(green2)
        private set
    var green3 by mutableStateOf(green3)
        private set
    var background by mutableStateOf(background)
        private set
    var beige by mutableStateOf(beige)
        private set
    var linearGray1 by mutableStateOf(linearGray1)
        private set
    var linearGray2 by mutableStateOf(linearGray2)
        private set
    var linearGreen1 by mutableStateOf(linearGreen1)
        private set
    var linearGreen2 by mutableStateOf(linearGreen2)
        private set
    var isLight by mutableStateOf(isLight)

    fun copy(): SopkathonColors = SopkathonColors(
        black,
        white,
        gray100,
        gray200,
        gray300,
        gray400,
        gray500,
        gray600,
        gray700,
        gray800,
        gray900,
        green1,
        green2,
        green3,
        background,
        beige,
        linearGray1,
        linearGray2,
        linearGreen1,
        linearGreen2,
        isLight,
    )

    fun update(other: SopkathonColors) {
        black = other.black
        white = other.white
        gray100 = other.gray100
        gray200 = other.gray200
        gray300 = other.gray300
        gray400 = other.gray400
        gray500 = other.gray500
        gray600 = other.gray600
        gray700 = other.gray700
        gray800 = other.gray800
        gray900 = other.gray900
        green1 = other.green1
        green2 = other.green2
        green3 = other.green3
        background = other.background
        beige = other.beige
        linearGray1 = other.linearGray1
        linearGray2 = other.linearGray2
        linearGreen1 = other.linearGreen1
        linearGreen2 = other.linearGreen2
        isLight = other.isLight
    }
}

fun SopkathonLightColors(
    Black: Color = black,
    White: Color = white,
    Gray100: Color = gray100,
    Gray200: Color = gray200,
    Gray300: Color = gray300,
    Gray400: Color = gray400,
    Gray500: Color = gray500,
    Gray600: Color = gray600,
    Gray700: Color = gray700,
    Gray800: Color = gray800,
    Gray900: Color = gray900,
    Green1: Color = green1,
    Green2: Color = green2,
    Green3: Color = green3,
    Background: Color = background,
    Beige: Color = beige,
    LinearGray1: Color = linearGray1,
    LinearGray2: Color = linearGray2,
    LinearGreen1: Color = linearGreen1,
    LinearGreen2: Color = linearGreen2,
) = SopkathonColors(
    Black,
    White,
    Gray100,
    Gray200,
    Gray300,
    Gray400,
    Gray500,
    Gray600,
    Gray700,
    Gray800,
    Gray900,
    Green1,
    Green2,
    Green3,
    Background,
    Beige,
    LinearGray1,
    LinearGray2,
    LinearGreen1,
    LinearGreen2,
    isLight = true,
)
