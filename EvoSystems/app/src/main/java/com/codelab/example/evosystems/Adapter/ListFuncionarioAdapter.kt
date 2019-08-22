package com.codelab.example.evosystems.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import com.codelab.example.evosystems.Model.Funcionario
import com.codelab.example.evosystems.Model.Person
import com.codelab.example.evosystems.R
import kotlinx.android.synthetic.main.row_layout.view.*
import kotlinx.android.synthetic.main.row_layout_funcionario.view.*

class ListFuncionarioAdapter(internal var activity: Activity,
                             internal var lstFuncionario:List<Funcionario>,
                             internal var edt_idFun: EditText,
                             internal var edt_iddDeparta: EditText,
                             internal var edt_nome: EditText,
                             internal var edt_rg: EditText):BaseAdapter() {


    internal var inflater:LayoutInflater

    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView:View
        rowView = inflater.inflate(R.layout.row_layout,null)

        rowView.txt_row_idFun.text = lstFuncionario[position].idFunc.toString()
        rowView.txt_row_idDeparta.text = lstFuncionario[position].idDepartamento.toString()
        rowView.txt_nome.text = lstFuncionario[position].nome.toString()
        rowView.txt_rg.text = lstFuncionario[position].rg.toString()

        //event
        rowView.setOnClickListener {
            edt_idFun.setText(rowView.txt_row_idFun.text.toString())
            edt_iddDeparta.setText(rowView.txt_row_idDeparta.text.toString())
            edt_nome.setText(rowView.txt_nome.text.toString())
            edt_rg.setText(rowView.txt_rg.text.toString())
        }
        return rowView
    }


    override fun getItem(position: Int): Any {
        return lstFuncionario [position]
    }

    override fun getItemId(position: Int): Long {
        return lstFuncionario[position].idFunc.toLong()
    }

    override fun getCount(): Int {
        return lstFuncionario.size
    }


}