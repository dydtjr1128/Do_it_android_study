package org.androidtown.myapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class PDFActivity extends AppCompatActivity {
    EditText editText03;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf);
        editText03 = (EditText) findViewById(R.id.editText03);
    }
    public void onButton4Clicked(View v){
        String filePath = editText03.getText().toString();
        if(filePath.length()>0)
            openPDF(filePath);
        else
            Toast.makeText(getApplicationContext(),"파일명 립력",Toast.LENGTH_SHORT).show();

    }
    public void openPDF(String contentsPath){
        File file = new File(contentsPath);
        if(file.exists()){
            Uri uri = FileProvider.getUriForFile(this, this.getPackageName(), file);//Uri.fromFile(file);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            try {
               startActivity(intent);
            }catch (Exception e){
                Toast.makeText(this,"뷰어앱 없음" + e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this,"파일 없듬",Toast.LENGTH_SHORT).show();
        }
    }
}