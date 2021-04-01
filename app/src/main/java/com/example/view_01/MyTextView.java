package com.example.view_01;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyTextView extends View {
    private String mText;
    private int mTextSize=15;
    private int mTextColor= Color.BLACK;

    //创建是调用  new MyTextView
    public MyTextView(Context context) {
        this(context,null);
    }

    //布局时调用
    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    //布局设置类型时调用 style
    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取自定义属性
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.MyTextView);
        mText=typedArray.getString(R.styleable.MyTextView_text);
        mTextColor=typedArray.getColor(R.styleable.MyTextView_textColor,mTextColor);
        mTextSize=typedArray.getDimensionPixelSize(R.styleable.MyTextView_textSize,mTextSize);

        typedArray.recycle();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e("event","手指放下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("event","手指移动");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("event","手指抬起");
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
