package com.codelab.example.evosystems

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.codelab.example.evosystems.Adapter.ListPersonAdapter
import com.codelab.example.evosystems.DBHelper.DBHelper
import com.codelab.example.evosystems.Model.Person
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal lateinit var db:DBHelper
    internal var lstPersons:List<Person> = ArrayList<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_cada_func.setOnClickListener {
            val cadastrarIntent = Intent (this, SecondActivity :: class.java)
            startActivity(cadastrarIntent)
        }

        db = DBHelper(this)

        refreshDate()

        //Event
        btn_adcionar.setOnClickListener {
            val person = Person(
                Integer.parseInt(edt_id.text.toString()),
                edt_departamento.text.toString(),
                edt_sigla.text.toString()
            )
            db.addPerson(person)
            refreshDate()
        }

        btn_atualizar.setOnClickListener {
            val person = Person(
                Integer.parseInt(edt_id.text.toString()),
                edt_departamento.text.toString(),
                edt_sigla.text.toString()
            )
            db.updatePerson(person)
            refreshDate()
        }

        btn_deletar.setOnClickListener {
            val person = Person(
                Integer.parseInt(edt_id.text.toString()),
                edt_departamento.text.toString(),
                edt_sigla.text.toString()
            )
            db.deletePerson(person)
            refreshDate()
        }

    }

    private fun refreshDate() {
        lstPersons = db.allPerson
        val adapeter = ListPersonAdapter(this@MainActivity,lstPersons,edt_id,edt_departamento,edt_sigla)
        list_persons.adapter = adapeter
    }
}
