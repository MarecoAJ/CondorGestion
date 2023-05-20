/*
* este JFrame registra (agrega, borra, edita, busca y filtra) todos la caja
*/
package Vistas;

import administradorClases.Administrador;
import administradorClases.AdministradorDetallesCaja;
import administradorClases.AdministradorCaja;
import administradorClases.AdministradorCartera;
import administradorClases.AdministradorCheques;
import clasesDatos.Cheques;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class JFrameRegistroCheques extends javax.swing.JFrame {
// atributos y variables    
    private final AdministradorCheques _administradorCheques;
    private final AdministradorDetallesCaja _administradorDetallesCaja;
    private final AdministradorCaja _administradorCaja;
    private final AdministradorCartera _administradorCartera;
    private Cheques _objCheques;
    private TableModel modeloTablaC;
    private int auxAbm;
    private boolean auxSeleccionList;
    private boolean auxSeleccionList2;
    private boolean auxSeleccionList3;
    
    public JFrameRegistroCheques() {
        initComponents();
// se personaliza las fuentes de letra de los objetos grafico
        jLabelTituloVentana.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 8));
        jLabelTituloNumCheque.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldNumCheque.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jLabelTituloTipoCheque.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldTipoCheque.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloBancoEmisor.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldBancoEmisor.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloBuscarCheques.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldBuscarCheques.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloSucursalBanco.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldSucursalBanco.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloMontoCheque.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldMontoCheque.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloIuCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldIuCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jTextFieldIuCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloIuCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldIuDetalleCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloIuDetalleCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldFechaCheque.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloFechaCheque.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldFechaCobro.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloFechaCobro.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
                                
        jLabelMensajeElementoExistente.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeItemNoSeleccionado.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeErrorBaseDeDatos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));         
        jLabelMensajeGuardadoErroneo.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeGuardadoCorrecto.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeValidarCambios.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeUno.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeDos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
// se personaliza el jTable    
        jTableCheques.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 6));
        JTableHeader auxJTableHeader;
        auxJTableHeader = jTableCheques.getTableHeader();
        auxJTableHeader.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
