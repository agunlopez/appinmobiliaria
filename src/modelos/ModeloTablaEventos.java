package modelos;


import entidades.Eventos;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.table.AbstractTableModel;




public class ModeloTablaEventos extends AbstractTableModel {

    final String[] COLUMN_NAMES = {"Fecha","Usuario","Descipcion","Tipo"}; //cambiar los titulos
    ArrayList<Eventos> lista = null;
    //retormanos el numero de elementos del array de datos

    public ModeloTablaEventos(ArrayList lista) {
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
                
                case 0: return lista.get(fila).getFecha();
                
                case 1: return lista.get(fila).getUsuario().getUsuario();
                
                case 2: return lista.get(fila).getDescipcion();
                
                case 3: return lista.get(fila).getTipo();
            
                default:
                    return null;
            }
        }
    }

}
