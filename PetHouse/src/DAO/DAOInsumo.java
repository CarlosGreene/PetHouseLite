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
import modelo.Insumo;
import java.sql.Date;
/**
 *
 * @author green
 */
public class DAOInsumo extends DAOGeneral<Insumo>{
    public DAOInsumo() {
    }

    public int agregar(Insumo e) throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "INSERT INTO insumo (producto, tipoDeInsumo, precio, donador, fechaCita)"+
                "VALUES ('"+ e.getProducto()+ "','" + e.getTipoDeInsumo()+ "'," + 
                e.getPrecio() + ",'"+ e.getDonador()+"','" + e.getFechaCita() +"')";

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int eliminar(String condicion)throws SQLException{
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "DELETE FROM insumo WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int modificar(Insumo e, String condicion)throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "UPDATE insumo SET " +
                " producto='"+e.getProducto()+"',"+
                " tipoDeInsumo='" + e.getTipoDeInsumo() + "',"+
                " precio="+ e.getPrecio()+ ","+
                " donador='" + e.getDonador() + "',"+
                " fechaCita='" + e.getFechaCita() + "'"+
                " WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public ArrayList<Insumo> consultar(String condicion) throws SQLException{
        ArrayList<Insumo> lista = new ArrayList<Insumo>();
        Insumo e;
        Connection con = getConeccion();
        String orden = "SELECT * FROM insumo " +
                (condicion==null || condicion.length()==0 ? "":"WHERE " + condicion);
        Statement sentencia = con.createStatement();
        ResultSet rs = sentencia.executeQuery( orden );
        while (rs.next()) {
            e = new Insumo(rs.getString("producto"), rs.getString("tipoDeInsumo"), rs.getDouble("precio"), rs.getString("donador"),rs.getDate("fechaCita"));
            lista.add( e );
        }
        sentencia.close();
        cerrarConeccion(con);
        return lista;
    }    
}
