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
import org.sopt.sopkathon.R.font.pretendard_medium
import org.sopt.sopkathon.R.font.pretendard_semibold

// TODO: Temporary Typography
val PretendardBold = FontFamily(Font(pretendard_bold))
val PretendardSemiBold = FontFamily(Font(pretendard_semibold))
val PretendardMedium = FontFamily(Font(pretendard_medium))

@Immutable
class SopkathonTypography(
    val display56b: TextStyle,
    val title22sb: TextStyle,
    val title22m: TextStyle,
    val body16m: TextStyle,
    val body14m: TextStyle,
    val label14m: TextStyle,
    val label12m: TextStyle,
    val label10b: TextStyle,
    val label10m: TextStyle,
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
    display56b = SopkathonTextStyle(
        fontFamily = PretendardBold,
        fontSize = 56.sp,
    ),
    title22sb = SopkathonTextStyle(
        fontFamily = PretendardSemiBold,
        fontSize = 22.sp,
    ),
    title22m = SopkathonTextStyle(
        fontFamily = PretendardMedium,
        fontSize = 22.sp,
    ),
    body16m = SopkathonTextStyle(
        fontFamily = PretendardMedium,
        fontSize = 16.sp,
    ),
    body14m = SopkathonTextStyle(
        fontFamily = PretendardMedium,
        fontSize = 14.sp,
    ),
    label14m = SopkathonTextStyle(
        fontFamily = PretendardMedium,
        fontSize = 14.sp,
    ),
    label12m = SopkathonTextStyle(
        fontFamily = PretendardMedium,
        fontSize = 12.sp,
    ),
    label10b = SopkathonTextStyle(
        fontFamily = PretendardSemiBold,
        fontSize = 10.sp,
    ),
    label10m = SopkathonTextStyle(
        fontFamily = PretendardMedium,
        fontSize = 10.sp,
    ),
)
