package johnnyk77.android.tobeadopted.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import johnnyk77.android.tobeadopted.domain.entity.AdoptStatus
import johnnyk77.android.tobeadopted.domain.entity.Gender
import johnnyk77.android.tobeadopted.domain.entity.Species
import johnnyk77.android.tobeadopted.domain.entity.TempProtectionStatus
import johnnyk77.android.tobeadopted.domain.entity.WaitAnimalEntity
import johnnyk77.android.tobeadopted.ui.navigation.NavigationUtil
import johnnyk77.android.tobeadopted.ui.theme.PurpleGrey80
import johnnyk77.android.tobeadopted.ui.theme.TobeAdoptedTheme
import johnnyk77.android.tobeadopted.util.BackOnPressed
import johnnyk77.android.tobeadopted.util.CircleProgressDialog
import johnnyk77.android.tobeadopted.util.extractYouTubeThumbnail

class MainView {
    @Composable
    fun MainScreen(
        viewModel: MainViewModel = hiltViewModel(), navController: NavHostController
    ) {
        val uiState by viewModel.uiState.collectAsState()
        MainContent(
            uiState = uiState,
            onSpeciesMenuClick = { isCatListType -> viewModel.setListType(isCatListType) },
            onListItemClick = viewModel::onListItemClick
        )
        LaunchedEffect(Unit) {
            viewModel.navigate.collect {
                NavigationUtil.setCurrentAnimal(navController, uiState.selectedEntity)
                navController.navigate(it)
            }
        }
        BackOnPressed()
    }

    @Composable
    private fun MainContent(
        uiState: MainViewModel.MainUiState,
        onSpeciesMenuClick: (Boolean) -> Unit,
        onListItemClick: (WaitAnimalEntity) -> Unit
    ) {
        Column {
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Box(
                    Modifier
                        .weight(1.0f)
                        .padding(5.dp)
                        .border(
                            width = 2.dp,
                            color = if (uiState.isCatListType) Color.Transparent else PurpleGrey80,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clickable {
                            onSpeciesMenuClick(false)
                        },
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        style = TextStyle(
                            fontSize = 25.sp, textAlign = TextAlign.Center
                        ),
                        text = Species.Dog.emoji
                    )
                }
                Box(
                    Modifier
                        .weight(1.0f)
                        .padding(5.dp)
                        .border(
                            width = 2.dp,
                            color = if (uiState.isCatListType) PurpleGrey80 else Color.Transparent,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clickable {
                            onSpeciesMenuClick(true)
                        },
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        style = TextStyle(
                            fontSize = 25.sp, textAlign = TextAlign.Center
                        ),
                        text = Species.Cat.emoji
                    )
                }
            }
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val waitAnimalList = uiState.waitAnimalList
                if (!waitAnimalList.isNullOrEmpty()) {
                    items(waitAnimalList.size) {
                        val entity = waitAnimalList[it]
                        WaitAnimalItem(entity = entity, onItemClick = { onListItemClick(entity) })
                    }
                }
            }
        }
        if (uiState.isLoading) {
            CircleProgressDialog()
        }
    }

    @Composable
    private fun WaitAnimalItem(entity: WaitAnimalEntity, onItemClick: () -> Unit) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable(onClick = onItemClick)
        ) {
            Row(
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = extractYouTubeThumbnail(entity.introductionUrl ?: "")
                    ),
                    contentDescription = "${entity.name}'s picture",
                    modifier = Modifier.size(80.dp),
                    contentScale = ContentScale.None
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Row {
                        Text(
                            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                            text = "${entity.name}",
                        )
                        Spacer(modifier = Modifier.width(7.dp))
                        if (entity.sexDistinguish == "W") {
                            Text(
                                style = TextStyle(
                                    color = Color.Red,
                                    fontWeight = FontWeight.Bold
                                ),
                                text = Gender.Woman.emoji
                            )
                        } else {
                            Text(
                                style = TextStyle(
                                    color = Color.Blue,
                                    fontWeight = FontWeight.Bold
                                ),
                                text = Gender.Man.emoji
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row {
                        Text(
                            text = "${entity.breeds}",
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "${entity.age}")
                    }
                    Text(text = "${entity.entranceDate} 입소")
                    Text(
                        text = "${
                            when (entity.adoptStatus) {
                                AdoptStatus.Waiting.code -> AdoptStatus.Waiting.msg
                                AdoptStatus.Ongoing.code -> AdoptStatus.Ongoing.msg
                                AdoptStatus.Complete.code -> AdoptStatus.Complete.msg
                                else -> ""
                            }
                        }, ${
                            when (entity.tempProtectStatus) {
                                TempProtectionStatus.Center.code -> TempProtectionStatus.Center.msg
                                TempProtectionStatus.Common.code -> TempProtectionStatus.Common.msg
                                else -> ""
                            }
                        }"
                    )
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
                onSpeciesMenuClick = {},
                onListItemClick = {}
            )
        }
    }
}