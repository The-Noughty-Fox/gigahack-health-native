package com.thenoughtyfox.gigahackhealth.di

import com.thenoughtyfox.gigahackhealth.net.interceptor.HeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.openapitools.client.apis.AreasApi
import org.openapitools.client.infrastructure.ApiClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetModule {

    private const val TIME_OUT = 60L

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(HeaderInterceptor())
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
    }

    @Provides
    @Singleton
    fun provideApiClient(
        okHttpBuilder: OkHttpClient.Builder
    ): ApiClient = ApiClient(
        okHttpClientBuilder = okHttpBuilder,
        baseUrl = "https://demo.docdream.com:8001/api/"
    )

    @Provides
    @Singleton
    fun provideAreasApi(apiClient: ApiClient): AreasApi =
        apiClient.createService(AreasApi::class.java)

}