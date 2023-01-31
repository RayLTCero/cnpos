package com.cnpos.helpers.modelos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Correo {
    private String correo;

    public void setCorreo(String correo) {
        if (this.validarCorreo(correo)) {
            this.correo = correo;
        }
    }

    private boolean validarCorreo(String correo) {
        Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(correo);

        return matcher.matches();
    }

    public String getCorreo() {
        return this.correo;
    }
}
