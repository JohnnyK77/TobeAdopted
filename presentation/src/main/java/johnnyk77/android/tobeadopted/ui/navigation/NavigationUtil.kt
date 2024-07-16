package johnnyk77.android.tobeadopted.ui.navigation

import androidx.navigation.NavHostController
import johnnyk77.android.tobeadopted.domain.entity.WaitAnimalEntity

object NavigationUtil {
    private const val KEY_ANIMAL = "Animal"

    fun setPreviousAnimal(controller: NavHostController, entity: WaitAnimalEntity?) {
        controller.previousBackStackEntry
            ?.savedStateHandle?.set(KEY_ANIMAL, entity)
    }

    fun getPreviousAnimal(controller: NavHostController): WaitAnimalEntity? {
        return controller.previousBackStackEntry
            ?.savedStateHandle?.get(KEY_ANIMAL)
    }

    fun setCurrentAnimal(controller: NavHostController, entity: WaitAnimalEntity?) {
        controller.currentBackStackEntry
            ?.savedStateHandle?.set(KEY_ANIMAL, entity)
    }

    fun getCurrentAnimal(controller: NavHostController): WaitAnimalEntity? {
        return controller.currentBackStackEntry
            ?.savedStateHandle?.get(KEY_ANIMAL)
    }
}