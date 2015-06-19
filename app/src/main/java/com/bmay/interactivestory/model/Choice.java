package com.bmay.interactivestory.model;

/**
 * Created by BMay on 02/02/2015.
 */
public class Choice {
    //Text that describes the choice
    private String mText;
    //Result of the choice.
    private int mNextPage;

    //This constructor will set the data
    public Choice(String text, int nextPage){
        mText = text;
        mNextPage = nextPage;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }
}