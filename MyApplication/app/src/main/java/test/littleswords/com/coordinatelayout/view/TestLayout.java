package test.littleswords.com.coordinatelayout.view;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import test.littleswords.com.coordinatelayout.R;

/**
 * Created by wenchaokong on 28/02/2017.
 */

public class TestLayout extends LinearLayout {
    private ViewDragHelper mDragHelper;
    private View image;

    public TestLayout(Context context) {
        this(context, null);
    }

    public TestLayout(Context context, AttributeSet attrs) {
        this(context, attrs ,0);
    }

    public TestLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        image = findViewById(R.id.test_image);
    }

    private void init() {
        mDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return true;
            }
            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                Log.d("DragLayout", "clampViewPositionHorizontal " + left + "," + dx);
                final int leftBound = getPaddingLeft();
                final int rightBound = getWidth() - image.getWidth();
                final int newLeft = Math.min(Math.max(left, leftBound), rightBound);
                return newLeft;
            }

        });

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        final int action = MotionEventCompat.getActionMasked(ev);
        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            mDragHelper.cancel();
            return false;
        }
        return mDragHelper.shouldInterceptTouchEvent(ev);
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        mDragHelper.processTouchEvent(ev);
        return true;
    }
}
