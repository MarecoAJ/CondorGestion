/*
* este JFrame registra (agrega, borra, edita, busca y filtra) todos la caja
*/
package Vistas;

import administradorClases.Administrador;
import administradorClases.AdministradorPolizaSiniestro;
import administradorClases.AdministradorSeguros;
import administradorClases.AdministradorVehiculos;
import clasesDatos.PolizaSiniestro;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class JFrameRegistroPolizaSiniestro extends javax.swing.JFrame {
// atributos y variables    
    private final AdministradorSeguros _administradorSeguros;
    private final AdministradorVehiculos _administradorVehiculos;
    private final AdministradorPolizaSiniestro _administradorPolizaSiniestro;
    private PolizaSiniestro _objPolizaSinestros;
    private TableModel modeloTablaPS;
    private String iuPolizaSiniestro;
    private int auxAbm;
    private boolean auxSeleccionList;
    private boolean auxSeleccionList2;
    
    public JFrameRegistroPolizaSiniestro() {
        initComponents();
// se personaliza las fuentes de letra de los objetos grafico
        jLabelTituloVentana.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 8));
        jLabelTituloIuPolizaSiniestro.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldIuPolizaSiniestro.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jLabelTituloIuSeguros.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldIuSeguros.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloNumPoliza.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldNumPoliza.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloBuscarPolizaSiniestro.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldBuscarPolizaSiniestro.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloNumSiniestro.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldNumSiniestro.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloNombreAsegurado.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldNombreAsegurado.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloDominioVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldDominioVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        
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
        jTablePolizaSiniestro.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 6));
        JTableHeader auxJTableHeader;
        auxJTableHeader = jTablePolizaSiniestro.getTableHeader();
        auxJTableHeader.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
