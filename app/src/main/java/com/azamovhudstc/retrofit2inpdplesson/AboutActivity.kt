package com.azamovhudstc.retrofit2inpdplesson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.azamovhudstc.retrofit2inpdplesson.model.MovieItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.item_movie.view.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val movieItem = intent.extras?.getSerializable("data") as MovieItem
        creater.text="created by:${movieItem.createdby}"
        des.text=movieItem.bio
        name.text=movieItem.name
        realName.text="realName:${movieItem.realname}"
        Picasso.get().load(movieItem.imageurl).into(imageView);

    }
}