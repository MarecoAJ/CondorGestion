/*
* este JFrame registra (agrega, borra, edita, busca y filtra) todos los modelos de vehiculos
*/
package Vistas;

import administradorClases.Administrador;
import administradorClases.AdministradorMarcaVehiculo;
import administradorClases.AdministradorModeloVehiculo;
import clasesDatos.ModeloVehiculo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;


public class JFrameRegistroModelosVehiculos extends javax.swing.JFrame {
// atributos y variables    
    private final AdministradorModeloVehiculo _administradorModeloVehiculo;
    private final AdministradorMarcaVehiculo _administradorMarcaVehiculo;
    private ModeloVehiculo _objModeloVehiculo;
    private TableModel modeloTablaMV;
    private String codModeloVehObtenido;
    private String antModCodModeloVehObtenido;
    private int auxAbm;
    private int auxSeleccionList;
    
    public JFrameRegistroModelosVehiculos() {
        initComponents();
// se personaliza las fuentes de letra de los objetos grafico
        jLabelTituloVentana.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 8));
        jLabelTituloCodModeloVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldCodModeloVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTitulocodMarcaVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldCodMarcaVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloBuscarModeloVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldBuscarModeloVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloDescrModeloVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldDescrModeloVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));

        
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
        jTableModeloVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 6));
        JTableHeader auxJTableHeader;
        auxJTableHeader = jTableModeloVeh.getTableHeader();
        auxJTableHeader.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
