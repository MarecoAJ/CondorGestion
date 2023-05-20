/*
* este JFrame registra (agrega, borra, edita, busca y filtra) todos los vehiculos
*/
package Vistas;

import administradorClases.Administrador;
import administradorClases.AdministradorCaja;
import administradorClases.AdministradorDetallesCaja;
import administradorClases.AdministradorTipoPagos;
import clasesDatos.DetallesDeCaja;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class JFrameRegistroDetallesDeCaja extends javax.swing.JFrame {
// atributos y variables    
    private final AdministradorDetallesCaja _administradorDetallesCaja;
    private final AdministradorTipoPagos _administradorTipoPagos;
    private final AdministradorCaja _administradorCaja;
    private DetallesDeCaja _objDetallesCaja;
    private TableModel modeloTablaDC;
    private int auxAbm;
    private int auxSeleccionList;
    
    public JFrameRegistroDetallesDeCaja() {
        initComponents();
// se personaliza las fuentes de letra de los objetos grafico
        jLabelTituloVentana.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 8));
        jLabelTituloIuDetalleCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldIuDetalleCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloIuCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldIuCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloIuTipoPago.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldIuTipoPago.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloBuscarDetalleDeCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldBuscarDetalleDeCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloSubTotal.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldSubTotal.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));

        
        jLabelMensajeElementoExistente.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeItemNoSeleccionado.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeErrorBaseDeDatos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));        
        jLabelMensajeGuardadoErroneo.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeGuardadoCorrecto.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeValidarCambios.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeUno.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeDos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
// se personaliza el jTable    
        jTableDetalleDeCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 6));
        JTableHeader auxJTableHeader;
        auxJTableHeader = jTableDetalleDeCaja.getTableHeader();
        auxJTableHeader.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
