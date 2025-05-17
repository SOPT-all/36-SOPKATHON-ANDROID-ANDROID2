package org.sopt.sopkathon.presentation.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import org.sopt.sopkathon.core.designsystem.theme.SopkathonTheme
import org.sopt.sopkathon.presentation.detail.navigation.detailGraph
import org.sopt.sopkathon.presentation.guide.navigation.guideGraph
import org.sopt.sopkathon.presentation.guide.navigation.navigateToGuide
import org.sopt.sopkathon.presentation.map.navigation.mapButtonGraph
import org.sopt.sopkathon.presentation.map.navigation.mapGraph
import org.sopt.sopkathon.presentation.map.navigation.navigateToMap
import org.sopt.sopkathon.presentation.map.navigation.navigateToMapButton
import org.sopt.sopkathon.presentation.purchase.navigation.navigateToPurchase
import org.sopt.sopkathon.presentation.purchase.navigation.purchaseGraph
import org.sopt.sopkathon.presentation.splash.navigation.splashGraph

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator(),
) {
    Scaffold(
        containerColor = SopkathonTheme.colors.white,
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Box {
            MainNavHost(
                navigator = navigator,
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}

@Composable
private fun MainNavHost(
    navigator: MainNavigator,
    modifier: Modifier = Modifier,
) {
    NavHost(
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
        navController = navigator.navController,
        startDestination = navigator.startDestination,
    ) {
        splashGraph(
            modifier = modifier,
            onNavigateToOnboarding = {
                val navOptions = navOptions {
                    navigator.navController.currentDestination?.route?.let {
                        popUpTo(it) {
                            inclusive = true
                        }
                    }
                }
                navigator.navController.navigateToMap(navOptions)
            },
        )

        mapButtonGraph(
            modifier = modifier,
            guideButtonClick = {
                navigator.navController.navigateToGuide()
            },
            purchaseButtonClick = {
                navigator.navController.navigateToPurchase()
            }
        )

        mapGraph(
            modifier = modifier,
            onClickButton = {
                navigator.navController.navigateToMapButton()
            }
        )

        guideGraph(
            modifier = modifier,
            onBackClick = {
                navigator.navController.popBackStack()
            }
        )

        purchaseGraph(
            navigateToUp = navigator.navController::navigateUp,
            modifier = modifier,
        )

        detailGraph(
            modifier = modifier,
        )
    }
}
