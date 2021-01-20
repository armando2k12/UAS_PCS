package com.armando.githubapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.armando.githubapi.adapter.MyPagerAdapter
import com.bumptech.glide.Glide.init
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_main.*

class DetailActivity : AppCompatActivity() {

    var b : Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.apply {
            elevation =0f
            title =""
        }


        var intent = getIntent()
        val itemAvatar = intent.getStringExtra("avatarUrl")

        initView()

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        detailPager.adapter = fragmentAdapter

        detailTab.setupWithViewPager(detailPager)
    }

    private fun initView() {
        b = intent.extras

        detailLogin.text =b?.getString("login")
        detailUrl.text = b?.getString("htmlUrl")
    }
}