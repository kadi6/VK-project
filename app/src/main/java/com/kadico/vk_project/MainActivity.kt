package com.kadico.vk_project

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kadico.vk_project.ui.theme.VKprojectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKprojectTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->

                    textField(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}




// Stateful
@Composable
fun textField(
    modifier: Modifier
) {
    var userData by remember { mutableStateOf("Name") }

    textField(
        modifier = modifier,
        userData = userData,
        onNameChange = { newValue: String ->
            userData = newValue
        }
    )
}



// Stateless
@Composable
fun textField(
    modifier: Modifier,
    userData: String,
    onNameChange: (String) -> Unit
) {
    Column (modifier = modifier) {
        OutlinedTextField(
            value = userData,
            onValueChange =  onNameChange,
            label = { Text("TextField") }
        )

        Spacer(modifier = Modifier.width(20.dp)
        )

        Button(
            onClick = TODO(),
            modifier = TODO(),
            enabled = TODO(),
            shape = TODO(),
            colors = TODO(),
            elevation = TODO(),
            border = TODO(),
            contentPadding = TODO(),
            interactionSource = TODO(),
            content = TODO()
        )



    }
}







@Preview(showBackground = true)
@Composable
fun previewTextField() {
    textField(Modifier)
}