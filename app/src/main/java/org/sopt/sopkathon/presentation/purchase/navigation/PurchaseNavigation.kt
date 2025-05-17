package org.sopt.sopkathon.presentation.purchase.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.sopkathon.core.common.navigation.Route
import org.sopt.sopkathon.presentation.purchase.PurchaseRoute

fun NavController.navigateToPurchase(navOptions: NavOptions? = null) =
    navigate(Purchase, navOptions)

fun NavGraphBuilder.purchaseGraph(
    navigateToUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    composable<Purchase> {
        PurchaseRoute(
            navigateToUp = navigateToUp,
            modifier = modifier,
        )
    }
}

@Serializable
data object Purchase : Route
