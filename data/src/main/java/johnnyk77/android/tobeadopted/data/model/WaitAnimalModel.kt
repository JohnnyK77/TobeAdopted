package johnnyk77.android.tobeadopted.data.model

import com.google.gson.annotations.SerializedName
import johnnyk77.android.tobeadopted.domain.entity.WaitAnimalEntity

data class WaitAnimalModel(
    @SerializedName("ANIMAL_NO") val animalNo: Int,
    @SerializedName("NM") val name: String?,
    @SerializedName("ENTRNC_DATE") val entranceDate: String?,
    @SerializedName("SPCS") val species: String?,
    @SerializedName("BREEDS") val breeds: String?,
    @SerializedName("SEXDSTN") val sexDistinguish: String?,
    @SerializedName("AGE") val age: String?,
    @SerializedName("BDWGH") val bodyWeight: Double,
    @SerializedName("ADP_STTUS") val adoptStatus: String?,
    @SerializedName("TMPR_PRTC_STTUS") val tempProtectStatus: String?,
    @SerializedName("TMPR_PRTC_CN") val tempProtectContent: String?,
    @SerializedName("INTRCN_MVP_URL") val introductionUrl: String?,
    @SerializedName("INTRCN_CN") val introductionContent: String?,
)

fun WaitAnimalModel.toDomain() = WaitAnimalEntity(
    animalNo = animalNo,
    name = name,
    entranceDate = entranceDate,
    species = species,
    breeds = breeds,
    sexDistinguish = sexDistinguish,
    age = age,
    bodyWeight = bodyWeight,
    adoptStatus = adoptStatus,
    tempProtectStatus = tempProtectStatus,
    tempProtectContent = tempProtectContent,
    introductionUrl = introductionUrl,
    introductionContent = introductionContent
)
