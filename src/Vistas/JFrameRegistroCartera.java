/*
* este JFrame registra (agrega, borra, edita, busca y filtra) el catalogo de cartera
*/
package Vistas;

import administradorClases.Administrador;
import administradorClases.AdministradorTipoCarteras;
import administradorClases.AdministradorCartera;
import clasesDatos.Cartera;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class JFrameRegistroCartera extends javax.swing.JFrame {
// atributos y variables    
    private final AdministradorTipoCarteras _administradorTipoCarteras;
    private final AdministradorCartera _administradorCartera;
    private Cartera _objCartera;
    private TableModel modeloTablaC;
    private int auxAbm;
    private boolean auxSeleccionList;
    private String auxListasIuTipoCartera;
    
    public JFrameRegistroCartera() {
        initComponents();
// se personaliza las fuentes de letra de los objetos grafico
        jLabelTituloVentana.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 8));
        jLabelTituloIuCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldIuCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jLabelTituloTipoCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldTipoCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloBuscarCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldBuscarCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloDniOCuitCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldDniOCuitCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloNombCompletoCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldNombCompletoCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloDireccionCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldDireccionCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
                
        jLabelMensajeElementoExistente.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeElementoExistente2.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));         jLabelMensajeItemNoSeleccionado.setFont(Administrador.fuentesPersonalizada("/multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeErrorBaseDeDatos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));         jLabelMensajeErrorBaseDeDatos1.setFont(Administrador.fuentesPersonalizada("/multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeGuardadoErroneo.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeGuardadoErroneo2.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeGuardadoCorrecto.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeValidarCambios.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeValidarCambios1.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeUno.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeDos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
// se personaliza el jTable    
        jTableCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 6));
        JTableHeader auxJTableHeader;
        auxJTableHeader = jTableCartera.getTableHeader();
        auxJTableHeader.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
