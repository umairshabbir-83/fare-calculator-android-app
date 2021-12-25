package com.example.farecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.farecalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Calculate.setOnClickListener { CalculateFare() }
    }

    private fun CalculateFare() {

        val kms = binding.Kilometers.text.toString()
        val distance = kms.toDouble()

        val avg = binding.Mileage.text.toString()
        val average = avg.toDouble()

        val rs = binding.Price.text.toString()
        val petrol = rs.toDouble()

        val myExpense =
            (distance.toBigDecimal().div(average.toBigDecimal())) * petrol.toBigDecimal()
        val fare = myExpense + myExpense

        val formattedFare = NumberFormat.getCurrencyInstance().format(fare)
        binding.Fare.text = getString(R.string.Total, formattedFare)
    }

}