package com.example.teste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val res = listOf("Sim", "Não conte com isso!", "Talvez")
        val random = Random.Default
        val campo = findViewById<EditText>(R.id.editText)
        val btn = findViewById<Button>(R.id.button)
        val mensagemExibida = findViewById<TextView>(R.id.textView)

        btn.setOnClickListener {
            if(campo.text.isEmpty()) {
                mensagemExibida.text = "Faça uma pergunta!"
            } else {
                val index = random.nextInt(3)
                mensagemExibida.text = res[index]
            }
        }

    }
}