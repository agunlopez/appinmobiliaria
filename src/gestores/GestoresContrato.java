
package gestores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import conexion.Conexion;
import entidades.Cliente;
import entidades.Contrato;
import entidades.Cuotas;
import entidades.TitularImpuesto;
import entidades.Inmueble;
import java.io.IOException;

public class GestoresContrato {
    
    
    
    
    
	public static ArrayList<Contrato> consultaTablaContrato(){
		ArrayList<Contrato> listaA=new ArrayList<Contrato>();
		Contrato contrato=null;
		Inmueble inmu=null;
		Cliente prop=null;
		Cliente inq=null;
		Cliente gara=null;
		Cliente gara2=null;
		
		ResultSet rs=null;
                
                String sql="SELECT contrato.idContrato,inmueble.idInmueble,inmueble.calle,contrato.fechaComienzo,contrato.fechaVencimiento,contrato.estado,contrato.cuotaActual,"
                        + " prop.apellido,prop.nombre,inq.apellido,inq.nombre,gara.apellido,gara.nombre,gara2.nombre,gara2.apellido"
                        + " FROM contrato,cliente as prop,cliente as inq,cliente as gara,cliente as gara2,inmueble "
                        + "WHERE inmueble.idPropietario=prop.idCliente and contrato.idInquilino=inq.idCliente and contrato.idGarante=gara.idCliente and "
                        + "contrato.idGarante2=gara2.idCliente and contrato.idInmueble=inmueble.idInmueble";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			rs=pst.executeQuery();

			while(rs.next()){
				
				contrato=new Contrato();
				inmu=new Inmueble();
				prop=new Cliente();
				inq=new Cliente();
				gara=new Cliente();
                                gara2=new Cliente();
				
                                inmu.setId(rs.getInt("inmueble.idInmueble"));
				inmu.setCalle(rs.getString("inmueble.calle"));
				
				prop.setNombre(rs.getString("prop.nombre"));
                                prop.setApellido(rs.getString("prop.apellido"));
				inmu.setPropietario(prop);
				inq.setNombre(rs.getString("inq.nombre"));
                                inq.setApellido(rs.getString("inq.apellido"));
				
				gara.setNombre(rs.getString("gara.nombre"));
                                gara.setApellido(rs.getString("gara.apellido"));
				
				gara2.setNombre(rs.getString("gara2.nombre"));
                                gara2.setApellido(rs.getString("gara2.apellido"));
				
				contrato.setIdContrato(Integer.parseInt(rs.getString("contrato.idContrato")));
				contrato.setFechaInicio(rs.getString("contrato.fechaComienzo"));
				contrato.setFechaVencimiento(rs.getString("contrato.fechaVencimiento"));
				contrato.setEstado(rs.getString("contrato.estado"));
				contrato.setCuotaActual(Integer.parseInt(rs.getString("contrato.cuotaActual")));
				
                contrato.setInmueble(inmu);			
                contrato.setInquilino(inq);
                contrato.setGarante1(gara);
                contrato.setGarante2(gara2);
                
                listaA.add(contrato);
                
                
			   
		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
		
	}
		
		return listaA;
	}
	
