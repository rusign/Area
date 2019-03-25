package com.controller;

import java.util.HashMap;
import java.util.Map;

public class MainController {
    private static Map<String, UserController> userRequest = new HashMap<String, UserController>();

    public static UserController getUserController(String login) {
        System.out.println("Login : " + login);
        if (userRequest.get(login) != null)
            return userRequest.get(login);
        userRequest.put(login, new UserController());
        return userRequest.get(login);
    }
}
