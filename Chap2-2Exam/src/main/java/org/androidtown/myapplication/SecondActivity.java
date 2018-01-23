package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void button1Clicked(View v){
        Button button = (Button)v;
        Intent intent = new Intent();
        intent.putExtra("menu",button.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}
