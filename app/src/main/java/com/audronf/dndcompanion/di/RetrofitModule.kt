package com.audronf.dndcompanion.di

import com.audronf.dndcompanion.BuildConfig
import com.audronf.dndcompanion.network.service.SpellsService
import com.audronf.dndcompanion.repository.SpellsRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {

    fun provideHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    fun provideRetrofit(httpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun provideSpellsService(retrofit: Retrofit): SpellsService = retrofit.create(SpellsService::class.java)


    single { provideHttpClient() }
    single { provideRetrofit(get()) }
    single { provideSpellsService(get()) }
    single { SpellsRepository(get(), get()) }
}
