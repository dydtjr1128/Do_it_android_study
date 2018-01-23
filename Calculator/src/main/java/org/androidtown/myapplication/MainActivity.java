package org.androidtown.myapplication;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.StringTokenizer;
import java.util.Vector;


public class MainActivity extends BaseActivity {

    Button button[] = new Button[20];
    EditText editText01, editText02;
    String lastWord = "";
    WebView webView1;
    int valueIndex = 0;
    String value[] = new String[10];
    String answer = "";
    ClipboardManager clipboardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText01 = (EditText) findViewById(R.id.editText01);
        editText02 = (EditText) findViewById(R.id.editText02);
        editText01.setCursorVisible(false);
        editText02.setCursorVisible(false);

        editText01.setFocusable(false);
        /*editText01.setClickable(false);
        editText02.setClickable(false);
        editText01.setFocusable(false);
        editText02.setFocusable(false);*/
        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        editText01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clipboardManager.setText(editText01.getText().toString());
                Toast.makeText(getApplicationContext(), "클립보드에 복사되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        webView1 = new WebView(getApplicationContext());
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.loadUrl("");
    }

    public void onButtonClicked(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        String bottomText = editText02.getText().toString();
        if (buttonText.equals("=")) {
            if (bottomText == null || bottomText.equals("")) {
                editText01.setText("0");
                return;
            }
//            Toast.makeText(getApplicationContext(),calcText,Toast.LENGTH_SHORT).show();
            calc(editText02.getText().toString());
            value[valueIndex++] = bottomText + " = " + answer;
            if (valueIndex == 10) {
                valueIndex = 0;
            }
            lastWord = buttonText;
        } else if (buttonText.equals("AC")) {
            editText01.setText("0");
            editText02.setText(null);
            lastWord = "";
        } else if (buttonText.equals("←")) {
            int length = bottomText.length();
            if (length > 0) {
                editText02.setText(bottomText.substring(0, length - 1));
                editText02.setSelection(length - 1);
            }
            calc(editText02.getText().toString());
        } else if (buttonText.equals("CE")) {
            String temp = "";
            for (int i = 0; i < bottomText.length(); i++) {
                char mun = bottomText.charAt(i);
                Boolean munja = false;
                if ((mun == '+') || (mun == '-') || (mun == '÷') || (mun == '×')) {
                    temp += "%%";
                    munja = true;
                }
                temp += mun;
                if (munja) {
                    temp += "%%";
                }
            }
            String splitText[] = temp.split("%%");
            editText02.setText(null);
            for (int i = 0; i < splitText.length - 1; i++) {
                editText02.append(splitText[i]);
            }
            if (editText02.length() > 1) {
                lastWord = bottomText.substring(bottomText.length() - 1);
            } else {
                lastWord = "";
            }
            calc(editText02.getText().toString());
        } else if (buttonText.equals("X")) {
            String splitText[] = bottomText.split("-|÷|×|\\+");
            Vector<Character> vec = new Vector<Character>();
            for (int i = 0; i < bottomText.length(); i++) {
                char mun = bottomText.charAt(i);
                if ((mun == '+') || (mun == '-') || (mun == '÷') || (mun == '×')) {
                    vec.add(mun);
                }
            }
            editText02.setText(null);
            int vecEnd = vec.size() - 1;
            for (int i = splitText.length - 1; i >= 0; i--) {
                editText02.append(splitText[i]);
                if (vecEnd >= 0) {
                    editText02.append(Character.toString(vec.get(vecEnd)));
                    vecEnd--;
                }
            }
            if (editText02.length() > 1) {
                lastWord = bottomText.substring(editText02.length() - 1);
            } else {
                lastWord = "";
            }
        } else if (buttonText.equals("His")) {
            Intent intent = new Intent(this, HistroyActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.putExtra("value", value);
            startActivity(intent);
        } else if (buttonText.equals("+") || buttonText.equals("÷") || buttonText.equals("×") || buttonText.equals("-")) {//buttonText.equals("+") || buttonText.equals("-") ||
            String endText;
            if(bottomText.length()>=1) {
                endText = bottomText.substring(bottomText.length() - 1, bottomText.length());
                if(endText.equals("+") || endText.equals("÷") || endText.equals("×") || endText.equals("-")){
                   lastWord = endText;
                }
            }
            if (lastWord.equals("+") || lastWord.equals("-") || lastWord.equals("÷") || lastWord.equals("×")) {
                editText02.setText(bottomText.substring(0, editText02.length() - 1));
                editText02.append(b.getText());
            } else if (lastWord.equals("=")) {
                editText02.setText(null);
                editText02.append(editText01.getText());
                editText02.append(b.getText());
            } else {
                editText02.append(b.getText());
            }
            lastWord = buttonText;
        } else if (lastWord.equals("=")) {
            editText02.setText(null);
            editText02.append(b.getText());
            calc(editText02.getText().toString());
            lastWord = buttonText;
        } else {
            /*if(bottomText.length()>1){
                String endText = bottomText.substring(bottomText.length()-1);
                String endPreviousText = bottomText.substring(bottomText.length()-2,bottomText.length()-1);
                if(endText.equals("-") && buttonText.equals("-")){

                }
                else if(endPreviousText.equals("+") || endPreviousText.equals("÷") || endPreviousText.equals("×")|| endPreviousText.equals("-")){

                }
                else{
                    editText02.append(b.getText());
                }
            }
            else{
                editText02.append(b.getText());
            }
            if(!(buttonText.equals("-"))){*/
            editText02.append(b.getText());
            int a = Integer.parseInt(buttonText);
            if (a == 0 || a > 0 || a < 0)
                calc(editText02.getText().toString());

            lastWord = buttonText;
            Log.e("rrrrr", lastWord);
        }
    }

    public void calc(String calcText) {
        calcText = calcText.replace('×', '*');
        calcText = calcText.replace('÷', '/');
        webView1.evaluateJavascript("(function() { return eval(" + calcText + "); })();", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String s) {
                if (s.equals("null")) {
                    answer = "0";
                    editText01.setText("0");
                } else {
                    answer = s;
                    editText01.setText(s);
                }
                Log.d("rrrr", s);
                //Toast.makeText(getApplicationContext(),s  +,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
