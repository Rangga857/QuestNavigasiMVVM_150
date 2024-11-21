package com.example.mvvm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.model.JenisKelamin.JenisK
import com.example.mvvm.ui.view.FormulirView
import com.example.mvvm.ui.view.TampilData
import com.example.mvvm.ui.view.TampilDataView
import com.example.mvvm.viewmodel.SiswaViewModel

enum class Halaman {
    FORMULIR,
    TAMPILDATA
}

@Composable
fun NavigationControl(
    modifier: Modifier =Modifier,
        viewModel: SiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
){
    val uiState by viewModel.statusUI.collectAsState()
    NavHost(
        modifier = Modifier,
        navController = navHost,
        startDestination = Halaman.FORMULIR.name
    ) {
        composable(
            route = Halaman.FORMULIR.name
        ) {
            val konteks = LocalContext.current
            FormulirView(
                listJK = JenisK.map { id ->
                    konteks.getString(id)
                },
                onSumbitClicked = {
                    viewModel.saveDataSiswa(it)
                    navHost.navigate(
                        Halaman.TAMPILDATA.name
                    )
                }
            )
        }
        composable(route = Halaman.TAMPILDATA.name) {
            TampilDataView(
                uiState = uiState,
                onBackButton = {navHost.popBackStack()}
            )
        }
    }
}