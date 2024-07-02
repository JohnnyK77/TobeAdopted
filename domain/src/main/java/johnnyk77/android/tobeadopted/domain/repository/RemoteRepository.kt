package johnnyk77.android.tobeadopted.domain.repository

import johnnyk77.android.tobeadopted.domain.entity.WaitAnimalEntity

interface RemoteRepository {
    suspend fun getWaitAnimalList(
        key: String,
        startIndex: Int,
        endIndex: Int
    ): List<WaitAnimalEntity>
}