package com.ucne.tiposoportesapp.ui.TipoSoporte

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.tiposoportesapp.data.repository.TiposSoportesRepository
import com.ucne.tiposoportesapp.util.Resource
import com.ucne.tiposoportesapp.util.TiposSoporteListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class TipoSoporteViewModel @Inject constructor(
    private val tiposSoportesRepository: TiposSoportesRepository

) : ViewModel() {

    var descripcion by mutableStateOf("")
    var precioBase by mutableFloatStateOf(0f)

    var descripcionError by mutableStateOf(true)
    var precioBaseError by mutableStateOf(true)

    fun OnDescriptionChange(text : String){
        descripcion = text
        descripcionError = descripcion.isBlank()
    }

    fun OnPrecioChange(text:Float){
        precioBase=text
        precioBaseError = precioBase<0
    }

    private var _stateTipoSoporte = mutableStateOf(TiposSoporteListState())
    val stateTipoSoporte: State<TiposSoporteListState> = _stateTipoSoporte

    init {
        load()
    }
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun load(){
        tiposSoportesRepository.getTiposSoportes().onEach{ result ->
            when (result) {
                is Resource.Loading -> {
                    _stateTipoSoporte.value = TiposSoporteListState(isLoading = true)
                }
                is Resource.Success -> {
                    _stateTipoSoporte.value = TiposSoporteListState(tiposSoporte = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _stateTipoSoporte.value = TiposSoporteListState(error = result.message ?: "Error desconocido")
                }

                else -> {}
            }
        }.launchIn(viewModelScope)


    }

}