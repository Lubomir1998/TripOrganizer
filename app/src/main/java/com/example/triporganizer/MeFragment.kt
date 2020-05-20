package com.example.triporganizer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_me.*

class MeFragment : Fragment() {

    val registrationActivity = RegistrationActivity()
    lateinit var nameOfUser: String



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_me, container, false)

        val textView = view.findViewById<TextView>(R.id.textview)

        // code here
        loadUserName()

        textView.text = "Hello $nameOfUser"



        return view
    }


    fun loadUserName(){
        val sh = activity?.getSharedPreferences(registrationActivity.SHARED_PREFS, AppCompatActivity.MODE_PRIVATE)

        nameOfUser = sh?.getString("nameKey", "").toString()

    }

}