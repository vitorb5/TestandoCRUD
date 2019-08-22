package com.codelab.example.evosystems.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import com.codelab.example.evosystems.Model.Person
import com.codelab.example.evosystems.R
import kotlinx.android.synthetic.main.row_layout.view.*

class ListPersonAdapter(internal var activity: Activity,
                        internal var lstPerson:List<Person>,
                        internal var edt_id: EditText,
                        internal var edt_departamento: EditText,
                        internal var edt_sigla: EditText):BaseAdapter() {

    internal var inflater:LayoutInflater

    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView:View
        rowView = inflater.inflate(R.layout.row_layout,null)

        rowView.txt_row_id.text = lstPerson[position].id.toString()
        rowView.txt_departamento.text = lstPerson[position].dep.toString()
        rowView.txt_sigla.text = lstPerson[position].sig.toString()

        //event
        rowView.setOnClickListener {
            edt_id.setText(rowView.txt_row_id.text.toString())
            edt_departamento.setText(rowView.txt_departamento.text.toString())
            edt_sigla.setText(rowView.txt_sigla.text.toString())
        }
        return rowView
    }

    override fun getItem(position: Int): Any {
        return lstPerson[position]
    }

    override fun getItemId(position: Int): Long {
        return lstPerson[position].id.toLong()
    }

    override fun getCount(): Int {
        return lstPerson.size
    }

}