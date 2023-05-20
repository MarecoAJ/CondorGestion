/*
* este JFrame registra (agrega, borra, edita, busca y filtra) todos las marcas de vehiculos
 */
package Vistas;

import administradorClases.Administrador;
import administradorClases.AdministradorMarcaVehiculo;
import clasesDatos.MarcaVehiculo;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class JFrameRegistroMarcasVehiculos extends javax.swing.JFrame {
// atributos y variables    
    private final AdministradorMarcaVehiculo _administradorMarcaVehiculo;
    private MarcaVehiculo _objMarcaVehiculo;
    private TableModel modeloTablaMV;
    private String codMarcaVehObtenido;
    private String antModCodMarcaVehObtenido; 
    private int auxAbm;
    
    public JFrameRegistroMarcasVehiculos() {
        initComponents();
// se personaliza las fuentes de letra de los objetos grafico
        jLabelTituloVentana.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 8));
        jLabelTituloIuMarcaVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldCodMarcaVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloDescrMarcaVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldDescrMarcaVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloBuscarMarcaVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldBuscarMarcaVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
         
        jLabelMensajeElementoExistente.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeElementoExistente2.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));         
        jLabelMensajeItemNoSeleccionado.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeErrorBaseDeDatos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));         
        jLabelMensajeErrorBaseDeDatos1.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeGuardadoErroneo.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeGuardadoErroneo2.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeGuardadoCorrecto.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeValidarCambios.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeValidarCambios1.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeUno.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeDos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
// se personaliza el jTable    
        jTableMarcaVehiculo.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 6));
        JTableHeader auxJTableHeader;
        auxJTableHeader = jTableMarcaVehiculo.getTableHeader();
        auxJTableHeader.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
