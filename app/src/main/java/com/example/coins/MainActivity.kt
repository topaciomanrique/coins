package com.example.coins

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.example.coins.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var spCoins:Spinner?=null
    private var tvInstructions:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpAction()
        //spCoins=findViewById(R.id.spinner_coins)
        //tvInstructions=findViewById(R.id.tv_intruccions)

        val listCoins = arrayOf("Seleccione una moneda", "EUR", "USD", "BRL", "MXN")

        var adaptador:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_spinner_item,listCoins)
        binding.spinnerCoins.adapter=adaptador

        binding.spinnerCoins.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position>0){
                tvInstructions?.text=spCoins?.getSelectedItem().toString()
            }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

    }

    private fun setUpAction() {
        binding.btAceptar.setOnClickListener {
            startActivity(Intent(this, CurrencyDetailActivity::class.java))
        }
    }

}