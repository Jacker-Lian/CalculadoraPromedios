package com.example.calculadorapromedios

import androidx.appcompat.app.AppCompatActivity
import com.example.calculadorapromedios.viewModel.MainViewModel
import androidx.activity.viewModels
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import android.widget.EditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import kotlin.getValue
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun  onCreate(savedInstantState: Bundle?) {
        super.onCreate(savedInstantState)
        setContentView(R.layout.activity_main)

        val num1EditText = findViewById<EditText>(R.id.etCalificacion1)
        val num2EditText = findViewById<EditText>(R.id.etCalificacion2)
        val num3EditText = findViewById<EditText>(R.id.etCalificacion3)
        val calculateButton = findViewById<Button>(R.id.btnCalcular)
        val resultTextView = findViewById<TextView>(R.id.tvResult)

        viewModel.promedio.observe(this,Observer { promedio ->
            resultTextView.text = "Resultado: ${String.format("%.2f", promedio)}"
        })
        viewModel.guardarMensaje.observe(this,Observer{message ->
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        })
            calculateButton.setOnClickListener{
            try{
                val n1 = num1EditText. text.toString().toDouble()
                val n2 = num2EditText. text.toString().toDouble()
                val n3 = num3EditText. text.toString().toDouble()
                viewModel.calcularPromedio(n1, n2, n3)

            }
            catch (e: Exception){
                Toast.makeText(this, "iNGRESE LOS VALORES", Toast.LENGTH_LONG).show()
            }

    }
}
}