// se instancia la clase AdministradorTipoCaja y se inicializa el menu del jTable
        _administradorSeguros = new AdministradorSeguros();
        _administradorVehiculos = new AdministradorVehiculos();
        _administradorPolizaSiniestro = new AdministradorPolizaSiniestro();
        
        popupMenuJTable();
        
        jTextFieldIuPolizaSiniestro.setEditable(false);
        jButtonBorrarPolizaSiniestro.setEnabled(false);
        jButtonEditarPolizaSiniestro.setEnabled(false);
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMensajeValidarABM = new javax.swing.JPanel();
        jButtonCancelarValidarCambios = new javax.swing.JButton();
        jButtonAceptarValidarCambios = new javax.swing.JButton();
        jLabelIconoAlertaValidarCambios = new javax.swing.JLabel();
        jLabelMensajeValidarCambios = new javax.swing.JLabel();
        jLabelMensajeValidarCambios1 = new javax.swing.JLabel();
        jLabelFondoIconoMensajeValidarCambios = new javax.swing.JLabel();
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
        jPanelMensajeCerrar = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jLabelIconoAlerta = new javax.swing.JLabel();
        jLabelMensajeUno = new javax.swing.JLabel();
        jLabelMensajeDos = new javax.swing.JLabel();
        jLabelFondoIconoMensajeCerrar = new javax.swing.JLabel();
        jPanelVentanaBuscar = new javax.swing.JPanel();
        jSeparatorBuscarPolizaSiniestro = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePolizaSiniestro = new javax.swing.JTable();
        jLabelTituloBuscarPolizaSiniestro = new javax.swing.JLabel();
        jTextFieldBuscarPolizaSiniestro = new javax.swing.JTextField();
        jButtonTraerPanelCuerpo = new javax.swing.JButton();
        jLabelFondoVentanaBuscar = new javax.swing.JLabel();
        jPanelCuerpo = new javax.swing.JPanel();
        jPanelListaIuSeguros = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListSeguros = new javax.swing.JList<>();
        jPanelListaDominioVeh = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListVehiculos = new javax.swing.JList<>();
        jLabelTituloNombreAsegurado = new javax.swing.JLabel();
        jTextFieldNombreAsegurado = new javax.swing.JTextField();
        jSeparatorNombreAsegurado = new javax.swing.JSeparator();
        jLabelTituloNumSiniestro = new javax.swing.JLabel();
        jTextFieldNumSiniestro = new javax.swing.JTextField();
        jSeparatorNumSiniestro = new javax.swing.JSeparator();
        jLabelTituloNumPoliza = new javax.swing.JLabel();
        jTextFieldNumPoliza = new javax.swing.JTextField();
        jSeparatorNumPoliza = new javax.swing.JSeparator();
        jButtonRegSeguros = new javax.swing.JButton();
        jLabelTituloIuSeguros = new javax.swing.JLabel();
        jTextFieldIuSeguros = new javax.swing.JTextField();
        jSeparatorIuSeguros = new javax.swing.JSeparator();
        jSeparatorIuPolizaSiniestro = new javax.swing.JSeparator();
        jLabelTituloIuPolizaSiniestro = new javax.swing.JLabel();
        jTextFieldIuPolizaSiniestro = new javax.swing.JTextField();
        jLabelTituloDominioVeh = new javax.swing.JLabel();
        jTextFieldDominioVeh = new javax.swing.JTextField();
        jSeparatorDominioVeh = new javax.swing.JSeparator();
        jButtonAgregarPolizaSiniestro = new javax.swing.JButton();
        jButtonEditarPolizaSiniestro = new javax.swing.JButton();
        jButtonBorrarPolizaSiniestro = new javax.swing.JButton();
        jButtonTraerPanelBuscar = new javax.swing.JButton();
        jButtonRegVehiculos = new javax.swing.JButton();
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

        getContentPane().add(jPanelMensajeValidarABM, new org.netbeans.lib.awtextra.AbsoluteConstraints(-250, 200, 250, 100));

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

        getContentPane().add(jPanelElementoNoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(-250, 200, 250, 100));

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

        getContentPane().add(jPanelItemNoSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 200, 250, 100));

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

        getContentPane().add(jPanelElementoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 200, 250, 100));

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

        getContentPane().add(jPanelErrorBaseDeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 200, 250, 100));

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

        getContentPane().add(jPanelGuardadoErroneo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 200, 250, 100));

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

        getContentPane().add(jPanelGuardadoExitoso, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 200, 250, 100));

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

        getContentPane().add(jPanelMensajeCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, 200, 250, 100));

        jPanelVentanaBuscar.setBackground(new java.awt.Color(245, 245, 245));
        jPanelVentanaBuscar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanelVentanaBuscar.setMaximumSize(new java.awt.Dimension(700, 457));
        jPanelVentanaBuscar.setMinimumSize(new java.awt.Dimension(700, 457));
        jPanelVentanaBuscar.setOpaque(false);
        jPanelVentanaBuscar.setPreferredSize(new java.awt.Dimension(700, 457));
        jPanelVentanaBuscar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparatorBuscarPolizaSiniestro.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorBuscarPolizaSiniestro.setForeground(new java.awt.Color(0, 0, 0));
        jPanelVentanaBuscar.add(jSeparatorBuscarPolizaSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 55, 100, 2));

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));

        jTablePolizaSiniestro = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jTablePolizaSiniestro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nº registro", "Seguro", "N° poliza", "N° siniestro", "Dominio", "Asegurado"
            }
        ));
        jTablePolizaSiniestro.setToolTipText("Has click derecho para opciones.");
        jTablePolizaSiniestro.setAutoscrolls(false);
        jTablePolizaSiniestro.setFocusable(false);
        jTablePolizaSiniestro.setMaximumSize(new java.awt.Dimension(480, 450));
        jTablePolizaSiniestro.setMinimumSize(new java.awt.Dimension(480, 450));
        jTablePolizaSiniestro.setPreferredSize(new java.awt.Dimension(480, 450));
        jTablePolizaSiniestro.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jTablePolizaSiniestro.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jTablePolizaSiniestro.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTablePolizaSiniestro);

        jPanelVentanaBuscar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 680, 375));

        jLabelTituloBuscarPolizaSiniestro.setText("Parametro de busqueda:");
        jPanelVentanaBuscar.add(jLabelTituloBuscarPolizaSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 10, -1, 25));

        jTextFieldBuscarPolizaSiniestro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBuscarPolizaSiniestro.setToolTipText("ingresa parametros de busqueda. Ej: vent");
        jTextFieldBuscarPolizaSiniestro.setBorder(null);
        jTextFieldBuscarPolizaSiniestro.setDisabledTextColor(new java.awt.Color(194, 4, 48));
        jTextFieldBuscarPolizaSiniestro.setOpaque(false);
        jTextFieldBuscarPolizaSiniestro.setSelectionColor(new java.awt.Color(73, 73, 73));
        jTextFieldBuscarPolizaSiniestro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarPolizaSiniestroKeyReleased(evt);
            }
        });
        jPanelVentanaBuscar.add(jTextFieldBuscarPolizaSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 35, 100, 20));

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

        jPanelListaIuSeguros.setOpaque(false);
        jPanelListaIuSeguros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(200, 45));

        jListSeguros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListSegurosFocusGained(evt);
            }
        });
        jListSeguros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListSegurosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListSeguros);

        jPanelListaIuSeguros.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 45));

        jPanelCuerpo.add(jPanelListaIuSeguros, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 138, 200, 45));

        jPanelListaDominioVeh.setOpaque(false);
        jPanelListaDominioVeh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(200, 45));

        jListVehiculos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListVehiculosFocusGained(evt);
            }
        });
        jListVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListVehiculosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jListVehiculos);

        jPanelListaDominioVeh.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 45));

        jPanelCuerpo.add(jPanelListaDominioVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 290, 200, 45));

        jLabelTituloNombreAsegurado.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloNombreAsegurado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloNombreAsegurado.setText("Nombre del asegurado:");
        jLabelTituloNombreAsegurado.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloNombreAsegurado, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 254, -1, 25));

        jTextFieldNombreAsegurado.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldNombreAsegurado.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldNombreAsegurado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNombreAsegurado.setToolTipText("Ingrese solo texto. Ej.: gaston");
        jTextFieldNombreAsegurado.setBorder(null);
        jTextFieldNombreAsegurado.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldNombreAsegurado.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldNombreAsegurado.setOpaque(false);
        jTextFieldNombreAsegurado.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldNombreAsegurado.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldNombreAsegurado, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 274, 200, 20));

        jSeparatorNombreAsegurado.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorNombreAsegurado.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorNombreAsegurado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorNombreAsegurado.setOpaque(true);
        jPanelCuerpo.add(jSeparatorNombreAsegurado, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 294, 200, -1));

        jLabelTituloNumSiniestro.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloNumSiniestro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloNumSiniestro.setText("N° de siniestro:");
        jLabelTituloNumSiniestro.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloNumSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 176, -1, 25));

        jTextFieldNumSiniestro.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldNumSiniestro.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldNumSiniestro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNumSiniestro.setToolTipText("Ingrese solo numeros. Ej.: 003");
        jTextFieldNumSiniestro.setBorder(null);
        jTextFieldNumSiniestro.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldNumSiniestro.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldNumSiniestro.setOpaque(false);
        jTextFieldNumSiniestro.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldNumSiniestro.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldNumSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 196, 200, 20));

        jSeparatorNumSiniestro.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorNumSiniestro.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorNumSiniestro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorNumSiniestro.setOpaque(true);
        jPanelCuerpo.add(jSeparatorNumSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 218, 200, -1));

        jLabelTituloNumPoliza.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloNumPoliza.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloNumPoliza.setText("N° de poliza:");
        jLabelTituloNumPoliza.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloNumPoliza, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 176, -1, 25));

        jTextFieldNumPoliza.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldNumPoliza.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldNumPoliza.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNumPoliza.setToolTipText("Ingrese solo numeros. Ej.: 003");
        jTextFieldNumPoliza.setBorder(null);
        jTextFieldNumPoliza.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldNumPoliza.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldNumPoliza.setOpaque(false);
        jTextFieldNumPoliza.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldNumPoliza.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldNumPoliza, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 196, 200, 20));

        jSeparatorNumPoliza.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorNumPoliza.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorNumPoliza.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorNumPoliza.setOpaque(true);
        jPanelCuerpo.add(jSeparatorNumPoliza, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 216, 200, -1));

        jButtonRegSeguros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x25Off.png"))); // NOI18N
        jButtonRegSeguros.setBorder(null);
        jButtonRegSeguros.setBorderPainted(false);
        jButtonRegSeguros.setContentAreaFilled(false);
        jButtonRegSeguros.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegSeguros.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegSeguros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegSegurosActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonRegSeguros, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 115, -1, -1));

        jLabelTituloIuSeguros.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuSeguros.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuSeguros.setText("Nombre del seguros:");
        jLabelTituloIuSeguros.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloIuSeguros, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 98, -1, 25));

        jTextFieldIuSeguros.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuSeguros.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuSeguros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuSeguros.setToolTipText("Ingrese solo texto. Ej.: sancor");
        jTextFieldIuSeguros.setBorder(null);
        jTextFieldIuSeguros.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuSeguros.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuSeguros.setOpaque(false);
        jTextFieldIuSeguros.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuSeguros.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldIuSeguros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIuSegurosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldIuSegurosFocusLost(evt);
            }
        });
        jTextFieldIuSeguros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldIuSegurosKeyReleased(evt);
            }
        });
        jPanelCuerpo.add(jTextFieldIuSeguros, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 118, 200, 20));

        jSeparatorIuSeguros.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuSeguros.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuSeguros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuSeguros.setOpaque(true);
        jPanelCuerpo.add(jSeparatorIuSeguros, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 138, 200, -1));

        jSeparatorIuPolizaSiniestro.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuPolizaSiniestro.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuPolizaSiniestro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuPolizaSiniestro.setOpaque(true);
        jPanelCuerpo.add(jSeparatorIuPolizaSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 66, 100, -1));

        jLabelTituloIuPolizaSiniestro.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuPolizaSiniestro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuPolizaSiniestro.setText("Codigo identificacion:");
        jLabelTituloIuPolizaSiniestro.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloIuPolizaSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 25, -1, 25));

        jTextFieldIuPolizaSiniestro.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuPolizaSiniestro.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuPolizaSiniestro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuPolizaSiniestro.setText("AUTOMATICO");
        jTextFieldIuPolizaSiniestro.setToolTipText("");
        jTextFieldIuPolizaSiniestro.setBorder(null);
        jTextFieldIuPolizaSiniestro.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuPolizaSiniestro.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuPolizaSiniestro.setOpaque(false);
        jTextFieldIuPolizaSiniestro.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuPolizaSiniestro.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldIuPolizaSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 45, 100, 20));

        jLabelTituloDominioVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloDominioVeh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloDominioVeh.setText("Dominio del vehiculo:");
        jLabelTituloDominioVeh.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloDominioVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, 25));

        jTextFieldDominioVeh.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldDominioVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldDominioVeh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDominioVeh.setToolTipText("Ingrese  texto y numero. Ej.: wwq220");
        jTextFieldDominioVeh.setBorder(null);
        jTextFieldDominioVeh.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldDominioVeh.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldDominioVeh.setOpaque(false);
        jTextFieldDominioVeh.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldDominioVeh.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldDominioVeh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDominioVehFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldDominioVehFocusLost(evt);
            }
        });
        jTextFieldDominioVeh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDominioVehKeyReleased(evt);
            }
        });
        jPanelCuerpo.add(jTextFieldDominioVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 270, 200, 20));

        jSeparatorDominioVeh.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorDominioVeh.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorDominioVeh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorDominioVeh.setOpaque(true);
        jPanelCuerpo.add(jSeparatorDominioVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 290, 200, -1));

        jButtonAgregarPolizaSiniestro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOff.png"))); // NOI18N
        jButtonAgregarPolizaSiniestro.setToolTipText("Has click para agregar.");
        jButtonAgregarPolizaSiniestro.setBorder(null);
        jButtonAgregarPolizaSiniestro.setBorderPainted(false);
        jButtonAgregarPolizaSiniestro.setContentAreaFilled(false);
        jButtonAgregarPolizaSiniestro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregarPolizaSiniestro.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarPolizaSiniestro.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarPolizaSiniestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarPolizaSiniestroActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonAgregarPolizaSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 407, -1, -1));

        jButtonEditarPolizaSiniestro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOff.png"))); // NOI18N
        jButtonEditarPolizaSiniestro.setToolTipText("Has click para editar.");
        jButtonEditarPolizaSiniestro.setBorder(null);
        jButtonEditarPolizaSiniestro.setBorderPainted(false);
        jButtonEditarPolizaSiniestro.setContentAreaFilled(false);
        jButtonEditarPolizaSiniestro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditarPolizaSiniestro.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarPolizaSiniestro.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarPolizaSiniestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarPolizaSiniestroActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonEditarPolizaSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 407, -1, -1));

        jButtonBorrarPolizaSiniestro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOff.png"))); // NOI18N
        jButtonBorrarPolizaSiniestro.setToolTipText("Has click para borrar.");
        jButtonBorrarPolizaSiniestro.setBorder(null);
        jButtonBorrarPolizaSiniestro.setBorderPainted(false);
        jButtonBorrarPolizaSiniestro.setContentAreaFilled(false);
        jButtonBorrarPolizaSiniestro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBorrarPolizaSiniestro.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarPolizaSiniestro.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarPolizaSiniestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarPolizaSiniestroActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonBorrarPolizaSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 407, -1, -1));

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

        jButtonRegVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x25Off.png"))); // NOI18N
        jButtonRegVehiculos.setBorder(null);
        jButtonRegVehiculos.setBorderPainted(false);
        jButtonRegVehiculos.setContentAreaFilled(false);
        jButtonRegVehiculos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegVehiculos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegVehiculosActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonRegVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 265, -1, -1));

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
        jLabelTituloVentana.setText("Registro de polizas y siniestros");
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

