package com.example.ainfo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ainfo.R
import com.example.ainfo.model.Top
import com.example.ainfo.model.TopModel
import kotlinx.android.synthetic.main.anime_list.view.*

    class RecyclerViewAdapter(private var context: FragmentActivity?,private var dataList:ArrayList<Top>):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
        override fun getItemCount(): Int {
            return dataList.size;
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.anime_list, parent, false))
        }

        override fun onBindViewHolder(holder:ViewHolder, position: Int) {
//            holder.textView.text=dataList[position].title
            Glide.with(holder.itemView.context)
                .load(dataList[position].image_url)
                .into(  holder.textView)
        }
        fun updatelist(list:List<Top>){
            dataList.addAll(list)
            notifyDataSetChanged()

        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var textView: ImageView =itemView.findViewById(R.id.title)
        }
    }