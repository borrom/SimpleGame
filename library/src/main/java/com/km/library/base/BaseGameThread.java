package com.km.library.base;


import android.graphics.Canvas;
import android.view.SurfaceHolder;

public abstract class BaseGameThread implements Runnable {

    private SurfaceHolder mSurfaceHolder;
    private boolean mIsRunning =  true;
    private double mTotalElapseTime;

    public BaseGameThread(SurfaceHolder holder){
        mSurfaceHolder = holder;
    }

    public void setRunning(boolean running){
        mIsRunning = running;
    }
    @Override
    public void run() {
        Canvas canvas = null;
        long previousFrameLine = System.currentTimeMillis();
        while (mIsRunning){
            try {
                canvas = mSurfaceHolder.lockCanvas(null);
                synchronized (mSurfaceHolder){
                    long currentTime = System.currentTimeMillis();
                    double elapseTime = currentTime - previousFrameLine;
                    mTotalElapseTime += elapseTime/100.0;
                }
            }catch (Exception ex){

            }finally {
                if(canvas != null){
                    mSurfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
