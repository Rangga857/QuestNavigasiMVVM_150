package com.example.mvvm.ui.view

import android.app.PictureInPictureUiState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mvvm.model.Datasiswa

@Composable
fun TampilDataView(
    uiState: Datasiswa,
    onBackButton : () -> Unit){
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp))
    {
        TampilData(x = "Nama", y = uiState.nama )
        TampilData(x = "Jenis Kelamin", y = uiState.gender)
        TampilData(x = "Alamat", y = uiState.alamat)
        Button(onClick = onBackButton) {
            Text(text = "Kembali")
        }
    }

}

@Composable
fun TampilData(x : String, y :String){
    Column (
        modifier = Modifier.padding(16.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween)
        {
                Text(text = x,
                    modifier = Modifier.weight(0.8f))
                Text(text = ":",
                    modifier = Modifier.weight(0.2f))
                Text(text = y,
                    modifier = Modifier.weight(2f))
        }
    }
}