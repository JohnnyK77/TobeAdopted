package johnnyk77.android.tobeadopted.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import johnnyk77.android.tobeadopted.ui.views.DetailView
import johnnyk77.android.tobeadopted.ui.views.MainView

class ScreenNavigation {
    @Composable
    fun SetUpNavGraph(controller: NavHostController, startDestination: String) {
        NavHost(navController = controller, startDestination = startDestination) {
            composable(
                route = Screen.Main.name
            ) {
                MainView().MainScreen(navController = controller)
            }
            composable(
                route = Screen.Detail.name
            ) { backStackEntry ->
                // MainViewModel 공유
                val parentEntry = remember(backStackEntry) {
                    controller.getBackStackEntry(Screen.Main.name)
                }
                DetailView().DetailScreen(
                    viewModel = hiltViewModel(parentEntry),
                    navController = controller
                )
            }
        }
    }
}

enum class Screen {
    Main, Detail
}
