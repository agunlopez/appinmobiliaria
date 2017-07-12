/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores.gestoresCliente;

import conexion.Conexion;
import entidades.Cliente;
import entidades.Contrato;
import entidades.Inmueble;
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
public class BusquedaCliente {
    
    
    //Para buscar todo los clientes y mandarlos al seleccionar en inmueble
    
    public static ArrayList<Cliente> consultaCliente(){
		ArrayList<Cliente> listaP=new ArrayList<Cliente>();
		Cliente prop=null;
		
		
		ResultSet rs=null;
       String sql="Select * from cliente";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);

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
                                prop.setTipo(rs.getString("tipo"));
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
    
    public static ArrayList<Cliente> consultaClienteApellido(String apellido){
		ArrayList<Cliente> listaA=new ArrayList<Cliente>();
		Cliente prop=null;
		String ape="%"+apellido+"%";
		String nom="%"+apellido+"%";
		
		ResultSet rs=null;
       String sql="SELECT idCliente,nombre,apellido,apellidoMaterno,dni,tipo,habilitado FROM cliente where apellido like ? ";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			pst.setString(1,ape);
			rs=pst.executeQuery();

			while(rs.next()){
				
				prop=new Cliente();
				prop.setId(Integer.parseInt(rs.getString("idCliente")));
				prop.setApellido(rs.getString("apellido"));
				prop.setNombre(rs.getString("nombre"));
				prop.setDni(Integer.parseInt(rs.getString("dni")));
				prop.setApellidoMaterno(rs.getString("apellidoMaterno"));
                                prop.setTipo(rs.getString("tipo"));

                           if(rs.getBoolean("habilitado")==true){
                                          listaA.add(prop);  
                                        }
                       

		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
		
	}
		
		return listaA;
	}
    
    public static ArrayList<Cliente> consultaBusquedaClienteApellido(String apellido, String tipo){
		ArrayList<Cliente> listaA=new ArrayList<Cliente>();
		Cliente prop=null;
		String ape="%"+apellido+"%";
		
		ResultSet rs=null;
       String sql="SELECT * FROM cliente where apellido like ? ";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			pst.setString(1,ape);
			rs=pst.executeQuery();

			while(rs.next()){
				
			prop=new Cliente();
				prop.setId(Integer.parseInt(rs.getString("idCliente")));
				prop.setApellido(rs.getString("apellido"));
				prop.setNombre(rs.getString("nombre"));
				prop.setDni(Integer.parseInt(rs.getString("dni")));
				prop.setApellidoMaterno(rs.getString("apellidoMaterno"));
                                prop.setTipo(rs.getString("tipo"));

                           if(rs.getBoolean("habilitado")==true){
                               if(tipo.equals("Todos")){
                                   listaA.add(prop);
                               }else{
                                   if(tipo.equals("Propietarios")){
                                       if(prop.getTipo().equals("Propietario")){
                                           listaA.add(prop);
                                       }
                                   }else if(tipo.equals("Inquilinos")){
                                       if(prop.getTipo().equals("Inquilino")){
                                           listaA.add(prop);
                                       }
                                   }else if(tipo.equals("Garantes")){
                                       if(prop.getTipo().equals("Garante")){
                                           listaA.add(prop);
                                       }
                                   }
                               }                                        
                           }
                       

		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
		
	}
		
		return listaA;
	}
    
    public static ArrayList<Cliente> consultaBusquedaClienteDNI(int dniCliente){
		ArrayList<Cliente> listaA=new ArrayList<Cliente>();
		Cliente prop=null;		
		ResultSet rs=null;
       String sql="SELECT * FROM cliente where dni=?";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			pst.setInt(1,dniCliente);
			rs=pst.executeQuery();
			while(rs.next()){				
			prop=new Cliente();
				prop.setId(Integer.parseInt(rs.getString("idCliente")));
				prop.setApellido(rs.getString("apellido"));
				prop.setNombre(rs.getString("nombre"));
				prop.setDni(Integer.parseInt(rs.getString("dni")));
				prop.setApellidoMaterno(rs.getString("apellidoMaterno"));
                                prop.setTipo(rs.getString("tipo"));

                           if(rs.getBoolean("habilitado")==true){
                                       listaA.add(prop);
                           }                       		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
		
	}
		
		return listaA;
	}
    
    public static ArrayList<Cliente> consultaBusquedaClienteTipo(String tipo){
		ArrayList<Cliente> listaA=new ArrayList<Cliente>();
		Cliente prop=null;		
		ResultSet rs=null;
                String sql="SELECT * FROM cliente ";
                try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){				
			prop=new Cliente();
				prop.setId(Integer.parseInt(rs.getString("idCliente")));
				prop.setApellido(rs.getString("apellido"));
				prop.setNombre(rs.getString("nombre"));
				prop.setDni(Integer.parseInt(rs.getString("dni")));
				prop.setApellidoMaterno(rs.getString("apellidoMaterno"));
                                prop.setTipo(rs.getString("tipo"));

                           if(rs.getBoolean("habilitado")==true){
                                      if(prop.getTipo().equals(tipo)){
                                          listaA.add(prop);
                                      
                                  }
                           }                       		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
		
	}
		
		return listaA;
	}
    
    
    public static ArrayList<Contrato> contratosDelCliente(int idCliente){
        ArrayList<Contrato> listaContratos=new ArrayList<Contrato>();
        String estado="Activo";
        String sql="SELECT cliente.nombre, contrato.idContrato,contrato.fechaVencimiento,inmueble.dpto,inmueble.piso,inmueble.calle,inmueble.idPropietario,contrato.idInquilino,contrato.idGarante,contrato.idGarante2,"
            + "inmueble.idInmueble FROM contrato INNER JOIN inmueble on contrato.idInmueble=inmueble.idInmueble "
            + "INNER JOIN cliente on cliente.idCliente=inmueble.idPropietario or cliente.idCliente=contrato.idInquilino or cliente.idCliente=contrato.idGarante "
            + "or cliente.idCliente=contrato.idGarante2 WHERE cliente.idCliente=? and contrato.estado like ?";
        Cliente cliente=null;
        Contrato contrato=null;
        Inmueble inmueble=null;
        ResultSet rs=null;
        
        try{
            PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
            pst.setInt(1, idCliente);
            pst.setString(2, estado);
            rs=pst.executeQuery();
            while(rs.next()){
                contrato=new Contrato();
                cliente=new Cliente();
                inmueble=new Inmueble();
                
                inmueble.setCalle(rs.getString("inmueble.calle"));
                inmueble.setPiso(rs.getString("inmueble.piso"));
                inmueble.setDpto(rs.getString("inmueble.dpto"));
                
                if(rs.getInt("inmueble.idPropietario")==idCliente){
                    cliente.setRolContrato("Propietario");
                }else if(rs.getInt("contrato.idInquilino")==idCliente){
                    cliente.setRolContrato("Inquilino");
                }else if(rs.getInt("contrato.idGarante")==idCliente){
                    cliente.setRolContrato("Garante 1");                
                }else if(rs.getInt("contrato.idGarante2")==idCliente){
                    cliente.setRolContrato("Garante 2");
                }
                
                contrato.setInmueble(inmueble);
                contrato.setCliente(cliente);
                contrato.setFechaInicio(rs.getString("contrato.fechaVencimiento"));
                contrato.setIdContrato(rs.getInt("contrato.idContrato"));
                
                listaContratos.add(contrato);
            }
                
            
        }catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
		
	}
        
        
        
        return listaContratos;
    }
    
}
