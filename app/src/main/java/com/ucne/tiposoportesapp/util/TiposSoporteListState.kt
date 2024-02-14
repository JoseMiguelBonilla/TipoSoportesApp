package com.ucne.tiposoportesapp.util

import com.ucne.tiposoportesapp.data.remote.dto.TipoSoportesDto

data class TiposSoporteListState(
    val isLoading: Boolean = false,
    val tiposSoporte: List<TipoSoportesDto> = emptyList(),
    val error: String = ""
)