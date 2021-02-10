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
import modelo.SolicitudEsterilizacion;
/**
 *
 * @author green
 */
public class DAOSolicitudEsterilizacion extends DAOGeneral<SolicitudEsterilizacion>{
    
    public DAOSolicitudEsterilizacion() {
    }

    public int agregar(SolicitudEsterilizacion e) throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "INSERT INTO solicitudesterilizacion (cliente, fecha, mascota, aporte)"+
                "VALUES ('"+ e.getCliente()+ "','" + e.getFecha()+ "','" + 
                e.getMascota() + "'," + e.getAporte() + ")";

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int eliminar(String condicion)throws SQLException{
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "DELETE FROM solicitudesterilizacion WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int modificar(SolicitudEsterilizacion e, String condicion)throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "UPDATE solicitudesterilizacion SET " +
                " cliente='"+e.getCliente()+"',"+
                " fecha='" + e.getFecha() + "',"+ 
                " mascota='" + e.getMascota() + "'," + 
                " aporte=" + e.getAporte() + 
                " WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public ArrayList<SolicitudEsterilizacion> consultar(String condicion) throws SQLException{
        ArrayList<SolicitudEsterilizacion> lista = new ArrayList<SolicitudEsterilizacion>();
        SolicitudEsterilizacion e;
        Connection con = getConeccion();
        String orden = "SELECT * FROM solicitudesterilizacion " +
                (condicion==null || condicion.length()==0 ? "":"WHERE " + condicion);
        Statement sentencia = con.createStatement();
        ResultSet rs = sentencia.executeQuery( orden );
        while (rs.next()) {
            e = new SolicitudEsterilizacion(rs.getString("cliente"), rs.getDate("fecha"), rs.getString("mascota"), rs.getDouble("aporte"));
            lista.add( e );
        }
        sentencia.close();
        cerrarConeccion(con);
        return lista;
    }
    
    public ArrayList<SolicitudEsterilizacion> enlistar() throws SQLException{
        ArrayList<SolicitudEsterilizacion> lista = new ArrayList<SolicitudEsterilizacion>();
        SolicitudEsterilizacion e;
        Connection con = getConeccion();
        String orden = "SELECT * FROM solicitudesterilizacion ";
        Statement sentencia = con.createStatement();
        ResultSet rs = sentencia.executeQuery( orden );
        while (rs.next()) {
            e = new SolicitudEsterilizacion(rs.getString("cliente"), rs.getDate("fecha"), rs.getString("mascota"), rs.getDouble("aporte"));
            lista.add( e );
        }
        sentencia.close();
        cerrarConeccion(con);
        return lista;
    }
}
