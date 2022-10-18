package com.azamovhudstc.retrofit2inpdplesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.azamovhudstc.retrofit2inpdplesson.adapter.RvAdapter
import com.azamovhudstc.retrofit2inpdplesson.model.MovieItem
import com.azamovhudstc.retrofit2inpdplesson.retrofit2.client.Common
import com.azamovhudstc.retrofit2inpdplesson.retrofit2.service.RetrofitService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var retrofitService: RetrofitService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        retrofitService = Common.retrofitService!!
        retrofitService.getMovies().enqueue(object : retrofit2.Callback<List<MovieItem>> {
            override fun onResponse(
                call: Call<List<MovieItem>>,
                response: Response<List<MovieItem>>
            ) {
                if (response.isSuccessful) {
                    Handler().postDelayed({
                       progressBar.visibility=View.VISIBLE
                       var adapter=RvAdapter(this@MainActivity,response.body()!!)
                       recycle_view.adapter=adapter
                       progressBar.visibility=View.INVISIBLE
                    }, 2000)
                }
            }

            override fun onFailure(call: Call<List<MovieItem>>, t: Throwable) {

            }

        })
    }
}