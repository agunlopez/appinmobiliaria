package modelos;

import entidades.Cliente;
import entidades.Contrato;
import entidades.Inmueble;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import pantallas.ListaInmueble;


public class ModeloTablaContratosDelCliente extends AbstractTableModel {

    final String[] COLUMN_NAMES = {"ID","Inmueble","Fecha Vencimiento","Rol en Contrato"}; //cambiar los titulos
    ArrayList<Contrato> lista = null;
    //retormanos el numero de elementos del array de datos

    public ModeloTablaContratosDelCliente(ArrayList lista) {
        super();
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }
    
    @Override
    public int getColumnCount() {
        return 4;//numeros de titulos
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
                case 0: return lista.get(fila).getIdContrato();
			
			case 1: return lista.get(fila).getInmueble().getCalle()+" "+lista.get(fila).getInmueble().getPiso()+" "+lista.get(fila).getInmueble().getDpto();
			
                        case 2: return lista.get(fila).getFechaInicio();
                        
                        case 3: return lista.get(fila).getCliente().getRolContrato();
                        
                        

		
			
			default: return null;
                

                 
            }
        }
    }

}
