package gestores;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import conexion.Conexion;
import entidades.Inmueble;
import java.io.IOException;



public class GestorModificarInmueble {
	
	public int modificarInueble (Inmueble inm) throws IOException{
		int r=0;
		
		String SQL="UPDATE `inmueble` SET `calle`=?,`piso`=?,`dpto`=?,`localidad`=?,"
                        + "`estado`=?,`tipo`=?,`idPropietario`=?,`folio`=?,`folioReal`=?,`tomo`=?,"
                        + "`fechaInscripcion`=?,provincia=? WHERE inmueble.idInmueble=?";
		try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);
		pst.setString(1,inm.getCalle());
		pst.setString(2,inm.getPiso());
		pst.setString(3,inm.getDpto());
		pst.setString(4,inm.getLocalidad());
		pst.setString(5,inm.getEstado());
		pst.setString(6,inm.getTipo());		
		pst.setInt(7,inm.getPropietario().getId());
                pst.setString(8, inm.getFolio());
                pst.setInt(9, inm.getFolioReal());
                pst.setInt(10,inm.getTomo());
                pst.setString(11, inm.getFechaInscripcion());
                pst.setInt(13, inm.getId());
                pst.setString(12,inm.getProvincia());
                

		r=pst.executeUpdate();
                
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al Modificar");}

		return r;
    }
	

        public static  int ModificarEstadoOcupado (int id){
		int r=0;
		String x="Ocupado";
		String SQL="UPDATE `inmueble` SET `estado`=? WHERE inmueble.idInmueble=?";

                
		try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);
		pst.setString(1,x);
		pst.setInt(2,id);
		
		
		r=pst.executeUpdate();
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al Modificar");}

		return r;
    }
	
        public static int ModificarEstadoDisponible (int id){
		int r=0;
		String x="Disponible";
		String SQL="UPDATE `inmueble` SET `estado`=? WHERE inmueble.idInmueble=?";

                
		try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);
		pst.setString(1,x);
		pst.setInt(2,id);
		
		
		r=pst.executeUpdate();
		}
		catch (SQLException e) {
                    JOptionPane.showMessageDialog(new JDialog(),"Error al Modificar "+e.toString());}

		return r;
    }
	
    
         public static int ModificarEstadoInhabilitado (int id){
		int r=0;
                Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(null, "¿En realidad desea eliminar el Inmueble?", "Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE, null, opciones, "Cancelar");
        if (eleccion == JOptionPane.YES_OPTION) {

		String x="Inhabilitado";
		String SQL="UPDATE `inmueble` SET `estado`=? WHERE inmueble.idInmueble=?";

                
		try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);
		pst.setString(1,x);
		pst.setInt(2,id);
		r=pst.executeUpdate();
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(),"Error al Eliminar");}

                }else{
            return 0;
        }
        
        
        
		return r;
    }
        
}
