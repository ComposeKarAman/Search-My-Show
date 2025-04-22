package com.example.searchmyshow

data class MovieData(
    val Title: String,
    val Year: String,
    val imdbID: String,
    val Type: String,
    val Poster: String,
    )



data class MovieList(val Search : List<MovieData>)