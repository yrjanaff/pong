package no.fraschetti.pong.common

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import no.fraschetti.pong.utils.Constants

class TextElements {

    private val generator: FreeTypeFontGenerator = FreeTypeFontGenerator(Gdx.files.internal("font/Pixel-Miners.otf"))
    private val startParam: FreeTypeFontGenerator.FreeTypeFontParameter = FreeTypeFontGenerator.FreeTypeFontParameter()
    private val scoreParam: FreeTypeFontGenerator.FreeTypeFontParameter = FreeTypeFontGenerator.FreeTypeFontParameter()
    var startFont: BitmapFont
    var aiScoreFont: BitmapFont
    var playerScoreFont: BitmapFont

    init {
        startParam.size = Constants.FONT_SIZE
        scoreParam.size = Constants.SCORE_FONT_SIZE
        scoreParam.color = Color.GRAY
        startFont = generator.generateFont(startParam)
        aiScoreFont = generator.generateFont(scoreParam)
        playerScoreFont = generator.generateFont(scoreParam)
    }

    fun dispose() {
        generator.dispose()
        startFont.dispose()
        aiScoreFont.dispose()
        playerScoreFont.dispose()
    }
}