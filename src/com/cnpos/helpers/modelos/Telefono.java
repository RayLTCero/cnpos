package com.cnpos.helpers.modelos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Telefono {
    private String numero; // Pattern: (202) 555-0125

    public void setNumero(String numero) {
        if (this.validarNumero(numero)) {
            this.numero = numero;
        }
    }

    private boolean validarNumero(String numero) {
        Pattern pattern = Pattern.compile("^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
        Matcher matcher = pattern.matcher(numero);

        return matcher.matches();
    }

    public String getNumero() {
        return this.numero;
    }
}
