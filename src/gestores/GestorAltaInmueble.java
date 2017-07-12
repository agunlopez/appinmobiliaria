package gestores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import conexion.Conexion;
import entidades.Inmueble;
import java.io.IOException;


public class GestorAltaInmueble {
	
	
	public int altaInmueble(Inmueble inm) throws IOException{
		int r=0;
		String SQL="INSERT INTO `inmueble`(`idInmueble`, `calle`, `piso`, `dpto`, `localidad`,"
                        + " `estado`, `tipo`, `idPropietario`, `folio`, `folioReal`, `tomo`, `fechaInscripcion`,`provincia`)"
                        + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try{PreparedStatement pst=Conexion.getConexionn().prepareStatement(SQL);
		
		pst.setInt(1, inm.getId());
		pst.setString(2,inm.getCalle());
		pst.setString(3,inm.getPiso());
		pst.setString(4,inm.getDpto());
		pst.setString(5,inm.getLocalidad());
		pst.setString(6,inm.getEstado());
		pst.setString(7, inm.getTipo());
		pst.setInt(8, inm.getPropietario().getId());
                pst.setString(9, inm.getFolio());
                pst.setInt(10, inm.getFolioReal());
                pst.setInt(11, inm.getTomo());
                pst.setString(12, inm.getFechaInscripcion());
                pst.setString(13,inm.getProvincia());
                
		r=pst.executeUpdate();
                

                //modelo.fireTableDataChanged();
		}catch (SQLException e) {
                    JOptionPane.showMessageDialog(new JDialog(),"Error al Agregar el Inmueble"+e.getMessage()+" "+e.toString());
                }
		
		return r;
	}
	
	public static int consultaId(){
		int id=0;
		
		
		ResultSet rs=null;
       String sql="SELECT DISTINCT idInmueble from inmueble ORDER BY idInmueble DESC LIMIT 1";
	try{
			PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
			rs=pst.executeQuery();

			while(rs.next()){
			   id=(Integer.parseInt(rs.getString("idInmueble")));
			     
						}
						
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(new JDialog(),"Error al consultar");
					
				}
					
					return id;
				}

}
