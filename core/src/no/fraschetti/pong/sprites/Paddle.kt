package no.fraschetti.pong.sprites

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import no.fraschetti.pong.utils.Constants

class Paddle(x: Float, y: Float) {

    private val rectangle: Pixmap = Pixmap(Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Pixmap.Format.RGB565)
    private val position: Vector2
    private val velocity: Vector2
    private val rectangleTextureRegion: TextureRegion
    private val bounds: Rectangle

    init {
        rectangle.setColor(Color.WHITE)
        rectangle.fillRectangle(0, 0, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT)
        position = Vector2(x, y)
        velocity = Vector2(0f ,0f)
        rectangleTextureRegion = TextureRegion(Texture(rectangle))
        bounds = Rectangle(x, y, rectangleTextureRegion.texture.width.toFloat(), rectangleTextureRegion.texture.height.toFloat())
    }

    fun update() {
        position.add(0f, velocity.y)
        velocity.y = 0f
        bounds.setPosition(position.x, position.y)
    }

    fun up() {
        if(position.y < Constants.HEIGHT - Constants.PADDLE_HEIGHT)
            velocity.y +=10f
    }

    fun down() {
        if(position.y > 0f)
            velocity.y -= 10f
    }

    fun getTexture(): TextureRegion {
        return rectangleTextureRegion
    }

    fun getPosition(): Vector2 {
        return position
    }

    fun collides(ball: Rectangle): Boolean {
        return ball.overlaps(bounds)
    }

    fun dispose() {
        rectangle.dispose()
    }
}