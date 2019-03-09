package no.fraschetti.pong.sprites

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import no.fraschetti.pong.utils.Constants

class Ball(x: Float, y: Float) {

    private val rectangle: Pixmap = Pixmap(Constants.BALL_WIDTH, Constants.BALL_HEIGHT, Pixmap.Format.RGB565)
    private val position: Vector2
    private val velocity: Vector2
    private val bounds: Rectangle
    private val rectangleTextureRegion: TextureRegion
    private var direction: Int
    private val speed: Int

    init {
        rectangle.setColor(Color.WHITE)
        rectangle.fillRectangle(0, 0, Constants.BALL_WIDTH, Constants.BALL_HEIGHT)
        position = Vector2(x, y)
        velocity = Vector2(0f ,0f)
        rectangleTextureRegion = TextureRegion(Texture(rectangle))
        bounds = Rectangle(x, y, rectangleTextureRegion.texture.width.toFloat(), rectangleTextureRegion.texture.height.toFloat())
        direction = MathUtils.randomSign()
        speed = 10
    }

    fun update(dt: Float) {
        velocity.scl(dt)
        velocity.x += direction * 10
        position.add(velocity.x, 0f)
        velocity.x = 0f
        bounds.setPosition(position.x, position.y)
    }

    fun flipDirection() {
        direction *= -1
    }

    fun getTexture(): TextureRegion {
        return rectangleTextureRegion
    }

    fun getPosition(): Vector2 {
        return position
    }

    fun outOfBoundsOnPlayerSide(): Boolean {
        if (position.x >= (1200f - (Constants.BALL_WIDTH / 2)))
            return true
        return false
    }

    fun outOfBoundsOnAiSide(): Boolean {
        if (position.x == 0f)
            return true
        return false
    }

    fun getBounds(): Rectangle {
        return bounds
    }

    fun dispose() {
        rectangle.dispose()
    }
}