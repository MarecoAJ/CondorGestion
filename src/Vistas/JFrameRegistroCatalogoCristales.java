/*
* este JFrame registra (agrega, borra, edita, busca y filtra) el catalogo de cristales
*/
package Vistas;

import administradorClases.Administrador;
import administradorClases.AdministradorCatalogoCristales;
import administradorClases.AdministradorMarcasCristales;
import administradorClases.AdministradorModeloVehiculo;
import clasesDatos.CatalogoCristales;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class JFrameRegistroCatalogoCristales extends javax.swing.JFrame {
// atributos y variables    
    private final AdministradorModeloVehiculo _administradorModeloVehiculo;
    private final AdministradorMarcasCristales _administradorMarcasCristales;
    private final AdministradorCatalogoCristales _administradorCatalogoCristales;
    private CatalogoCristales _objCatalogoCristales;
    private TableModel modeloTablaCC;
    private int auxAbm;
    private boolean auxSeleccionList;
    private boolean auxSeleccionList2;
    
    public JFrameRegistroCatalogoCristales() {
        initComponents();
// se personaliza las fuentes de letra de los objetos grafico
        jLabelTituloVentana.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 8));
        jLabelTituloCodigoCristal.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldCodigoCristal.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloDescrCristal.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldDescrCristal.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloBuscarCristal.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldBuscarCristal.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloCodModeloVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldCodModeloVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloIuMarcaCris.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldIuMarcaCris.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloCantidadMinima.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldCantidadMinima.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloCantidadExistencia.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldCantidadExistencia.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloPrecioPieza.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldPrecioPieza.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
                
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
        jTableCatalogoCristal.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 6));
        JTableHeader auxJTableHeader;
        auxJTableHeader = jTableCatalogoCristal.getTableHeader();
        auxJTableHeader.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
