package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private var entradaEditText: EditText? = null
    private var resultadoTextView: TextView? = null
    private var calcularButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        entradaEditText = findViewById<EditText?>(R.id.editTextNumberDecimal)
        resultadoTextView = findViewById<TextView?>(R.id.textView2)
        calcularButton = findViewById<Button?>(R.id.button16)

        calcularButton!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                calcularResultado()
            }
        })
    }

    private fun calcularResultado() {
        val expresion = entradaEditText!!.getText().toString()

        try {
            val resultado = evaluarExpresion(expresion)
            resultadoTextView!!.setText("Resultado: " + resultado)
        } catch (e: Exception) {
            resultadoTextView!!.setText("Error: Expresión inválida")
        }
    }

    private fun evaluarExpresion(expresion: String?): Double {
        val expression: Expression = ExpressionBuilder(expresion).build()
        return expression.evaluate()
    }
}