// se instancia la clase AdministradorTipoPagos y se inicializa el menu del jTable
        _administradorCartera = new AdministradorCartera();
        _administradorTipoCarteras = new AdministradorTipoCarteras();

        popupMenuJTable();
        
        jButtonEditarCartera.setEnabled(false);
        jButtonBorrarCartera.setEnabled(false);
        jTextFieldIuCartera.setEditable(false);
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
        jSeparatorBuscarCartera = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCartera = new javax.swing.JTable();
        jLabelTituloBuscarCartera = new javax.swing.JLabel();
        jTextFieldBuscarCartera = new javax.swing.JTextField();
        jButtonTraerPanelCuerpo = new javax.swing.JButton();
        jLabelFondoVentanaBuscar = new javax.swing.JLabel();
        jPanelCuerpo = new javax.swing.JPanel();
        jPanelListaTipoCartera = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListTipoCartera = new javax.swing.JList<>();
        jLabelTituloDireccionCartera = new javax.swing.JLabel();
        jSeparatorDireccionCartera = new javax.swing.JSeparator();
        jTextFieldDireccionCartera = new javax.swing.JTextField();
        jLabelTituloNombCompletoCartera = new javax.swing.JLabel();
        jSeparatorNombCompletoCartera = new javax.swing.JSeparator();
        jTextFieldNombCompletoCartera = new javax.swing.JTextField();
        jButtonRegTipoCartera = new javax.swing.JButton();
        jTextFieldDniOCuitCartera = new javax.swing.JTextField();
        jSeparatorDniOCuitCartera = new javax.swing.JSeparator();
        jLabelTituloDniOCuitCartera = new javax.swing.JLabel();
        jLabelTituloTipoCartera = new javax.swing.JLabel();
        jTextFieldTipoCartera = new javax.swing.JTextField();
        jSeparatorTipoCartera = new javax.swing.JSeparator();
        jSeparatorIuCartera = new javax.swing.JSeparator();
        jLabelTituloIuCartera = new javax.swing.JLabel();
        jTextFieldIuCartera = new javax.swing.JTextField();
        jButtonAgregarCartera = new javax.swing.JButton();
        jButtonEditarCartera = new javax.swing.JButton();
        jButtonBorrarCartera = new javax.swing.JButton();
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
        setMinimumSize(new java.awt.Dimension(900, 487));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(900, 487));
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

        getContentPane().add(jPanelElementoNoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 100, 250, 100));

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

        getContentPane().add(jPanelMensajeCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, 193, 250, 100));

        jPanelVentanaBuscar.setBackground(new java.awt.Color(245, 245, 245));
        jPanelVentanaBuscar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanelVentanaBuscar.setMaximumSize(new java.awt.Dimension(700, 457));
        jPanelVentanaBuscar.setMinimumSize(new java.awt.Dimension(700, 457));
        jPanelVentanaBuscar.setOpaque(false);
        jPanelVentanaBuscar.setPreferredSize(new java.awt.Dimension(700, 457));
        jPanelVentanaBuscar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparatorBuscarCartera.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorBuscarCartera.setForeground(new java.awt.Color(0, 0, 0));
        jPanelVentanaBuscar.add(jSeparatorBuscarCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 55, 100, 2));

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(480, 302));

        jTableCartera = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jTableCartera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N° de reg.", "Tipo de cartera", "Dni o CUIT ", "Nombre", "Direccion"
            }
        ));
        jTableCartera.setToolTipText("Has click derecho para opciones.");
        jTableCartera.setAutoscrolls(false);
        jTableCartera.setFocusable(false);
        jTableCartera.setMaximumSize(new java.awt.Dimension(480, 377));
        jTableCartera.setMinimumSize(new java.awt.Dimension(480, 377));
        jTableCartera.setPreferredSize(new java.awt.Dimension(480, 377));
        jTableCartera.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jTableCartera.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jTableCartera.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableCartera);

        jPanelVentanaBuscar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 680, 377));

        jLabelTituloBuscarCartera.setText("Parametro de busqueda:");
        jPanelVentanaBuscar.add(jLabelTituloBuscarCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 10, -1, 25));

        jTextFieldBuscarCartera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBuscarCartera.setToolTipText("ingresa parametros de busqueda. Ej:  parab");
        jTextFieldBuscarCartera.setBorder(null);
        jTextFieldBuscarCartera.setDisabledTextColor(new java.awt.Color(194, 4, 48));
        jTextFieldBuscarCartera.setOpaque(false);
        jTextFieldBuscarCartera.setSelectionColor(new java.awt.Color(73, 73, 73));
        jTextFieldBuscarCartera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarCarteraKeyReleased(evt);
            }
        });
        jPanelVentanaBuscar.add(jTextFieldBuscarCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 35, 100, 20));

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
        jPanelVentanaBuscar.add(jButtonTraerPanelCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 10, -1, -1));

        jLabelFondoVentanaBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondoCuerpo700x457.png"))); // NOI18N
        jLabelFondoVentanaBuscar.setToolTipText("");
        jPanelVentanaBuscar.add(jLabelFondoVentanaBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 457));

        getContentPane().add(jPanelVentanaBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-700, 30, 700, 457));

        jPanelCuerpo.setMaximumSize(new java.awt.Dimension(700, 457));
        jPanelCuerpo.setMinimumSize(new java.awt.Dimension(700, 457));
        jPanelCuerpo.setOpaque(false);
        jPanelCuerpo.setPreferredSize(new java.awt.Dimension(700, 457));
        jPanelCuerpo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelListaTipoCartera.setOpaque(false);
        jPanelListaTipoCartera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(200, 45));

        jListTipoCartera.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListTipoCarteraFocusGained(evt);
            }
        });
        jListTipoCartera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListTipoCarteraMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jListTipoCartera);

        jPanelListaTipoCartera.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 45));

        jPanelCuerpo.add(jPanelListaTipoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 138, 200, 45));

        jLabelTituloDireccionCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloDireccionCartera.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloDireccionCartera.setText("Domicilio:");
        jLabelTituloDireccionCartera.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloDireccionCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 250, -1, 25));

        jSeparatorDireccionCartera.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorDireccionCartera.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorDireccionCartera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorDireccionCartera.setOpaque(true);
        jPanelCuerpo.add(jSeparatorDireccionCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 295, 200, -1));

        jTextFieldDireccionCartera.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldDireccionCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldDireccionCartera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDireccionCartera.setToolTipText("Ingrese solo alfanumericos. Ej.: calle solo N34");
        jTextFieldDireccionCartera.setBorder(null);
        jTextFieldDireccionCartera.setMaximumSize(new java.awt.Dimension(25, 200));
        jTextFieldDireccionCartera.setMinimumSize(new java.awt.Dimension(25, 200));
        jTextFieldDireccionCartera.setOpaque(false);
        jTextFieldDireccionCartera.setPreferredSize(new java.awt.Dimension(25, 200));
        jTextFieldDireccionCartera.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldDireccionCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 275, 200, 20));

        jLabelTituloNombCompletoCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloNombCompletoCartera.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloNombCompletoCartera.setText("Nombre completo:");
        jLabelTituloNombCompletoCartera.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloNombCompletoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 176, -1, 25));

        jSeparatorNombCompletoCartera.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorNombCompletoCartera.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorNombCompletoCartera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorNombCompletoCartera.setOpaque(true);
        jPanelCuerpo.add(jSeparatorNombCompletoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 216, 200, -1));

        jTextFieldNombCompletoCartera.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldNombCompletoCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldNombCompletoCartera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNombCompletoCartera.setToolTipText("Ingrese solo texto. Ej.: Cristian.");
        jTextFieldNombCompletoCartera.setBorder(null);
        jTextFieldNombCompletoCartera.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldNombCompletoCartera.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldNombCompletoCartera.setOpaque(false);
        jTextFieldNombCompletoCartera.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldNombCompletoCartera.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldNombCompletoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 196, 200, 20));

        jButtonRegTipoCartera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x25Off.png"))); // NOI18N
        jButtonRegTipoCartera.setBorder(null);
        jButtonRegTipoCartera.setBorderPainted(false);
        jButtonRegTipoCartera.setContentAreaFilled(false);
        jButtonRegTipoCartera.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegTipoCartera.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegTipoCartera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegTipoCarteraActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonRegTipoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 113, -1, -1));

        jTextFieldDniOCuitCartera.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldDniOCuitCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldDniOCuitCartera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDniOCuitCartera.setToolTipText("Ingrese solo  numeros( sin guion, ni punto). Ej.: 20 37082055 0");
        jTextFieldDniOCuitCartera.setBorder(null);
        jTextFieldDniOCuitCartera.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldDniOCuitCartera.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldDniOCuitCartera.setOpaque(false);
        jTextFieldDniOCuitCartera.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldDniOCuitCartera.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldDniOCuitCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 196, 200, 20));

        jSeparatorDniOCuitCartera.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorDniOCuitCartera.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorDniOCuitCartera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorDniOCuitCartera.setOpaque(true);
        jPanelCuerpo.add(jSeparatorDniOCuitCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 216, 200, -1));

        jLabelTituloDniOCuitCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloDniOCuitCartera.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloDniOCuitCartera.setText("Dni o CUIT / L:");
        jLabelTituloDniOCuitCartera.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloDniOCuitCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 176, -1, 25));

        jLabelTituloTipoCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloTipoCartera.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloTipoCartera.setText("Tipo de cartera:");
        jLabelTituloTipoCartera.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloTipoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 98, -1, 25));

        jTextFieldTipoCartera.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldTipoCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldTipoCartera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTipoCartera.setToolTipText("Ingrese solo texto. Ej.: particular.");
        jTextFieldTipoCartera.setBorder(null);
        jTextFieldTipoCartera.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldTipoCartera.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldTipoCartera.setOpaque(false);
        jTextFieldTipoCartera.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldTipoCartera.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldTipoCartera.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldTipoCarteraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldTipoCarteraFocusLost(evt);
            }
        });
        jTextFieldTipoCartera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTipoCarteraKeyReleased(evt);
            }
        });
        jPanelCuerpo.add(jTextFieldTipoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 118, 200, 20));

        jSeparatorTipoCartera.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorTipoCartera.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorTipoCartera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorTipoCartera.setOpaque(true);
        jPanelCuerpo.add(jSeparatorTipoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 138, 200, -1));

        jSeparatorIuCartera.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuCartera.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuCartera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuCartera.setOpaque(true);
        jPanelCuerpo.add(jSeparatorIuCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 66, 100, -1));

        jLabelTituloIuCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuCartera.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuCartera.setText("Codigo identificacion:");
        jLabelTituloIuCartera.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloIuCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 25, -1, 25));

        jTextFieldIuCartera.setEditable(false);
        jTextFieldIuCartera.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuCartera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuCartera.setText("AUTOMATICO");
        jTextFieldIuCartera.setToolTipText("");
        jTextFieldIuCartera.setBorder(null);
        jTextFieldIuCartera.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuCartera.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuCartera.setOpaque(false);
        jTextFieldIuCartera.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuCartera.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldIuCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 45, 100, 20));

        jButtonAgregarCartera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOff.png"))); // NOI18N
        jButtonAgregarCartera.setToolTipText("Has click para agregar.");
        jButtonAgregarCartera.setBorder(null);
        jButtonAgregarCartera.setBorderPainted(false);
        jButtonAgregarCartera.setContentAreaFilled(false);
        jButtonAgregarCartera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregarCartera.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarCartera.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarCartera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarCarteraActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonAgregarCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 407, -1, -1));

        jButtonEditarCartera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOff.png"))); // NOI18N
        jButtonEditarCartera.setToolTipText("Has click para editar.");
        jButtonEditarCartera.setBorder(null);
        jButtonEditarCartera.setBorderPainted(false);
        jButtonEditarCartera.setContentAreaFilled(false);
        jButtonEditarCartera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditarCartera.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarCartera.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarCartera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarCarteraActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonEditarCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 407, -1, -1));

        jButtonBorrarCartera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOff.png"))); // NOI18N
        jButtonBorrarCartera.setToolTipText("Has click para borrar.");
        jButtonBorrarCartera.setBorder(null);
        jButtonBorrarCartera.setBorderPainted(false);
        jButtonBorrarCartera.setContentAreaFilled(false);
        jButtonBorrarCartera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBorrarCartera.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarCartera.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarCartera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarCarteraActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonBorrarCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 407, -1, -1));

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
        jPanelCuerpo.add(jButtonTraerPanelBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 10, -1, -1));

        jLabelIconoFondoCuerpo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondoCuerpo700x457.png"))); // NOI18N
        jPanelCuerpo.add(jLabelIconoFondoCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanelCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 700, 457));

        jPanelBarraTitulo.setMaximumSize(new java.awt.Dimension(900, 30));
        jPanelBarraTitulo.setMinimumSize(new java.awt.Dimension(900, 30));
        jPanelBarraTitulo.setOpaque(false);
        jPanelBarraTitulo.setPreferredSize(new java.awt.Dimension(900, 30));
        jPanelBarraTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTituloVentana.setFont(new java.awt.Font("Open Sans Extrabold", 0, 11)); // NOI18N
        jLabelTituloVentana.setForeground(new java.awt.Color(245, 245, 245));
        jLabelTituloVentana.setText("Registro de carteras");
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
        jPanelBarraTitulo.add(jButtonMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 3, -1, -1));

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
        jPanelBarraTitulo.add(jButtonCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 3, -1, -1));

        jLabelIconoBarraTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/barraTitulo900x30Radial.png"))); // NOI18N
        jPanelBarraTitulo.add(jLabelIconoBarraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanelBarraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 30));

        jLabelToolKitMarca.setToolTipText("Eldorado parabrisas");
        getContentPane().add(jLabelToolKitMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 430, 50, 50));

        jLabelIconoFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo900x487Logo.png"))); // NOI18N
        getContentPane().add(jLabelIconoFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

// se crea un objeto de la clase utilizada    
    public void crearObjCartera(){
     
        _objCartera = new Cartera();
        _objCartera.setIuCartera(Integer.parseInt(jTextFieldIuCartera.getText()));
        _objCartera.setIuTipoCartera(_administradorTipoCarteras.obtenerIuTipoCartera(jTextFieldTipoCartera.getText()));
        _objCartera.setDniOCuit(jTextFieldDniOCuitCartera.getText());
        _objCartera.setNombCompleto(jTextFieldNombCompletoCartera.getText());
        _objCartera.setDireccionCartera(jTextFieldDireccionCartera.getText());
    }

    
// valida iuTipoCartera en caso de no hacer cick en a lista
    public void validarIuTipoCartera(){
        
        if(_administradorTipoCarteras.obtenerIuTipoCartera(jTextFieldTipoCartera.getText())==0){
            auxSeleccionList = false;
        } else{
            auxSeleccionList = true;
        }
    }
    
// limpia los jtextfield usados
    public void limpiarCampos(){

        jTextFieldIuCartera.setText("AUTOMATICO");
        jTextFieldTipoCartera.setText(""); 
        jTextFieldDniOCuitCartera.setText("");
        jTextFieldNombCompletoCartera.setText("");
        jTextFieldDireccionCartera.setText("");
        }
     
// este metodo crea menu de opciones al usar click secundario   
    public final void popupMenuJTable(){
//se crean las opciones del menu
        JPopupMenu jPopupMenuTableHC = new JPopupMenu();
        JMenuItem jMenuItemEliminarCartera = new JMenuItem("Eliminar"); // cambiar x ico 
        JMenuItem jMenuItemModificarCartera = new JMenuItem("Modificar");
        JMenuItem jMenuOrdenar = new JMenu("Ordenar por");
        JMenuItem jMenuItemPrimerosAgregados = new JMenuItem("Primeros agregados");
        JMenuItem jMenuItemUltimosAgregados= new JMenuItem("Ultimos agregados");
        JMenuItem jMenuItemAlfabeticos = new JMenuItem("Alfabeticos"); 
        jMenuOrdenar.add(jMenuItemPrimerosAgregados);
        jMenuOrdenar.add(jMenuItemUltimosAgregados); 
        jMenuOrdenar.add(jMenuItemAlfabeticos);
// se generan las acciones de cada opcion
        jMenuItemEliminarCartera.addActionListener((ActionEvent e) -> {
        
        if(seleccionarItemJTabla()!= -1){
                 
            jPanelVentanaBuscar.setBounds(-700, 30, 700, 457);
            jPanelCuerpo.setBounds( 100,30,  700, 457);
              
            jButtonAgregarCartera.setEnabled(false);
            jButtonEditarCartera.setEnabled(false);
            jTextFieldTipoCartera.setEditable(false); 
            jTextFieldDniOCuitCartera.setEditable(false);
            jTextFieldNombCompletoCartera.setEditable(false);
            jTextFieldDireccionCartera.setEditable(false);
            jButtonRegTipoCartera.setEnabled(false);
            jListTipoCartera.setVisible(false);
            jPanelListaTipoCartera.setVisible(false);
            jButtonBorrarCartera.setEnabled(true);
             }
         });
         
        jMenuItemModificarCartera.addActionListener((ActionEvent e) -> {
            
        if(seleccionarItemJTabla()!= -1){
                     
            jPanelVentanaBuscar.setBounds(-700, 30, 700, 457);
            jPanelCuerpo.setBounds( 100,30,  700, 457);
                
            jButtonAgregarCartera.setEnabled(false);
            jTextFieldTipoCartera.setEditable(true); 
            jTextFieldDniOCuitCartera.setEditable(true);
            jTextFieldNombCompletoCartera.setEditable(true);
            jTextFieldDireccionCartera.setEditable(true);
            jButtonRegTipoCartera.setEnabled(false);
            jListTipoCartera.setVisible(true);
            jPanelListaTipoCartera.setVisible(true);
            jButtonBorrarCartera.setEnabled(false);
            jButtonEditarCartera.setEnabled(true);
            jButtonRegTipoCartera.setEnabled(true);
        }
        });
             
        jMenuItemUltimosAgregados.addActionListener((ActionEvent e) -> {
            _administradorCartera.ordenarTabla(jMenuItemUltimosAgregados.getText());
            jTableCartera.setModel( _administradorCartera.cargarJTabla());
        });
                
        jMenuItemAlfabeticos.addActionListener((ActionEvent e) -> {
            _administradorCartera.ordenarTabla(jMenuItemAlfabeticos.getText());
            jTableCartera.setModel( _administradorCartera.cargarJTabla());
        });
                                
        jMenuItemPrimerosAgregados.addActionListener((ActionEvent e) -> {
            _administradorCartera.ordenarTabla(jMenuItemPrimerosAgregados.getText());
            jTableCartera.setModel( _administradorCartera.cargarJTabla());
        });
// se construye el menu completo y se le asigna si jTable
        jPopupMenuTableHC.add(jMenuItemEliminarCartera);
        jPopupMenuTableHC.add(jMenuItemModificarCartera);
        jPopupMenuTableHC.add(jMenuOrdenar);
        jTableCartera.setComponentPopupMenu(jPopupMenuTableHC);  
     }
 
// se obtiene los datos del item seleccionado en la tabla
    public int seleccionarItemJTabla(){
// se obtiene el modelo y se verifica que se haya seleccionado un item   
        modeloTablaC = jTableCartera.getModel();
        int auxSeleccion = jTableCartera.getSelectedRow();
        if (auxSeleccion != -1) {
            jTableCartera.setEnabled(true);
// se cargan los campos con los valores selcionados
            jTextFieldIuCartera.setText((String)modeloTablaC.getValueAt(jTableCartera.getSelectedRow(), 0));
            jTextFieldTipoCartera.setText((String)modeloTablaC.getValueAt(jTableCartera.getSelectedRow(), 1));
            jTextFieldDniOCuitCartera.setText((String)modeloTablaC.getValueAt(jTableCartera.getSelectedRow(),2));
            jTextFieldNombCompletoCartera.setText((String)modeloTablaC.getValueAt(jTableCartera.getSelectedRow(), 3));
            jTextFieldDireccionCartera.setText((String)modeloTablaC.getValueAt(jTableCartera.getSelectedRow(), 4));
            return auxSeleccion;
            
        }else {
// si no selecciona mensaje error   
            jTableCartera.setEnabled(false);
            jPanelItemNoSeleccionado.setBounds(325, 193, 250,100);
            return auxSeleccion;
        }
    }
    
//visualiza el panel buscar
    private void jButtonTraerPanelBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelBuscarActionPerformed
// llama al panel buscar 
    try {
        jTableCartera.setModel(_administradorCartera.cargarJTabla());
    } catch (Exception e) {
        jPanelErrorBaseDeDatos.setBounds(325, 193, 250, 100);
    }
        jPanelCuerpo.setBounds(-700, 30, 700, 457);
        jPanelVentanaBuscar.setBounds( 100,30,  700, 457);      
    }//GEN-LAST:event_jButtonTraerPanelBuscarActionPerformed

