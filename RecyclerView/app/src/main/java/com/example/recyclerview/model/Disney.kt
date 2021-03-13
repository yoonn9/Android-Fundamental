package com.example.recyclerview.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Disney(
    var image: Int,
    var quote: String,
    var title: String
) : Parcelable