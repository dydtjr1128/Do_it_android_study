package org.androidtown.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class MainBroadcastActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mainbroadcast);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "sms 수신 권한 있음", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "sms 수신 권한 없음", Toast.LENGTH_SHORT).show();
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECEIVE_SMS)) {//권한은 있으나 승인되어있지않은경우
                Toast.makeText(this, "sms 권한 설명 필요", Toast.LENGTH_SHORT).show();
            } else {//권한이 아예 없느경우
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS}, 1);
            }
        }
        Log.i("rrrr", "메세지받음");
    }
    public void onButton7Clicked(View v){
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "sms 권한 승인", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "sms 권한 거부됨", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
