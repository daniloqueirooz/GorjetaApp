package com.example.appgorjeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appgorjeta.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.text.NumberFormat.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        binding.ButtonCalcular.setOnClickListener { calculatetip() }
    }

    fun calculatetip() {
        val stringTextFiel = binding.EditText1.text.toString()
        val cost = stringTextFiel.toDoubleOrNull()
        if (cost == null) {
            binding.Resultado.text = ""
            return
        }
        val tipPercentage = when (binding.GroupRadio.checkedRadioButtonId) {
            R.id.vinteporcento -> 0.20
            R.id.dezoitoporcento -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        if (binding.interruptor.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = getCurrencyInstance().format(tip)
        binding.Resultado.text = getString(R.string.tip_amount, formattedTip)
    }
}
