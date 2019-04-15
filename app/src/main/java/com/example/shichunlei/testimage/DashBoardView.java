package com.example.shichunlei.testimage;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shichunlei
 * on 2019/4/8
 */
public class DashBoardView extends View {

    Path dash = new Path();
    private PathDashPathEffect pathEffect = new PathDashPathEffect(dash,50,0, PathDashPathEffect.Style.ROTATE);
    public DashBoardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}
