/*
* este JFrame registra (agrega, borra, edita, busca y filtra) todos los vehiculos
*/
package Vistas;

import administradorClases.Administrador;
import administradorClases.AdministradorModeloVehiculo;
import administradorClases.AdministradorVehiculos;
import clasesDatos.Vehiculos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class JFrameRegistroVehiculos extends javax.swing.JFrame {
// atributos y variables    
    private final AdministradorVehiculos _administradorVehiculos;
    private final AdministradorModeloVehiculo _administradorModeloVehiculo;
    private Vehiculos _objVehiculos;
    private TableModel modeloTablaV;
    private int auxAbm;
    private int auxSeleccionList;
    
    public JFrameRegistroVehiculos() {
        initComponents();
// se personaliza las fuentes de letra de los objetos grafico
        jLabelTituloVentana.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 8));
        jLabelTituloDominioVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldDominioVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTitulocodModeloVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldCodModeloVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloBuscarVehiculos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldBuscarVehiculos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloAnioVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldAnioVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));

        
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
        jTableVehiculos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 6));
        JTableHeader auxJTableHeader;
        auxJTableHeader = jTableVehiculos.getTableHeader();
        auxJTableHeader.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
// se instancia la clase AdministradorTipoPagos y se inicializa el menu del jTable
        _administradorModeloVehiculo = new AdministradorModeloVehiculo();
        _administradorVehiculos = new AdministradorVehiculos();
        popupMenuJTable();
        
        jButtonEditarVehiculos.setEnabled(false);
        jButtonBorrarVehiculos.setEnabled(false);
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
        jSeparatorBuscarVehiculos = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVehiculos = new javax.swing.JTable();
        jLabelTituloBuscarVehiculos = new javax.swing.JLabel();
        jTextFieldBuscarVehiculos = new javax.swing.JTextField();
        jButtonTraerPanelCuerpo = new javax.swing.JButton();
        jLabelFondoVentanaBuscar = new javax.swing.JLabel();
        jPanelCuerpo = new javax.swing.JPanel();
        jPanelListaModeloVeh = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListModeloVeh = new javax.swing.JList<>();
        jButtonRegModeloVeh = new javax.swing.JButton();
        jTextFieldAnioVeh = new javax.swing.JTextField();
        jSeparatorAnioVeh = new javax.swing.JSeparator();
        jLabelTituloAnioVeh = new javax.swing.JLabel();
        jLabelTitulocodModeloVeh = new javax.swing.JLabel();
        jTextFieldCodModeloVeh = new javax.swing.JTextField();
        jSeparatorCodModeloVeh = new javax.swing.JSeparator();
        jSeparatorDominioVeh = new javax.swing.JSeparator();
        jLabelTituloDominioVeh = new javax.swing.JLabel();
        jTextFieldDominioVeh = new javax.swing.JTextField();
        jButtonAgregarVehiculos = new javax.swing.JButton();
        jButtonEditarVehiculos = new javax.swing.JButton();
        jButtonBorrarVehiculos = new javax.swing.JButton();
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

        jSeparatorBuscarVehiculos.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorBuscarVehiculos.setForeground(new java.awt.Color(0, 0, 0));
        jPanelVentanaBuscar.add(jSeparatorBuscarVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 55, 100, 2));

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(480, 146));

        jTableVehiculos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jTableVehiculos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableVehiculos.setToolTipText("Has click derecho para opciones.");
        jTableVehiculos.setAutoscrolls(false);
        jTableVehiculos.setFocusable(false);
        jTableVehiculos.setMaximumSize(new java.awt.Dimension(480, 250));
        jTableVehiculos.setMinimumSize(new java.awt.Dimension(480, 250));
        jTableVehiculos.setPreferredSize(new java.awt.Dimension(480, 250));
        jTableVehiculos.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jTableVehiculos.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jTableVehiculos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableVehiculos);

        jPanelVentanaBuscar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 480, 221));

        jLabelTituloBuscarVehiculos.setText("Parametro de busqueda:");
        jPanelVentanaBuscar.add(jLabelTituloBuscarVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 10, -1, 25));

        jTextFieldBuscarVehiculos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBuscarVehiculos.setToolTipText("ingresa parametros de busqueda. Ej: chev");
        jTextFieldBuscarVehiculos.setBorder(null);
        jTextFieldBuscarVehiculos.setDisabledTextColor(new java.awt.Color(194, 4, 48));
        jTextFieldBuscarVehiculos.setOpaque(false);
        jTextFieldBuscarVehiculos.setSelectionColor(new java.awt.Color(73, 73, 73));
        jTextFieldBuscarVehiculos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarVehiculosKeyReleased(evt);
            }
        });
        jPanelVentanaBuscar.add(jTextFieldBuscarVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 35, 100, 20));

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

        jPanelListaModeloVeh.setMinimumSize(new java.awt.Dimension(200, 45));
        jPanelListaModeloVeh.setOpaque(false);
        jPanelListaModeloVeh.setPreferredSize(new java.awt.Dimension(200, 45));
        jPanelListaModeloVeh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 45));

        jListModeloVeh.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jListModeloVeh.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jListModeloVeh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListModeloVehFocusGained(evt);
            }
        });
        jListModeloVeh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListModeloVehMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListModeloVeh);

        jPanelListaModeloVeh.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 45));

        jPanelCuerpo.add(jPanelListaModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 138, 200, 45));

        jButtonRegModeloVeh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x25Off.png"))); // NOI18N
        jButtonRegModeloVeh.setBorder(null);
        jButtonRegModeloVeh.setBorderPainted(false);
        jButtonRegModeloVeh.setContentAreaFilled(false);
        jButtonRegModeloVeh.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegModeloVeh.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegModeloVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegModeloVehActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonRegModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 113, -1, -1));

        jTextFieldAnioVeh.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldAnioVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldAnioVeh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAnioVeh.setToolTipText("Ingrese solo numeros. Ej.: 2008");
        jTextFieldAnioVeh.setBorder(null);
        jTextFieldAnioVeh.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldAnioVeh.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldAnioVeh.setOpaque(false);
        jTextFieldAnioVeh.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldAnioVeh.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldAnioVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 196, 100, 20));

        jSeparatorAnioVeh.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorAnioVeh.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorAnioVeh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorAnioVeh.setOpaque(true);
        jPanelCuerpo.add(jSeparatorAnioVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 216, 100, -1));

        jLabelTituloAnioVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloAnioVeh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloAnioVeh.setText("Año del vehiculo:");
        jLabelTituloAnioVeh.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloAnioVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 176, -1, 25));

        jLabelTitulocodModeloVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTitulocodModeloVeh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTitulocodModeloVeh.setText("Modelo del vehiculo:");
        jLabelTitulocodModeloVeh.setToolTipText("");
        jPanelCuerpo.add(jLabelTitulocodModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 98, -1, 25));

        jTextFieldCodModeloVeh.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldCodModeloVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldCodModeloVeh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCodModeloVeh.setToolTipText("Ingrese solo alfanumericos y simbolos(-) o (.). Ej.: palio");
        jTextFieldCodModeloVeh.setBorder(null);
        jTextFieldCodModeloVeh.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldCodModeloVeh.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldCodModeloVeh.setOpaque(false);
        jTextFieldCodModeloVeh.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldCodModeloVeh.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldCodModeloVeh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldCodModeloVehFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCodModeloVehFocusLost(evt);
            }
        });
        jTextFieldCodModeloVeh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCodModeloVehKeyReleased(evt);
            }
        });
        jPanelCuerpo.add(jTextFieldCodModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 118, 200, 20));

        jSeparatorCodModeloVeh.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorCodModeloVeh.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorCodModeloVeh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorCodModeloVeh.setOpaque(true);
        jPanelCuerpo.add(jSeparatorCodModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 138, 200, -1));

        jSeparatorDominioVeh.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorDominioVeh.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorDominioVeh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorDominioVeh.setOpaque(true);
        jPanelCuerpo.add(jSeparatorDominioVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 66, 100, -1));

        jLabelTituloDominioVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloDominioVeh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloDominioVeh.setText("Dominio del vehiculo:");
        jLabelTituloDominioVeh.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloDominioVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 25, -1, 25));

        jTextFieldDominioVeh.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldDominioVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldDominioVeh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDominioVeh.setToolTipText("Ingrese solo alfanumericos. Ej.: nsw-083");
        jTextFieldDominioVeh.setBorder(null);
        jTextFieldDominioVeh.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldDominioVeh.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldDominioVeh.setOpaque(false);
        jTextFieldDominioVeh.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldDominioVeh.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldDominioVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 45, 100, 20));

        jButtonAgregarVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOff.png"))); // NOI18N
        jButtonAgregarVehiculos.setToolTipText("Has click para agregar.");
        jButtonAgregarVehiculos.setBorder(null);
        jButtonAgregarVehiculos.setBorderPainted(false);
        jButtonAgregarVehiculos.setContentAreaFilled(false);
        jButtonAgregarVehiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregarVehiculos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarVehiculos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarVehiculosActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonAgregarVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 251, -1, -1));

        jButtonEditarVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOff.png"))); // NOI18N
        jButtonEditarVehiculos.setToolTipText("Has click para editar.");
        jButtonEditarVehiculos.setBorder(null);
        jButtonEditarVehiculos.setBorderPainted(false);
        jButtonEditarVehiculos.setContentAreaFilled(false);
        jButtonEditarVehiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditarVehiculos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarVehiculos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarVehiculosActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonEditarVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 251, -1, -1));

        jButtonBorrarVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOff.png"))); // NOI18N
        jButtonBorrarVehiculos.setToolTipText("Has click para borrar.");
        jButtonBorrarVehiculos.setBorder(null);
        jButtonBorrarVehiculos.setBorderPainted(false);
        jButtonBorrarVehiculos.setContentAreaFilled(false);
        jButtonBorrarVehiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBorrarVehiculos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarVehiculos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarVehiculosActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonBorrarVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 251, -1, -1));

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
        jLabelTituloVentana.setText("Registro de vehiculos");
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
    public void crearObjVehiculos(){
     
        _objVehiculos = new Vehiculos();
        _objVehiculos.setDominioVeh(jTextFieldDominioVeh.getText());
        _objVehiculos.setCodModeloVeh(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()));
        _objVehiculos.setAnioVeh(Integer.parseInt(jTextFieldAnioVeh.getText()));
    }

