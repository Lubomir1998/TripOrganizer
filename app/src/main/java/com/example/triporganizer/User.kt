package com.example.triporganizer

data class User (val email: String, val name: String, val password: String, val favourites: MutableList<Trip>)