// se instancia la clase AdministradorTipoPagos y se inicializa el menu del jTable
        _administradorModeloVehiculo = new AdministradorModeloVehiculo();
        _administradorMarcaVehiculo = new AdministradorMarcaVehiculo();
        popupMenuJTable();
        
        jButtonEditarModeloVeh.setEnabled(false);
        jButtonBorrarModeloVeh.setEnabled(false);
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelElementoNoExistente = new javax.swing.JPanel();
        jButtonAceptarElementoNoExistente = new javax.swing.JButton();
        jLabelIconoErrorElementoNoExistente = new javax.swing.JLabel();
        jLabelMensajeElementoNoExistente = new javax.swing.JLabel();
        jLabelMensajeElementoNoExistente2 = new javax.swing.JLabel();
        jLabelFondoIconoElementoNoExitente = new javax.swing.JLabel();
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
        jSeparatorBuscarModeloVeh = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableModeloVeh = new javax.swing.JTable();
        jLabelTituloBuscarModeloVeh = new javax.swing.JLabel();
        jTextFieldBuscarModeloVeh = new javax.swing.JTextField();
        jButtonTraerPanelCuerpo = new javax.swing.JButton();
        jLabelFondoVentanaBuscar = new javax.swing.JLabel();
        jPanelCuerpo = new javax.swing.JPanel();
        jPanelListaMarcaVeh = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListMarcaVeh = new javax.swing.JList<>();
        jButtonRegMarcaVeh = new javax.swing.JButton();
        jTextFieldDescrModeloVeh = new javax.swing.JTextField();
        jSeparatorDescrModeloVeh = new javax.swing.JSeparator();
        jLabelTituloDescrModeloVeh = new javax.swing.JLabel();
        jLabelTitulocodMarcaVeh = new javax.swing.JLabel();
        jTextFieldCodMarcaVeh = new javax.swing.JTextField();
        jSeparatorCodMarcaVeh = new javax.swing.JSeparator();
        jSeparatorCodModeloVeh = new javax.swing.JSeparator();
        jLabelTituloCodModeloVeh = new javax.swing.JLabel();
        jTextFieldCodModeloVeh = new javax.swing.JTextField();
        jButtonAgregarModeloVeh = new javax.swing.JButton();
        jButtonEditarModeloVeh = new javax.swing.JButton();
        jButtonBorrarModeloVeh = new javax.swing.JButton();
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
        setMinimumSize(new java.awt.Dimension(700, 331));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(700, 331));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelElementoNoExistente.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelElementoNoExistente.setOpaque(false);
        jPanelElementoNoExistente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarElementoNoExistente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarElementoNoExistente.setToolTipText("Has click para continuar.");
        jButtonAceptarElementoNoExistente.setBorder(null);
        jButtonAceptarElementoNoExistente.setBorderPainted(false);
        jButtonAceptarElementoNoExistente.setContentAreaFilled(false);
        jButtonAceptarElementoNoExistente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarElementoNoExistente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarElementoNoExistente.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarElementoNoExistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarElementoNoExistenteActionPerformed(evt);
            }
        });
        jPanelElementoNoExistente.add(jButtonAceptarElementoNoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorElementoNoExistente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelElementoNoExistente.add(jLabelIconoErrorElementoNoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeElementoNoExistente.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeElementoNoExistente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeElementoNoExistente.setText("No se guardo.");
        jPanelElementoNoExistente.add(jLabelMensajeElementoNoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeElementoNoExistente2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeElementoNoExistente2.setText(" Revise. Los datos no existen.");
        jPanelElementoNoExistente.add(jLabelMensajeElementoNoExistente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 35, -1, 25));

        jLabelFondoIconoElementoNoExitente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelElementoNoExistente.add(jLabelFondoIconoElementoNoExitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        getContentPane().add(jPanelElementoNoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 115, 250, 100));

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

        getContentPane().add(jPanelItemNoSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 115, 250, 100));

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

        getContentPane().add(jPanelElementoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 115, 250, 100));

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

        getContentPane().add(jPanelErrorBaseDeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 115, 250, 100));

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

        getContentPane().add(jPanelGuardadoErroneo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 115, 250, 100));

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

        getContentPane().add(jPanelGuardadoExitoso, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 115, 250, 100));

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

        getContentPane().add(jPanelMensajeValidarABM, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 115, 250, 100));

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

        getContentPane().add(jPanelMensajeCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, 115, 250, 100));

        jPanelVentanaBuscar.setBackground(new java.awt.Color(245, 245, 245));
        jPanelVentanaBuscar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanelVentanaBuscar.setMaximumSize(new java.awt.Dimension(500, 301));
        jPanelVentanaBuscar.setMinimumSize(new java.awt.Dimension(500, 301));
        jPanelVentanaBuscar.setOpaque(false);
        jPanelVentanaBuscar.setPreferredSize(new java.awt.Dimension(500, 301));
        jPanelVentanaBuscar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparatorBuscarModeloVeh.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorBuscarModeloVeh.setForeground(new java.awt.Color(0, 0, 0));
        jPanelVentanaBuscar.add(jSeparatorBuscarModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 55, 100, 2));

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(480, 146));

        jTableModeloVeh = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jTableModeloVeh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nº registro", "Descripcion", "Monto"
            }
        ));
        jTableModeloVeh.setToolTipText("Has click derecho para opciones.");
        jTableModeloVeh.setAutoscrolls(false);
        jTableModeloVeh.setFocusable(false);
        jTableModeloVeh.setMaximumSize(new java.awt.Dimension(480, 250));
        jTableModeloVeh.setMinimumSize(new java.awt.Dimension(480, 250));
        jTableModeloVeh.setPreferredSize(new java.awt.Dimension(480, 250));
        jTableModeloVeh.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jTableModeloVeh.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jTableModeloVeh.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableModeloVeh);

        jPanelVentanaBuscar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 480, 221));

        jLabelTituloBuscarModeloVeh.setText("Parametro de busqueda:");
        jPanelVentanaBuscar.add(jLabelTituloBuscarModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 10, -1, 25));

        jTextFieldBuscarModeloVeh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBuscarModeloVeh.setToolTipText("ingresa parametros de busqueda. Ej: chev");
        jTextFieldBuscarModeloVeh.setBorder(null);
        jTextFieldBuscarModeloVeh.setDisabledTextColor(new java.awt.Color(194, 4, 48));
        jTextFieldBuscarModeloVeh.setOpaque(false);
        jTextFieldBuscarModeloVeh.setSelectionColor(new java.awt.Color(73, 73, 73));
        jTextFieldBuscarModeloVeh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarModeloVehKeyReleased(evt);
            }
        });
        jPanelVentanaBuscar.add(jTextFieldBuscarModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 35, 100, 20));

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

        jLabelFondoVentanaBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondoCuerpo500x301.png"))); // NOI18N
        jLabelFondoVentanaBuscar.setToolTipText("");
        jPanelVentanaBuscar.add(jLabelFondoVentanaBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 301));

        getContentPane().add(jPanelVentanaBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, 30, 500, 301));

        jPanelCuerpo.setMaximumSize(new java.awt.Dimension(500, 301));
        jPanelCuerpo.setMinimumSize(new java.awt.Dimension(500, 301));
        jPanelCuerpo.setOpaque(false);
        jPanelCuerpo.setPreferredSize(new java.awt.Dimension(500, 301));
        jPanelCuerpo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelListaMarcaVeh.setMinimumSize(new java.awt.Dimension(200, 45));
        jPanelListaMarcaVeh.setOpaque(false);
        jPanelListaMarcaVeh.setPreferredSize(new java.awt.Dimension(200, 45));
        jPanelListaMarcaVeh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 45));

        jListMarcaVeh.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jListMarcaVeh.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jListMarcaVeh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListMarcaVehFocusGained(evt);
            }
        });
        jListMarcaVeh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListMarcaVehMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListMarcaVeh);

        jPanelListaMarcaVeh.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 45));

        jPanelCuerpo.add(jPanelListaMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 138, 200, 45));

        jButtonRegMarcaVeh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x25Off.png"))); // NOI18N
        jButtonRegMarcaVeh.setBorder(null);
        jButtonRegMarcaVeh.setBorderPainted(false);
        jButtonRegMarcaVeh.setContentAreaFilled(false);
        jButtonRegMarcaVeh.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegMarcaVeh.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegMarcaVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegMarcaVehActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonRegMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 113, -1, -1));

        jTextFieldDescrModeloVeh.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldDescrModeloVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldDescrModeloVeh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDescrModeloVeh.setToolTipText("Ingrese solo alfanumericos y simbolos(-) o (.). Ej.: palio");
        jTextFieldDescrModeloVeh.setBorder(null);
        jTextFieldDescrModeloVeh.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldDescrModeloVeh.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldDescrModeloVeh.setOpaque(false);
        jTextFieldDescrModeloVeh.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldDescrModeloVeh.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldDescrModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 196, 200, 20));

        jSeparatorDescrModeloVeh.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorDescrModeloVeh.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorDescrModeloVeh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorDescrModeloVeh.setOpaque(true);
        jPanelCuerpo.add(jSeparatorDescrModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 216, 200, -1));

        jLabelTituloDescrModeloVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloDescrModeloVeh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloDescrModeloVeh.setText("Modelo del vehiculo");
        jLabelTituloDescrModeloVeh.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloDescrModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 176, -1, 25));

        jLabelTitulocodMarcaVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTitulocodMarcaVeh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTitulocodMarcaVeh.setText("Marca del vehiculo:");
        jLabelTitulocodMarcaVeh.setToolTipText("");
        jPanelCuerpo.add(jLabelTitulocodMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 98, -1, 25));

        jTextFieldCodMarcaVeh.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldCodMarcaVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldCodMarcaVeh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCodMarcaVeh.setToolTipText("Ingrese solo alfanumericos y simbolos(-) o (.). Ej.: b-m.w");
        jTextFieldCodMarcaVeh.setBorder(null);
        jTextFieldCodMarcaVeh.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldCodMarcaVeh.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldCodMarcaVeh.setOpaque(false);
        jTextFieldCodMarcaVeh.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldCodMarcaVeh.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldCodMarcaVeh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldCodMarcaVehFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCodMarcaVehFocusLost(evt);
            }
        });
        jTextFieldCodMarcaVeh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCodMarcaVehKeyReleased(evt);
            }
        });
        jPanelCuerpo.add(jTextFieldCodMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 118, 200, 20));

        jSeparatorCodMarcaVeh.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorCodMarcaVeh.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorCodMarcaVeh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorCodMarcaVeh.setOpaque(true);
        jPanelCuerpo.add(jSeparatorCodMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 138, 200, -1));

        jSeparatorCodModeloVeh.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorCodModeloVeh.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorCodModeloVeh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorCodModeloVeh.setOpaque(true);
        jPanelCuerpo.add(jSeparatorCodModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 66, 100, -1));

        jLabelTituloCodModeloVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloCodModeloVeh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloCodModeloVeh.setText("Codigo identificacion:");
        jLabelTituloCodModeloVeh.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloCodModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 25, -1, 25));

        jTextFieldCodModeloVeh.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldCodModeloVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldCodModeloVeh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCodModeloVeh.setToolTipText("Ingrese solo numeros. Ej.: 08");
        jTextFieldCodModeloVeh.setBorder(null);
        jTextFieldCodModeloVeh.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldCodModeloVeh.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldCodModeloVeh.setOpaque(false);
        jTextFieldCodModeloVeh.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldCodModeloVeh.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldCodModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 45, 100, 20));

        jButtonAgregarModeloVeh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOff.png"))); // NOI18N
        jButtonAgregarModeloVeh.setToolTipText("Has click para agregar.");
        jButtonAgregarModeloVeh.setBorder(null);
        jButtonAgregarModeloVeh.setBorderPainted(false);
        jButtonAgregarModeloVeh.setContentAreaFilled(false);
        jButtonAgregarModeloVeh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregarModeloVeh.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarModeloVeh.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarModeloVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarModeloVehActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonAgregarModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 251, -1, -1));

        jButtonEditarModeloVeh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOff.png"))); // NOI18N
        jButtonEditarModeloVeh.setToolTipText("Has click para editar.");
        jButtonEditarModeloVeh.setBorder(null);
        jButtonEditarModeloVeh.setBorderPainted(false);
        jButtonEditarModeloVeh.setContentAreaFilled(false);
        jButtonEditarModeloVeh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditarModeloVeh.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarModeloVeh.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarModeloVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarModeloVehActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonEditarModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 251, -1, -1));

        jButtonBorrarModeloVeh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOff.png"))); // NOI18N
        jButtonBorrarModeloVeh.setToolTipText("Has click para borrar.");
        jButtonBorrarModeloVeh.setBorder(null);
        jButtonBorrarModeloVeh.setBorderPainted(false);
        jButtonBorrarModeloVeh.setContentAreaFilled(false);
        jButtonBorrarModeloVeh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBorrarModeloVeh.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarModeloVeh.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarModeloVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarModeloVehActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonBorrarModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 251, -1, -1));

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

        jLabelIconoFondoCuerpo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondoCuerpo500x301.png"))); // NOI18N
        jPanelCuerpo.add(jLabelIconoFondoCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 301));

        getContentPane().add(jPanelCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 500, 301));

        jPanelBarraTitulo.setMaximumSize(new java.awt.Dimension(700, 30));
        jPanelBarraTitulo.setMinimumSize(new java.awt.Dimension(700, 30));
        jPanelBarraTitulo.setOpaque(false);
        jPanelBarraTitulo.setPreferredSize(new java.awt.Dimension(700, 30));
        jPanelBarraTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTituloVentana.setFont(new java.awt.Font("Open Sans Extrabold", 0, 11)); // NOI18N
        jLabelTituloVentana.setForeground(new java.awt.Color(245, 245, 245));
        jLabelTituloVentana.setText("Registro de modelos de vehiculos");
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
        getContentPane().add(jLabelToolKitMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 50, 50));

        jLabelIconoFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo700x331Logo.png"))); // NOI18N
        getContentPane().add(jLabelIconoFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

// se crea un objeto de la clase utilizada    
    public void crearObjModeloVehiculo(){
     
        _objModeloVehiculo = new ModeloVehiculo();
        _objModeloVehiculo.setCodModeloVeh(jTextFieldCodModeloVeh.getText());
        _objModeloVehiculo.setCodMarcaVeh(_administradorMarcaVehiculo.obtenerCodMarcaVeh(jTextFieldCodMarcaVeh.getText()));
        _objModeloVehiculo.setDescrModeloVeh(jTextFieldDescrModeloVeh.getText());
    }

// valida codMarcaVeh en caso de no hacer cick en a lista
    public void validarCodMarcaVeh(){
        if(_administradorMarcaVehiculo.obtenerCodMarcaVeh(jTextFieldCodMarcaVeh.getText()).length()==0){
            auxSeleccionList = 0;
        } else{
            auxSeleccionList = 1;
        }
    }
    
// limpia los jtextfield usados
    public void limpiarCampos(){

        jTextFieldCodModeloVeh.setText("");
        jTextFieldCodMarcaVeh.setText(""); 
        jTextFieldDescrModeloVeh.setText("");
        }
     
// este metodo crea menu de opciones al usar click secundario   
    public final void popupMenuJTable(){
//se crean las opciones del menu
        JPopupMenu jPopupMenuTableHMV = new JPopupMenu();
        JMenuItem jMenuItemEliminarModeloVehiculo = new JMenuItem("Eliminar"); // cambiar x ico 
        JMenuItem jMenuItemModificarModeloVehiculo = new JMenuItem("Modificar");
        JMenuItem jMenuOrdenar = new JMenu("Ordenar por");
        JMenuItem jMenuItemPrimerosAgregados = new JMenuItem("Primeros agregados");
        JMenuItem jMenuItemUltimosAgregados= new JMenuItem("Ultimos agregados");
        JMenuItem jMenuItemAlfabeticos = new JMenuItem("Alfabeticos"); 
        jMenuOrdenar.add(jMenuItemPrimerosAgregados);
        jMenuOrdenar.add(jMenuItemUltimosAgregados); 
        jMenuOrdenar.add(jMenuItemAlfabeticos);
// se generan las acciones de cada opcion
        jMenuItemEliminarModeloVehiculo.addActionListener((ActionEvent e) -> {
        
        if(seleccionarItemJTabla()!= -1){
                 
            jPanelVentanaBuscar.setBounds(-500, 30, 500, 301);
            jPanelCuerpo.setBounds( 100,30,  500, 301);
              
            jButtonAgregarModeloVeh.setEnabled(false);
            jButtonEditarModeloVeh.setEnabled(false);
            jTextFieldCodModeloVeh.setEditable(false);
            jTextFieldCodMarcaVeh.setEditable(false); 
            jTextFieldDescrModeloVeh.setEditable(false);
            jButtonRegMarcaVeh.setEnabled(false);
            jPanelListaMarcaVeh.setVisible(false);
       
            jButtonBorrarModeloVeh.setEnabled(true);
             }
         });
         
        jMenuItemModificarModeloVehiculo.addActionListener((ActionEvent e) -> {
            
        if(seleccionarItemJTabla()!= -1){
                     
            jPanelVentanaBuscar.setBounds(-500, 30, 500, 301);
            jPanelCuerpo.setBounds( 100,30,  500, 301);
                
            jButtonAgregarModeloVeh.setEnabled(false);
            jButtonBorrarModeloVeh.setEnabled(false);
            jTextFieldCodModeloVeh.setEditable(false);   
            jButtonEditarModeloVeh.setEnabled(true);
        }
        });
             
        jMenuItemUltimosAgregados.addActionListener((ActionEvent e) -> {
            _administradorModeloVehiculo.ordenarTabla(jMenuItemUltimosAgregados.getText());
            jTableModeloVeh.setModel( _administradorModeloVehiculo.cargarJTabla());
        });
                
        jMenuItemAlfabeticos.addActionListener((ActionEvent e) -> {
            _administradorModeloVehiculo.ordenarTabla(jMenuItemAlfabeticos.getText());
            jTableModeloVeh.setModel( _administradorModeloVehiculo.cargarJTabla());
        });
                                
        jMenuItemPrimerosAgregados.addActionListener((ActionEvent e) -> {
            _administradorModeloVehiculo.ordenarTabla(jMenuItemPrimerosAgregados.getText());
            jTableModeloVeh.setModel( _administradorModeloVehiculo.cargarJTabla());
        });
// se construye el menu completo y se le asigna si jTable
        jPopupMenuTableHMV.add(jMenuItemEliminarModeloVehiculo);
        jPopupMenuTableHMV.add(jMenuItemModificarModeloVehiculo);
        jPopupMenuTableHMV.add(jMenuOrdenar);
        jTableModeloVeh.setComponentPopupMenu(jPopupMenuTableHMV);  
     }
 
// se obtiene los datos del item seleccionado en la tabla
    public int seleccionarItemJTabla(){
// se obtiene el modelo y se verifica que se haya seleccionado un item   
        modeloTablaMV = jTableModeloVeh.getModel();
        int auxSeleccion = jTableModeloVeh.getSelectedRow();
        if (auxSeleccion != -1) {
            jTableModeloVeh.setEnabled(true);
// se cargan los campos con los valores selcionados
            codModeloVehObtenido =  (String)modeloTablaMV.getValueAt(jTableModeloVeh.getSelectedRow(), 0);
            antModCodModeloVehObtenido = codModeloVehObtenido;
            jTextFieldCodModeloVeh.setText(codModeloVehObtenido);
            jTextFieldCodMarcaVeh.setText((String)modeloTablaMV.getValueAt(jTableModeloVeh.getSelectedRow(), 2));
            jTextFieldDescrModeloVeh.setText((String)modeloTablaMV.getValueAt(jTableModeloVeh.getSelectedRow(),1));
            return auxSeleccion;
            
        }else {
// si no selecciona mensaje error   
            jTableModeloVeh.setEnabled(false);
            jPanelItemNoSeleccionado.setBounds(225, 115, 250,100);
            return auxSeleccion;
        }
    }
    
//visualiza el panel buscar
    private void jButtonTraerPanelBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelBuscarActionPerformed
// llama al panel buscar 
    try {
        jTableModeloVeh.setModel(_administradorModeloVehiculo.cargarJTabla());
    } catch (Exception e) {
        jPanelErrorBaseDeDatos.setBounds(225, 115, 250, 100);
    }
        jPanelCuerpo.setBounds(-500, 30, 500, 301);
        jPanelVentanaBuscar.setBounds( 100,30,  500, 301);      
    }//GEN-LAST:event_jButtonTraerPanelBuscarActionPerformed

