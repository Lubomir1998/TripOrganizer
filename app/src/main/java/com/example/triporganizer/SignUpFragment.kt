package com.example.triporganizer

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        btnSignUp.setOnClickListener {
            startActivity(Intent(activity, RegistrationActivity::class.java))
        }

        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

}