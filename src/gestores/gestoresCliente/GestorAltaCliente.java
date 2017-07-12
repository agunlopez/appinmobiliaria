package gestores.gestoresCliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import conexion.Conexion;

import entidades.Cliente;
import java.io.IOException;

public class GestorAltaCliente {
	
	public int altaPropietario(Cliente prop) throws IOException{
		int r=0;
		String SQL="INSERT INTO `cliente`(`idCliente`, `nombre`, `apellido`, `apellidoMaterno`, `dni`, `cuit`, `correo`, `telefono`, `fechaNacimiento`,"
				+ " `estadoCivil`, `profesion`, `domicilio`, `ciudad`, `provincia`, `dgi`, `celular`,tipo) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);
		
		pst.setInt(1, prop.getId());
		pst.setString(2, prop.getNombre());
		pst.setString(3,prop.getApellido());
		pst.setString(4,prop.getApellidoMaterno());
		pst.setInt(5,prop.getDni());
		pst.setInt(6,prop.getCuit());
		pst.setString(7,prop.getCorreo());
		pst.setInt(8, prop.getTel());
		pst.setString(9,prop.getFechaNac());
		pst.setString(10,prop.getEstadoCivil());
		pst.setString(11,prop.getProfesion());
		pst.setString(12,prop.getDireccion());
		pst.setString(13,prop.getLocalidad());
		pst.setString(14,prop.getProvincia());
		pst.setString(15,prop.getDgi());
		pst.setInt(16,prop.getCelular());
		pst.setString(17, prop.getTipo());

		r=pst.executeUpdate();
                

		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al Agregar el Cliente "+e.toString());}
	
		return r;
	}
	
	public static int consultaId(){
            int id=0;				
            ResultSet rs=null;
            String sql="SELECT  idCliente from cliente ORDER BY idCliente DESC LIMIT 1";
            try{
                PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
                rs=pst.executeQuery();
                while(rs.next()){
                    id=(Integer.parseInt(rs.getString("idCliente")));			     
                }						
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");					
            }					
            return id;
        }
        
        public static boolean consultaDni(int dni){
            
            boolean consultaDni=false;
            ResultSet rs=null;
            String sql="select dni from cliente where dni=?";
            try{
                PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
                pst.setInt(1, dni);
                rs=pst.executeQuery();
                while(rs.next()){
                    consultaDni=true;
                }
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(new JDialog(),"Error al consultar "+e.toString());					
            }          
            return consultaDni;
        }

}
