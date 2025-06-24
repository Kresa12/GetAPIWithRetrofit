package com.esa.testsetelahupdate.latihanState

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun KegiatanList(
    modifier: Modifier = Modifier,
    listTodo : List<String>,
    valueText : String,
    onValueTextChange : (String) -> Unit,
    button : Boolean,
    addOnButton : () -> Unit
) {
    Column {

        TextField(
            value = valueText,
            onValueChange = onValueTextChange
        )

        Button(
            onClick = addOnButton,
            enabled = button
        ) {
            Text(
                text = "Tambah"
            )
        }

        listTodo.forEach{
            Column {
                Text(
                    text = it
                )
            }
        }
    }
}

@Composable
fun MainKegiatanList(modifier: Modifier = Modifier) {

    val listkegiatan = remember { mutableStateListOf<String>() }
    var valueText by remember { mutableStateOf("") }

    KegiatanList(
        listTodo = listkegiatan,
        valueText = valueText,
        onValueTextChange = {valueText = it},
        button = valueText.isNotEmpty() && valueText !in listkegiatan,
        addOnButton = {
            listkegiatan.add(valueText)
                      valueText = ""},
    )
}

@Preview(showBackground = true)
@Composable
private fun Prev() {

    MainKegiatanList()

}