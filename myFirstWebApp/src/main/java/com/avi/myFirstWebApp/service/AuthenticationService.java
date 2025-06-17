package com.avi.myFirstWebApp.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authentication(String userName, String password){
        boolean isValidUserName = userName.equalsIgnoreCase("avinash");
        boolean isValidPassword = password.equalsIgnoreCase("pwd@123");
        return isValidUserName && isValidPassword;
    }
}