//visualiza el cuerpo donde esta el ABM
    private void jButtonTraerPanelCuerpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelCuerpoActionPerformed
//llama al panel contenedor del abm
        jPanelVentanaBuscar.setBounds(-500, 30, 500, 301);
        jPanelCuerpo.setBounds( 100,30,  500, 301);
    }//GEN-LAST:event_jButtonTraerPanelCuerpoActionPerformed
   
// visualiza panel  ventana cerrar
    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed

        jPanelCuerpo.setBounds(-500, 30, 500, 301);
        jPanelVentanaBuscar.setBounds(-500, 30, 500, 301);
        jPanelMensajeCerrar.setBounds( 225,115,  250, 100);
        jPanelElementoExistente.setBounds(-260, 115, 250,  100);
        jPanelErrorBaseDeDatos.setBounds(-260, 115, 250,  100);
        jPanelGuardadoErroneo.setBounds(-260, 115, 250,  100);
        jPanelGuardadoExitoso.setBounds(-260, 115, 250,  100);
        jPanelItemNoSeleccionado.setBounds(-260, 115, 250,  100);
        jPanelMensajeValidarABM.setBounds(-260, 115, 250,  100);
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
        
        jPanelMensajeCerrar.setBounds(-500, 115, 250, 100);
        jPanelCuerpo.setBounds( 100,30,  500, 301);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

