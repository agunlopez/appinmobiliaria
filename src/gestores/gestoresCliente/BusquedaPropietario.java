package gestores.gestoresCliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import conexion.Conexion;
import entidades.Cliente;


public class BusquedaPropietario {

	public static ArrayList<Cliente> consultaTablaPropietario(){
		ArrayList<Cliente> listaP=new ArrayList<Cliente>();
		Cliente prop=null;
		String tipo="Propietario";
		
		ResultSet rs=null;
       String sql="SELECT DISTINCT idCliente,nombre,apellido,apellidoMaterno,cuit,correo,ciudad,celular,dni,domicilio,dgi,estadoCivil,telefono,profesion,cliente.provincia,"
               + " fechaNacimiento,habilitado,cliente.tipo FROM cliente,inmueble where inmueble.idPropietario=cliente.idCliente or cliente.tipo like  ?";
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
                                          listaP.add(prop);  
                                        }
                                
				
			   
		       
		      
		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
		
	}
		
		return listaP;
	}
	
    public static Cliente busquedaDatos(int id){
		
		      Cliente prop=null;
		      ResultSet rs=null;
		      
		      String sql="SELECT * FROM `cliente` WHERE idCliente=?";
		      
		      try{
		    	  PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);		
					pst.setInt(1, id);
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
						
					}
					
		      }catch(SQLException e1){
		    	  JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
		    	  
		      }
		
		
		      return prop;
	}
	
    public static Cliente busquedaDatos2(String apellido){
		
	      Cliente prop=null;
	      ResultSet rs=null;
	      
	      String sql="SELECT * FROM `cliente` WHERE apellido=?";
	      
	      try{
	    	  PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);		
				pst.setString(1,apellido);
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
                                        
					
				}
				
	      }catch(SQLException e1){
	    	  JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
	    	  
	      }
	
	
	      return prop;
}
    
    /**
    public static ArrayList<Cliente> consultaTablaPropietario2(String apellido){
		ArrayList<Cliente> listaA=new ArrayList<Cliente>();
		Cliente prop=null;
		String ape="%"+apellido+"%";
		String nom="%"+apellido+"%";
		
		ResultSet rs=null;
                String tipo="Propietario";
                String sql="SELECT DISTINCT idCliente,nombre,apellido,apellidoMaterno,dni,habilitado,cliente.tipo FROM cliente,inmueble where inmueble.idPropietario=cliente.idCliente or "
                + "cliente.tipo like  ? and apellido like ? or nombre like ?";
     //  String sql="SELECT idCliente,nombre,apellido,apellidoMaterno,dni,tipo,habilitado FROM cliente where apellido like ? or nombre like ?";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
                        pst.setString(1, tipo);
			pst.setString(2,ape);
			pst.setString(3, nom);
			rs=pst.executeQuery();

			while(rs.next()){
				
				prop=new Cliente();
				prop.setId(Integer.parseInt(rs.getString("idCliente")));
				prop.setApellido(rs.getString("apellido"));
				prop.setNombre(rs.getString("nombre"));
				prop.setDni(Integer.parseInt(rs.getString("dni")));
				prop.setApellidoMaterno(rs.getString("apellidoMaterno"));
                                prop.setTipo(rs.getString("cliente.tipo"));

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
