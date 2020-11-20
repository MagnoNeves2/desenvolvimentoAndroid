package com.github.MagnoNeves2.pokedex

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

class Pokemon(
        @SerializedName("order")
        val id: Int,
        @SerializedName("name")
        val nome: String,
        /*@SerializedName("types")
        val tipo: ArrayList<Objects>,
        @SerializedName("abilities")
        val habilidades: ArrayList<Objects>,
        @SerializedName("stats")
        val status: ArrayList<Objects>*/
)