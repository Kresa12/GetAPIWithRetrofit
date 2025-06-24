package com.esa.testsetelahupdate.latihanViewModel.uiViewModel

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.esa.testsetelahupdate.latihanViewModel.logicViewModel.CounterViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun Counter(
    value : Int,
    onIncrement : () -> Unit,
    onDecrement : () -> Unit
) {

    Column {
        Text("Angka: $value")
        Button(
            onClick = onDecrement,

            ) {
            Text("Kurang")
        }

        Button(onClick = onIncrement ) {
            Text("Tambah")
        }
    }
}

@Composable
fun CounterScreen(viewModel : CounterViewModel = viewModel()) {

    val countState = viewModel.count.collectAsState()

    Counter(
        value = countState.value,
        onIncrement = { viewModel.increment() },
        onDecrement = { viewModel.decrement() }
    )
}


@Preview(showBackground = true)
@Composable
private fun Prev() {
    CounterScreen()
}