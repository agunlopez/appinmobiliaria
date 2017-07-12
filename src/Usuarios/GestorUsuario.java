/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import conexion.Conexion;
import entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Nahuel
 */
public class GestorUsuario {
   
    public static ArrayList<Usuario> traerTodosLosUsuarios() throws SQLException{

        ArrayList<Usuario> listaUsuarios=new ArrayList<Usuario>();
        Usuario usuario=null;
        ResultSet rs=null;
        String sql="SELECT * FROM `usuarios` WHERE tipo LIKE ?";
        
        try{
            PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
            pst.setString(1, "EMPLEADO");
            rs=pst.executeQuery();
            
            while(rs.next()){
                usuario=new Usuario();  
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setTipo(rs.getString("tipo"));
                  
                listaUsuarios.add(usuario);
                
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(new JDialog(),"Error al consultar Usuario"+e.toString());
        }       
        return listaUsuarios;
    }
    public static ArrayList<Usuario> traerTodosLosUsuariosHabilitados() throws SQLException{

        ArrayList<Usuario> listaUsuarios=new ArrayList<Usuario>();
        Usuario usuario=null;
        ResultSet rs=null;
        String sql="SELECT * FROM `usuarios` WHERE tipo LIKE ?";
        
        try{
            PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
            pst.setString(1, "EMPLEADO");
            rs=pst.executeQuery();
            
            while(rs.next()){
                usuario=new Usuario();  
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setTipo(rs.getString("tipo"));
                
                if(rs.getBoolean("habilitado")==true){                   
                listaUsuarios.add(usuario);
                }
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(new JDialog(),"Error al consultar Usuario"+e.toString());
        }       
        return listaUsuarios;
    }
    public static ArrayList<Usuario> traerUsuariosInhabilitados() throws SQLException{

        ArrayList<Usuario> listaUsuarios=new ArrayList<Usuario>();
        Usuario usuario=null;
        ResultSet rs=null;
        String sql="SELECT * FROM `usuarios` WHERE tipo LIKE ?";
        
        try{
            PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
            pst.setString(1, "EMPLEADO");
            rs=pst.executeQuery();
            
            while(rs.next()){
                usuario=new Usuario();  
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setTipo(rs.getString("tipo"));
                
                if(rs.getBoolean("habilitado")==false){                   
                listaUsuarios.add(usuario);
                }
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(new JDialog(),"Error al consultar Usuario"+e.toString());
        }       
        return listaUsuarios;
    }
    public static Usuario traerUsuario(String nombreUsuario) throws SQLException{

        Usuario usuario=null;
        ResultSet rs=null;
        String sql="SELECT * FROM `usuarios` WHERE usuario LIKE ?";
        
        try{
            PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
            pst.setString(1, nombreUsuario);
            rs=pst.executeQuery();
            
            while(rs.next()){
                usuario=new Usuario();  
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setTipo(rs.getString("tipo"));
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(new JDialog(),"Error al consultar Usuario"+e.toString());
        }       
        return usuario;
    }
    
    public static int AgregarUsuario(Usuario usuario){
        int r=0;
        String SQL="INSERT INTO `usuarios`( `usuario`, `clave`, `tipo`) VALUES (?,?,?)";
        try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);
        pst.setString(1,usuario.getUsuario());
        pst.setString(2,usuario.getClave());
        pst.setString(3,usuario.getTipo());
        r=pst.executeUpdate();
            
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(new JDialog(),"Error al Agregar el Usuario"+e.getMessage());
        }
        return r;
    }
    
    public static int EliminarUsuario(String usuario){
        int r=0;
        String SQL="UPDATE `usuarios` SET `habilitado`=0 WHERE usuarios.usuario LIKE ?";
        try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);
        pst.setString(1,usuario);
        r=pst.executeUpdate();
            
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(new JDialog(),"Error al Eliminar el Usuario"+e.getMessage());
        }
        return r;
    }
    public static int RecuperarUsuario(String usuario){
        int r=0;
        String SQL="UPDATE `usuarios` SET `habilitado`=1 WHERE usuarios.usuario LIKE ?";
        try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);
        pst.setString(1,usuario);
        r=pst.executeUpdate();
            
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(new JDialog(),"Error al Recuperar el Usuario"+e.getMessage());
        }
        return r;
    }
    public static int CambiarContraseña(String nuevaClave,String usuario){
        int r=0;
        String SQL="UPDATE `usuarios` SET `clave`=? WHERE usuario LIKE?";
        try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);
        pst.setString(1,nuevaClave);
        pst.setString(2, usuario);
        r=pst.executeUpdate();
            
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(new JDialog(),"Error al cambiar contraseña del Usuario"+e.getMessage());
        }
        return r;
    }
}
