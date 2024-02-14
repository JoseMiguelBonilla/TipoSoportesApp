



package com.ucne.tiposoportesapp.di
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.ucne.tiposoportesapp.data.remote.TiposSoporteApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn( SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }




    @Provides
    @Singleton
    fun provideTiposAportesApi(moshi: Moshi, ): TiposSoporteApi {
        return Retrofit.Builder()
            .baseUrl("https://sag-api.azurewebsites.net/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(TiposSoporteApi::class.java)
    }

}