// valida codModeloVeh en caso de no hacer cick en a lista
    public void validarIuSeguros(){
        auxSeleccionList = _administradorSeguros.obtenerIuSeguros(jTextFieldIuSeguros.getText()).length() != 0;
    } 
    
// valida codModeloVeh en caso de no hacer cick en a lista
    public void validarDominoVeh(){
        auxSeleccionList2 = _administradorVehiculos.obtenerDominioVeh(jTextFieldDominioVeh.getText()).length() != 0;
    }
    
// se crea un objeto de la clase utilizada    
    public void crearObjPolizaSinestro(){
     
        _objPolizaSinestros = new PolizaSiniestro();
        _objPolizaSinestros.setIuPolizaSiniestro(Integer.parseInt(jTextFieldIuPolizaSiniestro.getText()));
        _objPolizaSinestros.setIuSeguros(Integer.parseInt(_administradorSeguros.obtenerIuSeguros(jTextFieldIuSeguros.getText())));
        _objPolizaSinestros.setNumPoliza(jTextFieldNumPoliza.getText());
        _objPolizaSinestros.setNumSiniestro(jTextFieldNumSiniestro.getText());
        _objPolizaSinestros.setDominioVeh(_administradorVehiculos.obtenerDominioVeh(jTextFieldDominioVeh.getText()));
        _objPolizaSinestros.setNombAsegurado(jTextFieldNombreAsegurado.getText());
     }
      
// limpia los jtextfield usados
    public void limpiarCampos(){

        jTextFieldIuPolizaSiniestro.setText("AUTOMATICO");
        jTextFieldIuSeguros.setText(""); 
        jTextFieldNumPoliza.setText("");
        jTextFieldNombreAsegurado.setText("");
        jTextFieldNumSiniestro.setText("");
        jTextFieldDominioVeh.setText("");
        }
     
