package org.sopt.sopkathon.presentation.map.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.sopkathon.core.common.navigation.Route
import org.sopt.sopkathon.presentation.map.MapRoute

fun NavController.navigateToMap(navOptions: NavOptions? = null) = navigate(Map, navOptions)

fun NavGraphBuilder.mapGraph(
    modifier: Modifier = Modifier,
) {
    composable<Map> {
        MapRoute(
            modifier = modifier,
        )
    }
}

@Serializable
data object Map : Route


