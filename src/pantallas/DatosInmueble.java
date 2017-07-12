/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import pantallas.pantallasClientes.ListaPropietariosModificar;
import Imagenes.CopiarImagenes;
import Imagenes.Galeria;
import Usuarios.InicioSesion;
import static Usuarios.RecuperarUsuario.usuarioRecuperar;
import entidades.Cliente;
import entidades.Eventos;
import entidades.Inmueble;
import gestores.GestorAltaInmueble;
import gestores.GestorEventos;
import gestores.GestorModificarInmueble;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.lang.String;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Nahuel
 */

public class DatosInmueble extends javax.swing.JFrame {

   private JPanel contentPane;
   
    Galeria Mi_Galeria = new Galeria();
    private int a = 0;
    private int b = 1;
    private int c = 2;
    private int d = 3;
    private int e = 4;
    private int f = 5;
    private int g = 6;
    private int h = 7;
    
    
    
    /**
     * Creates new form AltaInmueble
     */
    public DatosInmueble() {
        initComponents();
       this.setResizable(false);
        
        //se elimina el texto
        lblFoto1.setText("");lblFoto2.setText("");lblFoto3.setText("");lblFoto4.setText("");lblfoto5.setText("");lblfoto6.setText("");lblfoto7.setText("");lblfoto8.setText("");lblFotoGrande.setText("");
        //se inici la vista previa
        lblFoto1.setIcon(Mi_Galeria.getPreview(0));
        lblFoto2.setIcon(Mi_Galeria.getPreview(1));
        lblFoto3.setIcon(Mi_Galeria.getPreview(2));
        lblFoto4.setIcon(Mi_Galeria.getPreview(3));
        lblfoto5.setIcon(Mi_Galeria.getPreview(4));
        lblfoto6.setIcon(Mi_Galeria.getPreview(5));
        lblfoto7.setIcon(Mi_Galeria.getPreview(6));
        lblfoto8.setIcon(Mi_Galeria.getPreview(7));

                        

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        propietario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        calle = new javax.swing.JTextField();
        piso = new javax.swing.JTextField();
        dpto = new javax.swing.JTextField();
        ciudad = new javax.swing.JTextField();
        provincia = new javax.swing.JTextField();
        nroFolio = new javax.swing.JTextField();
        tipo = new javax.swing.JTextField();
        estado = new javax.swing.JTextField();
        folio = new javax.swing.JTextField();
        tomo = new javax.swing.JTextField();
        fechaInscripcion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        etiquetaId = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnEliminarInmueble = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Foto1 = new javax.swing.JPanel();
        lblFoto1 = new javax.swing.JLabel();
        Foto2 = new javax.swing.JPanel();
        lblFoto2 = new javax.swing.JLabel();
        Foto3 = new javax.swing.JPanel();
        lblFoto3 = new javax.swing.JLabel();
        Foto4 = new javax.swing.JPanel();
        lblFoto4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblfoto5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblfoto6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblfoto7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lblfoto8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblFotoGrande = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Datos del Inmueble");
        setLocation(new java.awt.Point(650, 150));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Propietario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setText("Propietario: ");
        jLabel1.setPreferredSize(new java.awt.Dimension(60, 25));

        propietario.setEditable(false);
        propietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propietarioActionPerformed(evt);
            }
        });

        jButton1.setText("Cambiar");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(propietario, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addContainerGap(624, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(propietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Inmueble", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel2.setText("Direccion:");
        jLabel2.setPreferredSize(new java.awt.Dimension(30, 20));

        jLabel4.setText("Piso: ");

        jLabel5.setText("Dpto: ");

        jLabel6.setText("Ciudad: ");

        jLabel7.setText("Provincia: ");

        jLabel8.setText("Tipo: ");

        jLabel9.setText("Estado: ");

        jLabel10.setText("Folio: ");

        jLabel11.setText("Numero:");

        jLabel12.setText("Tomo: ");

        jLabel13.setText("Fecha:");

        calle.setEditable(false);

        piso.setEditable(false);
        piso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pisoActionPerformed(evt);
            }
        });

        dpto.setEditable(false);

        ciudad.setEditable(false);

        provincia.setEditable(false);

        nroFolio.setEditable(false);

        tipo.setEditable(false);

        estado.setEditable(false);
        estado.setText("Disponible");
        estado.setToolTipText("");

        folio.setEditable(false);

        tomo.setEditable(false);

        fechaInscripcion.setEditable(false);

        jLabel14.setText("ID: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel14))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(jLabel13)
                .addGap(28, 28, 28)
                .addComponent(fechaInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calle, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(34, 34, 34)
                        .addComponent(piso))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(30, 30, 30)
                        .addComponent(dpto))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addComponent(provincia))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(20, 20, 20)
                        .addComponent(ciudad)))
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(19, 19, 19)
                        .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(30, 30, 30)
                        .addComponent(folio, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(nroFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(26, 26, 26)
                        .addComponent(tomo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(32, 32, 32)
                        .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel9))
                            .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(folio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel10)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nroFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel11)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tomo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel12)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel13))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(piso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(dpto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(provincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel7))))))
        );

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnEliminarInmueble.setText("Eliminar");
        btnEliminarInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarInmuebleActionPerformed(evt);
            }
        });

        jButton7.setText("Agregar Imagenes");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Editar");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnEliminarInmueble)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addGap(56, 56, 56)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(btnEliminarInmueble)
                    .addComponent(jButton7)
                    .addComponent(jCheckBox1))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Datos", jPanel3);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setText(">");
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setText("<");
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        Foto1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblFoto1.setText("jLabel15");
        lblFoto1.setToolTipText("");
        lblFoto1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFoto1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Foto1Layout = new javax.swing.GroupLayout(Foto1);
        Foto1.setLayout(Foto1Layout);
        Foto1Layout.setHorizontalGroup(
            Foto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        Foto1Layout.setVerticalGroup(
            Foto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        Foto2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblFoto2.setText("jLabel15");
        lblFoto2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFoto2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Foto2Layout = new javax.swing.GroupLayout(Foto2);
        Foto2.setLayout(Foto2Layout);
        Foto2Layout.setHorizontalGroup(
            Foto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        Foto2Layout.setVerticalGroup(
            Foto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        Foto3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblFoto3.setText("jLabel15");
        lblFoto3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFoto3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Foto3Layout = new javax.swing.GroupLayout(Foto3);
        Foto3.setLayout(Foto3Layout);
        Foto3Layout.setHorizontalGroup(
            Foto3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        Foto3Layout.setVerticalGroup(
            Foto3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        Foto4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblFoto4.setText("jLabel15");
        lblFoto4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFoto4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Foto4Layout = new javax.swing.GroupLayout(Foto4);
        Foto4.setLayout(Foto4Layout);
        Foto4Layout.setHorizontalGroup(
            Foto4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        Foto4Layout.setVerticalGroup(
            Foto4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblfoto5.setText("jLabel15");
        lblfoto5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblfoto5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblfoto5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblfoto5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblfoto6.setText("jLabel15");
        lblfoto6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblfoto6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblfoto6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblfoto6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblfoto7.setText("jLabel15");
        lblfoto7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblfoto7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblfoto7, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblfoto7, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblfoto8.setText("jLabel15");
        lblfoto8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblfoto8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblfoto8, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblfoto8, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(Foto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(Foto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(Foto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Foto4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jButton6)
                    .addContainerGap(513, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Foto1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Foto2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Foto3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Foto4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        lblFotoGrande.setText("jLabel15");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFotoGrande, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lblFotoGrande, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1025, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Imagenes", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        ListaPropietariosModificar listaP=new ListaPropietariosModificar();
                       listaP.setLocationRelativeTo(null);

				listaP.setVisible(true);
				
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed


        if(jCheckBox1.isSelected()){          
            Inmueble inm=new Inmueble();
            Cliente prop=new Cliente();
            Cliente prop2=new Cliente();
            String id=propietario.getText();
                  
            prop.setId(Integer.parseInt(id.substring(0,(id.indexOf("-")-1))));
            inm.setId(Integer.parseInt(etiquetaId.getText()));
            inm.setCalle(calle.getText());
            inm.setDpto(dpto.getText());
            inm.setLocalidad(ciudad.getText());
            inm.setPiso(piso.getText());
            inm.setEstado(estado.getText());                      
            inm.setTipo(tipo.getText());
            inm.setFechaInscripcion(fechaInscripcion.getText());
            inm.setFolio((folio.getText()));
            inm.setFolioReal(Integer.parseInt(nroFolio.getText()));
            inm.setTomo(Integer.parseInt(tomo.getText()));
            inm.setProvincia(provincia.getText());
            inm.setPropietario(prop);
                        
            GestorModificarInmueble gestinm=new GestorModificarInmueble();
            try {
                gestinm.modificarInueble(inm);
            } catch (IOException ex) {
                Logger.getLogger(DatosInmueble.class.getName()).log(Level.SEVERE, null, ex);
            }
            Eventos evento=new Eventos();            
            evento.setUsuario(InicioSesion.usuarioEnSesion);
            evento.setTipo("INMUEBLE");
            evento.setDescipcion("Se agrego el Inmueble "+inm.getCalle()+" "+inm.getPiso()+" "+inm.getDpto());
            evento.setFecha(GestorEventos.getFechaActual());
            JOptionPane.showMessageDialog(new JDialog(),"Guardado Correctamente");
            try {
                int e=GestorEventos.AltaEvento(evento);
            } catch (IOException ex) {
                Logger.getLogger(DatosInmueble.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        }else{            
            dispose();
        }                 
			


        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void propietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_propietarioActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

         if(h>=(Galeria.CA-1)){
        }else{
             a+=1;b+=1;c+=1;d+=1;e+=1;f+=1;g+=1;h+=1;
        lblFoto1.setIcon(Mi_Galeria.getPreview(a));
        lblFoto2.setIcon(Mi_Galeria.getPreview(b));
        lblFoto3.setIcon(Mi_Galeria.getPreview(c));
        lblFoto4.setIcon(Mi_Galeria.getPreview(d));
        lblfoto5.setIcon(Mi_Galeria.getPreview(e));
        lblfoto6.setIcon(Mi_Galeria.getPreview(f));
        lblfoto7.setIcon(Mi_Galeria.getPreview(g));
        lblfoto8.setIcon(Mi_Galeria.getPreview(h));
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
  
        if(a==0){        
        }else{
         a-=1;b-=1;c-=1;d-=1;e-=1;f-=1;g-=1;h-=1;
        lblFoto1.setIcon(Mi_Galeria.getPreview(a));
        lblFoto2.setIcon(Mi_Galeria.getPreview(b));
        lblFoto3.setIcon(Mi_Galeria.getPreview(c));
        lblFoto4.setIcon(Mi_Galeria.getPreview(d));
        lblfoto5.setIcon(Mi_Galeria.getPreview(e));
        lblfoto6.setIcon(Mi_Galeria.getPreview(f));
        lblfoto7.setIcon(Mi_Galeria.getPreview(g));
        lblfoto8.setIcon(Mi_Galeria.getPreview(h));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void lblFoto1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFoto1MouseClicked

// lblFotoGrande.setIcon(Mi_Galeria.getFoto(a,lblFotoGrande.getSize()));
lblFotoGrande.setIcon(Mi_Galeria.getFotoGrande(a));
        // TODO add your handling code here:
    }//GEN-LAST:event_lblFoto1MouseClicked

    private void lblFoto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFoto2MouseClicked


 //lblFotoGrande.setIcon(Mi_Galeria.getFoto(b,lblFotoGrande.getSize()));     
 
lblFotoGrande.setIcon(Mi_Galeria.getFotoGrande(b));// TODO add your handling code here:
    }//GEN-LAST:event_lblFoto2MouseClicked

    private void lblFoto3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFoto3MouseClicked

lblFotoGrande.setIcon(Mi_Galeria.getFotoGrande(c));
 //lblFotoGrande.setIcon(Mi_Galeria.getFoto(c,lblFotoGrande.getSize()));        // TODO add your handling code here:
    }//GEN-LAST:event_lblFoto3MouseClicked

    private void lblFoto4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFoto4MouseClicked

 //lblFotoGrande.setIcon(Mi_Galeria.getFoto(d,jPanel6.getSize()));
 lblFotoGrande.setIcon(Mi_Galeria.getFotoGrande(d));
 lblFotoGrande.setHorizontalAlignment(JLabel.CENTER);
 lblFotoGrande.setVerticalAlignment(JLabel.CENTER);
;        // TODO add your handling code here:
    }//GEN-LAST:event_lblFoto4MouseClicked

    private void lblfoto5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblfoto5MouseClicked
lblFotoGrande.setIcon(Mi_Galeria.getFotoGrande(e));

        // TODO add your handling code here:
    }//GEN-LAST:event_lblfoto5MouseClicked

    private void lblfoto6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblfoto6MouseClicked
lblFotoGrande.setIcon(Mi_Galeria.getFotoGrande(f));


        // TODO add your handling code here:
    }//GEN-LAST:event_lblfoto6MouseClicked

    private void lblfoto7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblfoto7MouseClicked


lblFotoGrande.setIcon(Mi_Galeria.getFotoGrande(g));        // TODO add your handling code here:
    }//GEN-LAST:event_lblfoto7MouseClicked

    private void lblfoto8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblfoto8MouseClicked


lblFotoGrande.setIcon(Mi_Galeria.getFotoGrande(h));        // TODO add your handling code here:
    }//GEN-LAST:event_lblfoto8MouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

 
    
        //se elimina el texto
        lblFoto1.setText("");lblFoto2.setText("");lblFoto3.setText("");lblFoto4.setText("");lblfoto5.setText("");lblfoto6.setText("");lblfoto7.setText("");lblfoto8.setText("");lblFotoGrande.setText("");
        //se inici la vista previa
        lblFoto1.setIcon(Mi_Galeria.getPreview(0));
        lblFoto2.setIcon(Mi_Galeria.getPreview(1));
        lblFoto3.setIcon(Mi_Galeria.getPreview(2));
        lblFoto4.setIcon(Mi_Galeria.getPreview(3));
        lblfoto5.setIcon(Mi_Galeria.getPreview(4));
        lblfoto6.setIcon(Mi_Galeria.getPreview(5));
        lblfoto7.setIcon(Mi_Galeria.getPreview(6));
        lblfoto8.setIcon(Mi_Galeria.getPreview(7));
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        //Creamos el objeto JFileChooser
JFileChooser fc=new JFileChooser();
 
//Indicamos que podemos seleccionar varios ficheros
fc.setMultiSelectionEnabled(true);
 
//Indicamos lo que podemos seleccionar
fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
 
//Creamos el filtro
FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de Imagen", "jpg", "jpeg");
 
//Le indicamos el filtro
fc.setFileFilter(filtro);
 
//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
int seleccion=fc.showOpenDialog(contentPane);
 
//Si el usuario, pincha en aceptar
if(seleccion==JFileChooser.APPROVE_OPTION){
 
    //Seleccionamos el fichero
    File[] ficheros=fc.getSelectedFiles();
 
    for(int i=0;i<ficheros.length;i++){
   
        int listaArchivos;
        String ruta="C:\\Users\\Nahuel\\Documents\\SM\\"+calle.getText()+piso.getText()+dpto.getText();
        File directorio=new File(ruta); 
        if(directorio.exists()){
              listaArchivos=directorio.listFiles().length;        
        }else{
            listaArchivos=0;
            directorio.mkdir();
        }
         
       // File source = new File("C:\\Users\\Nahuel\\Pictures\\union.jpeg");
        File dest = new File(ruta+"\\"+calle.getText()+piso.getText()+dpto.getText()+"-"+(listaArchivos+1)+".jpg");
        // copy file using FileStreams
        long start = System.nanoTime();
        long end;
        try {
            CopiarImagenes.copyFileUsingFileStreams(ficheros[i], dest);           
        } catch(NullPointerException ex2){
            JOptionPane.showMessageDialog(new JDialog(),ex2.toString()+" - "+ex2.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(AltaInmueble.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
                JOptionPane.showMessageDialog(new JDialog(),"Imagenes agregadas correctamente");

}

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void pisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pisoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pisoActionPerformed

    private void btnEliminarInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInmuebleActionPerformed

        int r=GestorModificarInmueble.ModificarEstadoInhabilitado(Integer.parseInt(etiquetaId.getText()));
        Inmueble inm=new Inmueble();
        inm.setCalle(calle.getText());
        inm.setPiso(piso.getText());
        inm.setDpto(dpto.getText());
        Eventos evento=new Eventos();            
            evento.setUsuario(InicioSesion.usuarioEnSesion);
            evento.setTipo("INMUEBLE");
            evento.setDescipcion("Se elimino el Inmueble "+inm.getCalle()+" "+inm.getPiso()+" "+inm.getDpto());
            evento.setFecha(GestorEventos.getFechaActual());
        if(r==1){
            JOptionPane.showMessageDialog(new JDialog(),"Eliminado correctamente");
            try {
                int e=GestorEventos.AltaEvento(evento);
            } catch (IOException ex) {
                Logger.getLogger(DatosInmueble.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }

    }//GEN-LAST:event_btnEliminarInmuebleActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        if(jCheckBox1.isSelected()){
            calle.setEditable(true);
            ciudad.setEditable(true);
            dpto.setEditable(true);
            fechaInscripcion.setEditable(true);
            folio.setEditable(true);
            piso.setEditable(true);
            nroFolio.setEditable(true);
            provincia.setEditable(true);
            tipo.setEditable(true);
            tomo.setEditable(true);
            jButton1.setEnabled(true);
            jButton2.setText("Guardar");
        }else{
            calle.setEditable(false);
            ciudad.setEditable(false);
            dpto.setEditable(false);
            fechaInscripcion.setEditable(false);
            folio.setEditable(false);
            piso.setEditable(false);
            nroFolio.setEditable(false);
            provincia.setEditable(false);
            tipo.setEditable(false);
            tomo.setEditable(false);
            jButton1.setEnabled(false);
            jButton2.setText("Aceptar");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(DatosInmueble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatosInmueble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatosInmueble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatosInmueble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new DatosInmueble().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Foto1;
    private javax.swing.JPanel Foto2;
    private javax.swing.JPanel Foto3;
    private javax.swing.JPanel Foto4;
    public static javax.swing.JButton btnEliminarInmueble;
    public static javax.swing.JTextField calle;
    public javax.swing.JTextField ciudad;
    public javax.swing.JTextField dpto;
    public javax.swing.JTextField estado;
    public javax.swing.JLabel etiquetaId;
    public javax.swing.JTextField fechaInscripcion;
    public javax.swing.JTextField folio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFoto1;
    private javax.swing.JLabel lblFoto2;
    private javax.swing.JLabel lblFoto3;
    private javax.swing.JLabel lblFoto4;
    private javax.swing.JLabel lblFotoGrande;
    private javax.swing.JLabel lblfoto5;
    private javax.swing.JLabel lblfoto6;
    private javax.swing.JLabel lblfoto7;
    private javax.swing.JLabel lblfoto8;
    public javax.swing.JTextField nroFolio;
    public javax.swing.JTextField piso;
    public static javax.swing.JTextField propietario;
    public static javax.swing.JTextField provincia;
    public javax.swing.JTextField tipo;
    public javax.swing.JTextField tomo;
    // End of variables declaration//GEN-END:variables
     public static Inmueble datosInmuebleComparar;


     
}
