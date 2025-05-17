package org.sopt.sopkathon.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import org.sopt.sopkathon.R.drawable.ic_splash_character
import org.sopt.sopkathon.R.drawable.ic_splash_logo
import org.sopt.sopkathon.core.designsystem.theme.SOPKATHONTheme
import org.sopt.sopkathon.core.designsystem.theme.SopkathonTheme

@Composable
fun SplashRoute(
    onNavigateToOnboarding: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val systemUiController = rememberSystemUiController()
    val splashColor = SopkathonTheme.colors.background

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = splashColor,
            darkIcons = false,
        )
    }

    LaunchedEffect(Unit) {
        delay(2500)
        onNavigateToOnboarding()
    }

    SplashScreen(
        modifier = modifier,
    )
}

@Composable
private fun SplashScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            imageVector = ImageVector.vectorResource(ic_splash_character),
            contentDescription = null,
        )

        Image(
            imageVector = ImageVector.vectorResource(ic_splash_logo),
            contentDescription = null,
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "마음을 잇다, 지역을 담다",
            style = SopkathonTheme.typography.captionR12.copy(
                color = SopkathonTheme.colors.green1,
            ),
        )
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SOPKATHONTheme {
        SplashScreen()
    }
}