// valida codModeloVeh en caso de no hacer cick en a lista
    public void validarCodModeloVeh(){
        if(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length()==0){
            auxSeleccionList = 0;
        } else{
            auxSeleccionList = 1;
        }
    }
    
// limpia los jtextfield usados
    public void limpiarCampos(){

        jTextFieldDominioVeh.setText("");
        jTextFieldCodModeloVeh.setText(""); 
        jTextFieldAnioVeh.setText("");
        }
     
// este metodo crea menu de opciones al usar click secundario   
    public final void popupMenuJTable(){
//se crean las opciones del menu
        JPopupMenu jPopupMenuTableHV = new JPopupMenu();
        JMenuItem jMenuItemEliminarVehiculo = new JMenuItem("Eliminar"); // cambiar x ico 
        JMenuItem jMenuItemModificarVehiculo = new JMenuItem("Modificar");
        JMenuItem jMenuOrdenar = new JMenu("Ordenar por");
        JMenuItem jMenuItemPrimerosAgregados = new JMenuItem("Primeros agregados");
        JMenuItem jMenuItemUltimosAgregados= new JMenuItem("Ultimos agregados");
        JMenuItem jMenuItemAlfabeticos = new JMenuItem("Alfabeticos"); 
        jMenuOrdenar.add(jMenuItemPrimerosAgregados);
        jMenuOrdenar.add(jMenuItemUltimosAgregados); 
        jMenuOrdenar.add(jMenuItemAlfabeticos);
// se generan las acciones de cada opcion
        jMenuItemEliminarVehiculo.addActionListener((ActionEvent e) -> {
        
        if(seleccionarItemJTabla()!= -1){
                 
            jPanelVentanaBuscar.setBounds(-500, 30, 500, 301);
            jPanelCuerpo.setBounds( 100,30,  500, 301);
              
            jButtonAgregarVehiculos.setEnabled(false);
            jButtonEditarVehiculos.setEnabled(false);
            jTextFieldDominioVeh.setEditable(false);
            jTextFieldCodModeloVeh.setEditable(false); 
            jTextFieldAnioVeh.setEditable(false);
            jButtonRegModeloVeh.setEnabled(false);
            jPanelListaModeloVeh.setVisible(false);
       
            jButtonBorrarVehiculos.setEnabled(true);
             }
         });
         
        jMenuItemModificarVehiculo.addActionListener((ActionEvent e) -> {
            
        if(seleccionarItemJTabla()!= -1){
                     
            jPanelVentanaBuscar.setBounds(-500, 30, 500, 301);
            jPanelCuerpo.setBounds( 100,30,  500, 301);
                
            jButtonAgregarVehiculos.setEnabled(false);
            jButtonBorrarVehiculos.setEnabled(false);
            jTextFieldDominioVeh.setEditable(false);   
            jButtonEditarVehiculos.setEnabled(true);
        }
        });
             
        jMenuItemUltimosAgregados.addActionListener((ActionEvent e) -> {
            _administradorVehiculos.ordenarTabla(jMenuItemUltimosAgregados.getText());
            jTableVehiculos.setModel( _administradorModeloVehiculo.cargarJTabla());
        });
                
        jMenuItemAlfabeticos.addActionListener((ActionEvent e) -> {
            _administradorVehiculos.ordenarTabla(jMenuItemAlfabeticos.getText());
            jTableVehiculos.setModel( _administradorVehiculos.cargarJTabla());
        });
                                
        jMenuItemPrimerosAgregados.addActionListener((ActionEvent e) -> {
            _administradorVehiculos.ordenarTabla(jMenuItemPrimerosAgregados.getText());
            jTableVehiculos.setModel( _administradorVehiculos.cargarJTabla());
        });
// se construye el menu completo y se le asigna si jTable
        jPopupMenuTableHV.add(jMenuItemEliminarVehiculo);
        jPopupMenuTableHV.add(jMenuItemModificarVehiculo);
        jPopupMenuTableHV.add(jMenuOrdenar);
        jTableVehiculos.setComponentPopupMenu(jPopupMenuTableHV);  
     }
 
