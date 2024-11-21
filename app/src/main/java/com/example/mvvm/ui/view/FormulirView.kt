package com.example.mvvm.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//@Preview (showBackground = true)
@Composable
fun FormulirView(
    modifier: Modifier = Modifier,
    listJK : List<String>,
    onSumbitClicked: (MutableList<String>) -> Unit
){
    var nama by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("")}
    var gender by remember { mutableStateOf("") }

    val listData: MutableList<String> = mutableListOf(nama, nim, gender, alamat)

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        TextField(
            value = nama,
            onValueChange = {nama = it},
            label = { Text(text = "Nama") },
            placeholder = { Text(text = "Isi Nama Anda") },
            modifier = modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
        TextField(
            value = nim,
            onValueChange = {nim = it},
            label = { Text(text = "NIM") },
            placeholder = { Text(text = "Isi NIM Anda") },
            modifier = modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Row (modifier = Modifier.fillMaxWidth()){
            listJK.forEach{selectedGender ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = gender == selectedGender,
                        onClick = {gender = selectedGender}
                    )
                    Text(text = selectedGender)
                }
            }
        }
        TextField(
            value = email,
            onValueChange = {email = it},
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Isi Email Anda") },
            modifier = modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = alamat,
            onValueChange = {alamat= it},
            label = { Text(text = "Alamat") },
            placeholder = { Text(text = "Isi alamat anda") },
            modifier = modifier
                .fillMaxWidth()
                .padding(5.dp)

        )
        TextField(
            value = notelepon,
            onValueChange = {notelepon = it},
            label = { Text(text = "Nomor Telepon") },
            placeholder = { Text(text = "Isi No Telepon Anda") },
            modifier = modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = { onSumbitClicked(listData) }
        )
        {
            Text(text = "simpan")
        }
    }
}


