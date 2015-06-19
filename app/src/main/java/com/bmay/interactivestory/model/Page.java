package com.bmay.interactivestory.model;

/**
 * Created by BMay on 02/02/2015.
 */
public class Page {
    //Add data for member variables we want to include on all pages
    // i.e. 1 image, 1 bit of text and 2 choices
    private int mImageId;
    private String mText;
    //The choices will be implemented as buttons in the View
    //The detail about the choice being a button belong here in the model
    private Choice mChoice1;
    private Choice mChoice2;
    //This flag is used to check if we are on one of the final pages
    private boolean mIsFinal = false;

    //Create a custom constructor for the Page class that takes 4 parameters to match up with 4 member vars
    public Page(int imageId, String text, Choice choice1, Choice choice2){
        mImageId = imageId;
        mText = text;
        mChoice1 = choice1;
        mChoice2 = choice2;
        }


    //This page constructor is for the final pages (5 & 6) which won't have any choices
    public Page(int imageId, String text){
        mImageId = imageId;
        mText = text;
        mChoice1 = null;
        mChoice2 = null;
        mIsFinal = true;
    }

    //Here we use getter and setter methods to get and set the member variables
    public int getImageId() {
        return mImageId;
    }

    //Always use a void data type for a setter method
    public void setImageId(int imageId) {
        mImageId = imageId;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }

    public boolean isFinal() {
        return mIsFinal;
    }

    public void setFinal(boolean isFinal) {
        mIsFinal = isFinal;
    }




}