// se obtiene los datos del item seleccionado en la tabla
    public int seleccionarItemJTabla(){
// se obtiene el modelo y se verifica que se haya seleccionado un item   
        modeloTablaV = jTableVehiculos.getModel();
        int auxSeleccion = jTableVehiculos.getSelectedRow();
        if (auxSeleccion != -1) {
            jTableVehiculos.setEnabled(true);
// se cargan los campos con los valores selcionados
            jTextFieldDominioVeh.setText((String)modeloTablaV.getValueAt(jTableVehiculos.getSelectedRow(), 0));
            jTextFieldCodModeloVeh.setText((String)modeloTablaV.getValueAt(jTableVehiculos.getSelectedRow(), 1));
            jTextFieldAnioVeh.setText((String)modeloTablaV.getValueAt(jTableVehiculos.getSelectedRow(),2));
            return auxSeleccion;
            
        }else {
// si no selecciona mensaje error   
            jTableVehiculos.setEnabled(false);
            jPanelItemNoSeleccionado.setBounds(225, 115, 250,100);
            return auxSeleccion;
        }
    }
    
//visualiza el panel buscar
    private void jButtonTraerPanelBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelBuscarActionPerformed
// llama al panel buscar 
    try {
        jTableVehiculos.setModel(_administradorVehiculos.cargarJTabla());
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
    private void jButtonAgregarVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarVehiculosActionPerformed
       
        jPanelMensajeValidarABM.setBounds(225, 115, 250, 100);
        auxAbm = 1;
        jButtonAgregarVehiculos.setEnabled(false);
        jButtonEditarVehiculos.setEnabled(false);
        jButtonBorrarVehiculos.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldDominioVeh.setEditable(false);
        jTextFieldCodModeloVeh.setEditable(false);
        jTextFieldAnioVeh.setEditable(false);
        jButtonRegModeloVeh.setEnabled(false);
    }//GEN-LAST:event_jButtonAgregarVehiculosActionPerformed

