/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.conexion;
import modelo.autores;

public class autoresDAO {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Boolean insertarAutor(autores a){
        String sql ="INSERT INTO autores (nombre_aut, nacionalidad_aut, estado_aut) VALUES(?,?,?)";

        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, a.getNombre());
            ps.setString(2, a.getNacionalidad());
            ps.setString(3, a.getEstado());

            ps.executeUpdate();
            return true;

        }catch(Exception e){
            System.out.println("error"+ e.toString());
            return false;
        }
    }

    public List<autores> listarAutor(){

        List<autores> lista = new ArrayList<>();
        String sql = "SELECT * FROM autores";

        try{

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){

                autores a = new autores();

                a.setId(rs.getInt("id_aut"));
                a.setNombre(rs.getString("nombre_aut"));
                a.setNacionalidad(rs.getString("nacionalidad_aut"));
                a.setEstado(rs.getString("estado_aut"));

                lista.add(a);
            }

        }catch(Exception e){
            System.out.println("error"+ e.toString());
        }

        return lista;
    }

    public boolean eliminarAutor(int id){

        String sql = "DELETE FROM autores WHERE id_aut=?";

        try{

            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            return true;

        }catch(Exception e){

            System.out.println("error"+ e.toString());
            return false;
        }
    }

    public boolean actualizarAutor(autores a){

        String sql = "UPDATE autores SET nombre_aut=?, nacionalidad_aut=?, estado_aut=? WHERE id_aut=?";

        try{

            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, a.getNombre());
            ps.setString(2, a.getNacionalidad());
            ps.setString(3, a.getEstado());
            ps.setInt(4, a.getId());

            ps.executeUpdate();

            return true;

        }catch(Exception e){

            System.out.println("error"+ e.toString());
            return false;
        }
    }

}
