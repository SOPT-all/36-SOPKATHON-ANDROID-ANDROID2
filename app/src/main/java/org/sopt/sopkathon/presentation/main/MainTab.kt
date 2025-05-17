package org.sopt.sopkathon.presentation.main

import androidx.compose.runtime.Composable
import org.sopt.sopkathon.core.common.navigation.MainTabRoute
import org.sopt.sopkathon.core.common.navigation.Route
import org.sopt.sopkathon.presentation.dummy.navigation.Dummy
import org.sopt.sopkathon.presentation.main.MainTab.entries

// TODO: Should implement
enum class MainTab(
//    @DrawableRes val iconRes: Int,
//    @StringRes val title: Int,
    val route: MainTabRoute,
) {
    DUMMY(
        route = Dummy
//       iconRes = R.drawable.ic_nav_home,
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}
