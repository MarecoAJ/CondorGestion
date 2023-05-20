/*
* este JFrame registra (agrega, borra, edita, busca y filtra) todos los modelos de vehiculos
*/
package Vistas;

import administradorClases.Administrador;
import administradorClases.AdministradorMovimientoSeguros;
import administradorClases.AdministradorPolizaSiniestro;
import clasesDatos.MovimientoSeguros;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class JFrameRegistroMovimientoSeguros extends javax.swing.JFrame {
// atributos y variables    
    private final AdministradorMovimientoSeguros _administradorMovimientoSeguros;
    private final AdministradorPolizaSiniestro _administradorPolizaSiniestro;
    private MovimientoSeguros _objMovimientoSeguros;
    private TableModel modeloTablaMS;
    private int auxAbm;
    private int auxSeleccionList;
    
    public JFrameRegistroMovimientoSeguros() {
        initComponents();
// se personaliza las fuentes de letra de los objetos grafico
        jLabelTituloVentana.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 8));
        jLabelTituloIuMovimietoSeg.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldIuMovimientoSeg.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloIuPolizaSiniestro.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldIuPolizaSiniestro.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloBuscarMovimientoSeg.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldBuscarMovimientoSeg.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloFechaAproxCobro.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldFechaAproxCobro.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));

        
        jLabelMensajeElementoExistente.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeItemNoSeleccionado.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeErrorBaseDeDatos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));         
        jLabelMensajeGuardadoErroneo.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeGuardadoCorrecto.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeValidarCambios.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeUno.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeDos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
// se personaliza el jTable    
        jTableMovimientoSeguros.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 6));
        JTableHeader auxJTableHeader;
        auxJTableHeader = jTableMovimientoSeguros.getTableHeader();
        auxJTableHeader.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
