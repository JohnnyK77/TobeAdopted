package johnnyk77.android.tobeadopted.domain.repository

interface AnimalRepository {
    suspend fun getWaitAnimalList(key: String, startIndex: Int, endIndex: Int)
}