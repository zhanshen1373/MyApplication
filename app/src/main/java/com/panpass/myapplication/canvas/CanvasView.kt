package com.panpass.myapplication.canvas

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class CanvasView(context: Context,attributeSet: AttributeSet):View(context,attributeSet) {

    init {
        initBitmap()
    }

    private fun initBitmap() {
     resources.getDrawable()
    }

    override fun onDraw(canvas: Canvas?) {
        canvas.drawBitmap()
    }
}