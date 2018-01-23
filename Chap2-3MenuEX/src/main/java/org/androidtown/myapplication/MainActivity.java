package org.androidtown.myapplication;



import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ActionBar bar;
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = getSupportActionBar();
        Log.e("ddeeeee","sdfsdf");
    }
    public void onButton1Clicked(View v){
        bar.setLogo(R.drawable.d2);
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_USE_LOGO);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        View v = menu.findItem(R.id.menu_searchs).getActionView();
        if(v != null){
            edit = (EditText) v.findViewById(R.id.edit01);
            if (edit != null){
                edit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        Toast.makeText(getApplicationContext(),v.getText().toString(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curid = item.getItemId();
        switch (curid){
            case R.id.menu_refresh:
                Toast.makeText(getApplicationContext(),"새로고침 매뉴 선택",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_search:
                Toast.makeText(getApplicationContext(),"검색 매뉴 선택",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_settings:
                Toast.makeText(getApplicationContext(),"설정 매뉴 선택",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
