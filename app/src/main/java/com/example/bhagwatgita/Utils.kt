import android.content.Context
import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import com.example.bhagwatgita.ApiCall
import java.io.IOException

fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}

 fun startSound(filename: String, context: Context) {
     var afd: AssetFileDescriptor? = null
     try {
         afd = context.assets.openFd(filename)
     } catch (e: IOException) {
         e.printStackTrace()
     }
     val player = MediaPlayer()
     try {
         afd?.let {
             player.setDataSource(it.fileDescriptor, it.startOffset, it.length)
         }
     } catch (e: IOException) {
         e.printStackTrace()
     }
     try {
         player.prepare()
     } catch (e: IOException) {
         e.printStackTrace()
     }
     player.start()

}