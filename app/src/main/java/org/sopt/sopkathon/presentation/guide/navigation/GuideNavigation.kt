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
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    composable<Guide> {
        GuideRoute(
            onBackClick = {
                onBackClick()
            },
            modifier = modifier
        )
    }
}

@Serializable
data object Guide : Route
