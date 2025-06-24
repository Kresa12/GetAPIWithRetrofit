package com.esa.testsetelahupdate.latihanViewModel.latihanViewModelStateFlow.ui.screen.listFriend

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.esa.testsetelahupdate.latihanViewModel.latihanViewModelStateFlow.ui.component.FriendCompose

@Composable
fun FriendScreen(viewModel: FriendViewModel = viewModel()) {

    Column (modifier = Modifier.fillMaxSize()){
        val listFriend = viewModel.listFriend.collectAsState()
        var valueTextField by remember { mutableStateOf("") }
        val errorName by remember { mutableStateOf<String?>(null) }
        val isLoading by viewModel.isLoading.collectAsState()


        if (isLoading){
            Text(
                text = "nama lagi di tambahin"
            )
        }

        FriendCompose(
            listFriend = listFriend.value,
            valueNameTextFiend = valueTextField,
            onValueNameTextFieldChange = {valueTextField = it},
            addBtn ={
                viewModel.addFriend(valueTextField)
                valueTextField = ""
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Prev() {
    FriendScreen()

}