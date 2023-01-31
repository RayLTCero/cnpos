package com.cnpos.config;

import javax.swing.*;
import java.awt.*;

public class Theming {
    public static final String primaryColor = "#2D3142";
    public static final String primaryColorLighter = "#4f5d75";
    public static final String textColor = "#121212";
    public static final String textSecondaryColor = "#FFFFFF";
    public static final String primaryFont = "Roboto Light";
    public static final Integer primaryFontWeight = Font.PLAIN;
    public static final Integer labelFontSize = 18;

    public static void setFieldStyles(JComponent component) {
        Dimension dimension = new Dimension(-1, 45);
        Font font = new Font(primaryFont, primaryFontWeight, labelFontSize);

        component.setPreferredSize(dimension);
        component.setMinimumSize(dimension);
        component.setMaximumSize(dimension);
        component.setBackground(Color.WHITE);
        component.setForeground(Color.decode(textColor));
        component.setFont(font);
    }

    public static void setLabelStyles(JLabel label) {
        Font font = new Font(primaryFont, primaryFontWeight, labelFontSize);

        label.setFont(font);
        label.setForeground(Color.decode(textSecondaryColor));
    }

}
