/*
* este JFrame registra (agrega, borra, edita, busca y filtra) todos las marcas de vehiculos
 */
package Vistas;

import administradorClases.Administrador;
import administradorClases.AdministradorMarcasCristales;
import administradorClases.AdministradorPedidos;
import com.mysql.jdbc.Connection;
import static controladorBD.ConectorMySql.getConection;
import java.awt.Color;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class JFrameRegistroGeneradorPedido extends javax.swing.JFrame {
    
    private final AdministradorMarcasCristales _administradorMarcasCristales;
    private final AdministradorPedidos _administradorPedidos;
    private boolean auxSeleccionList2;
    private boolean auxSeleccionList;
    private Connection _conectarSql;
    
    public JFrameRegistroGeneradorPedido() {
        initComponents();
// se personaliza las fuentes de letra de los objetos grafico
        jLabelTituloVentana.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 8));
        jLabelTituloIuMarcaCris.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldIuMarcaCris.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloFechaPedido.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldFechaPedido.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        
        jLabelMensajeUno.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeDos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));

        _administradorMarcasCristales = new AdministradorMarcasCristales();
        _administradorPedidos = new AdministradorPedidos();
        
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMensajeCerrar = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jLabelIconoAlerta = new javax.swing.JLabel();
        jLabelMensajeUno = new javax.swing.JLabel();
        jLabelMensajeDos = new javax.swing.JLabel();
        jLabelFondoIconoMensajeCerrar = new javax.swing.JLabel();
        jPanelMarcaVacia = new javax.swing.JPanel();
        jButtonAceptarMarcaVacia = new javax.swing.JButton();
        jLabelIconoErrorMarcaVacia = new javax.swing.JLabel();
        jLabelMensajeMarcaVacia = new javax.swing.JLabel();
        jLabelFondoIconoMarcaVacia = new javax.swing.JLabel();
        jPanelCuerpo = new javax.swing.JPanel();
        jPanelListaFechaPedido = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListFechaPedido = new javax.swing.JList<>();
        jPanelListaIuMarcaCris = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListMarcaCristal = new javax.swing.JList<>();
        jLabelTituloFechaPedido = new javax.swing.JLabel();
        jTextFieldFechaPedido = new javax.swing.JTextField();
        jSeparatorFechaPedido = new javax.swing.JSeparator();
        jSeparatorIuMarcaCris = new javax.swing.JSeparator();
        jLabelTituloIuMarcaCris = new javax.swing.JLabel();
        jTextFieldIuMarcaCris = new javax.swing.JTextField();
        jButtonGenerarReporte = new javax.swing.JButton();
        jLabelIconoFondoCuerpo = new javax.swing.JLabel();
        jPanelBarraTitulo = new javax.swing.JPanel();
        jLabelTituloVentana = new javax.swing.JLabel();
        jButtonMinimizar = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();
        jLabelIconoBarraTitulo = new javax.swing.JLabel();
        jLabelToolKitMarca = new javax.swing.JLabel();
        jLabelIconoFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 256));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(700, 256));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanelMarcaVacia.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelMarcaVacia.setOpaque(false);
        jPanelMarcaVacia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarMarcaVacia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarMarcaVacia.setToolTipText("Has click para continuar.");
        jButtonAceptarMarcaVacia.setBorder(null);
        jButtonAceptarMarcaVacia.setBorderPainted(false);
        jButtonAceptarMarcaVacia.setContentAreaFilled(false);
        jButtonAceptarMarcaVacia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarMarcaVacia.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarMarcaVacia.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarMarcaVacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarMarcaVaciaActionPerformed(evt);
            }
        });
        jPanelMarcaVacia.add(jButtonAceptarMarcaVacia, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorMarcaVacia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelMarcaVacia.add(jLabelIconoErrorMarcaVacia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeMarcaVacia.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeMarcaVacia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeMarcaVacia.setText("No selecciono una marca.");
        jPanelMarcaVacia.add(jLabelMensajeMarcaVacia, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 20, 200, 25));

        jLabelFondoIconoMarcaVacia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelMarcaVacia.add(jLabelFondoIconoMarcaVacia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        getContentPane().add(jPanelMarcaVacia, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 100, 250, 100));

        jPanelCuerpo.setMaximumSize(new java.awt.Dimension(500, 270));
        jPanelCuerpo.setMinimumSize(new java.awt.Dimension(500, 270));
        jPanelCuerpo.setOpaque(false);
        jPanelCuerpo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelListaFechaPedido.setOpaque(false);
        jPanelListaFechaPedido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(200, 45));

        jListFechaPedido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListFechaPedidoFocusGained(evt);
            }
        });
        jListFechaPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListFechaPedidoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jListFechaPedido);

        jPanelListaFechaPedido.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 45));

        jPanelCuerpo.add(jPanelListaFechaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 118, 200, 45));

        jPanelListaIuMarcaCris.setOpaque(false);
        jPanelListaIuMarcaCris.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(200, 45));

        jListMarcaCristal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListMarcaCristalFocusGained(evt);
            }
        });
        jListMarcaCristal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListMarcaCristalMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListMarcaCristal);

        jPanelListaIuMarcaCris.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 45));

        jPanelCuerpo.add(jPanelListaIuMarcaCris, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 66, 200, 45));

        jLabelTituloFechaPedido.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloFechaPedido.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloFechaPedido.setText("Fecha pedido:");
        jLabelTituloFechaPedido.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloFechaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 98, -1, 25));

        jTextFieldFechaPedido.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldFechaPedido.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldFechaPedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldFechaPedido.setToolTipText("Ingrese solo alfanumericos y simbolos(-) o (.). Ej.: b-m.w");
        jTextFieldFechaPedido.setBorder(null);
        jTextFieldFechaPedido.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaPedido.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaPedido.setOpaque(false);
        jTextFieldFechaPedido.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaPedido.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldFechaPedido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldFechaPedidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldFechaPedidoFocusLost(evt);
            }
        });
        jTextFieldFechaPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldFechaPedidoKeyReleased(evt);
            }
        });
        jPanelCuerpo.add(jTextFieldFechaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 118, 200, 20));

        jSeparatorFechaPedido.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorFechaPedido.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorFechaPedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorFechaPedido.setOpaque(true);
        jPanelCuerpo.add(jSeparatorFechaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 138, 200, -1));

        jSeparatorIuMarcaCris.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuMarcaCris.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuMarcaCris.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuMarcaCris.setOpaque(true);
        jPanelCuerpo.add(jSeparatorIuMarcaCris, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 66, 200, -1));

        jLabelTituloIuMarcaCris.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuMarcaCris.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuMarcaCris.setText("Marca Cristal:");
        jLabelTituloIuMarcaCris.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloIuMarcaCris, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 25, -1, 25));

        jTextFieldIuMarcaCris.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuMarcaCris.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuMarcaCris.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuMarcaCris.setToolTipText("Ingrese solo numeros. Ej.: 08");
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
        jPanelCuerpo.add(jTextFieldIuMarcaCris, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 45, 200, 20));

        jButtonGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonGenerarPedido100x25Off.png"))); // NOI18N
        jButtonGenerarReporte.setToolTipText("Has click para editar.");
        jButtonGenerarReporte.setBorder(null);
        jButtonGenerarReporte.setBorderPainted(false);
        jButtonGenerarReporte.setContentAreaFilled(false);
        jButtonGenerarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGenerarReporte.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonGenerarPedido100x25Off.png"))); // NOI18N
        jButtonGenerarReporte.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonGenerarPedido100x25On.png"))); // NOI18N
        jButtonGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarReporteActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 176, -1, -1));

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
        jLabelTituloVentana.setText("Generador de Pedido");
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
    
