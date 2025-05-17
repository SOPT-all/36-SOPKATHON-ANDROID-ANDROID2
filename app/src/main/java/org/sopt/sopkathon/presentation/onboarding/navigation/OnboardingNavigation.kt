package org.sopt.sopkathon.presentation.onboarding.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.sopkathon.core.common.navigation.Route
import org.sopt.sopkathon.presentation.onboarding.OnboardingRoute

fun NavController.navigateToOnboarding(navOptions: NavOptions? = null) = navigate(Onboarding, navOptions)

fun NavGraphBuilder.onboardingGraph(
    modifier: Modifier = Modifier,
) {
    composable<Onboarding> {
        OnboardingRoute(
            modifier = modifier,
        )
    }
}

@Serializable
data object Onboarding : Route
