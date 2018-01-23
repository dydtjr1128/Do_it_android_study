package org.androidtown.myapplication;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class MyService extends Service implements Runnable {
    public static final String TAG = "My Service";
    public int count = 0;

    public void onCreate() {
        super.onCreate();

        Thread myThread = new Thread(this);
        myThread.start();
       // Toast.makeText(getApplicationContext(),"ser",Toast.LENGTH_SHORT).show();
    }

    public void run() {
      //  Toast.makeText(getApplicationContext(),"run",Toast.LENGTH_SHORT).show();
        while (true) {
            try {
                Log.i(TAG, "my service called #" + count);
                count++;

                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Log.e(TAG, e.toString() + "ㄴㅇㄹㄹ");
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
