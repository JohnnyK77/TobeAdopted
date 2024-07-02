package johnnyk77.android.tobeadopted.domain.entity

data class WaitAnimalEntity(
    val animalNo: Int,
    val name: String?,
    val entranceDate: String?,
    val species: String?,
    val breeds: String?,
    val sexDistinguish: String?,
    val age: String?,
    val bodyWeight: Double?,
    val adoptStatus: String?,
    val tempProtectStatus: String?,
    val tempProtectContent: String?,
    val introductionUrl: String?,
    val introductionContent: String?,
)
