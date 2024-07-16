package johnnyk77.android.tobeadopted.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import johnnyk77.android.tobeadopted.domain.entity.Gender
import johnnyk77.android.tobeadopted.domain.entity.WaitAnimalEntity
import johnnyk77.android.tobeadopted.ui.theme.TobeAdoptedTheme
import johnnyk77.android.tobeadopted.util.HtmlText
import johnnyk77.android.tobeadopted.util.extractYouTubeId

class DetailView {
    @Composable
    fun DetailScreen(entity: WaitAnimalEntity?) {
        if (entity == null) return
        MainContent(entity = entity)
    }

    @Composable
    private fun MainContent(
        entity: WaitAnimalEntity,
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold
                ),
                text = "${entity.name}",
            )
            Spacer(modifier = Modifier.height(10.dp))
            YoutubeScreen(
                videoId = extractYouTubeId(entity.introductionUrl ?: "")
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                if (entity.sexDistinguish == "W") {
                    Text(
                        style = TextStyle(
                            color = Color.Red,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        text = Gender.Woman.emoji
                    )
                } else {
                    Text(
                        style = TextStyle(
                            color = Color.Blue,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        text = Gender.Man.emoji
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "${entity.breeds}",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 17.sp
                    ),
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "${entity.age}",
                    style = TextStyle(
                        fontSize = 17.sp,
                    )
                )
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "${entity.entranceDate} 등록",
                style = TextStyle(
                    textAlign = TextAlign.Right,
                    fontSize = 15.sp
                ),
            )
            Spacer(modifier = Modifier.height(20.dp))
            HtmlText(text = entity.introductionContent ?: "")
            Divider(Modifier.height(1.dp))
            Spacer(modifier = Modifier.height(20.dp))
            HtmlText(text = entity.tempProtectContent ?: "")
        }
    }

    @Composable
    fun YoutubeScreen(videoId: String) {
        AndroidView(factory = {
            val view = YouTubePlayerView(it)
            view.addYouTubePlayerListener(
                object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        super.onReady(youTubePlayer)
                        youTubePlayer.cueVideo(videoId, 0f)
                    }
                }
            )
            view
        })
    }

    @Preview(showBackground = true)
    @Composable
    fun MainViewPreview() {
        TobeAdoptedTheme {
            MainContent(
                entity = WaitAnimalEntity(0, "", "", "", "", "", "", null, "", "", "", "", ""),
            )
        }
    }
}