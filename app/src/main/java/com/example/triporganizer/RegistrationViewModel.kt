package com.example.triporganizer

import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase

class RegistrationViewModel : ViewModel() {

    val ref = FirebaseDatabase.getInstance().getReference("User")

    fun addUser(e: String, n: String, p: String){
        var user = User(e, n, p)

        ref.child(e).setValue(user)

        // opens new fragment
    }

}