// se instancia la clase AdministradorMarcaVehiculo y se inicializa el menu del jTable
        _administradorMarcaVehiculo = new AdministradorMarcaVehiculo();
        popupMenuJTable();
        jButtonBorrarMarcaVeh.setEnabled(false);
        jButtonEditarMarcaVeh.setEnabled(false);
        
        jPanelCuerpo.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{
            jTextFieldCodMarcaVeh, jTextFieldDescrMarcaVeh}));
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelItemNoSeleccionado = new javax.swing.JPanel();
        jButtonAceptarItemNoSeleccionado2 = new javax.swing.JButton();
        jLabelIconoErrorItemNoSeleccionado = new javax.swing.JLabel();
        jLabelMensajeItemNoSeleccionado = new javax.swing.JLabel();
        jLabelFondoIconoItemNoSeleccionado = new javax.swing.JLabel();
        jPanelElementoExistente = new javax.swing.JPanel();
        jButtonAceptarElementoExistente = new javax.swing.JButton();
        jLabelIconoErrorElementoExistente = new javax.swing.JLabel();
        jLabelMensajeElementoExistente = new javax.swing.JLabel();
        jLabelMensajeElementoExistente2 = new javax.swing.JLabel();
        jLabelFondoIconoElementoExitente = new javax.swing.JLabel();
        jPanelErrorBaseDeDatos = new javax.swing.JPanel();
        jButtonAceptarErrorBaseDeDatos = new javax.swing.JButton();
        jLabelIconoErrorBaseDeDatos = new javax.swing.JLabel();
        jLabelMensajeErrorBaseDeDatos = new javax.swing.JLabel();
        jLabelMensajeErrorBaseDeDatos1 = new javax.swing.JLabel();
        jLabelFondoIconoErrorBaseDeDatos = new javax.swing.JLabel();
        jPanelGuardadoErroneo = new javax.swing.JPanel();
        jButtonAceptarGuardadoErroneo = new javax.swing.JButton();
        jLabelIconoError = new javax.swing.JLabel();
        jLabelMensajeGuardadoErroneo = new javax.swing.JLabel();
        jLabelMensajeGuardadoErroneo2 = new javax.swing.JLabel();
        jLabelFondoIconoGuardadoErroneo = new javax.swing.JLabel();
        jPanelGuardadoExitoso = new javax.swing.JPanel();
        jButtonAceptarGuardadoExitoso = new javax.swing.JButton();
        jLabelIconoExito = new javax.swing.JLabel();
        jLabelMensajeGuardadoCorrecto = new javax.swing.JLabel();
        jLabelFondoIconoGuardadoExitoso = new javax.swing.JLabel();
        jPanelMensajeValidarABM = new javax.swing.JPanel();
        jButtonCancelarValidarCambios = new javax.swing.JButton();
        jButtonAceptarValidarCambios = new javax.swing.JButton();
        jLabelIconoAlertaValidarCambios = new javax.swing.JLabel();
        jLabelMensajeValidarCambios = new javax.swing.JLabel();
        jLabelMensajeValidarCambios1 = new javax.swing.JLabel();
        jLabelFondoIconoMensajeValidarCambios = new javax.swing.JLabel();
        jPanelMensajeCerrar = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jLabelIconoAlerta = new javax.swing.JLabel();
        jLabelMensajeUno = new javax.swing.JLabel();
        jLabelMensajeDos = new javax.swing.JLabel();
        jLabelFondoIconoMensajeCerrar = new javax.swing.JLabel();
        jPanelVentanaBuscar = new javax.swing.JPanel();
        jSeparatorBuscarMarcaVeh = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMarcaVehiculo = new javax.swing.JTable();
        jLabelTituloBuscarMarcaVeh = new javax.swing.JLabel();
        jTextFieldBuscarMarcaVeh = new javax.swing.JTextField();
        jButtonTraerPanelCuerpo = new javax.swing.JButton();
        jLabelFondoVentanaBuscar = new javax.swing.JLabel();
        jPanelCuerpo = new javax.swing.JPanel();
        jLabelTituloDescrMarcaVeh = new javax.swing.JLabel();
        jTextFieldDescrMarcaVeh = new javax.swing.JTextField();
        jSeparatorDescrMarcaVeh = new javax.swing.JSeparator();
        jSeparatorIuMarcaVeh = new javax.swing.JSeparator();
        jLabelTituloIuMarcaVeh = new javax.swing.JLabel();
        jTextFieldCodMarcaVeh = new javax.swing.JTextField();
        jButtonAgregarMarcaVeh = new javax.swing.JButton();
        jButtonEditarMarcaVeh = new javax.swing.JButton();
        jButtonBorrarMarcaVeh = new javax.swing.JButton();
        jButtonTraerPanelBuscar = new javax.swing.JButton();
        jLabelIconoFondoCuerpo = new javax.swing.JLabel();
        jPanelBarraTitulo = new javax.swing.JPanel();
        jLabelTituloVentana = new javax.swing.JLabel();
        jButtonMinimizar = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();
        jLabelIconoBarraTitulo = new javax.swing.JLabel();
        jLabelToolKitMarca = new javax.swing.JLabel();
        jLabelIconoFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(700, 256));
        setMinimumSize(new java.awt.Dimension(700, 256));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(700, 256));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 256));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelItemNoSeleccionado.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelItemNoSeleccionado.setMinimumSize(new java.awt.Dimension(250, 100));
        jPanelItemNoSeleccionado.setOpaque(false);
        jPanelItemNoSeleccionado.setPreferredSize(new java.awt.Dimension(250, 100));
        jPanelItemNoSeleccionado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarItemNoSeleccionado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarItemNoSeleccionado2.setToolTipText("Has click para continuar.");
        jButtonAceptarItemNoSeleccionado2.setBorder(null);
        jButtonAceptarItemNoSeleccionado2.setBorderPainted(false);
        jButtonAceptarItemNoSeleccionado2.setContentAreaFilled(false);
        jButtonAceptarItemNoSeleccionado2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarItemNoSeleccionado2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarItemNoSeleccionado2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarItemNoSeleccionado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarItemNoSeleccionado2ActionPerformed(evt);
            }
        });
        jPanelItemNoSeleccionado.add(jButtonAceptarItemNoSeleccionado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorItemNoSeleccionado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelItemNoSeleccionado.add(jLabelIconoErrorItemNoSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeItemNoSeleccionado.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeItemNoSeleccionado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeItemNoSeleccionado.setText("No selecciono un item de la tabla.");
        jPanelItemNoSeleccionado.add(jLabelMensajeItemNoSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 20, 200, 25));

        jLabelFondoIconoItemNoSeleccionado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelItemNoSeleccionado.add(jLabelFondoIconoItemNoSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        getContentPane().add(jPanelItemNoSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 100, 250, 100));

        jPanelElementoExistente.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelElementoExistente.setMinimumSize(new java.awt.Dimension(250, 100));
        jPanelElementoExistente.setOpaque(false);
        jPanelElementoExistente.setPreferredSize(new java.awt.Dimension(250, 100));
        jPanelElementoExistente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarElementoExistente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarElementoExistente.setToolTipText("Has click para continuar.");
        jButtonAceptarElementoExistente.setBorder(null);
        jButtonAceptarElementoExistente.setBorderPainted(false);
        jButtonAceptarElementoExistente.setContentAreaFilled(false);
        jButtonAceptarElementoExistente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarElementoExistente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarElementoExistente.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarElementoExistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarElementoExistenteActionPerformed(evt);
            }
        });
        jPanelElementoExistente.add(jButtonAceptarElementoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorElementoExistente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelElementoExistente.add(jLabelIconoErrorElementoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeElementoExistente.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeElementoExistente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeElementoExistente.setText("No se guardo.");
        jPanelElementoExistente.add(jLabelMensajeElementoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeElementoExistente2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeElementoExistente2.setText(" Revise. Los datos ya existen.");
        jPanelElementoExistente.add(jLabelMensajeElementoExistente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 35, -1, 25));

        jLabelFondoIconoElementoExitente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelElementoExistente.add(jLabelFondoIconoElementoExitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        getContentPane().add(jPanelElementoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 100, 250, 100));

        jPanelErrorBaseDeDatos.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelErrorBaseDeDatos.setMinimumSize(new java.awt.Dimension(250, 100));
        jPanelErrorBaseDeDatos.setOpaque(false);
        jPanelErrorBaseDeDatos.setPreferredSize(new java.awt.Dimension(250, 100));
        jPanelErrorBaseDeDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarErrorBaseDeDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarErrorBaseDeDatos.setToolTipText("Has click para continuar.");
        jButtonAceptarErrorBaseDeDatos.setBorder(null);
        jButtonAceptarErrorBaseDeDatos.setBorderPainted(false);
        jButtonAceptarErrorBaseDeDatos.setContentAreaFilled(false);
        jButtonAceptarErrorBaseDeDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarErrorBaseDeDatos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarErrorBaseDeDatos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarErrorBaseDeDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarErrorBaseDeDatosActionPerformed(evt);
            }
        });
        jPanelErrorBaseDeDatos.add(jButtonAceptarErrorBaseDeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorBaseDeDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelErrorBaseDeDatos.add(jLabelIconoErrorBaseDeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeErrorBaseDeDatos.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeErrorBaseDeDatos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeErrorBaseDeDatos.setText("Verifique que la Base de datos ");
        jPanelErrorBaseDeDatos.add(jLabelMensajeErrorBaseDeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 190, 25));

        jLabelMensajeErrorBaseDeDatos1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeErrorBaseDeDatos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeErrorBaseDeDatos1.setText("este conectada. Vuelva a intentar.");
        jPanelErrorBaseDeDatos.add(jLabelMensajeErrorBaseDeDatos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 35, 200, 25));

        jLabelFondoIconoErrorBaseDeDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelErrorBaseDeDatos.add(jLabelFondoIconoErrorBaseDeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        getContentPane().add(jPanelErrorBaseDeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 100, 250, 100));

        jPanelGuardadoErroneo.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelGuardadoErroneo.setMinimumSize(new java.awt.Dimension(250, 100));
        jPanelGuardadoErroneo.setOpaque(false);
        jPanelGuardadoErroneo.setPreferredSize(new java.awt.Dimension(250, 100));
        jPanelGuardadoErroneo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarGuardadoErroneo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarGuardadoErroneo.setToolTipText("Has click para continuar.");
        jButtonAceptarGuardadoErroneo.setBorder(null);
        jButtonAceptarGuardadoErroneo.setBorderPainted(false);
        jButtonAceptarGuardadoErroneo.setContentAreaFilled(false);
        jButtonAceptarGuardadoErroneo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarGuardadoErroneo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarGuardadoErroneo.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarGuardadoErroneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarGuardadoErroneoActionPerformed(evt);
            }
        });
        jPanelGuardadoErroneo.add(jButtonAceptarGuardadoErroneo, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelGuardadoErroneo.add(jLabelIconoError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeGuardadoErroneo.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeGuardadoErroneo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeGuardadoErroneo.setText("No se guardo.");
        jPanelGuardadoErroneo.add(jLabelMensajeGuardadoErroneo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeGuardadoErroneo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeGuardadoErroneo2.setText(" Revise los datos ingresados.");
        jPanelGuardadoErroneo.add(jLabelMensajeGuardadoErroneo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 35, -1, 25));

        jLabelFondoIconoGuardadoErroneo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelGuardadoErroneo.add(jLabelFondoIconoGuardadoErroneo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        getContentPane().add(jPanelGuardadoErroneo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 100, 250, 100));

        jPanelGuardadoExitoso.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelGuardadoExitoso.setMinimumSize(new java.awt.Dimension(250, 100));
        jPanelGuardadoExitoso.setOpaque(false);
        jPanelGuardadoExitoso.setPreferredSize(new java.awt.Dimension(250, 100));
        jPanelGuardadoExitoso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarGuardadoExitoso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarGuardadoExitoso.setToolTipText("Has click para continuar.");
        jButtonAceptarGuardadoExitoso.setBorder(null);
        jButtonAceptarGuardadoExitoso.setBorderPainted(false);
        jButtonAceptarGuardadoExitoso.setContentAreaFilled(false);
        jButtonAceptarGuardadoExitoso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarGuardadoExitoso.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarGuardadoExitoso.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarGuardadoExitoso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarGuardadoExitosoActionPerformed(evt);
            }
        });
        jPanelGuardadoExitoso.add(jButtonAceptarGuardadoExitoso, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoExito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoExito25x25.png"))); // NOI18N
        jPanelGuardadoExitoso.add(jLabelIconoExito, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeGuardadoCorrecto.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeGuardadoCorrecto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeGuardadoCorrecto.setText("Se guardo exitosamente.");
        jPanelGuardadoExitoso.add(jLabelMensajeGuardadoCorrecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 160, 25));

        jLabelFondoIconoGuardadoExitoso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelGuardadoExitoso.add(jLabelFondoIconoGuardadoExitoso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        getContentPane().add(jPanelGuardadoExitoso, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 100, 250, 100));

        jPanelMensajeValidarABM.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelMensajeValidarABM.setOpaque(false);
        jPanelMensajeValidarABM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCancelarValidarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOff.png"))); // NOI18N
        jButtonCancelarValidarCambios.setToolTipText("Has click para volver.");
        jButtonCancelarValidarCambios.setBorder(null);
        jButtonCancelarValidarCambios.setBorderPainted(false);
        jButtonCancelarValidarCambios.setContentAreaFilled(false);
        jButtonCancelarValidarCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelarValidarCambios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOn.png"))); // NOI18N
        jButtonCancelarValidarCambios.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOn.png"))); // NOI18N
        jButtonCancelarValidarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarValidarCambiosActionPerformed(evt);
            }
        });
        jPanelMensajeValidarABM.add(jButtonCancelarValidarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        jButtonAceptarValidarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarValidarCambios.setToolTipText("Has click para continuar.");
        jButtonAceptarValidarCambios.setBorder(null);
        jButtonAceptarValidarCambios.setBorderPainted(false);
        jButtonAceptarValidarCambios.setContentAreaFilled(false);
        jButtonAceptarValidarCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarValidarCambios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarValidarCambios.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarValidarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarValidarCambiosActionPerformed(evt);
            }
        });
        jPanelMensajeValidarABM.add(jButtonAceptarValidarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabelIconoAlertaValidarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelMensajeValidarABM.add(jLabelIconoAlertaValidarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeValidarCambios.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeValidarCambios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeValidarCambios.setText("Revise los datos antes.");
        jPanelMensajeValidarABM.add(jLabelMensajeValidarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeValidarCambios1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeValidarCambios1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeValidarCambios1.setText("¿Seguro de realizar esta acción? ");
        jPanelMensajeValidarABM.add(jLabelMensajeValidarCambios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 35, 190, 25));

        jLabelFondoIconoMensajeValidarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelMensajeValidarABM.add(jLabelFondoIconoMensajeValidarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        getContentPane().add(jPanelMensajeValidarABM, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 100, 250, 100));

        jPanelMensajeCerrar.setOpaque(false);
        jPanelMensajeCerrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOff.png"))); // NOI18N
        jButtonCancelar.setToolTipText("Has click para volver.");
        jButtonCancelar.setBorder(null);
        jButtonCancelar.setBorderPainted(false);
        jButtonCancelar.setContentAreaFilled(false);
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOn.png"))); // NOI18N
        jButtonCancelar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOn.png"))); // NOI18N
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelMensajeCerrar.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptar.setToolTipText("Has click para continuar.");
        jButtonAceptar.setBorder(null);
        jButtonAceptar.setBorderPainted(false);
        jButtonAceptar.setContentAreaFilled(false);
        jButtonAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });
        jPanelMensajeCerrar.add(jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabelIconoAlerta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelMensajeCerrar.add(jLabelIconoAlerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 32, -1, -1));

        jLabelMensajeUno.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeUno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeUno.setText("Se pueden perder datos. ");
        jPanelMensajeCerrar.add(jLabelMensajeUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeDos.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeDos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeDos.setText("Guarde antes de ACEPTAR");
        jPanelMensajeCerrar.add(jLabelMensajeDos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 35, 160, 25));

        jLabelFondoIconoMensajeCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelMensajeCerrar.add(jLabelFondoIconoMensajeCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        getContentPane().add(jPanelMensajeCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, 100, 250, 100));

        jPanelVentanaBuscar.setBackground(new java.awt.Color(245, 245, 245));
        jPanelVentanaBuscar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanelVentanaBuscar.setMaximumSize(new java.awt.Dimension(500, 270));
        jPanelVentanaBuscar.setMinimumSize(new java.awt.Dimension(500, 270));
        jPanelVentanaBuscar.setOpaque(false);
        jPanelVentanaBuscar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparatorBuscarMarcaVeh.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorBuscarMarcaVeh.setForeground(new java.awt.Color(0, 0, 0));
        jPanelVentanaBuscar.add(jSeparatorBuscarMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 55, 100, 2));

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));

        jTableMarcaVehiculo = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jTableMarcaVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Cod. marca", "Descripcion"
            }
        ));
        jTableMarcaVehiculo.setToolTipText("Has click derecho para opciones.");
        jTableMarcaVehiculo.setAutoscrolls(false);
        jTableMarcaVehiculo.setFocusable(false);
        jTableMarcaVehiculo.setMaximumSize(new java.awt.Dimension(480, 250));
        jTableMarcaVehiculo.setMinimumSize(new java.awt.Dimension(480, 250));
        jTableMarcaVehiculo.setPreferredSize(new java.awt.Dimension(480, 250));
        jTableMarcaVehiculo.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jTableMarcaVehiculo.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jTableMarcaVehiculo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableMarcaVehiculo);

        jPanelVentanaBuscar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 480, 146));

        jLabelTituloBuscarMarcaVeh.setText("Parametro de busqueda:");
        jPanelVentanaBuscar.add(jLabelTituloBuscarMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 10, -1, 25));

        jTextFieldBuscarMarcaVeh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBuscarMarcaVeh.setToolTipText("ingresa parametros de busqueda. Ej: chev");
        jTextFieldBuscarMarcaVeh.setBorder(null);
        jTextFieldBuscarMarcaVeh.setDisabledTextColor(new java.awt.Color(194, 4, 48));
        jTextFieldBuscarMarcaVeh.setOpaque(false);
        jTextFieldBuscarMarcaVeh.setSelectionColor(new java.awt.Color(73, 73, 73));
        jTextFieldBuscarMarcaVeh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarMarcaVehKeyReleased(evt);
            }
        });
        jPanelVentanaBuscar.add(jTextFieldBuscarMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 35, 100, 20));

        jButtonTraerPanelCuerpo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOff.png"))); // NOI18N
        jButtonTraerPanelCuerpo.setToolTipText("Has click para volver al area de carga.");
        jButtonTraerPanelCuerpo.setBorder(null);
        jButtonTraerPanelCuerpo.setBorderPainted(false);
        jButtonTraerPanelCuerpo.setContentAreaFilled(false);
        jButtonTraerPanelCuerpo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTraerPanelCuerpo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOn.png"))); // NOI18N
        jButtonTraerPanelCuerpo.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOn.png"))); // NOI18N
        jButtonTraerPanelCuerpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTraerPanelCuerpoActionPerformed(evt);
            }
        });
        jPanelVentanaBuscar.add(jButtonTraerPanelCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 10, -1, -1));

        jLabelFondoVentanaBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondoCuerpo500x226.png"))); // NOI18N
        jLabelFondoVentanaBuscar.setToolTipText("");
        jPanelVentanaBuscar.add(jLabelFondoVentanaBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 226));

        getContentPane().add(jPanelVentanaBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, 30, 500, 270));

        jPanelCuerpo.setMaximumSize(new java.awt.Dimension(500, 270));
        jPanelCuerpo.setMinimumSize(new java.awt.Dimension(500, 270));
        jPanelCuerpo.setOpaque(false);
        jPanelCuerpo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTituloDescrMarcaVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloDescrMarcaVeh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloDescrMarcaVeh.setText("Marca del vehiculo:");
        jLabelTituloDescrMarcaVeh.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloDescrMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 98, -1, 25));

        jTextFieldDescrMarcaVeh.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldDescrMarcaVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldDescrMarcaVeh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDescrMarcaVeh.setToolTipText("Ingrese solo alfanumericos y simbolos(-) o (.). Ej.: b-m.w");
        jTextFieldDescrMarcaVeh.setBorder(null);
        jTextFieldDescrMarcaVeh.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldDescrMarcaVeh.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldDescrMarcaVeh.setOpaque(false);
        jTextFieldDescrMarcaVeh.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldDescrMarcaVeh.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldDescrMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 118, 200, 20));

        jSeparatorDescrMarcaVeh.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorDescrMarcaVeh.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorDescrMarcaVeh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorDescrMarcaVeh.setOpaque(true);
        jPanelCuerpo.add(jSeparatorDescrMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 138, 200, -1));

        jSeparatorIuMarcaVeh.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuMarcaVeh.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuMarcaVeh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuMarcaVeh.setOpaque(true);
        jPanelCuerpo.add(jSeparatorIuMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 66, 100, -1));

        jLabelTituloIuMarcaVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuMarcaVeh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuMarcaVeh.setText("Codigo identificacion:");
        jLabelTituloIuMarcaVeh.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloIuMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 25, -1, 25));

        jTextFieldCodMarcaVeh.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldCodMarcaVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldCodMarcaVeh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCodMarcaVeh.setToolTipText("Ingrese solo numeros. Ej.: 08");
        jTextFieldCodMarcaVeh.setBorder(null);
        jTextFieldCodMarcaVeh.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldCodMarcaVeh.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldCodMarcaVeh.setOpaque(false);
        jTextFieldCodMarcaVeh.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldCodMarcaVeh.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldCodMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 45, 100, 20));

        jButtonAgregarMarcaVeh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOff.png"))); // NOI18N
        jButtonAgregarMarcaVeh.setToolTipText("Has click para agregar.");
        jButtonAgregarMarcaVeh.setBorder(null);
        jButtonAgregarMarcaVeh.setBorderPainted(false);
        jButtonAgregarMarcaVeh.setContentAreaFilled(false);
        jButtonAgregarMarcaVeh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregarMarcaVeh.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarMarcaVeh.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarMarcaVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarMarcaVehActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonAgregarMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 176, -1, -1));

        jButtonEditarMarcaVeh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOff.png"))); // NOI18N
        jButtonEditarMarcaVeh.setToolTipText("Has click para editar.");
        jButtonEditarMarcaVeh.setBorder(null);
        jButtonEditarMarcaVeh.setBorderPainted(false);
        jButtonEditarMarcaVeh.setContentAreaFilled(false);
        jButtonEditarMarcaVeh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditarMarcaVeh.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarMarcaVeh.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarMarcaVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarMarcaVehActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonEditarMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 176, -1, -1));

        jButtonBorrarMarcaVeh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOff.png"))); // NOI18N
        jButtonBorrarMarcaVeh.setToolTipText("Has click para borrar.");
        jButtonBorrarMarcaVeh.setBorder(null);
        jButtonBorrarMarcaVeh.setBorderPainted(false);
        jButtonBorrarMarcaVeh.setContentAreaFilled(false);
        jButtonBorrarMarcaVeh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBorrarMarcaVeh.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarMarcaVeh.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarMarcaVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarMarcaVehActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonBorrarMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 176, -1, -1));

        jButtonTraerPanelBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOff.png"))); // NOI18N
        jButtonTraerPanelBuscar.setToolTipText("Menu buscar");
        jButtonTraerPanelBuscar.setBorder(null);
        jButtonTraerPanelBuscar.setBorderPainted(false);
        jButtonTraerPanelBuscar.setContentAreaFilled(false);
        jButtonTraerPanelBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTraerPanelBuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOn.png"))); // NOI18N
        jButtonTraerPanelBuscar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOn.png"))); // NOI18N
        jButtonTraerPanelBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTraerPanelBuscarActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonTraerPanelBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 10, -1, -1));

        jLabelIconoFondoCuerpo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondoCuerpo500x226.png"))); // NOI18N
        jPanelCuerpo.add(jLabelIconoFondoCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 226));

        getContentPane().add(jPanelCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 500, 226));

        jPanelBarraTitulo.setMaximumSize(new java.awt.Dimension(700, 30));
        jPanelBarraTitulo.setMinimumSize(new java.awt.Dimension(700, 30));
        jPanelBarraTitulo.setOpaque(false);
        jPanelBarraTitulo.setPreferredSize(new java.awt.Dimension(700, 30));
        jPanelBarraTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTituloVentana.setFont(new java.awt.Font("Open Sans Extrabold", 0, 11)); // NOI18N
        jLabelTituloVentana.setForeground(new java.awt.Color(245, 245, 245));
        jLabelTituloVentana.setText("Registro de marcas de vehiculos");
        jPanelBarraTitulo.add(jLabelTituloVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 2, -1, 26));

        jButtonMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMinimizarOff.png"))); // NOI18N
        jButtonMinimizar.setToolTipText("Has click para minimizar.");
        jButtonMinimizar.setBorder(null);
        jButtonMinimizar.setBorderPainted(false);
        jButtonMinimizar.setContentAreaFilled(false);
        jButtonMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMinimizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMinimizarOn.png"))); // NOI18N
        jButtonMinimizar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMinimizarOn.png"))); // NOI18N
        jButtonMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinimizarActionPerformed(evt);
            }
        });
        jPanelBarraTitulo.add(jButtonMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 3, -1, -1));

        jButtonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonCerrarOff.png"))); // NOI18N
        jButtonCerrar.setToolTipText("Has click para cerrar.");
        jButtonCerrar.setBorder(null);
        jButtonCerrar.setBorderPainted(false);
        jButtonCerrar.setContentAreaFilled(false);
        jButtonCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonCerrarOn.png"))); // NOI18N
        jButtonCerrar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonCerrarOn.png"))); // NOI18N
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });
        jPanelBarraTitulo.add(jButtonCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 3, -1, -1));

        jLabelIconoBarraTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/barraTitulo700x30Radial.png"))); // NOI18N
        jPanelBarraTitulo.add(jLabelIconoBarraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanelBarraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 30));

        jLabelToolKitMarca.setToolTipText("Eldorado parabrisas");
        getContentPane().add(jLabelToolKitMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 196, 50, 50));

        jLabelIconoFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo700x256Logo.png"))); // NOI18N
        getContentPane().add(jLabelIconoFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 256));

        pack();
    }// </editor-fold>//GEN-END:initComponents

