package com.example.aula04.model

class Moto(
    var cilindradas: String,
    var bauExiste: Boolean
) {
    constructor(cilindradas: String,
                bauexiste: Boolean,
                cor: String,
                fabricante: String,
                qtdRodas : Int,
                capacidadeTanque : Double,
                lugares:Int
    ){
        this.cilindradas = cilindradas
        this.bauExiste = bauexiste
        super(cor, fabricante, qtdRodas, capacidadeTanque, lugares)

        //@Override
        override fun buzinar() : String{
            return ""
        }
    }