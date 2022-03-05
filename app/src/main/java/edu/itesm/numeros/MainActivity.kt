package edu.itesm.numeros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.itesm.numeros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(binding.root)
        //val es mutable
        //var no lo es
        val lista = mutableListOf<Int>()
        initUI(lista)
    }

    private fun initUI(lista: MutableList<Int>){
        binding.agregar.setOnClickListener {
            agregar(lista)
        }
        binding.promedio.setOnClickListener {
            promedio(lista)
        }

        binding.mayor.setOnClickListener {
            maximo(lista)
        }

        binding.pares.setOnClickListener {
            pares(lista)
        }
    }

    private fun agregar(lista: MutableList<Int>) {

        val numerosObtenidos = binding.editTextNumberSigned.text.toString()
        val numerosLista = numerosObtenidos.toIntOrNull()

        if (numerosLista == null) {

            Toast.makeText(this, "estoy dentro del boton", Toast.LENGTH_LONG).show()
            return
        }
        lista.add(numerosLista)
        binding.lista.text = "${lista}"
        binding.editTextNumberSigned.text.clear()

    }

    private fun promedio (lista: MutableList<Int>){

        val promedio = lista.average()
        binding.lista.text = " el promedio es : ${promedio}"
    }

    private fun maximo (lista: MutableList<Int>){

        if (lista == null)
            Toast.makeText(this, "error agrega elementos a la lista", Toast.LENGTH_LONG).show()
        val numeroMaximo = lista.maxOrNull()

        binding.lista.text = "el valor maximo ingresado es: ${numeroMaximo}"

    }

    private fun pares(lista: MutableList<Int>){

        for(elemento in lista){

            val numero = elemento

           val  par = numero % 2

            if(par == 0 ){

                binding.lista.text = "${par} "
            }

        }

    }
}