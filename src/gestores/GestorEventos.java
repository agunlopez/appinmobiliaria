/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import conexion.Conexion;
import entidades.Eventos;
import entidades.Usuario;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Nahuel
 */
public class GestorEventos {
    
    
    
    public static int AltaEvento(Eventos evento)throws IOException{
        int r=0;
        String sql="INSERT INTO `eventos`(`fecha`, `idUsuario`, `descipcion`, `tipo`) VALUES (?,?,?,?)";
        try{
            PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
            pst.setString(1, evento.getFecha());
            pst.setInt(2, evento.getUsuario().getIdUsuario());
            pst.setString(3, evento.getDescipcion());
            pst.setString(4,evento.getTipo());

            r=pst.executeUpdate();
      
        }catch(SQLException e){
	JOptionPane.showMessageDialog(new JDialog(),"Error al Registrar el evento"+e.toString());}
        return r;
    }
    
     public static String getFechaActual() {
         String fechaHoy="";
        //Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha y hora del sistema
        Calendar fecha = new GregorianCalendar();
        //Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        
        if(mes<10){
            fechaHoy=dia+"/0"+mes+"/"+año+" - "+hora+":"+minuto;
        }else{
           fechaHoy=dia+"/"+mes+"/"+año+" - "+hora+":"+minuto; 
        }
        

        return fechaHoy;
    }
     
     public static ArrayList<Eventos> consultarEventos() throws SQLException{
         ArrayList<Eventos> listaEventos=new ArrayList<Eventos>();
         Eventos evento=null;
         Usuario usuario=null;
         ResultSet rs=null;
         String sql="SELECT eventos.*,usuarios.usuario FROM `eventos` INNER JOIN usuarios on eventos.idUsuario=usuarios.idUsuario";
         
         try{
             PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);		
             rs=pst.executeQuery();
             while(rs.next()){
                 evento=new Eventos();
                 usuario=new Usuario();
                 usuario.setUsuario(rs.getString("usuarios.usuario"));
                 evento.setFecha(rs.getString("eventos.fecha"));
                 evento.setTipo(rs.getString("eventos.tipo"));
                 evento.setDescipcion(rs.getString("eventos.descipcion"));
                 evento.setUsuario(usuario);
                 
                 listaEventos.add(evento);
                 
                 
             }
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(new JDialog(),"Error al consultar los eventos "+e.toString());		
	}
         
         return listaEventos;
     }
}