// se instancia la clase AdministradorTipoCaja y se inicializa el menu del jTable
        _administradorCheques = new AdministradorCheques();
        _administradorDetallesCaja = new AdministradorDetallesCaja();
        _administradorCaja = new AdministradorCaja();
        _administradorCartera = new AdministradorCartera();
        
        popupMenuJTable();
        
        jButtonBorrarTajetas.setEnabled(false);
        jButtonEditarTajetas.setEnabled(false);
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
        jSeparatorBuscarCheques = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCheques = new javax.swing.JTable();
        jLabelTituloBuscarCheques = new javax.swing.JLabel();
        jTextFieldBuscarCheques = new javax.swing.JTextField();
        jButtonTraerPanelCuerpo = new javax.swing.JButton();
        jLabelFondoVentanaBuscar = new javax.swing.JLabel();
        jPanelCuerpo = new javax.swing.JPanel();
        jPanelListaIuCartera = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListIuCartera = new javax.swing.JList<>();
        jPanelListaCaja = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListCaja = new javax.swing.JList<>();
        jPanelListaDetalleCaja = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListDEtalleCaja = new javax.swing.JList<>();
        jButtonRegCaja = new javax.swing.JButton();
        jLabelTituloIuCaja = new javax.swing.JLabel();
        jTextFieldIuCaja = new javax.swing.JTextField();
        jSeparatorIuCaja = new javax.swing.JSeparator();
        jLabelTituloMontoCheque = new javax.swing.JLabel();
        jTextFieldMontoCheque = new javax.swing.JTextField();
        jSeparatorMontoCheque = new javax.swing.JSeparator();
        jLabelTituloSucursalBanco = new javax.swing.JLabel();
        jTextFieldSucursalBanco = new javax.swing.JTextField();
        jSeparatorSucursalBanco = new javax.swing.JSeparator();
        jLabelTituloBancoEmisor = new javax.swing.JLabel();
        jTextFieldBancoEmisor = new javax.swing.JTextField();
        jSeparatorBancoEmisor = new javax.swing.JSeparator();
        jLabelTituloTipoCheque = new javax.swing.JLabel();
        jTextFieldTipoCheque = new javax.swing.JTextField();
        jSeparatorTipoCheque = new javax.swing.JSeparator();
        jLabelTituloIuDetalleCaja = new javax.swing.JLabel();
        jTextFieldIuDetalleCaja = new javax.swing.JTextField();
        jSeparatorIuDetalleCaja = new javax.swing.JSeparator();
        jSeparatorNumCheque = new javax.swing.JSeparator();
        jLabelTituloNumCheque = new javax.swing.JLabel();
        jTextFieldNumCheque = new javax.swing.JTextField();
        jTextFieldFechaCheque = new javax.swing.JTextField();
        jSeparatorFechaCheque = new javax.swing.JSeparator();
        jLabelTituloFechaCheque = new javax.swing.JLabel();
        jLabelTituloFechaCobro = new javax.swing.JLabel();
        jTextFieldFechaCobro = new javax.swing.JTextField();
        jSeparatorFechaCobro = new javax.swing.JSeparator();
        jLabelTituloIuCartera = new javax.swing.JLabel();
        jTextFieldIuCartera = new javax.swing.JTextField();
        jSeparatorIuCartera = new javax.swing.JSeparator();
        jButtonRegCartera = new javax.swing.JButton();
        jButtonAgregarTajetas = new javax.swing.JButton();
        jButtonEditarTajetas = new javax.swing.JButton();
        jButtonBorrarTajetas = new javax.swing.JButton();
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

        jSeparatorBuscarCheques.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorBuscarCheques.setForeground(new java.awt.Color(0, 0, 0));
        jPanelVentanaBuscar.add(jSeparatorBuscarCheques, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 55, 100, 2));

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));

        jTableCheques = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jTableCheques.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nº registro", "Tarjeta", "Caja", "Detalle de caja", "Nº tarjeta", "Nº comprobante", "Lote", "Total"
            }
        ));
        jTableCheques.setToolTipText("Has click derecho para opciones.");
        jTableCheques.setAutoscrolls(false);
        jTableCheques.setFocusable(false);
        jTableCheques.setMaximumSize(new java.awt.Dimension(480, 450));
        jTableCheques.setMinimumSize(new java.awt.Dimension(480, 450));
        jTableCheques.setPreferredSize(new java.awt.Dimension(480, 450));
        jTableCheques.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jTableCheques.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jTableCheques.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableCheques);

        jPanelVentanaBuscar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 680, 375));

        jLabelTituloBuscarCheques.setText("Parametro de busqueda:");
        jPanelVentanaBuscar.add(jLabelTituloBuscarCheques, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 10, -1, 25));

        jTextFieldBuscarCheques.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBuscarCheques.setToolTipText("ingresa parametros de busqueda. Ej: vent");
        jTextFieldBuscarCheques.setBorder(null);
        jTextFieldBuscarCheques.setDisabledTextColor(new java.awt.Color(194, 4, 48));
        jTextFieldBuscarCheques.setOpaque(false);
        jTextFieldBuscarCheques.setSelectionColor(new java.awt.Color(73, 73, 73));
        jTextFieldBuscarCheques.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarChequesKeyReleased(evt);
            }
        });
        jPanelVentanaBuscar.add(jTextFieldBuscarCheques, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 35, 100, 20));

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

        jPanelListaIuCartera.setOpaque(false);
        jPanelListaIuCartera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(200, 45));

        jListIuCartera.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListIuCarteraFocusGained(evt);
            }
        });
        jListIuCartera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListIuCarteraMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListIuCartera);

        jPanelListaIuCartera.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 45));

        jPanelCuerpo.add(jPanelListaIuCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 290, 200, 45));

        jPanelListaCaja.setOpaque(false);
        jPanelListaCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(200, 45));

        jListCaja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListCajaFocusGained(evt);
            }
        });
        jListCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListCajaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jListCaja);

        jPanelListaCaja.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 45));

        jPanelCuerpo.add(jPanelListaCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 138, 100, 45));

        jPanelListaDetalleCaja.setOpaque(false);
        jPanelListaDetalleCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane5.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane5.setPreferredSize(new java.awt.Dimension(200, 45));

        jListDEtalleCaja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListDEtalleCajaFocusGained(evt);
            }
        });
        jListDEtalleCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListDEtalleCajaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jListDEtalleCaja);

        jPanelListaDetalleCaja.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 45));

        jPanelCuerpo.add(jPanelListaDetalleCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 138, 100, 45));

        jButtonRegCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x25Off.png"))); // NOI18N
        jButtonRegCaja.setBorder(null);
        jButtonRegCaja.setBorderPainted(false);
        jButtonRegCaja.setContentAreaFilled(false);
        jButtonRegCaja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegCaja.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegCajaActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonRegCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 115, -1, -1));

        jLabelTituloIuCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuCaja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuCaja.setText("Nº caja:");
        jLabelTituloIuCaja.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloIuCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 98, -1, 25));

        jTextFieldIuCaja.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuCaja.setToolTipText("Ingrese solo numeros. Ej.: 33.");
        jTextFieldIuCaja.setBorder(null);
        jTextFieldIuCaja.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuCaja.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuCaja.setOpaque(false);
        jTextFieldIuCaja.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuCaja.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldIuCaja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIuCajaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldIuCajaFocusLost(evt);
            }
        });
        jTextFieldIuCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldIuCajaKeyReleased(evt);
            }
        });
        jPanelCuerpo.add(jTextFieldIuCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 118, 100, 20));

        jSeparatorIuCaja.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuCaja.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuCaja.setOpaque(true);
        jPanelCuerpo.add(jSeparatorIuCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 138, 100, -1));

        jLabelTituloMontoCheque.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloMontoCheque.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloMontoCheque.setText("Total:");
        jLabelTituloMontoCheque.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloMontoCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 322, -1, 25));

        jTextFieldMontoCheque.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldMontoCheque.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldMontoCheque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldMontoCheque.setToolTipText("Ingrese solo decimales. Ej.: 99.01");
        jTextFieldMontoCheque.setBorder(null);
        jTextFieldMontoCheque.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldMontoCheque.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldMontoCheque.setOpaque(false);
        jTextFieldMontoCheque.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldMontoCheque.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldMontoCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 342, 100, 20));

        jSeparatorMontoCheque.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorMontoCheque.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorMontoCheque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorMontoCheque.setOpaque(true);
        jPanelCuerpo.add(jSeparatorMontoCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 362, 100, -1));

        jLabelTituloSucursalBanco.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloSucursalBanco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloSucursalBanco.setText("Sucursal:");
        jLabelTituloSucursalBanco.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloSucursalBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 176, -1, 25));

        jTextFieldSucursalBanco.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldSucursalBanco.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldSucursalBanco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSucursalBanco.setToolTipText("Ingrese solo numeros. Ej.: 003");
        jTextFieldSucursalBanco.setBorder(null);
        jTextFieldSucursalBanco.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldSucursalBanco.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldSucursalBanco.setOpaque(false);
        jTextFieldSucursalBanco.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldSucursalBanco.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldSucursalBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 196, 200, 20));

        jSeparatorSucursalBanco.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorSucursalBanco.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorSucursalBanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorSucursalBanco.setOpaque(true);
        jPanelCuerpo.add(jSeparatorSucursalBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 218, 200, -1));

        jLabelTituloBancoEmisor.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloBancoEmisor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloBancoEmisor.setText("Nombre del banco:");
        jLabelTituloBancoEmisor.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloBancoEmisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 176, -1, 25));

        jTextFieldBancoEmisor.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldBancoEmisor.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldBancoEmisor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBancoEmisor.setToolTipText("Ingrese solo numeros. Ej.: 003");
        jTextFieldBancoEmisor.setBorder(null);
        jTextFieldBancoEmisor.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldBancoEmisor.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldBancoEmisor.setOpaque(false);
        jTextFieldBancoEmisor.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldBancoEmisor.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldBancoEmisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 196, 200, 20));

        jSeparatorBancoEmisor.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorBancoEmisor.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorBancoEmisor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorBancoEmisor.setOpaque(true);
        jPanelCuerpo.add(jSeparatorBancoEmisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 216, 200, -1));

        jLabelTituloTipoCheque.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloTipoCheque.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloTipoCheque.setText("Tipo de cheque:");
        jLabelTituloTipoCheque.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloTipoCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 98, -1, 25));

        jTextFieldTipoCheque.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldTipoCheque.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldTipoCheque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTipoCheque.setToolTipText("Ingrese solo texto. Ej.: Naranja.");
        jTextFieldTipoCheque.setBorder(null);
        jTextFieldTipoCheque.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldTipoCheque.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldTipoCheque.setOpaque(false);
        jTextFieldTipoCheque.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldTipoCheque.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldTipoCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 118, 100, 20));

        jSeparatorTipoCheque.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorTipoCheque.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorTipoCheque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorTipoCheque.setOpaque(true);
        jPanelCuerpo.add(jSeparatorTipoCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 138, 100, -1));

        jLabelTituloIuDetalleCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuDetalleCaja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuDetalleCaja.setText("Nº detalle:");
        jLabelTituloIuDetalleCaja.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloIuDetalleCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 98, -1, 25));

        jTextFieldIuDetalleCaja.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuDetalleCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuDetalleCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuDetalleCaja.setToolTipText("Ingrese solo numeros. Ej.: 9.");
        jTextFieldIuDetalleCaja.setBorder(null);
        jTextFieldIuDetalleCaja.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuDetalleCaja.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuDetalleCaja.setOpaque(false);
        jTextFieldIuDetalleCaja.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuDetalleCaja.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldIuDetalleCaja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIuDetalleCajaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldIuDetalleCajaFocusLost(evt);
            }
        });
        jTextFieldIuDetalleCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldIuDetalleCajaKeyReleased(evt);
            }
        });
        jPanelCuerpo.add(jTextFieldIuDetalleCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 118, 100, 20));

        jSeparatorIuDetalleCaja.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuDetalleCaja.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuDetalleCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuDetalleCaja.setOpaque(true);
        jPanelCuerpo.add(jSeparatorIuDetalleCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 138, 100, -1));

        jSeparatorNumCheque.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorNumCheque.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorNumCheque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorNumCheque.setOpaque(true);
        jPanelCuerpo.add(jSeparatorNumCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 60, 100, -1));

        jLabelTituloNumCheque.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloNumCheque.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloNumCheque.setText("Nº de cheque:");
        jLabelTituloNumCheque.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloNumCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, 25));

        jTextFieldNumCheque.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldNumCheque.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldNumCheque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNumCheque.setToolTipText("");
        jTextFieldNumCheque.setBorder(null);
        jTextFieldNumCheque.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldNumCheque.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldNumCheque.setOpaque(false);
        jTextFieldNumCheque.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldNumCheque.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldNumCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 40, 100, 20));

        jTextFieldFechaCheque.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldFechaCheque.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldFechaCheque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldFechaCheque.setToolTipText("");
        jTextFieldFechaCheque.setBorder(null);
        jTextFieldFechaCheque.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaCheque.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaCheque.setOpaque(false);
        jTextFieldFechaCheque.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaCheque.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldFechaCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 100, 20));

        jSeparatorFechaCheque.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorFechaCheque.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorFechaCheque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorFechaCheque.setOpaque(true);
        jPanelCuerpo.add(jSeparatorFechaCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 100, -1));

        jLabelTituloFechaCheque.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloFechaCheque.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloFechaCheque.setText("Fecha del cheque:");
        jLabelTituloFechaCheque.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloFechaCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 20, -1, 25));

        jLabelTituloFechaCobro.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloFechaCobro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloFechaCobro.setText("Fecha de cobro:");
        jLabelTituloFechaCobro.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloFechaCobro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, 25));

        jTextFieldFechaCobro.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldFechaCobro.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldFechaCobro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldFechaCobro.setToolTipText("Ingrese solo texto. Ej.: Naranja.");
        jTextFieldFechaCobro.setBorder(null);
        jTextFieldFechaCobro.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaCobro.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaCobro.setOpaque(false);
        jTextFieldFechaCobro.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaCobro.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldFechaCobro, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 270, 100, 20));

        jSeparatorFechaCobro.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorFechaCobro.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorFechaCobro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorFechaCobro.setOpaque(true);
        jPanelCuerpo.add(jSeparatorFechaCobro, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 290, 100, -1));

        jLabelTituloIuCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuCartera.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuCartera.setText("Emisor del cheque:");
        jLabelTituloIuCartera.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloIuCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 250, -1, 25));

        jTextFieldIuCartera.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuCartera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuCartera.setToolTipText("Ingrese solo numeros. Ej.: 220.");
        jTextFieldIuCartera.setBorder(null);
        jTextFieldIuCartera.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuCartera.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuCartera.setOpaque(false);
        jTextFieldIuCartera.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuCartera.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldIuCartera.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIuCarteraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldIuCarteraFocusLost(evt);
            }
        });
        jTextFieldIuCartera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldIuCarteraKeyReleased(evt);
            }
        });
        jPanelCuerpo.add(jTextFieldIuCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 200, 20));

        jSeparatorIuCartera.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuCartera.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuCartera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuCartera.setOpaque(true);
        jPanelCuerpo.add(jSeparatorIuCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 200, -1));

        jButtonRegCartera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x25Off.png"))); // NOI18N
        jButtonRegCartera.setBorder(null);
        jButtonRegCartera.setBorderPainted(false);
        jButtonRegCartera.setContentAreaFilled(false);
        jButtonRegCartera.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegCartera.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegCartera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegCarteraActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonRegCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 268, -1, -1));

        jButtonAgregarTajetas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOff.png"))); // NOI18N
        jButtonAgregarTajetas.setToolTipText("Has click para agregar.");
        jButtonAgregarTajetas.setBorder(null);
        jButtonAgregarTajetas.setBorderPainted(false);
        jButtonAgregarTajetas.setContentAreaFilled(false);
        jButtonAgregarTajetas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregarTajetas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarTajetas.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarTajetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarTajetasActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonAgregarTajetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 407, -1, -1));

        jButtonEditarTajetas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOff.png"))); // NOI18N
        jButtonEditarTajetas.setToolTipText("Has click para editar.");
        jButtonEditarTajetas.setBorder(null);
        jButtonEditarTajetas.setBorderPainted(false);
        jButtonEditarTajetas.setContentAreaFilled(false);
        jButtonEditarTajetas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditarTajetas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarTajetas.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarTajetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarTajetasActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonEditarTajetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 407, -1, -1));

        jButtonBorrarTajetas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOff.png"))); // NOI18N
        jButtonBorrarTajetas.setToolTipText("Has click para borrar.");
        jButtonBorrarTajetas.setBorder(null);
        jButtonBorrarTajetas.setBorderPainted(false);
        jButtonBorrarTajetas.setContentAreaFilled(false);
        jButtonBorrarTajetas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBorrarTajetas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarTajetas.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarTajetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarTajetasActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonBorrarTajetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 407, -1, -1));

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
        jLabelTituloVentana.setText("Registro de tajetas");
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
    public void validarIuCaja(){
        auxSeleccionList = _administradorCaja.obtenerIuCaja(jTextFieldIuCaja.getText()).length() != 0;
    } 
    
    public void validarIuDetalleCaja(){
        auxSeleccionList2 = _administradorDetallesCaja.obtenerIuDetalleCaja(jTextFieldIuCaja.getText(), jTextFieldIuDetalleCaja.getText()).length() != 0;
    }
    
