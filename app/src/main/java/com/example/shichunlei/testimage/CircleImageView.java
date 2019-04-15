package com.example.shichunlei.testimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shichunlei
 * on 2019/4/8
 */
public class CircleImageView extends View {

    private Bitmap bitmap;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    private RectF rectF = new RectF();

    public CircleImageView(Context context) {
        super(context);
        bitmap = getBitmap(500);

    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap = getBitmap(500);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap = getBitmap(500);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF.set(50, 50, 450, 400);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = canvas.saveLayer(rectF, paint);
        canvas.drawBitmap(bitmap, 50, 50, paint);
        paint.setXfermode(xfermode);
        canvas.drawOval(rectF, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(i);
    }


    public Bitmap getBitmap(int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.header, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;
        return BitmapFactory.decodeResource(getResources(), R.mipmap.header, options);
    }
}