	public static ArrayList<Contrato> consultaPorEstado(String estado){
		ArrayList<Contrato> listaA=new ArrayList<Contrato>();
		Contrato contrato=null;
		Inmueble inmu=null;
		Cliente prop=null;
		Cliente inq=null;
		Cliente gara=null;
		Cliente gara2=null;
		
		ResultSet rs=null;
                   String sql="SELECT contrato.idContrato,inmueble.idInmueble,inmueble.calle,contrato.fechaComienzo,contrato.fechaVencimiento,contrato.estado,contrato.cuotaActual,"
                        + " prop.apellido,prop.nombre,inq.apellido,inq.nombre,gara.apellido,gara.nombre,gara2.nombre,gara2.apellido"
                        + " FROM contrato,cliente as prop,cliente as inq,cliente as gara,cliente as gara2,inmueble "
                        + "WHERE contrato.estado like ? AND inmueble.idPropietario=prop.idCliente and contrato.idInquilino=inq.idCliente and contrato.idGarante=gara.idCliente and "
                        + "contrato.idGarante2=gara2.idCliente and contrato.idInmueble=inmueble.idInmueble";

	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
                        pst.setString(1, estado);
			rs=pst.executeQuery();

			while(rs.next()){
				
				contrato=new Contrato();
				inmu=new Inmueble();
				prop=new Cliente();
				inq=new Cliente();
				gara=new Cliente();
				gara2=new Cliente();
                                
                                inmu.setId(rs.getInt("inmueble.idInmueble"));
				inmu.setCalle(rs.getString("inmueble.calle"));
				
				prop.setNombre(rs.getString("prop.nombre"));
                                prop.setApellido(rs.getString("prop.apellido"));
				inmu.setPropietario(prop);
				inq.setNombre(rs.getString("inq.nombre"));
                                inq.setApellido(rs.getString("inq.apellido"));
				
				gara.setNombre(rs.getString("gara.nombre"));
                                gara.setApellido(rs.getString("gara.apellido"));
                                
                                gara2.setNombre(rs.getString("gara2.nombre"));
                                gara2.setApellido(rs.getString("gara2.apellido"));
				
				
				
				contrato.setIdContrato(Integer.parseInt(rs.getString("contrato.idContrato")));
				contrato.setFechaInicio(rs.getString("contrato.fechaComienzo"));
				contrato.setFechaVencimiento(rs.getString("contrato.fechaVencimiento"));
				contrato.setEstado(rs.getString("contrato.estado"));
				contrato.setCuotaActual(Integer.parseInt(rs.getString("contrato.cuotaActual")));
				
                contrato.setInmueble(inmu);			
                contrato.setInquilino(inq);
                contrato.setGarante1(gara);
                contrato.setGarante2(gara2);
                
                listaA.add(contrato);
                
                
			   
		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
		
	}
		
		return listaA;
	}

	//Lista para elegir el inmueble del contrato y trae propietario tb

	public static ArrayList<Inmueble> consultaInmuebleContrato(){
		ArrayList<Inmueble> listaA=new ArrayList<Inmueble>();
		Inmueble inm=null;
		Cliente propietario=null;
		String tipo="Propietario";
		
		ResultSet rs=null;
       String sql="SELECT inmueble.calle,inmueble.piso,inmueble.dpto,cliente.apellido,cliente.nombre ,inmueble.estado,"
       		+ "inmueble.localidad,inmueble.idInmueble,inmueble.tipo FROM `inmueble`,cliente "
       		+ "WHERE cliente.tipo like ? AND inmueble.idPropietario=cliente.idCliente";


	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			pst.setString(1, tipo);
			rs=pst.executeQuery();

			while(rs.next()){
			  
			   inm=new Inmueble();
			   propietario=new Cliente();
			   propietario.setApellido(rs.getString("cliente.apellido"));
			   propietario.setNombre(rs.getString("cliente.nombre"));
			   inm.setId(Integer.parseInt(rs.getString("inmueble.idInmueble")));
		       inm.setCalle(rs.getString("inmueble.calle"));
		       inm.setDpto(rs.getString("inmueble.dpto"));
		       inm.setLocalidad(rs.getString("inmueble.localidad"));
		       inm.setPiso(rs.getString("inmueble.piso"));
		       inm.setEstado(rs.getString("inmueble.estado"));
		       inm.setTipo(rs.getString("inmueble.tipo"));
		       inm.setPropietario(propietario);
		       
		       
		       listaA.add(inm);
		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar Inmueble Contrato"+e.toString());
		
	}
		
		return listaA;
	}
      

        public static int consultaIdContrato(){
		int id=0;
		
		
		ResultSet rs=null;
       String sql="SELECT DISTINCT idContrato from contrato ORDER BY idContrato DESC LIMIT 1";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			rs=pst.executeQuery();

			while(rs.next()){
			   id=(Integer.parseInt(rs.getString("idContrato")));
			     
						}
						
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
					
				}
					