// se crea un objeto de la clase utilizada    
    public void crearObjMarcaVehiculo(){
     
        _objMarcaVehiculo = new MarcaVehiculo();
        _objMarcaVehiculo.setCodMarcaVeh(jTextFieldCodMarcaVeh.getText());
        _objMarcaVehiculo.setDescrMarcaVeh(jTextFieldDescrMarcaVeh.getText());
     }
      
// limpia los jtextfield usados
    public void limpiarCampos(){

        jTextFieldCodMarcaVeh.setText("");
        jTextFieldDescrMarcaVeh.setText(""); 
        }
     
// este metodo crea menu de opciones al usar click secundario   
    public final void popupMenuJTable(){
//se crean las opciones del menu
        JPopupMenu jPopupMenuTableHMV = new JPopupMenu();
        JMenuItem jMenuItemEliminarMarcaVehiculo = new JMenuItem("Eliminar"); // cambiar x ico 
        JMenuItem jMenuItemModificarMarcaVehiculo = new JMenuItem("Modificar");
        JMenuItem jMenuOrdenar = new JMenu("Ordenar por");
        JMenuItem jMenuItemPrimerosAgregados = new JMenuItem("Primeros agregados");
        JMenuItem jMenuItemUltimosAgregados= new JMenuItem("Ultimos agregados");
        JMenuItem jMenuItemAlfabeticos = new JMenuItem("Alfabeticos"); 
        jMenuOrdenar.add(jMenuItemPrimerosAgregados);
        jMenuOrdenar.add(jMenuItemUltimosAgregados); 
        jMenuOrdenar.add(jMenuItemAlfabeticos);
// se generan las acciones de cada opcion
        jMenuItemEliminarMarcaVehiculo.addActionListener((ActionEvent e) -> {
        
        if(seleccionarItemJTabla()!= -1){
                 
            jPanelVentanaBuscar.setBounds(-500, 30, 500, 270);
            jPanelCuerpo.setBounds( 100,30,  500, 270);
              
            jButtonAgregarMarcaVeh.setEnabled(false);
            jButtonEditarMarcaVeh.setEnabled(false);
            jTextFieldCodMarcaVeh.setEditable(false);
            jTextFieldDescrMarcaVeh.setEditable(false); 
            jButtonBorrarMarcaVeh.setEnabled(true);
             }
         });
         
        jMenuItemModificarMarcaVehiculo.addActionListener((ActionEvent e) -> {
            
        if(seleccionarItemJTabla()!= -1){
                     
            jPanelVentanaBuscar.setBounds(-500, 30, 500, 270);
            jPanelCuerpo.setBounds( 100,30,  500, 270);
                
            jButtonAgregarMarcaVeh.setEnabled(false);
            jButtonBorrarMarcaVeh.setEnabled(false);
            jTextFieldCodMarcaVeh.setEditable(false); 
            jButtonEditarMarcaVeh.setEnabled(true);
        }
        });
             
        jMenuItemUltimosAgregados.addActionListener((ActionEvent e) -> {
            _administradorMarcaVehiculo.ordenarTabla(jMenuItemUltimosAgregados.getText());
            jTableMarcaVehiculo.setModel( _administradorMarcaVehiculo.cargarJTabla());
        });
                
        jMenuItemAlfabeticos.addActionListener((ActionEvent e) -> {
            _administradorMarcaVehiculo.ordenarTabla(jMenuItemAlfabeticos.getText());
            jTableMarcaVehiculo.setModel( _administradorMarcaVehiculo.cargarJTabla());
        });
                                
        jMenuItemPrimerosAgregados.addActionListener((ActionEvent e) -> {
            _administradorMarcaVehiculo.ordenarTabla(jMenuItemPrimerosAgregados.getText());
            jTableMarcaVehiculo.setModel( _administradorMarcaVehiculo.cargarJTabla());
        });
// se construye el menu completo y se le asigna si jTable
        jPopupMenuTableHMV.add(jMenuItemEliminarMarcaVehiculo);
        jPopupMenuTableHMV.add(jMenuItemModificarMarcaVehiculo);
        jPopupMenuTableHMV.add(jMenuOrdenar);
        jTableMarcaVehiculo.setComponentPopupMenu(jPopupMenuTableHMV);  
     }
 
