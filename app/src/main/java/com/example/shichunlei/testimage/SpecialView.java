package com.example.shichunlei.testimage;

import android.app.IntentService;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by shichunlei
 * on 2019/3/30
 */
public class SpecialView extends View {

    private Paint paint = new Paint();
    private Paint linePaint = new Paint();
    private Path path = new Path();
    private Paint textPaint = new TextPaint();

    //红色脖子
    private Paint neckPaint = new Paint();
    private RectF rectFNeck = new RectF();
    private int x = 100;
    private int y = 100;
    private float l = 0;
    private int[] angles = {30, 60, 90, 20, 160};
    private int[] colors = {Color.parseColor("#27ad9a"),
            Color.parseColor("#000000"),
            Color.parseColor("#5527ad9a"),
            Color.parseColor("#7027ad9a"),
            Color.parseColor("#27cd9a")};
    public static final float ROUND = 180.0000f;
    private static final float translateL = 10.0000f;
    private int flag = 1;
    //圆心坐标
    private int CIRCLE_Y = 300;
    private int CIRCLE_X;
    private int RADIUS = 200;
    private int LINE = 40;
    private int LINE_STRAIGHT = 100;

    public SpecialView(Context context) {
        super(context);
        startThread();
    }

    public SpecialView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        startThread();
    }

    public SpecialView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d("Thread", "Thread");
        startThread();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        CIRCLE_X = getWidth() / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawColor(Color.BLUE);
//        paint.setColor(Color.BLACK);
//        paint.setStrokeWidth(10);
//        paint.setStyle(Paint.Style.FILL);
//        linePaint.setStyle(Paint.Style.STROKE);
//        linePaint.setStrokeWidth(3);
//        textPaint.setTextSize(30);
//        Shader linearGradient = new LinearGradient(100, 200, 200, 100, Color.parseColor("#27ad9a"), Color.parseColor("#2196f3"), Shader.TileMode.CLAMP);
//        linePaint.setShader(linearGradient);
        //        canvas.drawCircle(300,300,200,paint);
//        path.addCircle(300,300,200, Path.Direction.CW);
//        path.addCircle(500,300,150, Path.Direction.CW);
//        canvas.drawPath(path,paint);
//        neckPaint.setStyle(Paint.Style.FILL);
//        neckPaint.setColor(Color.RED);
//        RectF rectFHead = new RectF();
//        rectFHead.set(CIRCLE_X - 200, 100, CIRCLE_X + 200, 500);
//        RectF rectFace = new RectF();
//        rectFace.set(150, 180, 450, 500);
//        rectFNeck.set(150, 450, 450, 490);
//        canvas.drawArc(rectF,180,120,true,linePaint);
//        canvas.drawArc(rectFHead,130,l-6,false,paint);
//        canvas.drawArc(rectFace,136,l-18,false,paint);
//        canvas.drawRect(rectFNeck,neckPaint);
        Log.d("cos", Math.sin(Math.PI / 3) + "");
//        canvas.drawLine(200, 300 - (float)Math.sin(Math.PI/3)*200,200-(float)Math.cos(Math.PI/3)*50,300 - (float)Math.sin(Math.PI/3)*250,paint);
//        canvas.drawLine(200-(float)Math.cos(Math.PI/3)*50,300 - (float)Math.sin(Math.PI/3)*250,100-(float)Math.cos(Math.PI/3)*50,300 - (float)Math.sin(Math.PI/3)*250,paint);
//        canvas.drawPoint( x, y, linePaint);

//        path.addCircle(400,400,200, Path.Direction.CW);
//        path.addCircle(400,440,160, Path.Direction.CCW);
        path.setFillType(Path.FillType.EVEN_ODD);
        path.addOval(300,560,500,600, Path.Direction.CW);
        canvas.drawPath(path,paint);
        int startAngle = 0;
//        for (int i = 0; i < colors.length; i++) {
//            int save = canvas.save();
//            int translateAngle = startAngle + angles[i] / 2;
//            linePaint.setColor(colors[i]);
//            textPaint.setColor(colors[i]);
//            Log.d("1-angles[i] / 360", translateAngle / 360.0000 + "");
//            if (translateAngle > 0 && translateAngle <= 90 ) {
//                float dx = (float) Math.cos(Math.PI * translateAngle / ROUND);
//                float dy = (float) Math.sin(Math.PI * translateAngle / ROUND);
//                canvas.translate(translateL * dx, translateL * dy);
//                canvas.drawLine(CIRCLE_X + RADIUS * dx, CIRCLE_Y + RADIUS * dy, CIRCLE_X + (RADIUS + LINE) * dx, CIRCLE_Y + (RADIUS + LINE) * dy, linePaint);
//                canvas.drawLine(CIRCLE_X + (RADIUS + LINE) * dx, CIRCLE_Y + (RADIUS + LINE) * dy, CIRCLE_X + (RADIUS + LINE) * dx + LINE_STRAIGHT, CIRCLE_Y + (RADIUS + LINE) * dy, linePaint);
//                canvas.drawText((angles[i]*100/360)+"%",CIRCLE_X + (RADIUS + LINE) * dx + LINE_STRAIGHT,CIRCLE_Y + (RADIUS + LINE) * dy,textPaint);
//                Log.d("translateAngle1", translateL * dx + "");
//            } else if (translateAngle > 90 && translateAngle <= 180 ) {
//                float dx = (float) Math.cos(Math.PI * (1 - translateAngle / ROUND));
//                float dy = (float) Math.sin(Math.PI * (1 - translateAngle / ROUND));
//                canvas.translate(-translateL * dx, translateL * dy);
//                Log.d("translateAngle2", (1 - translateAngle / ROUND) + "");
//            } else if (translateAngle > 180 && translateAngle <= 270 ) {
//                float dx = (float) Math.cos(Math.PI * (translateAngle / ROUND - 1));
//                float dy = (float) Math.sin(Math.PI * (translateAngle / ROUND - 1));
//                canvas.translate(-translateL * dx, -translateL * dy);
//                Log.d("translateAngle3", (translateAngle / ROUND - 1) + "，" + translateAngle);
//            } else {
//                float dx = (float) Math.cos(Math.PI * (2 - translateAngle / ROUND));
//                float dy = (float) Math.sin(Math.PI * (2 - translateAngle / ROUND));
//                canvas.translate(translateL * dx, -translateL * dy);
//                Log.d("translateAngle4", (2 - translateAngle / ROUND) + "");
//            }
//            paint.setColor(colors[i]);
//            canvas.drawArc(rectFHead, startAngle, angles[i], true, paint);
//            startAngle += angles[i];
//            canvas.restoreToCount(save);
//        }
//        canvas.drawArc(rectFHead,150,240,false,paint);

//        canvas.drawColor(colors[0]);

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
    }

    public void startThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    l += 12;
                    Log.d("Thread", l + "");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    postInvalidate();
                }
            }
        }).start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("MotionEvent",event.getAction()+"");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                colors[0] = Color.parseColor("#000000");
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                colors[0] = Color.parseColor("#27ad9a");
                invalidate();
                break;
            default:
                break;
        }

        return super.onTouchEvent(event);
    }
}
