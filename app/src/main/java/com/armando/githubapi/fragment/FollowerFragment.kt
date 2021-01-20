package com.armando.githubapi.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.armando.githubapi.R
import com.armando.githubapi.adapter.FollowerAdapter
import com.armando.githubapi.model.FollowersHolder
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_follower.*
import kotlinx.android.synthetic.main.fragment_following.*
import okhttp3.*
import java.io.IOException


class FollowerFragment : Fragment() {

    lateinit var followerAdapter: FollowerAdapter
    var lm = LinearLayoutManager(activity)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_follower, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        getData()
    }


    @SuppressLint("UseRequireInsteadOfGet")
    fun initView(){
        rv_follower.layoutManager = lm
        followerAdapter = FollowerAdapter(activity!!)
        rv_follower.adapter = followerAdapter
    }

    private fun getData() {
        val request = Request.Builder()
            .url("https://api.github.com/users/edmt/followers")
            .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Failed", e.message.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body!!.string()
                val gson =GsonBuilder().create()
                val result = gson.fromJson(body,Array<FollowersHolder>::class.java).toList()


                activity!!.runOnUiThread {
                    /* iv_following. =result?.get(0)?.avatar_url.toString()*/
                    tv_follower.text = result.get(0).login.toString()
                    /*tv_following_htmlUrl.text = result[0].html_url.toString()*/
                    followerAdapter.setFollower(result)
                }
            }

        })

    }


}