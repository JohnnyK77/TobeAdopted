package johnnyk77.android.tobeadopted.data.dataSource

import johnnyk77.android.tobeadopted.data.model.BaseListModel
import johnnyk77.android.tobeadopted.data.model.WaitAnimalModel
import johnnyk77.android.tobeadopted.data.service.ApiService
import johnnyk77.android.tobeadopted.data.service.BaseApiResponse
import johnnyk77.android.tobeadopted.data.util.RequestResult

class RemoteDataSourceImpl(private val apiService: ApiService) : RemoteDataSource,
    BaseApiResponse() {
    override suspend fun getWaitAnimalList(
        key: String,
        startIndex: Int,
        endIndex: Int,
    ): RequestResult<BaseListModel<WaitAnimalModel>> {
        return callApi { apiService.getWaitAnimalList(key, startIndex, endIndex) }
    }
}