// valida datos y agrega a tabla TipoPagos un registro 
    private void jButtonAgregarModeloVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarModeloVehActionPerformed
       
        jPanelMensajeValidarABM.setBounds(225, 115, 250, 100);
        auxAbm = 1;
        jButtonAgregarModeloVeh.setEnabled(false);
        jButtonEditarModeloVeh.setEnabled(false);
        jButtonBorrarModeloVeh.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldCodModeloVeh.setEditable(false);
        jTextFieldCodMarcaVeh.setEditable(false);
        jTextFieldDescrModeloVeh.setEditable(false);
        jButtonRegMarcaVeh.setEnabled(false);
    }//GEN-LAST:event_jButtonAgregarModeloVehActionPerformed

//valida datos y edita un registro en tabla TipoPagos
    private void jButtonEditarModeloVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarModeloVehActionPerformed
        
        jPanelMensajeValidarABM.setBounds(225, 115, 250, 100);
        auxAbm = 2;
        jButtonAgregarModeloVeh.setEnabled(false);
        jButtonEditarModeloVeh.setEnabled(false);
        jButtonBorrarModeloVeh.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldCodModeloVeh.setEditable(false);
        jTextFieldCodMarcaVeh.setEditable(false);
        jTextFieldDescrModeloVeh.setEditable(false);
        jButtonRegMarcaVeh.setEnabled(false);
    }//GEN-LAST:event_jButtonEditarModeloVehActionPerformed

