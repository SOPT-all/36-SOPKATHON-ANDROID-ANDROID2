package org.sopt.sopkathon.presentation.guide.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.sopkathon.core.common.navigation.Route
import org.sopt.sopkathon.presentation.guide.GuideRoute

fun NavController.navigateToGuide(navOptions: NavOptions? = null) = navigate(Guide, navOptions)

fun NavGraphBuilder.guideGraph(
    modifier: Modifier = Modifier,
) {
    composable<Guide> {
        GuideRoute(
        )
    }
}

@Serializable
data object Guide : Route
