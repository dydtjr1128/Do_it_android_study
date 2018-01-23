package org.androidtown.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {
    EditText editText01,editText02;
    boolean edit = false;
    public static final int REQUEST_CODE_ANOTHER = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call);
        editText01 = (EditText) findViewById(R.id.editText01);
        editText02 = (EditText) findViewById(R.id.editText02);
        editText01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                int length = s.length();
                if(length == 4 |length == 9){
                    edit = false;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();
                int length = text.length();
                if(length == 3 && edit == true){
                    text = text.substring(0,3) + "-";
                    editText01.setText(text);
                    editText01.setSelection(editText01.length());
                    edit = false;
                }
                else if(length == 8 && edit == true){
                    text = text.substring(0,8) + "-";
                    editText01.setText(text);
                    editText01.setSelection(editText01.length());
                    edit = false;
                }
                else{
                    edit = true;
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void onButton2Clicked(View v){
        String data = "tel:" + editText01.getText().toString();

        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(data));
        Intent intent = new Intent();
        ComponentName name = new ComponentName("org.androidtown.myapplication","org.androidtown.myapplication.AnotherActivity");

        intent.setComponent(name);
        startActivityForResult(intent, REQUEST_CODE_ANOTHER);

    }
    public void onButton3Clicked(View v){
        String data = "http://" + editText02.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));
        startActivity(intent);
    }
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
