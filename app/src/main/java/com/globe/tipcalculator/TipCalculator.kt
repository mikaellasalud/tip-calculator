/*package com.globe.tipcalculator

import android.graphics.Color
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*fun main() {
    //call the mainactivity for the etAmount etc.
}*/

class tipCalculator {

    var tip: Double? = null
    var tipDescription = ""

    fun computeTip() {
        val amount: Double = etAmount.text.toString().toDoubleOrNull() ?: 0.0
        val percentage: Int = seekBar.progress

        val tip = amount * (percentage / 100.0)
        val total = amount + tip
        var tipDescription = ""

        tvTip.text = "%.2f".format(tip)
        tvTotal.text = "%.2f".format(total)

        tipDescription = when (percentage!!.toInt()) {
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
}*/