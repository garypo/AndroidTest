package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    private int pauseCount = 0;
    private int stopCount = 0;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        editText = (EditText) findViewById(R.id.recvd_message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(textView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        pauseCount++;
    }

    @Override
    protected void onResume() {
        super.onResume();

        String p = "Pause/Stop Count: " + pauseCount + "/" + stopCount;
        editText.setText(p);
        editText.setSelection(p.length());
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopCount++;
    }
}
