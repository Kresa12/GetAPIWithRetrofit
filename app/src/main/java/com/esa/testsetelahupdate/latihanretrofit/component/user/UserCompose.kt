package com.esa.testsetelahupdate.latihanretrofit.component.user

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.esa.testsetelahupdate.latihanretrofit.data.model.UserModel

@Composable
fun UserCompose(
    modifier: Modifier = Modifier,
    users : List<UserModel>,
//    isLoading : Boolean,
    onFetch : () -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        LaunchedEffect(Unit) {
            onFetch()
        }

        LazyColumn {
            items(users) { user ->
                Text(text = "${user.name} - ${user.id}")
            }
        }

//        if (isLoading) {
//            Text("Loading...")
//        } else {
//            LazyColumn {
//                items(users) { user ->
//                    Text(text = "${user.name} - ${user.email}")
//                }
//            }
//        }
    }
}