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
import modelo.Mascota_resguardo;

/**
 *
 * @author green
 */
public class DAOMascota_resguardo extends DAOGeneral<Mascota_resguardo>{
    
    public DAOMascota_resguardo(){
        
    }
    
    public int agregar(Mascota_resguardo e) throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "INSERT INTO Mascota_resguardo (especie, nombre, raza, edad, peso, sexo)"+
                "VALUES ('"+ e.getEspecie()+ "','" + e.getNombre()+ "','" + 
                e.getRaza() + "',"+ e.getEdad()+"," + e.getPeso() + ",'" + 
                e.getSexo() + "')";

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int eliminar(String condicion)throws SQLException{
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "DELETE FROM mascota_resguardo WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int modificar(Mascota_resguardo e, String condicion)throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "UPDATE mascota_resguardo SET " +
                " especie='"+e.getEspecie()+"',"+
                " nombre='" + e.getNombre() + "',"+
                " raza='"+ e.getRaza()+ "',"+
                " edad=" + e.getEdad() + ","+
                " peso=" + e.getPeso() + ","+
                " sexo='" + e.getSexo() + "'"+
                " WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public ArrayList<Mascota_resguardo> consultar(String condicion) throws SQLException{
        ArrayList<Mascota_resguardo> lista = new ArrayList<Mascota_resguardo>();
        Mascota_resguardo e;
        Connection con = getConeccion();
        String orden = "SELECT * FROM mascota_resguardo " +
                (condicion==null || condicion.length()==0 ? "":"WHERE " + condicion);
        Statement sentencia = con.createStatement();
        ResultSet rs = sentencia.executeQuery( orden );
        while (rs.next()) {
            e = new Mascota_resguardo(rs.getString("especie"), rs.getString("nombre"), rs.getString("raza"), 
                    rs.getInt("edad"),rs.getDouble("peso"), rs.getString("sexo"));
            lista.add( e );
        }
        sentencia.close();
        cerrarConeccion(con);
        return lista;
    }
}
