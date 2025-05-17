package org.sopt.sopkathon.presentation.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.sopkathon.core.designsystem.theme.SOPKATHONTheme


@Composable
fun OnboardingRoute(
    modifier: Modifier = Modifier,
) {

}

@Composable
private fun OnboardingScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier.fillMaxSize().background(
            color = androidx.compose.ui.graphics.Color.White,
        )
    )
}

@Preview
@Composable
private fun OnboardingScreenPreview() {
    SOPKATHONTheme {
        OnboardingScreen()
    }
}
