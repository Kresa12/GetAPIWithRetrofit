package com.esa.testsetelahupdate.latihanState

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TodoList(
    currenInput: String,
    onInputChange: (String) -> Unit,
    listTodo: List<String>,
    onAddTodo: () -> Unit,
    selectedTodo: String?,
    onSelectTodo: (String) -> Unit,
    onRemoveTodo: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row {
            TextField(
                value = currenInput,
                onValueChange = onInputChange,
                label = { Text("Masukkan todo") }
            )

            Button(
                onClick = onAddTodo,
                enabled = currenInput.isNotBlank()
            ) {
                Text(text = "Tambah")
            }
        }

        Button(
            onClick = onRemoveTodo,
            enabled = selectedTodo != null
        ) {
            Text(text = "Hapus Todo")
        }

        Column {
            listTodo.forEach { todo ->
                Button(
                    onClick = { onSelectTodo(todo) },
                    enabled = true
                ) {
                    val isSelected = todo == selectedTodo
                    Text(text = if (isSelected) "✅ $todo" else todo)
                }
            }
        }
    }
}

@Composable
fun MainTodo(modifier: Modifier = Modifier) {
    var input by remember { mutableStateOf("") }
    val listTodo = remember { mutableStateListOf<String>() }
    var selectedTodo by remember { mutableStateOf<String?>(null) }

    TodoList(
        currenInput = input,
        onInputChange = { input = it },
        listTodo = listTodo,
        onAddTodo = {

            listTodo.add(input)
            input = ""
        },
        selectedTodo = selectedTodo,
        onSelectTodo = { selectedTodo = it },
        onRemoveTodo = {
//            selectedTodo?.let {itemYangDihapus ->
//                listTodo.remove(itemYangDihapus)
//                selectedTodo = null
//            }
            /**kode di atas itu sama saja kaya dibawah ini, artinya
             * jika suatu variable tidak null mata kode yang ada di dalam blok .let{} akan di jalankan
             **/
            if (selectedTodo != null) {
                listTodo.remove(selectedTodo)
                selectedTodo = null
            }
        },
        modifier = modifier
    )
}

//besok memahami ini yaaa, bagaimana cara kerjanya

@Preview(showBackground = true)
@Composable
private fun PrevTodo() {
    MainTodo()
}