//visualiza el cuerpo donde esta el ABM
    private void jButtonTraerPanelCuerpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelCuerpoActionPerformed
//llama al panel contenedor del abm
        jPanelVentanaBuscar.setBounds(-700, 30, 700, 457);
        jPanelCuerpo.setBounds( 100,30,  700, 457);
    }//GEN-LAST:event_jButtonTraerPanelCuerpoActionPerformed
   
// visualiza panel  ventana cerrar
    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed

        jPanelCuerpo.setBounds(-700, 30, 500, 270);
        jPanelVentanaBuscar.setBounds(-700, 30, 500, 270);
        jPanelMensajeCerrar.setBounds( 325, 193,  250, 100);
        jPanelElementoExistente.setBounds(-260, 193, 250,  100);
        jPanelErrorBaseDeDatos.setBounds(-260, 193, 250,  100);
        jPanelGuardadoErroneo.setBounds(-260, 193, 250,  100);
        jPanelGuardadoExitoso.setBounds(-260, 193, 250,  100);
        jPanelItemNoSeleccionado.setBounds(-260, 193, 250,  100);
        jPanelMensajeValidarABM.setBounds(-260, 193, 250,  100);
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
        
        jPanelMensajeCerrar.setBounds(-700, 100, 250, 100);
        jPanelCuerpo.setBounds( 100,30, 700, 457);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

