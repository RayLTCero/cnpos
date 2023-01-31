package com.cnpos.dao;

import com.cnpos.helpers.conexion.Conexion;
import com.cnpos.helpers.interfaces.Consulta;
import com.cnpos.models.Empleado;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmpleadoDAO implements Consulta<Empleado> {
    private static final String SQL_CREAR = "INSERT INTO empleados (nombre, apellido, correo, contraseña, id_rol, telefono) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_ELIMINAR = "DELETE FROM empleados WHERE id = ?";
    private static final String SQL_ACTUALIZAR = "UPDATE empleados SET nombre = ?, apellido = ?, correo = ?, contraseña = ?, id_rol = ?, telefono = ? WHERE id = ?";
    private static final String SQL_OBTENER_POR_ID = "SELECT * FROM empleados WHERE id = ?";
    private static final String SQL_OBETENER_TODOS = "SELECT * FROM empleados";

    private static final Conexion conexion = Conexion.getInstancia();

    @Override
    public boolean crear(Empleado empleado) {
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL_CREAR);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setString(3, empleado.getCorreo());
            ps.setString(4, empleado.getContraseña());
            ps.setInt(5, empleado.getIdRol());
            ps.setString(6, empleado.getTelefono());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean eliminar(Empleado empleado) {
        return false;
    }

    @Override
    public boolean actualizar(Empleado empleado) {
        return false;
    }

    @Override
    public Empleado obtenerPorId(Integer id) {
        return null;
    }

    @Override
    public List<Empleado> obtenerTodos() {
        return null;
    }
}
