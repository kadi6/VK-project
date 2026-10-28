package com.kadico.vk_project.full.experemental

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun FriendListScreen() {

}

@Composable
fun ProfileScreen(
    onNavigateToFriends: () -> Unit
) {

    Column() {
        Button(
            onClick = onNavigateToFriends
        ) {
            Text(text = "FriendList")
        }
    }

}








