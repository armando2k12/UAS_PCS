package com.armando.githubapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.armando.githubapi.R
import com.armando.githubapi.model.FollowersHolder
import com.armando.githubapi.model.FollowingHolder
import com.armando.githubapi.model.MyHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.ImageViewTarget
import kotlinx.android.synthetic.main.item_follower.view.*
import kotlinx.android.synthetic.main.item_following.view.*


class FollowingAdapter (val context: Context) : RecyclerView.Adapter<FollowingAdapter.FollowingViewHolder>() {

    private val followings:MutableList<FollowingHolder> = mutableListOf()
    fun setFollowing(data:List<FollowingHolder>){
        followings.clear()
        followings.addAll(data)
        notifyDataSetChanged()

    }

    inner class FollowingViewHolder(item: View) : RecyclerView.ViewHolder(item){
        /*val ivAvatar: ImageView =item.findViewById(R.id.iv_following)*/
        val imageView:ImageView =item.iv_following
       val txtLogin: TextView = item.tv_following_login
        val txtHtml: TextView = item.findViewById(R.id.tv_following_htmlUrl)


        /*fun bindModel(b:FollowingHolder){
            *//*Glide.with(context).load(b.avatar_url).into(R.id.iv_following)*//*
            *//*ivAvatar.image= b.avatar_url.toString()*//*

            txtLogin.text = b.login
            txtHtml.text = b.html_url
        }*/
        fun bindModel (b: FollowingHolder){
            with(itemView){
                Glide.with(this).load(b.avatar_url).into(iv_following)
                txtLogin.text = b.login
                txtHtml.text =b.html_url
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingViewHolder {
        return FollowingViewHolder(LayoutInflater.from(context).inflate(R.layout.item_following,parent,false))
    }

    override fun getItemCount(): Int {
        return followings.size
    }

    override fun onBindViewHolder(holder: FollowingViewHolder, position: Int) {
        holder.bindModel(followings[position])

    }


}