// se instancia la clase AdministradorTipoPagos y se inicializa el menu del jTable
        _administradorModeloVehiculo = new AdministradorModeloVehiculo();
        _administradorCatalogoCristales = new AdministradorCatalogoCristales();
        _administradorMarcasCristales = new AdministradorMarcasCristales();
        popupMenuJTable();
        
        jButtonEditarCatalogoCristal.setEnabled(false);
        jButtonBorrarCatalogoCristal.setEnabled(false);
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
        jSeparatorBuscarCristal = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCatalogoCristal = new javax.swing.JTable();
        jLabelTituloBuscarCristal = new javax.swing.JLabel();
        jTextFieldBuscarCristal = new javax.swing.JTextField();
        jButtonTraerPanelCuerpo = new javax.swing.JButton();
        jLabelFondoVentanaBuscar = new javax.swing.JLabel();
        jPanelCuerpo = new javax.swing.JPanel();
        jPanelListaMarcaCris = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListMarcaCris = new javax.swing.JList<>();
        jPanelListaModeloVeh = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListModeloVeh = new javax.swing.JList<>();
        jLabelTituloPrecioPieza = new javax.swing.JLabel();
        jSeparatorPrecioPieza = new javax.swing.JSeparator();
        jTextFieldPrecioPieza = new javax.swing.JTextField();
        jLabelTituloCantidadExistencia = new javax.swing.JLabel();
        jSeparatorCantidadExistencia = new javax.swing.JSeparator();
        jTextFieldCantidadExistencia = new javax.swing.JTextField();
        jLabelTituloCantidadMinima = new javax.swing.JLabel();
        jSeparatorCantidadMinima = new javax.swing.JSeparator();
        jTextFieldCantidadMinima = new javax.swing.JTextField();
        jLabelTituloIuMarcaCris = new javax.swing.JLabel();
        jSeparatorIuMarcaCris = new javax.swing.JSeparator();
        jTextFieldIuMarcaCris = new javax.swing.JTextField();
        jButtonRegMarcaCris = new javax.swing.JButton();
        jButtonRegModeloVeh = new javax.swing.JButton();
        jTextFieldCodModeloVeh = new javax.swing.JTextField();
        jSeparatorCodModeloVeh = new javax.swing.JSeparator();
        jLabelTituloCodModeloVeh = new javax.swing.JLabel();
        jLabelTituloDescrCristal = new javax.swing.JLabel();
        jTextFieldDescrCristal = new javax.swing.JTextField();
        jSeparatorDescrCristal = new javax.swing.JSeparator();
        jSeparatorCodigoCristal = new javax.swing.JSeparator();
        jLabelTituloCodigoCristal = new javax.swing.JLabel();
        jTextFieldCodigoCristal = new javax.swing.JTextField();
        jButtonAgregarCatalogoCristal = new javax.swing.JButton();
        jButtonEditarCatalogoCristal = new javax.swing.JButton();
        jButtonBorrarCatalogoCristal = new javax.swing.JButton();
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
        setMaximumSize(new java.awt.Dimension(900, 487));
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

        jSeparatorBuscarCristal.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorBuscarCristal.setForeground(new java.awt.Color(0, 0, 0));
        jPanelVentanaBuscar.add(jSeparatorBuscarCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 55, 100, 2));

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(480, 146));

        jTableCatalogoCristal = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jTableCatalogoCristal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod. crsital", "Descripcion", "Modelo", "Marca", "Cant. fija", "Cant. en stock", "Precio"
            }
        ));
        jTableCatalogoCristal.setToolTipText("Has click derecho para opciones.");
        jTableCatalogoCristal.setAutoscrolls(false);
        jTableCatalogoCristal.setFocusable(false);
        jTableCatalogoCristal.setMaximumSize(new java.awt.Dimension(480, 377));
        jTableCatalogoCristal.setMinimumSize(new java.awt.Dimension(480, 377));
        jTableCatalogoCristal.setPreferredSize(new java.awt.Dimension(480, 377));
        jTableCatalogoCristal.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jTableCatalogoCristal.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jTableCatalogoCristal.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableCatalogoCristal);

        jPanelVentanaBuscar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 680, 377));

        jLabelTituloBuscarCristal.setText("Parametro de busqueda:");
        jPanelVentanaBuscar.add(jLabelTituloBuscarCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 10, -1, 25));

        jTextFieldBuscarCristal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBuscarCristal.setToolTipText("ingresa parametros de busqueda. Ej:  parab");
        jTextFieldBuscarCristal.setBorder(null);
        jTextFieldBuscarCristal.setDisabledTextColor(new java.awt.Color(194, 4, 48));
        jTextFieldBuscarCristal.setOpaque(false);
        jTextFieldBuscarCristal.setSelectionColor(new java.awt.Color(73, 73, 73));
        jTextFieldBuscarCristal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarCristalKeyReleased(evt);
            }
        });
        jPanelVentanaBuscar.add(jTextFieldBuscarCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 35, 100, 20));

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

        jPanelListaMarcaCris.setOpaque(false);
        jPanelListaMarcaCris.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(200, 45));

        jListMarcaCris.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListMarcaCrisFocusGained(evt);
            }
        });
        jListMarcaCris.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListMarcaCrisMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListMarcaCris);

        jPanelListaMarcaCris.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 45));

        jPanelCuerpo.add(jPanelListaMarcaCris, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 216, 200, 45));

        jPanelListaModeloVeh.setMinimumSize(new java.awt.Dimension(200, 45));
        jPanelListaModeloVeh.setOpaque(false);
        jPanelListaModeloVeh.setPreferredSize(new java.awt.Dimension(200, 45));
        jPanelListaModeloVeh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 45));

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

        jPanelCuerpo.add(jPanelListaModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 216, 200, 45));

        jLabelTituloPrecioPieza.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloPrecioPieza.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloPrecioPieza.setText("Precio del cristal:");
        jLabelTituloPrecioPieza.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloPrecioPieza, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 332, -1, 25));

        jSeparatorPrecioPieza.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorPrecioPieza.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorPrecioPieza.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorPrecioPieza.setOpaque(true);
        jPanelCuerpo.add(jSeparatorPrecioPieza, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 372, 100, -1));

        jTextFieldPrecioPieza.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldPrecioPieza.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldPrecioPieza.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPrecioPieza.setToolTipText("Ingrese solo numeros decimales. Ej.: 34.00");
        jTextFieldPrecioPieza.setBorder(null);
        jTextFieldPrecioPieza.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldPrecioPieza.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldPrecioPieza.setOpaque(false);
        jTextFieldPrecioPieza.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldPrecioPieza.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldPrecioPieza, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 352, 100, 20));

        jLabelTituloCantidadExistencia.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloCantidadExistencia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloCantidadExistencia.setText("Cantidad en stock:");
        jLabelTituloCantidadExistencia.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloCantidadExistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 254, -1, 25));

        jSeparatorCantidadExistencia.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorCantidadExistencia.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorCantidadExistencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorCantidadExistencia.setOpaque(true);
        jPanelCuerpo.add(jSeparatorCantidadExistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 294, 100, -1));

        jTextFieldCantidadExistencia.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldCantidadExistencia.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldCantidadExistencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCantidadExistencia.setToolTipText("Ingrese solo numeros. Ej.: 34");
        jTextFieldCantidadExistencia.setBorder(null);
        jTextFieldCantidadExistencia.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldCantidadExistencia.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldCantidadExistencia.setOpaque(false);
        jTextFieldCantidadExistencia.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldCantidadExistencia.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldCantidadExistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 274, 100, 20));

        jLabelTituloCantidadMinima.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloCantidadMinima.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloCantidadMinima.setText("Cantidad fija del stock:");
        jLabelTituloCantidadMinima.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloCantidadMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 254, -1, 25));

        jSeparatorCantidadMinima.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorCantidadMinima.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorCantidadMinima.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorCantidadMinima.setOpaque(true);
        jPanelCuerpo.add(jSeparatorCantidadMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 294, 100, -1));

        jTextFieldCantidadMinima.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldCantidadMinima.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldCantidadMinima.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCantidadMinima.setToolTipText("Ingrese solo numeros. Ej.: 34");
        jTextFieldCantidadMinima.setBorder(null);
        jTextFieldCantidadMinima.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldCantidadMinima.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldCantidadMinima.setOpaque(false);
        jTextFieldCantidadMinima.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldCantidadMinima.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldCantidadMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 274, 100, 20));

        jLabelTituloIuMarcaCris.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuMarcaCris.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuMarcaCris.setText("Marca del cristal:");
        jLabelTituloIuMarcaCris.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloIuMarcaCris, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 176, -1, 25));

        jSeparatorIuMarcaCris.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuMarcaCris.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuMarcaCris.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuMarcaCris.setOpaque(true);
        jPanelCuerpo.add(jSeparatorIuMarcaCris, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 216, 200, -1));

        jTextFieldIuMarcaCris.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuMarcaCris.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuMarcaCris.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuMarcaCris.setToolTipText("Ingrese solo alfanumericos y simbolos(-) o (.). Ej.: cristem");
        jTextFieldIuMarcaCris.setBorder(null);
        jTextFieldIuMarcaCris.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuMarcaCris.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuMarcaCris.setOpaque(false);
        jTextFieldIuMarcaCris.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuMarcaCris.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldIuMarcaCris.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIuMarcaCrisFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldIuMarcaCrisFocusLost(evt);
            }
        });
        jTextFieldIuMarcaCris.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldIuMarcaCrisKeyReleased(evt);
            }
        });
        jPanelCuerpo.add(jTextFieldIuMarcaCris, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 196, 200, 20));

        jButtonRegMarcaCris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x25Off.png"))); // NOI18N
        jButtonRegMarcaCris.setBorder(null);
        jButtonRegMarcaCris.setBorderPainted(false);
        jButtonRegMarcaCris.setContentAreaFilled(false);
        jButtonRegMarcaCris.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegMarcaCris.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegMarcaCris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegMarcaCrisActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonRegMarcaCris, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 191, -1, -1));

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
        jPanelCuerpo.add(jButtonRegModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 191, -1, -1));

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
        jPanelCuerpo.add(jTextFieldCodModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 196, 200, 20));

        jSeparatorCodModeloVeh.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorCodModeloVeh.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorCodModeloVeh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorCodModeloVeh.setOpaque(true);
        jPanelCuerpo.add(jSeparatorCodModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 216, 200, -1));

        jLabelTituloCodModeloVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloCodModeloVeh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloCodModeloVeh.setText("Modelo del vehiculo");
        jLabelTituloCodModeloVeh.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloCodModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 176, -1, 25));

        jLabelTituloDescrCristal.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloDescrCristal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloDescrCristal.setText("Descripcion del cristal:");
        jLabelTituloDescrCristal.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloDescrCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 98, -1, 25));

        jTextFieldDescrCristal.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldDescrCristal.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldDescrCristal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDescrCristal.setToolTipText("Ingrese solo alfanumericos y simbolos(-) o (.). Ej.: p.d.i");
        jTextFieldDescrCristal.setBorder(null);
        jTextFieldDescrCristal.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldDescrCristal.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldDescrCristal.setOpaque(false);
        jTextFieldDescrCristal.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldDescrCristal.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldDescrCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 118, 200, 20));

        jSeparatorDescrCristal.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorDescrCristal.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorDescrCristal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorDescrCristal.setOpaque(true);
        jPanelCuerpo.add(jSeparatorDescrCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 138, 200, -1));

        jSeparatorCodigoCristal.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorCodigoCristal.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorCodigoCristal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorCodigoCristal.setOpaque(true);
        jPanelCuerpo.add(jSeparatorCodigoCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 66, 100, -1));

        jLabelTituloCodigoCristal.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloCodigoCristal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloCodigoCristal.setText("Codigo identificacion:");
        jLabelTituloCodigoCristal.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloCodigoCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 25, -1, 25));

        jTextFieldCodigoCristal.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldCodigoCristal.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldCodigoCristal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCodigoCristal.setToolTipText("Ingrese solo numeros. Ej.: 08");
        jTextFieldCodigoCristal.setBorder(null);
        jTextFieldCodigoCristal.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldCodigoCristal.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldCodigoCristal.setOpaque(false);
        jTextFieldCodigoCristal.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldCodigoCristal.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldCodigoCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 45, 100, 20));

        jButtonAgregarCatalogoCristal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOff.png"))); // NOI18N
        jButtonAgregarCatalogoCristal.setToolTipText("Has click para agregar.");
        jButtonAgregarCatalogoCristal.setBorder(null);
        jButtonAgregarCatalogoCristal.setBorderPainted(false);
        jButtonAgregarCatalogoCristal.setContentAreaFilled(false);
        jButtonAgregarCatalogoCristal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregarCatalogoCristal.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarCatalogoCristal.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarCatalogoCristal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarCatalogoCristalActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonAgregarCatalogoCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 407, -1, -1));

        jButtonEditarCatalogoCristal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOff.png"))); // NOI18N
        jButtonEditarCatalogoCristal.setToolTipText("Has click para editar.");
        jButtonEditarCatalogoCristal.setBorder(null);
        jButtonEditarCatalogoCristal.setBorderPainted(false);
        jButtonEditarCatalogoCristal.setContentAreaFilled(false);
        jButtonEditarCatalogoCristal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditarCatalogoCristal.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarCatalogoCristal.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarCatalogoCristal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarCatalogoCristalActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonEditarCatalogoCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 407, -1, -1));

        jButtonBorrarCatalogoCristal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOff.png"))); // NOI18N
        jButtonBorrarCatalogoCristal.setToolTipText("Has click para borrar.");
        jButtonBorrarCatalogoCristal.setBorder(null);
        jButtonBorrarCatalogoCristal.setBorderPainted(false);
        jButtonBorrarCatalogoCristal.setContentAreaFilled(false);
        jButtonBorrarCatalogoCristal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBorrarCatalogoCristal.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarCatalogoCristal.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarCatalogoCristal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarCatalogoCristalActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonBorrarCatalogoCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 407, -1, -1));

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
        jLabelTituloVentana.setText("Registro del catalogo de cristales");
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
    public void crearObjCatalogoCristales(){
     
        _objCatalogoCristales = new CatalogoCristales();
        _objCatalogoCristales.setCodigoCristal(jTextFieldCodigoCristal.getText());
        _objCatalogoCristales.setDescrCristal(jTextFieldDescrCristal.getText());
        _objCatalogoCristales.setCodModeloVeh(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()));
        _objCatalogoCristales.setIuMarcaCris(Integer.parseInt(_administradorMarcasCristales.obtenerIuMarcaCris(jTextFieldIuMarcaCris.getText())));
        _objCatalogoCristales.setCantidadMinima(Integer.parseInt(jTextFieldCantidadMinima.getText()));
        _objCatalogoCristales.setCantidadExistencia(Integer.parseInt(jTextFieldCantidadExistencia.getText()));
        _objCatalogoCristales.setPrecioPieza(Double.parseDouble(jTextFieldPrecioPieza.getText()));
    }

