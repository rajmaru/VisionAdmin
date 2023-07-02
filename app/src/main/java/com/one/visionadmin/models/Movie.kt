package com.one.visionadmin.models

import android.os.Parcelable
import com.one.vision.models.Cast
import com.one.vision.models.Season
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Movie(
    val id: String?,
    val image: String?,
    val title: String?,
    val type: String?,
    val rating: String?,
    val year: String?,
    val duration : String?,
    val tags: ArrayList<String>?,
    val description: String?,
    val languages : ArrayList<String>?,
    val casts : ArrayList<Cast>?,
    val seasonsList: ArrayList<Season>?,
    val ottPlatform: String?,
    val isPrime: Boolean?
): Parcelable