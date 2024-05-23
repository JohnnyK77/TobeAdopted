package johnnyk77.android.tobeadopted.domain.usecase

import johnnyk77.android.tobeadopted.domain.entity.WaitAnimalEntity
import johnnyk77.android.tobeadopted.domain.repository.WaitAnimalRepository
import johnnyk77.android.tobeadopted.domain.util.ApiResult

class WaitAnimalListUseCase(private val waitAnimalRepository: WaitAnimalRepository) {
    suspend operator fun invoke(): ApiResult<WaitAnimalEntity> =
        waitAnimalRepository.getWaitAnimalList()
}