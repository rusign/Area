package com.beans;

import java.util.Map;


public abstract class ConnectBean {
    abstract boolean isExist(String property);

    protected MessageHolder validUserForConnect(String property, String successMessage, String errorMessage) {
        checker_.setProperty(property, errorMessage, successMessage, errorCode_, successCode_, p -> {
           boolean check = isExist(property);
           return ((String)p).length() > 3 && check;
        });
        if (!checker_.runCheckerStack())
            return feedMsg(checker_.retrieveErrorCode());
        return feedMsg(checker_.retrieveSuccessCode());
    }

    private MessageHolder feedMsg(Map<Integer, String> code) {
        Map.Entry<Integer, String> first = code.entrySet().iterator().next();
        return new MessageHolder(first.getKey(), first.getValue());
    }

    private int successCode_ = 200;
    private int errorCode_ = 500;
    private DataChecker checker_ = new DataChecker();
}
