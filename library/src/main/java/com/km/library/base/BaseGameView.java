package com.km.library.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public abstract class BaseGameView extends SurfaceView implements SurfaceHolder.Callback{
    private int mScreenWidth;
    private int mScreenHeight;
    private SurfaceHolder mHolder;

    public BaseGameView(Context context) {
        super(context);
    }

    public BaseGameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);


    }

    public BaseGameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BaseGameView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);

        mScreenWidth = width;
        mScreenHeight = height;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = null;
        try {
            synchronized (this){
                canvas = holder.lockCanvas(null);
                Paint paint = new Paint();
                paint.setColor(Color.WHITE);
                canvas.drawRect(0,0,getWidth(),getHeight(),paint);
            }

        }finally {
            holder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
