package com.example.triporganizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.r0adkll.slidr.Slidr
import com.r0adkll.slidr.model.SlidrInterface

class DetailTripActivity : AppCompatActivity() {

    private lateinit var slider: SlidrInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_trip)


        val tripNameTextView: TextView = findViewById(R.id.nameTextview)
        val nameT: String = intent.getStringExtra("name")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = nameT
        tripNameTextView.text = nameT

        slider = Slidr.attach(this)

    }


}
