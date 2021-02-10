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
import modelo.Mascota_cliente;

/**
 *
 * @author green
 */
public class DAOMascota_cliente extends DAOGeneral<Mascota_cliente>{
    
    public DAOMascota_cliente(){
        
    }
    
    public int agregar(Mascota_cliente e) throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "INSERT INTO mascota_cliente (especie, nombre, raza, edad, peso, sexo, cliente)"+
                "VALUES ('"+ e.getEspecie()+ "','" + e.getNombre()+ "','" + 
                e.getRaza() + "',"+ e.getEdad()+"," + e.getPeso() + ",'" + 
                e.getSexo() + "','" + e.getCliente() + "')";

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int eliminar(String condicion)throws SQLException{
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "DELETE FROM mascota_cliente WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int modificar(Mascota_cliente e, String condicion)throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "UPDATE mascota_cliente SET " +
                " especie='"+e.getEspecie()+"',"+
                " nombre='" + e.getNombre() + "',"+
                " raza='"+ e.getRaza()+ "',"+
                " edad=" + e.getEdad() + ","+
                " peso=" + e.getPeso() + ","+
                " sexo='" + e.getSexo() + "',"+
                " cliente='" + e.getCliente() + "'"+
                " WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public ArrayList<Mascota_cliente> consultar(String condicion) throws SQLException{
        ArrayList<Mascota_cliente> lista = new ArrayList<Mascota_cliente>();
        Mascota_cliente e;
        Connection con = getConeccion();
        String orden = "SELECT * FROM mascota_cliente " +
                (condicion==null || condicion.length()==0 ? "":"WHERE " + condicion);
        Statement sentencia = con.createStatement();
        ResultSet rs = sentencia.executeQuery( orden );
        while (rs.next()) {
            e = new Mascota_cliente(rs.getString("especie"), rs.getString("nombre"), rs.getString("raza"), 
                    rs.getInt("edad"),rs.getDouble("peso"), rs.getString("sexo"), rs.getString("cliente"));
            lista.add( e );
        }
        sentencia.close();
        cerrarConeccion(con);
        return lista;
    }
    
    public ArrayList<Mascota_cliente> enlistar() throws SQLException{
        ArrayList<Mascota_cliente> lista = new ArrayList<Mascota_cliente>();
        Mascota_cliente e;
        Connection con = getConeccion();
        String orden = "SELECT * FROM mascota_cliente ";
        Statement sentencia = con.createStatement();
        ResultSet rs = sentencia.executeQuery( orden );
        while (rs.next()) {
            e = new Mascota_cliente(rs.getString("especie"), rs.getString("nombre"), rs.getString("raza"), 
                    rs.getInt("edad"),rs.getDouble("peso"), rs.getString("sexo"), rs.getString("cliente"));
            lista.add( e );
        }
        sentencia.close();
        cerrarConeccion(con);
        return lista;
    }
}
