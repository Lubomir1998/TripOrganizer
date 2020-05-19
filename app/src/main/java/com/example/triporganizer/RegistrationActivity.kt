package com.example.triporganizer

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    var isRegistered: Boolean = false
    val SHARED_PREFS: String = "shared_prefs"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val emailField: EditText = findViewById(R.id.emailEditText)
        val nameField: EditText = findViewById(R.id.nameEditText)
        val passwordField: EditText = findViewById(R.id.passwordEditText)

        val ref = FirebaseDatabase.getInstance().getReference("User")


        registerbtn.setOnClickListener {
            // register the new user

            ref.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {

                    if (emailField.text.trim().isEmpty() || nameField.text.trim().isEmpty() || passwordField.text.trim().isEmpty()) {
                        Toast.makeText(applicationContext, "All fields must be filled", Toast.LENGTH_SHORT).show()
                    }
                    else if (dataSnapshot.child(emailField.text.toString()).exists()) {
                        Toast.makeText(applicationContext, "User already exists", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        val user = User(
                            emailField.text.toString(),
                            nameField.text.toString(),
                            passwordField.text.toString()
                        )
                        ref.child(emailField.text.toString()).setValue(user)
                        Toast.makeText(applicationContext, "Sign up successful", Toast.LENGTH_SHORT).show()
                        isRegistered = true
                        save()
                        finish()
                        openMeFragment()
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {

                }
            })


        }
        // oncreate



    }

    fun save(){
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        editor.putBoolean("regKey", isRegistered)
        editor.apply()
    }


    fun openMeFragment(){
        supportFragmentManager.
        beginTransaction().
        replace(R.id.frame, MeFragment()).
        commit()
    }


}