// se instancia la clase AdministradorTipoPagos y se inicializa el menu del jTable
        _administradorDetallesCaja = new AdministradorDetallesCaja();
        _administradorTipoPagos = new AdministradorTipoPagos();
        _administradorCaja = new AdministradorCaja();
        
        popupMenuJTable();
        jTextFieldIuCaja.setText(_administradorCaja.obtenerUltimoId());
        
        
        
        jButtonEditarDetalleCaja.setEnabled(false);
        jButtonBorrarDetalleCaja.setEnabled(false);
        jTextFieldIuCaja. setEditable(false);
        jTextFieldIuDetalleCaja.setEditable(false);
    }  
  
    public void setIuCaja(String iuCaja){
        
        jTextFieldIuCaja.setText(iuCaja);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMensajeTarChes = new javax.swing.JPanel();
        jLabelMensajeTarChes = new javax.swing.JLabel();
        jLabelMensajeTarChes1 = new javax.swing.JLabel();
        jButtonRegTarjetas = new javax.swing.JButton();
        jButtonRegCheques = new javax.swing.JButton();
        jButtonCancelarRegistros = new javax.swing.JButton();
        jLabelIconoTarChes = new javax.swing.JLabel();
        jLabelFondoIconoTarChes = new javax.swing.JLabel();
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
        jSeparatorBuscarDetalleDeCaja = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetalleDeCaja = new javax.swing.JTable();
        jLabelTituloBuscarDetalleDeCaja = new javax.swing.JLabel();
        jTextFieldBuscarDetalleDeCaja = new javax.swing.JTextField();
        jButtonTraerPanelCuerpo = new javax.swing.JButton();
        jLabelFondoVentanaBuscar = new javax.swing.JLabel();
        jPanelCuerpo = new javax.swing.JPanel();
        jPanelListaTipoPago = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListTipoPago = new javax.swing.JList<>();
        jButtonRegTipoPago = new javax.swing.JButton();
        jTextFieldSubTotal = new javax.swing.JTextField();
        jSeparatorSubTotal = new javax.swing.JSeparator();
        jLabelTituloSubTotal = new javax.swing.JLabel();
        jLabelTituloIuTipoPago = new javax.swing.JLabel();
        jTextFieldIuTipoPago = new javax.swing.JTextField();
        jSeparatorIuTipoPago = new javax.swing.JSeparator();
        jSeparatorIuCaja = new javax.swing.JSeparator();
        jLabelTituloIuCaja = new javax.swing.JLabel();
        jTextFieldIuCaja = new javax.swing.JTextField();
        jSeparatorIuDetalleCaja = new javax.swing.JSeparator();
        jLabelTituloIuDetalleCaja = new javax.swing.JLabel();
        jTextFieldIuDetalleCaja = new javax.swing.JTextField();
        jButtonAgregarDetalleCaja = new javax.swing.JButton();
        jButtonEditarDetalleCaja = new javax.swing.JButton();
        jButtonBorrarDetalleCaja = new javax.swing.JButton();
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

        jPanelMensajeTarChes.setMaximumSize(new java.awt.Dimension(400, 100));
        jPanelMensajeTarChes.setMinimumSize(new java.awt.Dimension(400, 100));
        jPanelMensajeTarChes.setOpaque(false);
        jPanelMensajeTarChes.setPreferredSize(new java.awt.Dimension(400, 100));
        jPanelMensajeTarChes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMensajeTarChes.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeTarChes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeTarChes.setText("podra cargar los datos desde aqui. ");
        jPanelMensajeTarChes.add(jLabelMensajeTarChes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 320, 25));

        jLabelMensajeTarChes1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeTarChes1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeTarChes1.setText("Si el pago no fue en efectivo,");
        jPanelMensajeTarChes.add(jLabelMensajeTarChes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 320, 25));

        jButtonRegTarjetas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonFondo100x25TarjetasOff.png"))); // NOI18N
        jButtonRegTarjetas.setToolTipText("Has click para ir a Tarjetas.");
        jButtonRegTarjetas.setBorder(null);
        jButtonRegTarjetas.setBorderPainted(false);
        jButtonRegTarjetas.setContentAreaFilled(false);
        jButtonRegTarjetas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRegTarjetas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonFondo100x25TarjetasOn.png"))); // NOI18N
        jButtonRegTarjetas.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonFondo100x25TarjetasOff.png"))); // NOI18N
        jButtonRegTarjetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegTarjetasActionPerformed(evt);
            }
        });
        jPanelMensajeTarChes.add(jButtonRegTarjetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 65, -1, -1));

        jButtonRegCheques.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonFondo100x25ChequesOff.png"))); // NOI18N
        jButtonRegCheques.setToolTipText("Has click para continuar.");
        jButtonRegCheques.setBorder(null);
        jButtonRegCheques.setBorderPainted(false);
        jButtonRegCheques.setContentAreaFilled(false);
        jButtonRegCheques.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRegCheques.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonFondo100x25ChequesOn.png"))); // NOI18N
        jButtonRegCheques.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonFondo100x25ChequesOff.png"))); // NOI18N
        jButtonRegCheques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegChequesActionPerformed(evt);
            }
        });
        jPanelMensajeTarChes.add(jButtonRegCheques, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 65, -1, -1));

        jButtonCancelarRegistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOff.png"))); // NOI18N
        jButtonCancelarRegistros.setToolTipText("Has click para continuar.");
        jButtonCancelarRegistros.setBorder(null);
        jButtonCancelarRegistros.setBorderPainted(false);
        jButtonCancelarRegistros.setContentAreaFilled(false);
        jButtonCancelarRegistros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelarRegistros.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOn.png"))); // NOI18N
        jButtonCancelarRegistros.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOff.png"))); // NOI18N
        jButtonCancelarRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarRegistrosActionPerformed(evt);
            }
        });
        jPanelMensajeTarChes.add(jButtonCancelarRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 65, -1, -1));

        jLabelIconoTarChes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelMensajeTarChes.add(jLabelIconoTarChes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelFondoIconoTarChes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo400x100SinLogo.png"))); // NOI18N
        jPanelMensajeTarChes.add(jLabelFondoIconoTarChes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 100));

        getContentPane().add(jPanelMensajeTarChes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-400, 115, 400, 100));

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

        jSeparatorBuscarDetalleDeCaja.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorBuscarDetalleDeCaja.setForeground(new java.awt.Color(0, 0, 0));
        jPanelVentanaBuscar.add(jSeparatorBuscarDetalleDeCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 55, 100, 2));

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(480, 146));

        jTableDetalleDeCaja = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jTableDetalleDeCaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nº caja", "Nº detalle", "Pago", "Subtotal"
            }
        ));
        jTableDetalleDeCaja.setToolTipText("Has click derecho para opciones.");
        jTableDetalleDeCaja.setAutoscrolls(false);
        jTableDetalleDeCaja.setFocusable(false);
        jTableDetalleDeCaja.setMaximumSize(new java.awt.Dimension(480, 250));
        jTableDetalleDeCaja.setMinimumSize(new java.awt.Dimension(480, 250));
        jTableDetalleDeCaja.setPreferredSize(new java.awt.Dimension(480, 250));
        jTableDetalleDeCaja.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jTableDetalleDeCaja.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jTableDetalleDeCaja.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableDetalleDeCaja);

        jPanelVentanaBuscar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 480, 221));

        jLabelTituloBuscarDetalleDeCaja.setText("Parametro de busqueda:");
        jPanelVentanaBuscar.add(jLabelTituloBuscarDetalleDeCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 10, -1, 25));

        jTextFieldBuscarDetalleDeCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBuscarDetalleDeCaja.setToolTipText("ingresa parametros de busqueda. Ej: chev");
        jTextFieldBuscarDetalleDeCaja.setBorder(null);
        jTextFieldBuscarDetalleDeCaja.setDisabledTextColor(new java.awt.Color(194, 4, 48));
        jTextFieldBuscarDetalleDeCaja.setOpaque(false);
        jTextFieldBuscarDetalleDeCaja.setSelectionColor(new java.awt.Color(73, 73, 73));
        jTextFieldBuscarDetalleDeCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarDetalleDeCajaKeyReleased(evt);
            }
        });
        jPanelVentanaBuscar.add(jTextFieldBuscarDetalleDeCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 35, 100, 20));

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

        jPanelListaTipoPago.setMinimumSize(new java.awt.Dimension(200, 45));
        jPanelListaTipoPago.setOpaque(false);
        jPanelListaTipoPago.setPreferredSize(new java.awt.Dimension(200, 45));
        jPanelListaTipoPago.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 45));

        jListTipoPago.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jListTipoPago.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jListTipoPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListTipoPagoFocusGained(evt);
            }
        });
        jListTipoPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListTipoPagoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListTipoPago);

        jPanelListaTipoPago.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 45));

        jPanelCuerpo.add(jPanelListaTipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 138, 200, 45));

        jButtonRegTipoPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x25Off.png"))); // NOI18N
        jButtonRegTipoPago.setBorder(null);
        jButtonRegTipoPago.setBorderPainted(false);
        jButtonRegTipoPago.setContentAreaFilled(false);
        jButtonRegTipoPago.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegTipoPago.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegTipoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegTipoPagoActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonRegTipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 113, -1, -1));

        jTextFieldSubTotal.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldSubTotal.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldSubTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSubTotal.setToolTipText("Ingrese solo decimales. Ej.: 20.08");
        jTextFieldSubTotal.setBorder(null);
        jTextFieldSubTotal.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldSubTotal.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldSubTotal.setOpaque(false);
        jTextFieldSubTotal.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldSubTotal.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 196, 100, 20));

        jSeparatorSubTotal.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorSubTotal.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorSubTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorSubTotal.setOpaque(true);
        jPanelCuerpo.add(jSeparatorSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 216, 100, -1));

        jLabelTituloSubTotal.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloSubTotal.setText("Subtotal:");
        jLabelTituloSubTotal.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 176, -1, 25));

        jLabelTituloIuTipoPago.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuTipoPago.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuTipoPago.setText("Tipo de pago: ");
        jLabelTituloIuTipoPago.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloIuTipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 98, -1, 25));

        jTextFieldIuTipoPago.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuTipoPago.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuTipoPago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuTipoPago.setToolTipText("Ingrese solo texto. Ej.: cheque.");
        jTextFieldIuTipoPago.setBorder(null);
        jTextFieldIuTipoPago.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuTipoPago.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuTipoPago.setOpaque(false);
        jTextFieldIuTipoPago.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuTipoPago.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldIuTipoPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIuTipoPagoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldIuTipoPagoFocusLost(evt);
            }
        });
        jTextFieldIuTipoPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldIuTipoPagoKeyReleased(evt);
            }
        });
        jPanelCuerpo.add(jTextFieldIuTipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 118, 200, 20));

        jSeparatorIuTipoPago.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuTipoPago.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuTipoPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuTipoPago.setOpaque(true);
        jPanelCuerpo.add(jSeparatorIuTipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 138, 200, -1));

        jSeparatorIuCaja.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuCaja.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuCaja.setOpaque(true);
        jPanelCuerpo.add(jSeparatorIuCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 66, 100, -1));

        jLabelTituloIuCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuCaja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuCaja.setText("Nº de caja:");
        jLabelTituloIuCaja.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloIuCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 25, -1, 25));

        jTextFieldIuCaja.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuCaja.setText("AUTOMATICO");
        jTextFieldIuCaja.setToolTipText("");
        jTextFieldIuCaja.setBorder(null);
        jTextFieldIuCaja.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuCaja.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuCaja.setOpaque(false);
        jTextFieldIuCaja.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuCaja.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldIuCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 45, 100, 20));

        jSeparatorIuDetalleCaja.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuDetalleCaja.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuDetalleCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuDetalleCaja.setOpaque(true);
        jPanelCuerpo.add(jSeparatorIuDetalleCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 66, 100, -1));

        jLabelTituloIuDetalleCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuDetalleCaja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuDetalleCaja.setText("Nª de detalle:");
        jLabelTituloIuDetalleCaja.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloIuDetalleCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 25, -1, 25));

        jTextFieldIuDetalleCaja.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuDetalleCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuDetalleCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuDetalleCaja.setText("AUTOMATICO");
        jTextFieldIuDetalleCaja.setToolTipText("");
        jTextFieldIuDetalleCaja.setBorder(null);
        jTextFieldIuDetalleCaja.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuDetalleCaja.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuDetalleCaja.setOpaque(false);
        jTextFieldIuDetalleCaja.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuDetalleCaja.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldIuDetalleCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 45, 100, 20));

        jButtonAgregarDetalleCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOff.png"))); // NOI18N
        jButtonAgregarDetalleCaja.setToolTipText("Has click para agregar.");
        jButtonAgregarDetalleCaja.setBorder(null);
        jButtonAgregarDetalleCaja.setBorderPainted(false);
        jButtonAgregarDetalleCaja.setContentAreaFilled(false);
        jButtonAgregarDetalleCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregarDetalleCaja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarDetalleCaja.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarDetalleCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarDetalleCajaActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonAgregarDetalleCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 251, -1, -1));

        jButtonEditarDetalleCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOff.png"))); // NOI18N
        jButtonEditarDetalleCaja.setToolTipText("Has click para editar.");
        jButtonEditarDetalleCaja.setBorder(null);
        jButtonEditarDetalleCaja.setBorderPainted(false);
        jButtonEditarDetalleCaja.setContentAreaFilled(false);
        jButtonEditarDetalleCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditarDetalleCaja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarDetalleCaja.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarDetalleCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarDetalleCajaActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonEditarDetalleCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 251, -1, -1));

        jButtonBorrarDetalleCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOff.png"))); // NOI18N
        jButtonBorrarDetalleCaja.setToolTipText("Has click para borrar.");
        jButtonBorrarDetalleCaja.setBorder(null);
        jButtonBorrarDetalleCaja.setBorderPainted(false);
        jButtonBorrarDetalleCaja.setContentAreaFilled(false);
        jButtonBorrarDetalleCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBorrarDetalleCaja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarDetalleCaja.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarDetalleCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarDetalleCajaActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonBorrarDetalleCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 251, -1, -1));

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
        jLabelTituloVentana.setText("Registro de detalle de caja");
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
    public void crearObjDetallesCaja(){
     
        _objDetallesCaja = new DetallesDeCaja();
        _objDetallesCaja.setIuCaja(Integer.parseInt(jTextFieldIuCaja.getText()));
        _objDetallesCaja.setIuDetalleCaja(Integer.parseInt(jTextFieldIuDetalleCaja.getText()));
        _objDetallesCaja.setIuTipoPago(Integer.parseInt(_administradorTipoPagos.obtenerIuTipoPago(jTextFieldIuTipoPago.getText())));
        _objDetallesCaja.setSubTotal(Double.parseDouble(jTextFieldSubTotal.getText()));
    }