// valida codModeloVeh en caso de no hacer cick en a lista
    public void validarCodModeloVeh(){
        auxSeleccionList = _administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length() != 0;
    }
    
// valida codModeloVeh en caso de no hacer cick en a lista
    public void validarIuMarcaCris(){
        auxSeleccionList2 = _administradorMarcasCristales.obtenerIuMarcaCris(jTextFieldIuMarcaCris.getText()).length() != 0;
    }
    
// limpia los jtextfield usados
    public void limpiarCampos(){

        jTextFieldCodigoCristal.setText("");
        jTextFieldDescrCristal.setText(""); 
        jTextFieldCodModeloVeh.setText("");
        jTextFieldIuMarcaCris.setText("");
        jTextFieldCantidadMinima.setText("");
        jTextFieldCantidadExistencia.setText("");
        jTextFieldPrecioPieza.setText("");
        }
     
// este metodo crea menu de opciones al usar click secundario   
    public final void popupMenuJTable(){
//se crean las opciones del menu
        JPopupMenu jPopupMenuTableHCC = new JPopupMenu();
        JMenuItem jMenuItemEliminarCatalogoCristales = new JMenuItem("Eliminar"); // cambiar x ico 
        JMenuItem jMenuItemModificarCatalogoCristales = new JMenuItem("Modificar");
        JMenuItem jMenuOrdenar = new JMenu("Ordenar por");
        JMenuItem jMenuItemPrimerosAgregados = new JMenuItem("Primeros agregados");
        JMenuItem jMenuItemUltimosAgregados= new JMenuItem("Ultimos agregados");
        JMenuItem jMenuItemAlfabeticos = new JMenuItem("Alfabeticos"); 
        jMenuOrdenar.add(jMenuItemPrimerosAgregados);
        jMenuOrdenar.add(jMenuItemUltimosAgregados); 
        jMenuOrdenar.add(jMenuItemAlfabeticos);
// se generan las acciones de cada opcion
        jMenuItemEliminarCatalogoCristales.addActionListener((ActionEvent e) -> {
        
        if(seleccionarItemJTabla()!= -1){
                 
            jPanelVentanaBuscar.setBounds(-700, 30, 700, 457);
            jPanelCuerpo.setBounds( 100,30,  700, 457);
              
            jButtonAgregarCatalogoCristal.setEnabled(false);
            jButtonEditarCatalogoCristal.setEnabled(false);
            jTextFieldCodigoCristal.setEditable(false);
            jTextFieldDescrCristal.setEditable(false); 
            jTextFieldCodModeloVeh.setEditable(false);
            jTextFieldIuMarcaCris.setEditable(false);
            jTextFieldCantidadMinima.setEditable(false);
            jTextFieldCantidadExistencia.setEditable(false);
            jTextFieldPrecioPieza.setEditable(false);
            jButtonRegMarcaCris.setEnabled(false);
            jButtonRegModeloVeh.setEnabled(false);
            jListMarcaCris.setVisible(false);
            jListModeloVeh.setVisible(false);
            jPanelListaMarcaCris.setVisible(false);
            jPanelListaModeloVeh.setVisible(false);
            jButtonBorrarCatalogoCristal.setEnabled(true);
             }
         });
         
        jMenuItemModificarCatalogoCristales.addActionListener((ActionEvent e) -> {
            
        if(seleccionarItemJTabla()!= -1){
                     
            jPanelVentanaBuscar.setBounds(-700, 30, 700, 457);
            jPanelCuerpo.setBounds( 100,30,  700, 457);
                
            jButtonAgregarCatalogoCristal.setEnabled(false);
            jButtonBorrarCatalogoCristal.setEnabled(false);
            jTextFieldCodigoCristal.setEditable(false);   
            jButtonEditarCatalogoCristal.setEnabled(true);
            jTextFieldCodModeloVeh.setEditable(false);
            jTextFieldDescrCristal.setEditable(true);
            jTextFieldIuMarcaCris.setEditable(false);
            jPanelListaMarcaCris.setVisible(false);
            jPanelListaModeloVeh.setVisible(false);
            jListMarcaCris.setVisible(false);
            jListModeloVeh.setVisible(false);
            jButtonRegMarcaCris.setEnabled(false);
            jButtonRegModeloVeh.setEnabled(false);
        }
        });
             
        jMenuItemUltimosAgregados.addActionListener((ActionEvent e) -> {
            _administradorCatalogoCristales.ordenarTabla(jMenuItemUltimosAgregados.getText());
            jTableCatalogoCristal.setModel( _administradorCatalogoCristales.cargarJTabla());
        });
                
        jMenuItemAlfabeticos.addActionListener((ActionEvent e) -> {
            _administradorCatalogoCristales.ordenarTabla(jMenuItemAlfabeticos.getText());
            jTableCatalogoCristal.setModel( _administradorCatalogoCristales.cargarJTabla());
        });
                                
        jMenuItemPrimerosAgregados.addActionListener((ActionEvent e) -> {
            _administradorCatalogoCristales.ordenarTabla(jMenuItemPrimerosAgregados.getText());
            jTableCatalogoCristal.setModel( _administradorCatalogoCristales.cargarJTabla());
        });
// se construye el menu completo y se le asigna si jTable
        jPopupMenuTableHCC.add(jMenuItemEliminarCatalogoCristales);
        jPopupMenuTableHCC.add(jMenuItemModificarCatalogoCristales);
        jPopupMenuTableHCC.add(jMenuOrdenar);
        jTableCatalogoCristal.setComponentPopupMenu(jPopupMenuTableHCC);  
     }
 
