package org.androidtown.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    EditText editText01,editText02;
    Button button01, button02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText01 = (EditText) findViewById(R.id.editText01);
        editText02 = (EditText) findViewById(R.id.editText02);
        button01 = (Button) findViewById(R.id.button01);
        button02 = (Button) findViewById(R.id.button02);
        Date day = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy 년 MM 월 dd일", Locale.getDefault());
        String fileName = String.valueOf(sdf.format(day));
        button01.setText(fileName);
    }
    public void button1Clicked(View v){
        if(v.getId() == button01.getId()){
            Dialog dialog = onCreateDialog();
            dialog.show();
        }
        else if(v.getId() == button02.getId()){
            String name = editText01.getText().toString();
            String age = editText02.getText().toString();

            Toast.makeText(this,name + " 의 나이는 " + age +"살 이고  생년월일은 " + button01.getText().toString() + "입니다.",Toast.LENGTH_SHORT).show();
        }
    }
    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            String fileName = year + "년 " + month + "월 " + dayOfMonth + "일";
            button01.setText(fileName);
        }
    };
    public Dialog onCreateDialog(){
        int myYear,myMonth,myDay;
        Date day = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy 년 MM 월 dd일", Locale.getDefault());
        String fileName = String.valueOf(sdf.format(day));
        myDay = day.getDate();
        myMonth = day.getMonth();
        myYear = day.getYear();
        button01.setText(fileName);
        DatePickerDialog dialog = new DatePickerDialog(this,listener,1900+myYear,myMonth+1,myDay);
        return dialog;

    }
}
