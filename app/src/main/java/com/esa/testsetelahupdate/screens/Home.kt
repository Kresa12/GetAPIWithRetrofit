package com.esa.testsetelahupdate.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.esa.testsetelahupdate.components.MainTopMenu

@Composable
fun Home(modifier: Modifier = Modifier) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ){
        MainTopMenu()
    }

}

@Preview
@Composable
private fun HomePreview() {

    Home()

}