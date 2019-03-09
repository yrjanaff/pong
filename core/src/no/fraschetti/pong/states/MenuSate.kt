package no.fraschetti.pong.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import no.fraschetti.pong.utils.Constants


class MenuSate(gsm: GameStateManager) : State(gsm) {

    override fun handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) gsm.set(PlayState(gsm))
    }

    override fun update(dt: Float) {
        handleInput()
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        gsm.getBorder(sb)
        gsm.getAiScoreFont(sb)
        gsm.getPlayerScoreFont(sb)
        gsm.textElements.startFont.draw(sb, Constants.START_TEXT, (Constants.WIDTH / 2f) - 190, Constants.HEIGHT / 2f)
        sb.end()
    }

    override fun dispose() {
    }
}