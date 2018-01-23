package org.androidtown.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Animation flowAnim;
    Button button01;
    TextView textView01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button01 = (Button) findViewById(R.id.Button01);
        textView01 = (TextView) findViewById(R.id.textView01);
        flowAnim = AnimationUtils.loadAnimation(this, R.anim.flow);

    }
    public void onButton1Clicked(View view){
        flowAnim.setAnimationListener(new FlowAnimationListener());
        textView01.startAnimation(flowAnim);
    }
    class FlowAnimationListener implements Animation.AnimationListener{
        @Override
        public void onAnimationEnd(Animation animation) {
            Toast.makeText(getApplicationContext(),"애니메이션 종료",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }

        @Override
        public void onAnimationStart(Animation animation) {

        }
    }
}