// valida codModeloVeh en caso de no hacer cick en a lista
    public void validarCartera(){
        auxSeleccionList3 = _administradorCartera.obtenerIuCartera2(jTextFieldIuCartera.getText())!= 0;
    }
    
// se crea un objeto de la clase utilizada    
    public void crearObjCheques(){
     
        _objCheques = new Cheques();
        _objCheques.setNumCheque(Integer.parseInt(jTextFieldNumCheque.getText()));
        _objCheques.setFechaCheque(jTextFieldFechaCheque.getText());
        _objCheques.setIuCaja(Integer.parseInt(jTextFieldIuCaja.getText()));
        _objCheques.setIuDetalleCaja(Integer.parseInt(jTextFieldIuDetalleCaja.getText()));
        _objCheques.setTipoCheque(jTextFieldTipoCheque.getText());
        _objCheques.setBancoEmisor(jTextFieldBancoEmisor.getText());
        _objCheques.setSucursalBanco(jTextFieldSucursalBanco.getText());
        _objCheques.setFechaCobro(jTextFieldFechaCobro.getText());
        _objCheques.setIuCartera(_administradorCartera.obtenerIuCartera2(jTextFieldIuCartera.getText()));
        _objCheques.setMontoCheque(Double.parseDouble(jTextFieldMontoCheque.getText()));
     }
      
// limpia los jtextfield usados
    public void limpiarCampos(){

        jTextFieldNumCheque.setText("");
        jTextFieldTipoCheque.setText(""); 
        jTextFieldBancoEmisor.setText("");
        jTextFieldMontoCheque.setText("");
        jTextFieldSucursalBanco.setText("");
        jTextFieldIuCartera.setText("");
        jTextFieldIuCaja.setText("");
        jTextFieldIuDetalleCaja.setText("");
        jTextFieldFechaCheque.setText("");
        jTextFieldFechaCobro.setText("");
        }
     
// este metodo crea menu de opciones al usar click secundario   
    public final void popupMenuJTable(){
//se crean las opciones del menu
        JPopupMenu jPopupMenuTableHC= new JPopupMenu();
        JMenuItem jMenuItemEliminarCheques = new JMenuItem("Eliminar"); // cambiar x ico 
        JMenuItem jMenuItemModificarCheques = new JMenuItem("Modificar");
        JMenuItem jMenuOrdenar = new JMenu("Ordenar por");
        JMenuItem jMenuItemPrimerosAgregados = new JMenuItem("Primeros agregados");
        JMenuItem jMenuItemUltimosAgregados= new JMenuItem("Ultimos agregados");
        jMenuOrdenar.add(jMenuItemPrimerosAgregados);
        jMenuOrdenar.add(jMenuItemUltimosAgregados); 
// se generan las acciones de cada opcion
        jMenuItemEliminarCheques.addActionListener((ActionEvent e) -> {
        
        if(seleccionarItemJTabla()!= -1){
                 
            jPanelVentanaBuscar.setBounds(-700, 30, 700, 457);
            jPanelCuerpo.setBounds( 100,30,  700, 457);
              
            jButtonAgregarTajetas.setEnabled(false);
            jButtonEditarTajetas.setEnabled(false);
            jButtonBorrarTajetas.setEnabled(true);
            
            jTextFieldNumCheque.setEditable(false); 
            jTextFieldTipoCheque.setEditable(false);
            jTextFieldBancoEmisor.setEditable(false);
            jTextFieldSucursalBanco.setEditable(false);
            jTextFieldMontoCheque.setEditable(false);
            jTextFieldIuCartera.setEditable(false);
            jTextFieldFechaCheque.setEditable(false);
            jTextFieldFechaCobro.setEditable(false);
            jButtonRegCartera.setEnabled(false);
            jButtonRegCaja.setEnabled(false);
            jButtonTraerPanelBuscar.setEnabled(true);
            
            jListCaja.setVisible(false);
            jListDEtalleCaja.setVisible(false);
            jListIuCartera.setVisible(false);
            
             }
         });
         
        jMenuItemModificarCheques.addActionListener((ActionEvent e) -> {
            
        if(seleccionarItemJTabla()!= -1){
                     
            jPanelVentanaBuscar.setBounds(-700, 30, 700, 457);
            jPanelCuerpo.setBounds( 100,30,  700, 457);
              
            jButtonAgregarTajetas.setEnabled(false);
            jButtonBorrarTajetas.setEnabled(false);
            jButtonEditarTajetas.setEnabled(true);
            
            jTextFieldNumCheque.setEditable(false); 
            jTextFieldTipoCheque.setEditable(true);
            jTextFieldBancoEmisor.setEditable(true);
            jTextFieldSucursalBanco.setEditable(true);
            jTextFieldMontoCheque.setEditable(true);
            jTextFieldIuCartera.setEditable(true);
            jTextFieldIuCaja.setEditable(true);
            jTextFieldIuDetalleCaja.setEditable(true);  
            jTextFieldFechaCheque.setEditable(true);
            jTextFieldFechaCobro.setEditable(true);
            jButtonRegCartera.setEnabled(true);
            jButtonRegCaja.setEnabled(true);
            jButtonTraerPanelBuscar.setEnabled(true);
            
            jListCaja.setVisible(true);
            jListDEtalleCaja.setVisible(true);
            jListIuCartera.setVisible(true);

            
        }
        });
             
        jMenuItemUltimosAgregados.addActionListener((ActionEvent e) -> {
            _administradorCheques.ordenarTabla(jMenuItemUltimosAgregados.getText());
            jTableCheques.setModel( _administradorCheques.cargarJTabla());
        });
                           
        jMenuItemPrimerosAgregados.addActionListener((ActionEvent e) -> {
            _administradorCheques.ordenarTabla(jMenuItemPrimerosAgregados.getText());
            jTableCheques.setModel( _administradorCheques.cargarJTabla());
        });
// se construye el menu completo y se le asigna si jTable
        jPopupMenuTableHC.add(jMenuItemEliminarCheques);
        jPopupMenuTableHC.add(jMenuItemModificarCheques);
        jPopupMenuTableHC.add(jMenuOrdenar);
        jTableCheques.setComponentPopupMenu(jPopupMenuTableHC);  
     }
 
