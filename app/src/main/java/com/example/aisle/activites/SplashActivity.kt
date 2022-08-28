package com.example.aisle.activites

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.example.aisle.R

class SplashActivity : AppCompatActivity() {

    private val TAG: String = "SplashActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val sharedPreference = getSharedPreferences("AISLE_PREFERENCE_DB", Context.MODE_PRIVATE)
        val token = sharedPreference.getString("TOKEN", "aisle")
        Log.d(TAG, "onCreate: Authentication token token:- $token")

        Handler().postDelayed({
            val intent: Intent
            if (token == "aisle") {
                intent = Intent(this, MobileNumberActivity::class.java)
            } else {
                intent = Intent(this, MainActivity::class.java)
            }

            startActivity(intent)
            finish()
        }, 2000)
    }
}