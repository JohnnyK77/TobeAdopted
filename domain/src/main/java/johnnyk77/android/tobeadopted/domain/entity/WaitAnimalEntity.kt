package johnnyk77.android.tobeadopted.domain.entity

import java.io.Serializable

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
) : Serializable

enum class Gender(val emoji: String) {
    Man("♂"), Woman("♀")
}

enum class Species(val code: String, val emoji: String) {
    Dog("DOG", "\uD83D\uDC36"), Cat("CAT", "\uD83D\uDC31")
}

enum class AdoptStatus(val code: String, val msg: String) {
    Waiting("N", "입양대기"), Ongoing("P", "입양진행중"), Complete("C", "입양완료")
}

enum class TempProtectionStatus(val code: String, val msg: String) {
    Center("N", "센터보호중"), Common("C", "임시보호중")
}
