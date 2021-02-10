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
import modelo.SolicitudAdopcion;
/**
 *
 * @author green
 */
public class DAOSolicitudAdopcion extends DAOGeneral<SolicitudAdopcion>{
    
    public DAOSolicitudAdopcion() {
    }

    public int agregar(SolicitudAdopcion e) throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "INSERT INTO solicitudadopcion (cliente, fecha, mascota)"+
                "VALUES ('"+ e.getCliente()+ "','" + e.getFecha()+ "','" + e.getMascota() +"')";

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int eliminar(String condicion)throws SQLException{
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "DELETE FROM solicitudadopcion WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int modificar(SolicitudAdopcion e, String condicion)throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "UPDATE solicitudadopcion SET " +
                " cliente='"+e.getCliente()+"',"+
                " fecha='" + e.getFecha() + "',"+ 
                " mascota='" + e.getMascota() + "'" + 
                " WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public ArrayList<SolicitudAdopcion> consultar(String condicion) throws SQLException{
        ArrayList<SolicitudAdopcion> lista = new ArrayList<SolicitudAdopcion>();
        SolicitudAdopcion e;
        Connection con = getConeccion();
        String orden = "SELECT * FROM solicitudadopcion " +
                (condicion==null || condicion.length()==0 ? "":"WHERE " + condicion);
        Statement sentencia = con.createStatement();
        ResultSet rs = sentencia.executeQuery( orden );
        while (rs.next()) {
            e = new SolicitudAdopcion(rs.getString("cliente"), rs.getDate("fecha"),rs.getString("mascota"));
            lista.add( e );
        }
        sentencia.close();
        cerrarConeccion(con);
        return lista;
    }
    
    public ArrayList<SolicitudAdopcion> enlistar() throws SQLException{
        ArrayList<SolicitudAdopcion> lista = new ArrayList<SolicitudAdopcion>();
        SolicitudAdopcion e;
        Connection con = getConeccion();
        String orden = "SELECT * FROM solicitudadopcion ";
        Statement sentencia = con.createStatement();
        ResultSet rs = sentencia.executeQuery( orden );
        while (rs.next()) {
            e = new SolicitudAdopcion(rs.getString("cliente"), rs.getDate("fecha"),rs.getString("mascota"));
            lista.add( e );
        }
        sentencia.close();
        cerrarConeccion(con);
        return lista;
    }
}
