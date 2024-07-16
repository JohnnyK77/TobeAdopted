package johnnyk77.android.tobeadopted.util

import android.widget.TextView
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.text.HtmlCompat
import androidx.core.text.method.LinkMovementMethodCompat

@Composable
fun HtmlText(text: String) {
    AndroidView(
        factory = { context -> TextView(context) },
        update = {
            it.text = HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_COMPACT)
            it.movementMethod = LinkMovementMethodCompat.getInstance()
        }
    )
}

@Composable
fun CircleProgressDialog() {
    Dialog(
        onDismissRequest = { },
        DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
    ) {
        CircularProgressIndicator()
    }
}