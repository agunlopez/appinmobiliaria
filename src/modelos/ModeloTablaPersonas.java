package modelos;

import entidades.Cliente;
import entidades.Inmueble;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;



public class ModeloTablaPersonas extends AbstractTableModel {

    final String[] COLUMN_NAMES = {"ID","Nombre","Apellido","Apellido Materno","DNI","Telefono","Celular","E-mail","Direccion","Localidad","Provincia","Fecha Nacimiento","DGI","CUIT","EstadoCivil","Profesion"}; //cambiar los titulos
    ArrayList<Cliente> lista = null;
    //retormanos el numero de elementos del array de datos

    public ModeloTablaPersonas(ArrayList lista) {
        super();
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }
    
    @Override
    public int getColumnCount() {
        return 9;//numeros de titulos
    }

    @Override
    public String getColumnName(int col) {
        return COLUMN_NAMES[col];
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        if (fila > lista.size()) {
            return null;
        } else {
            switch (columna) {
                case 0: return lista.get(fila).getId();
			
			case 1: return lista.get(fila).getNombre();
			
			case 2: return lista.get(fila).getApellido();
			
			case 3: return lista.get(fila).getApellidoMaterno();
			
			case 4: return lista.get(fila).getDni();
			
			case 5:  return lista.get(fila).getTel();
                  	
			case 6: return lista.get(fila).getCelular();
			
			case 7: return lista.get(fila).getCorreo();
			
			case 8: return lista.get(fila).getDireccion();
			
			case 9: return lista.get(fila).getLocalidad();
					
			case 10: return lista.get(fila).getProvincia();
					
			case 11: return lista.get(fila).getFechaNac();
					
			case 12: return lista.get(fila).getDgi();
					
			case 13: return lista.get(fila).getCuit();
					
			case 14: return lista.get(fila).getEstadoCivil();
					
			case 15: return lista.get(fila).getProfesion();
               
                
                default:
                    return null;
            }
        }
    }

}
