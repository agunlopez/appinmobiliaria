package modelos;

import entidades.CuotaImpuesto;
import java.util.ArrayList;
import javax.swing.JButton;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import pantallas.ListaInmueble;


public class ModeloTablaImpuesto extends AbstractTableModel {

    JButton btnEliminar=new JButton();
        
    final String[] COLUMN_NAMES = {"ID","Impuesto","Titular","Importe","Eliminar"}; //cambiar los titulos
    ArrayList<CuotaImpuesto> lista = null;
    //retormanos el numero de elementos del array de datos

    public ModeloTablaImpuesto(ArrayList lista) {
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
       
        btnEliminar.setOpaque(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setBorderPainted(false );
        
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cross.png")));
        if (fila > lista.size()) {
            return null;
        } else {
            switch (columna) {
                
              
                case 0:{
                    return lista.get(fila).getImpuesto().getIdImpuesto();
                }                   
                case 1: {
                    return lista.get(fila).getImpuesto().getDescripcion().getDescripcion();
                }
                case 2: {                   
                    return lista.get(fila).getTitular().getTitular();
                }
                case 3: {
                    return lista.get(fila).getImpuesto().getValor();
                }
                case 4:{
                    return btnEliminar;
                }

                                                         
                default:
                    return null;
            }
        }
    }

}
