package no.fraschetti.pong.states

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector3

abstract class State(protected val gsm: GameStateManager){
    protected lateinit var cam: OrthographicCamera
    protected lateinit var mouse: Vector3

    protected abstract fun handleInput()
    abstract fun update(dt: Float)
    abstract fun render(sb: SpriteBatch)
    abstract fun dispose()
}