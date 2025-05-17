package org.sopt.sopkathon.presentation.splash.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.sopkathon.core.common.navigation.Route
import org.sopt.sopkathon.presentation.splash.SplashRoute

fun NavController.navigateToSplash(navOptions: NavOptions? = null) = navigate(Splash, navOptions)

fun NavGraphBuilder.splashGraph(
    modifier: Modifier = Modifier,
) {
    composable<Splash> {
        SplashRoute(
        )
    }
}

@Serializable
data object Splash : Route
