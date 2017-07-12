package modelos;

import entidades.Inmueble;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import pantallas.ListaInmueble;


public class ModeloTablaInmueble extends AbstractTableModel {

    final String[] COLUMN_NAMES = {"Id","Calle","Piso","Dpto","Tipo","Localidad","Propietario","Estado"}; //cambiar los titulos
    ArrayList<Inmueble> lista = null;
    //retormanos el numero de elementos del array de datos

    public ModeloTablaInmueble(ArrayList lista) {
        super();
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }
    
    @Override
    public int getColumnCount() {
        return 8;//numeros de titulos
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
                    return lista.get(fila).getId();
                }
                case 1: {
                    return lista.get(fila).getCalle();
                }
                case 2: {
                    return lista.get(fila).getPiso();
                }
                case 3: {
                    return lista.get(fila).getDpto();
                }
                case 4: {
                    return lista.get(fila).getTipo();
                }
                case 5: {
                    return lista.get(fila).getLocalidad();
                }
                case 6: {
                    return lista.get(fila).getPropietario().getApellido()+" "+lista.get(fila).getPropietario().getNombre();
                }
                case 7: {
                    return lista.get(fila).getEstado();
                }
               
                
                default:
                    return null;
            }
        }
    }

}
