package johnnyk77.android.tobeadopted.util

fun extractYouTubeThumbnail(url: String): String {
    val regex =
        "^(?:https?://)?(?:www\\.|m\\.)?(?:youtube\\.com/watch\\?v=|youtu.be/)([\\w-]{11})(?:&.+)?\$".toRegex()
    val matchResult = regex.find(url)
    val id = matchResult?.groups?.get(1)?.value
    return "https://img.youtube.com/vi/$id/0.jpg"
}