package com.esa.testsetelahupdate.latihanState

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TambahKurangAngka(
    modifier: Modifier = Modifier,
    currenValue : Int,
    onIncrement : () -> Unit,
    onDecrement : () -> Unit
) {

    Row {

        Button(
            onClick = onDecrement,
            enabled = currenValue > 1
        ) {
            Text(
                text = "-"
            )
        }

        Text(
            text = currenValue.toString()
        )

        Button(
            onClick = onIncrement
        ) {
            Text(
                text = "+"
            )
        }
    }
}


@Composable
fun MainTambahKurangAngka(modifier: Modifier = Modifier) {
    var value by remember { mutableIntStateOf(1) }

    TambahKurangAngka(
        currenValue = value,
        onIncrement = {
            value++
        },
        onDecrement = {value = maxOf(1, value - 1) }
    )
}

@Preview(showBackground = true)
@Composable
private fun Prev() {

    MainTambahKurangAngka()
}