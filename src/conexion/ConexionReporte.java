/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nahuel
 */
public class ConexionReporte {
    
    private Connection con = null;
    
    public Connection conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sminmobiliaria","root","");
            
        }catch(ClassNotFoundException | SQLException e){
            
            
        }
        
        return con;
    }
    
}
