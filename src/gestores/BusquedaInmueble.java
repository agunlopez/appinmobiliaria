package gestores;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import conexion.Conexion;
import entidades.Inmueble;
import entidades.Cliente;




public class BusquedaInmueble {
	
	public static ArrayList<Inmueble> consultaTabla(){
		ArrayList<Inmueble> listaA=new ArrayList<Inmueble>();
		Inmueble inm=null;
		Cliente prop=null;
		
		
		ResultSet rs=null;
        String sql="SELECT idInmueble,calle,piso,dpto,inmueble.tipo,estado,localidad,cliente.nombre,cliente.apellido,inmueble.provincia "
       		+ "FROM inmueble,cliente WHERE inmueble.idPropietario=cliente.idCliente";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			rs=pst.executeQuery();

			while(rs.next()){
			   inm=new Inmueble();
			   prop=new Cliente();
			   prop.setApellido(rs.getString("cliente.apellido"));
			   prop.setNombre(rs.getString("cliente.nombre"));
			   inm.setId(Integer.parseInt(rs.getString("idInmueble")));
		       inm.setCalle(rs.getString("calle"));
		       inm.setDpto(rs.getString("dpto"));
		       inm.setLocalidad(rs.getString("localidad"));
		       inm.setPiso(rs.getString("piso"));
		       inm.setEstado(rs.getString("estado"));
		       inm.setTipo(rs.getString("inmueble.tipo"));
                       inm.setProvincia(rs.getString("inmueble.provincia"));
		       inm.setPropietario(prop);
		       
                       if(inm.getEstado().equals("Inhabilitado")){
                           
                       }else{
                        listaA.add(inm);   
                       }
                       
                       
		       
		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar"+e.toString());
		
	}
		
		return listaA;
	}
	
	public static Inmueble busquedaDatosInmueble(int id){
		Inmueble inm=null;		
		ResultSet rs=null;
		Cliente prop=null;
       String sql="SELECT * FROM `inmueble`,cliente WHERE inmueble.idPropietario=cliente.idCliente and inmueble.idInmueble=?";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			
			pst.setInt(1, id);
			rs=pst.executeQuery();

			while(rs.next()){
			   inm=new Inmueble();
			   prop=new Cliente();
	          	   prop.setApellido(rs.getString("cliente.apellido"));
		       prop.setNombre(rs.getString("cliente.nombre"));
                       prop.setId(Integer.parseInt(rs.getString("cliente.idCliente")));
		       inm.setCalle(rs.getString("calle"));
		       inm.setDpto(rs.getString("dpto"));
		       inm.setLocalidad(rs.getString("localidad"));
		       inm.setPiso(rs.getString("piso"));
		       inm.setEstado(rs.getString("estado"));
		       inm.setPropietario(prop);
		       inm.setId(Integer.parseInt(rs.getString("idInmueble")));
		       inm.setTipo(rs.getString("inmueble.tipo"));
                       inm.setFechaInscripcion(rs.getString("fechaInscripcion"));
                       inm.setFolio((rs.getString("folio")));
                       inm.setFolioReal(Integer.parseInt(rs.getString("folioReal")));
                       inm.setTomo(Integer.parseInt(rs.getString("tomo")));
                       inm.setProvincia(rs.getString("provincia"));
		       
		       
		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
		
	}
       

		
		
		return inm;
	}
	
	
	
	
	
