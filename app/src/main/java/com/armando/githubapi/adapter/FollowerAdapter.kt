package com.armando.githubapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.armando.githubapi.R
import com.armando.githubapi.data.User
import com.armando.githubapi.model.FollowersHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_follower.view.*
import kotlinx.android.synthetic.main.item_following.view.*
import kotlinx.android.synthetic.main.item_main.view.*

class FollowerAdapter (val context: Context) : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {

    private val followers:MutableList<FollowersHolder> = mutableListOf()
    fun setFollower(data:List<FollowersHolder>){
        followers.clear()
        followers.addAll(data)
        notifyDataSetChanged()

    }

    inner class FollowerViewHolder(item: View) : RecyclerView.ViewHolder(item){
        /*val ivAvatar: ImageView =item.findViewById(R.id.iv_following)*/
        var imageView:ImageView =item.iv_follower
        val txtLogin: TextView = item.tv_follower_login
        val txtHtml: TextView = item.findViewById(R.id.tv_follower_htmlUrl)


        /*fun bindModel(b: FollowersHolder){
            imageView = Glide.with(context).load(b.avatar_url).into(iv)
            txtLogin.text = b.login
            txtHtml.text = b.html_url

        }*/
        fun bindModel (b: FollowersHolder){
            with(itemView){
                Glide.with(this).load(b.avatar_url).into(iv_follower)
                txtLogin.text = b.login
                txtHtml.text =b.html_url
            }
        }

    }


    override fun getItemCount(): Int {
        return followers.size
    }

    override fun onBindViewHolder(holder: FollowerAdapter.FollowerViewHolder, position: Int) {
        holder.bindModel(followers[position])

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        return FollowerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_follower,parent,false))
    }


}