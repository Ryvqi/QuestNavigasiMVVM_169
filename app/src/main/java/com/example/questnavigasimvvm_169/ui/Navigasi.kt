package com.example.questnavigasimvvm_169.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasimvvm_169.model.DataJK
import com.example.questnavigasimvvm_169.ui.view.TampilMahasiswaView
import com.example.questnavigasimvvm_169.ui.view.formulirView
import com.example.questnavigasimvvm_169.ui.viewModel.MahasiswaViewModel

enum class Halaman{
    Form,
    Data
}
@Composable
fun Navigasi(modifier: Modifier = Modifier,
             viewModel: MahasiswaViewModel = viewModel(),
             navHost: NavHostController = rememberNavController()
){
    Scaffold {isipadding ->
        val _uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navHost, startDestination = Halaman.Form.name
        ) {
            composable(route = Halaman.Form.name){
                val konteks = LocalContext.current
                formulirView(
                    lisJK = DataJK.isiJK.map {
                            isi -> konteks.resources.getString(isi)
                    },
                    onClickButton = {
                        viewModel.saveDataMahasiswa(it)
                        navHost.navigate(Halaman.Data.name)
                    }
                )
            }
            composable(
                route = Halaman.Data.name
            ){
                TampilMahasiswaView(
                    mhs = _uiState,
                    onClickButton = {
                    }
                )
            }
        }
    }
}