// este metodo crea menu de opciones al usar click secundario   
    public final void popupMenuJTable(){
//se crean las opciones del menu
        JPopupMenu jPopupMenuTableHPS = new JPopupMenu();
        JMenuItem jMenuItemEliminarPolizaSiniestro = new JMenuItem("Eliminar"); // cambiar x ico 
        JMenuItem jMenuItemModificarPolizaSiniestro = new JMenuItem("Modificar");
        JMenuItem jMenuOrdenar = new JMenu("Ordenar por");
        JMenuItem jMenuItemPrimerosAgregados = new JMenuItem("Primeros agregados");
        JMenuItem jMenuItemUltimosAgregados= new JMenuItem("Ultimos agregados");
        JMenuItem jMenuItemAlfabeticos = new JMenuItem("Alfabeticos"); 
        jMenuOrdenar.add(jMenuItemPrimerosAgregados);
        jMenuOrdenar.add(jMenuItemUltimosAgregados); 
        jMenuOrdenar.add(jMenuItemAlfabeticos);
// se generan las acciones de cada opcion
        jMenuItemEliminarPolizaSiniestro.addActionListener((ActionEvent e) -> {
        
        if(seleccionarItemJTabla()!= -1){
                 
            jPanelVentanaBuscar.setBounds(-700, 30, 700, 457);
            jPanelCuerpo.setBounds( 100,30,  700, 457);
              
            jButtonAgregarPolizaSiniestro.setEnabled(false);
            jButtonEditarPolizaSiniestro.setEnabled(false);
            jButtonBorrarPolizaSiniestro.setEnabled(true);
            
            jTextFieldIuPolizaSiniestro.setEditable(false); 
            jTextFieldIuSeguros.setEditable(false);
            jTextFieldNumPoliza.setEditable(false);
            jTextFieldNumSiniestro.setEditable(false);
            jTextFieldNombreAsegurado.setEditable(false);
            jTextFieldDominioVeh.setEditable(false);
            jButtonRegSeguros.setEnabled(false);
            jButtonRegVehiculos.setEnabled(false);
            jButtonTraerPanelBuscar.setEnabled(true);
            
            jPanelListaIuSeguros.setVisible(false);
            jPanelListaDominioVeh.setVisible(false);
            jListSeguros.setVisible(false);
            jListVehiculos.setVisible(false);
            
             }
         });
         
        jMenuItemModificarPolizaSiniestro.addActionListener((ActionEvent e) -> {
            
        if(seleccionarItemJTabla()!= -1){
                     
            jPanelVentanaBuscar.setBounds(-700, 30, 700, 457);
            jPanelCuerpo.setBounds( 100,30,  700, 457);
              
            jButtonAgregarPolizaSiniestro.setEnabled(false);
            jButtonBorrarPolizaSiniestro.setEnabled(false);
            jButtonEditarPolizaSiniestro.setEnabled(true);
            
            jTextFieldIuPolizaSiniestro.setEditable(false); 
            jTextFieldIuSeguros.setEditable(true);
            jTextFieldNumPoliza.setEditable(true);
            jTextFieldNumSiniestro.setEditable(true);
            jTextFieldNombreAsegurado.setEditable(true);
            jTextFieldDominioVeh.setEditable(true);
            jButtonRegSeguros.setEnabled(true);
            jButtonRegVehiculos.setEnabled(true);
            jButtonTraerPanelBuscar.setEnabled(true);
            
            jPanelListaIuSeguros.setVisible(true);
            jPanelListaDominioVeh.setVisible(true);
            jListSeguros.setVisible(true);
            jListVehiculos.setVisible(true);
            
        }
        });
             
        jMenuItemUltimosAgregados.addActionListener((ActionEvent e) -> {
            _administradorPolizaSiniestro.ordenarTabla(jMenuItemUltimosAgregados.getText());
            jTablePolizaSiniestro.setModel( _administradorPolizaSiniestro.cargarJTabla());
        });
                
        jMenuItemAlfabeticos.addActionListener((ActionEvent e) -> {
            _administradorPolizaSiniestro.ordenarTabla(jMenuItemAlfabeticos.getText());
            jTablePolizaSiniestro.setModel( _administradorPolizaSiniestro.cargarJTabla());
        });
                                
        jMenuItemPrimerosAgregados.addActionListener((ActionEvent e) -> {
            _administradorPolizaSiniestro.ordenarTabla(jMenuItemPrimerosAgregados.getText());
            jTablePolizaSiniestro.setModel( _administradorPolizaSiniestro.cargarJTabla());
        });
// se construye el menu completo y se le asigna si jTable
        jPopupMenuTableHPS.add(jMenuItemEliminarPolizaSiniestro);
        jPopupMenuTableHPS.add(jMenuItemModificarPolizaSiniestro);
        jPopupMenuTableHPS.add(jMenuOrdenar);
        jTablePolizaSiniestro.setComponentPopupMenu(jPopupMenuTableHPS);  
     }
 
// se obtiene los datos del item seleccionado en la tabla
    public int seleccionarItemJTabla(){
// se obtiene el modelo y se verifica que se haya seleccionado un item   
        modeloTablaPS = jTablePolizaSiniestro.getModel();
        int auxSeleccion = jTablePolizaSiniestro.getSelectedRow();
        if (auxSeleccion != -1) {
            jTablePolizaSiniestro.setEnabled(true);
// se cargan los campos con los valores selcionados
            iuPolizaSiniestro =  (String)modeloTablaPS.getValueAt(jTablePolizaSiniestro.getSelectedRow(), 0);
            jTextFieldIuPolizaSiniestro.setText(iuPolizaSiniestro);
            jTextFieldIuSeguros.setText((String)modeloTablaPS.getValueAt(jTablePolizaSiniestro.getSelectedRow(), 1));
            jTextFieldNumPoliza.setText((String)modeloTablaPS.getValueAt(jTablePolizaSiniestro.getSelectedRow(), 2));
            jTextFieldNumSiniestro.setText((String)modeloTablaPS.getValueAt(jTablePolizaSiniestro.getSelectedRow(), 3));
            jTextFieldDominioVeh.setText((String)modeloTablaPS.getValueAt(jTablePolizaSiniestro.getSelectedRow(), 4));
            jTextFieldNombreAsegurado.setText((String)modeloTablaPS.getValueAt(jTablePolizaSiniestro.getSelectedRow(), 5));
            return auxSeleccion;
            
        }else {
// si no selecciona mensaje error 
            jTablePolizaSiniestro.setEnabled(false);
            jPanelItemNoSeleccionado.setBounds(325, 200, 250,100);
            return auxSeleccion;
        }
    }
    
//visualiza el panel buscar
    private void jButtonTraerPanelBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelBuscarActionPerformed
// llama al panel buscar 
    try {
        jTablePolizaSiniestro.setModel(_administradorPolizaSiniestro.cargarJTabla());
    } catch (Exception e) {
        jPanelErrorBaseDeDatos.setBounds(325, 200, 250, 100);
    }
        jPanelCuerpo.setBounds(-700, 30, 500, 270);
        jPanelVentanaBuscar.setBounds( 100,30,  700, 457);      
    }//GEN-LAST:event_jButtonTraerPanelBuscarActionPerformed

//visualiza el cuerpo donde esta el ABM
    private void jButtonTraerPanelCuerpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelCuerpoActionPerformed
//llama al panel contenedor del abm
        jPanelVentanaBuscar.setBounds(-700, 30, 500, 270);
        jPanelCuerpo.setBounds( 100,30,  700, 457);
    }//GEN-LAST:event_jButtonTraerPanelCuerpoActionPerformed
   
// visualiza panel  ventana cerrar
    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed

        jPanelCuerpo.setBounds(-700, 30, 500, 270);
        jPanelVentanaBuscar.setBounds(-700, 30, 500, 270);
        jPanelMensajeCerrar.setBounds( 325,200,  250, 100);
        jPanelElementoExistente.setBounds(-260, 200, 250,  100);
        jPanelErrorBaseDeDatos.setBounds(-260, 200, 250,  100);
        jPanelGuardadoErroneo.setBounds(-260, 200, 250,  100);
        jPanelGuardadoExitoso.setBounds(-260, 200, 250,  100);
        jPanelItemNoSeleccionado.setBounds(-260, 200, 250,  100);
        jPanelMensajeValidarABM.setBounds(-260, 200, 250,  100);
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
        
        jPanelMensajeCerrar.setBounds(-500, 200, 250, 100);
        jPanelCuerpo.setBounds( 100,30,  700, 457);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

//valida datos y edita un registro en tabla tipocaja 
    private void jButtonEditarPolizaSiniestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarPolizaSiniestroActionPerformed
        jPanelMensajeValidarABM.setBounds(325, 200, 250, 100);
        auxAbm = 2;
        jButtonAgregarPolizaSiniestro.setEnabled(false);
        jButtonEditarPolizaSiniestro.setEnabled(false);
        jButtonBorrarPolizaSiniestro.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldIuPolizaSiniestro.setEditable(false);

        jTextFieldIuPolizaSiniestro.setEditable(false); 
        jTextFieldIuSeguros.setEditable(false);
        jTextFieldNumPoliza.setEditable(false);
        jTextFieldNumSiniestro.setEditable(false);
        jTextFieldNombreAsegurado.setEditable(false);
        jTextFieldDominioVeh.setEditable(false);
        jButtonRegSeguros.setEnabled(false);
        jButtonRegVehiculos.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);

        jListSeguros.setVisible(false);
        jListVehiculos.setVisible(false);
    }//GEN-LAST:event_jButtonEditarPolizaSiniestroActionPerformed

