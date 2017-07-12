/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Renders;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import modelos.ModeloDetalleCuotasContrato;
import pantallas.DetallesContrato;
import static pantallas.DetallesContrato.tablaDetalle;
import pantallas.PrincipalAdministrador;

/**
 *
 * @author Nahuel
 */
public class RenderLiquidacion extends DefaultTableCellRenderer {
    
     @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        if(value instanceof JButton){
            JButton btn=(JButton) value;
            return btn;
        }
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
            if(ModeloDetalleCuotasContrato.mesPeriodo<(mesActual)){
                setBackground(Color.decode("#FE4B4B"));
                tablaDetalle.setSelectionForeground(Color.BLACK);                
            }else{
                if(ModeloDetalleCuotasContrato.mesPeriodo==(mesActual)){
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
 
       
         this.setBorder(BorderFactory.createMatteBorder(0,0,3,0,Color.BLACK));
         TableColumnModel columnModel = tablaDetalle.getColumnModel();
         
         columnModel.getColumn(0).setCellRenderer(new RenderBordeAbajoTabla());
         columnModel.getColumn(1).setCellRenderer(new RenderBordeAbajoTabla());
         columnModel.getColumn(2).setCellRenderer(new RenderBordeAbajoTabla());
         columnModel.getColumn(2).setPreferredWidth(85);
         columnModel.getColumn(3).setCellRenderer(new RenderBordeAbajoTabla());
         columnModel.getColumn(4).setCellRenderer(new RenderBordeTabla());
         columnModel.getColumn(5).setCellRenderer(new RenderBordeAbajoTabla());
         columnModel.getColumn(6).setCellRenderer(new RenderBordeTabla());
         columnModel.getColumn(7).setCellRenderer(new RenderBordeAbajoTabla());
         



        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        }
}
