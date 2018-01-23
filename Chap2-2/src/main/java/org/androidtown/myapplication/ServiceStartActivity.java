package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class ServiceStartActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.myservice);

    }
    public void onButton6Clicked(View v){
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
        Log.i("TAG","시작");
    }
}
