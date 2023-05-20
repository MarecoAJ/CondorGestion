/*
* este JFrame registra (agrega, borra, edita, busca y filtra) todos los servicios prestados
 */
package Vistas;

import administradorClases.Administrador;
import administradorClases.AdministradorTipoPagos;
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



public class JFrameRegistroGeneradorInformeVentas extends javax.swing.JFrame {

    private final Administrador _administrador;
    private final AdministradorTipoPagos _administradorTipoPagos;
    private boolean auxSeleccionList2;
    private boolean auxSeleccionList;
    private Connection _conectarSql;

    
    public JFrameRegistroGeneradorInformeVentas() {
        initComponents();
// se personaliza las fuentes de letra de los objetos grafico
        jLabelTituloVentana.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 8));
        
        jLabelTituloAñoFinal.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldAñoFinal.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloTipoPagos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldTipoPagos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelMensajeUno.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelMensajeDos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloMesInicio.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldMesInicio.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloAñoInicio.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldAñoInicio.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloMesFinal.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldMesFinal.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        
        _administrador = new Administrador();
        _administradorTipoPagos = new AdministradorTipoPagos();
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
        jPanelMesVacio = new javax.swing.JPanel();
        jButtonAceptarMesVacio = new javax.swing.JButton();
        jLabelIconoErrorMesVacio = new javax.swing.JLabel();
        jLabelMensajeMesVacio = new javax.swing.JLabel();
        jLabelFondoIconoMesVacio = new javax.swing.JLabel();
        jPanelCuerpo = new javax.swing.JPanel();
        jPanelListaMesInicio = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListMesInicio = new javax.swing.JList<>();
        jPanelListaAñoInicio = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListAñoInicio = new javax.swing.JList<>();
        jPanelListaMesFin = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListMesFin = new javax.swing.JList<>();
        jPanelListaAñoFin = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListAñoFin = new javax.swing.JList<>();
        jPanelListaTipoPago = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListTipoPago = new javax.swing.JList<>();
        jTextFieldAñoInicio = new javax.swing.JTextField();
        jSeparatorAñoInicio = new javax.swing.JSeparator();
        jLabelTituloAñoInicio = new javax.swing.JLabel();
        jSeparatorMesInicio = new javax.swing.JSeparator();
        jTextFieldMesInicio = new javax.swing.JTextField();
        jLabelTituloMesInicio = new javax.swing.JLabel();
        jLabelTituloMesFinal = new javax.swing.JLabel();
        jTextFieldMesFinal = new javax.swing.JTextField();
        jSeparatorMesFinal = new javax.swing.JSeparator();
        jLabelTituloAñoFinal = new javax.swing.JLabel();
        jTextFieldAñoFinal = new javax.swing.JTextField();
        jSeparatorAñoFinal = new javax.swing.JSeparator();
        jTextFieldTipoPagos = new javax.swing.JTextField();
        jSeparatorTipoPagos = new javax.swing.JSeparator();
        jLabelTituloTipoPagos = new javax.swing.JLabel();
        jButtonGenerarInforme = new javax.swing.JButton();
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

        jPanelMesVacio.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelMesVacio.setOpaque(false);
        jPanelMesVacio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarMesVacio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarMesVacio.setToolTipText("Has click para continuar.");
        jButtonAceptarMesVacio.setBorder(null);
        jButtonAceptarMesVacio.setBorderPainted(false);
        jButtonAceptarMesVacio.setContentAreaFilled(false);
        jButtonAceptarMesVacio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarMesVacio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarMesVacio.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarMesVacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarMesVacioActionPerformed(evt);
            }
        });
        jPanelMesVacio.add(jButtonAceptarMesVacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorMesVacio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelMesVacio.add(jLabelIconoErrorMesVacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeMesVacio.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeMesVacio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeMesVacio.setText("No selecciono algun item.");
        jPanelMesVacio.add(jLabelMensajeMesVacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 20, 200, 25));

        jLabelFondoIconoMesVacio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelMesVacio.add(jLabelFondoIconoMesVacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        getContentPane().add(jPanelMesVacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 100, 250, 100));

        jPanelCuerpo.setMaximumSize(new java.awt.Dimension(500, 301));
        jPanelCuerpo.setMinimumSize(new java.awt.Dimension(500, 301));
        jPanelCuerpo.setOpaque(false);
        jPanelCuerpo.setPreferredSize(new java.awt.Dimension(500, 301));
        jPanelCuerpo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelListaMesInicio.setOpaque(false);
        jPanelListaMesInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(200, 45));

        jListMesInicio.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListMesInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListMesInicioFocusGained(evt);
            }
        });
        jListMesInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListMesInicioMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListMesInicio);

        jPanelListaMesInicio.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 45));

        jPanelCuerpo.add(jPanelListaMesInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 73, 100, 45));

        jPanelListaAñoInicio.setOpaque(false);
        jPanelListaAñoInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(200, 45));

        jListAñoInicio.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListAñoInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListAñoInicioFocusGained(evt);
            }
        });
        jListAñoInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAñoInicioMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jListAñoInicio);

        jPanelListaAñoInicio.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 45));

        jPanelCuerpo.add(jPanelListaAñoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 73, 100, 45));

        jPanelListaMesFin.setOpaque(false);
        jPanelListaMesFin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane7.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane7.setPreferredSize(new java.awt.Dimension(200, 45));

        jListMesFin.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListMesFin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListMesFinFocusGained(evt);
            }
        });
        jListMesFin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListMesFinMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jListMesFin);

        jPanelListaMesFin.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 45));

        jPanelCuerpo.add(jPanelListaMesFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 145, 100, 45));

        jPanelListaAñoFin.setOpaque(false);
        jPanelListaAñoFin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane6.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane6.setPreferredSize(new java.awt.Dimension(200, 45));

        jListAñoFin.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListAñoFin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListAñoFinFocusGained(evt);
            }
        });
        jListAñoFin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAñoFinMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jListAñoFin);

        jPanelListaAñoFin.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 45));

        jPanelCuerpo.add(jPanelListaAñoFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 145, 200, 45));

        jPanelListaTipoPago.setOpaque(false);
        jPanelListaTipoPago.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane5.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane5.setPreferredSize(new java.awt.Dimension(200, 45));

        jListTipoPago.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
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
        jScrollPane5.setViewportView(jListTipoPago);

        jPanelListaTipoPago.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 45));

        jPanelCuerpo.add(jPanelListaTipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 216, 200, 45));

        jTextFieldAñoInicio.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldAñoInicio.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldAñoInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAñoInicio.setToolTipText("Ingrese solo texto. Ej.: sellado");
        jTextFieldAñoInicio.setBorder(null);
        jTextFieldAñoInicio.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldAñoInicio.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldAñoInicio.setOpaque(false);
        jTextFieldAñoInicio.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldAñoInicio.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldAñoInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldAñoInicioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldAñoInicioFocusLost(evt);
            }
        });
        jTextFieldAñoInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldAñoInicioKeyReleased(evt);
            }
        });
        jPanelCuerpo.add(jTextFieldAñoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 53, 100, 20));

        jSeparatorAñoInicio.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorAñoInicio.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorAñoInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorAñoInicio.setOpaque(true);
        jPanelCuerpo.add(jSeparatorAñoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 73, 100, -1));

        jLabelTituloAñoInicio.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloAñoInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloAñoInicio.setText("Año de Incio:");
        jLabelTituloAñoInicio.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloAñoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 33, -1, 25));

        jSeparatorMesInicio.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorMesInicio.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorMesInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorMesInicio.setOpaque(true);
        jPanelCuerpo.add(jSeparatorMesInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 73, 100, -1));

        jTextFieldMesInicio.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldMesInicio.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldMesInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldMesInicio.setToolTipText("Ingrese solo texto. Ej.: sellado");
        jTextFieldMesInicio.setBorder(null);
        jTextFieldMesInicio.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldMesInicio.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldMesInicio.setOpaque(false);
        jTextFieldMesInicio.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldMesInicio.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldMesInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldMesInicioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldMesInicioFocusLost(evt);
            }
        });
        jTextFieldMesInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldMesInicioKeyReleased(evt);
            }
        });
        jPanelCuerpo.add(jTextFieldMesInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 53, 100, 20));

        jLabelTituloMesInicio.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloMesInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloMesInicio.setText("Mes de inicio:");
        jLabelTituloMesInicio.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloMesInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 33, -1, 25));

        jLabelTituloMesFinal.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloMesFinal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloMesFinal.setText("Mes de fin:");
        jLabelTituloMesFinal.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloMesFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 105, -1, 25));

        jTextFieldMesFinal.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldMesFinal.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldMesFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldMesFinal.setToolTipText("Ingrese solo texto. Ej.: sellado");
        jTextFieldMesFinal.setBorder(null);
        jTextFieldMesFinal.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldMesFinal.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldMesFinal.setOpaque(false);
        jTextFieldMesFinal.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldMesFinal.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldMesFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldMesFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldMesFinalFocusLost(evt);
            }
        });
        jTextFieldMesFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldMesFinalKeyReleased(evt);
            }
        });
        jPanelCuerpo.add(jTextFieldMesFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 125, 100, 20));

        jSeparatorMesFinal.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorMesFinal.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorMesFinal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorMesFinal.setOpaque(true);
        jPanelCuerpo.add(jSeparatorMesFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 145, 100, -1));

        jLabelTituloAñoFinal.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloAñoFinal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloAñoFinal.setText("Año de fin:");
        jLabelTituloAñoFinal.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloAñoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 105, -1, 25));

        jTextFieldAñoFinal.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldAñoFinal.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldAñoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAñoFinal.setToolTipText("Ingrese solo texto. Ej.: sellado");
        jTextFieldAñoFinal.setBorder(null);
        jTextFieldAñoFinal.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldAñoFinal.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldAñoFinal.setOpaque(false);
        jTextFieldAñoFinal.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldAñoFinal.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldAñoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldAñoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldAñoFinalFocusLost(evt);
            }
        });
        jTextFieldAñoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldAñoFinalKeyReleased(evt);
            }
        });
        jPanelCuerpo.add(jTextFieldAñoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 125, 100, 20));

        jSeparatorAñoFinal.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorAñoFinal.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorAñoFinal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorAñoFinal.setOpaque(true);
        jPanelCuerpo.add(jSeparatorAñoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 145, 100, -1));

        jTextFieldTipoPagos.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldTipoPagos.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldTipoPagos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTipoPagos.setToolTipText("Ingrese solo decimales. Ej.: 3456.00");
        jTextFieldTipoPagos.setBorder(null);
        jTextFieldTipoPagos.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldTipoPagos.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldTipoPagos.setOpaque(false);
        jTextFieldTipoPagos.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldTipoPagos.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldTipoPagos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldTipoPagosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldTipoPagosFocusLost(evt);
            }
        });
        jTextFieldTipoPagos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTipoPagosKeyReleased(evt);
            }
        });
        jPanelCuerpo.add(jTextFieldTipoPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 196, 200, 20));

        jSeparatorTipoPagos.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorTipoPagos.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorTipoPagos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorTipoPagos.setOpaque(true);
        jPanelCuerpo.add(jSeparatorTipoPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 216, 200, -1));

        jLabelTituloTipoPagos.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloTipoPagos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloTipoPagos.setText("Tipo de pago:");
        jLabelTituloTipoPagos.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloTipoPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 176, -1, 25));

        jButtonGenerarInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonGenerarInforme100x25Off.jpg"))); // NOI18N
        jButtonGenerarInforme.setToolTipText("Has click para editar.");
        jButtonGenerarInforme.setBorder(null);
        jButtonGenerarInforme.setBorderPainted(false);
        jButtonGenerarInforme.setContentAreaFilled(false);
        jButtonGenerarInforme.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGenerarInforme.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonGenerarInforme100x25Off.jpg"))); // NOI18N
        jButtonGenerarInforme.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonGenerarInforme100x25On.jpg"))); // NOI18N
        jButtonGenerarInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarInformeActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonGenerarInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 251, -1, -1));

        jLabelIconoFondoCuerpo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondoCuerpo500x301.png"))); // NOI18N
        jPanelCuerpo.add(jLabelIconoFondoCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanelCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 500, 301));

        jPanelBarraTitulo.setMaximumSize(new java.awt.Dimension(700, 30));
        jPanelBarraTitulo.setMinimumSize(new java.awt.Dimension(700, 30));
        jPanelBarraTitulo.setOpaque(false);
        jPanelBarraTitulo.setPreferredSize(new java.awt.Dimension(700, 30));
        jPanelBarraTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTituloVentana.setFont(new java.awt.Font("Open Sans Extrabold", 0, 11)); // NOI18N
        jLabelTituloVentana.setForeground(new java.awt.Color(245, 245, 245));
        jLabelTituloVentana.setText("Generador de ventas");
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
 
    public void validarTipoPago(){
        if(_administradorTipoPagos.obtenerIuTipoPago(jTextFieldTipoPagos.getText()).length()==0){
            auxSeleccionList = false;
        } else{
            auxSeleccionList = true;
        }
    }
  
