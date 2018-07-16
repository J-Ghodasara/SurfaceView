package com.example.jayghodasara.surfaceview

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Toast

class MySurface(context: Context): SurfaceView(context),SurfaceHolder.Callback {

    var surfaceholder:SurfaceHolder = holder
    var biticon=BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher)


    init {

        surfaceholder.addCallback(this)
    }
    constructor(context: Context,attributeSet: AttributeSet) : this(context){}

    constructor(context: Context,attributeSet: AttributeSet,defstyle:Int) : this(context){}

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        Toast.makeText(context,"Destroyed",Toast.LENGTH_LONG).show()
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        Toast.makeText(context,"Surface Created",Toast.LENGTH_LONG).show()
        var canvas:Canvas= holder!!.lockCanvas()
        var paint=Paint()
        paint.color = Color.RED
        //canvas.drawColor(Color.RED)
         canvas.drawCircle((width/2).toFloat(),(height/2).toFloat(),100f,paint)
        holder.unlockCanvasAndPost(canvas)

//        canvas.drawBitmap(biticon,(width/2).toFloat(),(height/2).toFloat(),paint)
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        Toast.makeText(context,"Surface Changed",Toast.LENGTH_LONG).show()
    }

}