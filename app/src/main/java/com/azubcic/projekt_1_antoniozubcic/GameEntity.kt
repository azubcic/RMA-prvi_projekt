package com.azubcic.projekt_1_antoniozubcic

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GameEntity(
    val id: Int,
    val title: String,
    val short_description: String,
) : Serializable
