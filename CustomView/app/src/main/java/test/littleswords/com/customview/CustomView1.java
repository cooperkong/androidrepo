package test.littleswords.com.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wenchaokong on 9/02/2017.
 */

public class CustomView1 extends View {
    private Paint paint = new Paint();
    private int height;
    private int width;
    Path path = new Path();

    public CustomView1(Context context) {
        this(context, null);
    }

    public CustomView1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        System.out.println("caonima!");
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        //use of line to
//        canvas.translate(width/4, height / 4);
//        path.lineTo(200, 200);
//        path.lineTo(200, 0);
//        canvas.drawPath(path, paint);

        //use of moveto
        path.reset();
        canvas.translate(width/3, height / 3);
        paint.setColor(Color.GREEN);
        path.lineTo(200, 200);
        path.moveTo(0, 50);
        path.lineTo(0, 150);
        canvas.drawPath(path, paint);

        //use of setlastpoint
        canvas.translate(width/2, height / 2);
        path.reset();
        paint.setColor(Color.BLUE);
        path.lineTo(200, 200);
        path.setLastPoint(200, 100);
        path.lineTo(100, 0);
        canvas.drawPath(path, paint);
    }
}
