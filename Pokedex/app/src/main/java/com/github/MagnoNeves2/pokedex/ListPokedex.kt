package com.github.MagnoNeves2.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import retrofit2.Call
import java.util.ArrayList
import retrofit2.Callback
import retrofit2.Response

class ListPokedex : AppCompatActivity() {

    //Implementando uma Recyclerview
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PokemonAdapter
    private var listaPokemons = ArrayList<Pokemon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pokedex)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        recyclerView = findViewById(R.id.rvListaPokemon)
        adapter = PokemonAdapter(listaPokemons)
        recyclerView.adapter = adapter
        //Linkando a RecyclerView ao adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this@ListPokedex)

    }

    override fun onResume() {
        super.onResume()

        CoroutineScope(IO).launch {
            respostaApi()
        }

    }

    private suspend fun respostaApi() {
        val res = buscarTodosPokemons()
        println("salve: $res")
    }

    private suspend fun buscarTodosPokemons(): ArrayList<Pokemon> {
        //Criando o serviço do Retrofit
        val retrofitClient = NetworkUtils.RetrofitConfig("https://pokeapi.co/api/v2/")

        //Serviços da API que irei consumir, aonde irei checar
        val endpoint = retrofitClient.create(PokemonService::class.java)

        //Irá realizar a chamada e esperar um retorno
        val callback = endpoint.buscarTodosPokemons()

        val lista = ArrayList<Pokemon>()

         callback.enqueue(
            object : Callback<ArrayList<Pokemon>> {
                override fun onResponse(call: Call<ArrayList<Pokemon>>, response: Response<ArrayList<Pokemon>>) {
                    response.body()?.let {
                        //listaPokemons.addAll(it)
                        //adapter.notifyDataSetChanged()
                        lista.addAll(it)
                    }
                }
                override fun onFailure(call: Call<ArrayList<Pokemon>>, t: Throwable) {
                    Toast.makeText(this@ListPokedex, "Ocorreu algum errro!", Toast.LENGTH_SHORT)
                }
            }
        )
        logSolicitacao("buscarTodosPokemons()")
        delay(1000)
        return lista
    }

    private fun logSolicitacao(metodo: String) {
        println("salve: ${metodo}: ${Thread.currentThread().name}")
    }
}