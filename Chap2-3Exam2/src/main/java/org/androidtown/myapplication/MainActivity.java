package org.androidtown.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    Handler mHandler;
    Button button01, button02;
    LinearLayout adressLayout;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView01);
        adressLayout = (LinearLayout) findViewById(R.id.adressLayout);
        button01 = (Button)findViewById(R.id.button01);
        button02 = (Button)findViewById(R.id.button02);
        editText = (EditText)findViewById(R.id.editText01) ;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("");
    }
    public void button1Clicked(View v){
        if(v.getId() == R.id.button01){
            Animation animation = AnimationUtils.loadAnimation(this,R.anim.down);
            button01.setVisibility(View.GONE);
            button02.setVisibility(View.VISIBLE);
            adressLayout.startAnimation(animation);
            adressLayout.setVisibility(View.VISIBLE);
        }
        else if(v.getId() == R.id.button02){
            Animation animation = AnimationUtils.loadAnimation(this,R.anim.up);
            adressLayout.startAnimation(animation);

            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    button02.setVisibility(View.GONE);
                    button01.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    adressLayout.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
        else if(v.getId() == R.id.button03){
            webView.loadUrl(editText.getText().toString());
        }
    }
  class JavaScriptMethods{
      @JavascriptInterface
      public void clickonFace(){
          mHandler.post(new Runnable() {
              @Override
              public void run() {
                  webView.loadUrl("");
              }
          });
      }
  }
}
