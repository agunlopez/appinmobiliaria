package gestores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import conexion.Conexion;
import entidades.Usuario;


public class InicioSesion {
	
	public static Usuario inicioSesion(String usuario){
		
		Usuario usu=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM `usuarios` where usuario like ?";
		
		try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			pst.setString(1, usuario);
			rs=pst.executeQuery();
			
			while(rs.next()){
				usu=new Usuario();
				usu.setUsuario(rs.getString("usuario"));
				usu.setClave(rs.getString("clave"));
				usu.setTipo(rs.getString("tipo"));
				
				
				
			}
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
		}
		
		return usu;
	}

}