// limpia los jtextfield usados
    public void limpiarCampos(){

        jTextFieldIuMarcaCris.setText("");
        jTextFieldFechaPedido.setText(""); 
        }

    
  
// visualiza panel  ventana cerrar
    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed

        jPanelCuerpo.setBounds(-500, 30, 500, 270);
        jPanelMensajeCerrar.setBounds( 225,100,  250, 100);
        
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

//valida datos y edita un registro en tabla marcavehiculo 
    private void jButtonGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarReporteActionPerformed
            
        if(jTextFieldFechaPedido.getText().length()!=0 && jTextFieldIuMarcaCris.getText().length()!=0){
        
             _conectarSql = getConection();
            try {
                
                
                
                String path = "C:/CondorGestion/reportes/Pedidos.jrxml";
                
                JasperReport jr = JasperCompileManager.compileReport(path);
                
                int aux = Integer.parseInt(_administradorMarcasCristales.obtenerIuMarcaCris(jTextFieldIuMarcaCris.getText()));
                
                 HashMap <String, Object> mapa = new HashMap <String, Object> ();
                 mapa.put("fechaPedido",jTextFieldFechaPedido.getText());
                 mapa.put("marcaCristal", aux);
                 
                JasperPrint jp = JasperFillManager.fillReport(jr, mapa, _conectarSql);
                JasperViewer viewer = new JasperViewer(jp, false);
                viewer.setTitle("Reporte de Pedidos");
                viewer.setVisible(true);

            } catch (JRException ex ) {
                Logger.getLogger(JFrameRegistroGeneradorPedido.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
JOptionPane.showMessageDialog(this, ex);
            }
           
        }
    }//GEN-LAST:event_jButtonGenerarReporteActionPerformed

    private void jListMarcaCristalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListMarcaCristalFocusGained

        jPanelListaIuMarcaCris.setBounds(150, 66, 200, 50);
    }//GEN-LAST:event_jListMarcaCristalFocusGained

    private void jListMarcaCristalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListMarcaCristalMouseClicked
        int indexList = jListMarcaCristal.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList2 = true;
            jTextFieldIuMarcaCris.setText("");
            jTextFieldIuMarcaCris.setText(jListMarcaCristal.getSelectedValue());
            jPanelListaIuMarcaCris.setBounds(-300, 66, 200, 50);
        } else{
            auxSeleccionList2 = false;
        }
    }//GEN-LAST:event_jListMarcaCristalMouseClicked

    private void jListFechaPedidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListFechaPedidoFocusGained
        
        jPanelListaFechaPedido.setBounds(150, 138, 200, 50);
    }//GEN-LAST:event_jListFechaPedidoFocusGained

    private void jListFechaPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListFechaPedidoMouseClicked
            int indexList = jListFechaPedido.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList = true;
            jTextFieldFechaPedido.setText("");
            jTextFieldFechaPedido.setText(jListFechaPedido.getSelectedValue());
            jPanelListaFechaPedido.setBounds(-300, 138, 200, 50);
        } else{
            auxSeleccionList = false;
        }
    }//GEN-LAST:event_jListFechaPedidoMouseClicked

    private void jTextFieldIuMarcaCrisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuMarcaCrisFocusGained
        
        jListMarcaCristal.setModel(_administradorMarcasCristales.cargarLista(jTextFieldIuMarcaCris.getText()));
        jPanelListaIuMarcaCris.setBounds(150, 66, 200, 50);
    }//GEN-LAST:event_jTextFieldIuMarcaCrisFocusGained

    private void jTextFieldIuMarcaCrisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuMarcaCrisFocusLost
       
        jPanelListaIuMarcaCris.setBounds(-260, 66, 200, 50);
    }//GEN-LAST:event_jTextFieldIuMarcaCrisFocusLost

    private void jTextFieldIuMarcaCrisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIuMarcaCrisKeyReleased
        
        jListMarcaCristal.setModel(_administradorMarcasCristales.cargarLista(jTextFieldIuMarcaCris.getText()));
        jPanelListaIuMarcaCris.setBounds(150, 66, 200, 50);
    }//GEN-LAST:event_jTextFieldIuMarcaCrisKeyReleased

    private void jTextFieldFechaPedidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldFechaPedidoFocusGained
          
        if(jTextFieldIuMarcaCris.getText().equalsIgnoreCase("")){
            
            jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.red));
            jPanelMarcaVacia.setBounds(225, 75, 250, 100);
        } else{
        
            jListFechaPedido.setModel(_administradorPedidos.cargarListaFecha(jTextFieldFechaPedido.getText() ,  Integer.parseInt(_administradorMarcasCristales.obtenerIuMarcaCris(jTextFieldIuMarcaCris.getText())) ));
            jPanelListaFechaPedido.setBounds(150, 138, 200, 50);
        } 
        
    }//GEN-LAST:event_jTextFieldFechaPedidoFocusGained

    private void jTextFieldFechaPedidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldFechaPedidoFocusLost
               
       
        jPanelListaFechaPedido.setBounds(-260, 138, 200, 50);
    }//GEN-LAST:event_jTextFieldFechaPedidoFocusLost

    private void jTextFieldFechaPedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFechaPedidoKeyReleased
         
        if(jTextFieldIuMarcaCris.getText().equalsIgnoreCase("")){
            
            jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.red));
            jPanelMarcaVacia.setBounds(225, 75, 250, 100);
        }  else{
        
            jListFechaPedido.setModel(_administradorPedidos.cargarListaFecha(jTextFieldFechaPedido.getText() ,  Integer.parseInt(_administradorMarcasCristales.obtenerIuMarcaCris(jTextFieldIuMarcaCris.getText())) ));
            jPanelListaFechaPedido.setBounds(150, 138, 200, 50);
        }
        
        jListFechaPedido.setModel(_administradorPedidos.cargarListaFecha(jTextFieldFechaPedido.getText() ,  Integer.parseInt(_administradorMarcasCristales.obtenerIuMarcaCris(jTextFieldIuMarcaCris.getText())) ));
        jPanelListaFechaPedido.setBounds(150, 138, 200, 50);
    }//GEN-LAST:event_jTextFieldFechaPedidoKeyReleased

    private void jButtonAceptarMarcaVaciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarMarcaVaciaActionPerformed

        jTextFieldIuMarcaCris.setBorder(null);
        jPanelMarcaVacia.setBounds(-260, 100, 250, 100);
    }//GEN-LAST:event_jButtonAceptarMarcaVaciaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAceptarMarcaVacia;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonGenerarReporte;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JLabel jLabelFondoIconoMarcaVacia;
    private javax.swing.JLabel jLabelFondoIconoMensajeCerrar;
    private javax.swing.JLabel jLabelIconoAlerta;
    private javax.swing.JLabel jLabelIconoBarraTitulo;
    private javax.swing.JLabel jLabelIconoErrorMarcaVacia;
    private javax.swing.JLabel jLabelIconoFondo;
    private javax.swing.JLabel jLabelIconoFondoCuerpo;
    private javax.swing.JLabel jLabelMensajeDos;
    private javax.swing.JLabel jLabelMensajeMarcaVacia;
    private javax.swing.JLabel jLabelMensajeUno;
    private javax.swing.JLabel jLabelTituloFechaPedido;
    private javax.swing.JLabel jLabelTituloIuMarcaCris;
    private javax.swing.JLabel jLabelTituloVentana;
    private javax.swing.JLabel jLabelToolKitMarca;
    private javax.swing.JList<String> jListFechaPedido;
    private javax.swing.JList<String> jListMarcaCristal;
    private javax.swing.JPanel jPanelBarraTitulo;
    private javax.swing.JPanel jPanelCuerpo;
    private javax.swing.JPanel jPanelListaFechaPedido;
    private javax.swing.JPanel jPanelListaIuMarcaCris;
    private javax.swing.JPanel jPanelMarcaVacia;
    private javax.swing.JPanel jPanelMensajeCerrar;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparatorFechaPedido;
    private javax.swing.JSeparator jSeparatorIuMarcaCris;
    private javax.swing.JTextField jTextFieldFechaPedido;
    private javax.swing.JTextField jTextFieldIuMarcaCris;
    // End of variables declaration//GEN-END:variables
}
