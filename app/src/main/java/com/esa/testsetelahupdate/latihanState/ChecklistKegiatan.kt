package com.esa.testsetelahupdate.latihanState

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ChecklistKegiatan(
    modifier: Modifier = Modifier,
    valueList : String,
    onValueListChange : (String) -> Unit,
    list : Map<String, Boolean>,
    onToggleChecked : (String) -> Unit,
    addOn : () -> Unit
) {
    Column {
        Row {
            TextField(
                value = valueList,
                onValueChange = onValueListChange
            )

            Button(
                onClick = addOn
            ) {
                Text(
                    text = "Tambah Kegiatan"
                )
            }
        }

        Column {
            list.forEach{(key, value) ->
                Text(
                    text = key,
                    textDecoration = if (value) TextDecoration.LineThrough else TextDecoration.None,
                    fontStyle = if (value) FontStyle.Italic else FontStyle.Normal,
                    modifier = Modifier
                        .clickable { onToggleChecked(key) }
                )
            }
        }
    }
}

@Composable
fun MainChecklistKegiatan(modifier: Modifier = Modifier) {
    val list = remember { mutableStateMapOf<String, Boolean>() }
    var valueText by remember { mutableStateOf("") }

    ChecklistKegiatan(
        valueList = valueText,
        onValueListChange = {valueText = it},
        list = list,
        onToggleChecked = {
            //cara mengubah ubah nilai true false yang ada di map
            list[it] = !(list[it] ?: false)
        },
        addOn = {
            if (valueText.isNotBlank() && valueText !in list){
                list[valueText] = false
                valueText = ""
            }

        }
    )
}

//selanjutnya belajar langsung slicing dengan menerapkan ilmu state ini

@Preview(showBackground = true)
@Composable
private fun Prev(){
    MainChecklistKegiatan()
}