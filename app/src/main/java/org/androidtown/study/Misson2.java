package org.androidtown.study;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

public class Misson2 extends AppCompatActivity {
    EditText editText;
    TextView textView;
    String getString,beforeString;
    final int LIMIT_LENGTH = 50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mission2);
        editText = (EditText) findViewById(R.id.editText01);
        textView = (TextView) findViewById(R.id.textView01);
        editText.setSingleLine(false);
        final InputFilter filter[] = new InputFilter[1];
        filter[0] = new InputFilter.LengthFilter(LIMIT_LENGTH);
        editText.setFilters(filter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                beforeString = s.toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                getString = s.toString();
                try {
                    int length = getString.getBytes("KSC5601").length;
                    if(length>=LIMIT_LENGTH){
                        editText.setText(null);
                        editText.setText(beforeString);
                    }
                    else if(length%8==0 && length > beforeString.length()) {
                        editText.getText().append("\n");
                        editText.setSelection(editText.getSelectionEnd()+1);
                    }
                    textView.setText(length + " / 80 바이트");
                }catch (Exception e){
                    e.getStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void show(View v){
        Toast.makeText(getApplicationContext(),editText.getText(), Toast.LENGTH_SHORT).show();
    }
    public void exit(View v){
        finish();
    }

}
