package com.github.MagnoNeves2.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide

class InsertNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_name)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        val gif = findViewById<ImageView>(R.id.gif)
        val btnVamos = findViewById<Button>(R.id.btnGo)
        val nomeInserido = findViewById<EditText>(R.id.edtInsertName)

        Glide.with(this)
                .load(R.drawable.img_insert_name)
                .asGif()
                .into(gif)

        btnVamos.setOnClickListener {
            val nomeAventureiro = nomeInserido.text.toString()
            nomeAventureiro?.let {
                irParaTerceiraTela(nomeAventureiro)
            }
        }
    }


    fun irParaTerceiraTela(nome: String) {
        val terceiraTela = Intent(this, Welcome::class.java).apply {
            putExtra("NOME", nome)
        }
        startActivity(terceiraTela)
    }
}