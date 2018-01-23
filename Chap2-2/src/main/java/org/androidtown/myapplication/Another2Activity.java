package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Another2Activity extends AppCompatActivity {
    public static final String KEY_SIMPLE_DATA = "data";
    public static final int REQUEST_CODE_ANOTHER = 1001;
    TextView textView01;
    Bundle bundle;
    SimpleData data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another);
        textView01 = (TextView) findViewById(R.id.textView01);
        Button backbutton = (Button) findViewById(R.id.backButton);
        processIntent();
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.message = "OK Android!!!";
                data.number = 24;
                Intent intent = new Intent();
                intent.putExtra(KEY_SIMPLE_DATA,data);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
    private void processIntent(){
        bundle = getIntent().getExtras();
        data = (SimpleData)bundle.getParcelable(KEY_SIMPLE_DATA);

        textView01.setText("Parcelable 객체로 전달된 값 \nNumber = " + data.number + "\nMessage = " + data.message);
    }
}