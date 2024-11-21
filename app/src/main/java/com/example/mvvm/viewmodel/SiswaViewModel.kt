package com.example.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvm.model.Datasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SiswaViewModel : ViewModel() {
    //Request to model
    private val _statusUI = MutableStateFlow(Datasiswa())
    //Response to view
    val statusUI : StateFlow<Datasiswa> = _statusUI.asStateFlow()


}