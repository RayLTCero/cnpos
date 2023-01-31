package com.cnpos.views.fragmentos;

import com.cnpos.config.Theming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmpleadoForm extends JDialog {
    private JPanel contentPane;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JPanel container;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JFormattedTextField correoField;
    private JPasswordField contraseñaField;
    private JPasswordField contraseñaConfirmacionField;
    private JComboBox rolBox;
    private JFormattedTextField telefonoField;
    private JLabel nombreLabel;
    private JLabel apellidoLabel;
    private JLabel correoLabel;
    private JLabel contraseñaLabel;
    private JLabel contraseñaConfirmacionLabel;
    private JLabel rolLabel;
    private JLabel telefonoLabel;
    private JPanel buttonsContainer;

    public EmpleadoForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(guardarButton);
        setButtonStyles(cancelarButton);
        setButtonStyles(guardarButton);

        theming();

        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void setButtonStyles(JButton button) {
        Font font = new Font("Roboto Light", Font.PLAIN, 18);
        Dimension buttonSize = new Dimension(150, 40);
        button.setFont(font);
        button.setOpaque(true);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
    }

    private void theming() {
        Theming.setFieldStyles(nombreField);
        Theming.setFieldStyles(apellidoField);
        Theming.setFieldStyles(correoField);
        Theming.setFieldStyles(contraseñaField);
        Theming.setFieldStyles(contraseñaConfirmacionField);
        Theming.setFieldStyles(rolBox);
        Theming.setFieldStyles(telefonoField);

        Theming.setLabelStyles(nombreLabel);
        Theming.setLabelStyles(apellidoLabel);
        Theming.setLabelStyles(correoLabel);
        Theming.setLabelStyles(contraseñaLabel);
        Theming.setLabelStyles(contraseñaConfirmacionLabel);
        Theming.setLabelStyles(rolLabel);
        Theming.setLabelStyles(telefonoLabel);
    }

    public static void main(String[] args) {
        EmpleadoForm dialog = new EmpleadoForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
