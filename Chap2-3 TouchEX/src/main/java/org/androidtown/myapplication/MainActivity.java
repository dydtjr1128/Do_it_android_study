package org.androidtown.myapplication;

import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView01,textView02;
    EditText editText01;
    GestureDetector mGesture = null;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(mGesture != null){
            return mGesture.onTouchEvent(event);
        }else {
            return super.onTouchEvent(event);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){//가로
            Toast.makeText(this,"Orientation : ORIENTATION_LANDSCAPE",Toast.LENGTH_SHORT).show();
        }
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this,"Orientation : ORIENTATION_PORTRAIT",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView01 = (TextView) findViewById(R.id.textView01);
        final Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mGesture = new GestureDetector(new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                textView01.append("\nonFling \n\tx = " + velocityX + "\ny = " + velocityY);
                return super.onFling(e1, e2, velocityX, velocityY);
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                textView01.append("\nonScroll \n\tx = " + distanceX + "\ny = " + distanceY);
                return super.onScroll(e1, e2, distanceX, distanceY);
            }
        });
        textView01.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                textView01.append("\nonLongClick : " + v.toString());
                return true;
            }
        });
        textView01.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    textView01.append("\nonFocusChange, hasfocus : " + hasFocus);
                }
                else{
                    textView01.append("\nonFocusChange, hasfocus : " + hasFocus);
                }
            }
        });
    }
}