// valida datos y agrega a tabla TipoPagos un registro 
    private void jButtonAgregarCarteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarCarteraActionPerformed
       
        jPanelMensajeValidarABM.setBounds(325, 193, 250, 100);
        auxAbm = 1;
        jButtonAgregarCartera.setEnabled(false);
        jButtonEditarCartera.setEnabled(false);
        jButtonBorrarCartera.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldTipoCartera.setEditable(false);
        jTextFieldDniOCuitCartera.setEditable(false);
        jTextFieldNombCompletoCartera.setEditable(false);
        jTextFieldDireccionCartera.setEditable(false);
        jButtonRegTipoCartera.setEnabled(false);
        jListTipoCartera.setVisible(false);
    }//GEN-LAST:event_jButtonAgregarCarteraActionPerformed

//valida datos y edita un registro en tabla TipoPagos
    private void jButtonEditarCarteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarCarteraActionPerformed
        
        jPanelMensajeValidarABM.setBounds(325, 193, 250, 100);
        auxAbm = 2;
        jButtonAgregarCartera.setEnabled(false);
        jButtonEditarCartera.setEnabled(false);
        jButtonBorrarCartera.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldTipoCartera.setEditable(false);
        jTextFieldDniOCuitCartera.setEditable(false);
        jTextFieldNombCompletoCartera.setEditable(false);
        jTextFieldDireccionCartera.setEditable(false);
        jButtonRegTipoCartera.setEnabled(false);
        jListTipoCartera.setVisible(false);
    }//GEN-LAST:event_jButtonEditarCarteraActionPerformed

