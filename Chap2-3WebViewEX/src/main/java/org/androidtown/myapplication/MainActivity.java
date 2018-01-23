package org.androidtown.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    EditText urlEditText;
    Button urlButton;
    Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView01);
        urlEditText = (EditText) findViewById(R.id.editText01);
        urlButton = (Button) findViewById(R.id.button01);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

       // webView.setWebChromeClient(new WebBrowserClient());
        webView.setWebViewClient(new WebViewClient());
        webView.addJavascriptInterface(new JavaScriptMethod(),"sample");
        webView.loadUrl("file:///android_asset/sample.html");



        urlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(urlEditText.getText().toString());
            }
        });

    }
    final class JavaScriptMethod{
        JavaScriptMethod(){

        }
        @android.webkit.JavascriptInterface
        public void clickOnFace(){
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    urlButton.setText("클릭후열기");
                    webView.loadUrl("javascript:changeFace()");
                }
            });
        }
    }
   /* final  class WebBrowserClient extends WebChromeClient{
        public boolean onJsAlert(WebView view, String url, String message, JsResult result){
            result.confirm();
            return  true;
        }
    }*/
}