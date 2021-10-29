package com.audronf.dndcompanion.di

import okhttp3.OkHttpClient
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit

val retrofitModule = module {

    fun provideRetrofit(httpCliente: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
}