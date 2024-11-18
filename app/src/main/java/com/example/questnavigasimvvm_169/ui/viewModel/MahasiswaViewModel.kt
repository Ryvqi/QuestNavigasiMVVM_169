package com.example.questnavigasimvvm_169.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.questnavigasimvvm_169.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MahasiswaViewModel: ViewModel() { // view model ": ViewModel"
    private val _uiState = MutableStateFlow(Mahasiswa())
    val uiState: StateFlow<Mahasiswa> = _uiState.asStateFlow()


}