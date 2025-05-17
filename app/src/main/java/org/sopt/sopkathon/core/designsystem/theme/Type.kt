package org.sopt.sopkathon.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import org.sopt.sopkathon.R.font.pretendard_bold
import org.sopt.sopkathon.R.font.pretendard_regular

val PretendardBold = FontFamily(Font(pretendard_bold))
val PretendardRegular = FontFamily(Font(pretendard_regular))

@Immutable
class SopkathonTypography(
    val titleB28: TextStyle,
    val titleR28: TextStyle,
    val titleB24: TextStyle,
    val titleR24: TextStyle,
    val bodyB20: TextStyle,
    val bodyR20: TextStyle,
    val bodyB18: TextStyle,
    val bodyR18: TextStyle,
    val bodyB16: TextStyle,
    val bodyR16: TextStyle,
    val bodyB14: TextStyle,
    val bodyR14: TextStyle,
    val captionB12: TextStyle,
    val captionR12: TextStyle,
    val captionB10: TextStyle,
    val captionR10: TextStyle,
)

private fun SopkathonTextStyle(
    fontFamily: FontFamily,
    fontSize: TextUnit,
    lineHeight: TextUnit = 1.28.em,
    letterSpacing: TextUnit = 0.02.em,
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing,
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None,
    ),
)

fun SopkathonTypography() = SopkathonTypography(
    titleB28 = SopkathonTextStyle(
        fontFamily = PretendardBold,
        fontSize = 28.sp,
        lineHeight = 39.2.sp,
        letterSpacing = 0.28.sp
    ),
    titleR28 = SopkathonTextStyle(
        fontFamily = PretendardRegular,
        fontSize = 28.sp,
        lineHeight = 39.2.sp,
        letterSpacing = 0.28.sp
    ),
    titleB24 = SopkathonTextStyle(
        fontFamily = PretendardBold,
        fontSize = 24.sp,
        lineHeight = 33.6.sp,
        letterSpacing = 0.24.sp
    ),
    titleR24 = SopkathonTextStyle(
        fontFamily = PretendardRegular,
        fontSize = 24.sp,
        lineHeight = 33.6.sp,
        letterSpacing = 0.24.sp
    ),
    bodyB20 = SopkathonTextStyle(
        fontFamily = PretendardBold,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.2.sp
    ),
    bodyR20 = SopkathonTextStyle(
        fontFamily = PretendardRegular,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.2.sp
    ),
    bodyB18 = SopkathonTextStyle(
        fontFamily = PretendardBold,
        fontSize = 18.sp,
        lineHeight = 25.2.sp,
        letterSpacing = 0.18.sp
    ),
    bodyR18 = SopkathonTextStyle(
        fontFamily = PretendardRegular,
        fontSize = 18.sp,
        lineHeight = 25.2.sp,
        letterSpacing = 0.18.sp
    ),
    bodyB16 = SopkathonTextStyle(
        fontFamily = PretendardBold,
        fontSize = 16.sp,
        lineHeight = 22.4.sp,
        letterSpacing = 0.16.sp
    ),
    bodyR16 = SopkathonTextStyle(
        fontFamily = PretendardRegular,
        fontSize = 16.sp,
        lineHeight = 22.4.sp,
        letterSpacing = 0.16.sp
    ),
    bodyB14 = SopkathonTextStyle(
        fontFamily = PretendardBold,
        fontSize = 14.sp,
        lineHeight = 19.6.sp,
        letterSpacing = 0.14.sp
    ),
    bodyR14 = SopkathonTextStyle(
        fontFamily = PretendardRegular,
        fontSize = 14.sp,
        lineHeight = 19.6.sp,
        letterSpacing = 0.14.sp
    ),
    captionB12 = SopkathonTextStyle(
        fontFamily = PretendardBold,
        fontSize = 12.sp,
        lineHeight = 16.8.sp,
        letterSpacing = 0.12.sp
    ),
    captionR12 = SopkathonTextStyle(
        fontFamily = PretendardRegular,
        fontSize = 12.sp,
        lineHeight = 16.8.sp,
        letterSpacing = 0.12.sp
    ),
    captionB10 = SopkathonTextStyle(
        fontFamily = PretendardBold,
        fontSize = 10.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.10.sp
    ),
    captionR10 = SopkathonTextStyle(
        fontFamily = PretendardRegular,
        fontSize = 10.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.10.sp
    ),
)
