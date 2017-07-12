package gestores.gestoresCliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import conexion.Conexion;
import entidades.Cliente;

import java.io.IOException;

public class GestorModificarCliente {

	public int modificarCliente(Cliente prop) throws IOException{
		
		int r=0;
		String sql="UPDATE `cliente` SET `nombre`=?,`apellido`=?,`apellidoMaterno`=?,`dni`=?,`cuit`=?,`correo`=?,`telefono`=?,`fechaNacimiento`=?,`estadoCivil`=?,"
				+ "`profesion`=?,`domicilio`=?,`ciudad`=?,`provincia`=?,`dgi`=?,`celular`=? "
				+ "WHERE idCliente=?";
		
		try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
		
		pst.setString(1, prop.getNombre());
		pst.setString(2,prop.getApellido());
		pst.setString(3,prop.getApellidoMaterno());
		pst.setInt(4,prop.getDni());
		pst.setInt(5,prop.getCuit());
		pst.setString(6,prop.getCorreo());
		pst.setInt(7, prop.getTel());
		pst.setString(8,prop.getFechaNac());
		pst.setString(9,prop.getEstadoCivil());
		pst.setString(10,prop.getProfesion());
		pst.setString(11,prop.getDireccion());
		pst.setString(12,prop.getLocalidad());
		pst.setString(13,prop.getProvincia());
		pst.setString(14,prop.getDgi());
		pst.setInt(15,prop.getCelular());
		pst.setInt(16,prop.getId());
		r=pst.executeUpdate();

		
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al Modificar");}
		
		
		
		
		
		return r;
	}
}
