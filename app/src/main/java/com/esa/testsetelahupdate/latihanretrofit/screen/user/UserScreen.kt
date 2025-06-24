package com.esa.testsetelahupdate.latihanretrofit.screen.user

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.esa.testsetelahupdate.latihanretrofit.component.user.UserCompose

@Composable
fun UserScreen(viewModel: UserViewModel = viewModel()) {

    val users = viewModel.users.collectAsState()
//    val isLoading = viewModel.isLoading.collectAsState()

    UserCompose(
        users = users.value,
//        isLoading = isLoading.value,
        onFetch = {viewModel.fetchUsers()}
    )
}

@Preview(showBackground = true)
@Composable
private fun Prev() {
    UserScreen()
}