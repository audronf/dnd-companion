package com.audronf.dndcompanion.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.audronf.dndcompanion.R
import com.audronf.dndcompanion.ui.home.HomeActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        CoroutineScope(Dispatchers.IO).launch {
            delay(3000L)
        }.invokeOnCompletion {
            HomeActivity.start(this)
        }
    }
}
