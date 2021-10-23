package com.audronf.dndcompanion.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.audronf.dndcompanion.R

class HomeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar!!.hide()
    }

    companion object {
        fun start(context: Context) {
            with(Intent(context, HomeActivity::class.java)) {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                context.startActivity(this)
            }
        }
    }
}
