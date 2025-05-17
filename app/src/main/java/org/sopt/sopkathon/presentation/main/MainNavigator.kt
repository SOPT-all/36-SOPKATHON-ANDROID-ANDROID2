package org.sopt.sopkathon.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.sopt.sopkathon.presentation.dummy.navigation.Dummy

class MainNavigator(
    val navController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val startDestination = Dummy

    var isRegister: Boolean by mutableStateOf(false)
        private set

    val currentTab: MainTab?
        @Composable get() = MainTab.find { tab ->
            currentDestination?.hasRoute(tab::class) == true
        }

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            navController.currentDestination?.route?.let {
                popUpTo(it) {
                    saveState = true
                }
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainTab.DUMMY -> { }
            else -> { }
        }
    }

    fun navigateUp() {
        if (isRegister) dismissRegisterDialog()
        else navController.navigateUp()
    }

    @Composable
    fun showBottomBar() = MainTab.contains {
        currentDestination?.hasRoute(it::class) == true
    }

    fun dismissRegisterDialog() {
        isRegister = false
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}
