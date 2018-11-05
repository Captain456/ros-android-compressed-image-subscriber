package com.example.cgibbs.compressedimagesubscriber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    /*
     * Properties
     */

    public static final String EXTRA_URL = "com.example.cgibbs.compressedimagesubscriber.URL";
    public static final String EXTRA_TOPIC = "com.example.cgibbs.compressedimagesubscriber.TOPIC";

    /*
     * Constructors (ish)
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * Public Methods
     */

    // Called when the subscribe button is pressed.
    public void onSubscribeButtonPress(View view) {
        // Create a new intent for the next activity
        Intent intent = new Intent(this, ImageViewerActivity.class);

        // Get the strings from the EditText components
        EditText urlEditText = (EditText) findViewById(R.id.editText);
        EditText topicEditText = (EditText) findViewById(R.id.editText2);

        String url = urlEditText.getText().toString();
        String topic = topicEditText.getText().toString();

        // Add the strings to the intent
        intent.putExtra(EXTRA_URL, url);
        intent.putExtra(EXTRA_TOPIC, topic);

        // Start the new activity
        startActivity(intent);
    }
}