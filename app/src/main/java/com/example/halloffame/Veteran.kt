package com.example.halloffame

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Veteran(
    val id: Long,
    val name: String,
    @DrawableRes
    val image: Int,
    val description: String
): Parcelable