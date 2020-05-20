package com.example.triporganizer

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MeFragment : Fragment() {

    val registrationActivity = RegistrationActivity()
    lateinit var nameOfUser: String
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_me, container, false)

        val textView = view.findViewById<TextView>(R.id.textview)
        val textView2 = view.findViewById<TextView>(R.id.noFav)
        recyclerView = view.findViewById(R.id.recyclerview_fav)

        loadUserName()
        textView.text = "Hi, $nameOfUser!"





  // if the user has fav trips

        /*
        textView2.text = "Review your favourite trips"
        buttonToTrips.isClickable = false
        buttonToTrips.visibility = View.INVISIBLE

         */






        return view
    }


    fun loadUserName(){
        val sh = activity?.getSharedPreferences(registrationActivity.SHARED_PREFS, AppCompatActivity.MODE_PRIVATE)

        nameOfUser = sh?.getString("nameKey", "").toString()

    }

    fun openTripFragment(){
        bottomNav.selectedItemId = R.id.trip_item
        activity?.supportFragmentManager?.
        beginTransaction()?.
        replace(R.id.frame, TripFragment())?.
        commit()
    }

    fun openSignUpFragment(){
        activity?.supportFragmentManager?.
        beginTransaction()?.
        replace(R.id.frame, SignUpFragment())?.
        commit()
    }

    /*
    fun saveIsRegisteredBoolean(){
        val shrpf = activity?.getSharedPreferences("sha", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = shrpf!!.edit()

        editor.putBoolean("registered", registrationActivity.isRegistered)
        editor.apply()
    }

     */

}