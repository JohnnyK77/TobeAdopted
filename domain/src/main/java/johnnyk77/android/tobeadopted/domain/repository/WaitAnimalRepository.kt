package johnnyk77.android.tobeadopted.domain.repository

import johnnyk77.android.tobeadopted.domain.entity.WaitAnimalEntity
import johnnyk77.android.tobeadopted.domain.util.ApiResult

interface WaitAnimalRepository {
    suspend fun getWaitAnimalList():ApiResult<WaitAnimalEntity>
}