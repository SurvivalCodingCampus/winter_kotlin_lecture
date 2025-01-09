package com.survivalcoding.com.survivalcoding.day17.mapper

import com.survivalcoding.com.survivalcoding.day17.dto.MovieDto
import com.survivalcoding.day17.model.Movie
import java.time.LocalDate

fun MovieDto.toMovie() = Movie(
    id = id ?: -1,
    title = title ?: "",
    overview = overview ?: "",
    releaseDate = LocalDate.parse(release_date)
)