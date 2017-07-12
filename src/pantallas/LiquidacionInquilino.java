/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;



import Usuarios.InicioSesion;
import conexion.Conexion;
import entidades.Contrato;
import entidades.CuotaImpuesto;
import entidades.Cuotas;
import entidades.Eventos;
import entidades.Movimiento;
import gestores.GestorEventos;
import gestores.GestorMovimientos;
import gestores.GestoresContrato;
import gestores.GestoresImpuestos;
import gestores.fechas;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.ModeloDetalleCuotasContrato;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import static sun.font.GlyphLayout.done;

/**
 *
 * @author Nahuel
 */
public class LiquidacionInquilino extends javax.swing.JFrame {

    JDialog reciboInq= new JDialog(new JFrame(),"Recibo",true);
    
    conexion.Conexion con= new conexion.Conexion();

    public static boolean band=false;
 
    public LiquidacionInquilino() {
        super();
        initComponents();
        this.setResizable(false);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtMontoaPagar = new javax.swing.JTextField();
        lblPeriodo = new javax.swing.JLabel();
        lblPunitorios = new javax.swing.JLabel();
        lblAlquiler = new javax.swing.JLabel();
        lblTotalaPagar = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaImpuestosLiquidacion = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblGarantia = new javax.swing.JLabel();
        lblDescuento = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTotalPagado = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Liquidacion Inquilino");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Periodo: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Alquiler: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Punitorios: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Impuestos: ");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Total a Pagar: ");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Monto a Pagar: ");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Generar Liquidacion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtMontoaPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoaPagarKeyTyped(evt);
            }
        });

        lblPeriodo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblPunitorios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblAlquiler.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblTotalaPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton2.setText("Calcular Punitorios");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tablaImpuestosLiquidacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripcion", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaImpuestosLiquidacion);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Garantia: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Descuento: ");

        lblGarantia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblDescuento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Total Pagado:");

        lblTotalPagado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotalPagado.setText("jLabel8");

        jLabel8.setText("Todos los valores se representan el ($) Peso Argentino");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAlquiler)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblPunitorios)
                                        .addGap(49, 49, 49)
                                        .addComponent(jButton2))
                                    .addComponent(lblPeriodo)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel7))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotalPagado)
                                    .addComponent(lblTotalaPagar)
                                    .addComponent(lblDescuento)
                                    .addComponent(lblGarantia)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(txtMontoaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblPeriodo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblAlquiler))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblPunitorios)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblGarantia))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblDescuento))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblTotalPagado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblTotalaPagar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtMontoaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

  

        cuotaActual=GestoresContrato.ConsultarCuotaActual(Integer.parseInt(DetallesContrato.lblIdContrato.getText()));
        Cuotas cuota=new Cuotas();
        cuota=GestoresContrato.consultarCuotaLiquidacion(Integer.parseInt(DetallesContrato.lblIdContrato.getText()), cuotaActual);
        lblPeriodo.setText((String) DetallesContrato.tablaDetalle.getValueAt((cuotaActual-1), 0));
        lblAlquiler.setText(Integer.toString(cuota.getValorCuota()));
        lblPunitorios.setText(Double.toString(cuota.getPunitorios()));
        lblGarantia.setText(Double.toString(cuota.getValorGarantia()));
        lblDescuento.setText("("+Double.toString(cuota.getDescuento())+")");
        lblTotalPagado.setText(Double.toString(cuota.getTotalPagado()));
       
        lblTotalaPagar.setText(Double.toString(cuota.getTotalaPagar()));
        double txtTotal=cuota.getTotalaPagar();
        txtMontoaPagar.setText(Double.toString(txtTotal));
     


        
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.setCursor(Cursor.WAIT_CURSOR);
        
