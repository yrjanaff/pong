package no.fraschetti.pong.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import no.fraschetti.pong.utils.Constants
import no.fraschetti.pong.Pong

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        config.width = Constants.WIDTH
        config.height = Constants.HEIGHT
        LwjglApplication(Pong(), config)
    }
}
