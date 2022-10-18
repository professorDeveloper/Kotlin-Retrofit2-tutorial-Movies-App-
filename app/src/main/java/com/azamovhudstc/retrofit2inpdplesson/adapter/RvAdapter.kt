package com.azamovhudstc.retrofit2inpdplesson.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.R
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.retrofit2inpdplesson.AboutActivity
import com.azamovhudstc.retrofit2inpdplesson.model.MovieItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class RvAdapter(var context: Context,var arrayList: List<MovieItem>) : RecyclerView.Adapter<RvAdapter.Wh>() {
    inner class Wh(var itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun onBind(movieItem: MovieItem) {
            itemView.filmDes.text = "${movieItem.name}\n${movieItem.publisher} ${movieItem.createdby}"
            val trimStart = itemView.filmDes.text.trimStart()
            itemView.filmName.text = movieItem.name
            Picasso.get().load(movieItem.imageurl).into(itemView.film_image);
            itemView.setOnClickListener {
                var intent=Intent(context,AboutActivity::class.java)
                var bundle = Bundle()
                bundle.putSerializable("data",movieItem)
                intent.putExtras(bundle)
                context.startActivity(intent)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Wh {
        return Wh(
            LayoutInflater.from(parent.context)
                .inflate(com.azamovhudstc.retrofit2inpdplesson.R.layout.item_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Wh, position: Int) {
        holder.onBind(movieItem = arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}