package com.example.coins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var spCoins:Spinner?=null
    private var tvInstructions:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spCoins=findViewById(R.id.spinner_coins)
        tvInstructions=findViewById(R.id.tv_intruccions)

        val listCoins = arrayOf("Seleccione una moneda", "EUR", "USD", "BRL", "MXN")

        var adaptador:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_spinner_item,listCoins)
        spCoins?.adapter=adaptador

        spCoins?.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tvInstructions.text=spCoins.getSelectedItem().
                TODO("Not yet implemented")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }
}