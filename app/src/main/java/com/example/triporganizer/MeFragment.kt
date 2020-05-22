package com.example.triporganizer


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class MeFragment : Fragment() {

    private val registrationActivity = RegistrationActivity()
    lateinit var nameOfUser: String
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_me, container, false)

        (activity as? AppCompatActivity)?.supportActionBar?.hide()

        val textView = view.findViewById<TextView>(R.id.textview)
        val textView2 = view.findViewById<TextView>(R.id.noFav)
        recyclerView = view.findViewById(R.id.recyclerview_fav)


        loadUserName()
        textView.text = "Hi, $nameOfUser!"




  // if the user has fav trips

        /*
        textView2.text = "Review your favourite trips"

         */






        return view
    }




    fun loadUserName(){
        val sh = activity?.getSharedPreferences(registrationActivity.SHARED_PREFS, AppCompatActivity.MODE_PRIVATE)

        nameOfUser = sh?.getString("nameKey", "").toString()

    }


}