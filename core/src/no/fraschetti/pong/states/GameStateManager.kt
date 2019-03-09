package no.fraschetti.pong.states

import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import no.fraschetti.pong.common.Border
import no.fraschetti.pong.common.TextElements
import no.fraschetti.pong.utils.Constants
import java.util.*

class GameStateManager {

    private val states: Stack<State> = Stack()
    var playerScore = 0
    var aiScore = 0
    val textElements: TextElements = TextElements()
    private val borderRactangle = Border()

    fun push(state: State) {
        states.push(state)
    }

    fun pop() {
        states.pop().dispose()
    }

    fun set(state: State) {
        states.pop().dispose()
        states.push(state)
    }

    fun update(dt: Float) {
        states.peek().update(dt)
    }

    fun render(sb: SpriteBatch) {
        states.peek().render(sb)
    }

    fun getAiScoreFont(sb: SpriteBatch): GlyphLayout? {
        return textElements.aiScoreFont.draw(sb, aiScore.toString(), 300f, Constants.HEIGHT - 20f)
    }

    fun getPlayerScoreFont(sb: SpriteBatch): GlyphLayout? {
        return textElements.playerScoreFont.draw(sb, playerScore.toString(), Constants.WIDTH - 400f, Constants.HEIGHT - 20f)
    }

    fun getBorder(sb: SpriteBatch) = repeat(8) {
        sb.draw(borderRactangle.getTexture(), (Constants.WIDTH / 2) - (Constants.BORDER_WIDTH / 2f), (100f * it) + 5)
    }
}