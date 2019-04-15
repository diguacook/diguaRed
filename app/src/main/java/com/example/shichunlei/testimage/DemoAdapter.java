package com.example.shichunlei.testimage;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shichunlei
 * on 2019/2/21
 */
public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.MyViewHolder> {

    public Context context;
    public List<Number> list;
    public int mPosition = -1;

    public DemoAdapter(Context mContext, List<Number> mList) {
        context = mContext;
        list = mList;
    }
    @Override
    public DemoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        LinearLayout ll = (LinearLayout)view.findViewById(R.id.ll);
        if(mPosition >= 0) {
            for (int i = 0; i < list.get(mPosition).getValue(); i++) {
                TextView textView = new TextView(context);
                textView.setText("" + i);
                textView.setTextSize(20);
                textView.setWidth(180);
                textView.setHeight(180);
                textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
                ll.addView(textView);
            }
        }
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(DemoAdapter.MyViewHolder holder, int position) {
        mPosition = position;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
