package com.ucne.tiposoportesapp.ui.TipoSoporte

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun Consulta(
    tipoSoporteViewModel: TipoSoporteViewModel = hiltViewModel()
){
    var tiposSoportes = tipoSoporteViewModel.stateTipoSoporte.value.tiposSoporte

    Column (modifier = Modifier.padding(5.dp).fillMaxSize()){
        Column {
            Text(text = "Descripcion : 1")
            Text(text = "Precio Base : 2")
        }
        LazyColumn(){

            items(tiposSoportes) {tipoSoporte ->
                ElevatedCard(modifier = Modifier.padding(6.dp)) {
                    Column {
                        Text(text = "Descripcion : ${tipoSoporte.descripcion}")
                        Text(text = "Precio Base : ${tipoSoporte.precioBase}")
                    }
                }
            }
        }
    }
}