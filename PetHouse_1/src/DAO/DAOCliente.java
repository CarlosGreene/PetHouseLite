/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Cliente;

/**
 *
 * @author lbojor
 */
public class DAOCliente extends DAOGeneral<Cliente>{
    public DAOCliente() {
    }

    public int agregar(Cliente e) throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "INSERT INTO cliente (nombre, email, telefono, edad)"+
                "VALUES ('"+ e.getNombre()+ "','" + e.getEmail()+ "','" + 
                e.getTelefono() + "',"+ e.getEdad()+")";

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int eliminar(String condicion)throws SQLException{
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "DELETE FROM cliente WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int modificar(Cliente e, String condicion)throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "UPDATE cliente SET " +
                " nombre='"+e.getNombre()+"',"+
                " email='" + e.getEmail() + "',"+
                " telefono='"+ e.getTelefono()+ "',"+
                " edad=" + e.getEdad() + 
                " WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public ArrayList<Cliente> consultar(String condicion) throws SQLException{
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        Cliente e;
        Connection con = getConeccion();
        String orden = "SELECT * FROM cliente " +
                (condicion==null || condicion.length()==0 ? "":"WHERE " + condicion);
        Statement sentencia = con.createStatement();
        ResultSet rs = sentencia.executeQuery( orden );
        while (rs.next()) {
            e = new Cliente(rs.getString("nombre"), rs.getString("email"), rs.getString("telefono"), rs.getInt("edad"));
            lista.add( e );
        }
        sentencia.close();
        cerrarConeccion(con);
        return lista;
    }    
}
