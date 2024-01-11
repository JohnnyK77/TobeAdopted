package johnnyk77.android.tobeadopted.data.service

import johnnyk77.android.tobeadopted.data.model.BaseListModel
import johnnyk77.android.tobeadopted.data.model.WaitAnimalModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{key}/json/TbAdpWaitAnimalView/{startIdx}/{endIdx}")

    suspend fun getWaitAnimalList(
        @Path("key") key: String,
        @Path("startIdx") startIndex: Int,
        @Path("endIdx") endIndex: Int,
    ): Response<BaseListModel<WaitAnimalModel>>
}