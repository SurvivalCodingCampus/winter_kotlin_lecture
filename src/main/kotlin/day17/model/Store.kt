data class Pharmacy(
    val count: Int,
    val stores: List<Store>
)

data class Store(
    val address: String,           // 주소
    val code: String,           // 약국 코드
    val createdAt: String?,     // 생성 날짜
    val lat: Double,            // 위도
    val lng: Double,            // 경도
    val name: String,           // 약국 이름
    val remainStat: String?,    // 재고 상태 ("plenty", "some", "few", "empty", "break" 등)
    val stockAt: String?,       // 재고 확인 시간
    val type: String            // 약국 타입
)