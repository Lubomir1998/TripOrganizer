package com.example.triporganizer

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager

class TripFragment : Fragment(), TripAdapter.OnItemClickListener {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_trip, container, false)

        (activity as? AppCompatActivity)?.supportActionBar?.title = "Trips"
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerview)

        val tripList = ArrayList<Trip>()



        val parisSwileImg = ArrayList<Int>()
        parisSwileImg.add(R.drawable.parisfirst)
        parisSwileImg.add(R.drawable.parissecond)
        parisSwileImg.add(R.drawable.paristhird)
        val paris = Trip(R.drawable.parismain, "Paris", 5, 100, parisSwileImg)
        tripList.add(paris)


        val romeSwileImg = ArrayList<Int>()
        romeSwileImg.add(R.drawable.romefirst)
        romeSwileImg.add(R.drawable.romesecond)
        romeSwileImg.add(R.drawable.romethird)
        romeSwileImg.add(R.drawable.romeforth)
        romeSwileImg.add(R.drawable.romefifth)
        val rome = Trip(R.drawable.romemain, "Ancient Rome", 4, 120, romeSwileImg)
        tripList.add(rome)

        val barcaSwileImg = ArrayList<Int>()
        barcaSwileImg.add(R.drawable.barcelonafirst)
        barcaSwileImg.add(R.drawable.barcelonasecond)
        barcaSwileImg.add(R.drawable.barcelonathird)
        val barcelona = Trip(R.drawable.barcelonamain, "Sunny Barca", 7, 300, barcaSwileImg)
        tripList.add(barcelona)


        recyclerView.adapter = TripAdapter(tripList, this)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)



        return view
    }

    override fun onItemClicked(tripp: Trip) {
        val intent = Intent(activity, DetailTripActivity::class.java)
        intent.putExtra("name", tripp.tripName)
        intent.putIntegerArrayListExtra("photolist", tripp.slideImages)
        startActivity(intent)
        activity?.overridePendingTransition(R.anim.slide_right_first, R.anim.slide_right_second)
    }





}