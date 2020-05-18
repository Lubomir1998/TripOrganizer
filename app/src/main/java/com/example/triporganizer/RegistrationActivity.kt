package com.example.triporganizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    lateinit var registrationViewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        registerbtn.setOnClickListener {
            // register the new user
            registrationViewModel.addUser(emailEditText.text.toString(), nameEditText.text.toString(), passwordEditText.text.toString())
        }

    }


}
