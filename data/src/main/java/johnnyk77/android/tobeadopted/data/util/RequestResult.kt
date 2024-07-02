package johnnyk77.android.tobeadopted.data.util

sealed class RequestResult<T>(
    var data: T? = null,
    val message: String = ""
) {
    class Success<T>(data: T) : RequestResult<T>(data)
    class Error<T>(message: String, data: T? = null) : RequestResult<T>(data, message)
}

enum class ResultInfo(val code: String) {
    OK("INFO-000"), AuthError("INFO-100")
}