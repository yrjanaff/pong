package no.fraschetti.pong

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import no.fraschetti.pong.states.GameStateManager
import no.fraschetti.pong.states.PlayState

class Pong : ApplicationAdapter() {

    private lateinit var batch: SpriteBatch
    private lateinit var gsm: GameStateManager

    override fun create() {
        batch = SpriteBatch()
        gsm = GameStateManager()
        gsm.push(PlayState(gsm))
    }

    override fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        gsm.update(Gdx.graphics.deltaTime)
        gsm.render(batch)
    }

    override fun dispose() {
        batch.dispose()
    }
}