					return id;
				}
        
   public int altaContrato(Contrato cont) throws IOException{
		int r=0;
		String SQL="INSERT INTO `contrato`(`idContrato`, `idInmueble`, `idInquilino`, `idGarante`, `idGarante2`, `fechaComienzo`, `fechaVencimiento`, `cuota`,"
                        + " `cuotaActual`, `estado`, `garantia`, `cuotasGarantia`, `punitorios`, `comicion`, `diadePago`)"
                        + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
		
		
		//
		try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);
		
		pst.setInt(1,cont.getIdContrato());
                pst.setInt(2, cont.getInmueble().getId());
                pst.setInt(3, cont.getInquilino().getId());
                pst.setInt(4, cont.getGarante1().getId());
                pst.setInt(5, cont.getGarante2().getId());
                pst.setString(6,cont.getFechaInicio());
                pst.setString(7, cont.getFechaVencimiento());
                pst.setInt(8, cont.getTotalCuotas());
                pst.setInt(9, cont.getCuotaActual());
                pst.setString(10, cont.getEstado());
                pst.setDouble(11, cont.getGarantia());
                pst.setInt(12, cont.getCuotasGarantia());
                pst.setDouble(13, cont.getPunitorios());                             
                pst.setDouble(14, cont.getHonorarios());               
                pst.setInt(15, cont.getDiaPago());
                
		r=pst.executeUpdate();

                
		}
                
                
		catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al Agregar el Contrato"+e.toString()+" "+e.getLocalizedMessage()+" "+e.getMessage());
                }

		
		return r;
	}
        

        public static Inmueble consultaInmuebleDetalle(int id){
            
            
            Inmueble inm=null;
            ResultSet rs=null;
            
            String sql="SELECT * FROM inmueble WHERE inmueble.idInmueble=?";
            
            try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
                        pst.setInt(1, id);
                        rs=pst.executeQuery();
                        while(rs.next()){
                            inm=new Inmueble();
                            
                            inm.setId(id);
                            inm.setCalle(rs.getString("calle"));
                            inm.setPiso(rs.getString("inmueble.piso"));
                            inm.setDpto(rs.getString("inmueble.dpto"));
                            inm.setFechaInscripcion(rs.getString("inmueble.fechaInscripcion"));
                            inm.setFolio(rs.getString("inmueble.folio"));
                            inm.setFolioReal(rs.getInt("inmueble.folioReal"));
                            inm.setLocalidad(rs.getString("inmueble.localidad"));
                            inm.setTipo(rs.getString("inmueble.tipo"));
                            inm.setTomo(rs.getInt("inmueble.tomo"));

                       
                            
                        }
                        
                     } catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar InmDetalle"+e.toString());
		
	}   
            return inm;
        }
        
        public static int idInm(int idCon){
            int idInm = 0;
            ResultSet rs=null;
            String sql="SELECT inmueble.idInmueble FROM inmueble inner join contrato on contrato.idInmueble=inmueble.idInmueble where contrato.idContrato=?";
            try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
                        pst.setInt(1, idCon);
                        rs=pst.executeQuery();
                        while(rs.next()){
                            idInm=Integer.parseInt(rs.getString("inmueble.idInmueble"));
                            
                        }
                        
                     } catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar idInm"+e.toString());
		
	}  
            return idInm;
        }
            
        public static ArrayList<Contrato> consultaTablaBusquedaContrato(String datos){
		ArrayList<Contrato> listaA=new ArrayList<Contrato>();
                
                String c="%"+datos+"%";
		Inmueble inm=null;
		Cliente prop=null;
                Cliente inq=null;
                Cliente gara1=null;
                Cliente gara2=null;
		Contrato con=null;
		
		ResultSet rs=null;
       String sql= "SELECT contrato.idContrato,contrato.fechaComienzo,contrato.fechaVencimiento,contrato.estado,contrato.cuotaActual,inmueble.calle,inmueble.piso,inmueble.dpto,prop.nombre,"
               + "prop.apellido,inq.nombre,inq.apellido,gara1.nombre,gara1.apellido,gara2.nombre,gara2.apellido "
               + "from inmueble inner join contrato on contrato.idInmueble=inmueble.idInmueble "
               + "inner join cliente as prop on inmueble.idPropietario=prop.idCliente"
               + " inner join cliente as inq on contrato.idInquilino=inq.idCliente inner join cliente as gara1 on contrato.idGarante=gara1.idCliente "
               + "inner join cliente as gara2 on contrato.idGarante2=gara2.idCliente where inmueble.calle"
               + " LIKE ? or inq.nombre like ? or inq.apellido like ? or prop.nombre like ? or prop.apellido like ?";

	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
                        pst.setString(1, c);
                        pst.setString(2, c);
                        pst.setString(3, c);
                        pst.setString(4, c);
                        pst.setString(5, c);
			rs=pst.executeQuery();

			while(rs.next()){
			   inm=new Inmueble();
			   prop=new Cliente();
                           con= new Contrato();
                           inq=new Cliente();
                           gara1= new Cliente();
                           gara2= new Cliente();
                           con.setIdContrato(Integer.parseInt(rs.getString("contrato.idContrato")));
                           con.setFechaInicio(rs.getString("contrato.fechaComienzo"));
                           con.setFechaVencimiento(rs.getString("contrato.fechaVencimiento"));
                           con.setEstado(rs.getString("contrato.estado"));
                           con.setCuotaActual(Integer.parseInt(rs.getString("contrato.cuotaActual")));
			   prop.setApellido(rs.getString("prop.apellido"));
			   prop.setNombre(rs.getString("prop.nombre"));
                           inq.setApellido(rs.getString("inq.apellido"));
			   inq.setNombre(rs.getString("inq.nombre"));
                           gara1.setApellido(rs.getString("gara1.apellido"));
			   gara1.setNombre(rs.getString("gara1.nombre"));
                           gara2.setApellido(rs.getString("gara2.apellido"));
			   gara2.setNombre(rs.getString("gara2.nombre"));
                        
		       inm.setCalle(rs.getString("inmueble.calle"));
		       inm.setDpto(rs.getString("inmueble.dpto"));
		       inm.setPiso(rs.getString("inmueble.piso"));
		     
                       inm.setPropietario(prop);
		     
                       
                       con.setInquilino(inq);
                       con.setInmueble(inm);
                       con.setGarante1(gara1);
                       con.setGarante2(gara2);
                           listaA.add(con);
                       
                          
                       
		       
		       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
		
	}
		
		return listaA;
	}
        
     
        public int AltaCuotas(Cuotas contC){
		int r=0;
		String SQL="INSERT INTO `contratocuota`(`idContrato`, `nroCuota`, `totalImpuestos`, `valorCuota`, `montoTotal`, `punitorios`, `comicion`,"
                        + " `valorGarantia`, `totalPagado`, `descuento`) "
                        + "VALUES (?,?,?,?,?,?,?,?,?,?)";

		try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);
		
                pst.setInt(1, contC.getContrato().getIdContrato());
                pst.setInt(2,contC.getNroCuota());
                pst.setDouble(3,contC.getTotalImpuestos());
                pst.setInt(4,contC.getValorCuota());
                pst.setDouble(5,contC.getTotalaPagar());
                pst.setDouble(6, contC.getPunitorios());
                pst.setDouble(7,contC.getComision() );
                pst.setDouble(8, contC.getValorGarantia());
                pst.setDouble(9, contC.getTotalPagado());
                pst.setDouble(10, contC.getDescuento());

          
		r=pst.executeUpdate();
		}                               
		catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al cargar las Cuotas"+e.toString());}

		
		return r;
	}
        
        public static ArrayList<Cuotas> consultarCuotas(int idContrato){
            ArrayList<Cuotas> listaCuotas=new ArrayList<Cuotas>();
            Cuotas contratoCuota=null;
            Contrato contrato=null;
            ResultSet rs=null;
            
            String sql="SELECT contratocuota.* FROM `contrato` INNER JOIN contratocuota on contrato.idContrato=contratocuota.idContrato WHERE contrato.idContrato=?";
            
            try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			pst.setInt(1, idContrato);
			rs=pst.executeQuery();

			while(rs.next()){
                          contratoCuota=new Cuotas();
                          contrato=new Contrato();
                          contrato.setIdContrato(Integer.parseInt(rs.getString("idContrato")));

			  contratoCuota.setContrato(contrato);
                          contratoCuota.setNroCuota(Integer.parseInt(rs.getString("nroCuota")));
                          contratoCuota.setTotalImpuestos(Double.parseDouble(rs.getString("totalImpuestos")));
                          contratoCuota.setValorCuota(Integer.parseInt(rs.getString("valorCuota")));
                          contratoCuota.setTotalaPagar(Double.parseDouble(rs.getString("montoTotal")));                        
                          contratoCuota.setTotalPagado(Double.parseDouble(rs.getString("totalPagado")));
                          contratoCuota.setValorGarantia(Float.parseFloat(rs.getString("valorGarantia")));
                          contratoCuota.setDescuento(Double.parseDouble(rs.getString("descuento")));
                          contratoCuota.setPunitorios(Double.parseDouble(rs.getString("punitorios")));
                          
                          
                          
                          listaCuotas.add(contratoCuota);
			}
                        
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar Cuotas"+e.toString());
		
	}
        
        return listaCuotas;
}


        public static Cuotas consultarCuotaLiquidacion(int idContrato, int nroCuota){
            Cuotas cuota=new Cuotas();

            Contrato contrato=null;
            ResultSet rs=null;
            
            String sql="SELECT contratocuota.* FROM `contrato` INNER JOIN contratocuota on contrato.idContrato=contratocuota.idContrato WHERE contrato.idContrato=? and contratocuota.nroCuota=? ";
            
            try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			pst.setInt(1, idContrato);
                        pst.setInt(2, nroCuota);
			rs=pst.executeQuery();

			while(rs.next()){
                          cuota=new Cuotas();
                          contrato=new Contrato();
                          contrato.setIdContrato(Integer.parseInt(rs.getString("idContrato")));

			  cuota.setContrato(contrato);
                          cuota.setNroCuota(Integer.parseInt(rs.getString("nroCuota")));
                          cuota.setTotalImpuestos(Double.parseDouble(rs.getString("totalImpuestos")));
                          cuota.setValorCuota(Integer.parseInt(rs.getString("valorCuota")));
                          cuota.setTotalaPagar(Double.parseDouble(rs.getString("montoTotal")));                        
                          cuota.setTotalPagado(Double.parseDouble(rs.getString("totalPagado")));
                          cuota.setValorGarantia(Double.parseDouble(rs.getString("valorGarantia")));
                          cuota.setDescuento(Double.parseDouble(rs.getString("descuento")));
                          cuota.setPunitorios(Double.parseDouble(rs.getString("punitorios")));
                          cuota.setComision(Double.parseDouble(rs.getString("comicion")));
                          
                          
                          
            
			}
                        
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar la cuota "+e.toString());
		
	}
        
        return cuota;
}
              
        public static int ConsultarCuotaActual(int idContrato){
            int cuotaActual=0;
            ResultSet rs=null;
            
            String sql="SELECT contrato.cuotaActual FROM `contrato` WHERE contrato.idContrato=?";
            
            try{
                PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			pst.setInt(1, idContrato);

			rs=pst.executeQuery();
                        
                        while(rs.next()){
                            cuotaActual=rs.getInt("contrato.cuotaActual");
                        }
            }catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar Cuota Actual"+e.toString());}
            
            return cuotaActual;
        }
        
        public int ActualizarCuotaActual(int cuotaActual, int idContrato){
 
                int r=0;
		String SQL="UPDATE `contrato` SET `cuotaActual`=? where contrato.idContrato=?";

		try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);
                pst.setInt(1, cuotaActual);
                pst.setInt(2, idContrato);
		r=pst.executeUpdate();
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error actualizar Cuota Actual"+e.toString());}
		return r;
                }
        
        public static double totalPagado(int cuotaActual, int idContrato){
            double totalPagado=0;
            ResultSet rs=null;
            
            String sql="SELECT contratocuota.totalPagado FROM `contratocuota` WHERE contratocuota.idContrato=? and contratocuota.nroCuota=?";
            
            try{
                PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			pst.setInt(1, idContrato);
                        pst.setInt(2, cuotaActual);

			rs=pst.executeQuery();
                        
                        while(rs.next()){
                        totalPagado=Double.parseDouble(rs.getString("contratocuota.totalPagado"));
                        }
            }catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar Total Pagado"+e.toString());}
            
            return totalPagado;
        }
        
        public int GenerarLiquidacion(double totalPagado,int cuotaActual, int idContrato){
 
                int r=0;
		String SQL="UPDATE `contratocuota` SET `totalPagado`=? WHERE contratocuota.idContrato=? and contratocuota.nroCuota=?";

		try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);
                
                
                pst.setDouble(1, totalPagado);
                pst.setInt(2, idContrato);
                pst.setInt(3, cuotaActual);
                
		r=pst.executeUpdate();
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error actualizar Liquidacion"+e.toString());}
		return r;
                }
        
        
        //Consultar Datos del contrato para Detalle Contratos
        public static Contrato consultaDatosContrato(int idContrato){
		
		Contrato contrato=null;
		Inmueble inmu=null;
		Cliente prop=null;
		Cliente inq=null;
		Cliente gara=null;
		Cliente gara2=null;
		
		ResultSet rs=null;
                   String sql="SELECT inmueble.calle,inmueble.idPropietario,contrato.*,"
                        + " prop.apellido,prop.nombre,inq.apellido,inq.nombre,gara.apellido,gara.nombre,gara2.nombre,gara2.apellido"
                        + " FROM contrato,cliente as prop,cliente as inq,cliente as gara,cliente as gara2,inmueble "
                        + "WHERE contrato.idContrato=? AND inmueble.idPropietario=prop.idCliente and contrato.idInquilino=inq.idCliente and contrato.idGarante=gara.idCliente and "
                        + "contrato.idGarante2=gara2.idCliente and contrato.idInmueble=inmueble.idInmueble";

	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
                        pst.setInt(1, idContrato);
			rs=pst.executeQuery();

			while(rs.next()){
				
				contrato=new Contrato();
				inmu=new Inmueble();
				prop=new Cliente();
				inq=new Cliente();
				gara=new Cliente();
				gara2=new Cliente();
                                
                                inmu.setId(Integer.parseInt(rs.getString("contrato.idInmueble")));
				inmu.setCalle(rs.getString("inmueble.calle"));
				
                                prop.setId(Integer.parseInt(rs.getString("inmueble.idPropietario")));
				prop.setNombre(rs.getString("prop.nombre"));
                                prop.setApellido(rs.getString("prop.apellido"));
				inmu.setPropietario(prop);
                                
                                inq.setId(Integer.parseInt(rs.getString("contrato.idInquilino")));
				inq.setNombre(rs.getString("inq.nombre"));
                                inq.setApellido(rs.getString("inq.apellido"));
				
                                gara.setId(Integer.parseInt(rs.getString("contrato.idGarante")));
				gara.setNombre(rs.getString("gara.nombre"));
                                gara.setApellido(rs.getString("gara.apellido"));
                                
                                gara2.setId(Integer.parseInt(rs.getString("contrato.idGarante2")));
                                gara2.setNombre(rs.getString("gara2.nombre"));
                                gara2.setApellido(rs.getString("gara2.apellido"));
				
				
				
				contrato.setIdContrato(Integer.parseInt(rs.getString("contrato.idContrato")));
				contrato.setFechaInicio(rs.getString("contrato.fechaComienzo"));
				contrato.setFechaVencimiento(rs.getString("contrato.fechaVencimiento"));
				contrato.setEstado(rs.getString("contrato.estado"));
				contrato.setCuotaActual(Integer.parseInt(rs.getString("contrato.cuotaActual")));
                                contrato.setHonorarios(Double.parseDouble(rs.getString("contrato.comicion")));
                                contrato.setDiaPago(Integer.parseInt(rs.getString("contrato.diadePago")));
                                contrato.setPunitorios(Double.parseDouble(rs.getString("contrato.punitorios")));
                                contrato.setGarantia(Integer.parseInt(rs.getString("contrato.garantia")));
 
                                
                contrato.setInmueble(inmu);			
                contrato.setInquilino(inq);
                contrato.setGarante1(gara);
                contrato.setGarante2(gara2);
	       
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar Datos Contrato"+e.toString());
		
	}
		
		return contrato;
	}
        
         public static String ConsultarClienteEnContrato(int idCliente){
            String bandera="No";
            ResultSet rs=null;
            
            String sql="SELECT DISTINCT contrato.idContrato FROM contrato INNER JOIN inmueble on contrato.idInmueble=inmueble.idInmueble "
                    +"WHERE inmueble.idPropietario=? or contrato.idInquilino=? OR contrato.idGarante=? or contrato.idGarante2=?";
            
            try{
                PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			pst.setInt(1, idCliente);
                        pst.setInt(2, idCliente);
                        pst.setInt(3, idCliente);
                        pst.setInt(4, idCliente);

			rs=pst.executeQuery();
                        
                        while(rs.next()){
                            bandera="Si";
                        }
            }catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error "+e.toString());}
            
            return bandera;
        }
         
          public static int FinalizarContrato(int idContrato,int idInmueble){
		int r=0;
                String estado="Finalizado";
                String estadoInm="Disponible";
		String SQL="UPDATE `contrato` SET estado=? WHERE idContrato=? ";
                String SQL2="UPDATE `inmueble` SET estado=? WHERE idInmueble=? ";

		try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);
                pst.setString(1, estado);
                pst.setInt(2, idContrato);

		r=pst.executeUpdate();
                PreparedStatement pst2=Conexion.getConexionn().prepareStatement(SQL2);
                pst2.setString(1,estadoInm);
                pst2.setInt(2,idInmueble);
                r=pst2.executeUpdate();
		}                               
		catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al Actualizar etado Contrato "+e.toString());}		
		return r;
	}
         
             public  int ActualizarPunitorios(int idContrato,double Punitorios, int nroCuota){
		int r=0;
                
		String SQL="UPDATE `contratocuota` SET punitorios=? WHERE idContrato=? and nroCuota=?";

		try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);
                pst.setDouble(1, Punitorios);
                pst.setInt(2, idContrato);
                pst.setInt(3, nroCuota);

		r=pst.executeUpdate();

		}                               
		catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al Actualizar Punitorios "+e.toString());}		
		return r;
	}
     
        public static int ActualizarTotalaPagar(int idContrato, int nroCuota) throws SQLException{
        
        int r=0;
        double total=0;
        ResultSet rs=null;
        
        String sqlConsultaValor="SELECT `totalImpuestos`, `valorCuota`, `valorGarantia`, `totalPagado`,punitorios, `descuento` FROM `contratocuota` WHERE idContrato=? and nroCuota=?";
        String sqlMontoTotal="UPDATE `contratocuota` SET `montoTotal`=? WHERE idContrato=? and nroCuota=?";
        
        try{
            PreparedStatement pst=Conexion.getConexionn().prepareStatement(sqlConsultaValor);
			pst.setInt(1, idContrato);
                        pst.setInt(2, nroCuota);
			rs=pst.executeQuery();

			while(rs.next()){
                      
                            total=Double.parseDouble(rs.getString("totalImpuestos"))+Integer.parseInt(rs.getString("valorCuota"))+Double.parseDouble(rs.getString("valorGarantia"))
                                    +Double.parseDouble(rs.getString("punitorios"))-Double.parseDouble(rs.getString("totalPagado"))-Double.parseDouble(rs.getString("descuento"));
                        }
                  
            PreparedStatement pst2=Conexion.getConexionn().prepareStatement(sqlMontoTotal);  
            pst2.setDouble(1, total);
            pst2.setInt(2, idContrato);
            pst2.setInt(3, nroCuota);
            r=pst2.executeUpdate();
                        
                        
                        
                        
        }catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al actualizar Total a Pagar"+e.toString());
		
	}
        return r;
    }

        
        
}

 