// se obtiene los datos del item seleccionado en la tabla
    public int seleccionarItemJTabla(){
// se obtiene el modelo y se verifica que se haya seleccionado un item   
        modeloTablaMV = jTableMarcaVehiculo.getModel();
        int auxSeleccion = jTableMarcaVehiculo.getSelectedRow();
        if (auxSeleccion != -1) {
            jTableMarcaVehiculo.setEnabled(true);
// se cargan los campos con los valores selcionados
            codMarcaVehObtenido =  (String)modeloTablaMV.getValueAt(jTableMarcaVehiculo.getSelectedRow(), 0);
            antModCodMarcaVehObtenido = codMarcaVehObtenido;
            jTextFieldCodMarcaVeh.setText(codMarcaVehObtenido);
            jTextFieldDescrMarcaVeh.setText((String)modeloTablaMV.getValueAt(jTableMarcaVehiculo.getSelectedRow(), 1));
            return auxSeleccion;
            
        }else {
// si no selecciona mensaje error 
            jTableMarcaVehiculo.setEnabled(false);
            jPanelItemNoSeleccionado.setBounds(225, 100, 250,100);
            return auxSeleccion;
        }
    }
    
//visualiza el panel buscar
    private void jButtonTraerPanelBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelBuscarActionPerformed
