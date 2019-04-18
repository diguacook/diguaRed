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
    public float bottomFlip = 0;
    public float degree = 0;
    public float topFlip= 0;


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

    }
    private float height = bitmap.getHeight();

    public float getBottomFlip() {
        return bottomFlip;
    }

    public void setBottomFlip(float bottomFlip) {
        this.bottomFlip = bottomFlip;
        invalidate();
    }

    public float getDegree() {
        return degree;
    }

    public void setDegree(float degree) {
        this.degree = degree;
        invalidate();
    }

    public float getTopFlip() {
        return topFlip;
    }

    public void setTopFlip(float topFlip) {
        this.topFlip = topFlip;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("x+y+z:",camera.getLocationX()+","+camera.getLocationY()+","+camera.getLocationZ());

        canvas.save();
        canvas.translate(IMAGE_PADDING+IMAGE_WIDTH/2,IMAGE_PADDING+height/2);
        canvas.rotate(-degree);
        camera.save();
        camera.rotateX(topFlip);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.clipRect(-IMAGE_WIDTH,-IMAGE_WIDTH,IMAGE_WIDTH,0);
        canvas.rotate(degree);
        canvas.translate(-(IMAGE_PADDING+IMAGE_WIDTH/2),-(IMAGE_PADDING+height/2));
        canvas.drawBitmap(bitmap,IMAGE_PADDING,IMAGE_PADDING,paint);
        canvas.restore();


        canvas.save();
        canvas.translate(IMAGE_PADDING+IMAGE_WIDTH/2,IMAGE_PADDING+height/2);
        canvas.rotate(-degree);
        camera.save();
        camera.rotateX(bottomFlip);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.clipRect(-IMAGE_WIDTH,0,IMAGE_WIDTH,IMAGE_WIDTH);
        canvas.rotate(degree);
        canvas.translate(-(IMAGE_PADDING+IMAGE_WIDTH/2),-(IMAGE_PADDING+height/2));
        canvas.drawBitmap(bitmap,IMAGE_PADDING,IMAGE_PADDING,paint);
        canvas.restore();

    }
}