// se obtiene los datos del item seleccionado en la tabla
    public int seleccionarItemJTabla(){
// se obtiene el modelo y se verifica que se haya seleccionado un item   
        modeloTablaC = jTableCheques.getModel();
        int auxSeleccion = jTableCheques.getSelectedRow();
        if (auxSeleccion != -1) {
            jTableCheques.setEnabled(true);
// se cargan los campos con los valores selcionados
            jTextFieldNumCheque.setText((String)modeloTablaC.getValueAt(jTableCheques.getSelectedRow(), 0));
            jTextFieldTipoCheque.setText((String)modeloTablaC.getValueAt(jTableCheques.getSelectedRow(), 1));
            jTextFieldFechaCheque.setText((String)modeloTablaC.getValueAt(jTableCheques.getSelectedRow(), 2));
            jTextFieldFechaCobro.setText((String)modeloTablaC.getValueAt(jTableCheques.getSelectedRow(), 3));
            jTextFieldIuCaja.setText((String)modeloTablaC.getValueAt(jTableCheques.getSelectedRow(),6));
            jTextFieldIuDetalleCaja.setText((String)modeloTablaC.getValueAt(jTableCheques.getSelectedRow(),7));
            jTextFieldBancoEmisor.setText((String)modeloTablaC.getValueAt(jTableCheques.getSelectedRow(),4));
            jTextFieldSucursalBanco.setText((String)modeloTablaC.getValueAt(jTableCheques.getSelectedRow(), 5));
            jTextFieldIuCartera.setText((String)modeloTablaC.getValueAt(jTableCheques.getSelectedRow(), 8));
            jTextFieldMontoCheque.setText((String)modeloTablaC.getValueAt(jTableCheques.getSelectedRow(), 9));
            return auxSeleccion;
            
        }else {
// si no selecciona mensaje error 
            jTableCheques.setEnabled(false);
            jPanelItemNoSeleccionado.setBounds(325, 200, 250,100);
            return auxSeleccion;
        }
    }
    
//visualiza el panel buscar
    private void jButtonTraerPanelBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelBuscarActionPerformed
// llama al panel buscar 
    try {
        jTableCheques.setModel(_administradorCheques.cargarJTabla());
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
    private void jButtonEditarTajetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarTajetasActionPerformed
        jPanelMensajeValidarABM.setBounds(325, 200, 250, 100);
        auxAbm = 2;
        jButtonAgregarTajetas.setEnabled(false);
        jButtonEditarTajetas.setEnabled(false);
        jButtonBorrarTajetas.setEnabled(false);
        
        jTextFieldNumCheque.setEditable(false);
        jTextFieldTipoCheque.setEditable(false);
        jTextFieldBancoEmisor.setEditable(false);
        jTextFieldSucursalBanco.setEditable(false);
        jTextFieldMontoCheque.setEditable(false);
        jTextFieldIuCartera.setEditable(false);
        jTextFieldIuCaja.setEditable(false);
        jTextFieldIuDetalleCaja.setEditable(false);
        jTextFieldFechaCheque.setEditable(false);
        jTextFieldFechaCobro.setEditable(false);
        
        jButtonRegCartera.setEnabled(false);
        jButtonRegCaja.setEnabled(false);
        
        jButtonTraerPanelBuscar.setEnabled(false);
        jListIuCartera.setVisible(false);
        jListDEtalleCaja.setVisible(false);
        jListCaja.setVisible(false);
        
    }//GEN-LAST:event_jButtonEditarTajetasActionPerformed

//valida datos y borra un registro en tabla tipocaja 
    private void jButtonBorrarTajetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarTajetasActionPerformed
        
        jPanelMensajeValidarABM.setBounds(325, 200, 250, 100);
        auxAbm = 3;
        
        jButtonAgregarTajetas.setEnabled(false);
        jButtonEditarTajetas.setEnabled(false);
        jButtonBorrarTajetas.setEnabled(false);
        
        jTextFieldNumCheque.setEditable(false);
        jTextFieldTipoCheque.setEditable(false);
        jTextFieldBancoEmisor.setEditable(false);
        jTextFieldSucursalBanco.setEditable(false);
        jTextFieldMontoCheque.setEditable(false);
        jTextFieldIuCartera.setEditable(false);
        jTextFieldIuCaja.setEditable(false);
        jTextFieldIuDetalleCaja.setEditable(false);
        jTextFieldFechaCheque.setEditable(false);
        jTextFieldFechaCobro.setEditable(false);
        
        jButtonRegCartera.setEnabled(false);
        jButtonRegCaja.setEnabled(false);
        
        jButtonTraerPanelBuscar.setEnabled(false);
        jListIuCartera.setVisible(false);
        jListDEtalleCaja.setVisible(false);
        jListCaja.setVisible(false);
        
    }//GEN-LAST:event_jButtonBorrarTajetasActionPerformed

// con cada tecleo valida los datos y elimina los no correctos
    private void jTextFieldBuscarChequesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarChequesKeyReleased
        boolean auxValidar = Administrador.validarCharDinamico(evt.getKeyChar(), "[a-zA-Z_0-9]||[\\s]");
    try {
        
        if(auxValidar==false){
               
            evt.consume();
            jTableCheques.setModel(_administradorCheques.cargarJTabla());
               
        } else{
           
            jTableCheques.setModel(_administradorCheques.buscarEnTabla(jTextFieldBuscarCheques.getText()));
           }
    } catch (Exception e) {
        
        jPanelErrorBaseDeDatos.setBounds(325, 200, 250, 100);  
    }      
    }//GEN-LAST:event_jTextFieldBuscarChequesKeyReleased

//esconde el panel y habilita los obj en pantalla
    private void jButtonCancelarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarValidarCambiosActionPerformed
        
        auxAbm = 0;
        limpiarCampos();
        jPanelMensajeValidarABM.setBounds(-260, 200, 250, 100);
        jButtonAgregarTajetas.setEnabled(true);
        jButtonEditarTajetas.setEnabled(false);
        jButtonBorrarTajetas.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        
        jTextFieldNumCheque.setEditable(false);
        jTextFieldNumCheque.setBorder(null);
        jTextFieldTipoCheque.setEditable(true);
        jTextFieldTipoCheque.setBorder(null);
        jTextFieldBancoEmisor.setEditable(true);
        jTextFieldBancoEmisor.setBorder(null);
        jTextFieldSucursalBanco.setEditable(true);
        jTextFieldSucursalBanco.setBorder(null);
        jTextFieldIuCartera.setEditable(true);
        jTextFieldIuCartera.setBorder(null);
        jTextFieldMontoCheque.setEditable(true);
        jTextFieldMontoCheque.setBorder(null);
        jTextFieldIuCaja.setEditable(true);
        jTextFieldIuCaja.setBorder(null);
        jTextFieldIuDetalleCaja.setEditable(true);
        jTextFieldIuDetalleCaja.setBorder(null);
        jTextFieldFechaCheque.setEditable(true);
        jTextFieldFechaCheque.setBorder(null);
        jTextFieldFechaCobro.setEditable(true);
        jTextFieldFechaCobro.setBorder(null);
        
        jListIuCartera.setVisible(true);
        jListCaja.setVisible(true);
        jListDEtalleCaja.setVisible(true);
        jPanelListaIuCartera.setVisible(true);
        jPanelListaCaja.setVisible(true);
        jPanelListaDetalleCaja.setVisible(true);
    }//GEN-LAST:event_jButtonCancelarValidarCambiosActionPerformed

    private void jButtonAceptarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarValidarCambiosActionPerformed
        boolean[] listaVerdades = new boolean[10];
        int aux = 0;
        int auxMensaje2 = 0;
        int auxMensaje = 0;
                