// se instancia la clase AdministradorTipoPagos y se inicializa el menu del jTable
        _administradorMovimientoSeguros = new AdministradorMovimientoSeguros();
        _administradorPolizaSiniestro = new AdministradorPolizaSiniestro();
        popupMenuJTable();
        
        jButtonEditarMovimietoSeguros.setEnabled(false);
        jButtonBorrarMovimietoSeguros.setEnabled(false);
        jTextFieldIuMovimientoSeg.setEditable(false);
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
        jSeparatorBuscarMovimientoSeg = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMovimientoSeguros = new javax.swing.JTable();
        jLabelTituloBuscarMovimientoSeg = new javax.swing.JLabel();
        jTextFieldBuscarMovimientoSeg = new javax.swing.JTextField();
        jButtonTraerPanelCuerpo = new javax.swing.JButton();
        jLabelFondoVentanaBuscar = new javax.swing.JLabel();
        jPanelCuerpo = new javax.swing.JPanel();
        jPanelListaPolizaSiniestro = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListPolizaSiniestro = new javax.swing.JList<>();
        jButtonRegPolizaSiniestro = new javax.swing.JButton();
        jTextFieldFechaAproxCobro = new javax.swing.JTextField();
        jSeparatorFechaAproxCobro = new javax.swing.JSeparator();
        jLabelTituloFechaAproxCobro = new javax.swing.JLabel();
        jLabelTituloIuPolizaSiniestro = new javax.swing.JLabel();
        jTextFieldIuPolizaSiniestro = new javax.swing.JTextField();
        jSeparatorIuPolizaSiniestro = new javax.swing.JSeparator();
        jSeparatorIuMovimietoSeg = new javax.swing.JSeparator();
        jLabelTituloIuMovimietoSeg = new javax.swing.JLabel();
        jTextFieldIuMovimientoSeg = new javax.swing.JTextField();
        jButtonAgregarMovimietoSeguros = new javax.swing.JButton();
        jButtonEditarMovimietoSeguros = new javax.swing.JButton();
        jButtonBorrarMovimietoSeguros = new javax.swing.JButton();
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

        jSeparatorBuscarMovimientoSeg.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorBuscarMovimientoSeg.setForeground(new java.awt.Color(0, 0, 0));
        jPanelVentanaBuscar.add(jSeparatorBuscarMovimientoSeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 55, 100, 2));

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(480, 146));

        jTableMovimientoSeguros = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jTableMovimientoSeguros.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableMovimientoSeguros.setToolTipText("Has click derecho para opciones.");
        jTableMovimientoSeguros.setAutoscrolls(false);
        jTableMovimientoSeguros.setFocusable(false);
        jTableMovimientoSeguros.setMaximumSize(new java.awt.Dimension(480, 250));
        jTableMovimientoSeguros.setMinimumSize(new java.awt.Dimension(480, 250));
        jTableMovimientoSeguros.setPreferredSize(new java.awt.Dimension(480, 250));
        jTableMovimientoSeguros.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jTableMovimientoSeguros.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jTableMovimientoSeguros.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableMovimientoSeguros);

        jPanelVentanaBuscar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 480, 221));

        jLabelTituloBuscarMovimientoSeg.setText("Parametro de busqueda:");
        jPanelVentanaBuscar.add(jLabelTituloBuscarMovimientoSeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 10, -1, 25));

        jTextFieldBuscarMovimientoSeg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBuscarMovimientoSeg.setToolTipText("ingresa parametros de busqueda. Ej: chev");
        jTextFieldBuscarMovimientoSeg.setBorder(null);
        jTextFieldBuscarMovimientoSeg.setDisabledTextColor(new java.awt.Color(194, 4, 48));
        jTextFieldBuscarMovimientoSeg.setOpaque(false);
        jTextFieldBuscarMovimientoSeg.setSelectionColor(new java.awt.Color(73, 73, 73));
        jTextFieldBuscarMovimientoSeg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarMovimientoSegKeyReleased(evt);
            }
        });
        jPanelVentanaBuscar.add(jTextFieldBuscarMovimientoSeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 35, 100, 20));

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

        jPanelListaPolizaSiniestro.setMinimumSize(new java.awt.Dimension(200, 45));
        jPanelListaPolizaSiniestro.setOpaque(false);
        jPanelListaPolizaSiniestro.setPreferredSize(new java.awt.Dimension(200, 45));
        jPanelListaPolizaSiniestro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 45));

        jListPolizaSiniestro.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jListPolizaSiniestro.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jListPolizaSiniestro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListPolizaSiniestroFocusGained(evt);
            }
        });
        jListPolizaSiniestro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListPolizaSiniestroMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListPolizaSiniestro);

        jPanelListaPolizaSiniestro.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 45));

        jPanelCuerpo.add(jPanelListaPolizaSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 138, 200, 45));

        jButtonRegPolizaSiniestro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x25Off.png"))); // NOI18N
        jButtonRegPolizaSiniestro.setBorder(null);
        jButtonRegPolizaSiniestro.setBorderPainted(false);
        jButtonRegPolizaSiniestro.setContentAreaFilled(false);
        jButtonRegPolizaSiniestro.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegPolizaSiniestro.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegPolizaSiniestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegPolizaSiniestroActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonRegPolizaSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 113, -1, -1));

        jTextFieldFechaAproxCobro.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldFechaAproxCobro.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldFechaAproxCobro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldFechaAproxCobro.setToolTipText("Ingrese solo alfanumericos y simbolos(-) o (.). Ej.: palio");
        jTextFieldFechaAproxCobro.setBorder(null);
        jTextFieldFechaAproxCobro.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaAproxCobro.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaAproxCobro.setOpaque(false);
        jTextFieldFechaAproxCobro.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaAproxCobro.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldFechaAproxCobro, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 196, 100, 20));

        jSeparatorFechaAproxCobro.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorFechaAproxCobro.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorFechaAproxCobro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorFechaAproxCobro.setOpaque(true);
        jPanelCuerpo.add(jSeparatorFechaAproxCobro, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 216, 100, -1));

        jLabelTituloFechaAproxCobro.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloFechaAproxCobro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloFechaAproxCobro.setText("Fecha Aproximada de cobro:");
        jLabelTituloFechaAproxCobro.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloFechaAproxCobro, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 176, -1, 25));

        jLabelTituloIuPolizaSiniestro.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuPolizaSiniestro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuPolizaSiniestro.setText("Poliza y siniestro:");
        jLabelTituloIuPolizaSiniestro.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloIuPolizaSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 98, -1, 25));

        jTextFieldIuPolizaSiniestro.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuPolizaSiniestro.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuPolizaSiniestro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuPolizaSiniestro.setToolTipText("Ingrese solo alfanumericos y simbolos(-) o (.). Ej.: b-m.w");
        jTextFieldIuPolizaSiniestro.setBorder(null);
        jTextFieldIuPolizaSiniestro.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuPolizaSiniestro.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuPolizaSiniestro.setOpaque(false);
        jTextFieldIuPolizaSiniestro.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuPolizaSiniestro.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldIuPolizaSiniestro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIuPolizaSiniestroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldIuPolizaSiniestroFocusLost(evt);
            }
        });
        jTextFieldIuPolizaSiniestro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldIuPolizaSiniestroKeyReleased(evt);
            }
        });
        jPanelCuerpo.add(jTextFieldIuPolizaSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 118, 200, 20));

        jSeparatorIuPolizaSiniestro.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuPolizaSiniestro.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuPolizaSiniestro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuPolizaSiniestro.setOpaque(true);
        jPanelCuerpo.add(jSeparatorIuPolizaSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 138, 200, -1));

        jSeparatorIuMovimietoSeg.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuMovimietoSeg.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuMovimietoSeg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuMovimietoSeg.setOpaque(true);
        jPanelCuerpo.add(jSeparatorIuMovimietoSeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 66, 100, -1));

        jLabelTituloIuMovimietoSeg.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuMovimietoSeg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuMovimietoSeg.setText("Codigo identificacion:");
        jLabelTituloIuMovimietoSeg.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloIuMovimietoSeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 25, -1, 25));

        jTextFieldIuMovimientoSeg.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuMovimientoSeg.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuMovimientoSeg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuMovimientoSeg.setText("AUTOMATICO");
        jTextFieldIuMovimientoSeg.setToolTipText("Ingrese solo numeros. Ej.: 08");
        jTextFieldIuMovimientoSeg.setBorder(null);
        jTextFieldIuMovimientoSeg.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuMovimientoSeg.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuMovimientoSeg.setOpaque(false);
        jTextFieldIuMovimientoSeg.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuMovimientoSeg.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldIuMovimientoSeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 45, 100, 20));

        jButtonAgregarMovimietoSeguros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOff.png"))); // NOI18N
        jButtonAgregarMovimietoSeguros.setToolTipText("Has click para agregar.");
        jButtonAgregarMovimietoSeguros.setBorder(null);
        jButtonAgregarMovimietoSeguros.setBorderPainted(false);
        jButtonAgregarMovimietoSeguros.setContentAreaFilled(false);
        jButtonAgregarMovimietoSeguros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregarMovimietoSeguros.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarMovimietoSeguros.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarMovimietoSeguros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarMovimietoSegurosActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonAgregarMovimietoSeguros, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 251, -1, -1));

        jButtonEditarMovimietoSeguros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOff.png"))); // NOI18N
        jButtonEditarMovimietoSeguros.setToolTipText("Has click para editar.");
        jButtonEditarMovimietoSeguros.setBorder(null);
        jButtonEditarMovimietoSeguros.setBorderPainted(false);
        jButtonEditarMovimietoSeguros.setContentAreaFilled(false);
        jButtonEditarMovimietoSeguros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditarMovimietoSeguros.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarMovimietoSeguros.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarMovimietoSeguros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarMovimietoSegurosActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonEditarMovimietoSeguros, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 251, -1, -1));

        jButtonBorrarMovimietoSeguros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOff.png"))); // NOI18N
        jButtonBorrarMovimietoSeguros.setToolTipText("Has click para borrar.");
        jButtonBorrarMovimietoSeguros.setBorder(null);
        jButtonBorrarMovimietoSeguros.setBorderPainted(false);
        jButtonBorrarMovimietoSeguros.setContentAreaFilled(false);
        jButtonBorrarMovimietoSeguros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBorrarMovimietoSeguros.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarMovimietoSeguros.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarMovimietoSeguros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarMovimietoSegurosActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonBorrarMovimietoSeguros, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 251, -1, -1));

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
        jLabelTituloVentana.setText("Registro de movimientos de seguros");
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
    public void crearObjMovimientoSeguro(){
     
        _objMovimientoSeguros = new MovimientoSeguros();
        _objMovimientoSeguros.setIuMovimientoSeg(Integer.parseInt(jTextFieldIuMovimientoSeg.getText()));
        _objMovimientoSeguros.setIuPolizaSiniestro(_administradorPolizaSiniestro.obtenerIuPolizaSiniestro(jTextFieldIuPolizaSiniestro.getText()));
        _objMovimientoSeguros.setFechaAproxCobro(jTextFieldFechaAproxCobro.getText());
    }

