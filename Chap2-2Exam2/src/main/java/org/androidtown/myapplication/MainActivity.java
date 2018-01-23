package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 1001;
    private Button button01;
    private EditText editText01, editText02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button01 = (Button) findViewById(R.id.button01);
        editText01 = (EditText) findViewById(R.id.editText01);
        editText02 = (EditText) findViewById(R.id.editText02);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idText = editText01.getText().toString().trim();
                String pwText = editText02.getText().toString().trim();
                if(!idText.equals("") && !pwText.equals("")) {
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivityForResult(intent, REQUEST_CODE);
                }
                else{
                    Toast.makeText(getApplicationContext(),"ID 와 PW 를 입력해 주세요.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String text = data.getStringExtra("menu");
                Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
            }
        }
    }
}