	public static ArrayList<Inmueble> consultaPorEstado(String estado){
		ArrayList<Inmueble> listaA=new ArrayList<Inmueble>();
		Inmueble inm=null;
		Cliente prop=null;
		
		
		ResultSet rs=null;
        String sql="SELECT idInmueble,calle,piso,dpto,inmueble.tipo,estado,localidad,cliente.nombre,cliente.apellido,"
                + "inmueble.provincia FROM inmueble,cliente WHERE inmueble.idPropietario=cliente.idCliente "
                + "AND inmueble.estado like ?";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
                        pst.setString(1, estado);
			rs=pst.executeQuery();

			while(rs.next()){
			   inm=new Inmueble();
			   prop=new Cliente();
			   prop.setApellido(rs.getString("cliente.apellido"));
			   prop.setNombre(rs.getString("cliente.nombre"));
			   inm.setId(Integer.parseInt(rs.getString("idInmueble")));
		       inm.setCalle(rs.getString("calle"));
		       inm.setDpto(rs.getString("dpto"));
		       inm.setLocalidad(rs.getString("localidad"));
		       inm.setPiso(rs.getString("piso"));
		       inm.setEstado(rs.getString("estado"));
		       inm.setTipo(rs.getString("inmueble.tipo"));
                       inm.setProvincia(rs.getString("inmueble.provincia"));
		       inm.setPropietario(prop);
		       

                           listaA.add(inm);
                       
		       
		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar"+e.toString());
		
	}
		
		return listaA;
}
	
        
        public static ArrayList<Inmueble> consultaTablaInmuebleContrato(){
		ArrayList<Inmueble> listaA=new ArrayList<Inmueble>();
		Inmueble inm=null;
		Cliente prop=null;
		
		
		ResultSet rs=null;
      String sql="SELECT idInmueble,calle,piso,dpto,inmueble.tipo,estado,localidad,cliente.nombre,cliente.apellido,cliente.idCliente,inmueble.provincia "
              + "FROM inmueble,cliente WHERE inmueble.idPropietario=cliente.idCliente";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			rs=pst.executeQuery();

			while(rs.next()){
			   inm=new Inmueble();
			   prop=new Cliente();
			   prop.setApellido(rs.getString("cliente.apellido"));
			   prop.setNombre(rs.getString("cliente.nombre"));
                           prop.setId(Integer.parseInt(rs.getString("cliente.idCliente")));
			   inm.setId(Integer.parseInt(rs.getString("idInmueble")));
		       inm.setCalle(rs.getString("calle"));
		       inm.setDpto(rs.getString("dpto"));
		       inm.setLocalidad(rs.getString("localidad"));
		       inm.setPiso(rs.getString("piso"));
		       inm.setEstado(rs.getString("estado"));
		       inm.setTipo(rs.getString("inmueble.tipo"));
                      
		       inm.setPropietario(prop);
                       inm.setProvincia(rs.getString("inmueble.provincia"));
                           if(inm.getEstado().equals("Disponible")){
                           listaA.add(inm);
                       }
                    
		       
		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar"+e.toString());
		
	}
		
		return listaA;
	}
        
        public static ArrayList<Inmueble> consultaTablaBusquedaInmueble(String calle){
		ArrayList<Inmueble> listaA=new ArrayList<Inmueble>();
                
                String c="%"+calle+"%";
		Inmueble inm=null;
		Cliente prop=null;
		
		
		ResultSet rs=null;
       String sql="SELECT inmueble.idInmueble,inmueble.calle,inmueble.piso,inmueble.dpto,inmueble.tipo,"
               + "inmueble.localidad,inmueble.estado,cliente.nombre,cliente.apellido,cliente.idCliente,inmueble.provincia "
               + "from inmueble INNER JOIN cliente on inmueble.idPropietario=cliente.idCliente "
               + "where inmueble.calle like ? ";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
                        pst.setString(1, c);
			rs=pst.executeQuery();

			while(rs.next()){
			   inm=new Inmueble();
			   prop=new Cliente();
			   prop.setApellido(rs.getString("cliente.apellido"));
			   prop.setNombre(rs.getString("cliente.nombre"));
                           prop.setId(Integer.parseInt(rs.getString("cliente.idCliente")));
			   inm.setId(Integer.parseInt(rs.getString("idInmueble")));
		       inm.setCalle(rs.getString("calle"));
		       inm.setDpto(rs.getString("dpto"));
		       inm.setLocalidad(rs.getString("localidad"));
		       inm.setPiso(rs.getString("piso"));
		       inm.setEstado(rs.getString("estado"));
		       inm.setTipo(rs.getString("inmueble.tipo"));
                       inm.setPropietario(prop);
                       inm.setProvincia(rs.getString("inmueble.provincia"));
                       if(inm.getEstado().equals("Disponible")){
                           listaA.add(inm);
                       }
                        }
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar"+e.toString());
		
	}
		
