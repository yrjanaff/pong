package no.fraschetti.pong.common

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import no.fraschetti.pong.utils.Constants


class Border {

    private val rectangle: Pixmap = Pixmap(Constants.BORDER_WIDTH, Constants.BORDER_HEIGHT, Pixmap.Format.RGB565)

    init {
        rectangle.setColor(Color.GRAY)
        rectangle.fillRectangle(0, 0, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT)
    }

    fun getTexture(): Texture = Texture(rectangle)
}