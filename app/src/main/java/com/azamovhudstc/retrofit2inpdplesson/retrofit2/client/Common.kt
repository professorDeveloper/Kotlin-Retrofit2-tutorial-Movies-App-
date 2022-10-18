package com.azamovhudstc.retrofit2inpdplesson.retrofit2.client

import com.azamovhudstc.retrofit2inpdplesson.retrofit2.service.RetrofitService

object Common {
 const val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val retrofitService: RetrofitService?
    get()=RetrofitClient.getInstance(baseUrl = BASE_URL)?.create(RetrofitService::class.java)
}