		return listaA;
	}
        
         public static ArrayList<Inmueble> consultaTablaBusquedaInmueblePrincipal(String calle){
		ArrayList<Inmueble> listaA=new ArrayList<Inmueble>();
                
                String c="%"+calle+"%";
		Inmueble inm=null;
		Cliente prop=null;
		
		
		ResultSet rs=null;
       String sql="SELECT inmueble.idInmueble,inmueble.calle,inmueble.piso,inmueble.dpto,inmueble.tipo," +
               " inmueble.localidad,inmueble.estado,cliente.nombre,cliente.apellido,cliente.idCliente,inmueble.provincia" +
               " from inmueble INNER JOIN cliente on inmueble.idPropietario=cliente.idCliente " +
               " where inmueble.calle like ?";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
                        pst.setString(1, c);
			rs=pst.executeQuery();

			while(rs.next()){
			   inm=new Inmueble();
			   prop=new Cliente();
			   prop.setApellido(rs.getString("cliente.apellido"));
			   prop.setNombre(rs.getString("cliente.nombre"));
                           prop.setId(Integer.parseInt(rs.getString("cliente.idCliente")));
			   inm.setId(Integer.parseInt(rs.getString("idInmueble")));
		       inm.setCalle(rs.getString("calle"));
		       inm.setDpto(rs.getString("dpto"));
		       inm.setLocalidad(rs.getString("localidad"));
		       inm.setPiso(rs.getString("piso"));
		       inm.setEstado(rs.getString("estado"));
		       inm.setTipo(rs.getString("inmueble.tipo"));
                       inm.setPropietario(prop);
                     //  inm.setProvincia(rs.getString("inmueble.provincia"));
                       
                       if(inm.getEstado().equals("Inhabilitado")){
                           
                       }else{
                        listaA.add(inm);   
                       }
                       
                       
                       
                           
                       
		       
		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar"+e.toString());
		
	}
		
		return listaA;
	}
         
        public static ArrayList<Inmueble> consultaTablaBusquedaInmueblePrincipalLocalidad(String calle){
		ArrayList<Inmueble> listaA=new ArrayList<Inmueble>();
                
                String c="%"+calle+"%";
		Inmueble inm=null;
		Cliente prop=null;
		
		
		ResultSet rs=null;
       String sql="SELECT inmueble.idInmueble,inmueble.calle,inmueble.piso,inmueble.dpto,inmueble.tipo," +
               " inmueble.localidad,inmueble.estado,cliente.nombre,cliente.apellido,cliente.idCliente,inmueble.provincia" +
               " from inmueble INNER JOIN cliente on inmueble.idPropietario=cliente.idCliente " +
               " where inmueble.localidad like ?";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
                        pst.setString(1, c);
			rs=pst.executeQuery();

			while(rs.next()){
			   inm=new Inmueble();
			   prop=new Cliente();
			   prop.setApellido(rs.getString("cliente.apellido"));
			   prop.setNombre(rs.getString("cliente.nombre"));
                           prop.setId(Integer.parseInt(rs.getString("cliente.idCliente")));
			   inm.setId(Integer.parseInt(rs.getString("idInmueble")));
		       inm.setCalle(rs.getString("calle"));
		       inm.setDpto(rs.getString("dpto"));
		       inm.setLocalidad(rs.getString("localidad"));
		       inm.setPiso(rs.getString("piso"));
		       inm.setEstado(rs.getString("estado"));
		       inm.setTipo(rs.getString("inmueble.tipo"));
                       inm.setPropietario(prop);
                     //  inm.setProvincia(rs.getString("inmueble.provincia"));
                       
                       if(inm.getEstado().equals("Inhabilitado")){
                           
                       }else{
                        listaA.add(inm);   
                       }
                       
                       
                       
                           
                       
		       
		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar"+e.toString());
		
	}
		
		return listaA;
	} 
        
         public static ArrayList<Inmueble> consultaTablaBusquedaInmueblePrincipalPropietario(String calle){
		ArrayList<Inmueble> listaA=new ArrayList<Inmueble>();
                
                String c="%"+calle+"%";
		Inmueble inm=null;
		Cliente prop=null;
		
		
		ResultSet rs=null;
       String sql="SELECT inmueble.idInmueble,inmueble.calle,inmueble.piso,inmueble.dpto,inmueble.tipo," +
               " inmueble.localidad,inmueble.estado,cliente.nombre,cliente.apellido,cliente.idCliente,inmueble.provincia" +
               " from inmueble INNER JOIN cliente on inmueble.idPropietario=cliente.idCliente " +
               " where cliente.apellido like ?";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
                        pst.setString(1, c);
			rs=pst.executeQuery();

			while(rs.next()){
			   inm=new Inmueble();
			   prop=new Cliente();
			   prop.setApellido(rs.getString("cliente.apellido"));
			   prop.setNombre(rs.getString("cliente.nombre"));
                           prop.setId(Integer.parseInt(rs.getString("cliente.idCliente")));
			   inm.setId(Integer.parseInt(rs.getString("idInmueble")));
		       inm.setCalle(rs.getString("calle"));
		       inm.setDpto(rs.getString("dpto"));
		       inm.setLocalidad(rs.getString("localidad"));
		       inm.setPiso(rs.getString("piso"));
		       inm.setEstado(rs.getString("estado"));
		       inm.setTipo(rs.getString("inmueble.tipo"));
                       inm.setPropietario(prop);
                     //  inm.setProvincia(rs.getString("inmueble.provincia"));
                       
                       if(inm.getEstado().equals("Inhabilitado")){
                           
                       }else{
                        listaA.add(inm);   
                       }
                       
                       
                       
                           
                       
		       
		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar"+e.toString());
		
	}
		
		return listaA;
	} 
        public static ArrayList<Inmueble> consultaTablaBusquedaInmueblePrincipalTipo(String calle){
		ArrayList<Inmueble> listaA=new ArrayList<Inmueble>();
                
                String c="%"+calle+"%";
		Inmueble inm=null;
		Cliente prop=null;
		
		
		ResultSet rs=null;
       String sql="SELECT inmueble.idInmueble,inmueble.calle,inmueble.piso,inmueble.dpto,inmueble.tipo," +
               " inmueble.localidad,inmueble.estado,cliente.nombre,cliente.apellido,cliente.idCliente,inmueble.provincia" +
               " from inmueble INNER JOIN cliente on inmueble.idPropietario=cliente.idCliente " +
               " where inmueble.tipo like ?";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
                        pst.setString(1, c);
			rs=pst.executeQuery();

			while(rs.next()){
			   inm=new Inmueble();
			   prop=new Cliente();
			   prop.setApellido(rs.getString("cliente.apellido"));
			   prop.setNombre(rs.getString("cliente.nombre"));
                           prop.setId(Integer.parseInt(rs.getString("cliente.idCliente")));
			   inm.setId(Integer.parseInt(rs.getString("idInmueble")));
		       inm.setCalle(rs.getString("calle"));
		       inm.setDpto(rs.getString("dpto"));
		       inm.setLocalidad(rs.getString("localidad"));
		       inm.setPiso(rs.getString("piso"));
		       inm.setEstado(rs.getString("estado"));
		       inm.setTipo(rs.getString("inmueble.tipo"));
                       inm.setPropietario(prop);
                     //  inm.setProvincia(rs.getString("inmueble.provincia"));
                       
                       if(inm.getEstado().equals("Inhabilitado")){
                           
                       }else{
                        listaA.add(inm);   
                       }
                       
                       
                       
                           
                       
		       
		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar"+e.toString());
		
	}
		
		return listaA;
	} 

         public static ArrayList<Inmueble> consultaTablaInmuebleRecuperar(){
		ArrayList<Inmueble> listaA=new ArrayList<Inmueble>();
		Inmueble inm=null;
		Cliente prop=null;
		
		
		ResultSet rs=null;
      String sql="SELECT idInmueble,calle,piso,dpto,inmueble.tipo,estado,localidad,cliente.nombre,cliente.apellido,cliente.idCliente,inmueble.provincia "
              + "FROM inmueble,cliente WHERE inmueble.idPropietario=cliente.idCliente";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			rs=pst.executeQuery();

			while(rs.next()){
			   inm=new Inmueble();
			   prop=new Cliente();
			   prop.setApellido(rs.getString("cliente.apellido"));
			   prop.setNombre(rs.getString("cliente.nombre"));
                           prop.setId(Integer.parseInt(rs.getString("cliente.idCliente")));
			   inm.setId(Integer.parseInt(rs.getString("idInmueble")));
		       inm.setCalle(rs.getString("calle"));
		       inm.setDpto(rs.getString("dpto"));
		       inm.setLocalidad(rs.getString("localidad"));
		       inm.setPiso(rs.getString("piso"));
		       inm.setEstado(rs.getString("estado"));
		       inm.setTipo(rs.getString("inmueble.tipo"));
                      
		       inm.setPropietario(prop);
                       inm.setProvincia(rs.getString("inmueble.provincia"));
                           if(inm.getEstado().equals("Inhabilitado")){
                           listaA.add(inm);
                       }
                    
		       
		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar"+e.toString());
		
	}
		
		return listaA;
	}
         public static ArrayList<Inmueble> consultaTablaRecuperarInmueble(String calle){
		ArrayList<Inmueble> listaA=new ArrayList<Inmueble>();              
                String c="%"+calle+"%";
		Inmueble inm=null;
		Cliente prop=null;				
		ResultSet rs=null;
       String sql="SELECT inmueble.idInmueble,inmueble.calle,inmueble.piso,inmueble.dpto,inmueble.tipo,"
               + "inmueble.localidad,inmueble.estado,cliente.nombre,cliente.apellido,cliente.idCliente,inmueble.provincia "
               + "from inmueble INNER JOIN cliente on inmueble.idPropietario=cliente.idCliente "
               + "where inmueble.calle like ? ";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
                        pst.setString(1, c);
			rs=pst.executeQuery();

			while(rs.next()){
			   inm=new Inmueble();
			   prop=new Cliente();
			   prop.setApellido(rs.getString("cliente.apellido"));
			   prop.setNombre(rs.getString("cliente.nombre"));
                           prop.setId(Integer.parseInt(rs.getString("cliente.idCliente")));
			   inm.setId(Integer.parseInt(rs.getString("idInmueble")));
		       inm.setCalle(rs.getString("calle"));
		       inm.setDpto(rs.getString("dpto"));
		       inm.setLocalidad(rs.getString("localidad"));
		       inm.setPiso(rs.getString("piso"));
		       inm.setEstado(rs.getString("estado"));
		       inm.setTipo(rs.getString("inmueble.tipo"));
                       inm.setPropietario(prop);
                       inm.setProvincia(rs.getString("inmueble.provincia"));
                       if(inm.getEstado().equals("Inhabilitado")){
                           listaA.add(inm);
                       }
                       
                      
                           
                       
		       
		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar"+e.toString());
		
	}
		
		return listaA;
	}
}
