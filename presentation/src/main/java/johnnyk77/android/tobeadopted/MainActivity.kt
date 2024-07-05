package johnnyk77.android.tobeadopted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import johnnyk77.android.tobeadopted.ui.navigation.Screen
import johnnyk77.android.tobeadopted.ui.navigation.ScreenNavigation
import johnnyk77.android.tobeadopted.ui.theme.TobeAdoptedTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TobeAdoptedTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenNavigation().SetUpNavGraph(
                        controller = rememberNavController(),
                        startDestination = Screen.Main.name
                    )
                }
            }
        }
    }
}