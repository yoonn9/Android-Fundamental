package com.example.intent

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Author(
    val quote: String?,
    val name: String?,
    val period:Int?,
    val periodEnd:Int?
): Parcelable
