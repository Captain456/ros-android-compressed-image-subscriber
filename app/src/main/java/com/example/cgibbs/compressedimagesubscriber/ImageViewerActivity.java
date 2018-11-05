package com.example.cgibbs.compressedimagesubscriber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ImageViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);

        // Get the strings from the previous activity's intent
        Intent intent = getIntent();
        String url = intent.getStringExtra(MainActivity.EXTRA_URL);
        String topic = intent.getStringExtra(MainActivity.EXTRA_TOPIC);

        // Set the textViews to the strings
        TextView urlTextView = findViewById(R.id.textView3);
        TextView topicTextView = findViewById(R.id.textView4);

        urlTextView.setText(url);
        topicTextView.setText(topic);
    }
}
