package vn.gst.sun.moviestatistic.framework.service

import android.content.Context
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import vn.gst.sun.moviestatistic.R

class APIKeyInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val originalHttpUrl: HttpUrl = original.url()

        val apiKey = context.getString(R.string.api_key)

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key", apiKey)
            .build()

        val requestBuilder: Request.Builder = original.newBuilder()
            .url(url)

        val request: Request = requestBuilder.build()
        return chain.proceed(request)
    }
}