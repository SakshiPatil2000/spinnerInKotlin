package com.example.spinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var spinner:Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner=findViewById(R.id.spinner)

        val listItems= listOf("Chocolates","Vanilla","ButterScotch","Blue Berry","Strawberry","Mango")

        val arrayAdapter=ArrayAdapter(this, android.R.layout.simple_spinner_item, listItems)

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter=arrayAdapter

        spinner.onItemSelectedListener =object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItems = parent?.getItemIdAtPosition(position).toString()
                Toast.makeText(
                    this@MainActivity,
                    "You have clicked $selectedItems flavor ",
                    Toast.LENGTH_SHORT
                ).show()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            }
        }

    }
}