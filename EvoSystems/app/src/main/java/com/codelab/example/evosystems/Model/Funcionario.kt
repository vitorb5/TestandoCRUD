package com.codelab.example.evosystems.Model

class Funcionario {
    var idFunc:Int=0
    var idDepartamento:Int=0
    var nome:String?=null
    var rg:String?=null

    constructor(){}

    constructor(idFunc:Int, idDepartamento:Int, nome:String, rg:String)
    {
        this.idFunc=idFunc
        this.idDepartamento=idDepartamento
        this.nome=nome
        this.rg=rg
    }

}