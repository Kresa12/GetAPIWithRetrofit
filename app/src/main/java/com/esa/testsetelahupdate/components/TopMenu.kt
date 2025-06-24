package com.esa.testsetelahupdate.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.esa.testsetelahupdate.modell.TopMenu
import com.esa.testsetelahupdate.modell.listTopMenu

@Composable
fun TopMenu(menu : TopMenu, modifier: Modifier = Modifier) {

    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier
            .clip(RoundedCornerShape(7.dp))
            .background(Color.Gray)
            .padding(5.dp)
    ){
        Image(
            painter = painterResource(menu.image),
            contentDescription = "",
            modifier = Modifier
                .size(24.dp)
        )
        Text(
            text = menu.name,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun MainTopMenu(modifier: Modifier = Modifier) {
    LazyRow (
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ){
        items(listTopMenu){
            TopMenu(menu = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TopMenuPreview() {

    MainTopMenu()

}