/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Nahuel
 */
public class Conexion {
    
    
    
	private static Connection conexionn = null;
	
	
	public static Connection getConexionn() {
	
			if (conexionn == null) {		
				try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
				}	
				 catch (Exception ex){
					 System.out.println("Exception: " + "no se pudo registrar el driver");
					 System.out.println("Error\n" + ex.getMessage());
					 return null;
				 }
				 try{
	                conexionn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sminmobiliaria","root","");	                
			                                                                                        	
				}catch (SQLException ex){
					JOptionPane.showMessageDialog(new JDialog(),ex.getMessage());
					//System.out.println("SQLException: " + ex.getMessage());
					return null;
				}
			}
			
		 return conexionn;		
		
		
	}
}