// llama al panel buscar 
    try {
        jTableMarcaVehiculo.setModel(_administradorMarcaVehiculo.cargarJTabla());
    } catch (Exception e) {
        jPanelErrorBaseDeDatos.setBounds(225, 100, 250, 100);
    }
        jPanelCuerpo.setBounds(-500, 30, 500, 270);
        jPanelVentanaBuscar.setBounds( 100,30,  500, 270);      
    }//GEN-LAST:event_jButtonTraerPanelBuscarActionPerformed

//visualiza el cuerpo donde esta el ABM
    private void jButtonTraerPanelCuerpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelCuerpoActionPerformed
//llama al panel contenedor del abm
        jPanelVentanaBuscar.setBounds(-500, 30, 500, 270);
        jPanelCuerpo.setBounds( 100,30,  500, 270);
    }//GEN-LAST:event_jButtonTraerPanelCuerpoActionPerformed
   
// visualiza panel  ventana cerrar
    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed

        jPanelCuerpo.setBounds(-500, 30, 500, 270);
        jPanelVentanaBuscar.setBounds(-500, 30, 500, 270);
        jPanelMensajeCerrar.setBounds( 225,100,  250, 100);
        jPanelElementoExistente.setBounds(-260, 100, 250,  100);
        jPanelErrorBaseDeDatos.setBounds(-260, 100, 250,  100);
        jPanelGuardadoErroneo.setBounds(-260, 100, 250,  100);
        jPanelGuardadoExitoso.setBounds(-260, 100, 250,  100);
        jPanelItemNoSeleccionado.setBounds(-260, 100, 250,  100);
        jPanelMensajeValidarABM.setBounds(-260, 100, 250,  100);
    }//GEN-LAST:event_jButtonCerrarActionPerformed

