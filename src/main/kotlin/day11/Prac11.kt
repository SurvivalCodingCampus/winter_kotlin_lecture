import java.io.File


fun main() {
    val sourcePath = "./src/main/kotlin/day11/save.txt"
    val targetPath = "./src/main/kotlin/day11/save4.txt"

    FileOperation().copy(sourcePath, targetPath)
}


/**
 *  Only copy function enabled without buffering and error handling
 */
interface FileOperations {
    /*
    * @param sourcePath Origin of file path
    * @param targetPath target path
    * @throws IllegalArgumentException
    */
    fun copy(sourcePath: String, targetPath: String)
}


class FileOperation : FileOperations {
    override fun copy(sourcePath: String, targetPath: String) {
        try {
            val file = File(sourcePath)
            val newFile = File(targetPath)
            newFile.writeText(file.readText())
        } catch (_: Exception) {
            throw IllegalArgumentException("Not exist source file \n Checking the origin path")
        }
    }
}
