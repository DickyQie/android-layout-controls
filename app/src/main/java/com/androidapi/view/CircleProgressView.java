package com.androidapi.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zq on 2016/6/6.
 */

public class CircleProgressView extends View {
    private int mWidth, mHeight, mRadius;
    private Paint mPaint;
    private float degree;
    private ValueAnimator degreeAnimation;

    public CircleProgressView(Context context) {
        super(context);
        init();
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(mWidth / 2, mHeight / 2);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.rotate(degree);
        for (int i = 0; i < 12; i++) {
            if (i == 0 || i == 1 || i == 2) {
                mPaint.setColor(Color.GRAY);
            } else {
                mPaint.setColor(Color.LTGRAY);
            }
            RectF rectF = new RectF(-mRadius / 4, -mRadius * 7 / 2, mRadius / 4, -mRadius * 2);
            canvas.drawRoundRect(rectF, mRadius / 8, mRadius / 8, mPaint);
            canvas.rotate(30);
            canvas.save();
        }
        canvas.restore();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = widthSize * 1 / 2;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = heightSize * 1 / 2;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mWidth = getWidth();
        mHeight = getHeight();
        mRadius = mWidth / 10;
    }

    public void startAnimation() {

        degree = 0;
        degreeAnimation = ValueAnimator.ofFloat(0, 360);
        degreeAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                degree = (float) animation.getAnimatedValue();
                invalidate();
            }

        });
        degreeAnimation.setRepeatCount(ValueAnimator.INFINITE);
        degreeAnimation.setDuration(1000);
        degreeAnimation.start();
    }

    public void endAnimation() {
        degreeAnimation.end();
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (!hasWindowFocus) {
            endAnimation();
        }
    }

}
