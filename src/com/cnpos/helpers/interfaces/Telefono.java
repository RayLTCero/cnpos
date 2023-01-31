package com.cnpos.helpers.interfaces;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Telefono {
    String numero = new String();
    
    public default void setTelefono(String numeroTelefono) {
        this.validarTelefono(numeroTelefono);

    }
    
    private boolean validarTelefono(String numeroTelefono) {
        Pattern pattern = Pattern.compile("^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
        System.out.println(numeroTelefono);
//        Matcher matcher = pattern.matcher("(202) 555-0125");
//        System.out.println(matcher.matches());
        return true;
    }
}
