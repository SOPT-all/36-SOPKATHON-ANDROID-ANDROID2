package org.sopt.sopkathon.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalSopkathonColors = staticCompositionLocalOf<SopkathonColors> {
    error("No SopkathonColors provided")
}

private val LocalSopkathonTypography = staticCompositionLocalOf<SopkathonTypography> {
    error("No SopkathonTypography provided")
}

object SopkathonTheme {
    val colors: SopkathonColors
        @Composable
        @ReadOnlyComposable
        get() = LocalSopkathonColors.current
    val typography: SopkathonTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalSopkathonTypography.current
}

@Composable
fun ProvideSopkathonColorsAndTypography(
    colors: SopkathonColors,
    typography: SopkathonTypography,
    content: @Composable () -> Unit,
) {
    val provideColors = remember { colors.copy() }.apply { update(colors) }

    CompositionLocalProvider(
        LocalSopkathonColors provides provideColors,
        LocalSopkathonTypography provides typography,
        content = content,
    )
}


@Composable
fun SOPKATHONTheme(
    content: @Composable () -> Unit,
) {
    val colors = SopkathonLightColors()
    val typography = SopkathonTypography()

    ProvideSopkathonColorsAndTypography(
        colors = colors,
        typography = typography,
    ) {
        MaterialTheme(
            content = content,
        )
    }
}