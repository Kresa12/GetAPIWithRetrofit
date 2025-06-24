package com.esa.testsetelahupdate.latihanState

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextFieldHallo(
    modifier: Modifier = Modifier,
    value : String,
    onValueChange : (String) -> Unit
    ) {

    Column {

        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(text = "nama")
            }
        )

        Text(
            text = if (value.isNotBlank()) "Hallo, $value" else ""
        )
    }
}

@Composable
fun MainTextFieldHallo(modifier: Modifier = Modifier) {
    var value by remember { mutableStateOf("") }

    TextFieldHallo (
        value = value,
        onValueChange = {value = it}
    )
}

@Preview(showBackground = true)
@Composable
private fun Prev() {
    MainTextFieldHallo()
}