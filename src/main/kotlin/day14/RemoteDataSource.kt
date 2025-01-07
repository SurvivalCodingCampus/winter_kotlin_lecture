package org.example.day14

import MemoDataSource

class RemoteDataSource: MemoDataSource {
    override fun saveMemo(text: String) {
        // 서버에 저장
    }

    override fun getMemos(): List<String> {
        // 서버에서 조회
        return listOf()
    }
}