//valida datos y borra un registro en tabla TipoPagos 
    private void jButtonBorrarCarteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarCarteraActionPerformed
        
        jPanelMensajeValidarABM.setBounds(325, 193, 250, 100);
        auxAbm = 3;
        jButtonAgregarCartera.setEnabled(false);
        jButtonEditarCartera.setEnabled(false);
        jButtonBorrarCartera.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldTipoCartera.setEditable(false);
        jTextFieldDniOCuitCartera.setEditable(false);
        jTextFieldNombCompletoCartera.setEditable(false);
        jTextFieldDireccionCartera.setEditable(false);
        jButtonRegTipoCartera.setEnabled(false);
        jListTipoCartera.setVisible(false);
    }//GEN-LAST:event_jButtonBorrarCarteraActionPerformed

// con cada tecleo valida los datos y elimina los no correctos
    private void jTextFieldBuscarCarteraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarCarteraKeyReleased
        boolean auxValidar = Administrador.validarCharDinamico(evt.getKeyChar(), "[a-zA-Z_0-9]||[\\s]");
    try {
        
        if(auxValidar==false){
               
            evt.consume();
            jTableCartera.setModel(_administradorCartera.buscarEnTabla(jTextFieldBuscarCartera.getText()));
               
        } else{
           
            jTableCartera.setModel(_administradorCartera.buscarEnTabla(jTextFieldBuscarCartera.getText()));
           }
    } catch (Exception e) {
        
        jPanelErrorBaseDeDatos.setBounds(325, 193, 250, 100);  
    }      
    }//GEN-LAST:event_jTextFieldBuscarCarteraKeyReleased

//esconde el panel y habilita los obj en pantalla
    private void jButtonCancelarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarValidarCambiosActionPerformed
        
        auxAbm = 0;
        limpiarCampos();
        jPanelMensajeValidarABM.setBounds(-260, 193, 250, 100);
        jButtonAgregarCartera.setEnabled(true);
        jButtonEditarCartera.setEnabled(false);
        jButtonBorrarCartera.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldTipoCartera.setEditable(true);
        jTextFieldDniOCuitCartera.setEditable(true);
        jTextFieldNombCompletoCartera.setEditable(true);
        jTextFieldDireccionCartera.setEditable(true);
        jButtonRegTipoCartera.setEnabled(true);
        jListTipoCartera.setVisible(true);
        jPanelListaTipoCartera.setVisible(true);
        jTextFieldTipoCartera.setBorder(null);
        jTextFieldDniOCuitCartera.setBorder(null);
        jTextFieldNombCompletoCartera.setBorder(null);
        jTextFieldDireccionCartera.setBorder(null);
    }//GEN-LAST:event_jButtonCancelarValidarCambiosActionPerformed

    private void jButtonAceptarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarValidarCambiosActionPerformed
        boolean[] listaVerdades = new boolean[4];
        int aux = 0;
        int auxMensaje2 = 0;
        int auxMensaje = 0;
