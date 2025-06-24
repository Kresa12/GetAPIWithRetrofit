package com.esa.testsetelahupdate.latihanViewModel.latihanViewModelStateFlow.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FriendCompose(
    modifier: Modifier = Modifier,
    listFriend : List<String>,
    valueNameTextFiend : String,
    onValueNameTextFieldChange : (String) -> Unit,
    addBtn : () -> Unit
) {

    Column() {
        TextField(
            value = valueNameTextFiend,
            onValueChange = onValueNameTextFieldChange,
            placeholder = {
                Text(
                    text = "Tulis Nama teman baru"
                )
            }
        )

        Button(
            onClick = addBtn
        ) {
            Text(
                text = "Tambahkan Teman"
            )
        }

        LazyColumn {
            items(listFriend){
                Text(
                    text = it
                )
            }
        }
    }


}