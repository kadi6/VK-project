package com.kadico.vk_project

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.kadico.vk_project.SecondActivity.Companion.EXTRA_USER_INPUT
import com.kadico.vk_project.ui.theme.VKprojectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKprojectTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->

                    TextField(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .background(Color.Magenta)
                    )

                }
            }
        }
    }
}






// Stateful
@Composable
fun TextField(
    modifier: Modifier
) {
    val defaultUserInput = stringResource(R.string.user_input)
    var userInput by remember { mutableStateOf(defaultUserInput) }


    // Добавляем состояние "грязного" поля
    var isDirty by remember { mutableStateOf(false) }


    // Валидация (проверка данных) - проверяем является ли строка пустой или состоит исключительно из пробельных символов
    val validationInput = userInput.isBlank()
    val isError = validationInput && isDirty

    // Условие отображения ошибки
    val errorMessage = if (isError) stringResource(R.string.error_message) else ""

    // Возвращает Activity в виде Context
    val context = LocalContext.current

    TextField(
        modifier = modifier,
        userInput = userInput,
        isError = isError,
        errorMessage = errorMessage,
        onNameChange = { newValue: String ->
            userInput = newValue
            isDirty = true // Устанавливаем в true при первом же изменении
        },
        onTextButtonClick = {
            val intent = Intent(context, SecondActivity::class.java).apply {
                putExtra(EXTRA_USER_INPUT, userInput)
            }
            context.startActivity(intent)
        },
        onCallButtonClick = {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = "tel:".toUri()
            }
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
            }
        },
        onShareTextButtonClick = {
            val intent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, userInput)
                type = "text/plain"
            }

            // Создаем Intent для отображения системного окна выбора приложений (Chooser)
            val shareIntent = Intent.createChooser(intent, null)
            context.startActivity(shareIntent)

        }
    )
}






// Stateless
@Composable
fun TextField(
    modifier: Modifier,
    userInput: String,
    isError: Boolean,
    errorMessage: String,
    onNameChange: (String) -> Unit,
    onTextButtonClick: () -> Unit,
    onCallButtonClick: () -> Unit,
    onShareTextButtonClick: () -> Unit
) {
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        OutlinedTextField(
            value = userInput,
            // onNameChange выполняется в месте объявления
            onValueChange =  onNameChange,
            label = { Text(stringResource(R.string.text_field)) },
            isError = isError,
            supportingText = {
                if (isError) {
                    Text(text = errorMessage, color = Color.Red)
                }
            }
        )


        Spacer(modifier = Modifier.width(20.dp)
        )


        Button(
            onClick = onTextButtonClick,
            enabled = !isError
        ) {
            Text(text = stringResource(R.string.button_open_second_activity))
        }


        Spacer(modifier = Modifier.width(20.dp))


        Button(
            onClick = onCallButtonClick
        ) {
            Text(text = stringResource(R.string.button_call_to_friend))
        }


        Spacer(modifier = Modifier.width(20.dp))


        Button(
            onClick = onShareTextButtonClick
        ) {
            Text(text = stringResource(R.string.button_share_text))
        }

    }
}







@Preview(showBackground = true)
@Composable
fun previewTextField() {
    TextField(Modifier)
}