// valida codModeloVeh en caso de no hacer cick en a lista
    public void validarTipoPago(){
        if(_administradorTipoPagos.obtenerIuTipoPago(jTextFieldIuTipoPago.getText()).length()==0){
            auxSeleccionList = 0;
        } else{
            auxSeleccionList = 1;
        }
    }
    
// limpia los jtextfield usados
    public void limpiarCampos(){
        jTextFieldIuDetalleCaja.setText("AUTOMATICO");
        jTextFieldIuTipoPago.setText(""); 
        jTextFieldSubTotal.setText("");
        }
     
// este metodo crea menu de opciones al usar click secundario   
    public final void popupMenuJTable(){
//se crean las opciones del menu
        JPopupMenu jPopupMenuTableHDC = new JPopupMenu();
        JMenuItem jMenuItemEliminarDetalleCaja = new JMenuItem("Eliminar"); // cambiar x ico 
        JMenuItem jMenuItemModificarDetalleCaja = new JMenuItem("Modificar");
        JMenuItem jMenuOrdenar = new JMenu("Ordenar por");
        JMenuItem jMenuItemPrimerosAgregados = new JMenuItem("Primeros agregados");
        JMenuItem jMenuItemUltimosAgregados= new JMenuItem("Ultimos agregados");
        jMenuOrdenar.add(jMenuItemPrimerosAgregados);
        jMenuOrdenar.add(jMenuItemUltimosAgregados); 
// se generan las acciones de cada opcion
        jMenuItemEliminarDetalleCaja.addActionListener((ActionEvent e) -> {
        
        if(seleccionarItemJTabla()!= -1){
                 
            jPanelVentanaBuscar.setBounds(-500, 30, 500, 301);
            jPanelCuerpo.setBounds( 100,30,  500, 301);
              
            jButtonAgregarDetalleCaja.setEnabled(false);
            jButtonEditarDetalleCaja.setEnabled(false);
            jTextFieldIuCaja.setEditable(false);
            jTextFieldIuDetalleCaja.setEditable(false);
            jTextFieldIuTipoPago.setEditable(false); 
            jTextFieldSubTotal.setEditable(false);
            jButtonRegTipoPago.setEnabled(false);
            jListTipoPago.setVisible(false);
       
            jButtonBorrarDetalleCaja.setEnabled(true);
             }
         });
         
        jMenuItemModificarDetalleCaja.addActionListener((ActionEvent e) -> {
            
        if(seleccionarItemJTabla()!= -1){
                     
            jPanelVentanaBuscar.setBounds(-500, 30, 500, 301);
            jPanelCuerpo.setBounds( 100,30,  500, 301);
                
            jButtonAgregarDetalleCaja.setEnabled(false);
            jButtonBorrarDetalleCaja.setEnabled(false);
            jTextFieldIuCaja.setEditable(false); 
            jTextFieldIuDetalleCaja.setEditable(false);   
            jButtonEditarDetalleCaja.setEnabled(true);
            jTextFieldIuTipoPago.setEditable(false); 
            jTextFieldSubTotal.setEditable(true);
            jButtonRegTipoPago.setEnabled(true);
            jListTipoPago.setVisible(true);
        }
        });
             
        jMenuItemUltimosAgregados.addActionListener((ActionEvent e) -> {
            _administradorDetallesCaja.ordenarTabla(jMenuItemUltimosAgregados.getText());
            jTableDetalleDeCaja.setModel( _administradorDetallesCaja.cargarJTabla(jTextFieldIuCaja.getText()));
        });        
                                
        jMenuItemPrimerosAgregados.addActionListener((ActionEvent e) -> {
            _administradorDetallesCaja.ordenarTabla(jMenuItemPrimerosAgregados.getText());
            jTableDetalleDeCaja.setModel( _administradorDetallesCaja.cargarJTabla(jTextFieldIuCaja.getText()));
        });
// se construye el menu completo y se le asigna si jTable
        jPopupMenuTableHDC.add(jMenuItemEliminarDetalleCaja);
        jPopupMenuTableHDC.add(jMenuItemModificarDetalleCaja);
        jPopupMenuTableHDC.add(jMenuOrdenar);
        jTableDetalleDeCaja.setComponentPopupMenu(jPopupMenuTableHDC);  
     }
 
