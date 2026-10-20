package com.kadico.vk_project.presentation.appdetails


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kadico.vk_project.R
import com.kadico.vk_project.presentation.data.listApps
import com.kadico.vk_project.presentation.theme.VKprojectTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


// Stateful
@Composable
fun ListApps() {

    // Создаем состояние для Snackbar и область для запуска корутин
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    ListApps(
        snackbarHostState = snackbarHostState,
        scope = scope
    )

}


// Stateless
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListApps(
    snackbarHostState: SnackbarHostState,
    scope: CoroutineScope,
) {
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Text(
                            stringResource(R.string.toolbar),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar("Находится в разработке")
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Info,
                                contentDescription = "Menu",
                                tint = MaterialTheme.colorScheme.secondary
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar("Находится в разработке")
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Favorite",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                )
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant
                )
            }
        }
    ) { innerPadding ->


        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            items(listApps) { item ->

                Column(
                    modifier = Modifier
                        .background(color = Color(0xFFEDF2F8))
                        .clickable {
                            scope.launch {
                                snackbarHostState.showSnackbar("Находится в разработке")
                            }
                        }

                    ) {

                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                        horizontalAlignment = Alignment.Start
                    ) {

                        Icon(
                            imageVector = item.iconApp,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp),
                            tint = MaterialTheme.colorScheme.secondary
                        )


                        Text(text = item.titleApp, style = MaterialTheme.typography.titleMedium)
                        Text(
                            text = item.categoryApp,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        Text(
                            text = item.descriptionApp,
                            style = MaterialTheme.typography.bodySmall,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )


                        // Полоса-разделитель
                        HorizontalDivider(
                            modifier = Modifier.padding(top = 16.dp),
                            thickness = 1.dp,
                            color = MaterialTheme.colorScheme.outlineVariant
                        )
                    }

                }

            }

        }
    }
}


@Preview
@Composable
fun PreviewListApps() {
    VKprojectTheme {
        ListApps()
    }
}