package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by CYSN on 2017-03-07.
 */

public class Sub2Activity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        textView = (TextView) findViewById(R.id.textView02);
    }
    public void button3Clicked(View v){
        Intent intent = new Intent();
        intent.putExtra("submenu","sub " + textView.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}
