package com.audronf.dndcompanion.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.audronf.dndcompanion.R

class DiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)
    }
    companion object {
        fun start(context: Context) {
            with(Intent(context, DiceActivity::class.java)) {
                context.startActivity(this)
            }
        }
    }
}
