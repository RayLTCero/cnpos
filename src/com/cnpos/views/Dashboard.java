package com.cnpos.views;

import com.cnpos.views.fragmentos.EmpleadoView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    private JPanel container;
    private JPanel sidePanel;
    private JPanel mainPanel;
    private JPanel itemListPanel;
    private JButton ordersButton;
    private JButton employeesButton;
    private JButton addressesButton;
    private JButton salesButton;
    private JButton customersButton;
    private JButton entriesButton;
    private JButton supliersButton;
    public String estadoVista;

    public Dashboard() {
        super();
        this.setTitle("Dashboard");
        this.setButtonStyles(this.employeesButton);
        this.setButtonStyles(this.ordersButton);
        this.setButtonStyles(this.addressesButton);
        this.setButtonStyles(this.salesButton);
        this.setButtonStyles(this.customersButton);
        this.setButtonStyles(this.entriesButton);
        this.setButtonStyles(this.supliersButton);
        this.setContentPane(container);
        this.setMinimumSize(new Dimension(1280, 800));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(1280, 800);
        this.setVisible(true);
        this.employeesClick();
    }

    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard();
    }

    private void setButtonStyles(JButton button) {
        Font font = new Font("Roboto Light", Font.PLAIN, 18);
        Dimension buttonSize = new Dimension(150, 40);
        button.setFont(font);
        button.setOpaque(true);
        //button.setBorder(new MatteBorder(0, 0, 1, 0, Color.WHITE));
        button.setMinimumSize(buttonSize);
        button.setMaximumSize(buttonSize);
        button.setPreferredSize(buttonSize);
    }

    private void employeesClick() {
        employeesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estadoVista != "empleados") {
                    EmpleadoView empleadoView = new EmpleadoView();
                    mainPanel.setLayout(new GridLayout());
                    mainPanel.add(empleadoView.getEmpleadoPanel());
                }
                estadoVista = "empleados";
                mainPanel.updateUI();
            }
        });
    }
}
