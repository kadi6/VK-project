package com.kadico.vk_project.full.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kadico.details.presentation.AppDetailsScreen
import com.kadico.vk_project.full.presentation.listapps.ListApps






/*
    Создание и описание NavHost, регистрация экранов
*/





// Stateless composable
@Composable
fun AppNavHost(
    modifier: Modifier,
    navController: NavHostController
) {

    val appNavigator = remember(navController) {
        AppNavigatorImpl(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = ListAppsRoute,
        modifier = modifier
    ) {

        composable<ListAppsRoute> {
            ListApps(
                onAppClick = { navController.navigate(DetailsRoute) }
            )
        }

        composable<DetailsRoute> {
            AppDetailsScreen(
                navigator = appNavigator
            )
        }
    }

}