// se obtiene los datos del item seleccionado en la tabla
    public int seleccionarItemJTabla(){
// se obtiene el modelo y se verifica que se haya seleccionado un item   
        modeloTablaCC = jTableCatalogoCristal.getModel();
        int auxSeleccion = jTableCatalogoCristal.getSelectedRow();
        if (auxSeleccion != -1) {
            jTableCatalogoCristal.setEnabled(true);
// se cargan los campos con los valores selcionados
            jTextFieldCodigoCristal.setText((String)modeloTablaCC.getValueAt(jTableCatalogoCristal.getSelectedRow(), 0));
            jTextFieldDescrCristal.setText((String)modeloTablaCC.getValueAt(jTableCatalogoCristal.getSelectedRow(), 1));
            jTextFieldCodModeloVeh.setText((String)modeloTablaCC.getValueAt(jTableCatalogoCristal.getSelectedRow(),3));
            jTextFieldIuMarcaCris.setText((String)modeloTablaCC.getValueAt(jTableCatalogoCristal.getSelectedRow(), 4));
            jTextFieldCantidadMinima.setText((String)modeloTablaCC.getValueAt(jTableCatalogoCristal.getSelectedRow(), 5));
            jTextFieldCantidadExistencia.setText((String)modeloTablaCC.getValueAt(jTableCatalogoCristal.getSelectedRow(), 6));
            jTextFieldPrecioPieza.setText((String)modeloTablaCC.getValueAt(jTableCatalogoCristal.getSelectedRow(), 7));
            
            return auxSeleccion;
            
        }else {
// si no selecciona mensaje error   
            jTableCatalogoCristal.setEnabled(false);
            jPanelItemNoSeleccionado.setBounds(325, 193, 250,100);
            return auxSeleccion;
        }
    }
    
//visualiza el panel buscar
    private void jButtonTraerPanelBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelBuscarActionPerformed
// llama al panel buscar 
    try {
        jTableCatalogoCristal.setModel(_administradorCatalogoCristales.cargarJTabla());
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
    private void jButtonAgregarCatalogoCristalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarCatalogoCristalActionPerformed
       
        jPanelMensajeValidarABM.setBounds(325, 193, 250, 100);
        auxAbm = 1;
        jButtonAgregarCatalogoCristal.setEnabled(false);
        jButtonEditarCatalogoCristal.setEnabled(false);
        jButtonBorrarCatalogoCristal.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldCodigoCristal.setEditable(false);
        jTextFieldDescrCristal.setEditable(false);
        jTextFieldCodModeloVeh.setEditable(false);
        jTextFieldIuMarcaCris.setEditable(false);
        jTextFieldCantidadMinima.setEditable(false);
        jTextFieldCantidadExistencia.setEditable(false);
        jTextFieldPrecioPieza.setEditable(false);
        jButtonRegMarcaCris.setEnabled(false);
        jButtonRegModeloVeh.setEnabled(false);
        jListMarcaCris.setVisible(false);
        jListModeloVeh.setVisible(false);
    }//GEN-LAST:event_jButtonAgregarCatalogoCristalActionPerformed

//valida datos y edita un registro en tabla TipoPagos
    private void jButtonEditarCatalogoCristalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarCatalogoCristalActionPerformed
        
        jPanelMensajeValidarABM.setBounds(325, 193, 250, 100);
        auxAbm = 2;
        jButtonAgregarCatalogoCristal.setEnabled(false);
        jButtonEditarCatalogoCristal.setEnabled(false);
        jButtonBorrarCatalogoCristal.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldCodigoCristal.setEditable(false);
        jTextFieldDescrCristal.setEditable(false);
        jTextFieldCodModeloVeh.setEditable(false);
        jTextFieldIuMarcaCris.setEditable(false);
        jTextFieldCantidadMinima.setEditable(false);
        jTextFieldCantidadExistencia.setEditable(false);
        jTextFieldPrecioPieza.setEditable(false);
        jButtonRegMarcaCris.setEnabled(false);
        jButtonRegModeloVeh.setEnabled(false);
        jListMarcaCris.setVisible(false);
        jListModeloVeh.setVisible(false);
        jPanelListaMarcaCris.setVisible(false);
        jPanelListaModeloVeh.setVisible(false);
        
    }//GEN-LAST:event_jButtonEditarCatalogoCristalActionPerformed

//valida datos y borra un registro en tabla TipoPagos 
    private void jButtonBorrarCatalogoCristalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarCatalogoCristalActionPerformed
        
        jPanelMensajeValidarABM.setBounds(325, 193, 250, 100);
        auxAbm = 3;
        jButtonAgregarCatalogoCristal.setEnabled(false);
        jButtonEditarCatalogoCristal.setEnabled(false);
        jButtonBorrarCatalogoCristal.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldCodigoCristal.setEditable(false);
        jTextFieldDescrCristal.setEditable(false);
        jTextFieldCodModeloVeh.setEditable(false);
        jTextFieldIuMarcaCris.setEditable(false);
        jTextFieldCantidadMinima.setEditable(false);
        jTextFieldCantidadExistencia.setEditable(false);
        jTextFieldPrecioPieza.setEditable(false);
        jButtonRegMarcaCris.setEnabled(false);
        jButtonRegModeloVeh.setEnabled(false);
        jListMarcaCris.setVisible(false);
        jListModeloVeh.setVisible(false);
        jPanelListaMarcaCris.setVisible(false);
        jPanelListaModeloVeh.setVisible(false);
    }//GEN-LAST:event_jButtonBorrarCatalogoCristalActionPerformed