//valida datos y edita un registro en tabla TipoPagos
    private void jButtonEditarVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarVehiculosActionPerformed
        
        jPanelMensajeValidarABM.setBounds(225, 115, 250, 100);
        auxAbm = 2;
        jButtonAgregarVehiculos.setEnabled(false);
        jButtonEditarVehiculos.setEnabled(false);
        jButtonBorrarVehiculos.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldDominioVeh.setEditable(false);
        jTextFieldCodModeloVeh.setEditable(false);
        jTextFieldAnioVeh.setEditable(false);
        jButtonRegModeloVeh.setEnabled(false);
    }//GEN-LAST:event_jButtonEditarVehiculosActionPerformed

//valida datos y borra un registro en tabla TipoPagos 
    private void jButtonBorrarVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarVehiculosActionPerformed
        
        jPanelMensajeValidarABM.setBounds(225, 115, 250, 100);
        auxAbm = 3;
        jButtonAgregarVehiculos.setEnabled(false);
        jButtonEditarVehiculos.setEnabled(false);
        jButtonBorrarVehiculos.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldDominioVeh.setEditable(false);
        jTextFieldCodModeloVeh.setEditable(false);
        jTextFieldAnioVeh.setEditable(false);
        jButtonRegModeloVeh.setEnabled(false);
    }//GEN-LAST:event_jButtonBorrarVehiculosActionPerformed

