package com.example.hangman

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider

class HangmanView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
    private lateinit var viewModel: SharedViewModel
    private val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 10f
    }
    var incorrectGuesses = -1
        set(value) {
            field = value
            // Redraw the view whenever the value is changed
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val yHeightFull = height.toDouble()
        val xWidthFull = width.toDouble()

        val yHeight = yHeightFull*0.9
        val yBottom = yHeightFull*0.1
        val xRight = xWidthFull*0.6
        val xLeft = xWidthFull*0.2
        val middleGroundLeft = xLeft*2
        val middleGroundRight = xWidthFull*0.80
        val shortLineHeight = yHeightFull*0.2
        val headRadius = yHeightFull * 0.1
        val headYCoor = yBottom + headRadius*2
        val bodyYBot = headYCoor + headRadius
        val bodyYTop = yHeightFull*0.65
        val handYbot = bodyYBot +  headRadius*0.5
        val handYTop = handYbot + headRadius
        val handXRight = xWidthFull*0.3
        val handXLeft = xWidthFull*0.1
        val legYheight = bodyYBot + bodyYBot
        // Vertical line on right side
        canvas.drawLine(xRight.toFloat(), yHeight.toFloat(), xRight.toFloat(), yBottom.toFloat(), paint)
        // horizontal line on top
        canvas.drawLine(xRight.toFloat(), yBottom.toFloat(), xLeft.toFloat(), yBottom.toFloat(), paint)
        // horizontal line bottom
        canvas.drawLine(middleGroundLeft.toFloat() , yHeight.toFloat(), middleGroundRight.toFloat(), yHeight.toFloat() , paint)
        // short vertical line
        canvas.drawLine(xLeft.toFloat(), yBottom.toFloat(), xLeft.toFloat(), shortLineHeight.toFloat(), paint)

        //Make first mistake
        if (incorrectGuesses >= 1) {
            // Hangman Head
            canvas.drawCircle(xLeft.toFloat(), headYCoor.toFloat(), headRadius.toFloat(), paint)
        }

        if (incorrectGuesses >= 2) {
            // Hangman Body
            canvas.drawLine(xLeft.toFloat(), bodyYTop.toFloat(), xLeft.toFloat(), bodyYBot.toFloat(), paint)
        }

        if (incorrectGuesses >= 3) {
            // right arm
            canvas.drawLine(xLeft.toFloat(), handYbot.toFloat(), handXRight.toFloat(), handYTop.toFloat(), paint)
        }

        if (incorrectGuesses >= 4) {
            // left arm
            canvas.drawLine(xLeft.toFloat(), handYbot.toFloat(), handXLeft.toFloat(), handYTop.toFloat(), paint)
        }

        if (incorrectGuesses >= 5) {
            // Draw the right leg
            canvas.drawLine(xLeft.toFloat(), bodyYTop.toFloat(), handXRight.toFloat(), legYheight.toFloat(), paint)
        }

        if (incorrectGuesses >= 6) {
            // Draw the left leg
            canvas.drawLine(xLeft.toFloat(), bodyYTop.toFloat(), handXLeft.toFloat(), legYheight.toFloat(), paint)

        }
    }

    fun restartGame() {
        incorrectGuesses = 0 // Reset the counter to its initial state
        invalidate() // Force the view to redraw from scratch
    }

}
