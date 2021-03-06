package com.bmay.interactivestory.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bmay.interactivestory.R;


public class MainActivity extends Activity {

    private EditText mNameField;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameField = (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.startButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mNameField.getText().toString();
                //Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
                //Pass the name variable into startStory method
                startStory(name);
                 }
        });
    }

    private void startStory(String name){
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);

    }

    //Here we reset the EditText field when we complete the app and return to the starting page
    @Override
    protected void onResume() {
        super.onResume();
        mNameField.setText(null);
    }
}
