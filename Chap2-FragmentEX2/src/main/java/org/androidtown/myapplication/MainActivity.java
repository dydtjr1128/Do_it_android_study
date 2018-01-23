package org.androidtown.myapplication;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.ImageSelectionCallback{
    ListFragment listFragment;
    ViewerFragment viewerFragment;
    int images[] = {R.drawable.d1, R.drawable.d2, R.drawable.d3 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        listFragment = (ListFragment) manager.findFragmentById(R.id.listFragment);
        viewerFragment = (ViewerFragment) manager.findFragmentById(R.id.viewerFragment);
    }
    @Override
    public void onImageSelected(int position){
        viewerFragment.setImage(images[position]);
    }
}
