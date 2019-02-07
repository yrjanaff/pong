package no.fraschetti.pong.sprites

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Vector2
import no.fraschetti.pong.utils.Constants

class Ball {

    private val rectangle: Pixmap = Pixmap(Constants.BALL_WIDTH, Constants.BALL_HEIGHT, Pixmap.Format.RGB565)
    private val position: Vector2
    private val velocity: Vector2
    private val rectangleTextureRegion: TextureRegion

    constructor(x: Float, y: Float) {
        rectangle.setColor(Color.WHITE)
        rectangle.fillRectangle(0, 0, Constants.BALL_WIDTH, Constants.BALL_HEIGHT)
        position = Vector2(x, y)
        velocity = Vector2(0f ,0f)
        rectangleTextureRegion = TextureRegion(Texture(rectangle))
    }

    fun dispose() {
        rectangle.dispose()
    }
}