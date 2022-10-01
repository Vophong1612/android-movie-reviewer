package vn.gst.sun.moviestatistic.framework.service

import android.content.Context
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import vn.gst.sun.moviestatistic.Constants

class NetworkProvider private constructor(context: Context) {
    private val retrofit: Retrofit

    fun <T> getService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }

    private fun okhttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(1000L, TimeUnit.MILLISECONDS)
            .connectTimeout(1000L, TimeUnit.MILLISECONDS)
            .writeTimeout(1000L, TimeUnit.MILLISECONDS)
            .addInterceptor(APIKeyInterceptor(context))
            .build()
    }

    companion object {
        @Volatile
        private var instance: NetworkProvider? = null

        fun newInstance(context: Context): NetworkProvider {
            if (instance == null) {
                instance = NetworkProvider(context)
            }
            return instance!!
        }
    }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(Constants.API_URL)
            .client(okhttpClient(context))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}