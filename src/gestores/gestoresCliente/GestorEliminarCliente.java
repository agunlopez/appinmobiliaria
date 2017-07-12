package gestores.gestoresCliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import conexion.Conexion;
import entidades.Inmueble;
import entidades.Cliente;
import gestores.BusquedaInmueble;
import gestores.gestoresCliente.BusquedaPropietario;
import java.io.IOException;

public class GestorEliminarCliente {

    public static int gestorEliminarCliente(int id) throws IOException{
        int r = 0;
        Cliente prop=BusquedaPropietario.busquedaDatos(id);  
        if (prop == null) {
            return 33;
        } else {
            Object[] opciones = {"Aceptar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(null, "¿En realidad desea eliminar al Cliente  " + prop.getApellido() +" "+prop.getNombre()+ "?", "Mensaje de Confirmacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, opciones, "Cancelar");
            if (eleccion == JOptionPane.YES_OPTION) {
                try{
                    String sql2 = "UPDATE `cliente` SET `habilitado`=0 WHERE  idCliente=?";
                    PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql2);      		
                    pst.setInt(1,prop.getId());
                    r = pst.executeUpdate();                   		
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(new JDialog(),"Error al eliminar al Propietario");
                }  
            } else {
                return 0;
            }
        }
        return r;
    }
          
}
