package com.example.ligaapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueItem(
    val leagueName: String?, val leagueDescription: String?, val leagueImage: Int?
): Parcelable