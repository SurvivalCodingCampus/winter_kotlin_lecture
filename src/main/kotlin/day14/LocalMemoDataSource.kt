package org.example.day14

import MemoDataSource

class LocalMemoDataSource: MemoDataSource {
    private val memos = mutableListOf<String>()
    override fun saveMemo(text: String) {
        memos.add(text)
    }

    override fun getMemos(): List<String> {
        return memos.toList()
    }
}