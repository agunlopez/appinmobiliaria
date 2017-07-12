package modelos;

import entidades.Cliente;
import entidades.Contrato;
import entidades.Inmueble;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import pantallas.ListaInmueble;


public class ModeloTablaPropietarioResumen extends AbstractTableModel {

    final String[] COLUMN_NAMES = {"ID","Nombre","Apellido","Apellido Materno","DNI"}; //cambiar los titulos
    ArrayList<Cliente> lista = null;
    //retormanos el numero de elementos del array de datos

    public ModeloTablaPropietarioResumen(ArrayList lista) {
        super();
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }
    
    @Override
    public int getColumnCount() {
        return 5;//numeros de titulos
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
		
			
			default: return null;
                

                 
            }
        }
    }

}
