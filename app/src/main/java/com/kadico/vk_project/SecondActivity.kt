package com.kadico.vk_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kadico.vk_project.ui.theme.VKprojectTheme


class SecondActivity : ComponentActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        setContent {
            VKprojectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    f()
                }
            }

        }



    }




}




@Composable
fun f() {

}


@Preview
@Composable
fun f2() {
    f()
}
