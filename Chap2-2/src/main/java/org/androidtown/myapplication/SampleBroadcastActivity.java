package org.androidtown.myapplication;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class SampleBroadcastActivity extends AppCompatActivity {
    TextView textView02;
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.broadcast);
        textView02 = (TextView) findViewById(R.id.textView02);
        String msg = getIntent().getStringExtra("msg");
        textView02.setText(msg);

    }
}