// llama al panel y segun desde donde llamo ejecuta la accion        
        jPanelMensajeValidarABM.setBounds(-260, 193, 250, 100);  
        switch(auxAbm){
            
            case 1:
                validarIuTipoCartera();
                listaVerdades[0] = auxSeleccionList;
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldDniOCuitCartera.getText(), "\\d");
                listaVerdades[2] = Administrador.validarCamposTextos(jTextFieldNombCompletoCartera.getText(), "[a-zA-Z]||[\\s]" );
                listaVerdades[3] = Administrador.validarCamposTextos(jTextFieldDireccionCartera.getText(), "[a-zA-Z_0-9]||[\\s]");
                
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==4){
                    jTextFieldTipoCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldDniOCuitCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldNombCompletoCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldDireccionCartera.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    
                    _objCartera = new Cartera();
                    _objCartera.setIuTipoCartera(_administradorTipoCarteras.obtenerIuTipoCartera(jTextFieldTipoCartera.getText()));
                    _objCartera.setDniOCuit(jTextFieldDniOCuitCartera.getText());
                    _objCartera.setNombCompleto(jTextFieldNombCompletoCartera.getText());
                    _objCartera.setDireccionCartera(jTextFieldDireccionCartera.getText());
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorCartera.insertarTablaCartera(_objCartera)==true){
               
                            jPanelGuardadoExitoso.setBounds(325, 193, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(325, 193, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(325, 193, 250, 100);
    }
                
                
                } else{
                    for (int i = 0; i < listaVerdades.length; i++) {
                        switch(i){
                            case 0:
                                if(listaVerdades[i]==true){
                                    jTextFieldTipoCartera.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldTipoCartera.setBorder(new LineBorder(Color.red));
                                    if(jTextFieldTipoCartera.getText().length()==0 || auxSeleccionList==false){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;        
                            case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldDniOCuitCartera.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDniOCuitCartera.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldNombCompletoCartera.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNombCompletoCartera.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldDireccionCartera.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDireccionCartera.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                        }
                    }
                    if(auxMensaje==1) jPanelElementoNoExistente.setBounds(325, 193, 250, 100);
                    if(auxMensaje2==1) jPanelGuardadoErroneo.setBounds(325, 193, 250, 100);
                    
                }               
            break;
// se repite el mismo codigo solo que se edita un item de la db 
               
            case 2:
// se validan los datos
                validarIuTipoCartera();
                listaVerdades[0] = auxSeleccionList;
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldDniOCuitCartera.getText(), "\\d");
                listaVerdades[2] = Administrador.validarCamposTextos(jTextFieldNombCompletoCartera.getText(), "[a-zA-Z]||[\\s]" );
                listaVerdades[3] = Administrador.validarCamposTextos(jTextFieldDireccionCartera.getText(), "[a-zA-Z_0-9]||[\\s]");
                System.err.println("actua");
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==4){
                    
                    jTextFieldTipoCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldDniOCuitCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldNombCompletoCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldDireccionCartera.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    crearObjCartera();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorCartera.actualizarTablaCartera(_objCartera)==true){
               
                            jPanelGuardadoExitoso.setBounds(325, 193, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(325, 193, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(325, 193, 250, 100);
    }
                
                
                } else{
                    for (int i = 0; i < listaVerdades.length; i++) {
                        switch(i){
                            case 0:
                                if(listaVerdades[i]==true){
                                    jTextFieldTipoCartera.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldTipoCartera.setBorder(new LineBorder(Color.red));
                                    if(jTextFieldTipoCartera.getText().length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;        
                            case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldDniOCuitCartera.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDniOCuitCartera.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldNombCompletoCartera.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNombCompletoCartera.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldDireccionCartera.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDireccionCartera.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                        }
                    }
                    if(auxMensaje==1) jPanelElementoNoExistente.setBounds(325, 193, 250, 100);
                    if(auxMensaje2==1) jPanelGuardadoErroneo.setBounds(325, 193, 250, 100);
                    
                }               
            break;
// se repite el mismo codigo solo que se borra un item de la db         
            case 3:
// se validan los datos
               validarIuTipoCartera();
                listaVerdades[0] = auxSeleccionList;
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldDniOCuitCartera.getText(), "\\d");
                listaVerdades[2] = Administrador.validarCamposTextos(jTextFieldNombCompletoCartera.getText(), "[a-zA-Z]||[\\s]" );
                listaVerdades[3] = Administrador.validarCamposTextos(jTextFieldDireccionCartera.getText(), "[a-zA-Z_0-9]||[\\s]");
                
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==4){
                    jTextFieldTipoCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldDniOCuitCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldNombCompletoCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldDireccionCartera.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    crearObjCartera();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorCartera.eliminarTablaCartera(_objCartera)==true){
               
                            jPanelGuardadoExitoso.setBounds(325, 193, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(325, 193, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(325, 193, 250, 100);
    }
                
                
                } else{
                    for (int i = 0; i < listaVerdades.length; i++) {
                        switch(i){
                            case 0:
                                if(listaVerdades[i]==true){
                                    jTextFieldTipoCartera.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldTipoCartera.setBorder(new LineBorder(Color.red));
                                    if(jTextFieldTipoCartera.getText().length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;        
                            case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldDniOCuitCartera.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDniOCuitCartera.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldNombCompletoCartera.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNombCompletoCartera.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldDireccionCartera.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDireccionCartera.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                        }
                    }
                    if(auxMensaje==1) jPanelElementoNoExistente.setBounds(325, 193, 250, 100);
                    if(auxMensaje2==1) jPanelGuardadoErroneo.setBounds(325, 193, 250, 100);
                    
                }               
            break;            
        }
    }//GEN-LAST:event_jButtonAceptarValidarCambiosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones, se limpia los campos
    private void jButtonAceptarGuardadoExitosoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoExitosoActionPerformed
       
        jPanelGuardadoExitoso.setBounds(-260, 193, 250, 100);
        jTextFieldTipoCartera.setBorder(null);
        jTextFieldDniOCuitCartera.setBorder(null);
        jTextFieldNombCompletoCartera.setBorder(null);
        jTextFieldDireccionCartera.setBorder(null);
        limpiarCampos();
        jButtonAgregarCartera.setEnabled(true);
        jButtonEditarCartera.setEnabled(false);
        jButtonBorrarCartera.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldTipoCartera.setEditable(true);
        jTextFieldDniOCuitCartera.setEditable(true);
        jTextFieldNombCompletoCartera.setEditable(true);
        jTextFieldDireccionCartera.setEditable(true);
        jButtonRegTipoCartera.setEnabled(true);
        jListTipoCartera.setVisible(true);
        jPanelListaTipoCartera.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarGuardadoExitosoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarGuardadoErroneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoErroneoActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelGuardadoErroneo.setBounds(-260, 193, 250, 100);
                jButtonAgregarCartera.setEnabled(true);
                jButtonEditarCartera.setEnabled(false);
                jButtonBorrarCartera.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldTipoCartera.setEditable(true);
                jTextFieldDniOCuitCartera.setEditable(true);
                jTextFieldNombCompletoCartera.setEditable(true);
                jTextFieldDireccionCartera.setEditable(true);
                jButtonRegTipoCartera.setEnabled(true);
                jListTipoCartera.setVisible(true);
                jPanelListaTipoCartera.setVisible(true);
            break;
            
            case 2:
                jPanelGuardadoErroneo.setBounds(-260, 193, 250, 100);
                jButtonAgregarCartera.setEnabled(true);
                jButtonEditarCartera.setEnabled(false);
                jButtonBorrarCartera.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldTipoCartera.setEditable(true);
                jTextFieldDniOCuitCartera.setEditable(true);
                jTextFieldNombCompletoCartera.setEditable(true);
                jTextFieldDireccionCartera.setEditable(true);
                jButtonRegTipoCartera.setEnabled(true);
                jListTipoCartera.setVisible(true);
                jPanelListaTipoCartera.setVisible(true);
            break;
            
            case 3: 
                jPanelGuardadoErroneo.setBounds(-260, 193, 250, 100);
                jButtonAgregarCartera.setEnabled(true);
                jButtonEditarCartera.setEnabled(false);
                jButtonBorrarCartera.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldTipoCartera.setEditable(true);
                jTextFieldDniOCuitCartera.setEditable(true);
                jTextFieldNombCompletoCartera.setEditable(true);
                jTextFieldDireccionCartera.setEditable(true);
                jButtonRegTipoCartera.setEnabled(true);
                jListTipoCartera.setVisible(false);
                jPanelListaTipoCartera.setVisible(false);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarGuardadoErroneoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarErrorBaseDeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarErrorBaseDeDatosActionPerformed
        
        jPanelErrorBaseDeDatos.setBounds(-260, 193, 250, 100);
        jButtonAgregarCartera.setEnabled(true);
        jButtonEditarCartera.setEnabled(false);
        jButtonBorrarCartera.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldTipoCartera.setEditable(true);
        jTextFieldDniOCuitCartera.setEditable(true);
        jTextFieldNombCompletoCartera.setEditable(true);
        jTextFieldDireccionCartera.setEditable(true);
        jButtonRegTipoCartera.setEnabled(true);
        jListTipoCartera.setVisible(true);
        jPanelListaTipoCartera.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarErrorBaseDeDatosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarElementoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoExistenteActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelElementoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarCartera.setEnabled(true);
                jButtonEditarCartera.setEnabled(false);
                jButtonBorrarCartera.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldTipoCartera.setEditable(true);
                jTextFieldDniOCuitCartera.setEditable(true);
                jTextFieldNombCompletoCartera.setEditable(true);
                jTextFieldDireccionCartera.setEditable(true);
                jButtonRegTipoCartera.setEnabled(true);
                jListTipoCartera.setVisible(true);
            break;
            
            case 2:
                jPanelElementoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarCartera.setEnabled(false);
                jButtonEditarCartera.setEnabled(true);
                jButtonBorrarCartera.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldTipoCartera.setEditable(true);
                jTextFieldDniOCuitCartera.setEditable(true);
                jTextFieldNombCompletoCartera.setEditable(true);
                jTextFieldDireccionCartera.setEditable(true);
                jButtonRegTipoCartera.setEnabled(true);
                jListTipoCartera.setVisible(true);
            break;
            
            case 3: 
                jPanelElementoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarCartera.setEnabled(false);
                jButtonEditarCartera.setEnabled(false);
                jButtonBorrarCartera.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldTipoCartera.setEditable(true);
                jTextFieldDniOCuitCartera.setEditable(true);
                jTextFieldNombCompletoCartera.setEditable(true);
                jTextFieldDireccionCartera.setEditable(true);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarElementoExistenteActionPerformed

// se acomoda los objetos del frame para continuar trabajando. 
    private void jButtonAceptarItemNoSeleccionado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

        jTableCartera.setEnabled(true);
        jPanelItemNoSeleccionado.setBounds(-260, 193, 250, 100); 
    }//GEN-LAST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

    private void jButtonAceptarElementoNoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoNoExistenteActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelElementoNoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarCartera.setEnabled(true);
                jButtonEditarCartera.setEnabled(false);
                jButtonBorrarCartera.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldTipoCartera.setEditable(true);
                jTextFieldDniOCuitCartera.setEditable(true);
                jTextFieldNombCompletoCartera.setEditable(true);
                jTextFieldDireccionCartera.setEditable(true);
                jListTipoCartera.setVisible(true);
                jPanelListaTipoCartera.setVisible(true);
                jButtonRegTipoCartera.setEnabled(true);
            break;
            
            case 2:
                jPanelElementoNoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarCartera.setEnabled(false);
                jButtonEditarCartera.setEnabled(true);
                jButtonBorrarCartera.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldTipoCartera.setEditable(true);
                jTextFieldDniOCuitCartera.setEditable(true);
                jTextFieldNombCompletoCartera.setEditable(true);
                jTextFieldDireccionCartera.setEditable(true);
                jListTipoCartera.setVisible(true);
                jPanelListaTipoCartera.setVisible(true);
                jButtonRegTipoCartera.setEnabled(true);
            break;
            
            case 3: 
                jPanelElementoNoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarCartera.setEnabled(false);
                jButtonEditarCartera.setEnabled(false);
                jButtonBorrarCartera.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldTipoCartera.setEditable(true);
                jTextFieldDniOCuitCartera.setEditable(true);
                jTextFieldNombCompletoCartera.setEditable(true);
                jListTipoCartera.setVisible(false);
                jPanelListaTipoCartera.setVisible(false);
                jButtonAgregarCartera.setEnabled(true);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarElementoNoExistenteActionPerformed

    private void jListTipoCarteraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListTipoCarteraFocusGained

        jPanelListaTipoCartera.setBounds(250,138, 200, 50);
    }//GEN-LAST:event_jListTipoCarteraFocusGained

    private void jListTipoCarteraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTipoCarteraMouseClicked
        int auxCCMV = 0;
        int indexList = jListTipoCartera.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList = true;
            jTextFieldTipoCartera.setText("");
            auxListasIuTipoCartera = jListTipoCartera.getSelectedValue();
            jTextFieldTipoCartera.setText(auxListasIuTipoCartera);
            auxCCMV = _administradorTipoCarteras.obtenerIuTipoCartera(auxListasIuTipoCartera);
            jTextFieldTipoCartera.setText(_administradorTipoCarteras.obtenerDescrTipoCartera(auxCCMV));
            jPanelListaTipoCartera.setBounds(-300, 138, 200, 50);
        } else{
            auxSeleccionList = false;
        }
      
    }//GEN-LAST:event_jListTipoCarteraMouseClicked

    private void jTextFieldTipoCarteraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTipoCarteraFocusGained

        jListTipoCartera.setModel(_administradorTipoCarteras.cargarLista(jTextFieldTipoCartera.getText()));
        jPanelListaTipoCartera.setBounds(250,138, 200, 50);
    }//GEN-LAST:event_jTextFieldTipoCarteraFocusGained

    private void jTextFieldTipoCarteraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTipoCarteraFocusLost

        jPanelListaTipoCartera.setBounds(-300,138, 200, 50);
    }//GEN-LAST:event_jTextFieldTipoCarteraFocusLost

    private void jTextFieldTipoCarteraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTipoCarteraKeyReleased

        jListTipoCartera.setModel(_administradorTipoCarteras.cargarLista(jTextFieldTipoCartera.getText()));
        jPanelListaTipoCartera.setBounds(250,138, 200, 50);
    }//GEN-LAST:event_jTextFieldTipoCarteraKeyReleased

    private void jButtonRegTipoCarteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegTipoCarteraActionPerformed
        JFrameRegistroTipoCarteras obj = new JFrameRegistroTipoCarteras();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegTipoCarteraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAceptarElementoExistente;
    private javax.swing.JButton jButtonAceptarElementoNoExistente;
    private javax.swing.JButton jButtonAceptarErrorBaseDeDatos;
    private javax.swing.JButton jButtonAceptarGuardadoErroneo;
    private javax.swing.JButton jButtonAceptarGuardadoExitoso;
    private javax.swing.JButton jButtonAceptarItemNoSeleccionado2;
    private javax.swing.JButton jButtonAceptarValidarCambios;
    private javax.swing.JButton jButtonAgregarCartera;
    private javax.swing.JButton jButtonBorrarCartera;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelarValidarCambios;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonEditarCartera;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JButton jButtonRegTipoCartera;
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
    private javax.swing.JLabel jLabelTituloBuscarCartera;
    private javax.swing.JLabel jLabelTituloDireccionCartera;
    private javax.swing.JLabel jLabelTituloDniOCuitCartera;
    private javax.swing.JLabel jLabelTituloIuCartera;
    private javax.swing.JLabel jLabelTituloNombCompletoCartera;
    private javax.swing.JLabel jLabelTituloTipoCartera;
    private javax.swing.JLabel jLabelTituloVentana;
    private javax.swing.JLabel jLabelToolKitMarca;
    private javax.swing.JList<String> jListTipoCartera;
    private javax.swing.JPanel jPanelBarraTitulo;
    private javax.swing.JPanel jPanelCuerpo;
    private javax.swing.JPanel jPanelElementoExistente;
    private javax.swing.JPanel jPanelElementoNoExistente;
    private javax.swing.JPanel jPanelErrorBaseDeDatos;
    private javax.swing.JPanel jPanelGuardadoErroneo;
    private javax.swing.JPanel jPanelGuardadoExitoso;
    private javax.swing.JPanel jPanelItemNoSeleccionado;
    private javax.swing.JPanel jPanelListaTipoCartera;
    private javax.swing.JPanel jPanelMensajeCerrar;
    private javax.swing.JPanel jPanelMensajeValidarABM;
    private javax.swing.JPanel jPanelVentanaBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparatorBuscarCartera;
    private javax.swing.JSeparator jSeparatorDireccionCartera;
    private javax.swing.JSeparator jSeparatorDniOCuitCartera;
    private javax.swing.JSeparator jSeparatorIuCartera;
    private javax.swing.JSeparator jSeparatorNombCompletoCartera;
    private javax.swing.JSeparator jSeparatorTipoCartera;
    private javax.swing.JTable jTableCartera;
    private javax.swing.JTextField jTextFieldBuscarCartera;
    private javax.swing.JTextField jTextFieldDireccionCartera;
    private javax.swing.JTextField jTextFieldDniOCuitCartera;
    private javax.swing.JTextField jTextFieldIuCartera;
    private javax.swing.JTextField jTextFieldNombCompletoCartera;
    private javax.swing.JTextField jTextFieldTipoCartera;
    // End of variables declaration//GEN-END:variables
}
