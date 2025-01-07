interface MemoDataSource {
    fun saveMemo(text: String)
    fun getMemos() : List<String>
}