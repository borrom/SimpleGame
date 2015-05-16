package com.km.simplegame.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.km.library.base.BaseGameView;

public class GameView extends BaseGameView{
    private Line mBlocker;
    private Line mTarget;
    private Paint mBackgroundPaint;


    public GameView(Context context) {
        super(context);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mBlocker = new Line();
        mTarget = new Line();
        mBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBackgroundPaint.setAntiAlias(true);
        mBackgroundPaint.setStyle(Paint.Style.FILL);
        mBackgroundPaint.setColor(Color.WHITE);
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawGameElement(canvas);
    }

    private void drawGameElement(Canvas canvas){
        canvas.drawCircle(0,0,getWidth()/2,mBackgroundPaint);
        canvas.drawRect(0,0,getWidth(),getHeight(),mBackgroundPaint);
    }
}
