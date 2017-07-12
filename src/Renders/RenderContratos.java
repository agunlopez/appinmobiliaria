/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Renders;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import pantallas.PrincipalAdministrador;

/**
 *
 * @author Nahuel
 */
public class RenderContratos extends DefaultTableCellRenderer {
    
     @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        String f=(String) PrincipalAdministrador.tablaContratos.getValueAt(row, 9);
    
       if (f.equals("Finalizado")) {
           setBackground(Color.decode("#FE4B4B")); 
       }else{
           setBackground(null);
       }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        }

}
