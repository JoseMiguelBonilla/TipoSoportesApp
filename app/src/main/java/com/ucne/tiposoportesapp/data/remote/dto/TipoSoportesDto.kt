package com.ucne.tiposoportesapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
 data class TipoSoportesDto (
    @Json(name = "idTipo")
     val idTipo : Int?=  0,
    @Json(name = "descripcion")
     val descripcion : String =  "",
    @Json(name = "precioBase")
     val precioBase : Int?= 0
 )