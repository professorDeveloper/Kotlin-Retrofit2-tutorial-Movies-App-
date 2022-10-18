package com.azamovhudstc.retrofit2inpdplesson.retrofit2.service

import com.azamovhudstc.retrofit2inpdplesson.model.MovieItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("marvel")
    fun getMovies(): Call<List<MovieItem>>
}