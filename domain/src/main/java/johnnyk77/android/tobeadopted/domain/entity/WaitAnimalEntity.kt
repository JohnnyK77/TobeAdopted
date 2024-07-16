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

enum class Species(val code: String, val emoji: String) {
    Dog("DOG", "\uD83D\uDC36"), Cat("CAT", "\uD83D\uDC31")
}