// minimiza el jframe 
    private void jButtonMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinimizarActionPerformed
        this.setExtendedState(1);
    }//GEN-LAST:event_jButtonMinimizarActionPerformed

// cierra el jframe 
    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        this.dispose(); 
    }//GEN-LAST:event_jButtonAceptarActionPerformed
  
// visualiza el panel cuerpo contiene ABM
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        
        jPanelMensajeCerrar.setBounds(-500, 100, 250, 100);
        jPanelCuerpo.setBounds( 100,30,  500, 270);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

// valida datos y agrega a tabla marcavehiculo un registro 
    private void jButtonAgregarMarcaVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarMarcaVehActionPerformed
       
        jPanelMensajeValidarABM.setBounds(225, 100, 250, 100);
        auxAbm = 1;
        jButtonAgregarMarcaVeh.setEnabled(false);
        jButtonEditarMarcaVeh.setEnabled(false);
        jButtonBorrarMarcaVeh.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldCodMarcaVeh.setEditable(false);
        jTextFieldDescrMarcaVeh.setEditable(false);
    }//GEN-LAST:event_jButtonAgregarMarcaVehActionPerformed

//valida datos y edita un registro en tabla marcavehiculo 
    private void jButtonEditarMarcaVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarMarcaVehActionPerformed
        
        jPanelMensajeValidarABM.setBounds(225, 100, 250, 100);
        auxAbm = 2;
        jButtonAgregarMarcaVeh.setEnabled(false);
        jButtonEditarMarcaVeh.setEnabled(false);
        jButtonBorrarMarcaVeh.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldCodMarcaVeh.setEditable(false);
        jTextFieldDescrMarcaVeh.setEditable(false);
    }//GEN-LAST:event_jButtonEditarMarcaVehActionPerformed

//valida datos y borra un registro en tabla marcavehiculo 
    private void jButtonBorrarMarcaVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarMarcaVehActionPerformed
        
        jPanelMensajeValidarABM.setBounds(225, 100, 250, 100);
        auxAbm = 3;
        jButtonAgregarMarcaVeh.setEnabled(false);
        jButtonEditarMarcaVeh.setEnabled(false);
        jButtonBorrarMarcaVeh.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldCodMarcaVeh.setEditable(false);
        jTextFieldDescrMarcaVeh.setEditable(false);
    }//GEN-LAST:event_jButtonBorrarMarcaVehActionPerformed

// con cada tecleo valida los datos y elimina los no correctos
    private void jTextFieldBuscarMarcaVehKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarMarcaVehKeyReleased
        boolean auxValidar = Administrador.validarCharDinamico(evt.getKeyChar(), "[a-zA-Z_0-9]||[.]||[-]");
    try {
        
        if(auxValidar==false){
               
            evt.consume();
            jTableMarcaVehiculo.setModel(_administradorMarcaVehiculo.buscarEnTabla(jTextFieldBuscarMarcaVeh.getText()));
               
        } else{
           
            jTableMarcaVehiculo.setModel(_administradorMarcaVehiculo.buscarEnTabla(jTextFieldBuscarMarcaVeh.getText()));
           }
    } catch (Exception e) {
        
        jPanelErrorBaseDeDatos.setBounds(225, 100, 250, 100);  
    }      
    }//GEN-LAST:event_jTextFieldBuscarMarcaVehKeyReleased

