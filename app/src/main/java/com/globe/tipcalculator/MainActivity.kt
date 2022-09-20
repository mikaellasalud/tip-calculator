package com.globe.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var etAmount: EditText
    private lateinit var seekBar: SeekBar
    private lateinit var tvTipPercent: TextView
    private lateinit var tvTip: TextView
    private lateinit var tvTotal: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etAmount = findViewById(R.id.etAmount)
        seekBar = findViewById(R.id.seekBar)
        tvTipPercent = findViewById(R.id.tvTipPercent)
        tvTip = findViewById(R.id.tvTip)
        tvTotal = findViewById(R.id.tvTotal)

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
            }
        })
    }

    private fun addSeekBarListener() {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                tvTipPercent.text = "$progress%"

                computeTip()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    private fun computeTip(){
        val amount: Double = etAmount.text.toString().toDoubleOrNull() ?: 0.0
        val percentage: Int = seekBar.progress

        val tip = amount * (percentage/100.0)
        val total = amount + tip

        tvTip.text = "%.2f".format(tip)
        tvTotal.text = "%.2f".format(total)
    }
}
