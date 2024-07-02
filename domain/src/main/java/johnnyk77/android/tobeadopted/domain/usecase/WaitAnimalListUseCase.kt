package johnnyk77.android.tobeadopted.domain.usecase

import johnnyk77.android.tobeadopted.domain.entity.WaitAnimalEntity
import johnnyk77.android.tobeadopted.domain.repository.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class WaitAnimalListUseCase(private val remoteRepository: RemoteRepository) {
    suspend operator fun invoke(
        key: String,
        startIndex: Int,
        endIndex: Int
    ): Flow<List<WaitAnimalEntity>> {
        return flow {
            emit(
                remoteRepository.getWaitAnimalList(key, startIndex, endIndex)
            )
        }.flowOn(Dispatchers.IO)
    }
}