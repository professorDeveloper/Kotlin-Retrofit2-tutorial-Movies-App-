package com.azamovhudstc.retrofit2inpdplesson.retrofit2.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private final var instance: Retrofit? = null
    fun getInstance(baseUrl:String): Retrofit? {
        if (instance == null) {
            instance = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
        }
        return instance
    }
}