// con cada tecleo valida los datos y elimina los no correctos
    private void jTextFieldBuscarCristalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarCristalKeyReleased
        boolean auxValidar = Administrador.validarCharDinamico(evt.getKeyChar(), "[a-zA-Z_0-9]||[\\s]");
    try {
        
        if(auxValidar==false){
               
            evt.consume();
            jTableCatalogoCristal.setModel(_administradorCatalogoCristales.buscarEnTabla(jTextFieldBuscarCristal.getText()));
               
        } else{
           
            jTableCatalogoCristal.setModel(_administradorCatalogoCristales.buscarEnTabla(jTextFieldBuscarCristal.getText()));
           }
    } catch (Exception e) {
        
        jPanelErrorBaseDeDatos.setBounds(325, 193, 250, 100);  
    }      
    }//GEN-LAST:event_jTextFieldBuscarCristalKeyReleased

//esconde el panel y habilita los obj en pantalla
    private void jButtonCancelarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarValidarCambiosActionPerformed
        
        auxAbm = 0;
        limpiarCampos();
        jPanelMensajeValidarABM.setBounds(-260, 193, 250, 100);
        jButtonAgregarCatalogoCristal.setEnabled(true);
        jButtonEditarCatalogoCristal.setEnabled(false);
        jButtonBorrarCatalogoCristal.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldDescrCristal.setEditable(true);
        jTextFieldCodModeloVeh.setEditable(true);
        jTextFieldCodigoCristal.setEditable(true);
        jTextFieldIuMarcaCris.setEditable(true);
        jTextFieldCantidadMinima.setEditable(true);
        jTextFieldCantidadExistencia.setEditable(true);
        jTextFieldPrecioPieza.setEditable(true);
        jButtonRegMarcaCris.setEnabled(true);
        jButtonRegModeloVeh.setEnabled(true);
        jListMarcaCris.setVisible(true);
        jListModeloVeh.setVisible(true);
        jTextFieldDescrCristal.setBorder(null);
        jTextFieldCodModeloVeh.setBorder(null);
        jTextFieldCodigoCristal.setBorder(null);
        jTextFieldIuMarcaCris.setBorder(null);
        jTextFieldCantidadMinima.setBorder(null);
        jTextFieldCantidadExistencia.setBorder(null);
        jTextFieldPrecioPieza.setBorder(null);
        jPanelListaMarcaCris.setVisible(true);
        jPanelListaModeloVeh.setVisible(true);
    }//GEN-LAST:event_jButtonCancelarValidarCambiosActionPerformed

    private void jButtonAceptarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarValidarCambiosActionPerformed
        boolean[] listaVerdades = new boolean[7];
        int aux = 0;
        int auxMensaje2 = 0;
        int auxMensaje = 0;
// llama al panel y segun desde donde llamo ejecuta la accion        
        jPanelMensajeValidarABM.setBounds(-260, 193, 250, 100);     
        switch(auxAbm){
            
            case 1:
                listaVerdades[0] = Administrador.validarCamposTextos(jTextFieldCodigoCristal.getText(), "\\d" );
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldDescrCristal.getText(),"[a-zA-Z_0-9]||[.]||[-]");
                validarCodModeloVeh();
                listaVerdades[2] = auxSeleccionList;
                validarIuMarcaCris();
                listaVerdades[3] = auxSeleccionList2;
                listaVerdades[4] = Administrador.validarCamposTextos(jTextFieldCantidadMinima.getText(), "\\d" );
                listaVerdades[5] = Administrador.validarCamposTextos(jTextFieldCantidadExistencia.getText(), "\\d" );
                listaVerdades[6] = Administrador.validarCamposDoubles(jTextFieldPrecioPieza.getText());
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==7){
                    jTextFieldDescrCristal.setBorder(new LineBorder(Color.green));
                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCantidadExistencia.setBorder(new LineBorder(Color.green));
                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.green));
                    jTextFieldCantidadMinima.setBorder(new LineBorder(Color.green));
                    jTextFieldPrecioPieza.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    auxSeleccionList2 = false;
                    crearObjCatalogoCristales();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorCatalogoCristales.insertarTablaCatalogoCristal(_objCatalogoCristales)==true){
               
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
                                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;        
                            case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldDescrCristal.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDescrCristal.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                                    if(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.red));
                                    if(_administradorMarcasCristales.obtenerIuMarcaCris(jTextFieldIuMarcaCris.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 4:
                                if(listaVerdades[i]==true){
                                    jTextFieldCantidadMinima.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCantidadMinima.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 5:
                                if(listaVerdades[i]==true){
                                    jTextFieldCantidadExistencia.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCantidadExistencia.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 6:
                                if(listaVerdades[i]==true){
                                    jTextFieldPrecioPieza.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldPrecioPieza.setBorder(new LineBorder(Color.red));
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
                listaVerdades[0] = Administrador.validarCamposTextos(jTextFieldCodigoCristal.getText(), "\\d" );
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldDescrCristal.getText(),"[a-zA-Z_0-9]||[.]||[-]");
                validarCodModeloVeh();
                listaVerdades[2] = auxSeleccionList;
                validarIuMarcaCris();
                listaVerdades[3] = auxSeleccionList2;
                listaVerdades[4] = Administrador.validarCamposTextos(jTextFieldCantidadMinima.getText(), "\\d" );
                listaVerdades[5] = Administrador.validarCamposTextos(jTextFieldCantidadExistencia.getText(), "\\d" );
                listaVerdades[6] = Administrador.validarCamposDoubles(jTextFieldPrecioPieza.getText());
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true){
                        aux = 1;
                    } else{
                        aux = 0;
            break;
                    }
                }
                if(aux==1){
                    jTextFieldDescrCristal.setBorder(new LineBorder(Color.green));
                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCantidadExistencia.setBorder(new LineBorder(Color.green));
                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.green));
                    jTextFieldCantidadMinima.setBorder(new LineBorder(Color.green));
                    jTextFieldPrecioPieza.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    auxSeleccionList2 = false;
                    crearObjCatalogoCristales();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorCatalogoCristales.actualizarTablaCatalogoCristal(_objCatalogoCristales)==true){
               
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
                                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.red));
                                }
                        break;        
                            case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldDescrCristal.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDescrCristal.setBorder(new LineBorder(Color.red));
                                }
                        break;
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                                    if(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.red));
                                    if(_administradorMarcasCristales.obtenerIuMarcaCris(jTextFieldIuMarcaCris.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 4:
                                if(listaVerdades[i]==true){
                                    jTextFieldCantidadMinima.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCantidadMinima.setBorder(new LineBorder(Color.red));
                                }
                        break;
                            case 5:
                                if(listaVerdades[i]==true){
                                    jTextFieldCantidadExistencia.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCantidadExistencia.setBorder(new LineBorder(Color.red));
                                }
                        break;
                            case 6:
                                if(listaVerdades[i]==true){
                                    jTextFieldPrecioPieza.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldPrecioPieza.setBorder(new LineBorder(Color.red));
                                }
                        break;
                        }
                    }
                    if(auxMensaje==1) jPanelElementoNoExistente.setBounds(325, 193, 250, 100);
                    if(aux==0) jPanelGuardadoErroneo.setBounds(325, 193, 250, 100);
                    
                }
            break;
