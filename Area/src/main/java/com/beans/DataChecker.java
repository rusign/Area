package com.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DataChecker {

    public DataChecker setProperty(String property,
                                   String errorMessage,
                                   String successMessage,
                                   int code,
                                   int successCode,
                                   DataCheckerPredicate functor) {
        checkerList_.add(new DataCheckerBean()
                                .setProperty(property, functor)
                                .setErrorCode(code)
                                .setErrorMessage(errorMessage)
                                .setSuccessCode(successCode)
                                .setSuccessMessage(successMessage));
        return this;
    }

    public boolean runCheckerStack() {
        for (DataCheckerBean checker : checkerList_) {
            if (!checker.checkProperty()) {
                MessageHolder m = checker.retrieveCodeMessageOnFailure();
                errorCode_.put(m.m_code, m.m_message);
            } else {
                MessageHolder m = checker.retrieveCodeMessageOnSuccess();
                successCode_.put(m.m_code, m.m_message);
            }
        }
        return errorCode_.isEmpty();
    }

    public Map<Integer, String> retrieveErrorCode() {
        return errorCode_;
    }

    public Map<Integer, String> retrieveSuccessCode() {
        return successCode_;
    }

    private Map<Integer, String> errorCode_ = new HashMap<>();
    private Map<Integer, String> successCode_ = new HashMap<>();
    private ArrayList<DataCheckerBean> checkerList_ = new ArrayList<>();
}
