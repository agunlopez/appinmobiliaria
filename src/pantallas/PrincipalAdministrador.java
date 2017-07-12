/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;


import BackUp.BackUp;
import Imagenes.CopiarImagenes;
import Imagenes.Galeria;
import Renders.RenderAlerta;
import Renders.RenderAlertaTitulo;
import conexion.Conexion;
import entidades.Cliente;
import entidades.Contrato;
import entidades.Cuotas;
import entidades.Inmueble;

import Renders.RenderCuotas;
import Renders.RenderLiquidacion;
import Renders.RenderBordeTabla;
import Renders.RenderContratos;
import Usuarios.AgregarUsuario;
import Usuarios.EliminarUsuario;
import Usuarios.InicioSesion;
import Usuarios.ModificarContraseña;
import Usuarios.RecuperarUsuario;
import entidades.Eventos;
import entidades.Movimiento;
import entidades.Parametros;
import entidades.Usuario;
import gestores.BusquedaInmueble;
import gestores.GestorEventos;
import gestores.GestorMovimientos;
import gestores.GestorParametros;
import gestores.GestoresContrato;
import gestores.gestoresCliente.BusquedaGarante;
import gestores.gestoresCliente.BusquedaInquilino;
import gestores.fechas;
import gestores.gestoresCliente.BusquedaCliente;
import gestores.gestoresCliente.BusquedaPropietario;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelos.ModeloDetalleCuotasContrato;
import static modelos.ModeloDetalleCuotasContrato.añoPeriodo;
import static modelos.ModeloDetalleCuotasContrato.mesPeriodo;
import modelos.ModeloTablaBusquedaContrato;
import modelos.ModeloTablaCaja;
import modelos.ModeloTablaContrato;
import modelos.ModeloTablaContratosDelCliente;
import modelos.ModeloTablaEventos;
import modelos.ModeloTablaGarante;
import modelos.ModeloTablaInmueble;
import modelos.ModeloTablaInmuebleContrato;
import modelos.ModeloTablaInquilino;
import modelos.ModeloTablaPagoPropietario;
import modelos.ModeloTablaPersonas;
import modelos.ModeloTablaPropietarioResumen;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import static pantallas.Alerta.tablaAlerta;
import static pantallas.DetallesContrato.lblIdContrato;
import static pantallas.DetallesContrato.tablaDetalle;
import static pantallas.DetallesContrato.tablaImpuestos;

import pantallas.pantallasClientes.AltaGarante;
import pantallas.pantallasClientes.AltaInquilino;
import pantallas.pantallasClientes.AltaPropietario;
import pantallas.pantallasClientes.DatosCliente;
import pantallas.pantallasClientes.ListaBusquedaContrato;
import pantallas.pantallasClientes.PantallaBusquedaCliente;


import pantallas.pantallasClientes.RecuperarCliente;


/**
 *
 * @author Nahuel
 */
public class PrincipalAdministrador extends javax.swing.JFrame  {


    
    JDialog inmueblesDisponibles= new JDialog(new JFrame(),"Lista de Inmuebles Disponibles",true);
    private JPanel contentPane;
    private TableRowSorter<TableModel> modeloOrdenado;
    private TableRowSorter<TableModel> modeloOrdenadoPropietario;
    private TableRowSorter<TableModel> modeloOrdenadoInquilino;
    private TableRowSorter<TableModel> modeloOrdenadoGarante;
    private TableRowSorter<TableModel> modeloOrdenadoInmueble;
    private TableRowSorter<TableModel> modeloOrdenadoCaja;
    
    
    Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
    int alto=(int) dimension.getWidth();
    int ancho=(int) dimension.getHeight();
    
    JDialog recibo= new JDialog(new JFrame(),"Recibo",true);
    
    conexion.Conexion con= new conexion.Conexion();
    
    /**
     * Creates new form PrincipalAdministrador
     */
    public PrincipalAdministrador() throws ParseException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnCrearInmueble = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboBox = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        inmABuscar = new javax.swing.JTextField();
        comboBusqueda = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        btnNuevoContrato = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        comboContratos = new javax.swing.JComboBox<>();
        datos = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaContratos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnCrearPropietario = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPropietarios = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnCrearInquilino = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaInquilinos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btnCrearGarante = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaGarantes = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTotalPagado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTotalCobrado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtGanancia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtHonorarios = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaCaja = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuInmuebles = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuCrearContrato = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        menuPersonas = new javax.swing.JMenu();
        menuBuscarCliente = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        menuAgregarUsuario = new javax.swing.JMenuItem();
        menuEliminarUsuario = new javax.swing.JMenuItem();
        menuRecuperarUsuario = new javax.swing.JMenuItem();
        menuBackup = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuRestaurar = new javax.swing.JMenuItem();
        menuRegistro = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        menuParametros = new javax.swing.JMenuItem();
        menuAdminImpuestos = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuManualUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SM Inmobiliaria");
        setIconImage(getIconImage());
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        jPanel12.setBackground(java.awt.Color.red);
        jPanel12.setPreferredSize(new java.awt.Dimension(1012, 50));

        btnCrearInmueble.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCrearInmueble.setText("Crear Inmueble");
        btnCrearInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearInmuebleActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Filtrar: ");

        comboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos","Disponibles","Ocupados" }));
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        inmABuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inmABuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inmABuscarActionPerformed(evt);
            }
        });

        comboBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Calle","Tipo","Localidad","Apellido Propietario"}));
        comboBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCrearInmueble)
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(inmABuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearInmueble)
                    .addComponent(jLabel1)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(inmABuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(null);

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 500, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Inmuebles", new javax.swing.ImageIcon(getClass().getResource("/Imagenes/apartments (2).png")), jPanel1, "Lista de Inmuebles"); // NOI18N

        jPanel11.setBackground(java.awt.Color.red);
        jPanel11.setPreferredSize(new java.awt.Dimension(1012, 50));

        btnNuevoContrato.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevoContrato.setText("Nuevo Contrato");
        btnNuevoContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoContratoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Filtrar: ");

        comboContratos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboContratos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos","Activos","Finalizados"}));
        comboContratos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboContratosActionPerformed(evt);
            }
        });

        datos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datosActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoContrato)
                .addGap(61, 61, 61)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboContratos, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 337, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(datos, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoContrato)
                    .addComponent(jLabel2)
                    .addComponent(comboContratos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane5.setBorder(null);

        tablaContratos.setAutoCreateRowSorter(true);
        tablaContratos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaContratosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablaContratos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 500, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Contratos", new javax.swing.ImageIcon(getClass().getResource("/Imagenes/file.png")), jPanel2); // NOI18N

        jPanel10.setBackground(java.awt.Color.red);
        jPanel10.setPreferredSize(new java.awt.Dimension(1012, 50));

        btnCrearPropietario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCrearPropietario.setText("Crear Propietario");
        btnCrearPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPropietarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCrearPropietario)
                .addContainerGap(862, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCrearPropietario)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jScrollPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaPropietarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPropietariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaPropietarios);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 497, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Propietarios", new javax.swing.ImageIcon(getClass().getResource("/Imagenes/businessman.png")), jPanel3); // NOI18N

        jPanel9.setBackground(java.awt.Color.red);
        jPanel9.setPreferredSize(new java.awt.Dimension(1012, 50));

        btnCrearInquilino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCrearInquilino.setText("Crear Inquilino");
        btnCrearInquilino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearInquilinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCrearInquilino)
                .addContainerGap(878, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCrearInquilino)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jScrollPane3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaInquilinos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaInquilinosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaInquilinos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 497, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Inquilinos", new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user-silhouette.png")), jPanel4); // NOI18N

        jPanel8.setBackground(java.awt.Color.red);
        jPanel8.setPreferredSize(new java.awt.Dimension(1012, 50));

        btnCrearGarante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCrearGarante.setText("Crear Garante");
        btnCrearGarante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearGaranteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCrearGarante)
                .addContainerGap(880, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCrearGarante)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jScrollPane4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaGarantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaGarantesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaGarantes);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 497, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Garantes ", new javax.swing.ImageIcon(getClass().getResource("/Imagenes/people-silhouettes.png")), jPanel5); // NOI18N

        jPanel7.setBackground(java.awt.Color.red);
        jPanel7.setPreferredSize(new java.awt.Dimension(1012, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Elegir Periodo:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoy", "Mes Actual", "Año Actual", "Desde el origen de los tiempos" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel13.setBackground(java.awt.Color.red);
        jPanel13.setPreferredSize(new java.awt.Dimension(1012, 50));

        jPanel14.setBackground(java.awt.Color.red);
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel14.setPreferredSize(new java.awt.Dimension(150, 60));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Pagado");

        txtTotalPagado.setEditable(false);
        txtTotalPagado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("$");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("$");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 48, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalPagado)))
                .addContainerGap())
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(jLabel9)
                    .addContainerGap(70, Short.MAX_VALUE)))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalPagado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel9)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );

        jPanel15.setBackground(new java.awt.Color(0, 153, 0));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel15.setPreferredSize(new java.awt.Dimension(150, 60));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total Cobrado");

        txtTotalCobrado.setEditable(false);
        txtTotalCobrado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("$");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 41, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalCobrado)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalCobrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(0, 153, 0));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel16.setForeground(new java.awt.Color(255, 255, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(150, 60));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Saldo Caja");

        txtGanancia.setEditable(false);
        txtGanancia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("$");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 64, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGanancia)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(0, 102, 204));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel18.setPreferredSize(new java.awt.Dimension(150, 60));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Honorarios");

        txtHonorarios.setEditable(false);
        txtHonorarios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("$");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 62, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHonorarios)))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHonorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane6.setBorder(null);

        tablaCaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tablaCaja);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Caja ", new javax.swing.ImageIcon(getClass().getResource("/Imagenes/money.png")), jPanel6); // NOI18N

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        menuInmuebles.setText("Inmuebles");

        jMenuItem1.setText("Crear Inmueble");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuInmuebles.add(jMenuItem1);

        jMenuItem15.setText("Recuperar Inmueble");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        menuInmuebles.add(jMenuItem15);

        jMenuItem2.setText("Lista Inmuebles Disponibles");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuInmuebles.add(jMenuItem2);

        jMenuBar1.add(menuInmuebles);

        jMenu4.setText("Contratos");

        menuCrearContrato.setText("Crear Contrato");
        menuCrearContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCrearContratoActionPerformed(evt);
            }
        });
        jMenu4.add(menuCrearContrato);

        jMenuItem10.setText("Contratos por vencer");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        menuPersonas.setText("Personas");

        menuBuscarCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuBuscarCliente.setText("Buscar Cliente ");
        menuBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBuscarClienteActionPerformed(evt);
            }
        });
        menuPersonas.add(menuBuscarCliente);

        jMenu3.setText("Propietarios");

        jMenuItem6.setText("Crear Propietario");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        menuPersonas.add(jMenu3);

        jMenu8.setText("Inquilunos");

        jMenuItem7.setText("Crear Inquilino");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem7);

        menuPersonas.add(jMenu8);

        jMenu9.setText("Garantes");

        jMenuItem8.setText("Crear Garante");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem8);

        menuPersonas.add(jMenu9);

        jMenuItem16.setText("Recuperar Cliente");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        menuPersonas.add(jMenuItem16);

        jMenuBar1.add(menuPersonas);

        jMenu6.setText("Utilidades");

        jMenu1.setText("Administrar Usuarios");

        jMenuItem11.setText("Cambiar Contraseña");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        menuAgregarUsuario.setText("Agregar Usuario");
        menuAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgregarUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(menuAgregarUsuario);

        menuEliminarUsuario.setText("Eliminar Usuario");
        menuEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliminarUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(menuEliminarUsuario);

        menuRecuperarUsuario.setText("Recuperar Usuarios");
        menuRecuperarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRecuperarUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(menuRecuperarUsuario);

        jMenu6.add(jMenu1);

        menuBackup.setText("Backup");

        jMenuItem4.setText("Iniciar Backup");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuBackup.add(jMenuItem4);

        jMenuItem5.setText("Programar Backup");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuBackup.add(jMenuItem5);

        menuRestaurar.setText("Restaurar BackUp");
        menuRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRestaurarActionPerformed(evt);
            }
        });
        menuBackup.add(menuRestaurar);

        jMenu6.add(menuBackup);

        menuRegistro.setText("Registro de Actividad");
        menuRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegistroActionPerformed(evt);
            }
        });
        jMenu6.add(menuRegistro);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Ocipones");

        menuParametros.setText("Parametros del Sistema");
        menuParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuParametrosActionPerformed(evt);
            }
        });
        jMenu7.add(menuParametros);

        menuAdminImpuestos.setText("Administrar Impuestos");

        jMenuItem3.setText("Lista/Carga Impuestos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuAdminImpuestos.add(jMenuItem3);

        jMenuItem9.setText("Recuperar Impuesto");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        menuAdminImpuestos.add(jMenuItem9);

        jMenu7.add(menuAdminImpuestos);

        jMenu2.setText("Ayuda");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        menuManualUsuario.setText("Manual de Usuario");
        menuManualUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuManualUsuarioActionPerformed(evt);
            }
        });
        jMenu2.add(menuManualUsuario);

        jMenu7.add(jMenu2);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

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

    private void menuCrearContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCrearContratoActionPerformed


