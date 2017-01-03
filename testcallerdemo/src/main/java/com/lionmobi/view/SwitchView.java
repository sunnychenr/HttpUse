package com.lionmobi.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.lionmobi.utils.LogUtil;

/**
 * Created by ChenR on 2016/12/27.
 */

public class SwitchView extends CompoundButton {

    private float viewWidth;
    private float viewHeight;
    private float mWidth = 50;
    private float mHeight = 25;
    private float density;

    private float cx;

    private Paint p1;
    private Paint p2;
    private Canvas can;

    private float radius;

    public SwitchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setBackgroundColor(0x00000000);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        density = outMetrics.density;

        mWidth = 50 * density;
        mHeight = 25 * density;

        radius = (mHeight - 8) / 2;
        cx = (mWidth - mHeight) / 2;

        p1 = new Paint();
        p1.setAntiAlias(true);
        p1.setColor(0xffc4c4c4);

        p2 = new Paint();
        p2.setColor(0xffffffff);
        p2.setAntiAlias(true);
    }

    private boolean isFirst;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (!isFirst) {
            int height = getLayoutParams().height;
            int width = getLayoutParams().width;

            LogUtil.log("height ----> " + height);
            LogUtil.log("width -----> " + width);
            LogUtil.log("getTop() -----> " + getTop());
            LogUtil.log("getBottom() -----> " + getBottom());
            LogUtil.log("getWidth() -----> " + getWidth());

            rect = new RectF(0, 0, (int) mWidth, (int) mHeight);

            isFirst = true;
        }

    }

    private RectF rect;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(rect, (mWidth - mHeight) / 2, mHeight / 2, p1);
        canvas.drawCircle(cx, mHeight / 2, radius, p2);
    }

    private float startX;
    private boolean isOpen;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                float moveX = event.getX() - startX;

                LogUtil.log("moveX ---> " + moveX);

                if (moveX < (mWidth - mHeight) / 2) {
                    cx = (mWidth - mHeight) / 2;
                    p1.setColor(0xffc4c4c4);
                } else if (moveX > mWidth - mHeight / 2) {
                    cx = mWidth - mHeight / 2;
                    p1.setColor(0xff3f9cff);
                } else {
                    cx = moveX;
                }
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                float upX = event.getX();

                break;
        }

        return true;
    }

    private void startAnimate(final float move) {
        final float v = Math.abs(move) / 20;
        final int time = 200;
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 20) {
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    can.drawCircle(v * i + move, mHeight / 2, radius, p2);
                    postInvalidate();
                    i ++;
                }
            }
        }).start();
    }
}