//valida datos y borra un registro en tabla TipoPagos 
    private void jButtonBorrarModeloVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarModeloVehActionPerformed
        
        jPanelMensajeValidarABM.setBounds(225, 115, 250, 100);
        auxAbm = 3;
        jButtonAgregarModeloVeh.setEnabled(false);
        jButtonEditarModeloVeh.setEnabled(false);
        jButtonBorrarModeloVeh.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldCodModeloVeh.setEditable(false);
        jTextFieldCodMarcaVeh.setEditable(false);
        jTextFieldDescrModeloVeh.setEditable(false);
        jButtonRegMarcaVeh.setEnabled(false);
    }//GEN-LAST:event_jButtonBorrarModeloVehActionPerformed

// con cada tecleo valida los datos y elimina los no correctos
    private void jTextFieldBuscarModeloVehKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarModeloVehKeyReleased
        boolean auxValidar = Administrador.validarCharDinamico(evt.getKeyChar(), "[a-zA-Z_0-9]||[\\s]");
    try {
        
        if(auxValidar==false){
               
            evt.consume();
            jTableModeloVeh.setModel(_administradorModeloVehiculo.buscarEnTabla(jTextFieldBuscarModeloVeh.getText()));
               
        } else{
           
            jTableModeloVeh.setModel(_administradorModeloVehiculo.buscarEnTabla(jTextFieldBuscarModeloVeh.getText()));
           }
    } catch (Exception e) {
        
        jPanelErrorBaseDeDatos.setBounds(225, 115, 250, 100);  
    }      
    }//GEN-LAST:event_jTextFieldBuscarModeloVehKeyReleased

//esconde el panel y habilita los obj en pantalla
    private void jButtonCancelarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarValidarCambiosActionPerformed
        
        auxAbm = 0;
        limpiarCampos();
        jPanelMensajeValidarABM.setBounds(-260, 115, 250, 100);
        jButtonAgregarModeloVeh.setEnabled(true);
        jButtonEditarModeloVeh.setEnabled(false);
        jButtonBorrarModeloVeh.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldCodMarcaVeh.setEditable(true);
        jTextFieldDescrModeloVeh.setEditable(true);
        jTextFieldCodModeloVeh.setEditable(true);
        jTextFieldCodMarcaVeh.setBorder(null);
        jTextFieldCodModeloVeh.setBorder(null);
        jTextFieldDescrModeloVeh.setBorder(null);
        jButtonRegMarcaVeh.setEnabled(true);
        jPanelListaMarcaVeh.setVisible(true);
    }//GEN-LAST:event_jButtonCancelarValidarCambiosActionPerformed

    private void jButtonAceptarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarValidarCambiosActionPerformed
        String aux,aux2;
        boolean auxValidar, auxValidar2;
