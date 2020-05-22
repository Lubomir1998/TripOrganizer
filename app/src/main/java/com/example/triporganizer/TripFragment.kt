package com.example.triporganizer

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_trip.*

class TripFragment : Fragment(), TripAdapter.onItemClickListener {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_trip, container, false)

        (activity as? AppCompatActivity)?.supportActionBar?.title = "Trips"
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerview)

        val tripList = ArrayList<Trip>()

        // to trip will be added a new characteristic:
        // mutable list of images wich will be shown in a view pager in the detailed activity

        // this photo (football_field) is  just for review

        val paris = Trip(R.drawable.football_field, "Paris", 5, 100)
        tripList.add(paris)

        val rome = Trip(R.drawable.football_field, "Ancient Rome", 4, 120)
        tripList.add(rome)

        val barcelona = Trip(R.drawable.football_field, "Sunny Barca", 7, 300)
        tripList.add(barcelona)


        recyclerView.adapter = TripAdapter(tripList, this)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)


        return view
    }

    override fun onItemClicked(tripp: Trip) {
        // detail for trip

    }


}