// visualiza panel  ventana cerrar
    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed

        jPanelCuerpo.setBounds(-500, 30, 500, 301);
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
        jPanelCuerpo.setBounds( 100,30,  500, 301);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

//valida datos y edita un registro en tabla serviciosPrestados
    private void jButtonGenerarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarInformeActionPerformed

        
        jButtonGenerarInforme.setEnabled(false); 
        jTextFieldAñoFinal.setEditable(false);
        jTextFieldTipoPagos.setEditable(false);
        jTextFieldAñoInicio.setEditable(false);
        jTextFieldMesFinal.setEditable(false);
        jTextFieldMesInicio.setEditable(false);
        
        if(jTextFieldMesInicio.getText().length()!=0 && jTextFieldMesFinal.getText().length()!=0 &&
           jTextFieldAñoInicio.getText().length()!=0 && jTextFieldAñoFinal.getText().length()!=0 && 
           jTextFieldTipoPagos.getText().length()!=0){

             _conectarSql = getConection();
             
            try {
                
                
                
                String path = "C:/CondorGestion/reportes/Ventas.jrxml";
                
                JasperReport jr = JasperCompileManager.compileReport(path);
                
                 HashMap <String, Object> mapa = new HashMap <String, Object> ();
                 mapa = new HashMap<>();
                 mapa.put("TipoPago", Integer.parseInt( _administradorTipoPagos.obtenerIuTipoPago(jTextFieldTipoPagos.getText())));
                 mapa.put("FecIni", jTextFieldAñoInicio.getText() + "-" + _administrador.obtenerNumMes(jTextFieldMesInicio.getText()) +"-01 00:00:00" );
                 mapa.put("FecFin", jTextFieldAñoFinal.getText() + "-" + _administrador.obtenerNumMes(jTextFieldMesFinal.getText()) +"-01 00:00:00");
                 
                JasperPrint jp = JasperFillManager.fillReport(jr, mapa, _conectarSql);
                JasperViewer viewer = new JasperViewer(jp, false);
                viewer.setTitle("Reporte de Ventas");
                viewer.setVisible(true);

            } catch (JRException ex ) {
                Logger.getLogger(JFrameRegistroGeneradorPedido.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
                JOptionPane.showMessageDialog(this, ex);
            }
   
        } else{
        
            jPanelMesVacio.setBounds(225, 115, 250, 100);
        }
        
                jButtonGenerarInforme.setEnabled(true); 
                jTextFieldAñoFinal.setEnabled(true);
                jTextFieldTipoPagos.setEnabled(true);
                jTextFieldAñoInicio.setEnabled(true);
                jTextFieldMesFinal.setEnabled(true);
                jTextFieldMesInicio.setEnabled(true);
                
                jTextFieldMesInicio.setBorder(null);
                jTextFieldMesFinal.setBorder(null);
                jTextFieldAñoFinal.setBorder(null);
                jTextFieldAñoInicio.setBorder(null);
                jTextFieldTipoPagos.setBorder(null);
    }//GEN-LAST:event_jButtonGenerarInformeActionPerformed

    private void jButtonAceptarMesVacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarMesVacioActionPerformed

        jTextFieldAñoFinal.setBorder(null);
        jTextFieldMesInicio.setBorder(null);
        jTextFieldAñoInicio.setBorder(null);
        jTextFieldMesFinal.setBorder(null);
        jButtonGenerarInforme.setEnabled(true);
        jPanelMesVacio.setBounds(-260, 100, 250, 100);
    }//GEN-LAST:event_jButtonAceptarMesVacioActionPerformed

    private void jListAñoInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListAñoInicioFocusGained

        jPanelListaAñoInicio.setBounds(300, 73, 100, 50);
    }//GEN-LAST:event_jListAñoInicioFocusGained

    private void jListAñoInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListAñoInicioMouseClicked
        int indexList = jListAñoInicio.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList = true;
            jTextFieldAñoInicio.setText("");
            jTextFieldAñoInicio.setText(jListAñoInicio.getSelectedValue());
            jPanelListaAñoInicio.setBounds(-300, 145, 200, 50);
        } else{
            auxSeleccionList = false;
        }
    }//GEN-LAST:event_jListAñoInicioMouseClicked

    private void jListMesInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListMesInicioFocusGained

        jPanelListaMesInicio.setBounds(115, 73, 100, 50);
    }//GEN-LAST:event_jListMesInicioFocusGained

    private void jListMesInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListMesInicioMouseClicked
        int indexList = jListMesInicio.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList2 = true;
            jTextFieldMesInicio.setText("");
            jTextFieldMesInicio.setText(jListMesInicio.getSelectedValue());
            jPanelListaMesInicio.setBounds(-300, 73, 100, 50);
        } else{
            auxSeleccionList2 = false;
        }
    }//GEN-LAST:event_jListMesInicioMouseClicked

    private void jListTipoPagoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListTipoPagoFocusGained

        jPanelListaTipoPago.setBounds(150,216, 200, 50); 
    }//GEN-LAST:event_jListTipoPagoFocusGained

    private void jListTipoPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTipoPagoMouseClicked
        int indexList = jListTipoPago.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList2 = true;
            jTextFieldTipoPagos.setText("");
            jTextFieldTipoPagos.setText(jListTipoPago.getSelectedValue());
            jPanelListaTipoPago.setBounds(-300, 216, 200, 50);
        } else{
            auxSeleccionList2 = false;
        }
        
    }//GEN-LAST:event_jListTipoPagoMouseClicked

    private void jTextFieldMesInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldMesInicioFocusGained
                     
        jListMesInicio.setModel(_administrador.cargarListaMeses(jTextFieldMesInicio.getText()));
        jPanelListaMesInicio.setBounds(115, 73, 100, 50);
    }//GEN-LAST:event_jTextFieldMesInicioFocusGained

    private void jTextFieldMesInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldMesInicioFocusLost
               
        jPanelListaMesInicio.setBounds(-260, 73,100, 50);
    }//GEN-LAST:event_jTextFieldMesInicioFocusLost

    private void jTextFieldMesInicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMesInicioKeyReleased
                
        jListMesInicio.setModel(_administrador.cargarListaMeses(jTextFieldMesInicio.getText()));
        jPanelListaMesInicio.setBounds(115, 73, 100, 50);
    }//GEN-LAST:event_jTextFieldMesInicioKeyReleased

    private void jTextFieldAñoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAñoFinalFocusGained
       
        if(jTextFieldMesFinal.getText().equalsIgnoreCase("")){
            
            jTextFieldMesFinal.setBorder(new LineBorder(Color.red));
            jPanelMesVacio.setBounds(225, 75, 250, 100);
        } else{
            
            jListAñoFin.setModel(_administrador.cargarListaAños(jTextFieldAñoFinal.getText())); 
            jPanelListaAñoFin.setBounds(300, 145, 100, 50);
        } 
      
    }//GEN-LAST:event_jTextFieldAñoFinalFocusGained

    private void jTextFieldAñoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAñoFinalFocusLost
                 
        jPanelListaAñoFin.setBounds(-260, 145, 100, 50);
    }//GEN-LAST:event_jTextFieldAñoFinalFocusLost

    private void jTextFieldAñoFinalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAñoFinalKeyReleased
         
        if(jTextFieldMesFinal.getText().equalsIgnoreCase("")){
            
            jTextFieldMesFinal.setBorder(new LineBorder(Color.red));
            jPanelMesVacio.setBounds(225, 75, 250, 100);
        }  else{
        
            jListAñoFin.setModel(_administrador.cargarListaAños(jTextFieldAñoFinal.getText()));
            jPanelListaAñoFin.setBounds(300, 145, 200, 50);
        }
        
        jListAñoFin.setModel(_administrador.cargarListaAños(jTextFieldAñoFinal.getText()));
        jPanelListaAñoFin.setBounds(300, 145, 200, 50);        
    }//GEN-LAST:event_jTextFieldAñoFinalKeyReleased

    private void jTextFieldTipoPagosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTipoPagosFocusGained
       
        if(jTextFieldMesFinal.getText().equalsIgnoreCase("") || jTextFieldAñoFinal.getText().equalsIgnoreCase("") ){
            
            if(jTextFieldMesFinal.getText().equalsIgnoreCase("")){
            
                 jTextFieldMesFinal.setBorder(new LineBorder(Color.red));
            } else{
            
                jTextFieldAñoFinal.setBorder(new LineBorder(Color.red));
            }
            jPanelMesVacio.setBounds(225, 75, 250, 100);
            
        } else{
            
            jListTipoPago.setModel(_administradorTipoPagos.cargarLista(jTextFieldTipoPagos.getText())); 
            jPanelListaTipoPago.setBounds(150, 216, 200, 50);
        } 
    }//GEN-LAST:event_jTextFieldTipoPagosFocusGained

    private void jTextFieldTipoPagosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTipoPagosFocusLost
                 
        jPanelListaTipoPago.setBounds(-260, 216, 200, 50);
    }//GEN-LAST:event_jTextFieldTipoPagosFocusLost

    private void jTextFieldTipoPagosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTipoPagosKeyReleased
         
        if(jTextFieldMesFinal.getText().equalsIgnoreCase("") && jTextFieldAñoFinal.getText().equalsIgnoreCase("")){
            
            jTextFieldMesFinal.setBorder(new LineBorder(Color.red));
            jTextFieldAñoFinal.setBorder(new LineBorder(Color.red));
            jPanelMesVacio.setBounds(225, 75, 250, 100);
        }  else{
        
            jListTipoPago.setModel(_administradorTipoPagos.cargarLista(jTextFieldTipoPagos.getText()));
            jPanelListaTipoPago.setBounds(150, 216, 200, 50);
        }
        
        jListTipoPago.setModel(_administradorTipoPagos.cargarLista(jTextFieldTipoPagos.getText()));
        jPanelListaTipoPago.setBounds(150, 216, 200, 50);  
    }//GEN-LAST:event_jTextFieldTipoPagosKeyReleased

    private void jTextFieldAñoInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAñoInicioFocusGained
               
        if(jTextFieldMesInicio.getText().equalsIgnoreCase("")){
            
            jTextFieldMesInicio.setBorder(new LineBorder(Color.red));
            jPanelMesVacio.setBounds(225, 75, 250, 100);
        } else{
            
            jListAñoInicio.setModel(_administrador.cargarListaAños(jTextFieldAñoInicio.getText())); 
            jPanelListaAñoInicio.setBounds(300, 73, 100, 50);
        } 
      
    }//GEN-LAST:event_jTextFieldAñoInicioFocusGained

    private void jTextFieldAñoInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAñoInicioFocusLost
                 
        jPanelListaAñoInicio.setBounds(-260, 145, 100, 50);
    }//GEN-LAST:event_jTextFieldAñoInicioFocusLost

    private void jTextFieldAñoInicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAñoInicioKeyReleased
         
        if(jTextFieldMesInicio.getText().equalsIgnoreCase("")){
            
            jTextFieldMesInicio.setBorder(new LineBorder(Color.red));
            jPanelMesVacio.setBounds(225, 75, 250, 100);
        }  else{
        
            jListAñoInicio.setModel(_administrador.cargarListaAños(jTextFieldAñoInicio.getText()));
            jPanelListaAñoInicio.setBounds(300, 73, 100, 50);
        }
        
        jListAñoInicio.setModel(_administrador.cargarListaAños(jTextFieldAñoInicio.getText()));
        jPanelListaAñoInicio.setBounds(300, 73, 100, 50); 
    }//GEN-LAST:event_jTextFieldAñoInicioKeyReleased

    private void jTextFieldMesFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldMesFinalFocusGained
                       
        if(jTextFieldAñoInicio.getText().equalsIgnoreCase("")){
            
            jTextFieldAñoFinal.setBorder(new LineBorder(Color.red));
            jPanelMesVacio.setBounds(225, 75, 250, 100);
        } else{
            
            jListMesFin.setModel(_administrador.cargarListaMeses(jTextFieldMesFinal.getText())); 
            jPanelListaMesFin.setBounds(115, 145, 100, 50);
        } 
    }//GEN-LAST:event_jTextFieldMesFinalFocusGained

    private void jTextFieldMesFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldMesFinalFocusLost
                         
        jPanelListaMesFin.setBounds(-260, 145, 100, 50);
    }//GEN-LAST:event_jTextFieldMesFinalFocusLost

    private void jTextFieldMesFinalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMesFinalKeyReleased
                
        if(jTextFieldAñoInicio.getText().equalsIgnoreCase("")){
            
            jTextFieldAñoInicio.setBorder(new LineBorder(Color.red));
            jPanelMesVacio.setBounds(225, 75, 250, 100);
        }  else{
        
            jListMesFin.setModel(_administrador.cargarListaMeses(jTextFieldMesFinal.getText()));
            jPanelListaMesFin.setBounds(300, 145, 100, 50);
        }
        
        jListMesFin.setModel(_administrador.cargarListaMeses(jTextFieldMesFinal.getText()));
        jPanelListaMesFin.setBounds(300, 145, 100, 50); 
    }//GEN-LAST:event_jTextFieldMesFinalKeyReleased

    private void jListAñoFinFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListAñoFinFocusGained
        
        jPanelListaAñoFin.setBounds(300, 145, 100, 50);
    }//GEN-LAST:event_jListAñoFinFocusGained

    private void jListAñoFinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListAñoFinMouseClicked
        int indexList = jListAñoFin.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList = true;
            jTextFieldAñoFinal.setText("");
            jTextFieldAñoFinal.setText(jListAñoFin.getSelectedValue());
            jPanelListaAñoFin.setBounds(-300, 145, 100, 50);
        } else{
            auxSeleccionList = false;
        }
    }//GEN-LAST:event_jListAñoFinMouseClicked

    private void jListMesFinFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListMesFinFocusGained
        
        jPanelListaMesFin.setBounds(115, 145, 100, 50);
    }//GEN-LAST:event_jListMesFinFocusGained

    private void jListMesFinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListMesFinMouseClicked
        int indexList = jListMesFin.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList2 = true;
            jTextFieldMesFinal.setText("");
            jTextFieldMesFinal.setText(jListMesFin.getSelectedValue());
            jPanelListaMesFin.setBounds(-300, 145, 100, 50);
        } else{
            auxSeleccionList2 = false;
        }
    }//GEN-LAST:event_jListMesFinMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAceptarMesVacio;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonGenerarInforme;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JLabel jLabelFondoIconoMensajeCerrar;
    private javax.swing.JLabel jLabelFondoIconoMesVacio;
    private javax.swing.JLabel jLabelIconoAlerta;
    private javax.swing.JLabel jLabelIconoBarraTitulo;
    private javax.swing.JLabel jLabelIconoErrorMesVacio;
    private javax.swing.JLabel jLabelIconoFondo;
    private javax.swing.JLabel jLabelIconoFondoCuerpo;
    private javax.swing.JLabel jLabelMensajeDos;
    private javax.swing.JLabel jLabelMensajeMesVacio;
    private javax.swing.JLabel jLabelMensajeUno;
    private javax.swing.JLabel jLabelTituloAñoFinal;
    private javax.swing.JLabel jLabelTituloAñoInicio;
    private javax.swing.JLabel jLabelTituloMesFinal;
    private javax.swing.JLabel jLabelTituloMesInicio;
    private javax.swing.JLabel jLabelTituloTipoPagos;
    private javax.swing.JLabel jLabelTituloVentana;
    private javax.swing.JLabel jLabelToolKitMarca;
    private javax.swing.JList<String> jListAñoFin;
    private javax.swing.JList<String> jListAñoInicio;
    private javax.swing.JList<String> jListMesFin;
    private javax.swing.JList<String> jListMesInicio;
    private javax.swing.JList<String> jListTipoPago;
    private javax.swing.JPanel jPanelBarraTitulo;
    private javax.swing.JPanel jPanelCuerpo;
    private javax.swing.JPanel jPanelListaAñoFin;
    private javax.swing.JPanel jPanelListaAñoInicio;
    private javax.swing.JPanel jPanelListaMesFin;
    private javax.swing.JPanel jPanelListaMesInicio;
    private javax.swing.JPanel jPanelListaTipoPago;
    private javax.swing.JPanel jPanelMensajeCerrar;
    private javax.swing.JPanel jPanelMesVacio;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparatorAñoFinal;
    private javax.swing.JSeparator jSeparatorAñoInicio;
    private javax.swing.JSeparator jSeparatorMesFinal;
    private javax.swing.JSeparator jSeparatorMesInicio;
    private javax.swing.JSeparator jSeparatorTipoPagos;
    private javax.swing.JTextField jTextFieldAñoFinal;
    private javax.swing.JTextField jTextFieldAñoInicio;
    private javax.swing.JTextField jTextFieldMesFinal;
    private javax.swing.JTextField jTextFieldMesInicio;
    private javax.swing.JTextField jTextFieldTipoPagos;
    // End of variables declaration//GEN-END:variables
}
