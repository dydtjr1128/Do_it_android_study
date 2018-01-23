package org.androidtown.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class ScreenViewFlipper extends LinearLayout implements View.OnTouchListener {
    public static int countIndexes = 3;
    LinearLayout buttonLayout;
    ImageView[] indexButtons;
    View[] views;
    ViewFlipper flipper;
    int currentIndexes = 0;
    float downX = 0;
    float upX = 0;

    public ScreenViewFlipper(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.screenview, this, false);

        buttonLayout = (LinearLayout)findViewById(R.id.buttonLayout);
        flipper = (ViewFlipper)findViewById(R.id.flipper);()
        flipper.setOnTouchListener(this);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.leftMargin = 50;

        indexButtons = new ImageView[countIndexes];
        views = new TextView[countIndexes];
        for(int i=0; i< countIndexes; i++){
            indexButtons[i] = new ImageView(context);

            if(i == currentIndexes){
                indexButtons[i].setImageResource(R.drawable.d1);
            }
            else {
                indexButtons[i].setImageResource(R.drawable.d2);
            }
            indexButtons[i].setPadding(10, 10, 10, 10);
            buttonLayout.addView(indexButtons[i],params);

            TextView curView = new TextView(context);
            curView.setText("View #" + i);
            curView.setTextColor(Color.RED);
            curView.setTextSize(32);
            views[i] = curView;

            flipper.addView(views[i]);
        }
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(v != flipper) return false;

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            downX = event.getX();
        }
        else if(event.getAction() == MotionEvent.ACTION_UP){
            upX = event.getX();
        }

        if(upX < downX){
            flipper.setInAnimation(AnimationUtils.loadAnimation(getContext(), android.R.anim.wallpaper_open_enter));
        }
        return false;
    }
}
