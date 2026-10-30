package com.kadico.vk_project.full.presentation.navigation

import androidx.navigation.NavController
import com.kadico.core.AppNavigator




    /*
        Interface Implementation
    */



class AppNavigatorImpl(
    private val navController: NavController
) : AppNavigator {
    override fun navigateToApps() {
        navController.navigate(ListAppsRoute)
    }
}