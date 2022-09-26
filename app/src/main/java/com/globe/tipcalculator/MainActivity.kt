package com.globe.tipcalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

/*fun main() {

    TipCalculator.computeTip()
}*/

class MainActivity : AppCompatActivity() {

    private lateinit var etAmount: EditText
    private lateinit var seekBar: SeekBar
    private lateinit var tvTipPercent: TextView
    private lateinit var tvTip: TextView
    private lateinit var tvTotal: TextView
    private lateinit var tvDescriber: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etAmount = findViewById(R.id.etAmount)
        seekBar = findViewById(R.id.seekBar)
        tvTipPercent = findViewById(R.id.tvTipPercent)
        tvTip = findViewById(R.id.tvTip)
        tvTotal = findViewById(R.id.tvTotal)
        tvDescriber = findViewById(R.id.tvDescriber)

        addEditTextListener()
        addSeekBarListener()
    }

    private fun addEditTextListener() {
        etAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                computeTip()
                //tipCalculator().computeTip()

            }
        })
    }

    private fun addSeekBarListener() {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                tvTipPercent.text = "$progress%"
                //tipCalculator().computeTip()

                computeTip()
                //getTipDescription()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }
        var tipDescription = ""

        fun computeTip() {
            val amount: Double = etAmount.text.toString().toDoubleOrNull() ?: 0.0
            val percentage: Int = seekBar.progress

            val tip = amount * (percentage / 100.0)
            val total = amount + tip

            tvTip.text = "%.2f".format(tip)
            tvTotal.text = "%.2f".format(total)


            tipDescription = when (percentage) {
                in 0..9 -> "Poor"
                in 10..15 -> "Good"
                in 16..20 -> "Great"
                else -> "Generous"
            }
            when (tipDescription) {
                in "Poor" -> tvDescriber.setTextColor(Color.parseColor("#FF6B4C")).toString()
                in "Good" -> tvDescriber.setTextColor(Color.parseColor("#F4F540")).toString()
                in "Great" -> tvDescriber.setTextColor(Color.parseColor("#3DEF65")).toString()
                else -> tvDescriber.setTextColor(Color.parseColor("#11CE3E")).toString()
            }
            tvDescriber.text = tipDescription

        }
    }

