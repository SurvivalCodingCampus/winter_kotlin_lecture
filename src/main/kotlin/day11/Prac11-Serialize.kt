import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

fun main() {
    val targetPath = "./src/main/kotlin/day11/save4.txt"


    val department = Department(name = "steve", leader = Employee(name = "mac", age = 90))

    JsonOperation(department, targetPath)
}

class JsonOperation(instance: Department, targetPath: String) {
    private var serializedData = ""
    private var _targetPath = targetPath
    private var _instance = instance

    init {
        serializedData = Json.encodeToString(_instance)
        val fixedFileName = _targetPath.replace(Regex("/[^/]*\$"), "") + "/company.txt"

        val file = File(fixedFileName)

        file.writeText(serializedData)
    }
}


class CustomErrorHandler(inputMessage: String?) : Exception() {
    private var _inputMessage = inputMessage

    override val message: String
        get() = _inputMessage + super.message
}


@Serializable
data class Employee(var name: String, var age: Int)

@Serializable
data class Department(var name: String, var leader: Employee)


