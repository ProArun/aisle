package com.example.aisle.activites

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.aisle.R
import com.example.aisle.network.ApiInterface
import com.example.aisle.network.RemoteDataSource
import com.example.aisle.network.models.Otp
import com.example.aisle.network.models.VerifyOtpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OtpActivity : AppCompatActivity() {
    private val TAG: String = "OtpActivity";
    private lateinit var countDownTimerText: TextView
    private lateinit var resendOtpText: TextView
    private lateinit var otpMobileNumberText: TextView
    private lateinit var enterOtpEditText: EditText
    protected val remoteDataSource = RemoteDataSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        val continueButton: Button = findViewById(R.id.continue_otp_button)
        countDownTimerText = findViewById(R.id.count_down_timer_text)
        enterOtpEditText = findViewById(R.id.enter_otp_edit_text)
        resendOtpText = findViewById(R.id.resend_otp_text)
        otpMobileNumberText = findViewById(R.id.otp_mobile_number_text)
        val userMobile = intent.getStringExtra("mobile")

        otpMobileNumberText.text = userMobile.toString()

        timer.start()

        continueButton.setOnClickListener(View.OnClickListener {

            if (countDownTimerText.text.toString() == "00:00") {
                Toast.makeText(this, "Time Out", Toast.LENGTH_SHORT).show()
            } else {
                val call: Call<VerifyOtpResponse> =
                    remoteDataSource.buildApi(ApiInterface::class.java)
                        .verifyOtp(Otp("$userMobile", enterOtpEditText.text.toString()))

                call.enqueue(object : Callback<VerifyOtpResponse> {
                    override fun onResponse(
                        call: Call<VerifyOtpResponse>,
                        response: Response<VerifyOtpResponse>
                    ) {
                        val resbody = response.body()

                        if (resbody?.token != null) {
                            val sharedPreference =
                                getSharedPreferences("AISLE_PREFERENCE_DB", Context.MODE_PRIVATE)
                            val editor = sharedPreference.edit()
                            editor.putString("TOKEN", resbody.token.toString())
                            editor.apply().also {
                                Toast.makeText(
                                    this@OtpActivity,
                                    resbody.token.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(this@OtpActivity, MainActivity::class.java)
                                startActivity(intent)
                            }

                        } else {
                            Toast.makeText(this@OtpActivity, "", Toast.LENGTH_SHORT).show()
                        }

                    }

                    override fun onFailure(call: Call<VerifyOtpResponse>, t: Throwable) {
                        Log.d(TAG, "onFailure: Error while verifying otp")
                    }


                })

            }
        })

        resendOtpText.setOnClickListener(View.OnClickListener {
            timer.start()
            resendOtpText.visibility = View.GONE
        })

    }

    val timer = object : CountDownTimer(60000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            var remTime: Long = millisUntilFinished.div(1000)
            if (remTime > 10) {
                countDownTimerText.text = "00:$remTime"
            } else {
                countDownTimerText.text = "00:0$remTime"
            }
        }

        override fun onFinish() {
            countDownTimerText.text = "00:00"
            resendOtpText.visibility = View.VISIBLE
        }
    }

}