package com.one.visionadmin.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cast(
    val name: String?,
    val image: String?
) : Parcelable