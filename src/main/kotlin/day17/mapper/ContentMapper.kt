package org.example.day17.mapper

import day17.dto.ContentDto
import org.example.day17.model.Content
import org.example.day17.model.ContentType
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private val contentDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

fun ContentDto.toModel() = Content(
    id = id ?: -1,
    title = title ?: "",
    content = content ?: "",
    url = url ?: "",
    caption = caption ?: "",
    createdAt = LocalDate.parse(created_at!!, contentDateFormatter),
    type = ContentType.fromString(type)
)