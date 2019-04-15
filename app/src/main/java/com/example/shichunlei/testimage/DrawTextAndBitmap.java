package com.example.shichunlei.testimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by shichunlei
 * on 2019/4/8
 */
public class DrawTextAndBitmap extends View {

    private Bitmap bitmap;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint layerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    private RectF rectF = new RectF();
    private float[] measureWidth = new float[1];
    private String text = "学习之于心灵，就像食物之于身体一样。摄取了适量的营养食物，我们的身体得以生长而肌肉得以发达。" +
            "同样地，我们应该日复一日不断地学习以保持我们敏锐的心智能力，并扩充我们的智力容量。不断的学习提供我们用不尽的燃料，" +
            "来驱使我们磨利我们的推理、分析和判断的能力。持续的学习是在信息时代中跟时代并驾齐驱的最稳当的方法，也是在变动的世代" +
            "中成功的可靠保证.一旦学习停止，单调贫乏的生活就开始了。视学校为汲取知识的唯一场所是种常见的谬误。相反地，学习应该是一种" +
            "无终止的历程，从生到死。由于世界一直快速地在变动，只要学习停顿数日就将使人落后。更糟的是，蛰伏在我们潜意识深处的兽性本能就会复" +
            "活，削弱我们追求高贵理想的意志，弱化我们扫除成功障碍的决心，而且扼杀我们净化我们人格的欲望。缺少学习将不可避免地导致心灵的停滞，甚至更糟地";
    private Paint.FontMetrics fontMetrics;
    public static final int BITMAP_TOP = 200;
    private Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);

    public DrawTextAndBitmap(Context context) {
        super(context);

    }

    public DrawTextAndBitmap(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawTextAndBitmap(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF.set(50, 50, 450, 400);
    }

    {
        textPaint.setTextSize(39);
        bitmap = getBitmap(500);
        fontMetrics = textPaint.getFontMetrics();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        StaticLayout staticLayout = new StaticLayout(text,textPaint,canvas.getWidth(), Layout.Alignment.ALIGN_NORMAL,1,0,false);
//        staticLayout.draw(canvas);
        int height = bitmap.getHeight();
        int layer = canvas.saveLayer(0, 0, getWidth(), getHeight(), paint);
        canvas.drawOval(getWidth() / 2 - 200, BITMAP_TOP, getWidth() / 2 + 200, BITMAP_TOP + 400, paint);

        paint.setXfermode(xfermode);
        canvas.drawBitmap(bitmap, getWidth() / 2 - 250, BITMAP_TOP, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(layer);
        int count = 0;
        float startX = 0;
        int tempCount = 0;
        float textY = textPaint.getFontSpacing();
        float useableWidth;
        for (int i = 0; i < text.length(); i += count, textY += textPaint.getFontSpacing()) {
            float textTop = textY + fontMetrics.top;
            float textBottom = textY + fontMetrics.bottom;
            if (textBottom > BITMAP_TOP && textBottom <= BITMAP_TOP + 200) {
                useableWidth = getWidth() / 2 - (float) Math.sqrt(Math.pow(200.00, 2) - Math.pow(200 + BITMAP_TOP - textBottom, 2));
            } else if (textTop >= BITMAP_TOP + 200 && textTop < BITMAP_TOP + 400) {
                useableWidth = getWidth() / 2 - (float) Math.sqrt(Math.pow(200.00, 2) - Math.pow(textTop - BITMAP_TOP-200, 2));
            } else if (textBottom > BITMAP_TOP + 200 &&textTop < BITMAP_TOP + 200) {
                useableWidth = getWidth() / 2 - 200;
            } else if(textBottom <= BITMAP_TOP || textTop >= BITMAP_TOP+400){
                useableWidth = getWidth();
            }else {
                useableWidth = 0;
            }
            count = textPaint.breakText(text, i, text.length(), true, useableWidth, measureWidth);
            canvas.drawText(text, i, i + count, 0, textY, textPaint);
            if (useableWidth != getWidth()) {
                tempCount = textPaint.breakText(text, count, text.length(), true, useableWidth, measureWidth);
                canvas.drawText(text, i + count, tempCount + i + count, getWidth() -useableWidth, textY, textPaint);
                count += tempCount;
            }
        }


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
