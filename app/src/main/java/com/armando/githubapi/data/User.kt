package com.armando.githubapi.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class User (

    val login: String,
    val avatarUrl: String,
    val htmlUrl: String,
    val followersUrl: String,
    val followers: Int,
    val followingUrl: String,
    val following: Int,
    val repoUrl: String,
    val repos: Int

) : Parcelable