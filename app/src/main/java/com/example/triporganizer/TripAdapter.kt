package com.example.triporganizer


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.trip_layout.view.*

class TripAdapter(val listOfTrips: MutableList<Trip>, var itemCliclistener: OnItemClickListener) : RecyclerView.Adapter<TripAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.trip_layout, parent, false)

        return MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTrip = listOfTrips[position]

        holder.tripImage.setImageResource(currentTrip.mainImg)
        holder.tripName.text = currentTrip.tripName
        holder.tripDays.text = "${currentTrip.days} days"
        holder.tripPrice.text = "${currentTrip.price} $"

        holder.bind(currentTrip, itemCliclistener)

    }

    override fun getItemCount(): Int = listOfTrips.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val tripImage: ImageView = itemView.tripImg
        val tripName: TextView = itemView.tripName
        val tripPrice: TextView =  itemView.tripPrice
        val tripDays: TextView = itemView.tripLength

        fun bind(tripp: Trip, listener: OnItemClickListener){
            itemView.setOnClickListener {
                listener.onItemClicked(tripp)
            }
        }

    }

    interface OnItemClickListener{
        fun onItemClicked(tripp: Trip)
    }

}