package com.cnpos.helpers.interfaces;

import java.util.List;

public interface Consulta <Any> {
    public boolean crear(Any any);
    public boolean eliminar(Any any);
    public boolean actualizar(Any any);

    public Any obtenerPorId(Integer id);
    public List<Any> obtenerTodos();

}