//valida datos y borra un registro en tabla tipocaja 
    private void jButtonBorrarPolizaSiniestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarPolizaSiniestroActionPerformed
        
        jPanelMensajeValidarABM.setBounds(325, 200, 250, 100);
        auxAbm = 3;
        jButtonAgregarPolizaSiniestro.setEnabled(false);
        jButtonEditarPolizaSiniestro.setEnabled(false);
        jButtonBorrarPolizaSiniestro.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldIuPolizaSiniestro.setEditable(false);

        jTextFieldIuPolizaSiniestro.setEditable(false); 
        jTextFieldIuSeguros.setEditable(false);
        jTextFieldNumPoliza.setEditable(false);
        jTextFieldNumSiniestro.setEditable(false);
        jTextFieldNombreAsegurado.setEditable(false);
        jTextFieldDominioVeh.setEditable(false);
        jButtonRegSeguros.setEnabled(false);
        jButtonRegVehiculos.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);

        jListSeguros.setVisible(false);
        jListVehiculos.setVisible(false);
    }//GEN-LAST:event_jButtonBorrarPolizaSiniestroActionPerformed

// con cada tecleo valida los datos y elimina los no correctos
    private void jTextFieldBuscarPolizaSiniestroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarPolizaSiniestroKeyReleased
        boolean auxValidar = Administrador.validarCharDinamico(evt.getKeyChar(), "[a-zA-Z_0-9]||[\\s]");
    try {
        
        if(auxValidar==false){
            
            evt.consume();
            jTablePolizaSiniestro.setModel(_administradorPolizaSiniestro.buscarEnTabla(jTextFieldBuscarPolizaSiniestro.getText()));
               
        } else{

            jTablePolizaSiniestro.setModel(_administradorPolizaSiniestro.buscarEnTabla(jTextFieldBuscarPolizaSiniestro.getText()));
           }
    } catch (Exception e) {
        
        jPanelErrorBaseDeDatos.setBounds(325, 200, 250, 100);  
    }      
    }//GEN-LAST:event_jTextFieldBuscarPolizaSiniestroKeyReleased

//esconde el panel y habilita los obj en pantalla
    private void jButtonCancelarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarValidarCambiosActionPerformed
        
        auxAbm = 0;
        limpiarCampos();
        jPanelMensajeValidarABM.setBounds(-260, 200, 250, 100);
        jButtonAgregarPolizaSiniestro.setEnabled(true);
        jButtonEditarPolizaSiniestro.setEnabled(false);
        jButtonBorrarPolizaSiniestro.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        
        jTextFieldIuPolizaSiniestro.setEditable(false);
        jTextFieldIuPolizaSiniestro.setBorder(null);
        jTextFieldIuSeguros.setEditable(true);
        jTextFieldIuSeguros.setBorder(null);
        jTextFieldNumPoliza.setEditable(true);
        jTextFieldNumPoliza.setBorder(null);
        jTextFieldNumSiniestro.setEditable(true);
        jTextFieldNumSiniestro.setBorder(null);
        jTextFieldDominioVeh.setEditable(true);
        jTextFieldDominioVeh.setBorder(null);
        jTextFieldNombreAsegurado.setEditable(true);
        jTextFieldNombreAsegurado.setBorder(null);
        
        jListSeguros.setVisible(true);
        jListVehiculos.setVisible(true);
        jPanelListaIuSeguros.setVisible(true);
        jPanelListaDominioVeh.setVisible(true);
    }//GEN-LAST:event_jButtonCancelarValidarCambiosActionPerformed

    private void jButtonAceptarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarValidarCambiosActionPerformed
        boolean[] listaVerdades = new boolean[5];
        int aux = 0;
        int auxMensaje2 = 0;
        int auxMensaje = 0;
                
