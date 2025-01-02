interface FileOperations {
    //읽어서 다른데다 쓰면 복사
    fun copy(sourcePath: String, targetPath: String )
}