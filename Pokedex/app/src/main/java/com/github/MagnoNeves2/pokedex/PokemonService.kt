package com.github.MagnoNeves2.pokedex

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.ArrayList

interface PokemonService {

    @GET("pokemon/{pokemon}")
    fun buscarPokemon(@Path("pokemon") pokemon: String) : Call<Pokemon>

    @GET("pokemon")
    fun buscarTodosPokemons() : Call<ArrayList<Pokemon>>
}