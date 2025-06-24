package com.esa.testsetelahupdate.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Checkbox
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
fun InputName(name : String, onNameChange : (String) -> Unit) {
    TextField(
        value = name,
        onValueChange = onNameChange,
        label = {
            Text(
                text = "Nama"
            )
        }
    )
}

@Composable
fun Tes(modifier: Modifier = Modifier) {

    var name by remember { mutableStateOf("") }

    Column {
        InputName(
            name = name,
            onNameChange = {
                name = it
            }
        )

        Text(
            text = "Hallo $name"
        )
    }
}

@Composable
fun CheckBoxBuatan(
    checkedBox : Boolean,
    onChackBoxClick : (Boolean) ->Unit,
    modifier: Modifier = Modifier
) {

    Checkbox(
        checked = checkedBox,
        onCheckedChange = onChackBoxClick
    )
}

@Composable
fun MainCheckBoxBuatan(modifier: Modifier = Modifier) {

    var ischeked by remember { mutableStateOf(false) }

    CheckBoxBuatan(
        checkedBox = ischeked,
        onChackBoxClick = {ischeked = it}
    )
}


@Preview(showBackground =true)
@Composable
private fun ExampleStateHoistingPreview() {
    Tes()
}

@Preview(showBackground = true)
@Composable
private fun CheckBoxPrev() {
    MainCheckBoxBuatan()
}