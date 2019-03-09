package no.fraschetti.pong.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import no.fraschetti.pong.common.Border
import no.fraschetti.pong.sprites.Ball
import no.fraschetti.pong.utils.Constants
import no.fraschetti.pong.sprites.Paddle

class PlayState(gsm: GameStateManager): State(gsm) {

    private val paddleStartHeight = (Constants.HEIGHT / 2f) - (Constants.PADDLE_HEIGHT / 2f)
    private val aiPaddle: Paddle = Paddle(20f, paddleStartHeight)
    private val playerPaddle: Paddle = Paddle(Constants.WIDTH - Constants.PADDLE_WIDTH - 20f, paddleStartHeight)
    private val ball: Ball = Ball(Constants.WIDTH / 2f, Constants.HEIGHT / 2f)

    override fun handleInput() {
        when {
            Gdx.input.isKeyPressed(Input.Keys.UP) -> {
                playerPaddle.up()
            }
            Gdx.input.isKeyPressed(Input.Keys.DOWN) -> {
                playerPaddle.down()
            }
            Gdx.input.isKeyPressed(Input.Keys.W) -> {
                aiPaddle.up()
            }
            Gdx.input.isKeyPressed(Input.Keys.S) -> {
                aiPaddle.down()
            }
            Gdx.input.isKeyPressed(Input.Keys.ESCAPE) -> {
                gsm.playerScore = 0
                gsm.aiScore = 0
                gsm.set(MenuSate(gsm))
            }
        }
    }

    override fun update(dt: Float) {
        handleInput()
        playerPaddle.update()
        aiPaddle.update()
        ball.update(dt)
        if(playerPaddle.collides(ball.getBounds()) || aiPaddle.collides(ball.getBounds())) {
            ball.flipDirection()
        } else if (ball.outOfBoundsOnAiSide()) {
            gsm.playerScore += 1
            gsm.set(MenuSate(gsm))
        } else if (ball.outOfBoundsOnPlayerSide()) {
            gsm.aiScore += 1
            gsm.set(MenuSate(gsm))
        }
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        gsm.getBorder(sb)
        gsm.getAiScoreFont(sb)
        gsm.getPlayerScoreFont(sb)
        sb.draw(aiPaddle.getTexture(), aiPaddle.getPosition().x, aiPaddle.getPosition().y)
        sb.draw(playerPaddle.getTexture(), playerPaddle.getPosition().x, playerPaddle.getPosition().y)
        sb.draw(ball.getTexture(), ball.getPosition().x, ball.getPosition().y)
        sb.end()
    }

    override fun dispose() {
        playerPaddle.dispose()
        aiPaddle.dispose()
        ball.dispose()
    }
}