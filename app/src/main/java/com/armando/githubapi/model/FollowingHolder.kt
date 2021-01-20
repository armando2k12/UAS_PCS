package com.armando.githubapi.model


import com.google.gson.annotations.SerializedName

class FollowingHolder {
        var login :String? = null
        var id :Int? = null
        var node_id:String? =null
        var avatar_url:String? = null
        var gravatar_id:String =""
        var url: String? = null
        var html_url:String? = null
        var follower_url:String? =null
        var following_url :String? =null
        var gists_url:String? =null
        var starred_url:String? = null
        var subscription_utl:String? =null
        var organizations_url:String? =null
        var repos_url:String? =null
        var events_url:String? =null
        var received_events_url:String? =null
        var type:String? =null
        var site_admin:Boolean = false
}