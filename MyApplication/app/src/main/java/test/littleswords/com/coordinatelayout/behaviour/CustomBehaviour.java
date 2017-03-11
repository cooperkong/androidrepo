package test.littleswords.com.coordinatelayout.behaviour;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

import test.littleswords.com.coordinatelayout.R;

/**
 * Created by wenchaokong on 22/02/2017.
 */

public class CustomBehaviour<V extends View> extends CoordinatorLayout.Behavior<V> {

    private int minimumWidth;
    private int minimumHeight;
    private float imageInitialHeight;
    private float screenWidth;
    private float screenHeight;
    private int newTop;
    private ViewDragHelper mViewDragHelper;
    private DisplayMetrics displayMetrics;
    private WeakReference<View> mChildRef;
    private WeakReference<View> mDependencyRef;
    private int initialDependencyLeft;
    private int initialDependencyTop;
    private int initialDependencyRight;
    private int initialDependencyBottom;
    private boolean ifTransparentEnough;

    public CustomBehaviour(Context context, AttributeSet attrs) {
        super(context, attrs);
        displayMetrics = context.getResources().getDisplayMetrics();
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;
        imageInitialHeight = context.getResources().getDimensionPixelSize(R.dimen.image_initial_height);
        minimumWidth = context.getResources().getDimensionPixelSize(R.dimen.minimum_width);
        minimumHeight = context.getResources().getDimensionPixelSize(R.dimen.minimum_height);
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, V child, int layoutDirection) {
        if (mViewDragHelper == null) {
            mViewDragHelper = ViewDragHelper.create(parent, mDragCallback);
        }
        return false;
    }
    private ViewDragHelper.Callback mDragCallback = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return child instanceof ImageView;
        }

        @Override
        public int clampViewPositionVertical(final View child, int top, int dy) {
            final int topBound = mChildRef.get().getPaddingTop();
            final int bottomBound = mDependencyRef.get().getHeight() - mChildRef.get().getHeight();
            newTop = Math.min(Math.max(top, topBound), bottomBound);
            return newTop;
        }
    };

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent ev) {

        final int action = MotionEventCompat.getActionMasked(ev);
        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            mViewDragHelper.cancel();
            return false;
        }
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return !ifTransparentEnough;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, V child, View dependency) {
        return child != null && dependency instanceof ImageView;
    }

    @Override
    public boolean onDependentViewChanged(final CoordinatorLayout parent, V child, View dependency) {
        if(mChildRef == null)
            mChildRef = new WeakReference<View>(child);
        if(mDependencyRef == null)
            mDependencyRef = new WeakReference<View>(parent);
        if(newTop == 0){
            //record initial size;
            initialDependencyLeft = dependency.getLeft();
            initialDependencyTop= dependency.getTop();
            initialDependencyBottom = dependency.getBottom();
            initialDependencyRight = dependency.getRight();
        }
//        int offset = (int) (newTop/2);
        float alpha = (float) (1.0 - (newTop / (screenHeight - imageInitialHeight) ));
        dependency.layout( (initialDependencyLeft + newTop/3), newTop, (int) screenWidth, (initialDependencyBottom + newTop));
        child.setAlpha(alpha);
        child.setTranslationY(newTop);
        dependency.post(new Runnable() {
            @Override
            public void run() {
                parent.setTop(newTop);
            }
        });
//        parent.setAlpha(alpha);
//        if(alpha < 0.2) ifTransparentEnough = true;
        return true;
    }
}