x=GestoresContrato.consultaIdContrato()+1;
        NuevoContrato contrato;
        try {
            contrato = new NuevoContrato();
             contrato.setSize(alto/2,ancho/2);
        contrato.pack();
        contrato.setLocationRelativeTo(null);
        contrato.setVisible(true); 
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
       

               // TODO add your handling code here:
    }//GEN-LAST:event_menuCrearContratoActionPerformed

    private void inmABuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inmABuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inmABuscarActionPerformed

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        // TODO add your handling code here:
       
        if(comboBox.getSelectedItem().equals("Todos")){
            ArrayList lista=BusquedaInmueble.consultaTabla();   
            ModeloTablaInmueble modelo=new ModeloTablaInmueble(lista){
                @Override
                public Class getColumnClass(int columna) {
                    if (columna == 0)
                        return Integer.class;
                    return String.class;
                }
            };
            table.setModel(modelo);    
            modeloOrdenadoInmueble = new TableRowSorter<TableModel>(modelo);
            table.setRowSorter(modeloOrdenadoInmueble);

            table.getColumnModel().getColumn(0).setMaxWidth(50);
            table.getColumnModel().getColumn(2).setMaxWidth(50);
            table.getColumnModel().getColumn(3).setMaxWidth(50);    
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.LEFT);
            table.getColumnModel().getColumn(0).setCellRenderer(tcr);
            table.setModel(modelo);
        }else if(comboBox.getSelectedItem().equals("Disponibles")){
            ArrayList lista=BusquedaInmueble.consultaPorEstado("Disponible");
            ModeloTablaInmueble modelo=new ModeloTablaInmueble(lista){
                @Override
                public Class getColumnClass(int columna) {
                    if (columna == 0)
                        return Integer.class;
                    return String.class;
                }
            };
            table.setModel(modelo);    
            modeloOrdenadoInmueble = new TableRowSorter<TableModel>(modelo);
            table.setRowSorter(modeloOrdenadoInmueble);

            table.getColumnModel().getColumn(0).setMaxWidth(50);
            table.getColumnModel().getColumn(2).setMaxWidth(50);
            table.getColumnModel().getColumn(3).setMaxWidth(50);    
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.LEFT);
            table.getColumnModel().getColumn(0).setCellRenderer(tcr);
            table.setModel(modelo);
        }else{
            ArrayList lista=BusquedaInmueble.consultaPorEstado("Ocupado");
            ModeloTablaInmueble modelo=new ModeloTablaInmueble(lista){
                @Override
                public Class getColumnClass(int columna) {
                    if (columna == 0)
                        return Integer.class;
                    return String.class;
                }
            };
            table.setModel(modelo);    
            modeloOrdenadoInmueble = new TableRowSorter<TableModel>(modelo);
            table.setRowSorter(modeloOrdenadoInmueble);

            table.getColumnModel().getColumn(0).setMaxWidth(50);
            table.getColumnModel().getColumn(2).setMaxWidth(50);
            table.getColumnModel().getColumn(3).setMaxWidth(50);    
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.LEFT);
            table.getColumnModel().getColumn(0).setCellRenderer(tcr);
            table.setModel(modelo);
        }
        
        
    }//GEN-LAST:event_comboBoxActionPerformed

    private void btnCrearInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearInmuebleActionPerformed
        // TODO add your handling code here:
        
        AltaInmueble altaInmueble=new AltaInmueble();
        altaInmueble.setLocationRelativeTo(null);
        altaInmueble.pack();
        altaInmueble.setVisible(true);
    }//GEN-LAST:event_btnCrearInmuebleActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

 if(evt.getClickCount()==2){
          
				int row = table.getSelectedRow();
                                
				String id=table.getValueAt(row, 0).toString();
			        datosInmueble=BusquedaInmueble.busquedaDatosInmueble(Integer.parseInt(id));
                                Galeria.Ruta=datosInmueble.getCalle()+datosInmueble.getPiso()+datosInmueble.getDpto();
				DatosInmueble pantaDatos=new DatosInmueble();
                                Cliente prop=new Cliente();
                                
                                pantaDatos.propietario.setText(datosInmueble.getPropietario().getId()+" - "+datosInmueble.getPropietario().getApellido()+" "+datosInmueble.getPropietario().getNombre());
                                pantaDatos.calle.setText(datosInmueble.getCalle());
                                pantaDatos.ciudad.setText(datosInmueble.getLocalidad());
                                pantaDatos.dpto.setText(datosInmueble.getDpto());
                                pantaDatos.estado.setText(datosInmueble.getEstado());
                                pantaDatos.fechaInscripcion.setText(datosInmueble.getFechaInscripcion());
                                pantaDatos.folio.setText((datosInmueble.getFolio()));
                                pantaDatos.nroFolio.setText(Integer.toString(datosInmueble.getFolioReal()));
                                pantaDatos.piso.setText(datosInmueble.getPiso());
                                pantaDatos.tipo.setText(datosInmueble.getTipo());
                                pantaDatos.tomo.setText(Integer.toString(datosInmueble.getTomo()));
                                pantaDatos.etiquetaId.setText(Integer.toString(datosInmueble.getId()));
                                pantaDatos.provincia.setText(datosInmueble.getProvincia());
                                
                                if(InicioSesion.usuarioEnSesion.getTipo().equals("EMPLEADO")){
                                    pantaDatos.btnEliminarInmueble.setEnabled(false);
                                }
                                pantaDatos.setSize(alto/2, ancho/2);
                                pantaDatos.pack();
                                pantaDatos.setLocationRelativeTo(null);
                                        
                                pantaDatos.setVisible(true);
				
				
				
       }
        
        
    }//GEN-LAST:event_tableMouseClicked

    private void btnCrearPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPropietarioActionPerformed

       AltaPropietario alta=new AltaPropietario();
       alta.setLocationRelativeTo(null);
       alta.pack();
       alta.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearPropietarioActionPerformed

    private void btnCrearInquilinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearInquilinoActionPerformed

        AltaInquilino altaInquilino=new AltaInquilino();
        altaInquilino.setLocationRelativeTo(null);
        altaInquilino.pack();
        altaInquilino.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearInquilinoActionPerformed

    private void btnCrearGaranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearGaranteActionPerformed


        AltaGarante altaGarante=new AltaGarante();
        altaGarante.setLocationRelativeTo(null);
        altaGarante.pack();
        altaGarante.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearGaranteActionPerformed

    private void btnNuevoContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoContratoActionPerformed
        // TODO add your handling code here:

        x=GestoresContrato.consultaIdContrato()+1;
        NuevoContrato contrato;
        try {
            contrato = new NuevoContrato();
            contrato.setSize(alto/2,ancho/2);
        contrato.pack();
        contrato.setLocationRelativeTo(null);

        contrato.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnNuevoContratoActionPerformed

    private void comboContratosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboContratosActionPerformed
        // TODO add your handling code here:
        

        if (comboContratos.getSelectedItem().equals("Todos")){
            ArrayList listaContrato=GestoresContrato.consultaTablaContrato();
            ModeloTablaContrato modeloContrato=new ModeloTablaContrato(listaContrato){
                @Override
                public Class getColumnClass(int columna) {
                    if (columna == 0)
                        return Integer.class;
                    return String.class;
                }
            };
            tablaContratos.setDefaultRenderer(Object.class, new RenderContratos());
            tablaContratos.setModel(modeloContrato);       
            modeloOrdenado = new TableRowSorter<TableModel>(modeloContrato);
            tablaContratos.setRowSorter(modeloOrdenado);
    
            tablaContratos.getColumnModel().getColumn(0).setMaxWidth(50);
            tablaContratos.getColumnModel().getColumn(8).setMaxWidth(50);
        }else if(comboContratos.getSelectedItem().equals("Activos")){
            String a="Activo";
            ArrayList listaActivos=GestoresContrato.consultaPorEstado(a);
            ModeloTablaContrato modeloContrato=new ModeloTablaContrato(listaActivos){
                @Override
                public Class getColumnClass(int columna) {
                    if (columna == 0)
                        return Integer.class;
                    return String.class;
                }
            };
            tablaContratos.setDefaultRenderer(Object.class, new RenderContratos());
            tablaContratos.setModel(modeloContrato);       
            modeloOrdenado = new TableRowSorter<TableModel>(modeloContrato);
            tablaContratos.setRowSorter(modeloOrdenado);
    
            tablaContratos.getColumnModel().getColumn(0).setMaxWidth(50);
            tablaContratos.getColumnModel().getColumn(8).setMaxWidth(50);
        }else{
            ArrayList listaInactivos=GestoresContrato.consultaPorEstado("Finalizado");
            ModeloTablaContrato modeloContrato=new ModeloTablaContrato(listaInactivos){
                @Override
                public Class getColumnClass(int columna) {
                    if (columna == 0)
                        return Integer.class;
                    return String.class;
                }
            };
            tablaContratos.setDefaultRenderer(Object.class, new RenderContratos());
            tablaContratos.setModel(modeloContrato);       
            modeloOrdenado = new TableRowSorter<TableModel>(modeloContrato);
            tablaContratos.setRowSorter(modeloOrdenado);
    
            tablaContratos.getColumnModel().getColumn(0).setMaxWidth(50);
            tablaContratos.getColumnModel().getColumn(8).setMaxWidth(50);
        }
    }//GEN-LAST:event_comboContratosActionPerformed

    private void tablaPropietariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPropietariosMouseClicked
        // TODO add your handling code here:
        
        if(evt.getClickCount()==2){
            int row = tablaPropietarios.getSelectedRow();
				int id=Integer.parseInt(tablaPropietarios.getValueAt(row, 0).toString());
				
				Cliente prop=BusquedaPropietario.busquedaDatos(id);
				DatosCliente datosP=new DatosCliente();
				datosP.apellido.setText(prop.getApellido());
				datosP.apellidoM.setText(prop.getApellidoMaterno());
				datosP.celular.setText(Integer.toString(prop.getCelular()));
				datosP.ciudad.setText(prop.getLocalidad());
				datosP.correo.setText(prop.getCorreo());
				datosP.cuit.setText(Integer.toString(prop.getCuit()));
				datosP.dgi.setText(prop.getDgi());
				datosP.direccion.setText(prop.getDireccion());
				datosP.dni.setText(Integer.toString(prop.getDni()));
				datosP.estadoCivil.setText(prop.getEstadoCivil());
				datosP.fechaNac.setText(prop.getFechaNac());
				datosP.idPropietario.setText(Integer.toString(prop.getId()));
				datosP.nombre.setText(prop.getNombre());
				datosP.profesion.setText(prop.getProfesion());
				datosP.provincia.setText(prop.getProvincia());
				datosP.telefono.setText(Integer.toString(prop.getTel()));
				
                                datosP.setSize(alto/2, ancho/2);
                                datosP.pack();
                                datosP.setLocationRelativeTo(null);
                                
                                if(InicioSesion.usuarioEnSesion.getTipo().equals("EMPLEADO")){
                                    datosP.btnEliminarCliente.setEnabled(false);
                                }
                                 ArrayList<Contrato> listaContratos=BusquedaCliente.contratosDelCliente(prop.getId());
        ModeloTablaContratosDelCliente modelo=new ModeloTablaContratosDelCliente(listaContratos);
        DatosCliente.tablaContratosCliente.setModel(modelo);
				datosP.setVisible(true);
            
        }
        
				
				
    }//GEN-LAST:event_tablaPropietariosMouseClicked

    private void tablaInquilinosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaInquilinosMouseClicked

 if(evt.getClickCount()==2){
            int row = tablaInquilinos.getSelectedRow();
				int id=Integer.parseInt(tablaInquilinos.getValueAt(row, 0).toString());
				
				Cliente prop=BusquedaPropietario.busquedaDatos(id);
				DatosCliente datosP=new DatosCliente();
				datosP.apellido.setText(prop.getApellido());
				datosP.apellidoM.setText(prop.getApellidoMaterno());
				datosP.celular.setText(Integer.toString(prop.getCelular()));
				datosP.ciudad.setText(prop.getLocalidad());
				datosP.correo.setText(prop.getCorreo());
				datosP.cuit.setText(Integer.toString(prop.getCuit()));
				datosP.dgi.setText(prop.getDgi());
				datosP.direccion.setText(prop.getDireccion());
				datosP.dni.setText(Integer.toString(prop.getDni()));
				datosP.estadoCivil.setText(prop.getEstadoCivil());
				datosP.fechaNac.setText(prop.getFechaNac());
				datosP.idPropietario.setText(Integer.toString(prop.getId()));
				datosP.nombre.setText(prop.getNombre());
				datosP.profesion.setText(prop.getProfesion());
				datosP.provincia.setText(prop.getProvincia());
				datosP.telefono.setText(Integer.toString(prop.getTel()));
				
                                datosP.setSize(alto/2, ancho/2);
                                datosP.pack();
                                datosP.setLocationRelativeTo(null);
                                if(InicioSesion.usuarioEnSesion.getTipo().equals("EMPLEADO")){
                                    datosP.btnEliminarCliente.setEnabled(false);
                                }
                                 ArrayList<Contrato> listaContratos=BusquedaCliente.contratosDelCliente(prop.getId());
        ModeloTablaContratosDelCliente modelo=new ModeloTablaContratosDelCliente(listaContratos);
        DatosCliente.tablaContratosCliente.setModel(modelo);
				datosP.setVisible(true);
            
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tablaInquilinosMouseClicked

    private void tablaGarantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGarantesMouseClicked

 if(evt.getClickCount()==2){
            int row = tablaGarantes.getSelectedRow();
				int id=Integer.parseInt(tablaGarantes.getValueAt(row, 0).toString());
				
				Cliente prop=BusquedaPropietario.busquedaDatos(id);
				DatosCliente datosP=new DatosCliente();
				datosP.apellido.setText(prop.getApellido());
				datosP.apellidoM.setText(prop.getApellidoMaterno());
				datosP.celular.setText(Integer.toString(prop.getCelular()));
				datosP.ciudad.setText(prop.getLocalidad());
				datosP.correo.setText(prop.getCorreo());
				datosP.cuit.setText(Integer.toString(prop.getCuit()));
				datosP.dgi.setText(prop.getDgi());
				datosP.direccion.setText(prop.getDireccion());
				datosP.dni.setText(Integer.toString(prop.getDni()));
				datosP.estadoCivil.setText(prop.getEstadoCivil());
				datosP.fechaNac.setText(prop.getFechaNac());
				datosP.idPropietario.setText(Integer.toString(prop.getId()));
				datosP.nombre.setText(prop.getNombre());
				datosP.profesion.setText(prop.getProfesion());
				datosP.provincia.setText(prop.getProvincia());
				datosP.telefono.setText(Integer.toString(prop.getTel()));
				
                                if(InicioSesion.usuarioEnSesion.getTipo().equals("EMPLEADO")){
                                    datosP.btnEliminarCliente.setEnabled(false);
                                }
                                 ArrayList<Contrato> listaContratos=BusquedaCliente.contratosDelCliente(prop.getId());
        ModeloTablaContratosDelCliente modelo=new ModeloTablaContratosDelCliente(listaContratos);
        DatosCliente.tablaContratosCliente.setModel(modelo);
                                datosP.setSize(alto/2, ancho/2);
                                datosP.pack();
                                datosP.setLocationRelativeTo(null);
				datosP.setVisible(true);
            
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tablaGarantesMouseClicked

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowIconified

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
 
    //Cargamos tabla Inmueble
    listaInmueble=BusquedaInmueble.consultaTabla();
    ModeloTablaInmueble modelo=new ModeloTablaInmueble(listaInmueble){
         @Override
			public Class getColumnClass(int columna) {
				if (columna == 0)
					return Integer.class;
				return String.class;
			}
    };
    table.setModel(modelo);    
    modeloOrdenadoInmueble = new TableRowSorter<TableModel>(modelo);
    table.setRowSorter(modeloOrdenadoInmueble);

    table.getColumnModel().getColumn(0).setMaxWidth(50);
    table.getColumnModel().getColumn(2).setMaxWidth(50);
    table.getColumnModel().getColumn(3).setMaxWidth(50);
    
    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
    tcr.setHorizontalAlignment(SwingConstants.LEFT);
    table.getColumnModel().getColumn(0).setCellRenderer(tcr);

   
    //Cargamos tabla Contratos 
    ArrayList listaContrato=GestoresContrato.consultaTablaContrato();
    ModeloTablaContrato modeloContrato=new ModeloTablaContrato(listaContrato){
        @Override
        public Class getColumnClass(int columna) {
            if (columna == 0)
                return Integer.class;
            return String.class;
        }
    };
    tablaContratos.setDefaultRenderer(Object.class, new RenderContratos());
    tablaContratos.setModel(modeloContrato);       
    modeloOrdenado = new TableRowSorter<TableModel>(modeloContrato);
    tablaContratos.setRowSorter(modeloOrdenado);
    
    tablaContratos.getColumnModel().getColumn(0).setMaxWidth(50);
    tablaContratos.getColumnModel().getColumn(8).setMaxWidth(50);

    //Cargamos modelo de tabla Propietarios		
    ArrayList listaP=BusquedaPropietario.consultaTablaPropietario();
    ModeloTablaPersonas modeloP=new ModeloTablaPersonas(listaP){
        @Override
        public Class getColumnClass(int columna2) {
            if (columna2 == 0)
                return Integer.class;
            return String.class;
        }                                       
    };
    tablaPropietarios.setModel(modeloP);
    modeloOrdenadoPropietario= new TableRowSorter<TableModel>(modeloP);
    tablaPropietarios.setRowSorter(modeloOrdenadoPropietario);
    
    tablaPropietarios.getColumnModel().getColumn(0).setMaxWidth(50);
    
      
    
    tablaPropietarios.getColumnModel().getColumn(0).setCellRenderer(tcr);
    
                               
    //Cargamos tabla Inquilinos
    ArrayList listaI=BusquedaInquilino.consultaTablaInquilino();
    ModeloTablaPersonas modeloInquilino=new ModeloTablaPersonas(listaI){
        @Override
        public Class getColumnClass(int columna2) {
            if (columna2 == 0)
                return Integer.class;
            return String.class;
        }    
    };
    tablaInquilinos.setModel(modeloInquilino);

  
    modeloOrdenadoInquilino= new TableRowSorter<TableModel>(modeloInquilino);
    tablaInquilinos.setRowSorter(modeloOrdenadoInquilino);
    tablaInquilinos.getColumnModel().getColumn(0).setMaxWidth(50);
      
    tablaInquilinos.getColumnModel().getColumn(0).setCellRenderer(tcr);
    
    //Cargamos tabla Garantes
    ArrayList listaG=BusquedaGarante.consultaTablaGarante();
    ModeloTablaPersonas modeloG=new ModeloTablaPersonas(listaG){
        @Override
        public Class getColumnClass(int columna2) {
            if (columna2 == 0)
                return Integer.class;
            return String.class;
        }    
    };
    tablaGarantes.setModel(modeloG);

    modeloOrdenadoGarante= new TableRowSorter<TableModel>(modeloG);
    tablaGarantes.setRowSorter(modeloOrdenadoGarante);
    
    tablaGarantes.getColumnModel().getColumn(0).setMaxWidth(50);
    tablaGarantes.getColumnModel().getColumn(0).setCellRenderer(tcr);
    
    
    
    SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
    Calendar ahora= Calendar.getInstance();
    int diaActual=ahora.get(Calendar.DATE);
    int mesActual=ahora.get((Calendar.MONTH))+1;
    int añoActual=ahora.get(Calendar.YEAR);


    //Cargamos tabla Caja
   String periodo=diaActual+"/"+(mesActual+1)+"/"+añoActual+"%";   
   ArrayList listaCaja=GestorMovimientos.consultaTablaPorEstado(periodo);
   ModeloTablaCaja modeloCaja=new ModeloTablaCaja(listaCaja){
       @Override
                public Class getColumnClass(int columna) {
                    if (columna == 1 || columna == 2 || columna == 8 || columna == 9)
                        return Integer.class;
                    return String.class;
                }
   };
   modeloOrdenadoCaja= new TableRowSorter<TableModel>(modeloCaja);
   tablaCaja.setModel(modeloCaja);
   
   DefaultTableCellRenderer tcr2 = new DefaultTableCellRenderer();
    tcr.setHorizontalAlignment(SwingConstants.LEFT);
   tablaCaja.getColumnModel().getColumn(1).setCellRenderer(tcr);
   tablaCaja.setRowSorter(modeloOrdenadoCaja);
   tablaCaja.getColumnModel().getColumn(1).setMaxWidth(100);
   tablaCaja.getColumnModel().getColumn(2).setMaxWidth(50);
   actualizarSaldos();
        
      try {
            Date hoy=formato.parse(diaActual+"/"+mesActual+"/"+añoActual);
            Date vencimiento;
            ArrayList<Contrato> contratos=GestoresContrato.consultaTablaContrato();
            for(int i=0;i<contratos.size();i++){
               vencimiento=formato.parse(contratos.get(i).getFechaVencimiento());
                if(hoy.compareTo(vencimiento)>0){
                    GestoresContrato.FinalizarContrato(contratos.get(i).getIdContrato(),contratos.get(i).getInmueble().getId());
                }
                
            }
        } catch (ParseException ex) {
            Logger.getLogger(PrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }

 

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
    // TODO add your handling code here:
        
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void tablaContratosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaContratosMouseClicked


    if(evt.getClickCount()==2){
        int row = tablaContratos.getSelectedRow();
        
	    int id=Integer.parseInt(tablaContratos.getValueAt(row, 0).toString());
            idInmDatos=GestoresContrato.idInm(id);
            Inmueble inmDetalle=GestoresContrato.consultaInmuebleDetalle(idInmDatos);
            String inmuebleTitulo=inmDetalle.getCalle()+" "+inmDetalle.getPiso()+" "+inmDetalle.getDpto();
            inicioCon=(String) tablaContratos.getValueAt(row, 7);
            idConsAsociado=Integer.parseInt(tablaContratos.getValueAt(row, 0).toString());
            DetallesContrato detalles=new DetallesContrato();
            detalles.pack();
            detalles.setLocationRelativeTo(null);
            detalles.setExtendedState(MAXIMIZED_BOTH);
            ArrayList<Cuotas> contCuo2=GestoresContrato.consultarCuotas(id);
            ModeloDetalleCuotasContrato mdcc=new ModeloDetalleCuotasContrato(contCuo2);
            DetallesContrato.tablaDetalle.setModel(mdcc);
            DetallesContrato.lblIdContrato.setText(Integer.toString(id));
            DetallesContrato.lblInmueble.setText(inmuebleTitulo);
            DetallesContrato.tablaDetalle.setDefaultRenderer(Object.class, new RenderLiquidacion());   
            DetallesContrato.tablaDetalle.setRowHeight(25);
            DetallesContrato.tablaDetalle.getTableHeader().setPreferredSize(
            new Dimension(DetallesContrato.tablaDetalle.getColumnModel().getTotalColumnWidth(),40));
            ((DefaultTableCellRenderer)DetallesContrato.tablaDetalle.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            
            DetallesContrato.tablaImpuestos.getTableHeader().setPreferredSize(
            new Dimension(DetallesContrato.tablaImpuestos.getColumnModel().getTotalColumnWidth(),40));
            ((DefaultTableCellRenderer)DetallesContrato.tablaImpuestos.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            
            diaPago=GestoresContrato.consultaDatosContrato(id).getDiaPago();

            if(InicioSesion.usuarioEnSesion.getTipo().equals("EMPLEADO")){
               DetallesContrato.btnRescindir.setEnabled(false); 
            }
            
            if(tablaContratos.getValueAt(row,9).equals("Finalizado")){
            DetallesContrato.btnLiquidacion.setEnabled(false);
            DetallesContrato.btnGarantia.setEnabled(true);
            DetallesContrato.btnPagoPropietario.setEnabled(false);
            DetallesContrato.btnRescindir.setEnabled(false);
            DetallesContrato.habilitarTabla=false;
            DetallesContrato.ChcActivarPagos.setEnabled(true);
       
            }else{
                DetallesContrato.habilitarTabla=true;
            }          
            detalles.setVisible(true);
            
}

        // TODO add your handling code here:
    }//GEN-LAST:event_tablaContratosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

       ListaBusquedaInmueble lbi=new ListaBusquedaInmueble();
       //ArrayList listaInmueble=BusquedaInmueble.consultaTablaBusquedaInmueblePrincipal(inmABuscar.getText()); 
       ArrayList listaInmueble=null;
       if(comboBusqueda.getSelectedItem().toString().equals("Calle")){
            listaInmueble=BusquedaInmueble.consultaTablaBusquedaInmueblePrincipal(inmABuscar.getText());
       }else if(comboBusqueda.getSelectedItem().toString().equals("Localidad")){
            listaInmueble=BusquedaInmueble.consultaTablaBusquedaInmueblePrincipalLocalidad(inmABuscar.getText());
       }else if(comboBusqueda.getSelectedItem().toString().equals("Tipo")){
           listaInmueble=BusquedaInmueble.consultaTablaBusquedaInmueblePrincipalTipo(inmABuscar.getText());
       }else if(comboBusqueda.getSelectedItem().toString().equals("Apellido Propietario")){
           listaInmueble=BusquedaInmueble.consultaTablaBusquedaInmueblePrincipalPropietario(inmABuscar.getText());
       }
       if(listaInmueble.isEmpty()){
           JOptionPane.showMessageDialog(new JDialog(),"No se encuentra el Inmueble");
       }else{
       ModeloTablaInmuebleContrato modelo=new ModeloTablaInmuebleContrato(listaInmueble);
       lbi.tablaListaInmuebles2.setModel(modelo);
       TableColumnModel modeloColumna=lbi.tablaListaInmuebles2.getColumnModel();
       modeloColumna.getColumn(0).setMaxWidth(30);
       modeloColumna.getColumn(2).setMaxWidth(50);
       modeloColumna.getColumn(3).setMaxWidth(50);
       modeloColumna.getColumn(0).setPreferredWidth(30);
       modeloColumna.getColumn(2).setPreferredWidth(50);
       modeloColumna.getColumn(3).setPreferredWidth(50);
       modeloColumna.getColumn(4).setPreferredWidth(10);
       modeloColumna.getColumn(5).setPreferredWidth(15);
       modeloColumna.getColumn(7).setPreferredWidth(15);
       lbi.pack();
       lbi.setLocationRelativeTo(null);
       lbi.setVisible(true);
       }
       
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void datosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datosActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       // TODO add your handling code here:
        ListaBusquedaContrato lbc= new ListaBusquedaContrato();
        ArrayList listaCon=GestoresContrato.consultaTablaBusquedaContrato(datos.getText());
        if(listaCon.isEmpty()){
            JOptionPane.showMessageDialog(new JDialog(),"No se encuentra el Contrato con esos datos");

        }else{
           // ModeloTablaBusquedaContrato mtbq= new ModeloTablaBusquedaContrato(listaCon);
            ModeloTablaContrato mtbq=new ModeloTablaContrato(listaCon);
            
            lbc.tablaListaBusquedaContrato.setModel(mtbq);
            TableColumnModel modeloColumna=ListaBusquedaContrato.tablaListaBusquedaContrato.getColumnModel();
            modeloColumna.getColumn(0).setPreferredWidth(1);
            modeloColumna.getColumn(2).setPreferredWidth(5);
            modeloColumna.getColumn(7).setPreferredWidth(5);
            modeloColumna.getColumn(8).setPreferredWidth(20);
            modeloColumna.getColumn(9).setPreferredWidth(1);
            lbc.pack();
            lbc.setLocationRelativeTo(null);
            lbc.setVisible(true);
        }
        

        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
        Calendar ahora= Calendar.getInstance();
        int diaActual=ahora.get(Calendar.DATE);
        int mesActual=ahora.get((Calendar.MONTH));
        int añoActual=ahora.get(Calendar.YEAR);
        String periodo;
        if (jComboBox1.getSelectedItem().equals("Desde el origen de los tiempos")){
            ArrayList listaCaja=GestorMovimientos.consultaTabla();                                      
            ModeloTablaCaja modeloCaja=new ModeloTablaCaja(listaCaja){
                @Override
                public Class getColumnClass(int columna) {
                    if (columna == 1 || columna == 2 || columna == 8)
                        return Integer.class;
                    return String.class;
                }
            };
   modeloOrdenadoCaja= new TableRowSorter<TableModel>(modeloCaja);
   tablaCaja.setModel(modeloCaja);
   
   DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
    tcr.setHorizontalAlignment(SwingConstants.LEFT);
   tablaCaja.getColumnModel().getColumn(1).setCellRenderer(tcr);
   tablaCaja.getColumnModel().getColumn(8).setCellRenderer(tcr);
   tablaCaja.setRowSorter(modeloOrdenadoCaja);
   tablaCaja.getColumnModel().getColumn(1).setMaxWidth(100);
   tablaCaja.getColumnModel().getColumn(2).setMaxWidth(50);
   actualizarSaldos();

   tablaCaja.getColumnModel().getColumn(1).setMaxWidth(100);
   tablaCaja.getColumnModel().getColumn(2).setMaxWidth(50);
   actualizarSaldos();
        }else if(jComboBox1.getSelectedItem().equals("Hoy")){
            periodo=diaActual+"/"+(mesActual+1)+"/"+añoActual+"%";
            ArrayList listaCaja=GestorMovimientos.consultaTablaPorEstado(periodo);                                                                      
            ModeloTablaCaja modeloCaja=new ModeloTablaCaja(listaCaja){
                @Override
                public Class getColumnClass(int columna) {
                    if (columna == 1 || columna == 2 || columna == 8 )
                        return Integer.class;
                    return String.class;
                }
   };
   modeloOrdenadoCaja= new TableRowSorter<TableModel>(modeloCaja);
   tablaCaja.setModel(modeloCaja);
   
   DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
   tcr.setHorizontalAlignment(SwingConstants.LEFT);
   tablaCaja.getColumnModel().getColumn(1).setCellRenderer(tcr);
   tablaCaja.getColumnModel().getColumn(8).setCellRenderer(tcr);
   tablaCaja.setRowSorter(modeloOrdenadoCaja);
   tablaCaja.getColumnModel().getColumn(1).setMaxWidth(100);
   tablaCaja.getColumnModel().getColumn(2).setMaxWidth(50);
   actualizarSaldos();        
        }else if(jComboBox1.getSelectedItem().equals("Mes Actual")){
            periodo="%%/"+(mesActual+1)+"/"+añoActual;
            ArrayList listaCaja=GestorMovimientos.consultaTablaPorEstado(periodo);
            ModeloTablaCaja modeloCaja=new ModeloTablaCaja(listaCaja){
                @Override
                public Class getColumnClass(int columna) {
                    if (columna == 1 || columna == 2 || columna == 8 )
                        return Integer.class;
                    return String.class;
                }
   };
   modeloOrdenadoCaja= new TableRowSorter<TableModel>(modeloCaja);
   tablaCaja.setModel(modeloCaja);
   
   DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
    tcr.setHorizontalAlignment(SwingConstants.LEFT);
   tablaCaja.getColumnModel().getColumn(1).setCellRenderer(tcr);
   tablaCaja.getColumnModel().getColumn(8).setCellRenderer(tcr);
   tablaCaja.setRowSorter(modeloOrdenadoCaja);
   tablaCaja.getColumnModel().getColumn(1).setMaxWidth(100);
   tablaCaja.getColumnModel().getColumn(2).setMaxWidth(50);
   actualizarSaldos();                                                                       
   actualizarSaldos();
        }else{
            periodo="%/"+añoActual+"%";
            ArrayList listaCaja=GestorMovimientos.consultaTablaPorEstado(periodo);            
            ModeloTablaCaja modeloCaja=new ModeloTablaCaja(listaCaja){
                @Override
                public Class getColumnClass(int columna) {
                    if (columna == 1 || columna == 2 || columna == 8)
                        return Integer.class;
                    return String.class;
                }
   };
   modeloOrdenadoCaja= new TableRowSorter<TableModel>(modeloCaja);
   tablaCaja.setModel(modeloCaja);
   
   DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
    tcr.setHorizontalAlignment(SwingConstants.LEFT);
   tablaCaja.getColumnModel().getColumn(1).setCellRenderer(tcr);
   tablaCaja.getColumnModel().getColumn(8).setCellRenderer(tcr);
   tablaCaja.setRowSorter(modeloOrdenadoCaja);
   tablaCaja.getColumnModel().getColumn(1).setMaxWidth(100);
   tablaCaja.getColumnModel().getColumn(2).setMaxWidth(50);
   actualizarSaldos();
                                }
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void menuRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegistroActionPerformed

        try {
        PantallaEventos pantaEventos=new PantallaEventos();
        ArrayList<Eventos> listaEventos=GestorEventos.consultarEventos();
        ModeloTablaEventos modeloE=new ModeloTablaEventos(listaEventos);
        pantaEventos.tablaEventos.setModel(modeloE);
        pantaEventos.tablaEventos.getColumnModel().getColumn(0).setPreferredWidth(140);
        pantaEventos.tablaEventos.getColumnModel().getColumn(1).setPreferredWidth(90);
        pantaEventos.tablaEventos.getColumnModel().getColumn(3).setPreferredWidth(140);
        pantaEventos.tablaEventos.getColumnModel().getColumn(0).setMaxWidth(200);
        pantaEventos.tablaEventos.getColumnModel().getColumn(1).setMaxWidth(200);
        pantaEventos.tablaEventos.getColumnModel().getColumn(3).setMaxWidth(150);
        pantaEventos.setVisible(true);
            
            
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuRegistroActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        JFileChooser copiaSeguridad=new JFileChooser("C:\\Users\\Nahuel\\Desktop\\SM Inmobiliaria\\src\\BackUp");
       copiaSeguridad.setDialogTitle("Seleccione donde desea guardar la Copia de Seguridad");
       copiaSeguridad.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
       copiaSeguridad.setFileFilter(new FileNameExtensionFilter("todos los archivos *.sql", "sql","SQL"));

       
       int seleccion=copiaSeguridad.showSaveDialog(contentPane);
       if(seleccion==JFileChooser.APPROVE_OPTION){
           File archivo=copiaSeguridad.getSelectedFile();
           String rutaBackup=copiaSeguridad.getSelectedFile().getAbsolutePath(); 
           new BackUp().backup(rutaBackup);
           
       }

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained

     
        SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
        Calendar ahora= Calendar.getInstance();
   
        int diaActual=ahora.get(Calendar.DATE);
        int mesActual=ahora.get((Calendar.MONTH));
        int añoActual=ahora.get(Calendar.YEAR);
    //Cargamos tabla Caja
   String periodo=diaActual+"/"+(mesActual+1)+"/"+añoActual+"%";   
   ArrayList listaCaja=GestorMovimientos.consultaTablaPorEstado(periodo);
   ModeloTablaCaja modeloCaja=new ModeloTablaCaja(listaCaja){
       @Override
                public Class getColumnClass(int columna) {
                    if (columna == 1 || columna == 2 || columna == 8 || columna == 9)
                        return Integer.class;
                    return String.class;
                }
   };
   modeloOrdenadoCaja= new TableRowSorter<TableModel>(modeloCaja);
   tablaCaja.setModel(modeloCaja);
   
   DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
    tcr.setHorizontalAlignment(SwingConstants.LEFT);
   tablaCaja.getColumnModel().getColumn(1).setCellRenderer(tcr);
   tablaCaja.getColumnModel().getColumn(8).setCellRenderer(tcr);
   tablaCaja.setRowSorter(modeloOrdenadoCaja);
   tablaCaja.getColumnModel().getColumn(1).setMaxWidth(100);
   tablaCaja.getColumnModel().getColumn(2).setMaxWidth(50);
   actualizarSaldos();

        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed

           Alerta alerta=new Alerta();
        
        try {
            Calendar ahora= Calendar.getInstance();
        String dmy = ahora.get(Calendar.DATE)+"/"+(ahora.get(Calendar.MONTH)+1)+"/"+ahora.get(Calendar.YEAR);
        ArrayList<Contrato> listaContratos=GestoresContrato.consultaPorEstado("Activo");
        DefaultTableModel modeloAlerta= (DefaultTableModel) alerta.tablaAlerta.getModel();
        
        TableColumnModel columnModel = tablaAlerta.getColumnModel();
       for(int i=0;i<alerta.tablaAlerta.getColumnCount();i++){
           columnModel.getColumn(i).setCellRenderer(new RenderAlerta());
           alerta.tablaAlerta.getColumnModel().getColumn(i).setHeaderRenderer(new RenderAlertaTitulo());
           
       }
       for(int i=0;i<listaContratos.size();i++){
            String vencimiento=listaContratos.get(i).getFechaVencimiento();
            int dias;
            dias = fechas.cantidadDias(dmy,vencimiento);

            ArrayList<Parametros> parametro=GestorParametros.consultaParametros();
            int d=parametro.get(0).getDiasAlerta();
            if(dias<=d){
               
                    modeloAlerta.addRow(new Object[]{listaContratos.get(i).getIdContrato(),listaContratos.get(i).getFechaVencimiento(),
                    listaContratos.get(i).getInmueble().getCalle(),
                    listaContratos.get(i).getInmueble().getPropietario().getApellido()+" "+listaContratos.get(i).getInmueble().getPropietario().getNombre(),
                    listaContratos.get(i).getInquilino().getApellido()+" "+listaContratos.get(i).getInquilino().getNombre(),dias});
                
                
            }
        }

             alerta.setLocationRelativeTo(null);
            alerta.setVisible(true);
        
       
        
        } catch (ParseException ex) {
            Logger.getLogger(PrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        


        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        AltaInmueble altaInmueble=new AltaInmueble();
        altaInmueble.setLocationRelativeTo(null);
        altaInmueble.pack();
        altaInmueble.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

AltaPropietario alta=new AltaPropietario();
       alta.setLocationRelativeTo(null);
       alta.pack();
       alta.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

  AltaInquilino altaInquilino=new AltaInquilino();
        altaInquilino.setLocationRelativeTo(null);
        altaInquilino.pack();
        altaInquilino.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed

 AltaGarante altaGarante=new AltaGarante();
        altaGarante.setLocationRelativeTo(null);
        altaGarante.pack();
        altaGarante.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed


        ModificarContraseña modificar=new ModificarContraseña();
        modificar.lblUsuario.setText(InicioSesion.usuarioEnSesion.getUsuario());
        modificar.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void menuAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgregarUsuarioActionPerformed

        AgregarUsuario agregar=new AgregarUsuario();
        agregar.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_menuAgregarUsuarioActionPerformed

    private void menuEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminarUsuarioActionPerformed

        EliminarUsuario eliminar=new EliminarUsuario();
        eliminar.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_menuEliminarUsuarioActionPerformed

    private void menuRecuperarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRecuperarUsuarioActionPerformed

        RecuperarUsuario recuperar=new RecuperarUsuario();
        recuperar.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_menuRecuperarUsuarioActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed

        ListaRecuperarInmueble recuperarInm=new ListaRecuperarInmueble();
        recuperarInm.pack();
        recuperarInm.setLocationRelativeTo(null);
        recuperarInm.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed

        RecuperarCliente listaClientes=new RecuperarCliente();
        listaClientes.pack();
        listaClientes.setLocationRelativeTo(null);
        listaClientes.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        this.setCursor(Cursor.WAIT_CURSOR);
        try{
            conexion.ConexionReporte con=new conexion.ConexionReporte();

            JasperReport listaInmuebles=JasperCompileManager.compileReport("C:\\Users\\Nahuel\\Desktop\\SM Inmobiliaria\\src\\Recibos\\listaInmueblesDisponibles.jrxml");           
            JasperPrint jasperPrint=JasperFillManager.fillReport(listaInmuebles, null, con.conexion());
            
            
            inmueblesDisponibles.setSize(1000,1150);
            inmueblesDisponibles.setLocationRelativeTo(null);
            JRViewer jrv=new JRViewer(jasperPrint);
            inmueblesDisponibles.getContentPane().add(jrv);
            inmueblesDisponibles.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(PrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRestaurarActionPerformed

       JFileChooser copiaSeguridad=new JFileChooser("C:\\Users\\Nahuel\\Desktop\\SM Inmobiliaria\\src\\BackUp");
       copiaSeguridad.setDialogTitle("Seleccione la Copia de Seguridad");
       copiaSeguridad.setFileSelectionMode(JFileChooser.FILES_ONLY); 
       copiaSeguridad.setFileFilter(new FileNameExtensionFilter("todos los archivos *.sql", "sql","SQL"));

       
       int seleccion=copiaSeguridad.showOpenDialog(contentPane);
       if(seleccion==JFileChooser.APPROVE_OPTION){
           File archivo=copiaSeguridad.getSelectedFile();
           String rutaResotre=archivo.getPath();
           new BackUp().restore(rutaResotre);
       }

       
       
       
       
        // TODO add your handling code here:
    }//GEN-LAST:event_menuRestaurarActionPerformed

    private void comboBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBusquedaActionPerformed

    private void menuBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBuscarClienteActionPerformed

        PantallaBusquedaCliente busquedaCliente=new PantallaBusquedaCliente();
        busquedaCliente.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_menuBuscarClienteActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyTyped

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased

        
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowLostFocus

    private void menuParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuParametrosActionPerformed

        ParametrosSistema pantaParametros=new ParametrosSistema();
        pantaParametros.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_menuParametrosActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

         ListaCargaImpuestos adminImp=new ListaCargaImpuestos();
        adminImp.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

   RecuperarImpuesto recImp=new RecuperarImpuesto();
        recImp.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed

        
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void menuManualUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuManualUsuarioActionPerformed

         try {
            File path = new File("C:\\Users\\Nahuel\\Desktop\\SM Inmobiliaria\\src\\Manual\\Manual.pdf");
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_menuManualUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               PrincipalAdministrador principal;
                try {
                    principal = new PrincipalAdministrador();               
                    principal.pack();               
                    principal.setVisible(true);           
                }catch (ParseException ex) {
                    Logger.getLogger(PrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);       
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnCrearGarante;
    public static javax.swing.JButton btnCrearInmueble;
    public static javax.swing.JButton btnCrearInquilino;
    public static javax.swing.JButton btnCrearPropietario;
    public static javax.swing.JButton btnNuevoContrato;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JComboBox<String> comboBusqueda;
    private javax.swing.JComboBox<String> comboContratos;
    private javax.swing.JTextField datos;
    private javax.swing.JTextField inmABuscar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JMenu menuAdminImpuestos;
    public static javax.swing.JMenuItem menuAgregarUsuario;
    public static javax.swing.JMenu menuBackup;
    private javax.swing.JMenuItem menuBuscarCliente;
    public static javax.swing.JMenuItem menuCrearContrato;
    public static javax.swing.JMenuItem menuEliminarUsuario;
    public static javax.swing.JMenu menuInmuebles;
    private javax.swing.JMenuItem menuManualUsuario;
    public static javax.swing.JMenuItem menuParametros;
    public static javax.swing.JMenu menuPersonas;
    public static javax.swing.JMenuItem menuRecuperarUsuario;
    public static javax.swing.JMenuItem menuRegistro;
    public static javax.swing.JMenuItem menuRestaurar;
    public static javax.swing.JTable tablaCaja;
    public static javax.swing.JTable tablaContratos;
    public static javax.swing.JTable tablaGarantes;
    private javax.swing.JTable tablaInquilinos;
    private javax.swing.JTable tablaPropietarios;
    private javax.swing.JTable table;
    private static javax.swing.JTextField txtGanancia;
    private static javax.swing.JTextField txtHonorarios;
    private static javax.swing.JTextField txtTotalCobrado;
    private static javax.swing.JTextField txtTotalPagado;
    // End of variables declaration//GEN-END:variables

    private ArrayList listaInmueble=new ArrayList();
    public static int x=0;


                
     public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/SM.png"));


        return retValue;
    }
	
     public static String inicioCon;
     
     public static int idConsAsociado;
     
     public static int idInmDatos;
     
     public static Inmueble datosInmueble;
     
     public static int punitorios;
     public static int diaPago;

     
     
     public static void actualizarSaldos(){
         
        double totalCobrado=0;
        double totalPagado=0;
        double honorarios=0;
        for(int i=0; i<tablaCaja.getRowCount();i++){
            if(tablaCaja.getValueAt(i,7).equals("Ingreso")){
                String cobrado=tablaCaja.getValueAt(i,8).toString();
                totalCobrado=totalCobrado+Double.parseDouble(cobrado);
            }else{
               String pagado=tablaCaja.getValueAt(i,8).toString();
               totalPagado=totalPagado+Double.parseDouble(pagado); 
            }            
        }
   
        for(int i=0; i<tablaCaja.getRowCount();i++){
            if(tablaCaja.getValueAt(i,9).equals(" ")){
                honorarios=honorarios+0;
            }else{
                honorarios=honorarios+Double.parseDouble((String) tablaCaja.getValueAt(i,9));
            }            
        }
        
        double ganancia=totalCobrado-totalPagado;
        
        DecimalFormat df= new DecimalFormat("#0.00");


        txtTotalCobrado.setText(df.format(totalCobrado));
        txtTotalPagado.setText(df.format(totalPagado));
        txtGanancia.setText(df.format(ganancia));
        txtHonorarios.setText(df.format(honorarios));
        
     }

     


}