// llama al panel y segun desde donde llamo ejecuta la accion        
        jPanelMensajeValidarABM.setBounds(-260, 193, 250, 100);     
        switch(auxAbm){
            
            case 1:
                validarCartera();
                listaVerdades[0] = auxSeleccionList3;
                validarIuCaja();
                listaVerdades[1] = auxSeleccionList;
                validarIuDetalleCaja();
                listaVerdades[2] = auxSeleccionList2;
                listaVerdades[3] = Administrador.validarCamposTextos(jTextFieldBancoEmisor.getText(), "[A-Za-z]" );
                listaVerdades[4] = Administrador.validarCamposTextos(jTextFieldTipoCheque.getText(), "[A-Za-z]" );
                listaVerdades[5] = Administrador.validarCamposTextos(jTextFieldSucursalBanco.getText(), "[A-Za-z]" );
                listaVerdades[6] = Administrador.validarCamposDoubles(jTextFieldMontoCheque.getText());
                listaVerdades[7] = Administrador.validarCamposTextos(jTextFieldNumCheque.getText(), "\\d" );
                listaVerdades[8] = Administrador.validarFecha(jTextFieldFechaCheque.getText());
                listaVerdades[9] = Administrador.validarFecha(jTextFieldFechaCobro.getText());
                
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==10){
                    jTextFieldTipoCheque.setBorder(new LineBorder(Color.green));
                    jTextFieldBancoEmisor.setBorder(new LineBorder(Color.green));
                    jTextFieldSucursalBanco.setBorder(new LineBorder(Color.green));
                    jTextFieldMontoCheque.setBorder(new LineBorder(Color.green));
                    jTextFieldIuCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldIuCaja.setBorder(new LineBorder(Color.green));
                    jTextFieldIuDetalleCaja.setBorder(new LineBorder(Color.green));
                    jTextFieldNumCheque.setBorder( new LineBorder(Color.green));
                    jTextFieldFechaCheque.setBorder( new LineBorder(Color.green));
                    jTextFieldFechaCobro.setBorder( new LineBorder(Color.green));
                    auxSeleccionList = false;
                    auxSeleccionList2 = false;
                    auxSeleccionList3 = false;
                    
                    crearObjCheques();
        
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorCheques.insertarTablaCheques(_objCheques)==true){
               
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
                                    jTextFieldIuCartera.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuCartera.setBorder(new LineBorder(Color.red));
                                    if(_administradorCartera.obtenerIuCartera2(jTextFieldIuCartera.getText())==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                        
                        case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuCaja.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuCaja.setBorder(new LineBorder(Color.red));
                                    if(_administradorCaja.obtenerIuCaja(jTextFieldIuCaja.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                        
                        case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuDetalleCaja.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuDetalleCaja.setBorder(new LineBorder(Color.red));
                                    if(_administradorDetallesCaja.obtenerIuDetalleCaja(jTextFieldIuCaja.getText(), jTextFieldIuDetalleCaja.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldBancoEmisor.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldBancoEmisor.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            
                            case 4:
                                if(listaVerdades[i]==true){
                                    jTextFieldTipoCheque.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldTipoCheque.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 5:
                                if(listaVerdades[i]==true){
                                    jTextFieldSucursalBanco.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldSucursalBanco.setBorder(new LineBorder(Color.red));
                                    
                                }
                        break;
                            case 6:
                                if(listaVerdades[i]==true){
                                    jTextFieldMontoCheque.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldMontoCheque.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 7:
                                if(listaVerdades[i]==true){
                                    jTextFieldNumCheque.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNumCheque.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                                case 8:
                                if(listaVerdades[i]==true){
                                    jTextFieldFechaCheque.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldFechaCheque.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                                case 9:
                                if(listaVerdades[i]==true){
                                    jTextFieldFechaCobro.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldFechaCobro.setBorder(new LineBorder(Color.red));
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
                validarCartera();
                listaVerdades[0] = auxSeleccionList3;
                validarIuCaja();
                listaVerdades[1] = auxSeleccionList;
                validarIuDetalleCaja();
                listaVerdades[2] = auxSeleccionList2;
                listaVerdades[3] = Administrador.validarCamposTextos(jTextFieldBancoEmisor.getText(), "[A-Za-z]" );
                listaVerdades[4] = Administrador.validarCamposTextos(jTextFieldTipoCheque.getText(), "[A-Za-z]" );
                listaVerdades[5] = Administrador.validarCamposTextos(jTextFieldSucursalBanco.getText(), "[A-Za-z]" );
                listaVerdades[6] = Administrador.validarCamposDoubles(jTextFieldMontoCheque.getText());
                listaVerdades[7] = Administrador.validarCamposTextos(jTextFieldNumCheque.getText(), "\\d" );
                listaVerdades[8] = Administrador.validarFecha(jTextFieldFechaCheque.getText());
                listaVerdades[9] = Administrador.validarFecha(jTextFieldFechaCheque.getText());
                
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==10){
                    jTextFieldTipoCheque.setBorder(new LineBorder(Color.green));
                    jTextFieldBancoEmisor.setBorder(new LineBorder(Color.green));
                    jTextFieldSucursalBanco.setBorder(new LineBorder(Color.green));
                    jTextFieldMontoCheque.setBorder(new LineBorder(Color.green));
                    jTextFieldIuCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldIuCaja.setBorder(new LineBorder(Color.green));
                    jTextFieldIuDetalleCaja.setBorder(new LineBorder(Color.green));
                    jTextFieldNumCheque.setBorder( new LineBorder(Color.green));
                    jTextFieldFechaCheque.setBorder( new LineBorder(Color.green));
                    jTextFieldFechaCobro.setBorder( new LineBorder(Color.green));
                    auxSeleccionList = false;
                    auxSeleccionList2 = false;
                    auxSeleccionList3 = false;
                    
                    crearObjCheques();
        
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorCheques.actualizarTablaCheques(_objCheques)==true){
               
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
                                    jTextFieldIuCartera.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuCartera.setBorder(new LineBorder(Color.red));
                                    if(_administradorCartera.obtenerIuCartera2(jTextFieldIuCartera.getText())==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                        
                        case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuCaja.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuCaja.setBorder(new LineBorder(Color.red));
                                    if(_administradorCaja.obtenerIuCaja(jTextFieldIuCaja.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                        
                        case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuDetalleCaja.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuDetalleCaja.setBorder(new LineBorder(Color.red));
                                    if(_administradorDetallesCaja.obtenerIuDetalleCaja(jTextFieldIuCaja.getText(), jTextFieldIuDetalleCaja.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldBancoEmisor.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldBancoEmisor.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            
                            case 4:
                                if(listaVerdades[i]==true){
                                    jTextFieldTipoCheque.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldTipoCheque.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 5:
                                if(listaVerdades[i]==true){
                                    jTextFieldSucursalBanco.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldSucursalBanco.setBorder(new LineBorder(Color.red));
                                    
                                }
                        break;
                            case 6:
                                if(listaVerdades[i]==true){
                                    jTextFieldMontoCheque.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldMontoCheque.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 7:
                                if(listaVerdades[i]==true){
                                    jTextFieldNumCheque.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNumCheque.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                                case 8:
                                if(listaVerdades[i]==true){
                                    jTextFieldFechaCheque.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldFechaCheque.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                                case 9:
                                if(listaVerdades[i]==true){
                                    jTextFieldFechaCobro.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldFechaCobro.setBorder(new LineBorder(Color.red));
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
                validarCartera();
                listaVerdades[0] = auxSeleccionList3;
                validarIuCaja();
                listaVerdades[1] = auxSeleccionList;
                validarIuDetalleCaja();
                listaVerdades[2] = auxSeleccionList2;
                listaVerdades[3] = Administrador.validarCamposTextos(jTextFieldBancoEmisor.getText(), "[A-Za-z]" );
                listaVerdades[4] = Administrador.validarCamposTextos(jTextFieldTipoCheque.getText(), "[A-Za-z]" );
                listaVerdades[5] = Administrador.validarCamposTextos(jTextFieldSucursalBanco.getText(), "[A-Za-z]" );
                listaVerdades[6] = Administrador.validarCamposDoubles(jTextFieldMontoCheque.getText());
                listaVerdades[7] = Administrador.validarCamposTextos(jTextFieldNumCheque.getText(), "\\d" );
                listaVerdades[8] = Administrador.validarFecha(jTextFieldFechaCheque.getText());
                listaVerdades[9] = Administrador.validarFecha(jTextFieldFechaCheque.getText());
                
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==10){
                    jTextFieldTipoCheque.setBorder(new LineBorder(Color.green));
                    jTextFieldBancoEmisor.setBorder(new LineBorder(Color.green));
                    jTextFieldSucursalBanco.setBorder(new LineBorder(Color.green));
                    jTextFieldMontoCheque.setBorder(new LineBorder(Color.green));
                    jTextFieldIuCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldIuCaja.setBorder(new LineBorder(Color.green));
                    jTextFieldIuDetalleCaja.setBorder(new LineBorder(Color.green));
                    jTextFieldNumCheque.setBorder( new LineBorder(Color.green));
                    jTextFieldFechaCheque.setBorder( new LineBorder(Color.green));
                    jTextFieldFechaCobro.setBorder( new LineBorder(Color.green));
                    auxSeleccionList = false;
                    auxSeleccionList2 = false;
                    auxSeleccionList3 = false;
                    
                    crearObjCheques();
        
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorCheques.eliminarTablaCheques(_objCheques)==true){
               
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
                                    jTextFieldIuCartera.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuCartera.setBorder(new LineBorder(Color.red));
                                    if(_administradorCartera.obtenerIuCartera2(jTextFieldIuCartera.getText())==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                        
                        case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuCaja.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuCaja.setBorder(new LineBorder(Color.red));
                                    if(_administradorCaja.obtenerIuCaja(jTextFieldIuCaja.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                        
                        case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuDetalleCaja.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuDetalleCaja.setBorder(new LineBorder(Color.red));
                                    if(_administradorDetallesCaja.obtenerIuDetalleCaja(jTextFieldIuCaja.getText(), jTextFieldIuDetalleCaja.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldBancoEmisor.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldBancoEmisor.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            
                            case 4:
                                if(listaVerdades[i]==true){
                                    jTextFieldTipoCheque.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldTipoCheque.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 5:
                                if(listaVerdades[i]==true){
                                    jTextFieldSucursalBanco.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldSucursalBanco.setBorder(new LineBorder(Color.red));
                                    
                                }
                        break;
                            case 6:
                                if(listaVerdades[i]==true){
                                    jTextFieldMontoCheque.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldMontoCheque.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 7:
                                if(listaVerdades[i]==true){
                                    jTextFieldNumCheque.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNumCheque.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                                case 8:
                                if(listaVerdades[i]==true){
                                    jTextFieldFechaCheque.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldFechaCheque.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                                case 9:
                                if(listaVerdades[i]==true){
                                    jTextFieldFechaCobro.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldFechaCobro.setBorder(new LineBorder(Color.red));
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
       
        limpiarCampos();
        jButtonAgregarTajetas.setEnabled(true);
        jButtonBorrarTajetas.setEnabled(false);
        jButtonEditarTajetas.setEnabled(false);
        jTextFieldNumCheque.setEditable(true);
        jTextFieldNumCheque.setBorder(null);
        jTextFieldTipoCheque.setEditable(true);
        jTextFieldTipoCheque.setBorder(null);
        jTextFieldBancoEmisor.setEditable(true);
        jTextFieldBancoEmisor.setBorder(null);
        jTextFieldSucursalBanco.setEditable(true);
        jTextFieldSucursalBanco.setBorder(null);
        jTextFieldIuCartera.setEditable(true);
        jTextFieldIuCartera.setBorder(null);
        jTextFieldMontoCheque.setEditable(true);
        jTextFieldMontoCheque.setBorder(null);
        jTextFieldIuCaja.setEditable(true);
        jTextFieldIuCaja.setBorder(null);
        jTextFieldIuDetalleCaja.setEditable(true);
        jTextFieldIuDetalleCaja.setBorder(null);
        jTextFieldFechaCheque.setEditable(true);
        jTextFieldFechaCheque.setBorder(null);
        jTextFieldFechaCobro.setEditable(true);
        jTextFieldFechaCobro.setBorder(null);
        jButtonRegCaja.setEnabled(true);
        jButtonRegCartera.setEnabled(true);
        jButtonTraerPanelBuscar.setEnabled(true);
        jListCaja.setVisible(true);
        jListDEtalleCaja.setVisible(true);
        jListIuCartera.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarGuardadoExitosoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarGuardadoErroneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoErroneoActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelGuardadoErroneo.setBounds(-260, 200, 250, 100);
                jButtonAgregarTajetas.setEnabled(true);
                jButtonEditarTajetas.setEnabled(false);
                jButtonBorrarTajetas.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldTipoCheque.setEditable(true);
                jTextFieldNumCheque.setEditable(true); 
                jTextFieldTipoCheque.setEditable(true);
                jTextFieldBancoEmisor.setEditable(true);
                jTextFieldSucursalBanco.setEditable(true);
                jTextFieldMontoCheque.setEditable(true);
                jTextFieldIuCaja.setEditable(true);
                jTextFieldIuDetalleCaja.setEditable(true);
                jTextFieldIuCartera.setEditable(true);
                jTextFieldFechaCheque.setEditable(true);
                jTextFieldFechaCobro.setEditable(true);
                
                jButtonRegCartera.setEnabled(true);
                jButtonRegCaja.setEnabled(true);
                
                jPanelListaIuCartera.setVisible(true);
                jPanelListaCaja.setVisible(true); 
                jListIuCartera.setVisible(true);
                jListCaja.setVisible(true);
                jPanelListaDetalleCaja.setVisible(true);
                jListDEtalleCaja.setVisible(true);
            break;
            
            case 2:
                jPanelGuardadoErroneo.setBounds(-260, 200, 250, 100);
                jButtonAgregarTajetas.setEnabled(false);
                jButtonEditarTajetas.setEnabled(true);
                jButtonBorrarTajetas.setEnabled(false);
                
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldTipoCheque.setEditable(true);
                jTextFieldNumCheque.setEditable(false); 
                jTextFieldTipoCheque.setEditable(true);
                jTextFieldBancoEmisor.setEditable(true);
                jTextFieldSucursalBanco.setEditable(true);
                jTextFieldMontoCheque.setEditable(true);
                jTextFieldIuCaja.setEditable(true);
                jTextFieldIuDetalleCaja.setEditable(true);
                jTextFieldIuCartera.setEditable(true);
                jTextFieldFechaCheque.setEditable(true);
                jTextFieldFechaCobro.setEditable(true);
                
                jButtonRegCartera.setEnabled(true);
                jButtonRegCaja.setEnabled(true);
                
                jPanelListaIuCartera.setVisible(true);
                jPanelListaCaja.setVisible(true); 
                jListIuCartera.setVisible(true);
                jListCaja.setVisible(true);
                jPanelListaDetalleCaja.setVisible(true);
                jListDEtalleCaja.setVisible(true);
            break;
            
            case 3: 
                
                jPanelGuardadoErroneo.setBounds(-260, 200, 250, 100);
                jButtonAgregarTajetas.setEnabled(false);
                jButtonEditarTajetas.setEnabled(false);
                jButtonBorrarTajetas.setEnabled(true);
                jTextFieldTipoCheque.setEditable(false);
                jTextFieldNumCheque.setEditable(false); 
                jTextFieldTipoCheque.setEditable(false);
                jTextFieldBancoEmisor.setEditable(false);
                jTextFieldSucursalBanco.setEditable(false);
                jTextFieldMontoCheque.setEditable(false);
                jTextFieldIuCaja.setEditable(false);
                jTextFieldIuDetalleCaja.setEditable(false);
                jTextFieldIuCartera.setEditable(false);
                jTextFieldFechaCheque.setEditable(false);
                jTextFieldFechaCobro.setEditable(false);
                jButtonRegCartera.setEnabled(false);
                jButtonRegCaja.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                
                jListIuCartera.setVisible(false);
                jListCaja.setVisible(false);
                jListDEtalleCaja.setVisible(false);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarGuardadoErroneoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarErrorBaseDeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarErrorBaseDeDatosActionPerformed
        
        jPanelErrorBaseDeDatos.setBounds(-260, 200, 250, 100);
                
        jButtonAgregarTajetas.setEnabled(false);
        jButtonEditarTajetas.setEnabled(true);
        jButtonBorrarTajetas.setEnabled(false);
        
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldTipoCheque.setEditable(true);
        jTextFieldNumCheque.setEditable(false); 
        jTextFieldTipoCheque.setEditable(true);
        jTextFieldBancoEmisor.setEditable(true);
        jTextFieldSucursalBanco.setEditable(true);
        jTextFieldMontoCheque.setEditable(true);
        jTextFieldIuCaja.setEditable(true);
        jTextFieldIuDetalleCaja.setEditable(true);
        jTextFieldIuCartera.setEditable(true);
        jTextFieldFechaCheque.setEditable(true);
        jTextFieldFechaCobro.setEditable(true);
        jButtonRegCartera.setEnabled(true);
        jButtonRegCaja.setEnabled(true);
        jPanelListaIuCartera.setVisible(true);
        jPanelListaCaja.setVisible(true); 
        jListIuCartera.setVisible(true);
        jListCaja.setVisible(true);
        jPanelListaDetalleCaja.setVisible(true);
        jListDEtalleCaja.setVisible(true);


    }//GEN-LAST:event_jButtonAceptarErrorBaseDeDatosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarElementoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoExistenteActionPerformed
        
        jPanelElementoExistente.setBounds(-260, 200, 250, 100);
        jButtonAgregarTajetas.setEnabled(true);
        jButtonEditarTajetas.setEnabled(false);
        jButtonBorrarTajetas.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldTipoCheque.setEditable(true);
        jTextFieldNumCheque.setEditable(false); 
        jTextFieldTipoCheque.setEditable(true);
        jTextFieldBancoEmisor.setEditable(true);
        jTextFieldSucursalBanco.setEditable(true);
        jTextFieldMontoCheque.setEditable(true);
        jTextFieldIuCaja.setEditable(true);
        jTextFieldIuDetalleCaja.setEditable(true);
        jTextFieldIuCartera.setEditable(true);
        jTextFieldFechaCheque.setEditable(true);
        jTextFieldFechaCobro.setEditable(true);
        jButtonRegCartera.setEnabled(true);
        jButtonRegCaja.setEnabled(true);
        jPanelListaIuCartera.setVisible(true);
        jPanelListaCaja.setVisible(true); 
        jListIuCartera.setVisible(true);
        jListCaja.setVisible(true);
        jPanelListaDetalleCaja.setVisible(true);
        jListDEtalleCaja.setVisible(true);

    }//GEN-LAST:event_jButtonAceptarElementoExistenteActionPerformed

// se acomoda los objetos del frame para continuar trabajando. 
    private void jButtonAceptarItemNoSeleccionado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

        jTableCheques.setEnabled(true);
        jPanelItemNoSeleccionado.setBounds(-260, 200, 250, 100); 
    }//GEN-LAST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

    private void jListIuCarteraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListIuCarteraFocusGained

        jPanelListaIuCartera.setBounds(360, 290, 200, 50);
    }//GEN-LAST:event_jListIuCarteraFocusGained

    private void jListIuCarteraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListIuCarteraMouseClicked
        int indexList = jListIuCartera.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList3 = true;
            jTextFieldIuCartera.setText("");
            jTextFieldIuCartera.setText(jListIuCartera.getSelectedValue());
            jPanelListaIuCartera.setBounds(-1000, 290, 200, 50);
        } else{
            auxSeleccionList3 = false;
        }

    }//GEN-LAST:event_jListIuCarteraMouseClicked

    private void jListCajaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListCajaFocusGained

        jPanelListaCaja.setBounds(302, 138, 100, 50);
    }//GEN-LAST:event_jListCajaFocusGained

    private void jListCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListCajaMouseClicked
        int indexList = jListCaja.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList = true;
            jTextFieldIuCaja.setText("");
            jTextFieldIuCaja.setText(jListCaja.getSelectedValue());
            jPanelListaCaja.setBounds(-1000, 138, 100, 50);
        } else{
            auxSeleccionList = false;
        }
    
    }//GEN-LAST:event_jListCajaMouseClicked

    private void jButtonAceptarElementoNoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoNoExistenteActionPerformed
        switch(auxAbm){

            case 1:
            jPanelElementoNoExistente.setBounds(-260, 200, 250, 100);
            jButtonAgregarTajetas.setEnabled(true);
            jButtonEditarTajetas.setEnabled(false);
            jButtonBorrarTajetas.setEnabled(false);
            jButtonTraerPanelBuscar.setEnabled(true);
            jTextFieldTipoCheque.setEditable(true);
            jTextFieldNumCheque.setEditable(false); 
            jTextFieldTipoCheque.setEditable(true);
            jTextFieldBancoEmisor.setEditable(true);
            jTextFieldSucursalBanco.setEditable(true);
            jTextFieldMontoCheque.setEditable(true);
            jTextFieldIuCaja.setEditable(true);
            jTextFieldIuDetalleCaja.setEditable(true);
            jTextFieldIuCartera.setEditable(true);
            jTextFieldFechaCheque.setEditable(true);
            jTextFieldFechaCobro.setEditable(true);
            jButtonRegCartera.setEnabled(true);
            jButtonRegCaja.setEnabled(true);
            jPanelListaIuCartera.setVisible(true);
            jPanelListaCaja.setVisible(true); 
            jListIuCartera.setVisible(true);
            jListCaja.setVisible(true);
            jPanelListaDetalleCaja.setVisible(true);
            jListDEtalleCaja.setVisible(true);

            break;

            case 2:
            jPanelElementoNoExistente.setBounds(-260, 200, 250, 100);
            jButtonAgregarTajetas.setEnabled(false);
            jButtonEditarTajetas.setEnabled(true);
            jButtonBorrarTajetas.setEnabled(false);
            jButtonTraerPanelBuscar.setEnabled(true);
            jTextFieldTipoCheque.setEditable(true);
            jTextFieldNumCheque.setEditable(false); 
            jTextFieldTipoCheque.setEditable(true);
            jTextFieldBancoEmisor.setEditable(true);
            jTextFieldSucursalBanco.setEditable(true);
            jTextFieldMontoCheque.setEditable(true);
            jTextFieldIuCaja.setEditable(true);
            jTextFieldIuDetalleCaja.setEditable(true);
            jTextFieldIuCartera.setEditable(true);
            jTextFieldFechaCheque.setEditable(true);
            jTextFieldFechaCobro.setEditable(true);
            jButtonRegCartera.setEnabled(true);
            jButtonRegCaja.setEnabled(true);
            jPanelListaIuCartera.setVisible(true);
            jPanelListaCaja.setVisible(true); 
            jListIuCartera.setVisible(true);
            jListCaja.setVisible(true);
            jPanelListaDetalleCaja.setVisible(true);
            jListDEtalleCaja.setVisible(true);

            break;
            
            case 3:
                
            jPanelElementoNoExistente.setBounds(-260, 200, 250, 100);
            jButtonAgregarTajetas.setEnabled(false);
            jButtonEditarTajetas.setEnabled(false);
            jButtonBorrarTajetas.setEnabled(true);
            jButtonTraerPanelBuscar.setEnabled(true);
            jTextFieldTipoCheque.setEditable(false);
            jTextFieldNumCheque.setEditable(false); 
            jTextFieldTipoCheque.setEditable(false);
            jTextFieldBancoEmisor.setEditable(false);
            jTextFieldSucursalBanco.setEditable(false);
            jTextFieldMontoCheque.setEditable(false);
            jTextFieldIuCaja.setEditable(false);
            jTextFieldIuDetalleCaja.setEditable(false);
            jTextFieldIuCartera.setEditable(false);
            jTextFieldFechaCheque.setEditable(false);
            jTextFieldFechaCobro.setEditable(false);
            jButtonRegCartera.setEnabled(false);
            jButtonRegCaja.setEnabled(false);
            jPanelListaIuCartera.setVisible(true);
            jPanelListaCaja.setVisible(true); 
            jListIuCartera.setVisible(false);
            jListCaja.setVisible(false);
            jPanelListaDetalleCaja.setVisible(true);
            jListDEtalleCaja.setVisible(false);
            break;
        }
    }//GEN-LAST:event_jButtonAceptarElementoNoExistenteActionPerformed

    private void jButtonAgregarTajetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarTajetasActionPerformed

            jButtonAgregarTajetas.setEnabled(false);
            jButtonEditarTajetas.setEnabled(false);
            jButtonBorrarTajetas.setEnabled(false);
            jButtonTraerPanelBuscar.setEnabled(false);
            jTextFieldTipoCheque.setEditable(false);
            jTextFieldNumCheque.setEditable(false); 
            jTextFieldTipoCheque.setEditable(false);
            jTextFieldBancoEmisor.setEditable(false);
            jTextFieldSucursalBanco.setEditable(false);
            jTextFieldMontoCheque.setEditable(false);
            jTextFieldIuCaja.setEditable(false);
            jTextFieldIuDetalleCaja.setEditable(false);
            jTextFieldIuCartera.setEditable(false);
            jButtonRegCartera.setEnabled(false);
            jButtonRegCaja.setEnabled(false); 
            jListIuCartera.setVisible(false);
            jListCaja.setVisible(false);
            jListDEtalleCaja.setVisible(false);
            jTextFieldFechaCobro.setEditable(false);
            jTextFieldFechaCheque.setEditable(false);
        
        jPanelMensajeValidarABM.setBounds(325, 200, 250, 100);
        auxAbm = 1;
        
    }//GEN-LAST:event_jButtonAgregarTajetasActionPerformed

    private void jButtonRegCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegCajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegCajaActionPerformed

    private void jTextFieldIuCajaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuCajaFocusGained

        jListCaja.setModel(_administradorCaja.cargarLista(jTextFieldIuCaja.getText()));
        jPanelListaCaja.setBounds(305, 138, 100, 50);
    }//GEN-LAST:event_jTextFieldIuCajaFocusGained

    private void jTextFieldIuCajaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuCajaFocusLost
        
        jPanelListaCaja.setBounds(-1000, 138, 100, 50);
    }//GEN-LAST:event_jTextFieldIuCajaFocusLost

    private void jTextFieldIuCajaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIuCajaKeyReleased

        jListCaja.setModel(_administradorCaja.cargarLista(jTextFieldIuCaja.getText()));
        jPanelListaCaja.setBounds(305, 138, 100, 50);
    }//GEN-LAST:event_jTextFieldIuCajaKeyReleased

    private void jTextFieldIuDetalleCajaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuDetalleCajaFocusGained
        
        jListDEtalleCaja.setModel(_administradorDetallesCaja.cargarLista(jTextFieldIuCaja.getText(), jTextFieldIuDetalleCaja.getText()));
        jPanelListaDetalleCaja.setBounds(488, 138, 100, 50);
    }//GEN-LAST:event_jTextFieldIuDetalleCajaFocusGained

    private void jTextFieldIuDetalleCajaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuDetalleCajaFocusLost
        
        jPanelListaDetalleCaja.setBounds(-1000, 138, 100, 50);
    }//GEN-LAST:event_jTextFieldIuDetalleCajaFocusLost

    private void jTextFieldIuDetalleCajaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIuDetalleCajaKeyReleased
        
        jListDEtalleCaja.setModel(_administradorDetallesCaja.cargarLista(jTextFieldIuCaja.getText(), jTextFieldIuDetalleCaja.getText()));
        jPanelListaDetalleCaja.setBounds(488, 138, 100, 50);
    }//GEN-LAST:event_jTextFieldIuDetalleCajaKeyReleased

    private void jListDEtalleCajaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListDEtalleCajaFocusGained
        jPanelListaDetalleCaja.setBounds(488, 138, 100, 50);
    }//GEN-LAST:event_jListDEtalleCajaFocusGained

    private void jListDEtalleCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListDEtalleCajaMouseClicked
        int indexList = jListDEtalleCaja.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList2 = true;
            jTextFieldIuDetalleCaja.setText("");
            jTextFieldIuDetalleCaja.setText(jListDEtalleCaja.getSelectedValue());
            jPanelListaDetalleCaja.setBounds(-1000, 138, 100, 50);
        } else{
            auxSeleccionList2 = false;
        }
    }//GEN-LAST:event_jListDEtalleCajaMouseClicked

    private void jButtonRegCarteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegCarteraActionPerformed
        JFrameRegistroCartera obj = new JFrameRegistroCartera();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegCarteraActionPerformed

    private void jTextFieldIuCarteraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuCarteraFocusGained
        
        jListIuCartera.setModel(_administradorCartera.cargarLista2(jTextFieldIuCartera.getText()));
        jPanelListaIuCartera.setBounds(360,290,200,50);
    }//GEN-LAST:event_jTextFieldIuCarteraFocusGained

    private void jTextFieldIuCarteraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIuCarteraKeyReleased
        
        jListIuCartera.setModel(_administradorCartera.cargarLista2(jTextFieldIuCartera.getText()));
        jPanelListaIuCartera.setBounds(360,290,200,50);        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIuCarteraKeyReleased

    private void jTextFieldIuCarteraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuCarteraFocusLost

        jPanelListaIuCartera.setBounds(-1000,290,200,50);
    }//GEN-LAST:event_jTextFieldIuCarteraFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAceptarElementoExistente;
    private javax.swing.JButton jButtonAceptarElementoNoExistente;
    private javax.swing.JButton jButtonAceptarErrorBaseDeDatos;
    private javax.swing.JButton jButtonAceptarGuardadoErroneo;
    private javax.swing.JButton jButtonAceptarGuardadoExitoso;
    private javax.swing.JButton jButtonAceptarItemNoSeleccionado2;
    private javax.swing.JButton jButtonAceptarValidarCambios;
    private javax.swing.JButton jButtonAgregarTajetas;
    private javax.swing.JButton jButtonBorrarTajetas;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelarValidarCambios;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonEditarTajetas;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JButton jButtonRegCaja;
    private javax.swing.JButton jButtonRegCartera;
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
    private javax.swing.JLabel jLabelTituloBancoEmisor;
    private javax.swing.JLabel jLabelTituloBuscarCheques;
    private javax.swing.JLabel jLabelTituloFechaCheque;
    private javax.swing.JLabel jLabelTituloFechaCobro;
    private javax.swing.JLabel jLabelTituloIuCaja;
    private javax.swing.JLabel jLabelTituloIuCartera;
    private javax.swing.JLabel jLabelTituloIuDetalleCaja;
    private javax.swing.JLabel jLabelTituloMontoCheque;
    private javax.swing.JLabel jLabelTituloNumCheque;
    private javax.swing.JLabel jLabelTituloSucursalBanco;
    private javax.swing.JLabel jLabelTituloTipoCheque;
    private javax.swing.JLabel jLabelTituloVentana;
    private javax.swing.JLabel jLabelToolKitMarca;
    private javax.swing.JList<String> jListCaja;
    private javax.swing.JList<String> jListDEtalleCaja;
    private javax.swing.JList<String> jListIuCartera;
    private javax.swing.JPanel jPanelBarraTitulo;
    private javax.swing.JPanel jPanelCuerpo;
    private javax.swing.JPanel jPanelElementoExistente;
    private javax.swing.JPanel jPanelElementoNoExistente;
    private javax.swing.JPanel jPanelErrorBaseDeDatos;
    private javax.swing.JPanel jPanelGuardadoErroneo;
    private javax.swing.JPanel jPanelGuardadoExitoso;
    private javax.swing.JPanel jPanelItemNoSeleccionado;
    private javax.swing.JPanel jPanelListaCaja;
    private javax.swing.JPanel jPanelListaDetalleCaja;
    private javax.swing.JPanel jPanelListaIuCartera;
    private javax.swing.JPanel jPanelMensajeCerrar;
    private javax.swing.JPanel jPanelMensajeValidarABM;
    private javax.swing.JPanel jPanelVentanaBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparatorBancoEmisor;
    private javax.swing.JSeparator jSeparatorBuscarCheques;
    private javax.swing.JSeparator jSeparatorFechaCheque;
    private javax.swing.JSeparator jSeparatorFechaCobro;
    private javax.swing.JSeparator jSeparatorIuCaja;
    private javax.swing.JSeparator jSeparatorIuCartera;
    private javax.swing.JSeparator jSeparatorIuDetalleCaja;
    private javax.swing.JSeparator jSeparatorMontoCheque;
    private javax.swing.JSeparator jSeparatorNumCheque;
    private javax.swing.JSeparator jSeparatorSucursalBanco;
    private javax.swing.JSeparator jSeparatorTipoCheque;
    private javax.swing.JTable jTableCheques;
    private javax.swing.JTextField jTextFieldBancoEmisor;
    private javax.swing.JTextField jTextFieldBuscarCheques;
    private javax.swing.JTextField jTextFieldFechaCheque;
    private javax.swing.JTextField jTextFieldFechaCobro;
    private javax.swing.JTextField jTextFieldIuCaja;
    private javax.swing.JTextField jTextFieldIuCartera;
    private javax.swing.JTextField jTextFieldIuDetalleCaja;
    private javax.swing.JTextField jTextFieldMontoCheque;
    private javax.swing.JTextField jTextFieldNumCheque;
    private javax.swing.JTextField jTextFieldSucursalBanco;
    private javax.swing.JTextField jTextFieldTipoCheque;
    // End of variables declaration//GEN-END:variables
}
