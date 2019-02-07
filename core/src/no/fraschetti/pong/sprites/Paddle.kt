package no.fraschetti.pong.sprites

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Vector2
import no.fraschetti.pong.utils.Constants

class Paddle {

    private val rectangle: Pixmap = Pixmap(Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Pixmap.Format.RGB565)
    private val position: Vector2
    private val velocity: Vector2
    private val rectangleTextureRegion: TextureRegion

     constructor(x: Float, y: Float) {
         rectangle.setColor(Color.WHITE)
         rectangle.fillRectangle(0, 0, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT)
         position = Vector2(x, y)
         velocity = Vector2(0f ,0f)
         rectangleTextureRegion = TextureRegion(Texture(rectangle))
     }

    fun update() {
        position.add(0f, velocity.y)
        velocity.y = 0f
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

    fun dispose() {
        rectangle.dispose()
    }
    /*PixMap myPixMap = new PixMap(desiredWidth, desiredHeight, pixmapFormat);
    myPixMap.setColor(myColor);
    myPixMap.fillRectangle(x, y, width, height);

    TextureRegion myTextureRegion = new TextureRegion(new Texture(myPixMap));*/
}