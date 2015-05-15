package com.km.simplegame.view;

import android.content.Context;
import android.util.AttributeSet;

import com.km.library.base.BaseGameView;

public class GameView extends BaseGameView{
    private Line mBlocker;
    private Line mTarget;


    public GameView(Context context) {
        super(context);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mBlocker = new Line();
        mTarget = new Line();
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
