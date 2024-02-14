package com.ucne.tiposoportesapp.data.remote

import com.ucne.tiposoportesapp.data.remote.dto.TipoSoportesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Body
import retrofit2.http.Headers

interface TiposSoporteApi {

    @GET("TiposSoportes")
    @Headers("X-API-Key: test")
    suspend fun getTiposSoportes():List<TipoSoportesDto>

    @GET("TiposSoportes/{idTipo}")
    @Headers("X-API-Key: test")
    suspend fun getTiposSoporteById(@Path("idTipo")idTipo : Int): Response<TipoSoportesDto>

    @POST("TiposSoportes")
    @Headers("X-API-Key: test")
    suspend fun postTiposSoporte(@Body tipoSoportesDto: TipoSoportesDto): Response<TipoSoportesDto>

    @PUT("TiposSoportes/{idTipo}")
    @Headers("X-API-Key: test")
    suspend fun putTiposSoporte(@Body tipoSoportesDto: TipoSoportesDto, @Path("idTipo")idTipo : Int): Response<TipoSoportesDto>

    @DELETE("TiposSoportes/{id}")
    @Headers("X-API-Key: test")
    suspend fun deleteTiposSoporte(@Path("id") id: Int): Response<TipoSoportesDto>
}