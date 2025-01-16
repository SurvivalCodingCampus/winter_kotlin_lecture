package com.survivalcoding.com.survivalcoding.day18.model

data class Photo(
    val tags: List<String>,
    val imageUrl: String,
) {
    inner class Steps(
        val title: String,
        val description: String,
    )
}