//esconde el panel y habilita los obj en pantalla
    private void jButtonCancelarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarValidarCambiosActionPerformed
        
        auxAbm = 0;
        limpiarCampos();
        jPanelMensajeValidarABM.setBounds(-260, 100, 250, 100);
        jButtonAgregarMarcaVeh.setEnabled(true);
        jButtonEditarMarcaVeh.setEnabled(false);
        jButtonBorrarMarcaVeh.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldCodMarcaVeh.setEditable(true);
        jTextFieldDescrMarcaVeh.setEditable(true);
        jTextFieldCodMarcaVeh.setBorder(null);
        jTextFieldDescrMarcaVeh.setBorder(null);
    }//GEN-LAST:event_jButtonCancelarValidarCambiosActionPerformed

    private void jButtonAceptarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarValidarCambiosActionPerformed
        String aux,aux2;
        boolean auxValidar1, auxValidar2;
// llama al panel y segun desde donde llamo ejecuta la accion        
        jPanelMensajeValidarABM.setBounds(-260, 100, 250, 100);     
        switch(auxAbm){
            
            case 1:
// se validan los datos
                aux = jTextFieldCodMarcaVeh.getText();
                aux2 = jTextFieldDescrMarcaVeh.getText();
                auxValidar1 = Administrador.validarCamposTextos(aux, "\\d" );
                auxValidar2 = Administrador.validarCamposTextos(aux2,"[a-zA-Z_0-9]||[.]||[-]||[\\s]");
// si es correcto se crea el objeto de la clase usada
                if(auxValidar1==true && auxValidar2==true){

                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDescrMarcaVeh.setBorder(new LineBorder(Color.green));
                    crearObjMarcaVehiculo();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorMarcaVehiculo.insertarTablaMarcaVehiculo(_objMarcaVehiculo)==true){
               
                            jPanelGuardadoExitoso.setBounds(225, 100, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(225, 100, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(225, 100, 250, 100);
    }
// en caso de no ser validos los datos se avisa al usuario
                } else if(auxValidar1==true && auxValidar2==false){
                    
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDescrMarcaVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 100, 250, 100); 
                    
                }  else if(auxValidar1==false && auxValidar2==true){
                    
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldDescrMarcaVeh.setBorder(new LineBorder(Color.green));
                    jPanelGuardadoErroneo.setBounds(225, 100, 250, 100);
                    
                } else if(auxValidar1==false && auxValidar2==false){
                    
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldDescrMarcaVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 100, 250, 100);
                }
            break;
// se repite el mismo codigo solo que se edita un item de la db 
            case 2:
                aux = jTextFieldCodMarcaVeh.getText();
                aux2 = jTextFieldDescrMarcaVeh.getText();
                auxValidar1 = Administrador.validarCamposTextos(aux, "\\d" );
                auxValidar2 = Administrador.validarCamposTextos(aux2,"[a-zA-Z_0-9]||[.]||[-]||[\\s]");

                if(auxValidar1==true && auxValidar2==true){

                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDescrMarcaVeh.setBorder(new LineBorder(Color.green));
                    crearObjMarcaVehiculo();
    try {
                if(_administradorMarcaVehiculo.actualizarTablaMarcaVehiculo(_objMarcaVehiculo,antModCodMarcaVehObtenido)==true){
                    
                    jPanelGuardadoExitoso.setBounds(225, 100, 250, 100);   
                    
                } else{
            
                    jPanelElementoExistente.setBounds(225, 100, 250, 100); 
                }
    } catch (Exception e) {
        jPanelErrorBaseDeDatos.setBounds(225, 100, 250, 100);
    }
    
                } else if(auxValidar1==true && auxValidar2==false){

                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDescrMarcaVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 100, 250, 100);
    
                } else if(auxValidar1==false && auxValidar2==true){

                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldDescrMarcaVeh.setBorder(new LineBorder(Color.green));
                    jPanelGuardadoErroneo.setBounds(225, 100, 250, 100);

                } else if(auxValidar1==false && auxValidar2==false){

                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldDescrMarcaVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 100, 250, 100);
                }
            break;
// se repite el mismo codigo solo que se borra un item de la db         
            case 3:
                aux = jTextFieldCodMarcaVeh.getText();
                aux2 = jTextFieldDescrMarcaVeh.getText();
                auxValidar1 = Administrador.validarCamposTextos(aux, "\\d" );
                auxValidar2 = Administrador.validarCamposTextos(aux2,"[a-zA-Z_0-9]||[.]||[-]||[\\s]");

                if(auxValidar1==true && auxValidar2==true){

                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDescrMarcaVeh.setBorder(new LineBorder(Color.green));
                    crearObjMarcaVehiculo();
    try {
                if(_administradorMarcaVehiculo.eliminarTablaMarcaVehiculo(_objMarcaVehiculo,antModCodMarcaVehObtenido)==true){   
             
                    jPanelGuardadoExitoso.setBounds(225, 100, 250, 100);
               
                } else{
                    jPanelElementoExistente.setBounds(225, 100, 250, 100); 
                }        
    } catch (Exception e) {
                 
        jPanelErrorBaseDeDatos.setBounds(225,100, 250, 100);
    }
                } else if(auxValidar1==true && auxValidar2==false){

                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDescrMarcaVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 100, 250, 100);
            
                }  else if(auxValidar1==false && auxValidar2==true){

                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldDescrMarcaVeh.setBorder(new LineBorder(Color.green));
                    jPanelGuardadoErroneo.setBounds(225, 100, 250, 100);

                } else if(auxValidar1==false && auxValidar2==false){

                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldDescrMarcaVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 100, 250, 100);
                }    
            break;            
        }
    }//GEN-LAST:event_jButtonAceptarValidarCambiosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones, se limpia los campos
    private void jButtonAceptarGuardadoExitosoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoExitosoActionPerformed
       
        jPanelGuardadoExitoso.setBounds(-260, 100, 250, 100);
        jTextFieldCodMarcaVeh.setBorder(null);
        jTextFieldDescrMarcaVeh.setBorder(null);
        limpiarCampos();
        jButtonAgregarMarcaVeh.setEnabled(true);
        jButtonEditarMarcaVeh.setEnabled(false);
        jButtonBorrarMarcaVeh.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldCodMarcaVeh.setEditable(true);
        jTextFieldDescrMarcaVeh.setEditable(true);             
    }//GEN-LAST:event_jButtonAceptarGuardadoExitosoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarGuardadoErroneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoErroneoActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelGuardadoErroneo.setBounds(-260, 100, 250, 100);
                jButtonAgregarMarcaVeh.setEnabled(true);
                jButtonEditarMarcaVeh.setEnabled(false);
                jButtonBorrarMarcaVeh.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldDescrMarcaVeh.setEditable(true);
                jTextFieldCodMarcaVeh.setEditable(true);
            break;
            
            case 2:
                jPanelGuardadoErroneo.setBounds(-260, 100, 250, 100);
                jButtonAgregarMarcaVeh.setEnabled(false);
                jButtonEditarMarcaVeh.setEnabled(true);
                jButtonBorrarMarcaVeh.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldDescrMarcaVeh.setEditable(true);
            break;
            
            case 3: 
                jPanelGuardadoErroneo.setBounds(-260, 100, 250, 100);
                jButtonAgregarMarcaVeh.setEnabled(false);
                jButtonEditarMarcaVeh.setEnabled(false);
                jButtonBorrarMarcaVeh.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldDescrMarcaVeh.setEditable(true);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarGuardadoErroneoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarErrorBaseDeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarErrorBaseDeDatosActionPerformed
        
        jPanelErrorBaseDeDatos.setBounds(-260, 100, 250, 100);
        jButtonAgregarMarcaVeh.setEnabled(true);
        jButtonEditarMarcaVeh.setEnabled(false);
        jButtonBorrarMarcaVeh.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldCodMarcaVeh.setEditable(true);
        jTextFieldDescrMarcaVeh.setEditable(true);   
        jTextFieldCodMarcaVeh.setBorder(null);
        jTextFieldDescrMarcaVeh.setBorder(null);
    }//GEN-LAST:event_jButtonAceptarErrorBaseDeDatosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarElementoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoExistenteActionPerformed
        
        jPanelElementoExistente.setBounds(-260, 100, 250, 100);
        jButtonAgregarMarcaVeh.setEnabled(true);
        jButtonEditarMarcaVeh.setEnabled(false);
        jButtonBorrarMarcaVeh.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldCodMarcaVeh.setEditable(true);
        jTextFieldDescrMarcaVeh.setEditable(true);
    }//GEN-LAST:event_jButtonAceptarElementoExistenteActionPerformed

