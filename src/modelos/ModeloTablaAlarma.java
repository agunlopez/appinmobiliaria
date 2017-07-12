package modelos;

import entidades.Contrato;
import entidades.Inmueble;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import pantallas.ListaInmueble;


public class ModeloTablaAlarma extends AbstractTableModel {

    final String[] COLUMN_NAMES = {"Id Contrato","Calle","Propietario","Inquilino","Fecha Vencimiento"}; //cambiar los titulos
    ArrayList<Contrato> lista = null;
    //retormanos el numero de elementos del array de datos

    public ModeloTablaAlarma(ArrayList lista) {
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
                case 0: {
                    return lista.get(fila).getIdContrato();
                }
                case 1: {
                    return lista.get(fila).getInmueble().getCalle();
                }
                case 2: {
                    return lista.get(fila).getInmueble().getPropietario().getApellido()+" "+lista.get(fila).getInmueble().getPropietario().getNombre();
                }
                case 3: {
                    return lista.get(fila).getInquilino().getApellido()+" "+lista.get(fila).getInquilino().getNombre();
                }               
                case 4: {
                    return lista.get(fila).getFechaVencimiento();
                }                                           
                default:
                    return null;
            }
        }
    }

}
