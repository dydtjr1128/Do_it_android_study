package org.androidtown.study;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView01;
    ImageView imageView02;
    BitmapDrawable bitmap;
    boolean showImage1 = true;
    int imageWidth;
    int imageHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mission1);
        imageView01 = (ImageView) findViewById(R.id.imageView01);
        imageView02 = (ImageView) findViewById(R.id.imageView02);
        imageView01.setHorizontalScrollBarEnabled(true);
        imageView02.setHorizontalScrollBarEnabled(true);

        Resources res = getResources();
        bitmap = (BitmapDrawable)res.getDrawable(R.drawable.image01);
        imageWidth = bitmap.getIntrinsicWidth();
        imageHeight = bitmap.getIntrinsicHeight();

        imageView01.setImageDrawable(bitmap);
        imageView01.getLayoutParams().width = imageWidth;
        imageView01.getLayoutParams().height = imageHeight;
    }

    public void onClick1Button(View v){
        Toast.makeText(getApplicationContext(),"tt",Toast.LENGTH_SHORT).show();
        if(!showImage1){
            imageView01.setImageDrawable(bitmap);
            imageView01.getLayoutParams().width = imageWidth;
            imageView01.getLayoutParams().height = imageHeight;

            imageView02.setImageDrawable(null);
            showImage1 = true;
        }
    }
    public void onClick2Button(View v){
        Toast.makeText(getApplicationContext(),"ff",Toast.LENGTH_SHORT).show();
        if(showImage1){
            imageView02.setImageDrawable(bitmap);
            imageView02.getLayoutParams().width = imageWidth;
            imageView02.getLayoutParams().height = imageHeight;

            imageView01.setImageDrawable(null);
            showImage1 = false;
        }
    }
}
