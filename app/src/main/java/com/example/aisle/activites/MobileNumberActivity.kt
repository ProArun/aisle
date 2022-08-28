package com.example.aisle.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.aisle.databinding.ActivityMobileNumberBinding

import com.example.aisle.network.ApiInterface
import com.example.aisle.network.RemoteDataSource
import com.example.aisle.network.models.GetOtpResponse
import com.example.aisle.network.models.Mobile
import com.example.aisle.utils.Utils.isValidPhoneNumber
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MobileNumberActivity : AppCompatActivity() {
    private val TAG: String = "MobileNumberActivity";
    protected lateinit var binding: ActivityMobileNumberBinding
    protected val remoteDataSource = RemoteDataSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMobileNumberBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.continueButton.setOnClickListener(View.OnClickListener {
            val mobileNumber = binding.enterPhoneEditText.text.toString()
            if (mobileNumber.length < 10) {
                Toast.makeText(
                    this,
                    "Mobile number shouldn't be less than 10 digits!!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (mobileNumber.isValidPhoneNumber()) {
                    val call: Call<GetOtpResponse> =
                        remoteDataSource.buildApi(ApiInterface::class.java)
                            .getOTP(Mobile("+91$mobileNumber"))

                    call.enqueue(object : Callback<GetOtpResponse> {
                        override fun onResponse(
                            call: Call<GetOtpResponse>,
                            response: Response<GetOtpResponse>
                        ) {
                            val resbody = response.body()
                            if (resbody?.status != null) {
                                if (resbody.status!!) {
                                    val intent =
                                        Intent(this@MobileNumberActivity, OtpActivity::class.java)
                                    intent.putExtra("mobile", "+91$mobileNumber")
                                    startActivity(intent)
                                    Toast.makeText(
                                        this@MobileNumberActivity,
                                        "Success",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    Toast.makeText(
                                        this@MobileNumberActivity,
                                        "+91$mobileNumber is not registered!!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                            } else {
                                Toast.makeText(
                                    this@MobileNumberActivity,
                                    "Failure",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                        }

                        override fun onFailure(call: Call<GetOtpResponse>, t: Throwable) {

                            Log.d(TAG, "onFailure: Error in fetching otp")
                        }
                    })

                } else {
                    Toast.makeText(this, "Please Enter a valid Number!!", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }
}