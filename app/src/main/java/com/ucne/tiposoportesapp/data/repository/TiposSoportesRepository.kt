package com.ucne.tiposoportesapp.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import com.ucne.tiposoportesapp.data.remote.TiposSoporteApi
import com.ucne.tiposoportesapp.data.remote.dto.TipoSoportesDto
import com.ucne.tiposoportesapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class TiposSoportesRepository @Inject constructor(
    private val api: TiposSoporteApi
) {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getTiposSoportes(): Flow<Resource<List<TipoSoportesDto>?>> = flow {
        try {
            emit(Resource.Loading())

            val tiposSoportes = api.getTiposSoportes()

            emit(Resource.Success(tiposSoportes))
        } catch (e: HttpException) {

            emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))
        } catch (e: IOException) {

            emit(Resource.Error(e.message ?: "verificar tu conexion a internet"))
        }
    }

    suspend fun postTipoSoporte(tipoSoportesDto: TipoSoportesDto) : TipoSoportesDto?{
        val response = api.postTiposSoporte(tipoSoportesDto)
        if (response.isSuccessful) {
            response.body()
        }
        return tipoSoportesDto
    }
    suspend fun getTipoSoporteById(idTipo: Int ) : TipoSoportesDto?{
        val response = api.getTiposSoporteById(idTipo)
        if (response.isSuccessful) {
            response.body()
        }
        return response.body()
    }
    suspend fun putTipoSoporte(tipoSoportesDto: TipoSoportesDto,idTipo: Int) : TipoSoportesDto?{
        val response = api.putTiposSoporte(tipoSoportesDto, idTipo)
        if (response.isSuccessful) {
            response.body()
        }
        return tipoSoportesDto
    }

    suspend fun deleteTipoSoporte(id: Int) : TipoSoportesDto? {
        return api.deleteTiposSoporte(id).body()
    }


}