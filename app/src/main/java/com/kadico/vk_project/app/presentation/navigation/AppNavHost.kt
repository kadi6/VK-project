package com.kadico.vk_project.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kadico.details.presentation.AppDetailsScreen
import com.kadico.vk_project.app.di.AppContainer
import com.kadico.vk_project.app.presentation.listapps.ListApps
import com.kadico.vk_project.app.presentation.listapps.ListAppsViewModel







/*
    Создание и описание NavHost, регистрация экранов
*/





// Stateless composable
@Composable
fun AppNavHost(
    modifier: Modifier,
    navController: NavHostController,
    appContainer: AppContainer
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


            //  Подготавливаем фабрику
            val factory = viewModelFactory {
                initializer {
                    ListAppsViewModel(
                        appContainer.getAppInfoUseCase
                    )
                }
            }


            //  Запрашиваем ViewModel
            val viewModel: ListAppsViewModel = viewModel(factory = factory)


            //  Передаем ViewModel экрану
            ListApps(
                viewModel = viewModel,
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