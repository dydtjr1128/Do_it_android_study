package org.androidtown.myapplication;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.speech.SpeechRecognizer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int PROGRESS_DIALOG = 1001;
    ProgressDialog dialog;
    SeekBar seekBar;
    int brightness = 50;
    LinearLayout panel;
    int value = 10;
    TextView textView;
    Button btnbright;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar01);
        bar.setIndeterminate(false);
        bar.setMax(100);
        bar.setProgress(70);
        Button btnShow = (Button)findViewById(R.id.btnShow);
        Button btnClose = (Button)findViewById(R.id.btnClose);
        seekBar = (SeekBar) findViewById(R.id.seekbar01);
        panel = (LinearLayout)findViewById(R.id.panel01);
        textView = (TextView)findViewById(R.id.textView01);
        btnbright = (Button)findViewById(R.id.btnbright);
        dialog = (ProgressDialog) onCreateDialog(PROGRESS_DIALOG);
        seekBar.setOnSeekBarChangeListener(new MyOnSeekBarChangeListener());
        btnbright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPanel();
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(PROGRESS_DIALOG);
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dialog != null){
                    dialog.dismiss();
                }
            }
        });
    }
    private void showPanel(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        seekBar.setProgress(this.brightness);
        panel.setVisibility(View.VISIBLE);

        panel.startAnimation(animation);

    }
    private void setBrightness(int value){
        if(value < 10){
            value = 10;
        }
        else if(value > 100){
            value = 100;
        }

        brightness = value;
        WindowManager.LayoutParams parms = getWindow().getAttributes();
        parms.screenBrightness = (float)value/100;
        getWindow().setAttributes(parms);
    }
    private void hidePanel(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_right);
        panel.startAnimation(animation);
        panel.setVisibility(View.GONE);
    }
    class MyOnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener{
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            setBrightness(progress);
            textView.setText("밝기수준 : " + progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            hidePanel();
        }
    }

    public Dialog onCreateDialog(int id){
        switch (id){
            case (PROGRESS_DIALOG):
                dialog = new ProgressDialog(this);
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setMessage("데이터를 확인중입니다.");
                return dialog;
        }
        return null;
    }
}
