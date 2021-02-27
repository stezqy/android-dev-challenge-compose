package com.example.androiddevchallenge.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PuppyItem(
    val id: String,
    val name: String? = null,
    val image: String? = null,
    val description: String? = null,
    val gender: Gender = Gender.Female,
    val publishTime: Long? = null,
    val from: String? = null
): Parcelable

enum class Gender {
    Female,
    Male
}