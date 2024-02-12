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
        strokeWidth = 8f
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
        canvas.drawLine(width.toFloat() - 200f, height.toFloat() - 50f, width.toFloat() - 200f, 0f, paint)
        // horizontal line on top
        canvas.drawLine(width.toFloat() - 200f, 0f, width.toFloat()/2, 0f, paint)
        // horizontal line bottom
        canvas.drawLine(width.toFloat(), height.toFloat() - 50f, width.toFloat()/2, height.toFloat() - 50f, paint)
        // short vertical line
        canvas.drawLine(width.toFloat()/2, 0f, width.toFloat()/2, 50f, paint)


        Log.d("HangmanView", "Width / 2: ${width.toFloat() / 2}")

//// Draw the horizontal bar
//        canvas.drawLine(width / 2f - armLength, baseLineHeight, width / 2f + armLength, baseLineHeight, paint)
//
//// Draw the vertical bar
//        canvas.drawLine(width / 2f, baseLineHeight, width / 2f, baseLineHeight + 2 * headRadius + legLength, paint)

//// Draw the head
//        canvas.drawCircle(width / 2f, baseLineHeight + headRadius, headRadius, paint)
//
//// Hangman body
//        canvas.drawLine(width / 2f, baseLineHeight + 2 * headRadius, width / 2f, baseLineHeight + 2 * headRadius + legLength, paint)
//
//// Right arm (angled upwards)
//        canvas.drawLine(width / 2f, baseLineHeight + 1.5f * headRadius, width / 2f + armLength, baseLineHeight + headRadius, paint)
//
//// Left arm (angled downwards)
//        canvas.drawLine(width / 2f, baseLineHeight + 1.5f * headRadius, width / 2f - armLength, baseLineHeight + headRadius + armLength, paint)
//
//// Right leg (straight)
//        canvas.drawLine(width / 2f, baseLineHeight + 2 * headRadius + legLength, width / 2f, baseLineHeight + 2 * headRadius + legLength + footLength, paint)
//
//// Left leg (angled)
//        canvas.drawLine(width / 2f, baseLineHeight + 2 * headRadius + legLength, width / 2f - legLength / 2, baseLineHeight + 2 * headRadius + legLength + footLength, paint)

//
//        // Draw the horizontal bar
//        canvas.drawLine(width / 2f - 2 * armLength, height - headRadius, width / 2f + 2 * armLength, height - headRadius, paint)
//        // Draw the vertical bar
//        canvas.drawLine(width / 2f, height - headRadius, width / 2f, height - headRadius + legLength, paint)
//        // Draw the head
//        canvas.drawCircle(width / 2f, height - headRadius, headRadius, paint)
//        // Hangman body
//        canvas.drawLine(width / 2f, height - headRadius, width / 2f, height - headRadius - 2 * armLength, paint)
//        // Right arm
//        canvas.drawLine(width / 2f + armLength, height - headRadius, width / 2f + armLength, height - headRadius - armLength, paint)
//        // Left arm
//        canvas.drawLine(width / 2f - armLength, height - headRadius, width / 2f - armLength, height - headRadius - armLength, paint)
//        // Draw the right leg
//        canvas.drawLine(width / 2f + legLength / 2, height - headRadius + legLength, width / 2f + legLength / 2, height - headRadius + legLength + footLength, paint)
//        // Draw the left leg
//        canvas.drawLine(width / 2f - legLength / 2, height - headRadius + legLength, width / 2f - legLength / 2, height - headRadius + legLength + footLength, paint)

        //Make first mistake
        if (incorrectGuesses >= 1) {
            // Hangman body
            canvas.drawLine(width / 2f, height - headRadius, width / 2f, height - headRadius - 2 * armLength, paint)
//            canvas.drawLine(width / 2f, 200f, width / 2f, 400f, paint) // Body
        }

        if (incorrectGuesses >= 2) {
            // Right arm
            canvas.drawLine(width / 2f + armLength, height - headRadius, width / 2f + armLength, height - headRadius - armLength, paint)
//            canvas.drawLine(width / 2f, 250f, 2 * width / 3f, 300f, paint) // Right arm
        }

        if (incorrectGuesses >= 3) {
            // Left arm
            canvas.drawLine(width / 2f - armLength, height - headRadius, width / 2f - armLength, height - headRadius - armLength, paint)
//            canvas.drawLine(width / 2f, 250f, width / 3f, 300f, paint) // Left arm
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
//            canvas.drawLine(width / 2f, 400f, width / 3f, 500f, paint) // Left leg
        }
    }

//    fun setIncorrectGuesses(value: Int) {
//        incorrectGuesses = 5
//        invalidate() // Redraw the view
//    }
}