// se repite el mismo codigo solo que se borra un item de la db         
            case 3:
// se validan los datos
                listaVerdades[0] = Administrador.validarCamposTextos(jTextFieldCodigoCristal.getText(), "\\d" );
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldDescrCristal.getText(),"[a-zA-Z_0-9]||[.]||[-]");
                validarCodModeloVeh();
                listaVerdades[2] = auxSeleccionList;
                validarIuMarcaCris();
                listaVerdades[3] = auxSeleccionList2;
                listaVerdades[4] = Administrador.validarCamposTextos(jTextFieldCantidadMinima.getText(), "\\d" );
                listaVerdades[5] = Administrador.validarCamposTextos(jTextFieldCantidadExistencia.getText(), "\\d" );
                listaVerdades[6] = Administrador.validarCamposDoubles(jTextFieldPrecioPieza.getText());
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true){
                        aux = 1;
                    } else{
                        aux = 0;
            break;
                    }
                }
                if(aux==1){
                    jTextFieldDescrCristal.setBorder(new LineBorder(Color.green));
                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCantidadExistencia.setBorder(new LineBorder(Color.green));
                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.green));
                    jTextFieldCantidadMinima.setBorder(new LineBorder(Color.green));
                    jTextFieldPrecioPieza.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    auxSeleccionList2 = false;
                    crearObjCatalogoCristales();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorCatalogoCristales.eliminarTablaCatalogoCristal(_objCatalogoCristales)==true){
               
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
                                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.red));
                                }
                        break;        
                            case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldDescrCristal.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDescrCristal.setBorder(new LineBorder(Color.red));
                                }
                        break;
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                                    if(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.red));
                                    if(_administradorMarcasCristales.obtenerIuMarcaCris(jTextFieldIuMarcaCris.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 4:
                                if(listaVerdades[i]==true){
                                    jTextFieldCantidadMinima.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCantidadMinima.setBorder(new LineBorder(Color.red));
                                }
                        break;
                            case 5:
                                if(listaVerdades[i]==true){
                                    jTextFieldCantidadExistencia.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCantidadExistencia.setBorder(new LineBorder(Color.red));
                                }
                        break;
                            case 6:
                                if(listaVerdades[i]==true){
                                    jTextFieldPrecioPieza.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldPrecioPieza.setBorder(new LineBorder(Color.red));
                                }
                        break;
                        }
                    }
                    if(auxMensaje==1) jPanelElementoNoExistente.setBounds(225, 100, 250, 100);
                    if(aux==1) jPanelGuardadoErroneo.setBounds(325, 193, 250, 100);
                    
                }
            break;            
        }
    }//GEN-LAST:event_jButtonAceptarValidarCambiosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones, se limpia los campos
    private void jButtonAceptarGuardadoExitosoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoExitosoActionPerformed
       
        jPanelGuardadoExitoso.setBounds(-260, 193, 250, 100);
        jTextFieldDescrCristal.setBorder(null);
        jTextFieldCodModeloVeh.setBorder(null);
        jTextFieldCodigoCristal.setBorder(null);
        jTextFieldIuMarcaCris.setBorder(null);
        jTextFieldCantidadMinima.setBorder(null);
        jTextFieldCantidadExistencia.setBorder(null);
        jTextFieldPrecioPieza.setBorder(null);
        limpiarCampos();
        jButtonAgregarCatalogoCristal.setEnabled(true);
        jButtonEditarCatalogoCristal.setEnabled(false);
        jButtonBorrarCatalogoCristal.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldDescrCristal.setEditable(true);
        jTextFieldCodModeloVeh.setEditable(true);
        jTextFieldCodigoCristal.setEditable(true);
        jTextFieldIuMarcaCris.setEditable(true);
        jTextFieldCantidadMinima.setEditable(true);
        jTextFieldCantidadExistencia.setEditable(true);
        jTextFieldPrecioPieza.setEditable(true);
        jButtonRegModeloVeh.setEnabled(true);
        jButtonRegMarcaCris.setEnabled(true);
        jListMarcaCris.setVisible(true);
        jPanelListaModeloVeh.setVisible(true);
        jListModeloVeh.setVisible(true);
        jPanelListaMarcaCris.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarGuardadoExitosoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarGuardadoErroneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoErroneoActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelElementoExistente.setBounds(-260, 193, 250, 100);
                jPanelGuardadoErroneo.setBounds(-260, 193, 250, 100);
                jButtonAgregarCatalogoCristal.setEnabled(true);
                jButtonEditarCatalogoCristal.setEnabled(false);
                jButtonBorrarCatalogoCristal.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldDescrCristal.setEditable(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jTextFieldCodigoCristal.setEditable(true);
                jTextFieldIuMarcaCris.setEditable(true);
                jTextFieldCantidadMinima.setEditable(true);
                jTextFieldCantidadExistencia.setEditable(true);
                jTextFieldPrecioPieza.setEditable(true);
                jButtonRegMarcaCris.setEnabled(true);
                jButtonRegModeloVeh.setEnabled(true);
                jListMarcaCris.setVisible(true);
                jListModeloVeh.setVisible(true); 
                jPanelListaMarcaCris.setVisible(true);
                jPanelListaModeloVeh.setVisible(true);
            
            break;
            
            case 2:
                jPanelElementoExistente.setBounds(-260, 193, 250, 100);
                jPanelGuardadoErroneo.setBounds(-260, 193, 250, 100);
                jButtonAgregarCatalogoCristal.setEnabled(false);
                jButtonEditarCatalogoCristal.setEnabled(true);
                jButtonBorrarCatalogoCristal.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldDescrCristal.setEditable(true);
                jTextFieldCodModeloVeh.setEditable(false);
                jTextFieldCodigoCristal.setEditable(false);
                jTextFieldIuMarcaCris.setEditable(false);
                jTextFieldCantidadMinima.setEditable(true);
                jTextFieldCantidadExistencia.setEditable(true);
                jTextFieldPrecioPieza.setEditable(true);
                jButtonRegMarcaCris.setEnabled(false);
                jButtonRegModeloVeh.setEnabled(false);
                jListMarcaCris.setVisible(false);
                jListModeloVeh.setVisible(false);    
                jPanelListaMarcaCris.setVisible(false);
                jPanelListaModeloVeh.setVisible(false);
                
            break;
            
            case 3: 
                jPanelElementoExistente.setBounds(-260, 193, 250, 100);
                jPanelGuardadoErroneo.setBounds(-260, 193, 250, 100);
                jButtonAgregarCatalogoCristal.setEnabled(false);
                jButtonEditarCatalogoCristal.setEnabled(false);
                jButtonBorrarCatalogoCristal.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldDescrCristal.setEditable(false);
                jTextFieldCodModeloVeh.setEditable(false);
                jTextFieldCodigoCristal.setEditable(false);
                jTextFieldIuMarcaCris.setEditable(false);
                jTextFieldCantidadMinima.setEditable(false);
                jTextFieldCantidadExistencia.setEditable(false);
                jTextFieldPrecioPieza.setEditable(false);
                jListMarcaCris.setVisible(false);
                jListModeloVeh.setVisible(false);
                jPanelListaMarcaCris.setVisible(false);
                jPanelListaModeloVeh.setVisible(false);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarGuardadoErroneoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarErrorBaseDeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarErrorBaseDeDatosActionPerformed
        
        jPanelErrorBaseDeDatos.setBounds(-260, 193, 250, 100);
        jButtonAgregarCatalogoCristal.setEnabled(true);
        jButtonEditarCatalogoCristal.setEnabled(false);
        jButtonBorrarCatalogoCristal.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldDescrCristal.setEditable(true);
        jTextFieldCodModeloVeh.setEditable(true);
        jTextFieldCodigoCristal.setEditable(true);
        jTextFieldIuMarcaCris.setEditable(true);
        jTextFieldCantidadMinima.setEditable(true);
        jTextFieldCantidadExistencia.setEditable(true);
        jTextFieldPrecioPieza.setEditable(true);
        jPanelListaModeloVeh.setVisible(true);
        jPanelListaMarcaCris.setVisible(true);
        jListMarcaCris.setVisible(true);
        jListModeloVeh.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarErrorBaseDeDatosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarElementoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoExistenteActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelElementoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarCatalogoCristal.setEnabled(true);
                jButtonEditarCatalogoCristal.setEnabled(false);
                jButtonBorrarCatalogoCristal.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldDescrCristal.setEditable(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jTextFieldCodigoCristal.setEditable(true);
                jTextFieldIuMarcaCris.setEditable(true);
                jTextFieldCantidadMinima.setEditable(true);
                jTextFieldCantidadExistencia.setEditable(true);
                jTextFieldPrecioPieza.setEditable(true);
                jButtonRegMarcaCris.setEnabled(true);
                jButtonRegModeloVeh.setEnabled(true);
                jListMarcaCris.setVisible(true);
                jListModeloVeh.setVisible(true); 
                jPanelListaMarcaCris.setVisible(true);
                jPanelListaModeloVeh.setVisible(true);
            
            break;
            
            case 2:
                jPanelElementoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarCatalogoCristal.setEnabled(false);
                jButtonEditarCatalogoCristal.setEnabled(true);
                jButtonBorrarCatalogoCristal.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldDescrCristal.setEditable(true);
                jTextFieldCodModeloVeh.setEditable(false);
                jTextFieldCodigoCristal.setEditable(false);
                jTextFieldIuMarcaCris.setEditable(false);
                jTextFieldCantidadMinima.setEditable(true);
                jTextFieldCantidadExistencia.setEditable(true);
                jTextFieldPrecioPieza.setEditable(true);
                jButtonRegMarcaCris.setEnabled(false);
                jButtonRegModeloVeh.setEnabled(false);
                jListMarcaCris.setVisible(false);
                jListModeloVeh.setVisible(false);    
                jPanelListaMarcaCris.setVisible(false);
                jPanelListaModeloVeh.setVisible(false);
                
            break;
            
            case 3: 
                jPanelElementoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarCatalogoCristal.setEnabled(false);
                jButtonEditarCatalogoCristal.setEnabled(false);
                jButtonBorrarCatalogoCristal.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldDescrCristal.setEditable(false);
                jTextFieldCodModeloVeh.setEditable(false);
                jTextFieldCodigoCristal.setEditable(false);
                jTextFieldIuMarcaCris.setEditable(false);
                jTextFieldCantidadMinima.setEditable(false);
                jTextFieldCantidadExistencia.setEditable(false);
                jTextFieldPrecioPieza.setEditable(false);
                jListMarcaCris.setVisible(false);
                jListModeloVeh.setVisible(false);
                jPanelListaMarcaCris.setVisible(false);
                jPanelListaModeloVeh.setVisible(false);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarElementoExistenteActionPerformed

// se acomoda los objetos del frame para continuar trabajando. 
    private void jButtonAceptarItemNoSeleccionado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

        jTableCatalogoCristal.setEnabled(true);
        jPanelItemNoSeleccionado.setBounds(-260, 193, 250, 100); 
    }//GEN-LAST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

    private void jButtonRegModeloVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegModeloVehActionPerformed
        JFrameRegistroModelosVehiculos obj = new JFrameRegistroModelosVehiculos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegModeloVehActionPerformed

    private void jListModeloVehMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModeloVehMouseClicked
        int indexList = jListModeloVeh.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList = true;
            jTextFieldCodModeloVeh.setText("");
            jTextFieldCodModeloVeh.setText(jListModeloVeh.getSelectedValue());
            jPanelListaModeloVeh.setBounds(-300, 216, 200, 50);
        } else{
            auxSeleccionList = false;
        }
        
    }//GEN-LAST:event_jListModeloVehMouseClicked

    private void jListModeloVehFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListModeloVehFocusGained

        jPanelListaModeloVeh.setBounds(90,216, 200, 50); 
    }//GEN-LAST:event_jListModeloVehFocusGained

    private void jButtonAceptarElementoNoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoNoExistenteActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelElementoNoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarCatalogoCristal.setEnabled(true);
                jButtonEditarCatalogoCristal.setEnabled(false);
                jButtonBorrarCatalogoCristal.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldDescrCristal.setEditable(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jTextFieldCodigoCristal.setEditable(true);
                jTextFieldIuMarcaCris.setEditable(true);
                jTextFieldCantidadMinima.setEditable(true);
                jTextFieldCantidadExistencia.setEditable(true);
                jTextFieldPrecioPieza.setEditable(true);
                jButtonRegMarcaCris.setEnabled(true);
                jButtonRegModeloVeh.setEnabled(true);
                jListMarcaCris.setVisible(true);
                jListModeloVeh.setVisible(true); 
                jPanelListaMarcaCris.setVisible(true);
                jPanelListaModeloVeh.setVisible(true);
            break;
            
            case 2:
                jPanelElementoNoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarCatalogoCristal.setEnabled(false);
                jButtonEditarCatalogoCristal.setEnabled(true);
                jButtonBorrarCatalogoCristal.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldDescrCristal.setEditable(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jTextFieldCodigoCristal.setEditable(true);
                jTextFieldIuMarcaCris.setEditable(true);
                jTextFieldCantidadMinima.setEditable(true);
                jTextFieldCantidadExistencia.setEditable(true);
                jTextFieldPrecioPieza.setEditable(true);
                jButtonRegMarcaCris.setEnabled(true);
                jButtonRegModeloVeh.setEnabled(true);
                jListMarcaCris.setVisible(true);
                jListModeloVeh.setVisible(true); 
                jPanelListaMarcaCris.setVisible(false);
                jPanelListaModeloVeh.setVisible(false);
            break;
            
            case 3: 
                jPanelElementoNoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarCatalogoCristal.setEnabled(false);
                jButtonEditarCatalogoCristal.setEnabled(false);
                jButtonBorrarCatalogoCristal.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldDescrCristal.setEditable(false);
                jTextFieldCodModeloVeh.setEditable(false);
                jTextFieldCodigoCristal.setEditable(false);
                jTextFieldIuMarcaCris.setEditable(false);
                jTextFieldCantidadMinima.setEditable(false);
                jTextFieldCantidadExistencia.setEditable(false);
                jPanelListaModeloVeh.setVisible(false); 
                jPanelListaMarcaCris.setVisible(false);
                jPanelListaModeloVeh.setVisible(false);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarElementoNoExistenteActionPerformed

    private void jButtonRegMarcaCrisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegMarcaCrisActionPerformed
        JFrameRegistroMarcasCristales obj = new JFrameRegistroMarcasCristales();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegMarcaCrisActionPerformed

    private void jTextFieldCodModeloVehFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodModeloVehFocusGained

        jListModeloVeh.setModel(_administradorModeloVehiculo.cargarLista(jTextFieldCodModeloVeh.getText()));
        jPanelListaModeloVeh.setBounds(90,216, 200, 50);
    }//GEN-LAST:event_jTextFieldCodModeloVehFocusGained

    private void jTextFieldCodModeloVehFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodModeloVehFocusLost

        jPanelListaModeloVeh.setBounds(-300,216, 200, 50);
    }//GEN-LAST:event_jTextFieldCodModeloVehFocusLost

    private void jTextFieldCodModeloVehKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodModeloVehKeyReleased

        jListModeloVeh.setModel(_administradorModeloVehiculo.cargarLista(jTextFieldCodModeloVeh.getText()));
        jPanelListaModeloVeh.setBounds(90,216, 200, 50);
    }//GEN-LAST:event_jTextFieldCodModeloVehKeyReleased

    private void jTextFieldIuMarcaCrisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuMarcaCrisFocusGained

        jListMarcaCris.setModel(_administradorMarcasCristales.cargarLista(jTextFieldIuMarcaCris.getText()));
        jPanelListaMarcaCris.setBounds(390,216, 200, 50);
    }//GEN-LAST:event_jTextFieldIuMarcaCrisFocusGained

    private void jTextFieldIuMarcaCrisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuMarcaCrisFocusLost

        jPanelListaMarcaCris.setBounds(-300,216, 200, 50);
    }//GEN-LAST:event_jTextFieldIuMarcaCrisFocusLost

    private void jTextFieldIuMarcaCrisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIuMarcaCrisKeyReleased

        jListMarcaCris.setModel(_administradorMarcasCristales.cargarLista(jTextFieldIuMarcaCris.getText()));
        jPanelListaMarcaCris.setBounds(390,216, 200, 50);
    }//GEN-LAST:event_jTextFieldIuMarcaCrisKeyReleased

    private void jListMarcaCrisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListMarcaCrisFocusGained

        jPanelListaMarcaCris.setBounds(390,216, 200, 50); 
    }//GEN-LAST:event_jListMarcaCrisFocusGained

    private void jListMarcaCrisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListMarcaCrisMouseClicked
        int indexList = jListMarcaCris.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList2 = true;
            jTextFieldIuMarcaCris.setText("");
            jTextFieldIuMarcaCris.setText(jListMarcaCris.getSelectedValue());
            jPanelListaMarcaCris.setBounds(-300, 216, 200, 50);
        } else{
            auxSeleccionList2 = false;
        }
    
    }//GEN-LAST:event_jListMarcaCrisMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAceptarElementoExistente;
    private javax.swing.JButton jButtonAceptarElementoNoExistente;
    private javax.swing.JButton jButtonAceptarErrorBaseDeDatos;
    private javax.swing.JButton jButtonAceptarGuardadoErroneo;
    private javax.swing.JButton jButtonAceptarGuardadoExitoso;
    private javax.swing.JButton jButtonAceptarItemNoSeleccionado2;
    private javax.swing.JButton jButtonAceptarValidarCambios;
    private javax.swing.JButton jButtonAgregarCatalogoCristal;
    private javax.swing.JButton jButtonBorrarCatalogoCristal;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelarValidarCambios;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonEditarCatalogoCristal;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JButton jButtonRegMarcaCris;
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
    private javax.swing.JLabel jLabelTituloBuscarCristal;
    private javax.swing.JLabel jLabelTituloCantidadExistencia;
    private javax.swing.JLabel jLabelTituloCantidadMinima;
    private javax.swing.JLabel jLabelTituloCodModeloVeh;
    private javax.swing.JLabel jLabelTituloCodigoCristal;
    private javax.swing.JLabel jLabelTituloDescrCristal;
    private javax.swing.JLabel jLabelTituloIuMarcaCris;
    private javax.swing.JLabel jLabelTituloPrecioPieza;
    private javax.swing.JLabel jLabelTituloVentana;
    private javax.swing.JLabel jLabelToolKitMarca;
    private javax.swing.JList<String> jListMarcaCris;
    private javax.swing.JList<String> jListModeloVeh;
    private javax.swing.JPanel jPanelBarraTitulo;
    private javax.swing.JPanel jPanelCuerpo;
    private javax.swing.JPanel jPanelElementoExistente;
    private javax.swing.JPanel jPanelElementoNoExistente;
    private javax.swing.JPanel jPanelErrorBaseDeDatos;
    private javax.swing.JPanel jPanelGuardadoErroneo;
    private javax.swing.JPanel jPanelGuardadoExitoso;
    private javax.swing.JPanel jPanelItemNoSeleccionado;
    private javax.swing.JPanel jPanelListaMarcaCris;
    private javax.swing.JPanel jPanelListaModeloVeh;
    private javax.swing.JPanel jPanelMensajeCerrar;
    private javax.swing.JPanel jPanelMensajeValidarABM;
    private javax.swing.JPanel jPanelVentanaBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparatorBuscarCristal;
    private javax.swing.JSeparator jSeparatorCantidadExistencia;
    private javax.swing.JSeparator jSeparatorCantidadMinima;
    private javax.swing.JSeparator jSeparatorCodModeloVeh;
    private javax.swing.JSeparator jSeparatorCodigoCristal;
    private javax.swing.JSeparator jSeparatorDescrCristal;
    private javax.swing.JSeparator jSeparatorIuMarcaCris;
    private javax.swing.JSeparator jSeparatorPrecioPieza;
    private javax.swing.JTable jTableCatalogoCristal;
    private javax.swing.JTextField jTextFieldBuscarCristal;
    private javax.swing.JTextField jTextFieldCantidadExistencia;
    private javax.swing.JTextField jTextFieldCantidadMinima;
    private javax.swing.JTextField jTextFieldCodModeloVeh;
    private javax.swing.JTextField jTextFieldCodigoCristal;
    private javax.swing.JTextField jTextFieldDescrCristal;
    private javax.swing.JTextField jTextFieldIuMarcaCris;
    private javax.swing.JTextField jTextFieldPrecioPieza;
    // End of variables declaration//GEN-END:variables
}
