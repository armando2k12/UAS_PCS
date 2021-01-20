package com.armando.githubapi.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.armando.githubapi.fragment.FollowerFragment
import com.armando.githubapi.fragment.FollowingFragment

class MyPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                FollowerFragment ()
            }
            else -> {
                FollowingFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Followers"
            else -> {
                return "Following"
            }
        }
    }

}