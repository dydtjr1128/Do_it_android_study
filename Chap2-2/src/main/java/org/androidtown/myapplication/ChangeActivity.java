package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class ChangeActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_ANOTHER = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change);
    }
    public void onButton1Clicked(View v){
        Intent intent = new Intent(getApplicationContext(),AnotherActivity.class);
        startActivityForResult(intent, REQUEST_CODE_ANOTHER);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode == REQUEST_CODE_ANOTHER){
            Toast toast = Toast.makeText(getApplicationContext(),"onActivityResult 메소드 호출됨. 요청코드 : " + requestCode + ", 결과코드 : " + resultCode,Toast.LENGTH_SHORT);
            toast.show();
            if(resultCode == RESULT_OK){
                String name = intent.getExtras().getString("name");
                toast = Toast.makeText(getApplicationContext(),"응답으로 전달된 이름 : " + name,Toast.LENGTH_SHORT);
                toast.show();
            }
        }

    }
}