package org.sopt.sopkathon.presentation.map.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.sopkathon.core.common.navigation.Route
import org.sopt.sopkathon.presentation.map.MapButtonRoute

fun NavController.navigateToMapButton(navOptions: NavOptions? = null) = navigate(MapButton, navOptions)

fun NavGraphBuilder.mapButtonGraph(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit,
    guideButtonClick: () -> Unit,
    purchaseButtonClick: (Long?) -> Unit,
) {
    composable<MapButton> {
        MapButtonRoute(
            modifier = modifier,
            navigateUp = navigateUp,
            guideButtonClick = guideButtonClick,
            purchaseButtonClick = purchaseButtonClick
        )
    }
}

@Serializable
data object MapButton : Route