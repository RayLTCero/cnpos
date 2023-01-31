package com.cnpos.views.fragmentos;

import com.cnpos.config.Theming;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpleadoView {
    private JPanel empleadoPanel;
    private JLabel empleadoHeading;
    private JTable empleadosTable;
    private JScrollPane empleadosScrollPane;
    private JButton agregarButton;

    public EmpleadoView() {
        this.buildJTable();
        this.setButtonStyles(agregarButton);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { onAgregar();}
        });
    }

    public JPanel getEmpleadoPanel() {
        return this.empleadoPanel;
    }

    private void buildJTable() {
        empleadosScrollPane.setBorder(new EmptyBorder(0,0,0,0));
        String[] columnNames = new String[] {"Id", "Nombre", "Apellido", "Correo", "Rol", "Telefono"};
        String[][] rowData = new String[][] {
                {"1", "Joshua Bloch", "Addision-Wesley", "jb@gmail.com", "pasa piezas", "809-999-8565"},
                {"2", "Bruce Eckel", "Prentice Hall", "be@gmail.com", "pasa piezas", "809-999-8565"},
                {"3", "Kathy Sierra", "O'Reilly Media", "ks@gmail.com", "pasa piezas", "809-999-8565"},
        };
        DefaultTableModel model = new DefaultTableModel(rowData, columnNames);
        empleadosTable.setModel(model);
        JTableHeader tableHeader = empleadosTable.getTableHeader();
        tableHeader.setBackground(Color.decode(Theming.primaryColor));
        tableHeader.setForeground(Color.WHITE);
        tableHeader.setFont(new Font("Roboto Light", Font.PLAIN, 18));
    }

    private void setButtonStyles(JButton button) {
        Font font = new Font("Roboto Light", Font.PLAIN, 18);
        //Dimension buttonSize = new Dimension(150, 40);
        button.setFont(font);
        button.setOpaque(true);
        //button.setBorder(new MatteBorder(0, 0, 1, 0, Color.WHITE));
//        button.setMinimumSize(buttonSize);
//        button.setMaximumSize(buttonSize);
//        button.setPreferredSize(buttonSize);
    }

    private void onAgregar() {
        EmpleadoForm dialog = new EmpleadoForm();
        dialog.pack();
        dialog.setVisible(true);
    }
}
