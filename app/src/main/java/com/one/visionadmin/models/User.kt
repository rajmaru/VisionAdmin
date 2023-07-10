package com.one.visionadmin.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val name: String?,
    val img: String?,
    val email: String?,
    val plan: String?,
    val watchlist: ArrayList<Movie>?
): Parcelable