// se acomoda los objetos del frame para continuar trabajando. 
    private void jButtonAceptarItemNoSeleccionado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

        jTableMarcaVehiculo.setEnabled(true);
        jPanelItemNoSeleccionado.setBounds(-260, 100, 250, 100); 
    }//GEN-LAST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAceptarElementoExistente;
    private javax.swing.JButton jButtonAceptarErrorBaseDeDatos;
    private javax.swing.JButton jButtonAceptarGuardadoErroneo;
    private javax.swing.JButton jButtonAceptarGuardadoExitoso;
    private javax.swing.JButton jButtonAceptarItemNoSeleccionado2;
    private javax.swing.JButton jButtonAceptarValidarCambios;
    private javax.swing.JButton jButtonAgregarMarcaVeh;
    private javax.swing.JButton jButtonBorrarMarcaVeh;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelarValidarCambios;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonEditarMarcaVeh;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JButton jButtonTraerPanelBuscar;
    private javax.swing.JButton jButtonTraerPanelCuerpo;
    private javax.swing.JLabel jLabelFondoIconoElementoExitente;
    private javax.swing.JLabel jLabelFondoIconoErrorBaseDeDatos;
    private javax.swing.JLabel jLabelFondoIconoGuardadoErroneo;
    private javax.swing.JLabel jLabelFondoIconoGuardadoExitoso;
    private javax.swing.JLabel jLabelFondoIconoItemNoSeleccionado;
    private javax.swing.JLabel jLabelFondoIconoMensajeCerrar;
    private javax.swing.JLabel jLabelFondoIconoMensajeValidarCambios;
    private javax.swing.JLabel jLabelFondoVentanaBuscar;
    private javax.swing.JLabel jLabelIconoAlerta;
    private javax.swing.JLabel jLabelIconoAlertaValidarCambios;
    private javax.swing.JLabel jLabelIconoBarraTitulo;
    private javax.swing.JLabel jLabelIconoError;
    private javax.swing.JLabel jLabelIconoErrorBaseDeDatos;
    private javax.swing.JLabel jLabelIconoErrorElementoExistente;
    private javax.swing.JLabel jLabelIconoErrorItemNoSeleccionado;
    private javax.swing.JLabel jLabelIconoExito;
    private javax.swing.JLabel jLabelIconoFondo;
    private javax.swing.JLabel jLabelIconoFondoCuerpo;
    private javax.swing.JLabel jLabelMensajeDos;
    private javax.swing.JLabel jLabelMensajeElementoExistente;
    private javax.swing.JLabel jLabelMensajeElementoExistente2;
    private javax.swing.JLabel jLabelMensajeErrorBaseDeDatos;
    private javax.swing.JLabel jLabelMensajeErrorBaseDeDatos1;
    private javax.swing.JLabel jLabelMensajeGuardadoCorrecto;
    private javax.swing.JLabel jLabelMensajeGuardadoErroneo;
    private javax.swing.JLabel jLabelMensajeGuardadoErroneo2;
    private javax.swing.JLabel jLabelMensajeItemNoSeleccionado;
    private javax.swing.JLabel jLabelMensajeUno;
    private javax.swing.JLabel jLabelMensajeValidarCambios;
    private javax.swing.JLabel jLabelMensajeValidarCambios1;
    private javax.swing.JLabel jLabelTituloBuscarMarcaVeh;
    private javax.swing.JLabel jLabelTituloDescrMarcaVeh;
    private javax.swing.JLabel jLabelTituloIuMarcaVeh;
    private javax.swing.JLabel jLabelTituloVentana;
    private javax.swing.JLabel jLabelToolKitMarca;
    private javax.swing.JPanel jPanelBarraTitulo;
    private javax.swing.JPanel jPanelCuerpo;
    private javax.swing.JPanel jPanelElementoExistente;
    private javax.swing.JPanel jPanelErrorBaseDeDatos;
    private javax.swing.JPanel jPanelGuardadoErroneo;
    private javax.swing.JPanel jPanelGuardadoExitoso;
    private javax.swing.JPanel jPanelItemNoSeleccionado;
    private javax.swing.JPanel jPanelMensajeCerrar;
    private javax.swing.JPanel jPanelMensajeValidarABM;
    private javax.swing.JPanel jPanelVentanaBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparatorBuscarMarcaVeh;
    private javax.swing.JSeparator jSeparatorDescrMarcaVeh;
    private javax.swing.JSeparator jSeparatorIuMarcaVeh;
    private javax.swing.JTable jTableMarcaVehiculo;
    private javax.swing.JTextField jTextFieldBuscarMarcaVeh;
    private javax.swing.JTextField jTextFieldCodMarcaVeh;
    private javax.swing.JTextField jTextFieldDescrMarcaVeh;
    // End of variables declaration//GEN-END:variables
}
