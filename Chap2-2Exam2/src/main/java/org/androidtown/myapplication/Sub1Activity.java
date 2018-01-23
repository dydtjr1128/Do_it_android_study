package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by CYSN on 2017-03-07.
 */

public class Sub1Activity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
        textView = (TextView) findViewById(R.id.textView01);
    }
    public void button2Clicked(View v){
        Intent intent = new Intent();
        intent.putExtra("submenu","sub " + textView.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}
