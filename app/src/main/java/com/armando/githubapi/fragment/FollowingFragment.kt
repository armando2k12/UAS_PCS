package com.armando.githubapi.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.armando.githubapi.R
import com.armando.githubapi.adapter.FollowingAdapter
import com.armando.githubapi.model.FollowingHolder
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_following.*
import kotlinx.android.synthetic.main.item_following.*
import okhttp3.*
import java.io.IOException

class FollowingFragment : Fragment() {

    lateinit var followingAdapter: FollowingAdapter
    var lm = LinearLayoutManager(activity)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_following, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        getData()
    }


    @SuppressLint("UseRequireInsteadOfGet")
    fun initView(){
        rv_following.layoutManager = lm
        followingAdapter = FollowingAdapter(activity!!)
        rv_following.adapter = followingAdapter
    }

    private fun getData() {
        val request = Request.Builder()
            .url("https://api.github.com/users/edmt/following")
            .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Failed", e.message.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body!!.string()
                val gson =GsonBuilder().create()
                val result = gson.fromJson(body,Array<FollowingHolder>::class.java).toList()


                activity!!.runOnUiThread {
                  /* iv_following. =result?.get(0)?.avatar_url.toString()*/
                    tv_following.text = result.get(0).login.toString()
                    /*tv_following_htmlUrl.text = result[0].html_url.toString()*/
                    followingAdapter.setFollowing(result)
                }
            }

        })

    }


}