package com.example.hangman

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View

class HangmanView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
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

        val headRadius = 50f
        val armLength = 50f
        val legLength = 50f
        val footLength = 20f
        val baseLineHeight = height - 2 * headRadius - legLength - footLength

        // Vertical line on right side
        canvas.drawLine(width.toFloat() - 400f, height.toFloat() - 50f, width.toFloat() - 400f, 100f, paint)
        // horizontal line on top
        canvas.drawLine(width.toFloat() - 400f, 100f, width.toFloat()-800f, 100f, paint)
        // horizontal line bottom
        canvas.drawLine(width.toFloat()-150f, height.toFloat() - 50f, width.toFloat()-650f, height.toFloat() - 50f, paint)
        // short vertical line
        canvas.drawLine(width.toFloat()-800f, 100f, width.toFloat()-800f, 200f, paint)


        Log.d("HangmanView", "Width / 2: ${width.toFloat() / 2}")


        //Make first mistake
        if (incorrectGuesses >= 1) {
            // Hangman body
            canvas.drawLine(width / 2f, height - headRadius, width / 2f, height - headRadius - 2 * armLength, paint)
            // canvas.drawLine(width / 2f, 200f, width / 2f, 400f, paint) // Body
        }

        if (incorrectGuesses >= 2) {
            // Right arm
            canvas.drawLine(width / 2f + armLength, height - headRadius, width / 2f + armLength, height - headRadius - armLength, paint)
            // canvas.drawLine(width / 2f, 250f, 2 * width / 3f, 300f, paint) // Right arm
        }

        if (incorrectGuesses >= 3) {
            // Left arm
            canvas.drawLine(width / 2f - armLength, height - headRadius, width / 2f - armLength, height - headRadius - armLength, paint)
            // canvas.drawLine(width / 2f, 250f, width / 3f, 300f, paint) // Left arm
        }

        if (incorrectGuesses >= 4) {
            // Draw the right leg
            canvas.drawLine(width / 2f + legLength / 2, height - headRadius + legLength, width / 2f + legLength / 2, height - headRadius + legLength + footLength, paint)
            // Right leg
            canvas.drawLine(width / 2f, 400f, 2 * width / 3f, 500f, paint) // Right leg
        }

        if (incorrectGuesses >= 5) {
            // Draw the left leg
            canvas.drawLine(width / 2f - legLength / 2, height - headRadius + legLength, width / 2f - legLength / 2, height - headRadius + legLength + footLength, paint)
            // Left leg
            // canvas.drawLine(width / 2f, 400f, width / 3f, 500f, paint) // Left leg
        }
    }
}
