package com.beans;

import java.util.Map;

 
public abstract class RegistrationModelBean {
    public boolean isExist(String str) {
        return false;
    }

    protected MessageHolder validProperty(String property, String errorMessage, String successMessage) {
        checker_.setProperty(property, errorMessage, successMessage, errorCode_, successCode_, p -> {
                                boolean exist = isExist((String)p);
                                return ((String)p).length() > 3 && !exist;
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
