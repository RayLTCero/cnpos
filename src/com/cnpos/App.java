package com.cnpos;

import com.cnpos.controllers.LoginController;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        LoginController loginController = new LoginController();
        loginController.initView("Login");
    }
}
