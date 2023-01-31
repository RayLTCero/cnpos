package com.cnpos.views;

import com.cnpos.config.Theming;
import com.cnpos.controllers.LoginController;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel container;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel heading;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JLabel logo;

    public Login() {
        super();
        this.setTitle("Login");
        this.loginButton.setBackground(Color.decode(Theming.primaryColor));
        this.loginButton.setForeground(Color.WHITE);
        this.loginButton.setOpaque(true);
        this.loginButton.setBorder(new MatteBorder(0, 0, 1, 0, Color.WHITE));
        this.emailField.setBackground(Color.white);
        this.emailField.setOpaque(true);
        this.passwordField.setBackground(Color.WHITE);
        this.passwordField.setOpaque(true);
        this.setContentPane(container);
        this.setMinimumSize(new Dimension(800, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(800, 500);
        this.setVisible(true);
        this.onLoginClick();
    }

    public static void main(String[] args) {
        Login login = new Login();
    }

    private void onLoginClick() {
        this.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LoginController loginController = new LoginController();
                    setVisible(false);
                    dispose();
                    loginController.initView("Dashboard");
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        });
    }
}
