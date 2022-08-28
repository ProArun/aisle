package com.example.aisle.activites

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aisle.R
import com.example.aisle.databinding.ActivityMainBinding
import com.example.aisle.fragments.DiscoverFragment
import com.example.aisle.fragments.MatchesFragment
import com.example.aisle.fragments.NotesFragment
import com.example.aisle.fragments.ProfileFragment
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var firstBackPressed: Boolean = false
    private var firstTimestamp: Long = System.currentTimeMillis()
    private var secondTimestamp: Long = 0
    val timer = object : CountDownTimer(5000, 1000) {

        override fun onTick(millisUntilFinished: Long) {

        }

        override fun onFinish() {
            firstBackPressed = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(DiscoverFragment())
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.discover -> replaceFragment(DiscoverFragment())
                R.id.notes -> replaceFragment(NotesFragment())
                R.id.matches -> replaceFragment(MatchesFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
            }
            return@setOnItemSelectedListener true
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }


    override fun onBackPressed() {
        if (!firstBackPressed) {
            timer.start()
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show()
            firstTimestamp = System.currentTimeMillis()
            secondTimestamp = 0
            firstBackPressed = true
        } else {
            secondTimestamp = System.currentTimeMillis()
            val diff: Long = secondTimestamp - firstTimestamp
            val seconds = diff / 1000
            if (seconds < 5) {
                finishAffinity()
            } else {
                Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show()
            }
        }
    }
}