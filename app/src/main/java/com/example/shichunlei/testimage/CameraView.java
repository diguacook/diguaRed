package com.example.shichunlei.testimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by shichunlei
 * on 2019/4/15
 */
public class CameraView extends View {

    private Camera camera = new Camera();
    private Bitmap bitmap;
    private static final int IMAGE_WIDTH = 500;
    private static final int IMAGE_PADDING = 100;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CameraView(Context context) {
        super(context);
    }

    public CameraView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CameraView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = Utils.getBitmap(getResources(),IMAGE_WIDTH);
        camera.rotate(0,-10,0);

    }
    private float height = bitmap.getHeight();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("x+y+z:",camera.getLocationX()+","+camera.getLocationY()+","+camera.getLocationZ());
        canvas.save();
        canvas.clipRect(IMAGE_PADDING,IMAGE_PADDING,IMAGE_PADDING+IMAGE_WIDTH/2,IMAGE_PADDING+height);
        canvas.drawBitmap(bitmap,IMAGE_PADDING,IMAGE_PADDING,paint);
        canvas.restore();
        canvas.save();
//        canvas.translate( 0,-IMAGE_PADDING-height/2);
        canvas.clipRect(IMAGE_PADDING+IMAGE_WIDTH/2,IMAGE_PADDING,IMAGE_PADDING+IMAGE_WIDTH,IMAGE_PADDING+height);
        camera.applyToCanvas(canvas);
        canvas.drawBitmap(bitmap,IMAGE_PADDING,IMAGE_PADDING,paint);
        canvas.restore();

    }
}
