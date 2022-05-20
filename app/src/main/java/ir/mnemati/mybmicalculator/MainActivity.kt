package ir.mnemati.mybmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtWeight:EditText = findViewById(R.id.txt_weight)
        val txtHeight:EditText = findViewById(R.id.txt_height)
        val btnRest:Button = findViewById(R.id.btn_reset)
        val btnCalcBmi: Button = findViewById(R.id.btn_calc)
        var tvResult:TextView = findViewById(R.id.tv_result)

        btnCalcBmi.setOnClickListener {
            if(txtWeight.text.isEmpty() or txtHeight.text.isEmpty()){
                Toast.makeText(this, "Enter Weight or Height value", Toast.LENGTH_LONG).show()
            }
            else{
                val weight:Double = txtWeight.text.toString().toDouble()
                val height:Double = txtHeight.text.toString().toDouble() / 100

                val bmi = weight / (height * height)

                when (bmi){
                    in 0.0..18.5 -> tvResult.text = "Status: " + "Under Weight \n" + "BMI = " + bmi.toString()
                    in 18.6..24.9 -> tvResult.text = "Status: " + "Normal Weight \n" + "BMI = " + bmi.toString()
                    in 25.0..30.0 -> tvResult.text = "Status: " + "Overweight \n" + "BMI = " + bmi.toString()
                    else -> tvResult.text = "Status: " + "Obese \n" + "BMI = " + bmi.toString()
                }
            }

        }

        btnRest.setOnClickListener {
            txtWeight.text.clear()
            txtHeight.text.clear()
            tvResult.text = ""
            txtWeight.requestFocus()
        }

    } // end of onCreate
} // end of class ManinActivity