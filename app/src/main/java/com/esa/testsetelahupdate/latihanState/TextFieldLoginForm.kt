package com.esa.testsetelahupdate.latihanState

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextFileldLoginForm(
    modifier: Modifier = Modifier,
    valueName : String,
    valueEmail : String,
    onValueNameChange : (String) -> Unit,
    onValueEmailChange : (String) -> Unit,
    onSubmitButton : () -> Unit,
    isButtonEnabled : Boolean,
    list : List<String>
) {

    Column {

        TextField(
            value = valueName,
            onValueChange = onValueNameChange
        )

        TextField(
            value = valueEmail,
            onValueChange = onValueEmailChange
        )

        Button(
            onClick = onSubmitButton,
            enabled = isButtonEnabled
        ) {
            Text(
                text = "Kirim"
            )
        }

        LazyColumn {
            items(list){
                Text(
                    text = it
                )
            }
        }

    }
}

@Composable
fun MainTextfieldLoginForm(modifier: Modifier = Modifier) {

    var valueName by remember { mutableStateOf("") }
    var valueEmail by remember { mutableStateOf("") }
    //pakai ini agar inputan bisa berubah di UI
    val listName = remember { mutableStateListOf<String>() }


    var onError by remember { mutableStateOf<String?>(null) }

    val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")

    val isEmailValid = valueEmail.matches(emailRegex)
    Column {

//        if (onError != null){
//            Text(
//                text = onError?: "",
//                color = Color.Red
//            )
//        }

        onError?.let {
            Text(
                text = it, // it itu adalah representasi dari isi onError
                color = Color.Red
            )
        }


        TextFileldLoginForm(
            valueName = valueName,
            valueEmail = valueEmail,
            onValueNameChange = { valueName = it },
            onValueEmailChange = { valueEmail = it },
            onSubmitButton = {
                if (valueName.length < 5){
                    onError = "nama kurang panjang"
                }else if (valueName in listName){
                    onError = "nama sudah ada"
                }else if (!isEmailValid){
                    onError = "masukan email dengan benar"
                }
                else{
                    listName.add(valueName)
                    valueName = ""
                    valueEmail = ""
                    onError = null
                }
            },
            isButtonEnabled = valueName.isNotEmpty() && valueEmail.isNotEmpty(),
            list = listName
        )

    }

}

@Preview(showBackground = true)
@Composable
private fun Prev() {

    MainTextfieldLoginForm()
}