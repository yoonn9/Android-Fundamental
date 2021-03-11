package com.example.recyclerview.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(
    var image: Int,
    var quote: String,
    var title: String
) : Parcelable