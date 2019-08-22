package com.codelab.example.evosystems.Model

class Person {
    var id:Int=0
    var dep:String?=null
    var sig:String?=null

    constructor(){}

    constructor(id:Int, nome:String, departamento:String)
    {
        this.id=id
        this.dep=nome
        this.sig=departamento
    }

}