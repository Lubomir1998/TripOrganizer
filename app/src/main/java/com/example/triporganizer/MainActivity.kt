package com.example.triporganizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav.selectedItemId = R.id.explore_item

        supportFragmentManager.
        beginTransaction().
        replace(R.id.frame, ExploreFragment()).
        commit()

        bottomNav.setOnNavigationItemSelectedListener { item ->
            lateinit var selectedFragment: Fragment

            when(item.itemId){
                R.id.explore_item -> selectedFragment = ExploreFragment()
                R.id.trip_item -> selectedFragment = TripFragment()
                R.id.me_item -> selectedFragment = SignUpFragment()

            }

            supportFragmentManager.
            beginTransaction().
            replace(R.id.frame, selectedFragment).
            commit()

            true
        }

    }
}
