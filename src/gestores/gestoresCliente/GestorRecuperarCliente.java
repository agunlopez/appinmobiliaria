/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores.gestoresCliente;

import conexion.Conexion;
import entidades.Cliente;
import java.io.IOException;
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
public class GestorRecuperarCliente {
    
    public static ArrayList<Cliente> consultaBuscarClientesInhabilitados(String apellido){
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
                
                if(rs.getBoolean("habilitado")==false){
                    listaA.add(prop);  
                }		       
            }			
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");		
        }		
        return listaA;
    }
                
                
    public static ArrayList<Cliente> consultaClientesInhabilitados(){
        ArrayList<Cliente> listaA=new ArrayList<Cliente>();
        Cliente prop=null;			
        ResultSet rs=null;
        String sql="SELECT idCliente,nombre,apellido,apellidoMaterno,cuit,correo,ciudad,celular,dni,domicilio,dgi,estadoCivil,telefono,profesion,provincia,tipo,habilitado "
                + "FROM cliente ";
        try{
            PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){					
                prop=new Cliente();
                prop.setId(Integer.parseInt(rs.getString("idCliente")));
                prop.setApellido(rs.getString("apellido"));
                prop.setApellidoMaterno(rs.getString("apellidoMaterno"));
                prop.setNombre(rs.getString("nombre"));               
                prop.setDni(Integer.parseInt(rs.getString("dni")));	
                prop.setTipo(rs.getString("tipo"));
				   
                if(rs.getBoolean("habilitado")==false){
                    listaA.add(prop);  
                }			       
            }				
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");			
        }	
        return listaA;
    }
    
    public static int gestorRecuperarCliente(int id) throws IOException{
        int r = 0;
        Cliente prop=BusquedaPropietario.busquedaDatos(id);  
        if (prop == null) {
            return 33;
        } else {
            Object[] opciones = {"Aceptar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(null, "¿Desea recuperar el Cliente  " + prop.getApellido() +" "+prop.getNombre()+ "?", "Mensaje de Confirmacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, opciones, "Cancelar");
            if (eleccion == JOptionPane.YES_OPTION) {
                try{
                    String sql2 = "UPDATE `cliente` SET `habilitado`=1 WHERE  idCliente=?";
                    PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql2);      		
                    pst.setInt(1,prop.getId());
                    r = pst.executeUpdate();                   		
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(new JDialog(),"Error al recuperar el Cliente");
                }  
            } else {
                return 0;
            }
        }
        return r;
    }
    
}
