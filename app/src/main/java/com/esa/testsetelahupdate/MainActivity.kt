package com.esa.testsetelahupdate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.esa.testsetelahupdate.latihanretrofit.screen.user.UserScreen
import com.esa.testsetelahupdate.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                UserScreen()
            }
        }
    }
}






@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}

data class Product(val name: String, val price : String)



@Composable
fun CardTest(product: Product, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .size(height = 80.dp, width = 40.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = product.name,
            fontSize = 25.sp
        )

        Text(
            text = product.price,
            fontSize = 25.sp
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun CartdTestPriview() {

    val products = listOf(
        Product("Nurisari", "2000"),
        Product("Nurisari", "2000"),
        Product("Nurisari", "2000"),
        Product("Nurisari", "2000"),
        Product("Nurisari", "2000"),
        Product("Nurisari", "2000"),
        Product("Nurisari", "2000"),
        Product("Nurisari", "2000"),
        Product("Nurisari", "2000"),
        Product("Nurisari", "2000"),
        Product("Nurisari", "2000"),
        Product("Nurisari", "2000"),
        Product("Nurisari", "2000"),
        Product("Nurisari", "2000")
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement =   Arrangement.spacedBy(10.dp)
    ) {
        items(products){
            CardTest(product = it)
        }
    }



}