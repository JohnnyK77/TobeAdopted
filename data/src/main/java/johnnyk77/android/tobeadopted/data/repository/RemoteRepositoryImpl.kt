package johnnyk77.android.tobeadopted.data.repository

import com.orhanobut.logger.Logger
import johnnyk77.android.tobeadopted.data.dataSource.RemoteDataSource
import johnnyk77.android.tobeadopted.data.model.toDomain
import johnnyk77.android.tobeadopted.data.service.BaseApiResponse
import johnnyk77.android.tobeadopted.data.util.ResultInfo
import johnnyk77.android.tobeadopted.domain.entity.WaitAnimalEntity
import johnnyk77.android.tobeadopted.domain.repository.RemoteRepository

class RemoteRepositoryImpl(private val remoteDataSource: RemoteDataSource) :
    RemoteRepository, BaseApiResponse() {
    override suspend fun getWaitAnimalList(
        key: String,
        startIndex: Int,
        endIndex: Int
    ): List<WaitAnimalEntity> {
        val requestResult = remoteDataSource.getWaitAnimalList(key, startIndex, endIndex)
        val list = mutableListOf<WaitAnimalEntity>()
        requestResult.data?.content.apply {
            val result = this?.result
            val row = this?.row
            when (result?.code) {
                ResultInfo.OK.code -> { // 정상 처리
                    row?.forEach {
                        list.add(it.toDomain())
                    }
                }

                ResultInfo.AuthError.code -> {
                    Logger.w("auth error!!")
                }
            }
        }
        return list
    }
}