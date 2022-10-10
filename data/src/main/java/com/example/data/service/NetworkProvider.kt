package com.example.data.service

import com.example.data.di.DataScope
import javax.inject.Inject
import retrofit2.Retrofit

@DataScope
class NetworkProvider @Inject constructor(
    private val retrofit: Retrofit
) {

    fun <T> getService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}