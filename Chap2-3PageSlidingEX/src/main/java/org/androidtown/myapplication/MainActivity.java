package org.androidtown.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    boolean isPageOpen = false;
    Animation translateLeftAnim;
    Animation translateRightAnim;

    LinearLayout slidingPage01;
    Button button01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slidingPage01 = (LinearLayout) findViewById(R.id.slidingPage01);
        button01 = (Button) findViewById(R.id.button01);
        translateLeftAnim = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRightAnim = AnimationUtils.loadAnimation(this,R.anim.translate_right);
        SlidingPageAnimationListener listener = new SlidingPageAnimationListener();
        translateLeftAnim.setAnimationListener(listener);
        translateRightAnim.setAnimationListener(listener);
    }

    public void onButton1Clicked(View view){
        if(isPageOpen){
            slidingPage01.startAnimation(translateRightAnim);
        }
        else{
            slidingPage01.setVisibility(View.VISIBLE);
            slidingPage01.startAnimation(translateLeftAnim);
        }

    }

    private class SlidingPageAnimationListener implements  Animation.AnimationListener{
        @Override
        public void onAnimationEnd(Animation animation) {
            if(isPageOpen) {
                slidingPage01.setVisibility(View.INVISIBLE);

                button01.setText("Open");
                isPageOpen = false;
            }
            else{
                button01.setText("close");
                isPageOpen = true;
            }

        }

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
