package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import modelo.conexion;
import modelo.usuarios;
import java.util.ArrayList;
import java.util.List;

public class usuariosDAO {
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public usuarios login(String usuario, String password){
        usuarios u = null;
        String sql = "SELECT * FROM usuarios WHERE cedula_usu =? and password_usu=? and estado_usu='activo' and rol_usu='administrador' or rol_usu =lector' ";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
                u = new usuarios();
                u.setId(rs.getInt("id_usu"));
                u.setNombre(rs.getString("nombre_usu"));
                u.setApellido(rs.getString("apellido_usu"));
                u.setRol(rs.getString("rol_usu"));
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setUsuario(rs.getString("usuario"));
                u.setPassword(rs.getString("password"));
                u.setRol(rs.getString("rol"));
                u.setEstado(rs.getString("estado"));
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return u;
    }
    public Boolean insertarUsuario(usuarios u){
        String sql ="INSERT INTO usuarios (cedula_usu, nombre_usu, apellido_usu, genero_usu, email_usu, direccion_usu, estado_usu, password_usu, rol_usu) VALUES(?,?,?,?,?,?,?,?,?)";
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, u.getCedula());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellido());
            ps.setString(4, u.getGenero());
            ps.setString(5, u.getEmail());
            ps.setString(6, u.getDireccion());
            ps.setString(7, u.getEstado());
            ps.setString(8, u.getCedula());//dcontraseña
            ps.setString(9, "cliente");//rol
            
            ps.executeUpdate();
            return true;
           
        }catch(Exception e){
            System.out.println("error"+ e.toString());
            return false;
        }
    }
    public List<usuarios> listarUsuarios(){
        List<usuarios> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                usuarios u = new usuarios();
                u.setId(rs.getInt("id_usu"));
                u.setCedula(rs.getString("cedula_usu"));
                u.setNombre(rs.getString("nombre_usu"));
                u.setApellido(rs.getString("apellido_usu"));
                u.setGenero(rs.getString("genero_usu"));
                u.setEmail(rs.getString("email_usu"));
                u.setDireccion(rs.getString("direccion_usu"));
                u.setEstado(rs.getString("estado_usu"));
                u.setRol(rs.getString("rol_usu"));
                
                lista.add(u);
            }
        }catch(Exception e){
            System.out.println("error"+ e.toString());
           
        }
        return lista;
    }
    
    public boolean eliminarUsuario(int id){

    String sql = "DELETE FROM usuarios WHERE id_usu=?";

    try{

        con = cn.getConnection();
        ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ps.executeUpdate();

        return true;

    }catch(Exception e){

        System.out.println(e.toString());
        return false;

    }

}

    public boolean editarUsuario(usuarios u){

        String sql = "UPDATE usuarios SET cedula_usu=?,"
                + "nombre_usu=?,"
                + "apellido_usu=?,"
                + "genero_usu=?,"
                + "email_usu=?,"
                + "direccion_usu=?,"
                + "estado_usu=? "
                + "WHERE id_usu=?";

        try{

            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, u.getCedula());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellido());
            ps.setString(4, u.getGenero());
            ps.setString(5, u.getEmail());
            ps.setString(6, u.getDireccion());
            ps.setString(7, u.getEstado());
            ps.setInt(8, u.getId());

            ps.executeUpdate();

            return true;

        }catch(Exception e){

            System.out.println(e.toString());

            return false;

        }

    }
    public usuarios buscarUsuarios(String dato){
           usuarios u = null;
            String sql = "SELECT * FROM usuarios WHERE rol_usu = 'cliente' AND cedula_usu = ? AND estado_usu = 'activo'";
            try{
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1, dato);
                rs = ps.executeQuery();
                if(rs.next()){
                    u = new usuarios();
                    u.setId(rs.getInt("id_usu"));
                    u.setCedula(rs.getString("cedula_usu"));
                    u.setNombre(rs.getString("nombre_usu"));
                    u.setApellido(rs.getString("apellido_usu"));
                    u.setGenero(rs.getString("genero_usu"));
                    u.setEmail(rs.getString("email_usu"));
                    u.setDireccion(rs.getString("direccion_usu"));
                    u.setEstado(rs.getString("estado_usu"));
                    u.setRol(rs.getString("rol_usu"));
                }
            }catch(Exception e){
                System.out.println("error"+ e.toString());

            }
            return u;

    }
}
