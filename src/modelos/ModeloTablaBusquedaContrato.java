package modelos;

import entidades.Contrato;
import entidades.Inmueble;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import pantallas.ListaInmueble;


public class ModeloTablaBusquedaContrato extends AbstractTableModel {

    final String[] COLUMN_NAMES = {"Id Contrato","Calle","Piso","Dpto","Inquilino","Propietario"}; //cambiar los titulos
    ArrayList<Contrato> lista = null;
    //retormanos el numero de elementos del array de datos

    public ModeloTablaBusquedaContrato(ArrayList lista) {
        super();
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }
    
    @Override
    public int getColumnCount() {
        return 6;//numeros de titulos
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
                    return lista.get(fila).getInmueble().getPiso();

                }
                case 3: {
                    return lista.get(fila).getInmueble().getDpto();

                }
                case 4: {
                    return lista.get(fila).getInquilino().getApellido()+" "+lista.get(fila).getInquilino().getNombre();

                }
                case 5: {
                    return lista.get(fila).getInmueble().getPropietario().getApellido()+" "+lista.get(fila).getInmueble().getPropietario().getNombre();

                }
          
               
                
                default:
                    return null;
            }
        }
    }

}
