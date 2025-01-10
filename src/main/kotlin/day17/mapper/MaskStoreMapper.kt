package day17.mapper

import day17.dto.Pharmacy
import day17.model.Pharmacy as DomainPharmacy

// dto에서 필요한 부분만 변환, Nullable 을 non-Nullable로 변환
fun maskMapper(dto: Pharmacy): DomainPharmacy {
    return DomainPharmacy(
        addr = dto.addr.orEmpty(),   // addr이 null일 경우 빈 문자열("")로 처리
        code = dto.code.orEmpty(),
        createdAt = dto.createdAt.orEmpty(),
        lat = dto.lat ?: 0.0,       // lat이 null일 경우 0.0으로 기본값을 설정
        lng = dto.lng ?: 0.0,
        name = dto.name.orEmpty(),
        remainStat = dto.remainStat.orEmpty(),
        stockAt = dto.stockAt.orEmpty(),
        type = dto.type.orEmpty()
    )
}