// valida codMarcaVeh en caso de no hacer cick en a lista
    public void validarIuPolizaSiniestro(){
        System.err.println(_administradorPolizaSiniestro.obtenerIuPolizaSiniestro(jTextFieldIuPolizaSiniestro.getText()));
        if(_administradorPolizaSiniestro.obtenerIuPolizaSiniestro(jTextFieldIuPolizaSiniestro.getText()).length()==0){
            auxSeleccionList = 0;
        } else{
            auxSeleccionList = 1;
        }
    }
    
// limpia los jtextfield usados
    public void limpiarCampos(){

        jTextFieldIuMovimientoSeg.setText("AUTOMATICO");
        jTextFieldIuPolizaSiniestro.setText(""); 
        jTextFieldFechaAproxCobro.setText("");
        }
     
// este metodo crea menu de opciones al usar click secundario   
    public final void popupMenuJTable(){
//se crean las opciones del menu
        JPopupMenu jPopupMenuTableHMS = new JPopupMenu();
        JMenuItem jMenuItemEliminarMovimientoSeguro = new JMenuItem("Eliminar"); // cambiar x ico 
        JMenuItem jMenuItemModificarMovimientoSeguro = new JMenuItem("Modificar");
        JMenuItem jMenuOrdenar = new JMenu("Ordenar por");
        JMenuItem jMenuItemPrimerosAgregados = new JMenuItem("Primeros agregados");
        JMenuItem jMenuItemUltimosAgregados= new JMenuItem("Ultimos agregados");
        jMenuOrdenar.add(jMenuItemPrimerosAgregados);
        jMenuOrdenar.add(jMenuItemUltimosAgregados); 
// se generan las acciones de cada opcion
        jMenuItemEliminarMovimientoSeguro.addActionListener((ActionEvent e) -> {
        
        if(seleccionarItemJTabla()!= -1){
                 
            jPanelVentanaBuscar.setBounds(-500, 30, 500, 301);
            jPanelCuerpo.setBounds( 100,30,  500, 301);
              
            jButtonAgregarMovimietoSeguros.setEnabled(false);
            jButtonEditarMovimietoSeguros.setEnabled(false);
            jTextFieldIuMovimientoSeg.setEditable(false);
            jTextFieldIuPolizaSiniestro.setEditable(false); 
            jTextFieldFechaAproxCobro.setEditable(false);
            jButtonRegPolizaSiniestro.setEnabled(false);
            jListPolizaSiniestro.setVisible(false);
       
            jButtonBorrarMovimietoSeguros.setEnabled(true);
             }
         });
         
        jMenuItemModificarMovimientoSeguro.addActionListener((ActionEvent e) -> {
            
        if(seleccionarItemJTabla()!= -1){
                     
            jPanelVentanaBuscar.setBounds(-500, 30, 500, 301);
            jPanelCuerpo.setBounds( 100,30,  500, 301);
                
            jButtonAgregarMovimietoSeguros.setEnabled(false);
            jButtonBorrarMovimietoSeguros.setEnabled(false);
            jTextFieldIuMovimientoSeg.setEditable(false);   
            jButtonEditarMovimietoSeguros.setEnabled(true);
        }
        });
             
        jMenuItemUltimosAgregados.addActionListener((ActionEvent e) -> {
            _administradorMovimientoSeguros.ordenarTabla(jMenuItemUltimosAgregados.getText());
            jTableMovimientoSeguros.setModel( _administradorMovimientoSeguros.cargarJTabla());
        });
                                
        jMenuItemPrimerosAgregados.addActionListener((ActionEvent e) -> {
            _administradorMovimientoSeguros.ordenarTabla(jMenuItemPrimerosAgregados.getText());
            jTableMovimientoSeguros.setModel( _administradorMovimientoSeguros.cargarJTabla());
        });
// se construye el menu completo y se le asigna si jTable
        jPopupMenuTableHMS.add(jMenuItemEliminarMovimientoSeguro);
        jPopupMenuTableHMS.add(jMenuItemModificarMovimientoSeguro);
        jPopupMenuTableHMS.add(jMenuOrdenar);
        jTableMovimientoSeguros.setComponentPopupMenu(jPopupMenuTableHMS);  
     }
 