// con cada tecleo valida los datos y elimina los no correctos
    private void jTextFieldBuscarVehiculosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarVehiculosKeyReleased
        boolean auxValidar = Administrador.validarCharDinamico(evt.getKeyChar(), "[a-zA-Z_0-9]||[\\s]");
    try {
        
        if(auxValidar==false){
               
            evt.consume();
            jTableVehiculos.setModel(_administradorVehiculos.buscarEnTabla(jTextFieldBuscarVehiculos.getText()));
               
        } else{
           
            jTableVehiculos.setModel(_administradorVehiculos.buscarEnTabla(jTextFieldBuscarVehiculos.getText()));
           }
    } catch (Exception e) {
        
        jPanelErrorBaseDeDatos.setBounds(225, 115, 250, 100);  
    }      
    }//GEN-LAST:event_jTextFieldBuscarVehiculosKeyReleased

//esconde el panel y habilita los obj en pantalla
    private void jButtonCancelarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarValidarCambiosActionPerformed
        
        auxAbm = 0;
        limpiarCampos();
        jPanelMensajeValidarABM.setBounds(-260, 115, 250, 100);
        jButtonAgregarVehiculos.setEnabled(true);
        jButtonEditarVehiculos.setEnabled(false);
        jButtonBorrarVehiculos.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldCodModeloVeh.setEditable(true);
        jTextFieldAnioVeh.setEditable(true);
        jTextFieldDominioVeh.setEditable(true);
        jTextFieldCodModeloVeh.setBorder(null);
        jTextFieldDominioVeh.setBorder(null);
        jTextFieldAnioVeh.setBorder(null);
        jButtonRegModeloVeh.setEnabled(true);
        jPanelListaModeloVeh.setVisible(true);
    }//GEN-LAST:event_jButtonCancelarValidarCambiosActionPerformed

    private void jButtonAceptarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarValidarCambiosActionPerformed
        String aux,aux2;
        boolean auxValidar, auxValidar2;
