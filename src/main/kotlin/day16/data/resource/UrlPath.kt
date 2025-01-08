package org.example.day16.data.resource

import java.io.File
import java.util.*

private val movieApiKey = Properties().apply {
    load(File("local.properties").inputStream())
}.getProperty("movie.api.key")

val movieUrlPath =
    "https://api.themoviedb.org/3/movie/upcoming?api_key=${movieApiKey}"