// se obtiene los datos del item seleccionado en la tabla
    public int seleccionarItemJTabla(){
// se obtiene el modelo y se verifica que se haya seleccionado un item   
        modeloTablaMS = jTableMovimientoSeguros.getModel();
        int auxSeleccion = jTableMovimientoSeguros.getSelectedRow();
        if (auxSeleccion != -1) {
            jTableMovimientoSeguros.setEnabled(true);
// se cargan los campos con los valores selcionados
            jTextFieldIuMovimientoSeg.setText((String)modeloTablaMS.getValueAt(jTableMovimientoSeguros.getSelectedRow(),0));
            jTextFieldIuPolizaSiniestro.setText((String)modeloTablaMS.getValueAt(jTableMovimientoSeguros.getSelectedRow(), 1));
            jTextFieldFechaAproxCobro.setText((String)modeloTablaMS.getValueAt(jTableMovimientoSeguros.getSelectedRow(),2));
            return auxSeleccion;
            
        }else {
// si no selecciona mensaje error   
            jTableMovimientoSeguros.setEnabled(false);
            jPanelItemNoSeleccionado.setBounds(225, 115, 250,100);
            return auxSeleccion;
        }
    }
    
//visualiza el panel buscar
    private void jButtonTraerPanelBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelBuscarActionPerformed
// llama al panel buscar 
    try {
        jTableMovimientoSeguros.setModel(_administradorMovimientoSeguros.cargarJTabla());
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
    private void jButtonAgregarMovimietoSegurosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarMovimietoSegurosActionPerformed
       
        jPanelMensajeValidarABM.setBounds(225, 115, 250, 100);
        auxAbm = 1;
        jButtonAgregarMovimietoSeguros.setEnabled(false);
        jButtonEditarMovimietoSeguros.setEnabled(false);
        jButtonBorrarMovimietoSeguros.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldIuMovimientoSeg.setEditable(false);
        jTextFieldFechaAproxCobro.setEditable(false);
        jButtonRegPolizaSiniestro.setEnabled(false);
    }//GEN-LAST:event_jButtonAgregarMovimietoSegurosActionPerformed

