package com.cnpos.dao;

import com.cnpos.helpers.conexion.Conexion;
import com.cnpos.helpers.interfaces.Consulta;
import com.cnpos.models.Permiso;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PermisoDAO implements Consulta<Permiso> {
    public static final String SQL_CREAR = "INSERT INTO permisos (titulo, descripcion, estado, referencia) VALUES (?, ?, ?, ?);";
    public static final String SQL_ELIMINAR = "DELETE FROM permisos WHERE id = ?;";
    public static final String SQL_ACTUALIZAR = "UPDATE permisos SET titulo = ?, descripcion = ?, estado = ?, referencia = ? WHERE id = ?;";
    public static final String SQL_OBTENER_POR_ID = "SELECT * FROM permisos WHERE id = ?;";
    public static final String SQL_OBTENER_TODOS = "SELECT * FROM permisos;";

    private static final Conexion conexion = Conexion.getInstancia();

    @Override
    public boolean crear(Permiso permiso) {
        PreparedStatement ps;
        Boolean result = false;

        try {
            ps = conexion.getConexion().prepareStatement(SQL_CREAR);
            ps.setString(1, permiso.getTitulo());
            ps.setString(2, permiso.getDescripcion());
            ps.setBoolean(3, permiso.getEstado());
            ps.setString(4, permiso.getReferencia());

            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return result;
    }

    @Override
    public boolean eliminar(Permiso permiso) {
        PreparedStatement ps;
        Boolean result = false;

        try {
            ps = conexion.getConexion().prepareStatement(SQL_ELIMINAR);
            ps.setInt(1, permiso.getId());

            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return result;
    }

    @Override
    public boolean actualizar(Permiso permiso) {
        PreparedStatement ps;
        Boolean result = false;

        try {
            ps = conexion.getConexion().prepareStatement(SQL_ACTUALIZAR);
            ps.setString(1, permiso.getTitulo());
            ps.setString(2, permiso.getDescripcion());
            ps.setBoolean(3, permiso.getEstado());
            ps.setString(4, permiso.getReferencia());
            ps.setInt(5, permiso.getId());

            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }

        return result;
    }

    @Override
    public Permiso obtenerPorId(Integer id) {
        PreparedStatement ps;
        ResultSet resultSet;
        Permiso permiso = null;

        try {
            ps = conexion.getConexion().prepareStatement(SQL_OBTENER_POR_ID);
            ps.setInt(1, id);
            resultSet = ps.executeQuery();

            while(resultSet.next()) {
                permiso = new Permiso();
                permiso.setId(resultSet.getInt(1));
                permiso.setTitulo(resultSet.getString(2));
                permiso.setDescripcion(resultSet.getString(3));
                permiso.setEstado(resultSet.getBoolean(4));
                permiso.setReferencia(resultSet.getString(5));
            }

            return permiso;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }

        return permiso;
    }

    @Override
    public List<Permiso> obtenerTodos() {
        PreparedStatement ps;
        ResultSet resultSet;
        ArrayList<Permiso> permisos = new ArrayList<Permiso>();

        try {
            ps = conexion.getConexion().prepareStatement(SQL_OBTENER_TODOS);
            resultSet = ps.executeQuery();

            while(resultSet.next()) {
                Permiso permiso = new Permiso();
                permiso.setId(resultSet.getInt(1));
                permiso.setTitulo(resultSet.getString(2));
                permiso.setDescripcion(resultSet.getString(3));
                permiso.setEstado(resultSet.getBoolean(4));
                permiso.setReferencia(resultSet.getString(5));
                permisos.add(permiso);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }

        return permisos;
    }
}
