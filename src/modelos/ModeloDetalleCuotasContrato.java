/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import entidades.Cuotas;
import entidades.TitularImpuesto;
import gestores.GestoresContrato;
import java.awt.Font;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;

import static pantallas.DetallesContrato.tablaDetalle;
import pantallas.PrincipalAdministrador;

/**
 *
 * @author Nahuel
 */
public class ModeloDetalleCuotasContrato extends AbstractTableModel{
  
    ArrayList<Cuotas> lista = null;
    Font negrita = new Font("Arial", Font.BOLD, 14);
    public static JButton btnAgregar= new JButton("Agregar");
    public static JButton btnDescuento= new JButton("Descuento");
    


    final String[] COLUMN_NAMES = {"Periodo","Precio Alquiler $","Total Impuestos $","Punitorios $","Total a Pagar $","Total Pagado $","Descuento $","Garantia $","Impuesto","Descuento"}; //cambiar los titulos
    //retormanos el numero de elementos del array de datos

    public ModeloDetalleCuotasContrato(ArrayList lista) {
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
    @SuppressWarnings("empty-statement")
    public Object getValueAt(int fila, int columna) {
        btnAgregar.setFont(negrita);
        btnDescuento.setFont(negrita);
        btnAgregar.setName("a");
        btnDescuento.setName("d");
        
        if (fila > lista.size()) {
            return null;
        } else {
            
        try {
            Calendar cal = Calendar.getInstance();
            DateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yy");
            Date inicio=formatoDelTexto.parse(PrincipalAdministrador.inicioCon);  
            cal.setTime(inicio); 
            cal.add(Calendar.MONTH, lista.get(fila).getNroCuota());
            mesPeriodo=cal.get(Calendar.MONTH);
            añoPeriodo=cal.get(Calendar.YEAR)-1;        
        } catch (ParseException ex) {
            Logger.getLogger(ModeloDetalleCuotasContrato.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        btnAgregar.setOpaque(false);
        btnAgregar.setBorderPainted(false );
        btnAgregar.setBackground(java.awt.Color.decode("#B7B7B7"));
        
        btnDescuento.setOpaque(false);
        btnDescuento.setBorderPainted(false );
        btnDescuento.setBackground(java.awt.Color.decode("#B7B7B7"));
       
            switch (columna) {
                case 0: return meses[mesPeriodo]+" "+añoPeriodo;
			
			case 1: return lista.get(fila).getValorCuota();
			
                        case 2: return lista.get(fila).getTotalImpuestos();
                        
                        case 3: return lista.get(fila).getPunitorios();
			
			case 4: return lista.get(fila).getTotalaPagar();
                        
                        case 5: return lista.get(fila).getTotalPagado(); 
                        
                        case 6: return lista.get(fila).getDescuento();
                        
                        case 7: return lista.get(fila).getValorGarantia();                        
  
                        case 8: return btnAgregar;
                        
                        case 9: return btnDescuento;
               
                
                default:
                    return null;
            }
        }
    }
    

    public static Date nuevafecha;
    public static int mesPeriodo;
    public static int añoPeriodo;
    public static String[] meses = {"Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sept","Oct","Nov","Dic"};
    private double garantia=1;
}