// llama al panel y segun desde donde llamo ejecuta la accion        
        jPanelMensajeValidarABM.setBounds(-260, 115, 250, 100);     
        switch(auxAbm){
            
            case 1:
// se validan los datos
                aux2 = jTextFieldCodModeloVeh.getText();
                auxValidar2 = Administrador.validarCamposTextos(aux2, "\\d" );
                aux = jTextFieldDescrModeloVeh.getText();
                auxValidar = Administrador.validarCamposTextos(aux,"[a-zA-Z_0-9]||[.]||[-]||[\\s]");
                validarCodMarcaVeh();
// si es correcto se crea el objeto de la clase usada
                if(auxValidar2==true && auxValidar==true && auxSeleccionList==1){

                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = 0;
                    crearObjModeloVehiculo();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorModeloVehiculo.insertarTablaModeloVehiculo(_objModeloVehiculo)==true){
               
                            jPanelGuardadoExitoso.setBounds(225, 115, 250, 100);
                    
                    } else{
                            jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                            jPanelElementoExistente.setBounds(225, 115, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(225, 115, 250, 100);
    }
// en caso de no ser validos los datos se avisa al usuario
                } else if(auxValidar2==false && auxValidar==true && auxSeleccionList==1){
                    
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==false && auxSeleccionList==1){
                    System.err.println("www");
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorMarcaVehiculo.obtenerCodMarcaVeh(jTextFieldCodMarcaVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==false && auxSeleccionList==1){
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorMarcaVehiculo.obtenerCodMarcaVeh(jTextFieldCodMarcaVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorMarcaVehiculo.obtenerCodMarcaVeh(jTextFieldCodMarcaVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                }
            break;
// se repite el mismo codigo solo que se edita un item de la db 
            case 2:
// se validan los datos
                aux2 = jTextFieldCodModeloVeh.getText();
                auxValidar2 = Administrador.validarCamposTextos(aux2,"\\d");
                aux = jTextFieldDescrModeloVeh.getText();
                auxValidar = Administrador.validarCamposTextos(aux,"[[a-zA-Z_0-9]||[.]||[-]||[\\s]");
                validarCodMarcaVeh();
// si es correcto se crea el objeto de la clase usada
                if(auxValidar2==true && auxValidar==true && auxSeleccionList==1){

                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = 0;
                    crearObjModeloVehiculo();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorModeloVehiculo.actualizarTablaModeloVehiculo(_objModeloVehiculo, antModCodModeloVehObtenido)==true){
               
                            jPanelGuardadoExitoso.setBounds(225, 115, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(225, 115, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(225, 115, 250, 100);
    }
// en caso de no ser validos los datos se avisa al usuario
                } else if(auxValidar2==false && auxValidar==true && auxSeleccionList==1){
                    
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==false && auxSeleccionList==1){
                    System.err.println("www");
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorMarcaVehiculo.obtenerCodMarcaVeh(jTextFieldCodMarcaVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==false && auxSeleccionList==1){
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorMarcaVehiculo.obtenerCodMarcaVeh(jTextFieldCodMarcaVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorMarcaVehiculo.obtenerCodMarcaVeh(jTextFieldCodMarcaVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 100, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                }
            break;
// se repite el mismo codigo solo que se borra un item de la db         
            case 3:
// se validan los datos
                aux2 = jTextFieldCodModeloVeh.getText();
                auxValidar2 = Administrador.validarCamposTextos(aux2,"\\d");
                aux = jTextFieldDescrModeloVeh.getText();
                auxValidar = Administrador.validarCamposTextos(aux,"[a-zA-Z_0-9]||[.]||[-]||[\\s]");
                validarCodMarcaVeh();
// si es correcto se crea el objeto de la clase usada
                if(auxValidar2==true && auxValidar==true && auxSeleccionList==1){

                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = 0;
                    crearObjModeloVehiculo();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorModeloVehiculo.eliminarTablaModeloVehiculo(_objModeloVehiculo, antModCodModeloVehObtenido)==true){
               
                            jPanelGuardadoExitoso.setBounds(225, 115, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(225, 115, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(225, 115, 250, 100);
    }
// en caso de no ser validos los datos se avisa al usuario
                } else if(auxValidar2==false && auxValidar==true && auxSeleccionList==1){
                    
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==false && auxSeleccionList==1){

                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorMarcaVehiculo.obtenerCodMarcaVeh(jTextFieldCodMarcaVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==false && auxSeleccionList==1){
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorMarcaVehiculo.obtenerCodMarcaVeh(jTextFieldCodMarcaVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorMarcaVehiculo.obtenerCodMarcaVeh(jTextFieldCodMarcaVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldDescrModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodMarcaVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                }
            break;            
        }
    }//GEN-LAST:event_jButtonAceptarValidarCambiosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones, se limpia los campos
    private void jButtonAceptarGuardadoExitosoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoExitosoActionPerformed
       
        jPanelGuardadoExitoso.setBounds(-260, 115, 250, 100);
        jTextFieldCodModeloVeh.setBorder(null);
        jTextFieldCodMarcaVeh.setBorder(null);
        jTextFieldDescrModeloVeh.setBorder(null);
        limpiarCampos();
        jButtonAgregarModeloVeh.setEnabled(true);
        jButtonEditarModeloVeh.setEnabled(false);
        jButtonBorrarModeloVeh.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldCodMarcaVeh.setEditable(true);
        jTextFieldDescrModeloVeh.setEditable(true);
        jTextFieldCodModeloVeh.setEditable(true);
        jButtonRegMarcaVeh.setEnabled(true);
        jPanelListaMarcaVeh.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarGuardadoExitosoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarGuardadoErroneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoErroneoActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelGuardadoErroneo.setBounds(-260, 115, 250, 100);
                jButtonAgregarModeloVeh.setEnabled(true);
                jButtonEditarModeloVeh.setEnabled(false);
                jButtonBorrarModeloVeh.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodMarcaVeh.setEditable(true);
                jTextFieldDescrModeloVeh.setEditable(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jButtonRegMarcaVeh.setEnabled(true);
            break;
            
            case 2:
                jPanelGuardadoErroneo.setBounds(-260, 115, 250, 100);
                jButtonAgregarModeloVeh.setEnabled(false);
                jButtonEditarModeloVeh.setEnabled(true);
                jButtonBorrarModeloVeh.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodMarcaVeh.setEditable(true);
                jTextFieldDescrModeloVeh.setEditable(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jButtonRegMarcaVeh.setEnabled(true);
            break;
            
            case 3: 
                jPanelGuardadoErroneo.setBounds(-260, 115, 250, 100);
                jButtonAgregarModeloVeh.setEnabled(false);
                jButtonEditarModeloVeh.setEnabled(false);
                jButtonBorrarModeloVeh.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodMarcaVeh.setEditable(true);
                jTextFieldDescrModeloVeh.setEditable(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jPanelListaMarcaVeh.setVisible(true);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarGuardadoErroneoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarErrorBaseDeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarErrorBaseDeDatosActionPerformed
        
        jPanelErrorBaseDeDatos.setBounds(-260, 115, 250, 100);
        jButtonAgregarModeloVeh.setEnabled(true);
        jButtonEditarModeloVeh.setEnabled(false);
        jButtonBorrarModeloVeh.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldCodMarcaVeh.setEditable(true);
        jTextFieldDescrModeloVeh.setEditable(true);
        jTextFieldCodModeloVeh.setEditable(true);
        jPanelListaMarcaVeh.setVisible(true);
        jButtonRegMarcaVeh.setEnabled(true);
    }//GEN-LAST:event_jButtonAceptarErrorBaseDeDatosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarElementoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoExistenteActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelElementoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarModeloVeh.setEnabled(true);
                jButtonEditarModeloVeh.setEnabled(false);
                jButtonBorrarModeloVeh.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodMarcaVeh.setEditable(true);
                jTextFieldDescrModeloVeh.setEditable(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jButtonRegMarcaVeh.setEnabled(true);
            break;
            
            case 2:
                jPanelElementoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarModeloVeh.setEnabled(false);
                jButtonEditarModeloVeh.setEnabled(true);
                jButtonBorrarModeloVeh.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodMarcaVeh.setEditable(true);
                jTextFieldDescrModeloVeh.setEditable(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jButtonRegMarcaVeh.setEnabled(true);
            break;
            
            case 3: 
                jPanelElementoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarModeloVeh.setEnabled(false);
                jButtonEditarModeloVeh.setEnabled(false);
                jButtonBorrarModeloVeh.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodMarcaVeh.setEditable(true);
                jTextFieldDescrModeloVeh.setEditable(true);
                jTextFieldCodModeloVeh.setEditable(true);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarElementoExistenteActionPerformed

// se acomoda los objetos del frame para continuar trabajando. 
    private void jButtonAceptarItemNoSeleccionado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

        jTableModeloVeh.setEnabled(true);
        jPanelItemNoSeleccionado.setBounds(-260, 115, 250, 100); 
    }//GEN-LAST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

    private void jTextFieldCodMarcaVehFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodMarcaVehFocusGained

        jListMarcaVeh.setModel(_administradorMarcaVehiculo.cargarLista(jTextFieldCodMarcaVeh.getText()));
        jPanelListaMarcaVeh.setBounds(150,138, 200, 50);
    }//GEN-LAST:event_jTextFieldCodMarcaVehFocusGained

    private void jTextFieldCodMarcaVehKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodMarcaVehKeyReleased

        jListMarcaVeh.setModel(_administradorMarcaVehiculo.cargarLista(jTextFieldCodMarcaVeh.getText()));
        jPanelListaMarcaVeh.setBounds(150,138, 200, 50);
    }//GEN-LAST:event_jTextFieldCodMarcaVehKeyReleased

    private void jButtonRegMarcaVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegMarcaVehActionPerformed
        JFrameRegistroMarcasVehiculos obj = new JFrameRegistroMarcasVehiculos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegMarcaVehActionPerformed

    private void jListMarcaVehMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListMarcaVehMouseClicked
        int indexList = jListMarcaVeh.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList = 1;
            jTextFieldCodMarcaVeh.setText("");
            jTextFieldCodMarcaVeh.setText(jListMarcaVeh.getSelectedValue());
            jPanelListaMarcaVeh.setBounds(-300, 138, 200, 50);
        } else{
            auxSeleccionList = 0;
        }
        
    }//GEN-LAST:event_jListMarcaVehMouseClicked

    private void jTextFieldCodMarcaVehFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodMarcaVehFocusLost

        jPanelListaMarcaVeh.setBounds(-300,138, 200, 50);
    }//GEN-LAST:event_jTextFieldCodMarcaVehFocusLost

    private void jListMarcaVehFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListMarcaVehFocusGained

        jPanelListaMarcaVeh.setBounds(150,138, 200, 50); 
    }//GEN-LAST:event_jListMarcaVehFocusGained

    private void jButtonAceptarElementoNoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoNoExistenteActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelElementoNoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarModeloVeh.setEnabled(true);
                jButtonEditarModeloVeh.setEnabled(false);
                jButtonBorrarModeloVeh.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodMarcaVeh.setEditable(true);
                jTextFieldDescrModeloVeh.setEditable(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jButtonRegMarcaVeh.setEnabled(true);
            break;
            
            case 2:
                jPanelElementoNoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarModeloVeh.setEnabled(false);
                jButtonEditarModeloVeh.setEnabled(true);
                jButtonBorrarModeloVeh.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodMarcaVeh.setEditable(true);
                jTextFieldDescrModeloVeh.setEditable(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jButtonRegMarcaVeh.setEnabled(true);
            break;
            
            case 3: 
                jPanelElementoNoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarModeloVeh.setEnabled(false);
                jButtonEditarModeloVeh.setEnabled(false);
                jButtonBorrarModeloVeh.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodMarcaVeh.setEditable(true);
                jTextFieldDescrModeloVeh.setEditable(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jPanelListaMarcaVeh.setVisible(true);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarElementoNoExistenteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAceptarElementoExistente;
    private javax.swing.JButton jButtonAceptarElementoNoExistente;
    private javax.swing.JButton jButtonAceptarErrorBaseDeDatos;
    private javax.swing.JButton jButtonAceptarGuardadoErroneo;
    private javax.swing.JButton jButtonAceptarGuardadoExitoso;
    private javax.swing.JButton jButtonAceptarItemNoSeleccionado2;
    private javax.swing.JButton jButtonAceptarValidarCambios;
    private javax.swing.JButton jButtonAgregarModeloVeh;
    private javax.swing.JButton jButtonBorrarModeloVeh;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelarValidarCambios;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonEditarModeloVeh;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JButton jButtonRegMarcaVeh;
    private javax.swing.JButton jButtonTraerPanelBuscar;
    private javax.swing.JButton jButtonTraerPanelCuerpo;
    private javax.swing.JLabel jLabelFondoIconoElementoExitente;
    private javax.swing.JLabel jLabelFondoIconoElementoNoExitente;
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
    private javax.swing.JLabel jLabelIconoErrorElementoNoExistente;
    private javax.swing.JLabel jLabelIconoErrorItemNoSeleccionado;
    private javax.swing.JLabel jLabelIconoExito;
    private javax.swing.JLabel jLabelIconoFondo;
    private javax.swing.JLabel jLabelIconoFondoCuerpo;
    private javax.swing.JLabel jLabelMensajeDos;
    private javax.swing.JLabel jLabelMensajeElementoExistente;
    private javax.swing.JLabel jLabelMensajeElementoExistente2;
    private javax.swing.JLabel jLabelMensajeElementoNoExistente;
    private javax.swing.JLabel jLabelMensajeElementoNoExistente2;
    private javax.swing.JLabel jLabelMensajeErrorBaseDeDatos;
    private javax.swing.JLabel jLabelMensajeErrorBaseDeDatos1;
    private javax.swing.JLabel jLabelMensajeGuardadoCorrecto;
    private javax.swing.JLabel jLabelMensajeGuardadoErroneo;
    private javax.swing.JLabel jLabelMensajeGuardadoErroneo2;
    private javax.swing.JLabel jLabelMensajeItemNoSeleccionado;
    private javax.swing.JLabel jLabelMensajeUno;
    private javax.swing.JLabel jLabelMensajeValidarCambios;
    private javax.swing.JLabel jLabelMensajeValidarCambios1;
    private javax.swing.JLabel jLabelTituloBuscarModeloVeh;
    private javax.swing.JLabel jLabelTituloCodModeloVeh;
    private javax.swing.JLabel jLabelTituloDescrModeloVeh;
    private javax.swing.JLabel jLabelTituloVentana;
    private javax.swing.JLabel jLabelTitulocodMarcaVeh;
    private javax.swing.JLabel jLabelToolKitMarca;
    private javax.swing.JList<String> jListMarcaVeh;
    private javax.swing.JPanel jPanelBarraTitulo;
    private javax.swing.JPanel jPanelCuerpo;
    private javax.swing.JPanel jPanelElementoExistente;
    private javax.swing.JPanel jPanelElementoNoExistente;
    private javax.swing.JPanel jPanelErrorBaseDeDatos;
    private javax.swing.JPanel jPanelGuardadoErroneo;
    private javax.swing.JPanel jPanelGuardadoExitoso;
    private javax.swing.JPanel jPanelItemNoSeleccionado;
    private javax.swing.JPanel jPanelListaMarcaVeh;
    private javax.swing.JPanel jPanelMensajeCerrar;
    private javax.swing.JPanel jPanelMensajeValidarABM;
    private javax.swing.JPanel jPanelVentanaBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparatorBuscarModeloVeh;
    private javax.swing.JSeparator jSeparatorCodMarcaVeh;
    private javax.swing.JSeparator jSeparatorCodModeloVeh;
    private javax.swing.JSeparator jSeparatorDescrModeloVeh;
    private javax.swing.JTable jTableModeloVeh;
    private javax.swing.JTextField jTextFieldBuscarModeloVeh;
    private javax.swing.JTextField jTextFieldCodMarcaVeh;
    private javax.swing.JTextField jTextFieldCodModeloVeh;
    private javax.swing.JTextField jTextFieldDescrModeloVeh;
    // End of variables declaration//GEN-END:variables
}
