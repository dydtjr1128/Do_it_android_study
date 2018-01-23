package org.androidtown.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;


public class ParcelActivity extends AppCompatActivity {
    public static final String KEY_SIMPLE_DATA = "data";
    public static final int REQUEST_CODE_ANOTHER = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parcel);
        Toast.makeText(getApplicationContext(),"onCreate",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected  void onStart(){
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected  void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected  void onRestart(){
        super.onRestart();
        Toast.makeText(getApplicationContext(),"onRestart",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected  void onPause(){
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected  void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected  void onDestroy(){
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy",Toast.LENGTH_SHORT).show();
    }
    public void onButton5Clicked(View v){
        Intent intent = new Intent(getApplicationContext(),Another2Activity.class);
        SimpleData data = new SimpleData(100,"Hello Android!");
        intent.putExtra(KEY_SIMPLE_DATA, data);
        startActivityForResult(intent,REQUEST_CODE_ANOTHER);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
        if(requestCode == REQUEST_CODE_ANOTHER){
            Toast toast = Toast.makeText(getApplicationContext(),"onActivityResult 메소드 호출됨. 요청코드 : " + requestCode + ", 결과코드 : " + resultCode,Toast.LENGTH_SHORT);
            toast.show();
            if(resultCode == RESULT_OK){
                Bundle bundle = intent.getExtras();
                SimpleData data = bundle.getParcelable(KEY_SIMPLE_DATA);
                /*String name = intent.getExtras().getString(KEY_SIMPLE_DATA);
                toast = Toast.makeText(getApplicationContext(),"응답으로 전달된 이름 : " + name,Toast.LENGTH_SHORT);*/
                toast = Toast.makeText(getApplicationContext(),"Parcelable 객체로 전달된 값 \nNumber = " + data.number + "\nMessage = " + data.message,Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
