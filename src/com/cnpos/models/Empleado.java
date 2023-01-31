package com.cnpos.models;

import com.cnpos.helpers.interfaces.Consulta;
import com.cnpos.helpers.modelos.Correo;
import com.cnpos.helpers.modelos.Telefono;

import java.util.List;

public class Empleado extends BaseModel {
    private Integer id;
    private String nombre;
    private String apellido;
    private Correo correo;
    private Telefono telefono;
    private String contraseña;
    private Integer id_rol;

    public Empleado() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo.getCorreo();
    }

    public void setCorreo(String correo) {
        this.correo.setCorreo(correo);
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Integer getIdRol() {
        return id_rol;
    }

    public void setIdRol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public String getTelefono() {
        return telefono.getNumero();
    }

    public void setTelefono(String numero) {
        this.telefono.setNumero(numero);
    }
}