//valida datos y edita un registro en tabla TipoPagos
    private void jButtonEditarMovimietoSegurosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarMovimietoSegurosActionPerformed
        
        jPanelMensajeValidarABM.setBounds(225, 115, 250, 100);
        auxAbm = 2;
        jButtonAgregarMovimietoSeguros.setEnabled(false);
        jButtonEditarMovimietoSeguros.setEnabled(false);
        jButtonBorrarMovimietoSeguros.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldIuMovimientoSeg.setEditable(false);
        jTextFieldFechaAproxCobro.setEditable(false);
        jButtonRegPolizaSiniestro.setEnabled(false);
    }//GEN-LAST:event_jButtonEditarMovimietoSegurosActionPerformed

//valida datos y borra un registro en tabla TipoPagos 
    private void jButtonBorrarMovimietoSegurosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarMovimietoSegurosActionPerformed
        
        jPanelMensajeValidarABM.setBounds(225, 115, 250, 100);
        auxAbm = 3;
        jButtonAgregarMovimietoSeguros.setEnabled(false);
        jButtonEditarMovimietoSeguros.setEnabled(false);
        jButtonBorrarMovimietoSeguros.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldIuPolizaSiniestro.setEditable(false);
        jTextFieldFechaAproxCobro.setEditable(false);
        jButtonRegPolizaSiniestro.setEnabled(false);
    }//GEN-LAST:event_jButtonBorrarMovimietoSegurosActionPerformed

// con cada tecleo valida los datos y elimina los no correctos
    private void jTextFieldBuscarMovimientoSegKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarMovimientoSegKeyReleased
        boolean auxValidar = Administrador.validarCharDinamico(evt.getKeyChar(), "[a-zA-Z_0-9]||[\\s]");
    try {
        
        if(auxValidar==false){
               
            evt.consume();
            jTableMovimientoSeguros.setModel(_administradorMovimientoSeguros.buscarEnTabla(jTextFieldBuscarMovimientoSeg.getText()));
               
        } else{
           
            jTableMovimientoSeguros.setModel(_administradorMovimientoSeguros.buscarEnTabla(jTextFieldBuscarMovimientoSeg.getText()));
           }
    } catch (Exception e) {
        
        jPanelErrorBaseDeDatos.setBounds(225, 115, 250, 100);  
    }      
    }//GEN-LAST:event_jTextFieldBuscarMovimientoSegKeyReleased

//esconde el panel y habilita los obj en pantalla
    private void jButtonCancelarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarValidarCambiosActionPerformed
        
        auxAbm = 0;
        limpiarCampos();
        jPanelMensajeValidarABM.setBounds(-260, 115, 250, 100);
        jButtonAgregarMovimietoSeguros.setEnabled(true);
        jButtonEditarMovimietoSeguros.setEnabled(false);
        jButtonBorrarMovimietoSeguros.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldIuPolizaSiniestro.setEditable(true);
        jTextFieldFechaAproxCobro.setEditable(true);
        jTextFieldIuPolizaSiniestro.setBorder(null);
        jTextFieldFechaAproxCobro.setBorder(null);
        jButtonRegPolizaSiniestro.setEnabled(true);
        jPanelListaPolizaSiniestro.setVisible(true);
        jListPolizaSiniestro.setVisible(true);
    }//GEN-LAST:event_jButtonCancelarValidarCambiosActionPerformed

    private void jButtonAceptarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarValidarCambiosActionPerformed
        String aux;
        boolean auxValidar;
