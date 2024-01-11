package johnnyk77.android.tobeadopted.data.model

import com.google.gson.annotations.SerializedName

data class BaseListModel<T>(
    @SerializedName("TbAdpWaitAnimalView") val content: Content<T>
) {
    data class Content<T>(
        @SerializedName("list_total_count") val listTotalCount: Int,
        @SerializedName("RESULT") val result: Result?,
        @SerializedName("row") val row: List<T>?
    )

    data class Result(
        @SerializedName("CODE") val code: String?,
        @SerializedName("MESSAGE") val message: String?
    )
}
