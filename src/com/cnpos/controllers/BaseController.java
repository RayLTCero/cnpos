package com.cnpos.controllers;

import com.cnpos.config.Helper;

import javax.swing.*;

public class BaseController {

    public void initView(String view) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        String viewsPath = Helper.PATH_VIEWS;
        Class<?> GUI = Class.forName(viewsPath + view);
        Object newView = GUI.newInstance();
    }
}