GenerarLiquidacion();

        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        
       
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        Calendar ahora= Calendar.getInstance();
        int diaActual=ahora.get(Calendar.DATE);
        int mesActual=ahora.get((Calendar.MONTH))+1;
        int añoActual=ahora.get(Calendar.YEAR);
        int mesV = 0;
        String[] meses = {"Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sept","Oct","Nov","Dic"};
        for(int i=0;i<meses.length;i++){
            if(meses[i].equals(lblPeriodo.getText().substring(0,3))){
                mesV=i+1;
            }
        }
        String vencimiento = PrincipalAdministrador.diaPago+"/"+mesV+"/"+lblPeriodo.getText().substring(4,8);
        String actual = diaActual+"/"+mesActual+"/"+añoActual;
 
        int dias;
        try {
            dias = fechas.cantidadDias(vencimiento,actual );
            
            if(dias>0){
                GestoresContrato gestPun=new GestoresContrato();
                if(DetallesContrato.datosContrato.getPunitorios()>1){
                    double punitorio=dias+DetallesContrato.datosContrato.getPunitorios();
                    
                    Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(null, "Desea agregar el total de: "+punitorio+" en concepto de Punitorios?","Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE, null, opciones, "Cancelar");
        if (eleccion == JOptionPane.YES_OPTION) {
            
            int r = gestPun.ActualizarPunitorios(DetallesContrato.datosContrato.getIdContrato(),punitorio, DetallesContrato.datosContrato.getCuotaActual() );                  
                   double total=punitorio+Double.parseDouble(lblTotalaPagar.getText());
                   gestPun.ActualizarTotalaPagar(DetallesContrato.datosContrato.getIdContrato(), DetallesContrato.datosContrato.getCuotaActual());
                   if(r==1){
                       JOptionPane.showMessageDialog(new JDialog(),"Punitorios Actualizados: "+punitorio);
                   }
        }else{
            dispose();
        }
                    
                    
                   
                }else{
                    double punitorio=(Double.parseDouble(lblAlquiler.getText())*DetallesContrato.datosContrato.getPunitorios())*dias;
                    
                    Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(null, "Desea agregar el total de: "+punitorio+" en concepto de Punitorios?","Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE, null, opciones, "Cancelar");
        if (eleccion == JOptionPane.YES_OPTION) {
            
            int r = gestPun.ActualizarPunitorios(DetallesContrato.datosContrato.getIdContrato(),punitorio, DetallesContrato.datosContrato.getCuotaActual() );
                   double total=punitorio+Double.parseDouble(lblTotalaPagar.getText());
                   gestPun.ActualizarTotalaPagar(DetallesContrato.datosContrato.getIdContrato(), DetallesContrato.datosContrato.getCuotaActual());
                   if(r==1){
                       JOptionPane.showMessageDialog(new JDialog(),"Punitorios Actualizados: "+punitorio);
                   }
        }else{
            dispose();
        }
        
        
                   
                }
            }else{
                JOptionPane.showMessageDialog(new JDialog(),"La Cuota no esta Vencida");
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(LiquidacionInquilino.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LiquidacionInquilino.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtMontoaPagarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoaPagarKeyTyped

char validar=evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros");
        }   
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoaPagarKeyTyped

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
            java.util.logging.Logger.getLogger(LiquidacionInquilino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LiquidacionInquilino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LiquidacionInquilino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LiquidacionInquilino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LiquidacionInquilino().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAlquiler;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblGarantia;
    public static javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblPunitorios;
    private javax.swing.JLabel lblTotalPagado;
    private javax.swing.JLabel lblTotalaPagar;
    public static javax.swing.JTable tablaImpuestosLiquidacion;
    private javax.swing.JTextField txtMontoaPagar;
    // End of variables declaration//GEN-END:variables

    
    
    public static int cuotaActual;
    
  
    public void GenerarLiquidacion(){


         if(Double.parseDouble(lblTotalaPagar.getText()) >= Double.parseDouble(txtMontoaPagar.getText())){     

             double pagado=GestoresContrato.totalPagado(cuotaActual, Integer.parseInt(DetallesContrato.lblIdContrato.getText()));
            if(Double.parseDouble(lblTotalaPagar.getText()) == Double.parseDouble(txtMontoaPagar.getText())){               
                double totalPagado=Double.parseDouble(txtMontoaPagar.getText())+pagado;
                GestoresContrato gestorContrato=new GestoresContrato();
                gestorContrato.GenerarLiquidacion(totalPagado, cuotaActual,Integer.parseInt(DetallesContrato.lblIdContrato.getText()));
                int nuevaCuota=cuotaActual+1;
                gestorContrato.ActualizarCuotaActual(nuevaCuota,Integer.parseInt(DetallesContrato.lblIdContrato.getText()));
                
            }else{
                double totalPagado=Double.parseDouble(txtMontoaPagar.getText())+pagado;               
                GestoresContrato gestorContrato=new GestoresContrato();              
                gestorContrato.GenerarLiquidacion(totalPagado, cuotaActual,Integer.parseInt(DetallesContrato.lblIdContrato.getText()));
            }
            
            Movimiento movimiento=new Movimiento();
            Cuotas cuota=new Cuotas();
            Contrato contrato=new Contrato();
            Calendar ahora= Calendar.getInstance();

            int diaActual=ahora.get(Calendar.DATE);
            int mesActual=ahora.get((Calendar.MONTH))+1;
            int añoActual=ahora.get(Calendar.YEAR);
            
            contrato.setIdContrato(Integer.parseInt(DetallesContrato.lblIdContrato.getText()));
            cuota.setNroCuota(cuotaActual);
            
            movimiento.setContrato(contrato);
            movimiento.setContratoCuota(cuota);
            movimiento.setFecha(diaActual+"/"+mesActual+"/"+añoActual);
            movimiento.setTipoMovimiento("I");
            movimiento.setValorMovimiento(Double.parseDouble(txtMontoaPagar.getText()));
            movimiento.setHonorarios(0);
            
            GestorMovimientos gestorIngreso=new GestorMovimientos();
            GestoresContrato gestorContrato=new GestoresContrato();
             try {
                 Eventos evento=new Eventos();            
                 evento.setUsuario(InicioSesion.usuarioEnSesion);
                 evento.setTipo("MOVIMIENTO");
                 evento.setDescipcion("Se registro el cobro de la cuota "+movimiento.getContratoCuota().getNroCuota()+" del contrato "+movimiento.getContrato().getIdContrato()+" por $"+movimiento.getValorMovimiento());
                 evento.setFecha(GestorEventos.getFechaActual());
                 gestorContrato.ActualizarTotalaPagar(Integer.parseInt(DetallesContrato.lblIdContrato.getText()),cuotaActual);
                 gestorIngreso.AltaIngreso(movimiento);
                 int recibo=gestorIngreso.numeroRecibo();
                 int e=GestorEventos.AltaEvento(evento);

                 conexion.ConexionReporte con=new conexion.ConexionReporte();


        try{
            
            Map parametro=new HashMap();
            
            parametro.put("Recibo",recibo); 
            JasperReport reciboInquilino=JasperCompileManager.compileReport("C:\\Users\\Usuario\\Desktop\\Tesis\\SM Inmobiliaria\\src\\Recibos\\reciboInq.jrxml");           
            JasperPrint jasperPrint=JasperFillManager.fillReport(reciboInquilino, parametro, con.conexion());
            
            
            reciboInq.setSize(1000,700);
            reciboInq.setLocationRelativeTo(null);
            JRViewer jrv=new JRViewer(jasperPrint);
            reciboInq.getContentPane().add(jrv);
            reciboInq.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(PrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
             } catch (IOException ex) {
                 Logger.getLogger(LiquidacionInquilino.class.getName()).log(Level.SEVERE, null, ex);
             } catch (SQLException ex) {
                 Logger.getLogger(LiquidacionInquilino.class.getName()).log(Level.SEVERE, null, ex);
             }
            
            
            dispose();
            
            }else{
            JOptionPane.showMessageDialog(new JDialog(),"El monto a pagar no puede ser mayor al total");
            
        }
        
    }
}
