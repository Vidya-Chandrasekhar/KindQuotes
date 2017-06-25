package io.zipcoder.kindquotes.controller;

/**
 * Created by vidyachandasekhar on 6/25/17.
 */
public class CustomErrorType {

    private String errorMessage;

    public CustomErrorType(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
