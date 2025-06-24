
package com.esa.testsetelahupdate.latihanViewModel.latihanViewModelStateFlow.ui.screen.changeName

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.esa.testsetelahupdate.latihanViewModel.latihanViewModelStateFlow.ui.component.ChangeNameCompose

@Composable
fun ChangeNameScreen(viewModel: ChangeNameViewModel = viewModel()) {

    Column {
        val name = viewModel.name.collectAsState()
        var newNameChange by remember { mutableStateOf("") }
        var onErrorName by remember { mutableStateOf<String?>(null) }


        ChangeNameCompose(
            name = name.value,
            valueNameTextField = newNameChange,
            onValueNameTextFieldChange = {
                newNameChange = it
            },
            changeNameBtn = {
                if (newNameChange == name.value){
                    onErrorName = "Nama yang anda ganti sama dengan nama lama"
                }
                viewModel.setName(newNameChange)
                newNameChange = ""
            }
        )

        onErrorName?.let {
            Text(
                text = onErrorName!!,
                color = Color.Red
            )
        }


    }

}

@Preview(showBackground = true)
@Composable
private fun Prev() {

    ChangeNameScreen()

}