// se obtiene los datos del item seleccionado en la tabla
    public int seleccionarItemJTabla(){
// se obtiene el modelo y se verifica que se haya seleccionado un item   
        modeloTablaDC = jTableDetalleDeCaja.getModel();
        int auxSeleccion = jTableDetalleDeCaja.getSelectedRow();
        if (auxSeleccion != -1) {
            jTableDetalleDeCaja.setEnabled(true);
// se cargan los campos con los valores selcionados
            jTextFieldIuCaja.setText((String)modeloTablaDC.getValueAt(jTableDetalleDeCaja.getSelectedRow(), 0));
             jTextFieldIuDetalleCaja.setText((String)modeloTablaDC.getValueAt(jTableDetalleDeCaja.getSelectedRow(),1 ));
            jTextFieldIuTipoPago.setText((String)modeloTablaDC.getValueAt(jTableDetalleDeCaja.getSelectedRow(), 2));
            jTextFieldSubTotal.setText((String)modeloTablaDC.getValueAt(jTableDetalleDeCaja.getSelectedRow(),3));
            return auxSeleccion;
            
        }else {
// si no selecciona mensaje error   
            jTableDetalleDeCaja.setEnabled(false);
            jPanelItemNoSeleccionado.setBounds(225, 115, 250,100);
            return auxSeleccion;
        }
    }
    
