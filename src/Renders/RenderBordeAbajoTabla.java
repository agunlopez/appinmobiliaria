/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Renders;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.image.ColorModel;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import modelos.ModeloDetalleCuotasContrato;
import static pantallas.DetallesContrato.tablaDetalle;
import pantallas.PrincipalAdministrador;

/**
 *
 * @author Nahuel
 */
public class RenderBordeAbajoTabla extends DefaultTableCellRenderer {
    
    
   
    public Component getTableCellRendererComponent(JTable table,
      Object value,
      boolean isSelected,
      boolean hasFocus,
      int row,
      int column)
   {
      super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
      double x=(double) tablaDetalle.getValueAt(row, 4);
        
      if (x*1 == 0) {
           setBackground(Color.decode("#97F771")); 
           tablaDetalle.setSelectionForeground(Color.BLACK);

      }else {
          Calendar ahora= Calendar.getInstance();

        int diaActual=ahora.get(Calendar.DATE);
        int mesActual=ahora.get((Calendar.MONTH));
        int añoActual=ahora.get(Calendar.YEAR);
        

   
   
            if(ModeloDetalleCuotasContrato.añoPeriodo <añoActual){
            setBackground(Color.decode("#FE4B4B"));
            tablaDetalle.setSelectionForeground(Color.BLACK);           
        }else{
            if(ModeloDetalleCuotasContrato.mesPeriodo<(mesActual) && ModeloDetalleCuotasContrato.añoPeriodo <=añoActual){
                setBackground(Color.decode("#FE4B4B"));
                tablaDetalle.setSelectionForeground(Color.BLACK);                
            }else{
                if(ModeloDetalleCuotasContrato.mesPeriodo==(mesActual) && ModeloDetalleCuotasContrato.añoPeriodo <=añoActual){
                if(diaActual>=PrincipalAdministrador.diaPago){
                    setBackground(Color.decode("#FE4B4B"));
                        tablaDetalle.setSelectionForeground(Color.BLACK);
                }else{
                    setBackground(Color.white);  
                    tablaDetalle.setSelectionForeground(Color.BLACK);
                }
            }else{
                 setBackground(Color.white);  
                    tablaDetalle.setSelectionForeground(Color.BLACK);   
                }
        }
        }
      }

         this.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK));

      return this;
   }
}
