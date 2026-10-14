package com.kadico.vk_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.kadico.vk_project.ui.theme.VKprojectTheme


class SecondActivity : ComponentActivity() {



    companion object {
        // Префикс в значении константы используется для уникальности ключа
        const val EXTRA_USER_INPUT = "com.kadico.vk_project.USER_INPUT"
    }



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val userInput = intent.getStringExtra(EXTRA_USER_INPUT) ?: getString(R.string.user_input)


        setContent {
            VKprojectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ReceiverUserInput(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(Color.Cyan),
                        userInput = userInput
                    )
                }
            }

        }



    }




}




@Composable
fun ReceiverUserInput(
    modifier: Modifier,
    userInput: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = userInput
        )
    }
}