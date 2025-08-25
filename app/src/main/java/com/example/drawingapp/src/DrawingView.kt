package com.example.drawingapp.src


import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import androidx.core.graphics.createBitmap
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorInt


class DrawingView(context: Context): View(context){

    private lateinit var drawPath: FingerPath //tracks current path of finger movement

    private lateinit var canvasPaint: Paint

    private lateinit var drawPaint: Paint

    private var color: Int = Color.BLACK

    private lateinit var mcanvas: Canvas

    private lateinit var canvasBitmap: Bitmap

    private var brushSize: Float = 0.toFloat()

    private val paths = mutableListOf<FingerPath>() //  stores all paths

    init {
        setUpDrawing()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        // get coordinates of touch point
        val touchX = event?.x
        val touchY = event?.y

        // handle touch event
        when(event?.action){

            // started drawing something, reset path, color and brush size to reflect changes
            MotionEvent.ACTION_DOWN -> {

                drawPath.color = color
                drawPath.brushThickness = brushSize

                drawPath.reset()

                drawPath.moveTo(touchX!!, touchY!!) //move to point of touch

            }

            // dragging finger on screen, follow along
            MotionEvent.ACTION_MOVE -> {

                drawPath.lineTo(touchX!!, touchY!!)

            }

            // lifted finger, reinitialize drawPath and add previous path to paths
            MotionEvent.ACTION_UP -> {

                drawPaint.color = drawPath.color
                drawPaint.strokeWidth = drawPath.brushThickness
                mcanvas.drawPath(drawPath, drawPaint)
                paths.add(drawPath)
                drawPath = FingerPath(color, brushSize)

            }

            // no touch return false
            else -> return false

        }
        invalidate()

        return true

    }

    override fun onDraw(canvas: Canvas) {

        super.onDraw(canvas)
        canvas.drawBitmap(canvasBitmap, 0f, 0f, drawPaint) // draw bitmap from top left corner on canvas

        // check if a path was drawn
        if(!drawPath.isEmpty){

            drawPaint.color = drawPath.color
            drawPaint.strokeWidth = drawPath.brushThickness

            canvas.drawPath(drawPath, drawPaint)

        }

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {

        super.onSizeChanged(w, h, oldw, oldh)
        canvasBitmap = createBitmap(w, h) //create bitmap with ARGB_8888 config ARGB_8888 is 32-bit color
        mcanvas = Canvas(canvasBitmap)

    }

    fun changeBrushSize(newBrushSize: Float){

        // fancy things so that it doesn't change drastically for same values with different res devices
        brushSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, newBrushSize, resources.displayMetrics)
        drawPaint.strokeWidth = brushSize
    }

    fun changeBrushColor(newColor: String){

        color = newColor.toColorInt()

    }

    fun setUpDrawing(){

        // initialize drawPaint, drawPath and canvasPaint
        brushSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20.toFloat(), resources.displayMetrics)
        drawPaint = Paint()
        drawPaint.color = color
        drawPaint.style = Paint.Style.STROKE
        drawPaint.strokeWidth = brushSize
        drawPaint.strokeJoin = Paint.Join.ROUND
        drawPaint.strokeCap = Paint.Cap.ROUND

        drawPath = FingerPath(color, brushSize)
        canvasPaint = Paint(Paint.DITHER_FLAG) //DITHER_FLAG makes colors smoother



    }

    fun getBrushSize(): Int{
        return brushSize.toInt()
    }

    internal inner class FingerPath(var color: Int, var brushThickness: Float): Path()

}