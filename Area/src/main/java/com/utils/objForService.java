package com.utils;

public class objForService {
    private String _getName;
    private String _setName;
    private String _message;
    private String _htmlCode;

    public objForService(String a, String b, String c){
        _getName = a;
        _setName = b;
        _message = c;
    }

    public String getGetName(){
        return _getName;
    }

    public String getSetName(){
        return _setName;
    }

    public String getMessage(){
        return _message;
    }

    public String getHtmlCode() {
        return _htmlCode;
    }
}
