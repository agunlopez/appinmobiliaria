package modelos;

import entidades.Inmueble;
import entidades.Movimiento;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import pantallas.ListaInmueble;


public class ModeloTablaCaja extends AbstractTableModel {

    final String[] COLUMN_NAMES = {"Recibo","ID Contrato","Cuota","Fecha","Inmueble","Inquilino","Propietario","Tipo Movimiento","Valor $","Honorarios $"}; //cambiar los titulos
    ArrayList<Movimiento> lista = null;
    //retormanos el numero de elementos del array de datos

    public ModeloTablaCaja(ArrayList lista) {
        super();
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }
    
    @Override
    public int getColumnCount() {
        return 10;//numeros de titulos
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
            
            if(lista.get(fila).getTipoMovimiento().equals("I")){
                tipo="Ingreso";
            }
            if(lista.get(fila).getTipoMovimiento().equals("E")){
                tipo="Egreso";
            }
            
           
            if(lista.get(fila).getHonorarios()==0){
                honorarios=" ";
            }else{
                honorarios=Double.toString(lista.get(fila).getHonorarios());
            }
            Formatter fmt = new Formatter();
             fmt.format("%010d",lista.get(fila).getRecibo() );
            
            switch (columna) {
                
                case 0: return fmt.toString();
                
                case 1: return lista.get(fila).getContrato().getIdContrato();
                
                case 2: return lista.get(fila).getContratoCuota().getNroCuota();
                
                case 3: return lista.get(fila).getFecha();
                
               case 4: return lista.get(fila).getContrato().getInmueble().getCalle()+" "+lista.get(fila).getContrato().getInmueble().getPiso()+" "+lista.get(fila).getContrato().getInmueble().getDpto();
                
                case 5: return lista.get(fila).getContrato().getInquilino().getApellido()+" "+lista.get(fila).getContrato().getInquilino().getNombre();
                
                case 6: return lista.get(fila).getContrato().getInmueble().getPropietario().getApellido()+" "+lista.get(fila).getContrato().getInmueble().getPropietario().getNombre();
                
                case 7: return tipo;
                
                case 8: return lista.get(fila).getValorMovimiento();
                
                case 9: return honorarios;
               
                
                default:
                    return null;
            }
        }
    }
    
  
   private String honorarios;
   private String tipo;

}
