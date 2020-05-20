package com.example.triporganizer

import android.content.Context
import android.content.Intent
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

    lateinit var emailField: EditText
    lateinit var nameField: EditText
    lateinit var passwordField: EditText

    val ref = FirebaseDatabase.getInstance().getReference("User")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        emailField = findViewById(R.id.emailEditText)
        nameField = findViewById(R.id.nameEditText)
        passwordField = findViewById(R.id.passwordEditText)


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
                            nameField.text.toString(),
                            passwordField.text.toString()
                        )
                        ref.child(emailField.text.toString()).setValue(user)

                        Toast.makeText(applicationContext, "Sign up successful", Toast.LENGTH_SHORT).show()
                        isRegistered = true
                        save()
                        finish()
                        startActivity(Intent(this@RegistrationActivity, MainActivity::class.java))
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
        editor.putString("nameKey", nameField.text.toString())
        editor.apply()
    }


}
