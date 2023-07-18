package com.example.cl.ejercicio14kotlinandroidmodulo5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.cl.ejercicio14kotlinandroidmodulo5.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var saldo =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOK.setOnClickListener{
         when(binding.radioGroup.checkedRadioButtonId){
             R.id.radioButtonSaldo ->
                 binding.txtIngresar.setText(saldo.toString())
             R.id.radioButtonIngresar -> ingresarSaldo()
             R.id.radioButtonRetirar -> retirarSaldo()
             R.id.radioButtonSalir -> salir()

         }
        }
    }

    private fun salir() {
     System.exit(0)
    }

    private fun retirarSaldo() {
        if(saldo- binding.txtIngresar.text.toString().toInt()<0){
            Toast.makeText(applicationContext,"saldo insuficiente",Toast.LENGTH_LONG).show()
            return
        }
        saldo -= binding.txtIngresar.text.toString().toInt()
        Toast.makeText(applicationContext,"su saldo a sido actualizado correctamente",Toast.LENGTH_LONG).show()
    }

    fun ingresarSaldo(){
        if(binding.txtIngresar.text.isEmpty()){
            Toast.makeText(applicationContext,"no a ingresado ningun valor",Toast.LENGTH_LONG).show()
            return
        }
    saldo += binding.txtIngresar.text.toString().toInt()
    Toast.makeText(applicationContext,"su saldo a sido actualizado correctamente",Toast.LENGTH_LONG).show()
}
}