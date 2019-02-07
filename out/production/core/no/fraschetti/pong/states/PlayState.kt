package no.fraschetti.pong.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import no.fraschetti.pong.utils.Constants
import no.fraschetti.pong.sprites.Paddle

class PlayState: State {

    private val paddleStartHeight = (Constants.HEIGHT / 2f) - (Constants.PADDLE_HEIGHT / 2f)

    private val aiPaddle: Paddle = Paddle(20f, paddleStartHeight)
    private val playerPaddle: Paddle = Paddle(Constants.WIDTH - Constants.PADDLE_WIDTH - 20f, paddleStartHeight)
    //private val velocity: Vector3

    constructor(gsm: GameStateManager) : super(gsm) {
        //velocity = Vector3(0f, 0f, 0f)

    }

    override fun handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            println("UP was pressed!")
            playerPaddle.up()
            aiPaddle.up()
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            println("DOWN was pressed")
            playerPaddle.down()
            aiPaddle.down()
        }

    }

    override fun update(dt: Float) {
        handleInput()
        playerPaddle.update()
        aiPaddle.update()
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        sb.draw(aiPaddle.getTexture(), aiPaddle.getPosition().x, aiPaddle.getPosition().y)
        sb.draw(playerPaddle.getTexture(), playerPaddle.getPosition().x, playerPaddle.getPosition().y)
        sb.end()
    }

    override fun dispose() {
        playerPaddle.dispose()
        aiPaddle.dispose()
    }
}