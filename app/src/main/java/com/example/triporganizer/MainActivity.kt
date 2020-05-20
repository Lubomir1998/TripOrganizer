package com.example.triporganizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var registrationActivity = RegistrationActivity()
    var a: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav.selectedItemId = R.id.explore_item

        supportFragmentManager.
        beginTransaction().
        replace(R.id.frame, ExploreFragment()).
        commit()

        // load isRegistered boolean
        loadBoolean()

        bottomNav.setOnNavigationItemSelectedListener { item ->
            lateinit var selectedFragment: Fragment

            when(item.itemId){
                R.id.explore_item -> selectedFragment = ExploreFragment()
                R.id.trip_item -> selectedFragment = TripFragment()

          // if the user is already registered we are not going to show him the sign up screen
          // instead he is going to see a screen with favourite trips (if there are any)

                R.id.me_item ->
                 if(!registrationActivity.isRegistered) {
                    selectedFragment = SignUpFragment()
                }
                 else{
                    selectedFragment = MeFragment()
                }

            }

            supportFragmentManager.
            beginTransaction().
            replace(R.id.frame, selectedFragment).
            commit()

            true
        }

    }

    fun loadBoolean(){
        val s = getSharedPreferences(registrationActivity.SHARED_PREFS, MODE_PRIVATE)
        registrationActivity.isRegistered = s.getBoolean("regKey", false)
    }
}
