package com.thenoughtyfox.gigahackhealth.di

import com.thenoughtyfox.gigahackhealth.net.interceptor.HeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import getUnsafeOkHttpClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.openapitools.client.apis.AreasApi
import org.openapitools.client.apis.DictionariesApi
import org.openapitools.client.apis.PersonsApi
import org.openapitools.client.apis.PricingApi
import org.openapitools.client.apis.ResourcesApi
import org.openapitools.client.apis.RoutinesApi
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
        return getUnsafeOkHttpClient().newBuilder()
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
        baseUrl = "https://demo.docdream.com:8001/"
    )

    @Provides
    @Singleton
    fun provideAreasApi(apiClient: ApiClient): AreasApi =
        apiClient.createService(AreasApi::class.java)

    @Provides
    @Singleton
    fun providePersonsApi(apiClient: ApiClient): PersonsApi =
        apiClient.createService(PersonsApi::class.java)

    @Provides
    @Singleton
    fun provideResourcesApi(apiClient: ApiClient): ResourcesApi =
        apiClient.createService(ResourcesApi::class.java)

    @Provides
    @Singleton
    fun provideRoutinesApi(apiClient: ApiClient): RoutinesApi =
        apiClient.createService(RoutinesApi::class.java)

    @Provides
    @Singleton
    fun provideDictionariesApi(apiClient: ApiClient): DictionariesApi =
        apiClient.createService(DictionariesApi::class.java)

    @Provides
    @Singleton
    fun providePriceApi(apiClient: ApiClient): PricingApi=
        apiClient.createService(PricingApi::class.java)

}