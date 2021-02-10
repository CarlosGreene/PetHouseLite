/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import modelo.Mascota_adoptada;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author green
 */
public class DAOMascota_adoptada extends DAOGeneral<Mascota_adoptada>{
    
    public DAOMascota_adoptada(){
        
    }
    
    public int agregar(Mascota_adoptada e) throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "INSERT INTO mascota_adoptada (especie, nombre, raza, edad, peso, sexo, cliente, fechaCita)"+
                "VALUES ('"+ e.getEspecie()+ "','" + e.getNombre()+ "','" + 
                e.getRaza() + "',"+ e.getEdad()+"," + e.getPeso() + ",'" + 
                e.getSexo() + "','" + e.getCliente() + "','" + 
                e.getFechaCita() +"')";

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int eliminar(String condicion)throws SQLException{
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "DELETE FROM mascota_adoptada WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int modificar(Mascota_adoptada e, String condicion)throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "UPDATE mascota_adoptada SET " +
                " especie='"+e.getEspecie()+"',"+
                " nombre='" + e.getNombre() + "',"+
                " raza='"+ e.getRaza()+ "',"+
                " edad=" + e.getEdad() + ","+
                " peso=" + e.getPeso() + ","+
                " sexo='" + e.getSexo() + "',"+
                " cliente='" + e.getCliente() + "',"+
                " fechaCita='" + e.getFechaCita() + "'"+
                " WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public ArrayList<Mascota_adoptada> consultar(String condicion) throws SQLException{
        ArrayList<Mascota_adoptada> lista = new ArrayList<Mascota_adoptada>();
        Mascota_adoptada e;
        Connection con = getConeccion();
        String orden = "SELECT * FROM mascota_adoptad " +
                (condicion==null || condicion.length()==0 ? "":"WHERE " + condicion);
        Statement sentencia = con.createStatement();
        ResultSet rs = sentencia.executeQuery( orden );
        while (rs.next()) {
            e = new Mascota_adoptada(rs.getString("especie"), rs.getString("nombre"), rs.getString("raza"), 
                    rs.getInt("edad"),rs.getDouble("peso"), rs.getString("sexo"), rs.getString("cliente"), rs.getDate("fechaCita"));
            lista.add( e );
        }
        sentencia.close();
        cerrarConeccion(con);
        return lista;
    }
    
    public ArrayList<Mascota_adoptada> enlistar() throws SQLException{
        ArrayList<Mascota_adoptada> lista = new ArrayList<Mascota_adoptada>();
        Mascota_adoptada e;
        Connection con = getConeccion();
        String orden = "SELECT * FROM mascota_adoptad ";
        Statement sentencia = con.createStatement();
        ResultSet rs = sentencia.executeQuery( orden );
        while (rs.next()) {
            e = new Mascota_adoptada(rs.getString("especie"), rs.getString("nombre"), rs.getString("raza"), 
                    rs.getInt("edad"),rs.getDouble("peso"), rs.getString("sexo"), rs.getString("cliente"), rs.getDate("fechaCita"));
            lista.add( e );
        }
        sentencia.close();
        cerrarConeccion(con);
        return lista;
    }
    
}
