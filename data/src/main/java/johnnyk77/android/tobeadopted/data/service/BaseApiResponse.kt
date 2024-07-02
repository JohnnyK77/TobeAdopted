package johnnyk77.android.tobeadopted.data.service

import com.orhanobut.logger.Logger
import johnnyk77.android.tobeadopted.data.util.RequestResult
import retrofit2.Response

abstract class BaseApiResponse {
    suspend fun <T> callApi(apiCall: suspend () -> Response<T>):
            RequestResult<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return RequestResult.Success(body)
                }
            }
            Logger.d("RESPONSE FAIL...CODE:${response.code()}, MSG:${response.message()}")
            return error(response.message())
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(errorMessage: String): RequestResult<T> =
        RequestResult.Error("서버 통신 실패: $errorMessage")
}