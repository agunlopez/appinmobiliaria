package modelos;

import entidades.Inmueble;
import entidades.Movimiento;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import pantallas.ListaInmueble;


public class ModeloTablaPagoPropietario extends AbstractTableModel {

    final String[] COLUMN_NAMES = {"Recibo","Fecha","Cuota","Pagado","Honorarios"}; //cambiar los titulos
    ArrayList<Movimiento> lista = null;
    //retormanos el numero de elementos del array de datos

    public ModeloTablaPagoPropietario(ArrayList lista) {
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
            

            Formatter fmt = new Formatter();
             fmt.format("%010d",lista.get(fila).getRecibo() );
            
            switch (columna) {
                
                case 0: return fmt.toString();
                
                case 1: return lista.get(fila).getFecha();
                
                case 2: return lista.get(fila).getPropietarioPago().getPeriodo();
                                        
                case 3: return lista.get(fila).getPropietarioPago().getTotal();
                
                case 4: return lista.get(fila).getHonorarios();
               
                
                default:
                    return null;
            }
        }
    }
    


}
