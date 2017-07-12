/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

/**
 *
 * @author Nahuel**/

import conexion.Conexion;
import entidades.Contrato;
import entidades.CuotaImpuesto;
import entidades.Cuotas;
import entidades.DescripcionImpuesto;
import entidades.Impuesto;
import entidades.TitularImpuesto;
import entidades.Inmueble;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class GestoresImpuestos {
    

public int GestorAltaTitular(TitularImpuesto titular){
		int r=0;
		String SQL="INSERT INTO `impuestoasociados`(`idDescripcion`, `idContrato`, `titularImp`)"
                        + " VALUES (?,?,?)";								
		
		try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);

                pst.setInt(1, titular.getDescipcion().getIdDescripcion());
                pst.setInt(2, titular.getContrato().getIdContrato());
                pst.setString(3, titular.getTitular());
		r=pst.executeUpdate();
                
 
		}
                
                
		catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al Cargar Impuestos"+e.toString());}
		
		
		
		
		
		return r;
	}

    public int GestorAltaImpuesto(CuotaImpuesto imp){
		int r=0;
                int rr=0;
		String SQL="INSERT INTO `impuesto`(`idImpuesto`, `idDescripcion`, `valorImp`) VALUES (?,?,?)";
                String sql2="INSERT INTO `cuotaimpuesto`(`idCcontrato`, `nroCuota`, `idImpuesto`) VALUES (?,?,?)";
				
		
		
		
		try{
                    PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);
                    PreparedStatement pst2=Conexion.getConexionn().prepareStatement(sql2);
                    
                pst.setInt(1, imp.getImpuesto().getIdImpuesto());
                pst.setInt(2, imp.getImpuesto().getIdDescripcion());
                pst.setDouble(3, imp.getImpuesto().getValor());
                
                pst2.setInt(1, imp.getCuotas().getContrato().getIdContrato());
                pst2.setInt(2, imp.getCuotas().getNroCuota());
                pst2.setInt(3, imp.getImpuesto().getIdImpuesto());

		r=pst.executeUpdate();
                rr=pst2.executeUpdate();
                
 
		}
                
                
		catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al Cargar Impuestos");}
		
		
		
		
		
		return r;
	}
    
    
    public static ArrayList<CuotaImpuesto> consultaTablaImpuesto(int idContrato,int nroCuota){
     
        ArrayList<CuotaImpuesto> impuestos=new ArrayList<CuotaImpuesto>(); 
        ResultSet rs=null;

        DescripcionImpuesto descrip=null;
        Cuotas cuotas=null;
        CuotaImpuesto cuotaImp=null;
        Impuesto impuesto=null;
        TitularImpuesto titular=null;
        
        String sql="SELECT impuesto.idImpuesto,cuotaimpuesto.nroCuota,descripcionimpuesto.idDescripcion,descripcionimpuesto.descripcion,impuesto.valorImp "
            + "FROM impuesto,descripcionimpuesto,cuotaimpuesto"
            + " WHERE cuotaimpuesto.idCcontrato=? and cuotaimpuesto.nroCuota=? and cuotaimpuesto.idImpuesto=impuesto.idImpuesto and "
                + "impuesto.idDescripcion=descripcionimpuesto.idDescripcion ";
        
     
        try{
            PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			pst.setInt(1, idContrato);
                        pst.setInt(2, nroCuota);
			rs=pst.executeQuery();

			while(rs.next()){
                            
                            descrip=new DescripcionImpuesto();
                            cuotas=new Cuotas();
                            cuotaImp=new CuotaImpuesto();
                            impuesto=new Impuesto();
                            titular=new TitularImpuesto();
                                                     
                            descrip.setIdDescripcion(Integer.parseInt(rs.getString("descripcionimpuesto.idDescripcion")));
                            descrip.setDescripcion(rs.getString("descripcionimpuesto.descripcion"));
                            cuotas.setNroCuota(Integer.parseInt(rs.getString("cuotaimpuesto.nroCuota")));
                            impuesto.setValor(Double.parseDouble(rs.getString("impuesto.valorImp")));
                            impuesto.setIdImpuesto(rs.getInt("impuesto.idImpuesto"));
                            impuesto.setDescripcion(descrip);
                            
                            titular.setTitular(consultaTitularImpuesto(idContrato,descrip.getIdDescripcion()));
                            
                            cuotaImp.setTitular(titular);
                            cuotaImp.setCuotas(cuotas);
                            cuotaImp.setImpuesto(impuesto);
                            
                           
                            impuestos.add(cuotaImp);
                            

                        }
        } catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar Impuestos"+e.toString());
		
	}
     
        return impuestos;
    }
    
    public static String consultaTitularImpuesto(int idContrato, int idDescipcion){
        String titular=" ";
        String sqlTitulares="SELECT contrato.idContrato,descripcionimpuesto.idDescripcion,titularimp "
                + "FROM descripcionimpuesto INNER JOIN impuestoasociados ON descripcionimpuesto.idDescripcion=impuestoasociados.idDescripcion "
                + "INNER JOIN contrato ON impuestoasociados.idContrato=contrato.idContrato"
                + " WHERE contrato.idContrato=? and impuestoasociados.idDescripcion=?";
        ResultSet rs=null;
        try{
            PreparedStatement pst=Conexion.getConexionn().prepareStatement(sqlTitulares);
			pst.setInt(1, idContrato);
                        pst.setInt(2, idDescipcion);
			rs=pst.executeQuery();

			while(rs.next()){
                            titular=rs.getString("titularimp");
        }
        } catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al consultar Impuestos"+e.toString());
		
	}
        return titular;
    }
    
    public static int ActualizarTotalImpuesto(int idContrato, int nroCuota) throws SQLException{
        
        int r=0;
        double total=0;
        ResultSet rs=null;
        
        String sqlConsultaValor="SELECT SUM(impuesto.valorImp) FROM `cuotaimpuesto` INNER JOIN impuesto on cuotaimpuesto.idImpuesto=impuesto.idImpuesto WHERE idCcontrato=? and nroCuota=?";
        String sqlActualizar="UPDATE `contratocuota` SET `totalImpuestos`=? WHERE idContrato=? and nroCuota=?";

        
        try{
            PreparedStatement pst=Conexion.getConexionn().prepareStatement(sqlConsultaValor);
			pst.setInt(1, idContrato);
                        pst.setInt(2, nroCuota);
			rs=pst.executeQuery();

			while(rs.next()){
                            try{
                               total=Double.parseDouble(rs.getString("SUM(impuesto.valorImp)")); 
                            }catch(NullPointerException ex){
                                total=0;
                            }
                            
                        }
                  
            PreparedStatement pst2=Conexion.getConexionn().prepareStatement(sqlActualizar);  
            pst2.setDouble(1, total);
            pst2.setInt(2, idContrato);
            pst2.setInt(3, nroCuota);
            r=pst2.executeUpdate();
                        
                        
                        
                        
        }catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al actualizar Impuestos"+e.toString());
		
	}
        return r;
    }
    
    public int ActualizarDescuento(double descuento,int idContrato, int nroCuota) throws SQLException{
        
        int r=0;
        ResultSet rs=null;
        
        String sqlActualizar="UPDATE `contratocuota` SET `descuento`=? WHERE idContrato=? and nroCuota=?";
          
        try{
                   
            PreparedStatement pst2=Conexion.getConexionn().prepareStatement(sqlActualizar);  
            pst2.setDouble(1, descuento);
            pst2.setInt(2, idContrato);
            pst2.setInt(3, nroCuota);
            r=pst2.executeUpdate();
                        
                                                                       
        }catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al actualizar el Descuento"+e.toString());
		
	}
        return r;
    }
    
    public static String TraerValorDescuento(int idContrato,int nroCuota) throws SQLException{
        
        String descuento="";
        String sql="SELECT descuento FROM `contratocuota` WHERE idContrato=? AND nroCuota=?";
        ResultSet rs=null;
        try{
            PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
            pst.setInt(1, idContrato);
            pst.setInt(2, nroCuota);
            rs=pst.executeQuery();

			while(rs.next()){
                            descuento=rs.getString("descuento");
                        }
            
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(new JDialog(),"Error al consultar Descuento "+e.toString());
		
	}
        return descuento;
    }
    
    public static int EliminarImpuesto(int idImpuesto) throws SQLException{
        
        int r=0;
        ResultSet rs=null;
        
        String sql="DELETE FROM `impuesto` WHERE impuesto.idImpuesto=?" ;
        String sql2="DELETE FROM cuotaimpuesto WHERE cuotaimpuesto.idImpuesto=?";
          
        try{
                   
            PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);  
            pst.setInt(1, idImpuesto);
            r=pst.executeUpdate();
            
            PreparedStatement pst2=Conexion.getConexionn().prepareStatement(sql2);  
            pst2.setInt(1, idImpuesto);
            r=pst2.executeUpdate();
                        
                                                                       
        }catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al eliminar Impuesto"+e.toString());
		
	}
        return r;
    }
    
    
    public static int GestorAltaImpuesto(DescripcionImpuesto impuesto){
		int r=0;
		String SQL="INSERT INTO `descripcionimpuesto`(`idDescripcion`, `descripcion`, `habilitar`) VALUES (?,?,?)";								
		
		try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);

                pst.setInt(1, impuesto.getIdDescripcion());
                pst.setString(2, impuesto.getDescripcion());
                pst.setInt(3, 1);
		r=pst.executeUpdate();                
		}                              
		catch (SQLException e) {
                    JOptionPane.showMessageDialog(new JDialog(),"Error al Cargar Impuesto"+e.toString());}
                return r;
    }
    
    public static int ultimoIdImpuesto(){
        int id=0;
        ResultSet rs=null;
        String sql="SELECT idDescripcion FROM `descripcionimpuesto` ORDER BY `idDescripcion` DESC LIMIT 1";
        try{
            PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
               id=rs.getInt("idDescripcion");
        }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JDialog(),"Error al consultar ID de Impuestos"+e.toString());
		
	}
        return id;
    }
    
    public static int inhabilitarImpuesto(int id){
        int r=0;
        String sql="UPDATE `descripcionimpuesto` SET `habilitar`=? WHERE idDescripcion=?";
        try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);       
        pst.setInt(1, 0);
        pst.setInt(2, id);
        r=pst.executeUpdate();                
        }                              
        catch (SQLException e) {
            JOptionPane.showMessageDialog(new JDialog(),"Error al inhabilitar el Impuesto"+e.toString());}
        return r;
    }
     public static int habilitarImpuesto(int id){
        int r=0;
        String sql="UPDATE `descripcionimpuesto` SET `habilitar`=? WHERE idDescripcion=?";
        try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);       
        pst.setInt(1, 1);
        pst.setInt(2, id);
        r=pst.executeUpdate();                
        }                              
        catch (SQLException e) {
            JOptionPane.showMessageDialog(new JDialog(),"Error al habiliar el  Impuesto"+e.toString());}
        return r;
    }
}
