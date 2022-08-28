package com.example.aisle.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aisle.R
import com.example.aisle.activites.MobileNumberActivity
import com.example.aisle.adapters.UserAdapter
import com.example.aisle.models.UserProfile
import com.example.aisle.network.ApiInterface
import com.example.aisle.network.RemoteDataSource
import com.example.aisle.repository.UserRepository
import com.example.aisle.viewModels.UserViewModel
import com.example.aisle.viewModels.ViewModelFactory
import com.squareup.picasso.Picasso

class DiscoverFragment : Fragment() {
    private val TAG: String = "DiscoverFragment";
    lateinit var userRecyclerView: RecyclerView
    lateinit var logOutImg: ImageView
    lateinit var roundedImageView: ImageView
    lateinit var upgradeButton: Button
    lateinit var userFirstNameAgeText: TextView
    lateinit var userProfile: UserProfile

    private lateinit var userViewModel: UserViewModel

    protected val remoteDataSource = RemoteDataSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_discover, container, false)
        userRecyclerView = root.findViewById(R.id.idGRV)
        logOutImg = root.findViewById(R.id.log_out_img)
        roundedImageView = root.findViewById(R.id.roundedImageView)
        upgradeButton = root.findViewById(R.id.upgrade_button)
        userFirstNameAgeText = root.findViewById(R.id.user_first_name_age_text)

        val userRepository = UserRepository(remoteDataSource.buildApi(ApiInterface::class.java))

        val sharedPreference =
            activity?.getSharedPreferences("AISLE_PREFERENCE_DB", Context.MODE_PRIVATE)
        val token = sharedPreference?.getString("TOKEN", "aisle")

        userViewModel = ViewModelProvider(
            this,
            ViewModelFactory(userRepository, token.toString())
        ).get(UserViewModel::class.java)

        userViewModel.profileData.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onCreateView: ${it.toString()} ")
            userProfile = it
            Picasso.get()
                .load(it.invites!!.profiles[0].photos[0].photo.toString())
                .into(roundedImageView)
            userFirstNameAgeText.text = "${it!!.invites!!.profiles[0].generalInformation!!.firstName},${it!!.invites!!.profiles[0].generalInformation!!.age}"

            userRecyclerView.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(context, 2)
                adapter = UserAdapter(it.likes!!.profileOfUsers)
            }
        })

        logOutImg.setOnClickListener(View.OnClickListener {
            val sharedPreference =
                requireContext().getSharedPreferences("AISLE_PREFERENCE_DB", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.remove("TOKEN")
            editor.apply()
            Toast.makeText(
                requireContext(),
                "You are successfully logout\nThanks for using Aisle",
                Toast.LENGTH_SHORT
            ).show()
            Handler().postDelayed({
                activity?.let {
                    val intent = Intent(it, MobileNumberActivity::class.java)
                    it.startActivity(intent)
                    it.finishAffinity()
                }
            }, 3000)
        })

        upgradeButton.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                requireContext(),
                "Thank you for showing interest\n Our team will connect you soon",
                Toast.LENGTH_SHORT
            ).show()
        })
        return root;
    }


}
