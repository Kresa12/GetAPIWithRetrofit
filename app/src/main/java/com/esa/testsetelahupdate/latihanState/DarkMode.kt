package com.esa.testsetelahupdate.latihanState

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DarkMode(
    modifier: Modifier = Modifier,
    darkMode : Boolean,
    onModeChange : () -> Unit
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(if (darkMode) Color.Black else Color.White)
    ){
        Text(
            text = if (darkMode) "Ini Dark Mode" else " Ini Light Mode",
            color = if (darkMode) Color.White else Color.Black
        )

        Button(
            onClick = onModeChange
        ) {
            Text(
                text = if (darkMode) "Ubah Ke Light Mode" else "Ubah ke Dark Mode",
                color = if (darkMode) Color.White else Color.Black
            )
        }
    }

}

@Composable
fun MainDarkMode(modifier: Modifier = Modifier) {
    var isDarkMode by remember { mutableStateOf(false) }

    DarkMode(
        darkMode = isDarkMode,
        onModeChange = {
            isDarkMode = !isDarkMode
        }
    )
}

@Preview
@Composable
private fun Prev() {

    MainDarkMode()

}