//visualiza el panel buscar
    private void jButtonTraerPanelBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelBuscarActionPerformed
// llama al panel buscar 
    try {
        jTableDetalleDeCaja.setModel(_administradorDetallesCaja.cargarJTabla(jTextFieldIuCaja.getText()));
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
        jPanelMensajeTarChes.setBounds(-410, 115, 400, 100);

        
        JFramePrincipal obj = new JFramePrincipal();
        obj.apagar();
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
    private void jButtonAgregarDetalleCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarDetalleCajaActionPerformed
       
        jPanelMensajeValidarABM.setBounds(225, 115, 250, 100);
        auxAbm = 1;
        jButtonAgregarDetalleCaja.setEnabled(false);
        jButtonEditarDetalleCaja.setEnabled(false);
        jButtonBorrarDetalleCaja.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldIuDetalleCaja.setEditable(false);
        jTextFieldIuCaja.setEditable(false);
        jTextFieldIuTipoPago.setEditable(false);
        jTextFieldSubTotal.setEditable(false);
        jButtonRegTipoPago.setEnabled(false);
        jListTipoPago.setVisible(false);
    }//GEN-LAST:event_jButtonAgregarDetalleCajaActionPerformed

//valida datos y edita un registro en tabla TipoPagos
    private void jButtonEditarDetalleCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarDetalleCajaActionPerformed
        
        jPanelMensajeValidarABM.setBounds(225, 115, 250, 100);
        auxAbm = 2;
        jButtonAgregarDetalleCaja.setEnabled(false);
        jButtonEditarDetalleCaja.setEnabled(false);
        jButtonBorrarDetalleCaja.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldIuDetalleCaja.setEditable(false);
        jTextFieldIuCaja.setEditable(false);
        jTextFieldIuTipoPago.setEditable(false);
        jTextFieldSubTotal.setEditable(false);
        jButtonRegTipoPago.setEnabled(false);
        jListTipoPago.setVisible(false);
    }//GEN-LAST:event_jButtonEditarDetalleCajaActionPerformed

//valida datos y borra un registro en tabla TipoPagos 
    private void jButtonBorrarDetalleCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarDetalleCajaActionPerformed
        
        jPanelMensajeValidarABM.setBounds(225, 115, 250, 100);
        auxAbm = 3;
        jButtonAgregarDetalleCaja.setEnabled(false);
        jButtonEditarDetalleCaja.setEnabled(false);
        jButtonBorrarDetalleCaja.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldIuDetalleCaja.setEditable(false);
        jTextFieldIuCaja.setEditable(false);
        jTextFieldIuTipoPago.setEditable(false);
        jTextFieldSubTotal.setEditable(false);
        jButtonRegTipoPago.setEnabled(false);
        jListTipoPago.setVisible(false);
    }//GEN-LAST:event_jButtonBorrarDetalleCajaActionPerformed

// con cada tecleo valida los datos y elimina los no correctos
    private void jTextFieldBuscarDetalleDeCajaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarDetalleDeCajaKeyReleased
        boolean auxValidar = Administrador.validarCharDinamico(evt.getKeyChar(), "[a-zA-Z_0-9]||[\\s]");
    try {
        
        if(auxValidar==false){
               
            evt.consume();
            jTableDetalleDeCaja.setModel(_administradorDetallesCaja.buscarEnTabla(jTextFieldBuscarDetalleDeCaja.getText(), jTextFieldIuCaja.getText()));
        } else{
           
            jTableDetalleDeCaja.setModel(_administradorDetallesCaja.buscarEnTabla(jTextFieldBuscarDetalleDeCaja.getText(), jTextFieldIuCaja.getText()));
           }
    } catch (Exception e) {
        
        jPanelErrorBaseDeDatos.setBounds(225, 115, 250, 100);  
    }      
    }//GEN-LAST:event_jTextFieldBuscarDetalleDeCajaKeyReleased

//esconde el panel y habilita los obj en pantalla
    private void jButtonCancelarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarValidarCambiosActionPerformed
        
        auxAbm = 0;
        limpiarCampos();
        jPanelMensajeValidarABM.setBounds(-260, 115, 250, 100);
        jButtonAgregarDetalleCaja.setEnabled(true);
        jButtonEditarDetalleCaja.setEnabled(false);
        jButtonBorrarDetalleCaja.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldIuTipoPago.setEditable(true);
        jTextFieldSubTotal.setEditable(true);
        jTextFieldIuDetalleCaja.setEditable(true);
        jTextFieldIuCaja.setEditable(true);
        jTextFieldIuTipoPago.setBorder(null);
        jTextFieldSubTotal.setBorder(null);
        jButtonRegTipoPago.setEnabled(true);
        jListTipoPago.setVisible(true);
    }//GEN-LAST:event_jButtonCancelarValidarCambiosActionPerformed

    private void jButtonAceptarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarValidarCambiosActionPerformed
        String aux;
        boolean auxValidar;
