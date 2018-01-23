package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 1002;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void button1Clicked(View v){
        Button button = (Button)v;
        String subMenu = button.getText().toString();
        Intent intent;
        if(subMenu.equals("고객 관리")){
            intent = new Intent(getApplicationContext(),Sub1Activity.class);
            startActivityForResult(intent,REQUEST_CODE);
        }
        else if(subMenu.equals("매출 관리")){
            intent = new Intent(getApplicationContext(),Sub2Activity.class);
            startActivityForResult(intent,REQUEST_CODE);
        }
        else if(subMenu.equals("상품 관리")){
            intent = new Intent(getApplicationContext(),Sub3Activity.class);
            startActivityForResult(intent,REQUEST_CODE);
        }
        else if(subMenu.equals("이전으로")){
            intent = new Intent();
            intent.putExtra("menu",button.getText().toString());
            setResult(RESULT_OK,intent);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String text = data.getStringExtra("submenu");
                Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
            }
        }
    }
}
