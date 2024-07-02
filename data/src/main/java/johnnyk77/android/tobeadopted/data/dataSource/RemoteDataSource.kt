package johnnyk77.android.tobeadopted.data.dataSource

import johnnyk77.android.tobeadopted.data.model.BaseListModel
import johnnyk77.android.tobeadopted.data.model.WaitAnimalModel
import johnnyk77.android.tobeadopted.data.util.RequestResult

interface RemoteDataSource {
    suspend fun getWaitAnimalList(
        key: String,
        startIndex: Int,
        endIndex: Int,
    ): RequestResult<BaseListModel<WaitAnimalModel>>
}