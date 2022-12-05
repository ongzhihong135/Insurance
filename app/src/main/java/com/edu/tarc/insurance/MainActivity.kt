package com.edu.tarc.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.edu.tarc.insurance.databinding.ActivityMainBinding
import java.util.*

//, AdapterView.OnItemClickListener
class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.spinnerAge.setOnItemClickListener(this)
        binding.buttonCalculate.setOnClickListener {
            val age = binding.spinnerAge.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker =binding.checkBoxYesSmoker.isChecked


            var premiumPrice: Int = 0
            var malePrice:Int
            var smokerPrice:Int

            if(age ==0){
            //Less than 17
                premiumPrice= 60
            }
            when(age){
                1 -> {
                premiumPrice = 70
                }
                2 -> {
                premiumPrice = 90
                }
                3 -> {
                premiumPrice = 120
                }
                in 4..5 -> {
                premiumPrice = 150
                }
            }
            if(gender == R.id.radioButtonMale){
                //Calculate premium for male
                when(age){
                    1 -> {
                    premiumPrice += 50
                    }
                    2 -> {
                    premiumPrice += 100
                    }
                    3 -> {
                        premiumPrice += 150
                    }
                    in 4..5 -> {
                        premiumPrice += 200
                    }
                }
            }
            if(smoker) {
                //Calculate premium for a smoker
                when(age){
                    1 -> {
                        smokerPrice = 50
                    }
                    2 -> {
                        smokerPrice = 100
                    }
                    3 -> {
                        smokerPrice = 150
                    }
                    4 -> {
                        smokerPrice = 200
                    }
                    5 -> {
                        smokerPrice = 300
                    }
                }
            }
            //Display the final premium value

            val totalPrice = premiumPrice + malePrice + smokerPrice
            val myLocale = Locale.getDefault()
            val myCurrency = Currency.getInstance(myLocale)

            binding.textViewPremium.text = String.format("%s %d",
                myCurrency.currencyCode.toString(),
                premiumPrice)
        }
        binding.buttonReset.setOnClickListener {

        }
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        TODO("Not yet implemented")
    }
}