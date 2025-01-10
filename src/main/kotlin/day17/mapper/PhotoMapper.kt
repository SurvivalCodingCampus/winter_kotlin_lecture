import org.example.day17.dto.PhotoDto
import org.example.day17.model.Photo
import org.example.day17.model.PhotoType
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object PhotoMapper {
    private val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    fun mapToModel(dto: PhotoDto): Photo {
        return Photo(
            id = dto.id ?: 0, // id가 null이거나 숫자가 아니면 기본값 0
            type = PhotoType.values().find { it.name.equals(dto.type, ignoreCase = true) } ?: PhotoType.UNKNOWN,
            title = dto.title,
            content = dto.content,
            url = dto.url,
            caption = dto.caption,
            createdAt = dto.createdAt?.let {
                try {
                    LocalDate.parse(it, dateFormatter)
                } catch (e: Exception) {
                    LocalDate.now() // 잘못된 날짜 형식일 경우 현재 날짜 반환
                }
            } ?: LocalDate.now() // null일 경우 현재 날짜 반환
        )
    }
}