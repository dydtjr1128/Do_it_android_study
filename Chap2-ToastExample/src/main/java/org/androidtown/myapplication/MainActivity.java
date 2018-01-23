package org.androidtown.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText editText01,editText02;
    TextView textView01;
    String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText01 = (EditText) findViewById(R.id.editText01);
        editText02 = (EditText) findViewById(R.id.editText02);
        textView01 = (TextView) findViewById(R.id.textView01);
    }
    public void button1Clicked(View v){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.activity_main,(ViewGroup) findViewById(R.id.activity_main));
        Toast toast = Toast.makeText(this, "Hello~", Toast.LENGTH_SHORT);
        int xOffset = Integer.parseInt(editText01.getText().toString());
        int yOffset = Integer.parseInt(editText02.getText().toString());
        toast.setGravity(Gravity.LEFT, xOffset, yOffset);
        toast.setView(layout);
        toast.show();
    }
    public void button2Clicked(View v){
        AlertDialog dialog = createDialogBox();
        dialog.show();
    }
    private AlertDialog createDialogBox(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("안내");
        builder.setMessage("종료 하시겠습니까??");

        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                msg = "예 버튼이 눌렸습니다." + Integer.toString(which);
                textView01.setText(msg);
            }
        });
        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                msg = "취소 버튼이 눌렸습니다." + Integer.toString(which);
                textView01.setText(msg);
            }
        });
        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                msg = "아니오 버튼이 눌렸습니다." + Integer.toString(which);
                textView01.setText(msg);
            }
        });
        AlertDialog alertDialog = builder.create();
        return alertDialog;
    }
}
