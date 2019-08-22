package com.codelab.example.evosystems.DBHelper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.codelab.example.evosystems.Model.Person

class DBHelper(context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, DATABSE_VER) {
    companion object{
        private val DATABSE_VER = 1
        private val DATABASE_NAME = "EDMTDB.db"

        //table
        private val TABLE_EMPRESA="Person"
        private val COL_ID="Id"
        private val COL_DEPARTAMENTO="Name"
        private val COL_SIGLA="Email"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY = ("CREATE TABLE $TABLE_EMPRESA ($COL_ID INTEGER PRIMARY KEY,$COL_DEPARTAMENTO TEXT,$COL_SIGLA TEXT)")
        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_EMPRESA")
        onCreate(db)
    }

    //CRUD
    val allPerson:List<Person>
        get(){
            val lstPersons = ArrayList<Person>()
            val selectQuery ="SELECT * FROM $TABLE_EMPRESA"
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQuery,null)
            if (cursor.moveToFirst())
            {
                do {
                    val person= Person()
                    person.id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                    person.dep = cursor.getString(cursor.getColumnIndex(COL_DEPARTAMENTO))
                    person.sig = cursor.getString(cursor.getColumnIndex(COL_SIGLA))

                    lstPersons.add(person)
                }while(cursor.moveToNext())
            }
            db.close()
            return lstPersons
        }

    fun addPerson(person: Person)
    {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL_ID,person.id)
        values.put(COL_DEPARTAMENTO,person.dep)
        values.put(COL_SIGLA,person.sig)

        db.insert(TABLE_EMPRESA, null,values)
        db.close()
    }

    fun updatePerson(person: Person):Int
    {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL_ID,person.id)
        values.put(COL_DEPARTAMENTO,person.dep)
        values.put(COL_SIGLA,person.sig)

        return db.update(TABLE_EMPRESA, values,"$COL_ID=?", arrayOf(person.id.toString()))

    }

    fun deletePerson(person: Person)
    {
        val db = this.writableDatabase


        db.delete(TABLE_EMPRESA,"$COL_ID=?", arrayOf(person.id.toString()))
        db.close()

    }

}