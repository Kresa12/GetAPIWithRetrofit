package com.esa.testsetelahupdate.latihanState

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
fun LikeButton(
    modifier: Modifier = Modifier,
    likeBtn : Boolean,
    onBtnLikeChange : () -> Unit

) {

    Button(
        onClick =
            onBtnLikeChange

    ) {
        Icon(
            imageVector = Icons.Outlined.ThumbUp,
            contentDescription = "",
            tint = if (likeBtn) Color.White else Color.Black
        )
    }
}

@Composable
fun MainLikeButton(modifier: Modifier = Modifier) {
    var isLiked by remember { mutableStateOf(false) }

    Column {

        LikeButton (
            likeBtn = isLiked,
            onBtnLikeChange = {
                //kuncinya disini agar membuat button bisa di di ubah nilainya dari true ke false dari false ke true
                isLiked = !isLiked
            }
        )

        Text(
            text = if (isLiked) "Batal Suka" else "Suka",
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun Prev() {
    MainLikeButton()
}