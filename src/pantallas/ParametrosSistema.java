/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import Excepciones.ExcepcionModificarParametro;
import entidades.Parametros;
import gestores.GestorParametros;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Nahuel
 */
public class ParametrosSistema extends javax.swing.JFrame {

    /**
     * Creates new form ParametrosSistema
     */
    public ParametrosSistema() {
        initComponents();
        setLocationRelativeTo(null);
        this.setResizable(false);
        try {
            ArrayList<Parametros> detallesParametros=GestorParametros.consultaParametros();
            diasAlerta.setText(Integer.toString(detallesParametros.get(0).getDiasAlerta()));
            porcentajePunitorios.setText(Double.toString(detallesParametros.get(0).getPorcentajePunitorios()));
            porcentajeComision.setText(Double.toString(detallesParametros.get(0).getProcentajeComision()));
        } catch (SQLException ex) {
            Logger.getLogger(ParametrosSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        diasAlerta = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        porcentajePunitorios = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        porcentajeComision = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Parametros del Sistema");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Dias Alerta: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Porcentaje Punitorios: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Porcentaje Comision: ");

        jLabel4.setText("Configurar cantidad de dias antes del vencimiento para las alertas");

        jLabel5.setText("Porcentaje predeterminado de punitorios para un \"Nuevo Contrato\"");

        jLabel6.setText("Porcentaje predeterminado de comision para un \"Nuevo Contrato\"");

        diasAlerta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        diasAlerta.setEnabled(false);
        diasAlerta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                diasAlertaKeyTyped(evt);
            }
        });

        porcentajePunitorios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        porcentajePunitorios.setEnabled(false);
        porcentajePunitorios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                porcentajePunitoriosKeyTyped(evt);
            }
        });

        porcentajeComision.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        porcentajeComision.setEnabled(false);
        porcentajeComision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                porcentajeComisionKeyTyped(evt);
            }
        });

        jCheckBox1.setText("Editar");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("%");

        jLabel8.setText("%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(diasAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(porcentajePunitorios, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(porcentajeComision, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addGap(0, 56, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(diasAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(porcentajePunitorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(porcentajeComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jCheckBox1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        if(jCheckBox1.isSelected()){
            jButton1.setText("Guardar");
            diasAlerta.setEnabled(true);
            porcentajePunitorios.setEnabled(true);
            porcentajeComision.setEnabled(true);
        }else{
            jButton1.setText("Aceptar");
            diasAlerta.setEnabled(false);
            porcentajePunitorios.setEnabled(false);
            porcentajeComision.setEnabled(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(jButton1.getText().equals("Aceptar")){
            dispose();
        }else{
            Parametros parametro=new Parametros();
            parametro.setDiasAlerta(Integer.parseInt(diasAlerta.getText()));
            parametro.setPorcentajePunitorios(Double.parseDouble(porcentajePunitorios.getText()));
            parametro.setProcentajeComision(Double.parseDouble(porcentajeComision.getText()));
            
            try {
                ExcepcionModificarParametro.validarDatos(parametro.getDiasAlerta(), porcentajePunitorios.getText(), parametro.getPorcentajePunitorios(), parametro.getProcentajeComision(),porcentajeComision.getText());
                int r=GestorParametros.modificarParametros(parametro);
                if(r==1){
                    JOptionPane.showMessageDialog(new JDialog(),"Guardado");
                    dispose();
                }
            } catch (ExcepcionModificarParametro ex) {
               JOptionPane.showMessageDialog(new JDialog(),ex.getMessage());
            }
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void diasAlertaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_diasAlertaKeyTyped

        char validar=evt.getKeyChar();
        if(Character.isDigit(validar) ){
            
        }else{
            if(validar==KeyEvent.VK_BACK_SPACE){
                
            }else{
                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros");
            }
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_diasAlertaKeyTyped

    private void porcentajePunitoriosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_porcentajePunitoriosKeyTyped

        if(!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar()!='.'){
            evt.consume();
        }
        if(evt.getKeyChar()=='.' && porcentajePunitorios.getText().contains(".")){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_porcentajePunitoriosKeyTyped

    private void porcentajeComisionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_porcentajeComisionKeyTyped

        if(!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar()!='.'){
            evt.consume();
        }
        if(evt.getKeyChar()=='.' && porcentajeComision.getText().contains(".")){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_porcentajeComisionKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ParametrosSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParametrosSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParametrosSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParametrosSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParametrosSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField diasAlerta;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField porcentajeComision;
    private javax.swing.JTextField porcentajePunitorios;
    // End of variables declaration//GEN-END:variables
}