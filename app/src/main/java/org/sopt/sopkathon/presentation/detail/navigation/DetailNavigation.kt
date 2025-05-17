package org.sopt.sopkathon.presentation.detail.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.sopkathon.core.common.navigation.Route
import org.sopt.sopkathon.presentation.detail.DetailRoute

fun NavController.navigateToDetail(navOptions: NavOptions? = null) = navigate(Detail, navOptions)

fun NavGraphBuilder.detailGraph(
    modifier: Modifier = Modifier,
) {
    composable<Detail> {
        DetailRoute(
        )
    }
}

@Serializable
data object Detail : Route
