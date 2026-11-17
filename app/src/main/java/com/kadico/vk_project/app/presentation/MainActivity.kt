package com.kadico.vk_project.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.kadico.vk_project.app.di.AppContainer
import com.kadico.vk_project.app.presentation.navigation.AppNavHost
import com.kadico.vk_project.app.presentation.theme.VKprojectTheme
import dagger.hilt.android.AndroidEntryPoint









    /*
        MainActivity    ---     Точка входа в пользовательский интерфейс приложения
    */








@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKprojectTheme {



                // State Holder для NavHost
                val navController = rememberNavController()

                // Создаём контейнер зависимостей
                val appContainer = remember {
                    AppContainer()
                }



                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->

                    AppNavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        appContainer = appContainer
                    )

                }
            }
        }
    }
}