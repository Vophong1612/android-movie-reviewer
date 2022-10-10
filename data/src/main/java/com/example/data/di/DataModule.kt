package com.example.data.di

import com.example.data.Constants
import com.example.data.repositories.MovieRepositoryImpl
import com.example.data.service.APIKeyInterceptor
import com.example.data.service.NetworkProvider
import com.example.data.service.service.MovieDataService
import dagger.Module
import dagger.Provides
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import vn.gst.sun.lib.repositories.MovieRepository

@Module
class DataModule {

    @Provides
    @DataScope
    fun provideApiKeyInterceptor(): APIKeyInterceptor = APIKeyInterceptor(Constants.API_KEY)

    @Provides
    @DataScope
    fun provideOkHttpClient(apiKeyInterceptor: APIKeyInterceptor): OkHttpClient = OkHttpClient.Builder()
            .readTimeout(1000L, TimeUnit.MILLISECONDS)
            .connectTimeout(1000L, TimeUnit.MILLISECONDS)
            .writeTimeout(1000L, TimeUnit.MILLISECONDS)
            .addInterceptor(apiKeyInterceptor)
            .build()

    @Provides
    @DataScope
    fun provideRetrofit(okhttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.API_URL)
        .client(okhttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @DataScope
    fun provideMovieDataService(networkProvider: NetworkProvider): MovieDataService =
        networkProvider.getService(MovieDataService::class.java)

    @Provides
    fun provideMovieRepository(movieDataService: MovieDataService): MovieRepository =
        MovieRepositoryImpl(movieDataService)
}