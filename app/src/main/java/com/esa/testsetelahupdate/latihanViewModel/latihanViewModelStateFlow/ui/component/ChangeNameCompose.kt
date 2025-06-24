package com.esa.testsetelahupdate.latihanViewModel.latihanViewModelStateFlow.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun ChangeNameCompose(
    modifier: Modifier = Modifier,
    name : String,
    valueNameTextField : String,
    onValueNameTextFieldChange : (String) -> Unit,
    changeNameBtn : () -> Unit
    ) {

    Column {

        Text(
            text = "hallo $name"
        )

        TextField(
            value = valueNameTextField,
            onValueChange = onValueNameTextFieldChange
        )

        Button(
            onClick = changeNameBtn
        ) { }


    }


}

