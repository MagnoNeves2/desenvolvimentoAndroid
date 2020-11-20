package com.github.MagnoNeves2.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), Runnable {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        GlobalScope.launch {
            delay(2500)
            this@MainActivity.irParaSegundaTela()
        }

    }

    override fun run() {
       irParaSegundaTela()
    }

    private fun irParaSegundaTela() {
        val segundaTela = Intent(this, InsertNameActivity::class.java)
        startActivity(segundaTela)
    }

}