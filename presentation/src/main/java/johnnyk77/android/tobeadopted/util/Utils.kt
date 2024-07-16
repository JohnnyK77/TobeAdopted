package johnnyk77.android.tobeadopted.util

fun extractYouTubeThumbnail(url: String): String {
    val id = extractYouTubeId(url)
    return "https://img.youtube.com/vi/$id/0.jpg"
}

fun extractYouTubeId(url: String): String {
    val regex =
        "^(?:https?://)?(?:www\\.|m\\.)?(?:youtube\\.com/watch\\?v=|youtu.be/)([\\w-]{11})(?:&.+)?\$".toRegex()
    val matchResult = regex.find(url)
    return matchResult?.groups?.get(1)?.value ?: ""
}