// llama al panel y segun desde donde llamo ejecuta la accion        
        jPanelMensajeValidarABM.setBounds(-260, 115, 250, 100);     
        switch(auxAbm){
            
            case 1:
// se validan los datos
                aux = jTextFieldSubTotal.getText();
                auxValidar = Administrador.validarCamposDoubles(aux);
                validarTipoPago();
// si es correcto se crea el objeto de la clase usada
                if( auxValidar==true && auxSeleccionList==1){

                    jTextFieldIuTipoPago.setBorder(new LineBorder(Color.green));
                    jTextFieldSubTotal.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = 0;
                    _objDetallesCaja = new DetallesDeCaja();
                    _objDetallesCaja.setIuCaja(Integer.parseInt(jTextFieldIuCaja.getText()));   
                    _objDetallesCaja.setIuTipoPago(Integer.parseInt(_administradorTipoPagos.obtenerIuTipoPago(jTextFieldIuTipoPago.getText())));
                    _objDetallesCaja.setSubTotal(Double.parseDouble(jTextFieldSubTotal.getText()));
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorDetallesCaja.insertarTablaDetalleCaja(_objDetallesCaja)==true){
               
                            jPanelGuardadoExitoso.setBounds(225, 115, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(225, 115, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(225, 115, 250, 100);
    }
// en caso de no ser validos los datos se avisa al usuario
                } else if( auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldSubTotal.setBorder(new LineBorder(Color.green));
                    jTextFieldIuTipoPago.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if( auxValidar==false && auxSeleccionList==1){
                    jTextFieldSubTotal.setBorder(new LineBorder(Color.red));
                    jTextFieldIuTipoPago.setBorder(new LineBorder(Color.green));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if( auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldSubTotal.setBorder(new LineBorder(Color.red));
                    jTextFieldIuTipoPago.setBorder(new LineBorder(Color.red));
                    if(_administradorTipoPagos.obtenerIuTipoPago(jTextFieldIuTipoPago.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                }
            break;
// se repite el mismo codigo solo que se edita un item de la db 
            case 2:
// se validan los datos
// se validan los datos
                aux = jTextFieldSubTotal.getText();
                auxValidar = Administrador.validarCamposDoubles(aux);
                validarTipoPago();
// si es correcto se crea el objeto de la clase usada
                if( auxValidar==true && auxSeleccionList==1){

                    jTextFieldIuTipoPago.setBorder(new LineBorder(Color.green));
                    jTextFieldSubTotal.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = 0;
                    crearObjDetallesCaja();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorDetallesCaja.actualizarTablaDetalleCaja(_objDetallesCaja)==true){
               
                            jPanelGuardadoExitoso.setBounds(225, 115, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(225, 115, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(225, 115, 250, 100);
    }
// en caso de no ser validos los datos se avisa al usuario
                } else if( auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldSubTotal.setBorder(new LineBorder(Color.green));
                    jTextFieldIuTipoPago.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if( auxValidar==false && auxSeleccionList==1){
                    jTextFieldSubTotal.setBorder(new LineBorder(Color.red));
                    jTextFieldIuTipoPago.setBorder(new LineBorder(Color.green));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if( auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldSubTotal.setBorder(new LineBorder(Color.red));
                    jTextFieldIuTipoPago.setBorder(new LineBorder(Color.red));
                    if(_administradorTipoPagos.obtenerIuTipoPago(jTextFieldIuTipoPago.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                }
            break;
// se repite el mismo codigo solo que se borra un item de la db         
            case 3:
// se validan los datos
                aux = jTextFieldSubTotal.getText();
                auxValidar = Administrador.validarCamposDoubles(aux);
                validarTipoPago();
// si es correcto se crea el objeto de la clase usada
                if( auxValidar==true && auxSeleccionList==1){

                    jTextFieldIuTipoPago.setBorder(new LineBorder(Color.green));
                    jTextFieldSubTotal.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = 0;
                    crearObjDetallesCaja();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorDetallesCaja.eliminarTablaDetalleCaja(_objDetallesCaja)==true){
               
                            jPanelGuardadoExitoso.setBounds(225, 115, 250, 100);
                    
                    } else{

                            jPanelElementoExistente.setBounds(225, 115, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(225, 115, 250, 100);
    }
// en caso de no ser validos los datos se avisa al usuario
                } else if( auxValidar==true && auxSeleccionList==0){
                    
                    jTextFieldSubTotal.setBorder(new LineBorder(Color.green));
                    jTextFieldIuTipoPago.setBorder(new LineBorder(Color.red));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if( auxValidar==false && auxSeleccionList==1){
                    jTextFieldSubTotal.setBorder(new LineBorder(Color.red));
                    jTextFieldIuTipoPago.setBorder(new LineBorder(Color.green));
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    
                } else if( auxValidar==false && auxSeleccionList==0){
                    
                    jTextFieldSubTotal.setBorder(new LineBorder(Color.red));
                    jTextFieldIuTipoPago.setBorder(new LineBorder(Color.red));
                    if(_administradorTipoPagos.obtenerIuTipoPago(jTextFieldIuTipoPago.getText()).length()==0){
                        
                        jPanelElementoNoExistente.setBounds(225, 115, 250, 100);
                    } else {
                        
                    jPanelGuardadoErroneo.setBounds(225, 115, 250, 100); 
                    }
                }
            break;  
        }
    }//GEN-LAST:event_jButtonAceptarValidarCambiosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones, se limpia los campos
    private void jButtonAceptarGuardadoExitosoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoExitosoActionPerformed

        
        jPanelGuardadoExitoso.setBounds(-260, 115, 250, 100);
        jTextFieldIuTipoPago.setBorder(null);
        jTextFieldSubTotal.setBorder(null);
        limpiarCampos();
        jButtonAgregarDetalleCaja.setEnabled(true);
        jButtonEditarDetalleCaja.setEnabled(false);
        jButtonBorrarDetalleCaja.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldIuTipoPago.setEditable(true);
        jTextFieldSubTotal.setEditable(true);
        jButtonRegTipoPago.setEnabled(true);
        jListTipoPago.setVisible(true);
        switch(auxAbm){
            
            case 1:
                jPanelMensajeTarChes.setBounds(150, 115, 400, 100);
            break;
            
            case 2:
                jPanelMensajeTarChes.setBounds(150, 115, 400, 100);
            break;
            
            case 3:
            break;
        
        
        }
    }//GEN-LAST:event_jButtonAceptarGuardadoExitosoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarGuardadoErroneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoErroneoActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelGuardadoErroneo.setBounds(-260, 115, 250, 100);
                jButtonAgregarDetalleCaja.setEnabled(true);
                jButtonEditarDetalleCaja.setEnabled(false);
                jButtonBorrarDetalleCaja.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuTipoPago.setEditable(true);
                jTextFieldSubTotal.setEditable(true);
                jButtonRegTipoPago.setEnabled(true);
                jListTipoPago.setVisible(true);
            break;
            
            case 2:
                jPanelGuardadoErroneo.setBounds(-260, 115, 250, 100);
                jButtonAgregarDetalleCaja.setEnabled(false);
                jButtonEditarDetalleCaja.setEnabled(true);
                jButtonBorrarDetalleCaja.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuTipoPago.setEditable(true);
                jTextFieldSubTotal.setEditable(true);
                jButtonRegTipoPago.setEnabled(true);
                jListTipoPago.setVisible(true);
            break;
            
            case 3: 
                jPanelGuardadoErroneo.setBounds(-260, 115, 250, 100);
                jButtonAgregarDetalleCaja.setEnabled(false);
                jButtonEditarDetalleCaja.setEnabled(false);
                jButtonBorrarDetalleCaja.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuTipoPago.setEditable(false);
                jTextFieldSubTotal.setEditable(false);
                jButtonRegTipoPago.setEnabled(false);
                jListTipoPago.setVisible(false);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarGuardadoErroneoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarErrorBaseDeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarErrorBaseDeDatosActionPerformed
        
        jPanelErrorBaseDeDatos.setBounds(-260, 115, 250, 100);
        jButtonAgregarDetalleCaja.setEnabled(true);
        jButtonEditarDetalleCaja.setEnabled(false);
        jButtonBorrarDetalleCaja.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldIuTipoPago.setEditable(true);
        jTextFieldSubTotal.setEditable(true);
        jTextFieldIuDetalleCaja.setEditable(true);
        jListTipoPago.setVisible(true);
        jButtonRegTipoPago.setEnabled(true);
    }//GEN-LAST:event_jButtonAceptarErrorBaseDeDatosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarElementoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoExistenteActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelElementoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarDetalleCaja.setEnabled(true);
                jButtonEditarDetalleCaja.setEnabled(false);
                jButtonBorrarDetalleCaja.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuTipoPago.setEditable(true);
                jTextFieldSubTotal.setEditable(true);
                jButtonRegTipoPago.setEnabled(true);
                jListTipoPago.setVisible(true);
            break;
            
            case 2:
                jPanelElementoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarDetalleCaja.setEnabled(false);
                jButtonEditarDetalleCaja.setEnabled(true);
                jButtonBorrarDetalleCaja.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuTipoPago.setEditable(true);
                jTextFieldSubTotal.setEditable(true);
                jButtonRegTipoPago.setEnabled(true);
                jListTipoPago.setVisible(true);
            break;
            
            case 3: 
                jPanelElementoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarDetalleCaja.setEnabled(false);
                jButtonEditarDetalleCaja.setEnabled(false);
                jButtonBorrarDetalleCaja.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuTipoPago.setEditable(false);
                jTextFieldSubTotal.setEditable(false);
                jButtonRegTipoPago.setEnabled(false);
                jListTipoPago.setVisible(false);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarElementoExistenteActionPerformed

// se acomoda los objetos del frame para continuar trabajando. 
    private void jButtonAceptarItemNoSeleccionado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

        jTableDetalleDeCaja.setEnabled(true);
        jPanelItemNoSeleccionado.setBounds(-260, 115, 250, 100); 
    }//GEN-LAST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

    private void jTextFieldIuTipoPagoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuTipoPagoFocusGained

        jListTipoPago.setModel(_administradorTipoPagos.cargarLista(_administradorTipoPagos.obtenerIuTipoPago( jTextFieldIuTipoPago.getText())));
        jPanelListaTipoPago.setBounds(150,138, 200, 50);
    }//GEN-LAST:event_jTextFieldIuTipoPagoFocusGained

    private void jTextFieldIuTipoPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIuTipoPagoKeyReleased

        jListTipoPago.setModel(_administradorTipoPagos.cargarLista(_administradorTipoPagos.obtenerIuTipoPago( jTextFieldIuTipoPago.getText())));
        jPanelListaTipoPago.setBounds(150,138, 200, 50);
    }//GEN-LAST:event_jTextFieldIuTipoPagoKeyReleased

    private void jButtonRegTipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegTipoPagoActionPerformed
        JFrameRegistroTipoPagos obj = new JFrameRegistroTipoPagos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegTipoPagoActionPerformed

    private void jListTipoPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTipoPagoMouseClicked
        int indexList = jListTipoPago.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList = 1;
            jTextFieldIuTipoPago.setText("");
            jTextFieldIuTipoPago.setText(jListTipoPago.getSelectedValue());
            jPanelListaTipoPago.setBounds(-300, 138, 200, 50);
        } else{
            auxSeleccionList = 0;
        }
        
    }//GEN-LAST:event_jListTipoPagoMouseClicked

    private void jTextFieldIuTipoPagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuTipoPagoFocusLost

        jPanelListaTipoPago.setBounds(-300,138, 200, 50);
    }//GEN-LAST:event_jTextFieldIuTipoPagoFocusLost

    private void jListTipoPagoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListTipoPagoFocusGained

        jPanelListaTipoPago.setBounds(150,138, 200, 50); 
    }//GEN-LAST:event_jListTipoPagoFocusGained

    private void jButtonAceptarElementoNoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoNoExistenteActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelElementoNoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarDetalleCaja.setEnabled(true);
                jButtonEditarDetalleCaja.setEnabled(false);
                jButtonBorrarDetalleCaja.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuTipoPago.setEditable(true);
                jTextFieldSubTotal.setEditable(true);
                jButtonRegTipoPago.setEnabled(true);
                jListTipoPago.setVisible(true);
            break;
            
            case 2:
                jPanelElementoNoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarDetalleCaja.setEnabled(false);
                jButtonEditarDetalleCaja.setEnabled(true);
                jButtonBorrarDetalleCaja.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuTipoPago.setEditable(true);
                jTextFieldSubTotal.setEditable(true);
                jButtonRegTipoPago.setEnabled(true);
                jListTipoPago.setVisible(true);
            break;
            
            case 3: 
                jPanelElementoNoExistente.setBounds(-260, 115, 250, 100);
                jButtonAgregarDetalleCaja.setEnabled(false);
                jButtonEditarDetalleCaja.setEnabled(false);
                jButtonBorrarDetalleCaja.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuTipoPago.setEditable(false);
                jTextFieldSubTotal.setEditable(false);
                jButtonRegTipoPago.setEnabled(false);
                jListTipoPago.setVisible(false);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarElementoNoExistenteActionPerformed

    private void jButtonRegTarjetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegTarjetasActionPerformed
               
        jPanelMensajeTarChes.setBounds(-400, 115, 400, 100);
        JFrameRegistroTarjetas obj = new JFrameRegistroTarjetas();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegTarjetasActionPerformed

    private void jButtonRegChequesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegChequesActionPerformed
       
        jPanelMensajeTarChes.setBounds(-400, 115, 400, 100);
        JFrameRegistroCheques obj = new JFrameRegistroCheques();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_jButtonRegChequesActionPerformed

    private void jButtonCancelarRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarRegistrosActionPerformed
        jPanelMensajeTarChes.setBounds(-400, 115, 400, 100);
    }//GEN-LAST:event_jButtonCancelarRegistrosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAceptarElementoExistente;
    private javax.swing.JButton jButtonAceptarElementoNoExistente;
    private javax.swing.JButton jButtonAceptarErrorBaseDeDatos;
    private javax.swing.JButton jButtonAceptarGuardadoErroneo;
    private javax.swing.JButton jButtonAceptarGuardadoExitoso;
    private javax.swing.JButton jButtonAceptarItemNoSeleccionado2;
    private javax.swing.JButton jButtonAceptarValidarCambios;
    private javax.swing.JButton jButtonAgregarDetalleCaja;
    private javax.swing.JButton jButtonBorrarDetalleCaja;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelarRegistros;
    private javax.swing.JButton jButtonCancelarValidarCambios;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonEditarDetalleCaja;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JButton jButtonRegCheques;
    private javax.swing.JButton jButtonRegTarjetas;
    private javax.swing.JButton jButtonRegTipoPago;
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
    private javax.swing.JLabel jLabelFondoIconoTarChes;
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
    private javax.swing.JLabel jLabelIconoTarChes;
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
    private javax.swing.JLabel jLabelMensajeTarChes;
    private javax.swing.JLabel jLabelMensajeTarChes1;
    private javax.swing.JLabel jLabelMensajeUno;
    private javax.swing.JLabel jLabelMensajeValidarCambios;
    private javax.swing.JLabel jLabelMensajeValidarCambios1;
    private javax.swing.JLabel jLabelTituloBuscarDetalleDeCaja;
    private javax.swing.JLabel jLabelTituloIuCaja;
    private javax.swing.JLabel jLabelTituloIuDetalleCaja;
    private javax.swing.JLabel jLabelTituloIuTipoPago;
    private javax.swing.JLabel jLabelTituloSubTotal;
    private javax.swing.JLabel jLabelTituloVentana;
    private javax.swing.JLabel jLabelToolKitMarca;
    private javax.swing.JList<String> jListTipoPago;
    private javax.swing.JPanel jPanelBarraTitulo;
    private javax.swing.JPanel jPanelCuerpo;
    private javax.swing.JPanel jPanelElementoExistente;
    private javax.swing.JPanel jPanelElementoNoExistente;
    private javax.swing.JPanel jPanelErrorBaseDeDatos;
    private javax.swing.JPanel jPanelGuardadoErroneo;
    private javax.swing.JPanel jPanelGuardadoExitoso;
    private javax.swing.JPanel jPanelItemNoSeleccionado;
    private javax.swing.JPanel jPanelListaTipoPago;
    private javax.swing.JPanel jPanelMensajeCerrar;
    private javax.swing.JPanel jPanelMensajeTarChes;
    private javax.swing.JPanel jPanelMensajeValidarABM;
    private javax.swing.JPanel jPanelVentanaBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparatorBuscarDetalleDeCaja;
    private javax.swing.JSeparator jSeparatorIuCaja;
    private javax.swing.JSeparator jSeparatorIuDetalleCaja;
    private javax.swing.JSeparator jSeparatorIuTipoPago;
    private javax.swing.JSeparator jSeparatorSubTotal;
    private javax.swing.JTable jTableDetalleDeCaja;
    private javax.swing.JTextField jTextFieldBuscarDetalleDeCaja;
    private javax.swing.JTextField jTextFieldIuCaja;
    private javax.swing.JTextField jTextFieldIuDetalleCaja;
    private javax.swing.JTextField jTextFieldIuTipoPago;
    private javax.swing.JTextField jTextFieldSubTotal;
    // End of variables declaration//GEN-END:variables
}
