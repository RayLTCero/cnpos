package com.cnpos.controllers;

import com.cnpos.config.Helper;
import com.cnpos.models.Empleado;

public class EmpleadoController extends BaseController {
    private Empleado empleado;

    public boolean isAuthenticated() {
        return false;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
