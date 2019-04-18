package com.example.shichunlei.testimage;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rv;
    private List<Number> list = new ArrayList<>();
    private ArrayList<String> array = new ArrayList<>();
    private int[] arr = {10, 15, 9, 23, 5, 67, 33};
    private DemoAdapter demoAdapter;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.rv);
        view = findViewById(R.id.cv);
        demoAdapter = new DemoAdapter(this,list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(demoAdapter);
//        view.animate()
//                .rotation(180)
//                .setDuration(5000)
//                .setStartDelay(1000)
//                .start();

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view,"bottomFlip",30);
        objectAnimator.setDuration(1000).setStartDelay(100);

        ObjectAnimator degree = ObjectAnimator.ofFloat(view,"degree",360);
        degree.setDuration(3000).setStartDelay(100);

        ObjectAnimator top = ObjectAnimator.ofFloat(view,"topFlip",-30);
        degree.setDuration(3000).setStartDelay(100);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimator,degree,top);
        animatorSet.start();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("MotionEvent","onTouchEvent"+event.getAction());
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("MotionEvent","dispatchTouchEvent"+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }
}
