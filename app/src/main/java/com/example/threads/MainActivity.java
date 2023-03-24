package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView textView;
    String s;
    int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.idbtn);
        textView = findViewById(R.id.textid);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newThread();
            }
        };
        btn.setOnClickListener(onClickListener);
    }
    public void newThread(){
         new Thread() {
            @Override
            public void run() {
                while (a != 15) {
                    a++;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(Integer.toString(a));
                        }
                    });
                }
            }
        }.start();
    }
}