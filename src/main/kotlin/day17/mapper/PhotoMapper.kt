import day17.PhotoDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun PhotoDto.toPhoto(): Photo {
    return Photo(
        id = id ?: "",
        createdAt = LocalDate.parse(createdAt, DateTimeFormatter.ISO_LOCAL_DATE) ?: null,
        title = title ?: "",
        content = content ?: "",
        type = handlePhotoType(type)
    )
}
