package com.beans;


public class DataCheckerBean {
    public DataCheckerBean setProperty(Object value, DataCheckerPredicate functor) {
        value_ = value;
        functor_ = functor;
        return this;
    }

    public DataCheckerBean setErrorMessage(String message) {
        errorMessage_ = message;
        return this;
    }

    public DataCheckerBean setSuccessMessage(String message) {
        successMessage_ = message;
        return this;
    }

    public DataCheckerBean setErrorCode(int code) {
        codeError_ = code;
        return this;
    }

    public DataCheckerBean setSuccessCode(int code) {
        codeSuccess_ = code;
        return this;
    }

    public boolean checkProperty() {
        assert isAbleToEvaluate() : "Error, you have to set the error message, success message and code (greater than zero) to check your datas";
        return functor_.check__(value_);
    }

    public MessageHolder retrieveCodeMessageOnSuccess() {
        return new MessageHolder(codeSuccess_, successMessage_);
    }

    public MessageHolder retrieveCodeMessageOnFailure() {
        return new MessageHolder(codeError_, errorMessage_);
    }

    private boolean isAbleToEvaluate() {
        return codeSuccess_ > 0 && codeError_ > 0 && !errorMessage_.equals("") && !successMessage_.equals("");
    }

    private Object value_;
    private String errorMessage_ = "";
    private String successMessage_ = "";
    private int codeSuccess_ = -1;
    private int codeError_ = -1;
    private DataCheckerPredicate functor_;
}
