package gestores.gestoresCliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import conexion.Conexion;
import entidades.Cliente;

public class BusquedaGarante {


		public static ArrayList<Cliente> consultaTablaGarante(){
			ArrayList<Cliente> listaA=new ArrayList<Cliente>();
			Cliente prop=null;
			String tipo="Garante";
			
			ResultSet rs=null;
	       String sql="SELECT DISTINCT idCliente,nombre,apellido,apellidoMaterno,cuit,correo,ciudad,celular,dni,domicilio,dgi,estadoCivil,telefono,profesion,provincia,"
                       + "fechaNacimiento,habilitado,tipo FROM cliente,contrato where contrato.idGarante=cliente.idCliente or tipo like ?";
		try{
				PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
				pst.setString (1, tipo);
				rs=pst.executeQuery();

				while(rs.next()){
					
					prop=new Cliente();
					prop.setId(Integer.parseInt(rs.getString("idCliente")));
					prop.setApellido(rs.getString("apellido"));
					prop.setApellidoMaterno(rs.getString("apellidoMaterno"));
					prop.setNombre(rs.getString("nombre"));
					prop.setDni(Integer.parseInt(rs.getString("dni")));;
					prop.setCuit(Integer.parseInt(rs.getString("cuit")));
					prop.setCorreo(rs.getString("correo"));
					prop.setTel(Integer.parseInt(rs.getString("telefono")));
					prop.setFechaNac(rs.getString("fechaNacimiento"));
					prop.setEstadoCivil(rs.getString("estadoCivil"));
					prop.setProfesion(rs.getString("profesion"));
					prop.setDireccion(rs.getString("domicilio"));
					prop.setLocalidad(rs.getString("ciudad"));
					prop.setProvincia(rs.getString("provincia"));
					prop.setDgi(rs.getString("dgi"));
					prop.setCelular(Integer.parseInt(rs.getString("celular")));
				   
                                        if(rs.getBoolean("habilitado")==true){
                                          listaA.add(prop);  
                                        }
                                     
                                
			       
			  
			       
				}
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(new JDialog(),"Error al consultar "+e.toString());
			
		}
			
			return listaA;
		}
     /**           
                public static ArrayList<Cliente> consultaTablaGarante2(String apellido){
		ArrayList<Cliente> listaA=new ArrayList<Cliente>();
		Cliente prop=null;
		String ape="%"+apellido+"%";
		String nom="%"+apellido+"%";
		
		ResultSet rs=null;
       String sql="SELECT idCliente,nombre,apellido,apellidoMaterno,dni,tipo,habilitado FROM cliente where apellido like ? or nombre like ?";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			pst.setString(1,ape);
			pst.setString(2, nom);
			rs=pst.executeQuery();

			while(rs.next()){
				
				prop=new Cliente();
				prop.setId(Integer.parseInt(rs.getString("idCliente")));
				prop.setApellido(rs.getString("apellido"));
				prop.setNombre(rs.getString("nombre"));
				prop.setDni(Integer.parseInt(rs.getString("dni")));
				prop.setApellidoMaterno(rs.getString("apellidoMaterno"));
                                prop.setTipo(rs.getString("tipo"));
		   
		       if(prop.getTipo().equals("Garante")){
                           if(rs.getBoolean("habilitado")==true){
                                          listaA.add(prop);  
                                        }
                       }		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
		
	}
		
		return listaA;
	}
            /**    
                public static ArrayList<Cliente> consultaTablaGarante3(){
			ArrayList<Cliente> listaA=new ArrayList<Cliente>();
			Cliente prop=null;
			String tipo="Garante";
			
			ResultSet rs=null;
	       String sql="SELECT idCliente,nombre,apellido,apellidoMaterno,cuit,correo,ciudad,celular,dni,domicilio,dgi,estadoCivil,telefono,profesion,provincia,fechaNacimiento,habilitado "
	       		+ "FROM cliente WHERE cliente.tipo like ?";
		try{
				PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
				pst.setString (1, tipo);
				rs=pst.executeQuery();

				while(rs.next()){
					
					prop=new Cliente();
					prop.setId(Integer.parseInt(rs.getString("idCliente")));
					prop.setApellido(rs.getString("apellido"));
					prop.setApellidoMaterno(rs.getString("apellidoMaterno"));
					prop.setNombre(rs.getString("nombre"));
					prop.setDni(Integer.parseInt(rs.getString("dni")));;

				   
			       
			       if(rs.getBoolean("habilitado")==true){
                                          listaA.add(prop);  
                                        }
			       
				}
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
			
		}
			
			return listaA;
		}
                
                 public static ArrayList<Cliente> consultaTablaGarante4(String id){
			ArrayList<Cliente> listaA=new ArrayList<Cliente>();
			Cliente prop=null;
			String tipo="Garante";
			
			ResultSet rs=null;
	       String sql="SELECT idCliente,nombre,apellido,apellidoMaterno,cuit,correo,ciudad,celular,dni,domicilio,dgi,estadoCivil,telefono,profesion,provincia,fechaNacimiento,habilitado "
	       		+ "FROM cliente WHERE cliente.tipo like ? and idCliente<>?";
		try{
				PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
				pst.setString (1, tipo);
                                pst.setString(2, id);
				rs=pst.executeQuery();

				while(rs.next()){
					
					prop=new Cliente();
					prop.setId(Integer.parseInt(rs.getString("idCliente")));
					prop.setApellido(rs.getString("apellido"));
					prop.setApellidoMaterno(rs.getString("apellidoMaterno"));
					prop.setNombre(rs.getString("nombre"));
					prop.setDni(Integer.parseInt(rs.getString("dni")));;

				   
			       
			      if(rs.getBoolean("habilitado")==true){
                                          listaA.add(prop);  
                                        }
			       
				}
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
			
		}
			
			return listaA;
		}**/
	}
