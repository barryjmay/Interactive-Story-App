package com.bmay.interactivestory.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bmay.interactivestory.R;
import com.bmay.interactivestory.model.Page;
import com.bmay.interactivestory.model.Story;


public class StoryActivity extends Activity {

    public static final String TAG = StoryActivity.class.getSimpleName();

    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;
    private Page mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));

        if (mName == null) {
            mName = "friend";
        }
        Log.d(TAG, mName);

        mImageView = (ImageView)findViewById(R.id.storyImageView);
        mTextView = (TextView)findViewById(R.id.storyTextView);
        mChoice1 = (Button)findViewById(R.id.choiceButton1);
        mChoice2 = (Button)findViewById(R.id.choiceButton2);

        loadPage(0);

           }
    //This method will load a page both when the activity is first created and when a button is tapped
    private void loadPage(int choice) {
        //Create a new mCurrentPage variable
        mCurrentPage = mStory.getPage(choice);

        //Create drawable variable & get the ID for the drawable from our mCurrentPage
        //We're getting the resources for the project through the activity and then from those resources
        //we are getting a drawable type and we're passing in this specific ID of the drawable that we want to get
        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        //Change the image dynamically by using setImageDrawable method - this takes a drawable type
        mImageView.setImageDrawable(drawable);

        String pageText = mCurrentPage.getText();
        //format is a static method. don't need an instance of a string to call it
        //This will add the name if placeholder included. It won't add if no placeholder
        //Basic search and replace method
        pageText = String.format(pageText, mName);

        mTextView.setText(pageText);
        //mTextView.setText(mCurrentPage.getText());

        if (mCurrentPage.isFinal()) {
            //Hide the top button
            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText("PLAY AGAIN");
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

        } else {

            mChoice1.setText(mCurrentPage.getChoice1().getText());
            mChoice2.setText(mCurrentPage.getChoice2().getText());

            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            });

            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    loadPage(nextPage);
                }
            });

        }
    }

    }