// llama al panel y segun desde donde llamo ejecuta la accion        
        jPanelMensajeValidarABM.setBounds(-260, 115, 250, 100);     
        switch(auxAbm){
            
            case 1:
// se validan los datos
                aux = jTextFieldFechaAproxCobro.getText();
                auxValidar = Administrador.validarFecha(aux);
                validarIuPolizaSiniestro();
// si es correcto se crea el objeto de la clase usada
                if(auxValidar==true && auxSeleccionList==1){

                    jTextFieldIuPolizaSiniestro.setBorder(new LineBorder(Color.green));
                    jTextFieldFechaAproxCobro.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = 0;
                    
                    _objMovimientoSeguros = new MovimientoSeguros();
                    _objMovimientoSeguros.setIuPolizaSiniestro(_administradorPolizaSiniestro.obtenerIuPolizaSiniestro(jTextFieldIuPolizaSiniestro.getText()));
                    _objMovimientoSeguros.setFechaAproxCobro(jTextFieldFechaAproxCobro.getText());
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorMovimientoSeguros.insertarTablaMovimientoSeguros(_objMovimientoSeguros)==true){
               
                            jPanelGuardadoExitoso.setBounds(225, 115, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(225, 115, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(225, 115, 250, 100);
    }
// en caso de no ser validos los datos se avisa al usuario
                } else if(auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldFechaAproxCobro.setBorder(new LineBorder(Color.green));
                    jTextFieldIuPolizaSiniestro.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar==false && auxSeleccionList==1){
                    jTextFieldFechaAproxCobro.setBorder(new LineBorder(Color.red));
                    jTextFieldIuPolizaSiniestro.setBorder(new LineBorder(Color.green));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if( auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldFechaAproxCobro.setBorder(new LineBorder(Color.red));
                    jTextFieldIuPolizaSiniestro.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                } 
            break;
// se repite el mismo codigo solo que se edita un item de la db 
            case 2:
// se validan los datos
                aux = jTextFieldFechaAproxCobro.getText();
                auxValidar = Administrador.validarFecha(aux);
                validarIuPolizaSiniestro();
// si es correcto se crea el objeto de la clase usada
                if(auxValidar==true && auxSeleccionList==1){

                    jTextFieldIuPolizaSiniestro.setBorder(new LineBorder(Color.green));
                    jTextFieldFechaAproxCobro.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = 0;
                    crearObjMovimientoSeguro();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorMovimientoSeguros.actualizarTablaMovimientoSeguros(_objMovimientoSeguros)==true){
               
                            jPanelGuardadoExitoso.setBounds(225, 115, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(225, 115, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(225, 115, 250, 100);
    }
// en caso de no ser validos los datos se avisa al usuario
                } else if(auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldFechaAproxCobro.setBorder(new LineBorder(Color.green));
                    jTextFieldIuPolizaSiniestro.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar==false && auxSeleccionList==1){
                    jTextFieldFechaAproxCobro.setBorder(new LineBorder(Color.red));
                    jTextFieldIuPolizaSiniestro.setBorder(new LineBorder(Color.green));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if( auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldFechaAproxCobro.setBorder(new LineBorder(Color.red));
                    jTextFieldIuPolizaSiniestro.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                } 
            break;
// se repite el mismo codigo solo que se borra un item de la db         
            case 3:
// se validan los datos
                aux = jTextFieldFechaAproxCobro.getText();
                auxValidar = Administrador.validarFecha(aux);
                validarIuPolizaSiniestro();
// si es correcto se crea el objeto de la clase usada
                if(auxValidar==true && auxSeleccionList==1){

                    jTextFieldIuPolizaSiniestro.setBorder(new LineBorder(Color.green));
                    jTextFieldFechaAproxCobro.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = 0;
                    crearObjMovimientoSeguro();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorMovimientoSeguros.eliminarTablaMovimientoSeguros(_objMovimientoSeguros)==true){
               
                            jPanelGuardadoExitoso.setBounds(225, 115, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(225, 115, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(225, 115, 250, 100);
    }
// en caso de no ser validos los datos se avisa al usuario
                } else if(auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldFechaAproxCobro.setBorder(new LineBorder(Color.green));
                    jTextFieldIuPolizaSiniestro.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if(auxValidar==false && auxSeleccionList==1){
                    jTextFieldFechaAproxCobro.setBorder(new LineBorder(Color.red));
                    jTextFieldIuPolizaSiniestro.setBorder(new LineBorder(Color.green));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if( auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldFechaAproxCobro.setBorder(new LineBorder(Color.red));
                    jTextFieldIuPolizaSiniestro.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                } 
            break;            
        }
    }//GEN-LAST:event_jButtonAceptarValidarCambiosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones, se limpia los campos
    private void jButtonAceptarGuardadoExitosoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoExitosoActionPerformed
       
        jPanelGuardadoExitoso.setBounds(-260, 115, 250, 100);
        jTextFieldIuPolizaSiniestro.setBorder(null);
        jTextFieldFechaAproxCobro.setBorder(null);
        limpiarCampos();
        jButtonAgregarMovimietoSeguros.setEnabled(true);
        jButtonEditarMovimietoSeguros.setEnabled(false);
        jButtonBorrarMovimietoSeguros.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldIuPolizaSiniestro.setEditable(true);
        jTextFieldFechaAproxCobro.setEditable(true);
        jListPolizaSiniestro.setVisible(true);
        jButtonRegPolizaSiniestro.setEnabled(true);
        jPanelListaPolizaSiniestro.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarGuardadoExitosoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarGuardadoErroneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoErroneoActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelGuardadoErroneo.setBounds(-260, 115, 250, 100);
                jButtonAgregarMovimietoSeguros.setEnabled(true);
                jButtonEditarMovimietoSeguros.setEnabled(false);
                jButtonBorrarMovimietoSeguros.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuPolizaSiniestro.setEditable(true);
                jTextFieldFechaAproxCobro.setEditable(true);
                
                jButtonRegPolizaSiniestro.setEnabled(true);
                jListPolizaSiniestro.setVisible(true);
                jPanelListaPolizaSiniestro.setVisible(true);
            break;
            
            case 2:
                jPanelGuardadoErroneo.setBounds(-260, 115, 250, 100);
                jButtonAgregarMovimietoSeguros.setEnabled(false);
                jButtonEditarMovimietoSeguros.setEnabled(true);
                jButtonBorrarMovimietoSeguros.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuPolizaSiniestro.setEditable(true);
                jTextFieldFechaAproxCobro.setEditable(true);
                
                jButtonRegPolizaSiniestro.setEnabled(true);
                jListPolizaSiniestro.setVisible(true);
                jPanelListaPolizaSiniestro.setVisible(true);
            break;
            
            case 3: 
                jPanelGuardadoErroneo.setBounds(-260, 115, 250, 100);
                jButtonAgregarMovimietoSeguros.setEnabled(false);
                jButtonEditarMovimietoSeguros.setEnabled(false);
                jButtonBorrarMovimietoSeguros.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuPolizaSiniestro.setEditable(false);
                jTextFieldFechaAproxCobro.setEditable(false);
                jListPolizaSiniestro.setVisible(false);
                jPanelListaPolizaSiniestro.setVisible(true);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarGuardadoErroneoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarErrorBaseDeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarErrorBaseDeDatosActionPerformed
        
        jPanelErrorBaseDeDatos.setBounds(-260, 115, 250, 100);
        jButtonAgregarMovimietoSeguros.setEnabled(true);
        jButtonEditarMovimietoSeguros.setEnabled(false);
        jButtonBorrarMovimietoSeguros.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldIuPolizaSiniestro.setEditable(true);
        jTextFieldFechaAproxCobro.setEditable(true);
        jListPolizaSiniestro.setVisible(true);
        jPanelListaPolizaSiniestro.setVisible(true);
        jButtonRegPolizaSiniestro.setEnabled(true);
    }//GEN-LAST:event_jButtonAceptarErrorBaseDeDatosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarElementoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoExistenteActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelElementoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarMovimietoSeguros.setEnabled(true);
                jButtonEditarMovimietoSeguros.setEnabled(false);
                jButtonBorrarMovimietoSeguros.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuPolizaSiniestro.setEditable(true);
                jTextFieldFechaAproxCobro.setEditable(true);
                jPanelListaPolizaSiniestro.setVisible(true);
                jListPolizaSiniestro.setVisible(true);
                jButtonRegPolizaSiniestro.setEnabled(true);
            break;
            
            case 2:
                jPanelElementoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarMovimietoSeguros.setEnabled(false);
                jButtonEditarMovimietoSeguros.setEnabled(true);
                jButtonBorrarMovimietoSeguros.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuPolizaSiniestro.setEditable(true);
                jTextFieldFechaAproxCobro.setEditable(true);
                jPanelListaPolizaSiniestro.setVisible(true);
                jListPolizaSiniestro.setVisible(true);
                jButtonRegPolizaSiniestro.setEnabled(true);
            break;
            
            case 3: 
                jPanelElementoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarMovimietoSeguros.setEnabled(false);
                jButtonEditarMovimietoSeguros.setEnabled(false);
                jButtonBorrarMovimietoSeguros.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuPolizaSiniestro.setEditable(false);
                jTextFieldFechaAproxCobro.setEditable(false);
                jPanelListaPolizaSiniestro.setVisible(true);
                jListPolizaSiniestro.setVisible(false);
                jButtonRegPolizaSiniestro.setEnabled(false);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarElementoExistenteActionPerformed

// se acomoda los objetos del frame para continuar trabajando. 
    private void jButtonAceptarItemNoSeleccionado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

        jTableMovimientoSeguros.setEnabled(true);
        jPanelItemNoSeleccionado.setBounds(-260, 115, 250, 100); 
    }//GEN-LAST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

    private void jTextFieldIuPolizaSiniestroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuPolizaSiniestroFocusGained

        jListPolizaSiniestro.setModel(_administradorPolizaSiniestro.cargarLista(jTextFieldIuPolizaSiniestro.getText()));
        jPanelListaPolizaSiniestro.setBounds(150,138, 200, 50);
    }//GEN-LAST:event_jTextFieldIuPolizaSiniestroFocusGained

    private void jTextFieldIuPolizaSiniestroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIuPolizaSiniestroKeyReleased

        jListPolizaSiniestro.setModel(_administradorPolizaSiniestro.cargarLista(jTextFieldIuPolizaSiniestro.getText()));
        jPanelListaPolizaSiniestro.setBounds(150,138, 200, 50);
    }//GEN-LAST:event_jTextFieldIuPolizaSiniestroKeyReleased

    private void jButtonRegPolizaSiniestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegPolizaSiniestroActionPerformed
        JFrameRegistroMarcasVehiculos obj = new JFrameRegistroMarcasVehiculos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegPolizaSiniestroActionPerformed

    private void jListPolizaSiniestroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPolizaSiniestroMouseClicked
        int indexList = jListPolizaSiniestro.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList = 1;
            jTextFieldIuPolizaSiniestro.setText("");
            jTextFieldIuPolizaSiniestro.setText(jListPolizaSiniestro.getSelectedValue());
            jPanelListaPolizaSiniestro.setBounds(-300, 138, 200, 50);
        } else{
            auxSeleccionList = 0;
        }
        
    }//GEN-LAST:event_jListPolizaSiniestroMouseClicked

    private void jTextFieldIuPolizaSiniestroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuPolizaSiniestroFocusLost

        jPanelListaPolizaSiniestro.setBounds(-300,138, 200, 50);
    }//GEN-LAST:event_jTextFieldIuPolizaSiniestroFocusLost

    private void jListPolizaSiniestroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListPolizaSiniestroFocusGained

        jPanelListaPolizaSiniestro.setBounds(150,138, 200, 50); 
    }//GEN-LAST:event_jListPolizaSiniestroFocusGained

    private void jButtonAceptarElementoNoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoNoExistenteActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelElementoNoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarMovimietoSeguros.setEnabled(true);
                jButtonEditarMovimietoSeguros.setEnabled(false);
                jButtonBorrarMovimietoSeguros.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuPolizaSiniestro.setEditable(true);
                jTextFieldFechaAproxCobro.setEditable(true);
                jPanelListaPolizaSiniestro.setVisible(true);
                jListPolizaSiniestro.setVisible(true);
                jButtonRegPolizaSiniestro.setEnabled(true);
            break;
            
            case 2:
                jPanelElementoNoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarMovimietoSeguros.setEnabled(false);
                jButtonEditarMovimietoSeguros.setEnabled(true);
                jButtonBorrarMovimietoSeguros.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuPolizaSiniestro.setEditable(true);
                jTextFieldFechaAproxCobro.setEditable(true);
                jPanelListaPolizaSiniestro.setVisible(true);
                jListPolizaSiniestro.setVisible(true);
                jButtonRegPolizaSiniestro.setEnabled(true);
            break;
            
            case 3: 
                jPanelElementoNoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarMovimietoSeguros.setEnabled(false);
                jButtonEditarMovimietoSeguros.setEnabled(false);
                jButtonBorrarMovimietoSeguros.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuPolizaSiniestro.setEditable(true);
                jTextFieldFechaAproxCobro.setEditable(true);
                jPanelListaPolizaSiniestro.setVisible(true);
                jListPolizaSiniestro.setVisible(false);
                jButtonRegPolizaSiniestro.setEnabled(false);
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
    private javax.swing.JButton jButtonAgregarMovimietoSeguros;
    private javax.swing.JButton jButtonBorrarMovimietoSeguros;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelarValidarCambios;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonEditarMovimietoSeguros;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JButton jButtonRegPolizaSiniestro;
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
    private javax.swing.JLabel jLabelTituloBuscarMovimientoSeg;
    private javax.swing.JLabel jLabelTituloFechaAproxCobro;
    private javax.swing.JLabel jLabelTituloIuMovimietoSeg;
    private javax.swing.JLabel jLabelTituloIuPolizaSiniestro;
    private javax.swing.JLabel jLabelTituloVentana;
    private javax.swing.JLabel jLabelToolKitMarca;
    private javax.swing.JList<String> jListPolizaSiniestro;
    private javax.swing.JPanel jPanelBarraTitulo;
    private javax.swing.JPanel jPanelCuerpo;
    private javax.swing.JPanel jPanelElementoExistente;
    private javax.swing.JPanel jPanelElementoNoExistente;
    private javax.swing.JPanel jPanelErrorBaseDeDatos;
    private javax.swing.JPanel jPanelGuardadoErroneo;
    private javax.swing.JPanel jPanelGuardadoExitoso;
    private javax.swing.JPanel jPanelItemNoSeleccionado;
    private javax.swing.JPanel jPanelListaPolizaSiniestro;
    private javax.swing.JPanel jPanelMensajeCerrar;
    private javax.swing.JPanel jPanelMensajeValidarABM;
    private javax.swing.JPanel jPanelVentanaBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparatorBuscarMovimientoSeg;
    private javax.swing.JSeparator jSeparatorFechaAproxCobro;
    private javax.swing.JSeparator jSeparatorIuMovimietoSeg;
    private javax.swing.JSeparator jSeparatorIuPolizaSiniestro;
    private javax.swing.JTable jTableMovimientoSeguros;
    private javax.swing.JTextField jTextFieldBuscarMovimientoSeg;
    private javax.swing.JTextField jTextFieldFechaAproxCobro;
    private javax.swing.JTextField jTextFieldIuMovimientoSeg;
    private javax.swing.JTextField jTextFieldIuPolizaSiniestro;
    // End of variables declaration//GEN-END:variables
}