// llama al panel y segun desde donde llamo ejecuta la accion        
        jPanelMensajeValidarABM.setBounds(-260, 115, 250, 100);     
        switch(auxAbm){
            
            case 1:
// se validan los datos
                aux2 = jTextFieldDominioVeh.getText();
                auxValidar2 = Administrador.validarCamposTextos(aux2, "[a-zA-Z_0-9]||[-]" );
                aux = jTextFieldAnioVeh.getText();
                auxValidar = Administrador.validarCamposTextos(aux,"\\d");
                validarCodModeloVeh();
// si es correcto se crea el objeto de la clase usada
                if(auxValidar2==true && auxValidar==true && auxSeleccionList==1){

                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = 0;
                    crearObjVehiculos();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorVehiculos.insertarTablaVehiculos(_objVehiculos)==true){
               
                            jPanelGuardadoExitoso.setBounds(225, 115, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(225, 115, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(225, 115, 250, 100);
    }
// en caso de no ser validos los datos se avisa al usuario
                } else if(auxValidar2==false && auxValidar==true && auxSeleccionList==1){
                    
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==false && auxSeleccionList==1){
                    System.err.println("www");
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==false && auxSeleccionList==1){
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                }
            break;
// se repite el mismo codigo solo que se edita un item de la db 
            case 2:
// se validan los datos
                aux2 = jTextFieldDominioVeh.getText();
                auxValidar2 = Administrador.validarCamposTextos(aux2,"[a-zA-Z_0-9]||[-]");
                aux = jTextFieldAnioVeh.getText();
                auxValidar = Administrador.validarCamposTextos(aux,"\\d");
                validarCodModeloVeh();
// si es correcto se crea el objeto de la clase usada
                if(auxValidar2==true && auxValidar==true && auxSeleccionList==1){

                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = 0;
                    crearObjVehiculos();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorVehiculos.actualizarTablaVehiculos(_objVehiculos)==true){
               
                            jPanelGuardadoExitoso.setBounds(225, 115, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(225, 115, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(225, 115, 250, 100);
    }
// en caso de no ser validos los datos se avisa al usuario
                } else if(auxValidar2==false && auxValidar==true && auxSeleccionList==1){
                    
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==false && auxSeleccionList==1){

                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==false && auxSeleccionList==1){
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 100, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                }
            break;
// se repite el mismo codigo solo que se borra un item de la db         
            case 3:
// se validan los datos
                aux2 = jTextFieldDominioVeh.getText();
                auxValidar2 = Administrador.validarCamposTextos(aux2,"[a-zA-Z_0-9]||[-]");
                aux = jTextFieldAnioVeh.getText();
                auxValidar = Administrador.validarCamposTextos(aux,"\\d");
                validarCodModeloVeh();
// si es correcto se crea el objeto de la clase usada
                if(auxValidar2==true && auxValidar==true && auxSeleccionList==1){

                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = 0;
                    crearObjVehiculos();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorVehiculos.eliminarTablaVehiculos(_objVehiculos)==true){
               
                            jPanelGuardadoExitoso.setBounds(225, 115, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(225, 115, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(225, 115, 250, 100);
    }
// en caso de no ser validos los datos se avisa al usuario
                } else if(auxValidar2==false && auxValidar==true && auxSeleccionList==1){
                    
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==false && auxSeleccionList==1){

                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==false && auxSeleccionList==1){
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar2==true && auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    if(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                } else if(auxValidar2==false && auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldAnioVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                }
            break;            
        }
    }//GEN-LAST:event_jButtonAceptarValidarCambiosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones, se limpia los campos
    private void jButtonAceptarGuardadoExitosoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoExitosoActionPerformed
       
        jPanelGuardadoExitoso.setBounds(-260, 115, 250, 100);
        jTextFieldDominioVeh.setBorder(null);
        jTextFieldCodModeloVeh.setBorder(null);
        jTextFieldAnioVeh.setBorder(null);
        limpiarCampos();
        jButtonAgregarVehiculos.setEnabled(true);
        jButtonEditarVehiculos.setEnabled(false);
        jButtonBorrarVehiculos.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldCodModeloVeh.setEditable(true);
        jTextFieldAnioVeh.setEditable(true);
        jTextFieldDominioVeh.setEditable(true);
        jButtonRegModeloVeh.setEnabled(true);
        jPanelListaModeloVeh.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarGuardadoExitosoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarGuardadoErroneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoErroneoActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelGuardadoErroneo.setBounds(-260, 115, 250, 100);
                jButtonAgregarVehiculos.setEnabled(true);
                jButtonEditarVehiculos.setEnabled(false);
                jButtonBorrarVehiculos.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jTextFieldAnioVeh.setEditable(true);
                jTextFieldDominioVeh.setEditable(true);
                jButtonRegModeloVeh.setEnabled(true);
            break;
            
            case 2:
                jPanelGuardadoErroneo.setBounds(-260, 115, 250, 100);
                jButtonAgregarVehiculos.setEnabled(false);
                jButtonEditarVehiculos.setEnabled(true);
                jButtonBorrarVehiculos.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jTextFieldAnioVeh.setEditable(true);
                jTextFieldDominioVeh.setEditable(true);
                jButtonRegModeloVeh.setEnabled(true);
            break;
            
            case 3: 
                jPanelGuardadoErroneo.setBounds(-260, 115, 250, 100);
                jButtonAgregarVehiculos.setEnabled(false);
                jButtonEditarVehiculos.setEnabled(false);
                jButtonBorrarVehiculos.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jTextFieldAnioVeh.setEditable(true);
                jTextFieldDominioVeh.setEditable(true);
                jPanelListaModeloVeh.setVisible(true);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarGuardadoErroneoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarErrorBaseDeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarErrorBaseDeDatosActionPerformed
        
        jPanelErrorBaseDeDatos.setBounds(-260, 115, 250, 100);
        jButtonAgregarVehiculos.setEnabled(true);
        jButtonEditarVehiculos.setEnabled(false);
        jButtonBorrarVehiculos.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldCodModeloVeh.setEditable(true);
        jTextFieldAnioVeh.setEditable(true);
        jTextFieldDominioVeh.setEditable(true);
        jPanelListaModeloVeh.setVisible(true);
        jButtonRegModeloVeh.setEnabled(true);
    }//GEN-LAST:event_jButtonAceptarErrorBaseDeDatosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarElementoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoExistenteActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelElementoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarVehiculos.setEnabled(true);
                jButtonEditarVehiculos.setEnabled(false);
                jButtonBorrarVehiculos.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jTextFieldAnioVeh.setEditable(true);
                jTextFieldDominioVeh.setEditable(true);
                jButtonRegModeloVeh.setEnabled(true);
            break;
            
            case 2:
                jPanelElementoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarVehiculos.setEnabled(false);
                jButtonEditarVehiculos.setEnabled(true);
                jButtonBorrarVehiculos.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jTextFieldAnioVeh.setEditable(true);
                jTextFieldDominioVeh.setEditable(true);
                jButtonRegModeloVeh.setEnabled(true);
            break;
            
            case 3: 
                jPanelElementoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarVehiculos.setEnabled(false);
                jButtonEditarVehiculos.setEnabled(false);
                jButtonBorrarVehiculos.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jTextFieldAnioVeh.setEditable(true);
                jTextFieldDominioVeh.setEditable(true);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarElementoExistenteActionPerformed

// se acomoda los objetos del frame para continuar trabajando. 
    private void jButtonAceptarItemNoSeleccionado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

        jTableVehiculos.setEnabled(true);
        jPanelItemNoSeleccionado.setBounds(-260, 115, 250, 100); 
    }//GEN-LAST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

    private void jTextFieldCodModeloVehFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodModeloVehFocusGained

        jListModeloVeh.setModel(_administradorModeloVehiculo.cargarLista(jTextFieldCodModeloVeh.getText()));
        jPanelListaModeloVeh.setBounds(150,138, 200, 50);
    }//GEN-LAST:event_jTextFieldCodModeloVehFocusGained

    private void jTextFieldCodModeloVehKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodModeloVehKeyReleased

        jListModeloVeh.setModel(_administradorModeloVehiculo.cargarLista(jTextFieldCodModeloVeh.getText()));
        jPanelListaModeloVeh.setBounds(150,138, 200, 50);
    }//GEN-LAST:event_jTextFieldCodModeloVehKeyReleased

    private void jButtonRegModeloVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegModeloVehActionPerformed
        JFrameRegistroMarcasVehiculos obj = new JFrameRegistroMarcasVehiculos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegModeloVehActionPerformed

    private void jListModeloVehMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModeloVehMouseClicked
        int indexList = jListModeloVeh.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList = 1;
            jTextFieldCodModeloVeh.setText("");
            jTextFieldCodModeloVeh.setText(jListModeloVeh.getSelectedValue());
            jPanelListaModeloVeh.setBounds(-300, 138, 200, 50);
        } else{
            auxSeleccionList = 0;
        }
        
    }//GEN-LAST:event_jListModeloVehMouseClicked

    private void jTextFieldCodModeloVehFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodModeloVehFocusLost

        jPanelListaModeloVeh.setBounds(-300,138, 200, 50);
    }//GEN-LAST:event_jTextFieldCodModeloVehFocusLost

    private void jListModeloVehFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListModeloVehFocusGained

        jPanelListaModeloVeh.setBounds(150,138, 200, 50); 
    }//GEN-LAST:event_jListModeloVehFocusGained

    private void jButtonAceptarElementoNoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoNoExistenteActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelElementoNoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarVehiculos.setEnabled(true);
                jButtonEditarVehiculos.setEnabled(false);
                jButtonBorrarVehiculos.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jTextFieldAnioVeh.setEditable(true);
                jTextFieldDominioVeh.setEditable(true);
                jButtonRegModeloVeh.setEnabled(true);
            break;
            
            case 2:
                jPanelElementoNoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarVehiculos.setEnabled(false);
                jButtonEditarVehiculos.setEnabled(true);
                jButtonBorrarVehiculos.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jTextFieldAnioVeh.setEditable(true);
                jTextFieldDominioVeh.setEditable(true);
                jButtonRegModeloVeh.setEnabled(true);
            break;
            
            case 3: 
                jPanelElementoNoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarVehiculos.setEnabled(false);
                jButtonEditarVehiculos.setEnabled(false);
                jButtonBorrarVehiculos.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jTextFieldAnioVeh.setEditable(true);
                jTextFieldDominioVeh.setEditable(true);
                jPanelListaModeloVeh.setVisible(true);
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
    private javax.swing.JButton jButtonAgregarVehiculos;
    private javax.swing.JButton jButtonBorrarVehiculos;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelarValidarCambios;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonEditarVehiculos;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JButton jButtonRegModeloVeh;
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
    private javax.swing.JLabel jLabelTituloAnioVeh;
    private javax.swing.JLabel jLabelTituloBuscarVehiculos;
    private javax.swing.JLabel jLabelTituloDominioVeh;
    private javax.swing.JLabel jLabelTituloVentana;
    private javax.swing.JLabel jLabelTitulocodModeloVeh;
    private javax.swing.JLabel jLabelToolKitMarca;
    private javax.swing.JList<String> jListModeloVeh;
    private javax.swing.JPanel jPanelBarraTitulo;
    private javax.swing.JPanel jPanelCuerpo;
    private javax.swing.JPanel jPanelElementoExistente;
    private javax.swing.JPanel jPanelElementoNoExistente;
    private javax.swing.JPanel jPanelErrorBaseDeDatos;
    private javax.swing.JPanel jPanelGuardadoErroneo;
    private javax.swing.JPanel jPanelGuardadoExitoso;
    private javax.swing.JPanel jPanelItemNoSeleccionado;
    private javax.swing.JPanel jPanelListaModeloVeh;
    private javax.swing.JPanel jPanelMensajeCerrar;
    private javax.swing.JPanel jPanelMensajeValidarABM;
    private javax.swing.JPanel jPanelVentanaBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparatorAnioVeh;
    private javax.swing.JSeparator jSeparatorBuscarVehiculos;
    private javax.swing.JSeparator jSeparatorCodModeloVeh;
    private javax.swing.JSeparator jSeparatorDominioVeh;
    private javax.swing.JTable jTableVehiculos;
    private javax.swing.JTextField jTextFieldAnioVeh;
    private javax.swing.JTextField jTextFieldBuscarVehiculos;
    private javax.swing.JTextField jTextFieldCodModeloVeh;
    private javax.swing.JTextField jTextFieldDominioVeh;
    // End of variables declaration//GEN-END:variables
}
