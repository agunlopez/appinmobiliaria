/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import conexion.Conexion;
import entidades.DescripcionImpuesto;
import gestores.GestoresImpuestos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nahuel
 */
public class RecuperarImpuesto extends javax.swing.JFrame {

    /**
     * Creates new form AdministrarImpuesto
     */
    public RecuperarImpuesto() {
        initComponents();
        setLocationRelativeTo(null);
        this.setResizable(false);
        completarLista();

        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaImpuestos = new javax.swing.JList<>();
        lblId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Impuestos");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Lista de Impuestos: ");

        listaImpuestos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaImpuestosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaImpuestos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(lblId)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

            dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listaImpuestosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaImpuestosMouseClicked

        if(evt.getClickCount()==2){
            Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(null, "¿En realidad desea recuperar el impuesto "+listaImpuestos.getSelectedValue()+"?", "Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE, null, opciones, "Cancelar");
        if (eleccion == JOptionPane.YES_OPTION) {
            String imp=listaImpuestos.getSelectedValue();
            int r=GestoresImpuestos.habilitarImpuesto(Integer.parseInt(imp.substring(0,(imp.indexOf("-")-1))));
            if(r==1){
                JOptionPane.showMessageDialog(new JDialog(),"Recuperado Correctamente");
                completarLista();
            }

        }else{
            
        }
        }     
        // TODO add your handling code here:
    }//GEN-LAST:event_listaImpuestosMouseClicked

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
            java.util.logging.Logger.getLogger(RecuperarImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecuperarImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecuperarImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecuperarImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecuperarImpuesto().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblId;
    private javax.swing.JList<String> listaImpuestos;
    // End of variables declaration//GEN-END:variables

    
    
    public  ArrayList<DescripcionImpuesto> traerImpuestosInhabilitados(){
        
        ArrayList<DescripcionImpuesto> listaImp=new ArrayList<DescripcionImpuesto>();
        String sql="SELECT * FROM `descripcionimpuesto` ORDER BY `idDescripcion` ASC";
        ResultSet rs=null;
        DescripcionImpuesto descriImp=null;
        try{
            PreparedStatement pst=Conexion.getConexionn().prepareStatement(sql);
            rs=pst.executeQuery();           
            while(rs.next()){
                descriImp=new DescripcionImpuesto();
                descriImp.setDescripcion(rs.getString("descripcion"));
                descriImp.setIdDescripcion(rs.getInt("idDescripcion"));
                if(rs.getInt("habilitar")==0){
                    listaImp.add(descriImp);
                }

            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(new JDialog(),"Error al consultar Impuesto"+e.toString());
        }
        
        return listaImp;
        }
    
    public void completarLista(){
        ArrayList<DescripcionImpuesto> listaImp=traerImpuestosInhabilitados();
        DefaultListModel modeloLista = new DefaultListModel();
        for(int i=0;i<listaImp.size();i++){
            modeloLista.addElement(listaImp.get(i).getIdDescripcion()+" - "+listaImp.get(i).getDescripcion());
        }
        listaImpuestos.setModel(modeloLista);
        
    }
        
}
