/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import conexion.Conexion;
import entidades.Parametros;
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
public class GestorParametros {
    
    public static ArrayList<Parametros> consultaParametros() throws SQLException{
        ArrayList<Parametros> detallesParametros=new ArrayList<Parametros>();
        Parametros parametros=null;
        ResultSet rs=null;
        String sql="select * from parametrossistema";
        try{
            PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
                parametros=new Parametros();
                parametros.setDiasAlerta(rs.getInt("diasAlerta"));
                parametros.setPorcentajePunitorios(rs.getDouble("purcentajePunitorios"));
                parametros.setProcentajeComision(rs.getDouble("porcentajeComision"));
                
                detallesParametros.add(parametros);
                
            }
            
        }catch (SQLException e) {
             JOptionPane.showMessageDialog(new JDialog(),"Error al consultar los parametros del sistema "+e.toString());		
	}
        
        
        return detallesParametros;
    }
    
    public static int modificarParametros(Parametros parametro){
        int r = 0;
        String sql="UPDATE `parametrosSistema` SET `diasAlerta`=?,`purcentajePunitorios`=?,`porcentajeComision`=?";
        try{
            PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
            pst.setInt(1, parametro.getDiasAlerta());
            pst.setDouble(2, parametro.getPorcentajePunitorios());
            pst.setDouble(3, parametro.getProcentajeComision());
            r=pst.executeUpdate();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(new JDialog(),"Error al modificar los parametros "+e.toString());
        }
        
        
        return r;
    }
}
