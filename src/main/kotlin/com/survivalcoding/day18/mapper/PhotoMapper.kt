package com.survivalcoding.com.survivalcoding.day18.mapper

import com.survivalcoding.com.survivalcoding.day18.model.Photo
import com.survivalcoding.day18.dto.PhotoDto

fun PhotoDto.toPhoto(): Photo {
    return Photo(
        tags = tags?.split(", ") ?: emptyList(),
        imageUrl = webformatURL
            ?: "https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcRXD2gc5vf4OqCkAEjjzKDmbCaHLyvhHAZ7hjY5i7DbySIBYXYNi4eyzXlGxaPAAsQdJyol-L_2iwY9n-g"
    )
}