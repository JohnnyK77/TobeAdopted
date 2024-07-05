package johnnyk77.android.tobeadopted.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import johnnyk77.android.tobeadopted.domain.entity.WaitAnimalEntity
import johnnyk77.android.tobeadopted.ui.theme.TobeAdoptedTheme
import johnnyk77.android.tobeadopted.util.extractYouTubeThumbnail

class MainView {
    @Composable
    fun MainScreen(
        viewModel: MainViewModel = hiltViewModel(),
        navController: NavHostController
    ) {
        val context = LocalContext.current
        val uiState by viewModel.uiState.collectAsState()
        MainContent(
            uiState = uiState,
        )
        LaunchedEffect(Unit) {
            /*viewModel.navigate.collect {
                navController.navigate(it)
            }*/
        }
    }

    @Composable
    private fun MainContent(
        uiState: MainViewModel.MainUiState,
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val waitAnimalList = uiState.waitAnimalList
            if (!waitAnimalList.isNullOrEmpty()) {
                items(waitAnimalList.size) {
                    WaitAnimalItem(entity = waitAnimalList[it])
                }
            }
        }
    }

    @Composable
    private fun WaitAnimalItem(entity: WaitAnimalEntity) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Row(
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model =
                        extractYouTubeThumbnail(entity.introductionUrl ?: "")
                    ),
                    contentDescription = "${entity.name}'s picture",
                    modifier = Modifier.size(80.dp),
                    contentScale = ContentScale.None
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = "${entity.name}", fontWeight = FontWeight.Bold)
                    Text(text = "Age: ${entity.age}")
                    Text(text = "Breed: ${entity.breeds}")
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainViewPreview() {
        TobeAdoptedTheme {
            MainContent(
                uiState = MainViewModel.MainUiState(
                ),
            )
        }
    }
}