// llama al panel y segun desde donde llamo ejecuta la accion        
        jPanelMensajeValidarABM.setBounds(-260, 193, 250, 100);     
        switch(auxAbm){
            
            case 1:
                validarIuSeguros();
                listaVerdades[0] = auxSeleccionList;
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldNumPoliza.getText(), "\\d" );
                listaVerdades[2] = Administrador.validarCamposTextos(jTextFieldNumSiniestro.getText(), "\\d" );
                validarDominoVeh();
                listaVerdades[3] = auxSeleccionList2;
                listaVerdades[4] = Administrador.validarCamposTextos(jTextFieldNombreAsegurado.getText(), "[a-zA-Z_0-9]||[\\s]" );

                
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==5){
                    jTextFieldIuSeguros.setBorder(new LineBorder(Color.green));
                    jTextFieldNumPoliza.setBorder(new LineBorder(Color.green));
                    jTextFieldNumSiniestro.setBorder(new LineBorder(Color.green));
                    jTextFieldNombreAsegurado.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    auxSeleccionList2 = false;
                    
                    _objPolizaSinestros = new PolizaSiniestro();
                    _objPolizaSinestros.setIuSeguros(Integer.parseInt(_administradorSeguros.obtenerIuSeguros(jTextFieldIuSeguros.getText())));
                    _objPolizaSinestros.setNumPoliza(jTextFieldNumPoliza.getText());
                    _objPolizaSinestros.setNumSiniestro(jTextFieldNumSiniestro.getText());
                    _objPolizaSinestros.setDominioVeh(_administradorVehiculos.obtenerDominioVeh(jTextFieldDominioVeh.getText()));
                    _objPolizaSinestros.setNombAsegurado(jTextFieldNombreAsegurado.getText());
        
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorPolizaSiniestro.insertarTablaPolizaSiniestro(_objPolizaSinestros)==true){
               
                            jPanelGuardadoExitoso.setBounds(325, 200, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(325, 200, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(325, 200, 250, 100);
    }
                
                
                } else{
                    for (int i = 0; i < listaVerdades.length; i++) {
                        switch(i){
                            
                            case 0:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuSeguros.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuSeguros.setBorder(new LineBorder(Color.red));
                                    if(_administradorSeguros.obtenerIuSeguros(jTextFieldIuSeguros.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldNumPoliza.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNumPoliza.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldNumSiniestro.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNumSiniestro.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.red));
                                    if(_administradorVehiculos.obtenerDominioVeh(jTextFieldDominioVeh.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 4:
                                if(listaVerdades[i]==true){
                                    jTextFieldNombreAsegurado.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNombreAsegurado.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            
                        }
                    }
                    if(auxMensaje==1) jPanelElementoNoExistente.setBounds(325, 200, 250, 100);
                    if(auxMensaje2==1) jPanelGuardadoErroneo.setBounds(325, 200, 250, 100);
                    
                }               
            break;
// se repite el mismo codigo solo que se edita un item de la db 
            case 2:
// se validan los datos
                validarIuSeguros();
                listaVerdades[0] = auxSeleccionList;
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldNumPoliza.getText(), "\\d" );
                listaVerdades[2] = Administrador.validarCamposTextos(jTextFieldNumSiniestro.getText(), "\\d" );
                validarDominoVeh();
                listaVerdades[3] = auxSeleccionList2;
                listaVerdades[4] = Administrador.validarCamposTextos(jTextFieldNombreAsegurado.getText(), "[a-zA-Z_0-9]||[\\s]" );
                
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==5){
                    jTextFieldIuSeguros.setBorder(new LineBorder(Color.green));
                    jTextFieldNumPoliza.setBorder(new LineBorder(Color.green));
                    jTextFieldNumSiniestro.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldNombreAsegurado.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    auxSeleccionList2 = false;
                    
                    crearObjPolizaSinestro();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorPolizaSiniestro.actualizarTablaPolizaSiniestro(_objPolizaSinestros)==true){
               
                            jPanelGuardadoExitoso.setBounds(325, 200, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(325, 200, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(325, 200, 250, 100);
    }
                
                
                } else{
                    for (int i = 0; i < listaVerdades.length; i++) {
                        switch(i){
                            
                            case 0:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuSeguros.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuSeguros.setBorder(new LineBorder(Color.red));
                                    if(_administradorSeguros.obtenerIuSeguros(jTextFieldIuSeguros.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldNumPoliza.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNumPoliza.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldNumSiniestro.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNumSiniestro.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.red));
                                    if(_administradorVehiculos.obtenerDominioVeh(jTextFieldDominioVeh.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 4:
                                if(listaVerdades[i]==true){
                                    jTextFieldNombreAsegurado.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNombreAsegurado.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            
                        }
                    }
                    if(auxMensaje==1) jPanelElementoNoExistente.setBounds(325, 200, 250, 100);
                    if(auxMensaje2==1) jPanelGuardadoErroneo.setBounds(325, 200, 250, 100);
                    
                }               
            break;
// se repite el mismo codigo solo que se borra un item de la db         
            case 3:
// se validan los datos
                validarIuSeguros();
                listaVerdades[0] = auxSeleccionList;
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldNumPoliza.getText(), "\\d" );
                listaVerdades[2] = Administrador.validarCamposTextos(jTextFieldNumSiniestro.getText(), "\\d" );
                validarDominoVeh();
                listaVerdades[3] = auxSeleccionList2;
                listaVerdades[4] = Administrador.validarCamposTextos(jTextFieldNombreAsegurado.getText(), "[a-zA-Z_0-9]||[\\s]" );
                
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==5){
                    jTextFieldIuSeguros.setBorder(new LineBorder(Color.green));
                    jTextFieldNumPoliza.setBorder(new LineBorder(Color.green));
                    jTextFieldNumSiniestro.setBorder(new LineBorder(Color.green));
                    jTextFieldNombreAsegurado.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    auxSeleccionList2 = false;
                    
                    crearObjPolizaSinestro();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorPolizaSiniestro.eliminarTablaPolizaSiniestro(_objPolizaSinestros)==true){
               
                            jPanelGuardadoExitoso.setBounds(325, 200, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(325, 200, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(325, 200, 250, 100);
    }
                
                
                } else{
                    for (int i = 0; i < listaVerdades.length; i++) {
                        switch(i){
                            
                            case 0:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuSeguros.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuSeguros.setBorder(new LineBorder(Color.red));
                                    if(_administradorSeguros.obtenerIuSeguros(jTextFieldIuSeguros.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldNumPoliza.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNumPoliza.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldNumSiniestro.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNumSiniestro.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.red));
                                    if(_administradorVehiculos.obtenerDominioVeh(jTextFieldDominioVeh.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 4:
                                if(listaVerdades[i]==true){
                                    jTextFieldNombreAsegurado.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNombreAsegurado.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            
                        }
                    }
                    if(auxMensaje==1) jPanelElementoNoExistente.setBounds(325, 200, 250, 100);
                    if(auxMensaje2==1) jPanelGuardadoErroneo.setBounds(325, 200, 250, 100);
                    
                }               
            break;   
        }
    }//GEN-LAST:event_jButtonAceptarValidarCambiosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones, se limpia los campos
    private void jButtonAceptarGuardadoExitosoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoExitosoActionPerformed
       
        jPanelGuardadoExitoso.setBounds(-260, 200, 250, 100);
        jTextFieldIuPolizaSiniestro.setBorder(null); 
        jTextFieldIuSeguros.setBorder(null);
        jTextFieldNumPoliza.setBorder(null);
        jTextFieldNumSiniestro.setBorder(null);
        jTextFieldNombreAsegurado.setBorder(null);
        jTextFieldDominioVeh.setBorder(null);
        limpiarCampos();
        jButtonAgregarPolizaSiniestro.setEnabled(true);
        jButtonEditarPolizaSiniestro.setEnabled(false);
        jButtonBorrarPolizaSiniestro.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        
        jTextFieldIuPolizaSiniestro.setEditable(false); 
        jTextFieldIuSeguros.setEditable(true);
        jTextFieldNumPoliza.setEditable(true);
        jTextFieldNumSiniestro.setEditable(true);
        jTextFieldNombreAsegurado.setEditable(true);
        jTextFieldDominioVeh.setEditable(true);
        jButtonRegSeguros.setEnabled(true);
        jButtonRegVehiculos.setEnabled(true);
        jButtonTraerPanelBuscar.setEnabled(true);
            
        jPanelListaIuSeguros.setVisible(true);
        jPanelListaDominioVeh.setVisible(true); 
        jListSeguros.setVisible(true);
        jListVehiculos.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarGuardadoExitosoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarGuardadoErroneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoErroneoActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelGuardadoErroneo.setBounds(-260, 200, 250, 100);
                jButtonAgregarPolizaSiniestro.setEnabled(true);
                jButtonEditarPolizaSiniestro.setEnabled(false);
                jButtonBorrarPolizaSiniestro.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuSeguros.setEditable(true);
                jTextFieldIuPolizaSiniestro.setEditable(false); 
                jTextFieldIuSeguros.setEditable(true);
                jTextFieldNumPoliza.setEditable(true);
                jTextFieldNumSiniestro.setEditable(true);
                jTextFieldNombreAsegurado.setEditable(true);
                jTextFieldDominioVeh.setEditable(true);
                jButtonRegSeguros.setEnabled(true);
                jButtonRegVehiculos.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jPanelListaIuSeguros.setVisible(true);
                jPanelListaDominioVeh.setVisible(true); 
                jListSeguros.setVisible(true);
                jListVehiculos.setVisible(true);
            break;
            
            case 2:
                jPanelGuardadoErroneo.setBounds(-260, 200, 250, 100);
                jButtonAgregarPolizaSiniestro.setEnabled(false);
                jButtonEditarPolizaSiniestro.setEnabled(true);
                jButtonBorrarPolizaSiniestro.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuPolizaSiniestro.setEditable(false); 
                jTextFieldIuSeguros.setEditable(true);
                jTextFieldNumPoliza.setEditable(true);
                jTextFieldNumSiniestro.setEditable(true);
                jTextFieldNombreAsegurado.setEditable(true);
                jTextFieldDominioVeh.setEditable(true);
                jButtonRegSeguros.setEnabled(true);
                jButtonRegVehiculos.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jPanelListaIuSeguros.setVisible(true);
                jPanelListaDominioVeh.setVisible(true); 
                jListSeguros.setVisible(true);
                jListVehiculos.setVisible(true);

            break;
            
            case 3: 
                jPanelGuardadoErroneo.setBounds(-260, 200, 250, 100);
                jButtonAgregarPolizaSiniestro.setEnabled(false);
                jButtonEditarPolizaSiniestro.setEnabled(false);
                jButtonBorrarPolizaSiniestro.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                
                jTextFieldIuPolizaSiniestro.setEditable(false); 
                jTextFieldIuSeguros.setEditable(false);
                jTextFieldNumPoliza.setEditable(false);
                jTextFieldNumSiniestro.setEditable(false);
                jTextFieldNombreAsegurado.setEditable(false);
                jTextFieldDominioVeh.setEditable(false);
                jButtonRegSeguros.setEnabled(false);
                jButtonRegVehiculos.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(false);
                jPanelListaIuSeguros.setVisible(false);
                jPanelListaDominioVeh.setVisible(false); 
                jListSeguros.setVisible(false);
                jListVehiculos.setVisible(false);

            break;
        } 
    }//GEN-LAST:event_jButtonAceptarGuardadoErroneoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarErrorBaseDeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarErrorBaseDeDatosActionPerformed
        
        jPanelErrorBaseDeDatos.setBounds(-260, 200, 250, 100);
        jButtonAgregarPolizaSiniestro.setEnabled(true);
        jButtonEditarPolizaSiniestro.setEnabled(false);
        jButtonBorrarPolizaSiniestro.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true); 
        jTextFieldIuPolizaSiniestro.setEditable(false); 
        jTextFieldIuSeguros.setEditable(true);
        jTextFieldNumPoliza.setEditable(true);
        jTextFieldNumSiniestro.setEditable(true);
        jTextFieldNombreAsegurado.setEditable(true);
        jTextFieldDominioVeh.setEditable(true);
        jButtonRegSeguros.setEnabled(true);
        jButtonRegVehiculos.setEnabled(true);
        jButtonTraerPanelBuscar.setEnabled(true);
        jPanelListaIuSeguros.setVisible(true);
        jPanelListaDominioVeh.setVisible(true); 
        jListSeguros.setVisible(true);
        jListVehiculos.setVisible(true);

    }//GEN-LAST:event_jButtonAceptarErrorBaseDeDatosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarElementoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoExistenteActionPerformed
        
        jPanelElementoExistente.setBounds(-260, 200, 250, 100);
        jButtonAgregarPolizaSiniestro.setEnabled(true);
        jButtonEditarPolizaSiniestro.setEnabled(false);
        jButtonBorrarPolizaSiniestro.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldIuSeguros.setEditable(true);
        jTextFieldIuPolizaSiniestro.setEditable(false); 
        jTextFieldIuSeguros.setEditable(true);
        jTextFieldNumPoliza.setEditable(true);
        jTextFieldNumSiniestro.setEditable(true);
        jTextFieldNombreAsegurado.setEditable(true);
        jTextFieldDominioVeh.setEditable(true);
        jButtonRegSeguros.setEnabled(true);
        jButtonRegVehiculos.setEnabled(true);
        jButtonTraerPanelBuscar.setEnabled(true);
        jPanelListaIuSeguros.setVisible(true);
        jPanelListaDominioVeh.setVisible(true); 
        jListSeguros.setVisible(true);
        jListVehiculos.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarElementoExistenteActionPerformed

// se acomoda los objetos del frame para continuar trabajando. 
    private void jButtonAceptarItemNoSeleccionado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

        jTablePolizaSiniestro.setEnabled(true);
        jPanelItemNoSeleccionado.setBounds(-260, 200, 250, 100); 
    }//GEN-LAST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

    private void jButtonRegSegurosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegSegurosActionPerformed
        JFrameRegistroSeguros obj = new JFrameRegistroSeguros();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegSegurosActionPerformed

    private void jListSegurosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListSegurosFocusGained

        jPanelListaIuSeguros.setBounds(240, 138, 200, 50);
    }//GEN-LAST:event_jListSegurosFocusGained

    private void jListSegurosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListSegurosMouseClicked
        int indexList = jListSeguros.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList2 = true;
            jTextFieldIuSeguros.setText("");
            jTextFieldIuSeguros.setText(jListSeguros.getSelectedValue());
            jPanelListaIuSeguros.setBounds(-300, 138, 200, 50);
        } else{
            auxSeleccionList2 = false;
        }

    }//GEN-LAST:event_jListSegurosMouseClicked

    private void jListVehiculosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListVehiculosFocusGained

        jPanelListaDominioVeh.setBounds(115, 290, 200, 50); 
    }//GEN-LAST:event_jListVehiculosFocusGained

    private void jListVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListVehiculosMouseClicked
        int indexList = jListVehiculos.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList2 = true;
            jTextFieldDominioVeh.setText("");
            jTextFieldDominioVeh.setText(jListVehiculos.getSelectedValue());
            jPanelListaDominioVeh.setBounds(-300, 290, 200, 50);
        } else{
            auxSeleccionList2 = false;
        }
    
    }//GEN-LAST:event_jListVehiculosMouseClicked

    private void jButtonAceptarElementoNoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoNoExistenteActionPerformed
        switch(auxAbm){

            case 1:
            jPanelElementoNoExistente.setBounds(-260, 200, 250, 100);
            jButtonAgregarPolizaSiniestro.setEnabled(true);
            jButtonEditarPolizaSiniestro.setEnabled(false);
            jButtonBorrarPolizaSiniestro.setEnabled(false);
            jButtonTraerPanelBuscar.setEnabled(true);
                
            jTextFieldIuPolizaSiniestro.setEditable(false); 
            jTextFieldIuSeguros.setEditable(true);
            jTextFieldNumPoliza.setEditable(true);
            jTextFieldNumSiniestro.setEditable(true);
            jTextFieldNombreAsegurado.setEditable(true);
            jTextFieldDominioVeh.setEditable(true);
            jButtonRegSeguros.setEnabled(true);
            jButtonRegVehiculos.setEnabled(true);
            jButtonTraerPanelBuscar.setEnabled(true);
            
            jPanelListaIuSeguros.setVisible(true);
            jPanelListaDominioVeh.setVisible(true); 
            jListSeguros.setVisible(true);
            jListVehiculos.setVisible(true);
            break;

            case 2:
            jPanelElementoNoExistente.setBounds(-260, 200, 250, 100);
            jButtonAgregarPolizaSiniestro.setEnabled(false);
            jButtonEditarPolizaSiniestro.setEnabled(true);
            jButtonBorrarPolizaSiniestro.setEnabled(false);
            jButtonTraerPanelBuscar.setEnabled(true);
                
            jTextFieldIuPolizaSiniestro.setEditable(false); 
            jTextFieldIuSeguros.setEditable(true);
            jTextFieldNumPoliza.setEditable(true);
            jTextFieldNumSiniestro.setEditable(true);
            jTextFieldNombreAsegurado.setEditable(true);
            jTextFieldDominioVeh.setEditable(true);
            jButtonRegSeguros.setEnabled(true);
            jButtonRegVehiculos.setEnabled(true);
            jButtonTraerPanelBuscar.setEnabled(true);
            
            jPanelListaIuSeguros.setVisible(true);
            jPanelListaDominioVeh.setVisible(true); 
            jListSeguros.setVisible(true);
            jListVehiculos.setVisible(true);
            break;

            case 3:
            jPanelElementoNoExistente.setBounds(-260, 200, 250, 100);
            jButtonAgregarPolizaSiniestro.setEnabled(false);
            jButtonEditarPolizaSiniestro.setEnabled(false);
            jButtonBorrarPolizaSiniestro.setEnabled(true);
            jButtonTraerPanelBuscar.setEnabled(true);
                
            jTextFieldIuPolizaSiniestro.setEditable(false); 
            jTextFieldIuSeguros.setEditable(false);
            jTextFieldNumPoliza.setEditable(false);
            jTextFieldNumSiniestro.setEditable(false);
            jTextFieldNombreAsegurado.setEditable(false);
            jTextFieldDominioVeh.setEditable(false);
            jButtonRegSeguros.setEnabled(false);
            jButtonRegVehiculos.setEnabled(false);
            jButtonTraerPanelBuscar.setEnabled(false);
            
            jPanelListaIuSeguros.setVisible(false);
            jPanelListaDominioVeh.setVisible(false); 
            jListSeguros.setVisible(false);
            jListVehiculos.setVisible(false);
            break;
        }
    }//GEN-LAST:event_jButtonAceptarElementoNoExistenteActionPerformed

    private void jTextFieldIuSegurosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuSegurosFocusGained

        jListSeguros.setModel(_administradorSeguros.cargarLista(jTextFieldIuSeguros.getText()));
        jPanelListaIuSeguros.setBounds(240, 138, 200, 50);
    }//GEN-LAST:event_jTextFieldIuSegurosFocusGained

    private void jTextFieldIuSegurosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuSegurosFocusLost

        jPanelListaIuSeguros.setBounds(-300,138, 200, 50);
    }//GEN-LAST:event_jTextFieldIuSegurosFocusLost

    private void jTextFieldIuSegurosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIuSegurosKeyReleased

        jListSeguros.setModel(_administradorSeguros.cargarLista(jTextFieldIuSeguros.getText()));
        jPanelListaIuSeguros.setBounds(240, 138, 200, 50);
    }//GEN-LAST:event_jTextFieldIuSegurosKeyReleased

    private void jButtonRegVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegVehiculosActionPerformed
        JFrameRegistroVehiculos obj = new JFrameRegistroVehiculos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_jButtonRegVehiculosActionPerformed

    private void jTextFieldDominioVehFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDominioVehFocusGained

        jListVehiculos.setModel(_administradorVehiculos.cargarLista(jTextFieldDominioVeh.getText()));
        jPanelListaDominioVeh.setBounds(115, 290, 200, 50);
    }//GEN-LAST:event_jTextFieldDominioVehFocusGained

    private void jTextFieldDominioVehFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDominioVehFocusLost

        jPanelListaDominioVeh.setBounds(-300,290, 200, 50);
    }//GEN-LAST:event_jTextFieldDominioVehFocusLost

    private void jTextFieldDominioVehKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDominioVehKeyReleased

        jListVehiculos.setModel(_administradorVehiculos.cargarLista(jTextFieldDominioVeh.getText()));
        jPanelListaDominioVeh.setBounds(115,290, 200, 50);
    }//GEN-LAST:event_jTextFieldDominioVehKeyReleased

    private void jButtonAgregarPolizaSiniestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarPolizaSiniestroActionPerformed

        jButtonAgregarPolizaSiniestro.setEnabled(false);
        jButtonEditarPolizaSiniestro.setEnabled(false);
        jButtonBorrarPolizaSiniestro.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldIuPolizaSiniestro.setEditable(false); 
        jTextFieldIuSeguros.setEditable(false);
        jTextFieldNumPoliza.setEditable(false);
        jTextFieldNumSiniestro.setEditable(false);
        jTextFieldNombreAsegurado.setEditable(false);
        jTextFieldDominioVeh.setEditable(false);
        jButtonRegSeguros.setEnabled(false);
        jButtonRegVehiculos.setEnabled(false);
        jListSeguros.setVisible(false);
        jListVehiculos.setVisible(false);
        
        jPanelMensajeValidarABM.setBounds(325, 200, 250, 100);
        auxAbm = 1;
        
    }//GEN-LAST:event_jButtonAgregarPolizaSiniestroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAceptarElementoExistente;
    private javax.swing.JButton jButtonAceptarElementoNoExistente;
    private javax.swing.JButton jButtonAceptarErrorBaseDeDatos;
    private javax.swing.JButton jButtonAceptarGuardadoErroneo;
    private javax.swing.JButton jButtonAceptarGuardadoExitoso;
    private javax.swing.JButton jButtonAceptarItemNoSeleccionado2;
    private javax.swing.JButton jButtonAceptarValidarCambios;
    private javax.swing.JButton jButtonAgregarPolizaSiniestro;
    private javax.swing.JButton jButtonBorrarPolizaSiniestro;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelarValidarCambios;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonEditarPolizaSiniestro;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JButton jButtonRegSeguros;
    private javax.swing.JButton jButtonRegVehiculos;
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
    private javax.swing.JLabel jLabelTituloBuscarPolizaSiniestro;
    private javax.swing.JLabel jLabelTituloDominioVeh;
    private javax.swing.JLabel jLabelTituloIuPolizaSiniestro;
    private javax.swing.JLabel jLabelTituloIuSeguros;
    private javax.swing.JLabel jLabelTituloNombreAsegurado;
    private javax.swing.JLabel jLabelTituloNumPoliza;
    private javax.swing.JLabel jLabelTituloNumSiniestro;
    private javax.swing.JLabel jLabelTituloVentana;
    private javax.swing.JLabel jLabelToolKitMarca;
    private javax.swing.JList<String> jListSeguros;
    private javax.swing.JList<String> jListVehiculos;
    private javax.swing.JPanel jPanelBarraTitulo;
    private javax.swing.JPanel jPanelCuerpo;
    private javax.swing.JPanel jPanelElementoExistente;
    private javax.swing.JPanel jPanelElementoNoExistente;
    private javax.swing.JPanel jPanelErrorBaseDeDatos;
    private javax.swing.JPanel jPanelGuardadoErroneo;
    private javax.swing.JPanel jPanelGuardadoExitoso;
    private javax.swing.JPanel jPanelItemNoSeleccionado;
    private javax.swing.JPanel jPanelListaDominioVeh;
    private javax.swing.JPanel jPanelListaIuSeguros;
    private javax.swing.JPanel jPanelMensajeCerrar;
    private javax.swing.JPanel jPanelMensajeValidarABM;
    private javax.swing.JPanel jPanelVentanaBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparatorBuscarPolizaSiniestro;
    private javax.swing.JSeparator jSeparatorDominioVeh;
    private javax.swing.JSeparator jSeparatorIuPolizaSiniestro;
    private javax.swing.JSeparator jSeparatorIuSeguros;
    private javax.swing.JSeparator jSeparatorNombreAsegurado;
    private javax.swing.JSeparator jSeparatorNumPoliza;
    private javax.swing.JSeparator jSeparatorNumSiniestro;
    private javax.swing.JTable jTablePolizaSiniestro;
    private javax.swing.JTextField jTextFieldBuscarPolizaSiniestro;
    private javax.swing.JTextField jTextFieldDominioVeh;
    private javax.swing.JTextField jTextFieldIuPolizaSiniestro;
    private javax.swing.JTextField jTextFieldIuSeguros;
    private javax.swing.JTextField jTextFieldNombreAsegurado;
    private javax.swing.JTextField jTextFieldNumPoliza;
    private javax.swing.JTextField jTextFieldNumSiniestro;
    // End of variables declaration//GEN-END:variables
}
