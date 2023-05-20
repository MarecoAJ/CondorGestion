/*
* este JFrame registra (agrega, borra, edita, busca y filtra) el catalogo de cartera
*/
package Vistas;

import administradorClases.Administrador;
import administradorClases.AdministradorCartera;
import administradorClases.AdministradorContactoCartera;
import clasesDatos.ContactoCartera;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class JFrameRegistroContactoCartera extends javax.swing.JFrame {
// atributos y variables    
    private final AdministradorCartera _administradorCartera;
    private final AdministradorContactoCartera _administradorContactoCartera;
    private ContactoCartera _objContactoCartera;
    private TableModel modeloTablaCC;
    private int auxAbm;
    private boolean auxSeleccionList;
    private String auxListasIuCartera;
    
    public JFrameRegistroContactoCartera() {
        initComponents();
// se personaliza las fuentes de letra de los objetos grafico
        jLabelTituloVentana.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 8));
        jLabelTituloIuContactoCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldIuContactoCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jLabelTituloIuCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldIuCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloBuscarContactoCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldBuscarContactoCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloTelefonoContacto.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldTelefonoContacto.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloCelularContacto.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldCelularContacto.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
        jLabelTituloCorreoContacto.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldCorreoContacto.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 7));
                
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
        jTableContactoCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-ITALIC.otf", 0, 6));
        JTableHeader auxJTableHeader;
        auxJTableHeader = jTableContactoCartera.getTableHeader();
        auxJTableHeader.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
// se instancia la clase AdministradorTipoPagos y se inicializa el menu del jTable
        _administradorCartera = new AdministradorCartera();
        _administradorContactoCartera = new AdministradorContactoCartera();

        popupMenuJTable();
        
        jButtonEditarContactoCartera.setEnabled(false);
        jButtonBorrarContactoCartera.setEnabled(false);
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
        jSeparatorBuscarContactoCartera = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContactoCartera = new javax.swing.JTable();
        jLabelTituloBuscarContactoCartera = new javax.swing.JLabel();
        jTextFieldBuscarContactoCartera = new javax.swing.JTextField();
        jButtonTraerPanelCuerpo = new javax.swing.JButton();
        jLabelFondoVentanaBuscar = new javax.swing.JLabel();
        jPanelCuerpo = new javax.swing.JPanel();
        jPanelListaCartera = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListCartera = new javax.swing.JList<>();
        jLabelTituloCorreoContacto = new javax.swing.JLabel();
        jSeparatorCorreoContacto = new javax.swing.JSeparator();
        jTextFieldCorreoContacto = new javax.swing.JTextField();
        jLabelTituloCelularContacto = new javax.swing.JLabel();
        jSeparatorCelularContacto = new javax.swing.JSeparator();
        jTextFieldCelularContacto = new javax.swing.JTextField();
        jButtonRegCartera = new javax.swing.JButton();
        jTextFieldTelefonoContacto = new javax.swing.JTextField();
        jSeparatorTelefonoContacto = new javax.swing.JSeparator();
        jLabelTituloTelefonoContacto = new javax.swing.JLabel();
        jLabelTituloIuCartera = new javax.swing.JLabel();
        jTextFieldIuCartera = new javax.swing.JTextField();
        jSeparatorIuCartera = new javax.swing.JSeparator();
        jSeparatorIuContactoCartera = new javax.swing.JSeparator();
        jLabelTituloIuContactoCartera = new javax.swing.JLabel();
        jTextFieldIuContactoCartera = new javax.swing.JTextField();
        jButtonAgregarContactoCartera = new javax.swing.JButton();
        jButtonEditarContactoCartera = new javax.swing.JButton();
        jButtonBorrarContactoCartera = new javax.swing.JButton();
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

        jSeparatorBuscarContactoCartera.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorBuscarContactoCartera.setForeground(new java.awt.Color(0, 0, 0));
        jPanelVentanaBuscar.add(jSeparatorBuscarContactoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 55, 100, 2));

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(480, 302));

        jTableContactoCartera = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jTableContactoCartera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N° de reg.", "Dni o CUIT ", "Telefono", "Celular", "Correo electronico"
            }
        ));
        jTableContactoCartera.setToolTipText("Has click derecho para opciones.");
        jTableContactoCartera.setAutoscrolls(false);
        jTableContactoCartera.setFocusable(false);
        jTableContactoCartera.setMaximumSize(new java.awt.Dimension(480, 377));
        jTableContactoCartera.setMinimumSize(new java.awt.Dimension(480, 377));
        jTableContactoCartera.setPreferredSize(new java.awt.Dimension(480, 377));
        jTableContactoCartera.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jTableContactoCartera.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jTableContactoCartera.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableContactoCartera);

        jPanelVentanaBuscar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 680, 377));

        jLabelTituloBuscarContactoCartera.setText("Parametro de busqueda:");
        jPanelVentanaBuscar.add(jLabelTituloBuscarContactoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 10, -1, 25));

        jTextFieldBuscarContactoCartera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBuscarContactoCartera.setToolTipText("ingresa parametros de busqueda. Ej:  parab");
        jTextFieldBuscarContactoCartera.setBorder(null);
        jTextFieldBuscarContactoCartera.setDisabledTextColor(new java.awt.Color(194, 4, 48));
        jTextFieldBuscarContactoCartera.setOpaque(false);
        jTextFieldBuscarContactoCartera.setSelectionColor(new java.awt.Color(73, 73, 73));
        jTextFieldBuscarContactoCartera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarContactoCarteraKeyReleased(evt);
            }
        });
        jPanelVentanaBuscar.add(jTextFieldBuscarContactoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 35, 100, 20));

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

        jPanelListaCartera.setOpaque(false);
        jPanelListaCartera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(200, 45));

        jListCartera.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListCarteraFocusGained(evt);
            }
        });
        jListCartera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListCarteraMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jListCartera);

        jPanelListaCartera.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 45));

        jPanelCuerpo.add(jPanelListaCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 138, 200, 45));

        jLabelTituloCorreoContacto.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloCorreoContacto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloCorreoContacto.setText("Correo electronico:");
        jLabelTituloCorreoContacto.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloCorreoContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 250, -1, 25));

        jSeparatorCorreoContacto.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorCorreoContacto.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorCorreoContacto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorCorreoContacto.setOpaque(true);
        jPanelCuerpo.add(jSeparatorCorreoContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 295, 200, -1));

        jTextFieldCorreoContacto.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldCorreoContacto.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldCorreoContacto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCorreoContacto.setToolTipText("Ingrese alfanumericos y simbolos. Ej.: ale@mail.com");
        jTextFieldCorreoContacto.setBorder(null);
        jTextFieldCorreoContacto.setMaximumSize(new java.awt.Dimension(25, 200));
        jTextFieldCorreoContacto.setMinimumSize(new java.awt.Dimension(25, 200));
        jTextFieldCorreoContacto.setOpaque(false);
        jTextFieldCorreoContacto.setPreferredSize(new java.awt.Dimension(25, 200));
        jTextFieldCorreoContacto.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldCorreoContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 275, 200, 20));

        jLabelTituloCelularContacto.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloCelularContacto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloCelularContacto.setText("Telefono movil:");
        jLabelTituloCelularContacto.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloCelularContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 176, -1, 25));

        jSeparatorCelularContacto.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorCelularContacto.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorCelularContacto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorCelularContacto.setOpaque(true);
        jPanelCuerpo.add(jSeparatorCelularContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 216, 200, -1));

        jTextFieldCelularContacto.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldCelularContacto.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldCelularContacto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCelularContacto.setToolTipText("Ingrese solo numeros. Ej.: 371 45678777");
        jTextFieldCelularContacto.setBorder(null);
        jTextFieldCelularContacto.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldCelularContacto.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldCelularContacto.setOpaque(false);
        jTextFieldCelularContacto.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldCelularContacto.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldCelularContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 196, 200, 20));

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
        jPanelCuerpo.add(jButtonRegCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 113, -1, -1));

        jTextFieldTelefonoContacto.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldTelefonoContacto.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldTelefonoContacto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTelefonoContacto.setToolTipText("Ingrese solo numeros. Ej.: 011 43454647");
        jTextFieldTelefonoContacto.setBorder(null);
        jTextFieldTelefonoContacto.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldTelefonoContacto.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldTelefonoContacto.setOpaque(false);
        jTextFieldTelefonoContacto.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldTelefonoContacto.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldTelefonoContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 196, 200, 20));

        jSeparatorTelefonoContacto.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorTelefonoContacto.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorTelefonoContacto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorTelefonoContacto.setOpaque(true);
        jPanelCuerpo.add(jSeparatorTelefonoContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 216, 200, -1));

        jLabelTituloTelefonoContacto.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloTelefonoContacto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloTelefonoContacto.setText("Telefono fijo:");
        jLabelTituloTelefonoContacto.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloTelefonoContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 176, -1, 25));

        jLabelTituloIuCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuCartera.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuCartera.setText("Cartera:");
        jLabelTituloIuCartera.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloIuCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 98, -1, 25));

        jTextFieldIuCartera.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuCartera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuCartera.setToolTipText("Ingrese solo numeros. Ej.: 20 37082088 0");
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
        jPanelCuerpo.add(jTextFieldIuCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 118, 200, 20));

        jSeparatorIuCartera.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuCartera.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuCartera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuCartera.setOpaque(true);
        jPanelCuerpo.add(jSeparatorIuCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 138, 200, -1));

        jSeparatorIuContactoCartera.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuContactoCartera.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuContactoCartera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuContactoCartera.setOpaque(true);
        jPanelCuerpo.add(jSeparatorIuContactoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 66, 100, -1));

        jLabelTituloIuContactoCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuContactoCartera.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuContactoCartera.setText("Codigo identificacion:");
        jLabelTituloIuContactoCartera.setToolTipText("");
        jPanelCuerpo.add(jLabelTituloIuContactoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 25, -1, 25));

        jTextFieldIuContactoCartera.setEditable(false);
        jTextFieldIuContactoCartera.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuContactoCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuContactoCartera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuContactoCartera.setText("AUTOMATICO");
        jTextFieldIuContactoCartera.setToolTipText("");
        jTextFieldIuContactoCartera.setBorder(null);
        jTextFieldIuContactoCartera.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuContactoCartera.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuContactoCartera.setOpaque(false);
        jTextFieldIuContactoCartera.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuContactoCartera.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelCuerpo.add(jTextFieldIuContactoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 45, 100, 20));

        jButtonAgregarContactoCartera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOff.png"))); // NOI18N
        jButtonAgregarContactoCartera.setToolTipText("Has click para agregar.");
        jButtonAgregarContactoCartera.setBorder(null);
        jButtonAgregarContactoCartera.setBorderPainted(false);
        jButtonAgregarContactoCartera.setContentAreaFilled(false);
        jButtonAgregarContactoCartera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregarContactoCartera.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarContactoCartera.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarContactoCartera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarContactoCarteraActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonAgregarContactoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 407, -1, -1));

        jButtonEditarContactoCartera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOff.png"))); // NOI18N
        jButtonEditarContactoCartera.setToolTipText("Has click para editar.");
        jButtonEditarContactoCartera.setBorder(null);
        jButtonEditarContactoCartera.setBorderPainted(false);
        jButtonEditarContactoCartera.setContentAreaFilled(false);
        jButtonEditarContactoCartera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditarContactoCartera.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarContactoCartera.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarContactoCartera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarContactoCarteraActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonEditarContactoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 407, -1, -1));

        jButtonBorrarContactoCartera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOff.png"))); // NOI18N
        jButtonBorrarContactoCartera.setToolTipText("Has click para borrar.");
        jButtonBorrarContactoCartera.setBorder(null);
        jButtonBorrarContactoCartera.setBorderPainted(false);
        jButtonBorrarContactoCartera.setContentAreaFilled(false);
        jButtonBorrarContactoCartera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBorrarContactoCartera.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarContactoCartera.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarContactoCartera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarContactoCarteraActionPerformed(evt);
            }
        });
        jPanelCuerpo.add(jButtonBorrarContactoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 407, -1, -1));

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
        jLabelTituloVentana.setText("Registro  contacto de carteras");
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
    public void crearObjContactoCartera(){
     
        _objContactoCartera = new ContactoCartera();
        _objContactoCartera.setIuContactoCartera(Integer.parseInt(jTextFieldIuContactoCartera.getText()));
        _objContactoCartera.setIuCartera(_administradorCartera.obtenerIuCartera(jTextFieldIuCartera.getText()));
        _objContactoCartera.setTelefonoContacto(jTextFieldTelefonoContacto.getText());
        _objContactoCartera.setCelularContacto(jTextFieldCelularContacto.getText());
        _objContactoCartera.setCorreoContacto(jTextFieldCorreoContacto.getText());
    }

    
// valida iuTipoCartera en caso de no hacer cick en a lista
    public void validarIuCartera(){

        if(_administradorCartera.obtenerIuCartera(jTextFieldIuCartera.getText())==0){
            
            auxSeleccionList = false;
        } else{
            auxSeleccionList = true;
        }
    }

// limpia los jtextfield usados
    public void limpiarCampos(){

        jTextFieldIuContactoCartera.setText("AUTOMATICO");
        jTextFieldIuCartera.setText(""); 
        jTextFieldTelefonoContacto.setText("");
        jTextFieldCelularContacto.setText("");
        jTextFieldCorreoContacto.setText("");
        }
     
// este metodo crea menu de opciones al usar click secundario   
    public final void popupMenuJTable(){
//se crean las opciones del menu
        JPopupMenu jPopupMenuTableHCC = new JPopupMenu();
        JMenuItem jMenuItemEliminarContactoCartera = new JMenuItem("Eliminar"); // cambiar x ico 
        JMenuItem jMenuItemModificarContactoCartera = new JMenuItem("Modificar");
        JMenuItem jMenuOrdenar = new JMenu("Ordenar por");
        JMenuItem jMenuItemPrimerosAgregados = new JMenuItem("Primeros agregados");
        JMenuItem jMenuItemUltimosAgregados= new JMenuItem("Ultimos agregados");
        jMenuOrdenar.add(jMenuItemPrimerosAgregados);
        jMenuOrdenar.add(jMenuItemUltimosAgregados); 
// se generan las acciones de cada opcion
        jMenuItemEliminarContactoCartera.addActionListener((ActionEvent e) -> {
        
        if(seleccionarItemJTabla()!= -1){
                 
            jPanelVentanaBuscar.setBounds(-700, 30, 700, 457);
            jPanelCuerpo.setBounds( 100,30,  700, 457);
              
            jButtonAgregarContactoCartera.setEnabled(false);
            jButtonEditarContactoCartera.setEnabled(false);
            jTextFieldIuContactoCartera.setEditable(false);
            jTextFieldIuCartera.setEditable(false); 
            jTextFieldTelefonoContacto.setEditable(false);
            jTextFieldCelularContacto.setEditable(false);
            jTextFieldCorreoContacto.setEditable(false);
            jButtonRegCartera.setEnabled(false);
            jListCartera.setVisible(false);
            jButtonBorrarContactoCartera.setEnabled(true);
             }
         });
         
        jMenuItemModificarContactoCartera.addActionListener((ActionEvent e) -> {
            
        if(seleccionarItemJTabla()!= -1){
                     
            jPanelVentanaBuscar.setBounds(-700, 30, 700, 457);
            jPanelCuerpo.setBounds( 100,30,  700, 457);
                
            jButtonAgregarContactoCartera.setEnabled(false);
            jTextFieldIuContactoCartera.setEditable(false);
            jTextFieldIuCartera.setEditable(false); 
            jTextFieldTelefonoContacto.setEditable(true);
            jTextFieldCelularContacto.setEditable(true);
            jTextFieldCorreoContacto.setEditable(true);
            jButtonRegCartera.setEnabled(false);
            jListCartera.setVisible(false);
            jButtonBorrarContactoCartera.setEnabled(false);
            jButtonEditarContactoCartera.setEnabled(true);
        }
        });
             
        jMenuItemUltimosAgregados.addActionListener((ActionEvent e) -> {
            _administradorContactoCartera.ordenarTabla(jMenuItemUltimosAgregados.getText());
            jTableContactoCartera.setModel( _administradorContactoCartera.cargarJTabla());
        });
                                
        jMenuItemPrimerosAgregados.addActionListener((ActionEvent e) -> {
            _administradorContactoCartera.ordenarTabla(jMenuItemPrimerosAgregados.getText());
            jTableContactoCartera.setModel( _administradorContactoCartera.cargarJTabla());
        });
// se construye el menu completo y se le asigna si jTable
        jPopupMenuTableHCC.add(jMenuItemEliminarContactoCartera);
        jPopupMenuTableHCC.add(jMenuItemModificarContactoCartera);
        jPopupMenuTableHCC.add(jMenuOrdenar);
        jTableContactoCartera.setComponentPopupMenu(jPopupMenuTableHCC);  
     }
 
// se obtiene los datos del item seleccionado en la tabla
    public int seleccionarItemJTabla(){
// se obtiene el modelo y se verifica que se haya seleccionado un item   
        modeloTablaCC = jTableContactoCartera.getModel();
        int auxSeleccion = jTableContactoCartera.getSelectedRow();
        if (auxSeleccion != -1) {
            jTableContactoCartera.setEnabled(true);
// se cargan los campos con los valores selcionados
            jTextFieldIuContactoCartera.setText((String)modeloTablaCC.getValueAt(jTableContactoCartera.getSelectedRow(), 0));
            jTextFieldIuCartera.setText((String)modeloTablaCC.getValueAt(jTableContactoCartera.getSelectedRow(), 1));
            jTextFieldTelefonoContacto.setText((String)modeloTablaCC.getValueAt(jTableContactoCartera.getSelectedRow(),2));
            jTextFieldCelularContacto.setText((String)modeloTablaCC.getValueAt(jTableContactoCartera.getSelectedRow(), 3));
            jTextFieldCorreoContacto.setText((String)modeloTablaCC.getValueAt(jTableContactoCartera.getSelectedRow(), 4));
            return auxSeleccion;
            
        }else {
// si no selecciona mensaje error   
            jTableContactoCartera.setEnabled(false);
            jPanelItemNoSeleccionado.setBounds(325, 193, 250,100);
            return auxSeleccion;
        }
    }
    
//visualiza el panel buscar
    private void jButtonTraerPanelBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelBuscarActionPerformed
// llama al panel buscar 
    try {
        jTableContactoCartera.setModel(_administradorContactoCartera.cargarJTabla());
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
    private void jButtonAgregarContactoCarteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarContactoCarteraActionPerformed
       
        jPanelMensajeValidarABM.setBounds(325, 193, 250, 100);
        auxAbm = 1;
        jButtonAgregarContactoCartera.setEnabled(false);
        jButtonEditarContactoCartera.setEnabled(false);
        jButtonBorrarContactoCartera.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldIuContactoCartera.setEditable(false);
        jTextFieldIuCartera.setEditable(false);
        jTextFieldTelefonoContacto.setEditable(false);
        jTextFieldCelularContacto.setEditable(false);
        jTextFieldCorreoContacto.setEditable(false);
        jButtonRegCartera.setEnabled(false);
        jListCartera.setVisible(false);
    }//GEN-LAST:event_jButtonAgregarContactoCarteraActionPerformed

//valida datos y edita un registro en tabla TipoPagos
    private void jButtonEditarContactoCarteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarContactoCarteraActionPerformed
        
        jPanelMensajeValidarABM.setBounds(325, 193, 250, 100);
        auxAbm = 2;
        jButtonAgregarContactoCartera.setEnabled(false);
        jButtonEditarContactoCartera.setEnabled(false);
        jButtonBorrarContactoCartera.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldIuContactoCartera.setEditable(false);
        jTextFieldIuCartera.setEditable(false);
        jTextFieldTelefonoContacto.setEditable(false);
        jTextFieldCelularContacto.setEditable(false);
        jTextFieldCorreoContacto.setEditable(false);
        jButtonRegCartera.setEnabled(false);
        jListCartera.setVisible(false);
    }//GEN-LAST:event_jButtonEditarContactoCarteraActionPerformed

//valida datos y borra un registro en tabla TipoPagos 
    private void jButtonBorrarContactoCarteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarContactoCarteraActionPerformed
        
        jPanelMensajeValidarABM.setBounds(325, 193, 250, 100);
        auxAbm = 3;
        jButtonAgregarContactoCartera.setEnabled(false);
        jButtonEditarContactoCartera.setEnabled(false);
        jButtonBorrarContactoCartera.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldIuContactoCartera.setEditable(false);
        jTextFieldIuCartera.setEditable(false);
        jTextFieldTelefonoContacto.setEditable(false);
        jTextFieldCelularContacto.setEditable(false);
        jTextFieldCorreoContacto.setEditable(false);
        jButtonRegCartera.setEnabled(false);
        jListCartera.setVisible(false);
    }//GEN-LAST:event_jButtonBorrarContactoCarteraActionPerformed

// con cada tecleo valida los datos y elimina los no correctos
    private void jTextFieldBuscarContactoCarteraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarContactoCarteraKeyReleased
        boolean auxValidar = Administrador.validarCharDinamico(evt.getKeyChar(), "[a-zA-Z_0-9]||[\\s]");
    try {
        
        if(auxValidar==false){
               
            evt.consume();
            
            jTableContactoCartera.setModel(_administradorContactoCartera.buscarEnTabla(jTextFieldBuscarContactoCartera.getText()));
               
        } else{
           
            jTableContactoCartera.setModel(_administradorContactoCartera.buscarEnTabla(jTextFieldBuscarContactoCartera.getText()));
           }
    } catch (Exception e) {
        
        jPanelErrorBaseDeDatos.setBounds(325, 193, 250, 100);  
    }      
    }//GEN-LAST:event_jTextFieldBuscarContactoCarteraKeyReleased

//esconde el panel y habilita los obj en pantalla
    private void jButtonCancelarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarValidarCambiosActionPerformed
        
        auxAbm = 0;
        limpiarCampos();
        jPanelMensajeValidarABM.setBounds(-260, 193, 250, 100);
        jButtonAgregarContactoCartera.setEnabled(true);
        jButtonEditarContactoCartera.setEnabled(false);
        jButtonBorrarContactoCartera.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldIuCartera.setEditable(true);
        jTextFieldTelefonoContacto.setEditable(true);
        jTextFieldIuContactoCartera.setEditable(false);
        jTextFieldCelularContacto.setEditable(true);
        jTextFieldCorreoContacto.setEditable(true);
        jButtonRegCartera.setEnabled(true);
        jListCartera.setVisible(true);
        jPanelListaCartera.setVisible(true);
        jTextFieldIuCartera.setBorder(null);
        jTextFieldTelefonoContacto.setBorder(null);
        jTextFieldIuContactoCartera.setBorder(null);
        jTextFieldCelularContacto.setBorder(null);
        jTextFieldCorreoContacto.setBorder(null);
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
                
                validarIuCartera();
                
                listaVerdades[0] = auxSeleccionList;
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldTelefonoContacto.getText(), "\\d");
                listaVerdades[2] = Administrador.validarCamposTextos(jTextFieldCelularContacto.getText(), "\\d" );
                listaVerdades[3] = Administrador.validarCorreoE(jTextFieldCorreoContacto.getText());
                
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==4){
                    jTextFieldIuCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldTelefonoContacto.setBorder(new LineBorder(Color.green));
                    jTextFieldCelularContacto.setBorder(new LineBorder(Color.green));
                    jTextFieldCorreoContacto.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    
                    _objContactoCartera = new ContactoCartera();
                    _objContactoCartera.setIuContactoCartera(_administradorContactoCartera.generadorIuContactoCartera() + 1);
                    _objContactoCartera.setIuCartera(_administradorCartera.obtenerIuCartera(jTextFieldIuCartera.getText()));
                    _objContactoCartera.setTelefonoContacto(jTextFieldTelefonoContacto.getText());
                    _objContactoCartera.setCelularContacto(jTextFieldCelularContacto.getText());
                    _objContactoCartera.setCorreoContacto(jTextFieldCorreoContacto.getText());
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorContactoCartera.insertarTablaContactoCartera(_objContactoCartera)==true){
               
                            jPanelGuardadoExitoso.setBounds(325, 193, 250, 100);
                    
                    } else{
                        
                            jTextFieldIuCartera.setBorder(new LineBorder(Color.red));
                            
                            jPanelElementoExistente.setBounds(325, 193, 250, 100);
                            
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatos.setBounds(325, 193, 250, 100);
    }
                
                
                } else{
                    for (int i = 0; i < listaVerdades.length; i++) {
                        switch(i){
                            case 0:
                                if(listaVerdades[i]==true ){
                                    jTextFieldIuCartera.setBorder(new LineBorder(Color.green));
                                    
                                }else{
                                   
                                    jTextFieldIuCartera.setBorder(new LineBorder(Color.red));
                                    if(jTextFieldIuCartera.getText().length()==0 || auxSeleccionList==false){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;        
                            case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldTelefonoContacto.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldTelefonoContacto.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldCelularContacto.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCelularContacto.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldCorreoContacto.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCorreoContacto.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                        }
                    }
                    if(auxMensaje==1) jPanelElementoNoExistente.setBounds(325, 193, 250, 100);
                    if(auxMensaje2==1) jPanelGuardadoErroneo.setBounds(325, 193, 250, 100);
                    if(auxMensaje2==3) jPanelElementoExistente.setBounds(325, 193, 250, 100);
                }               
            break;
// se repite el mismo codigo solo que se edita un item de la db 
               
            case 2:
// se validan los datos
                validarIuCartera();
                listaVerdades[0] = auxSeleccionList;
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldTelefonoContacto.getText(), "\\d");
                listaVerdades[2] = Administrador.validarCamposTextos(jTextFieldCelularContacto.getText(), "\\d" );
                listaVerdades[3] = Administrador.validarCorreoE(jTextFieldCorreoContacto.getText());
                System.err.println("actua");
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==4){
                    
                    jTextFieldIuCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldIuContactoCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldTelefonoContacto.setBorder(new LineBorder(Color.green));
                    jTextFieldCelularContacto.setBorder(new LineBorder(Color.green));
                    jTextFieldCorreoContacto.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    crearObjContactoCartera();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorContactoCartera.actualizarTablaContactoCartera(_objContactoCartera)==true){
               
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
                                    jTextFieldIuContactoCartera.setBorder(new LineBorder(Color.green));
                                    jTextFieldIuCartera.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuCartera.setBorder(new LineBorder(Color.red));
                                    if(jTextFieldIuCartera.getText().length()==0 || auxSeleccionList==false){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;        
                            case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldTelefonoContacto.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldTelefonoContacto.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldCelularContacto.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCelularContacto.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldCorreoContacto.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCorreoContacto.setBorder(new LineBorder(Color.red));
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
               validarIuCartera();
                listaVerdades[0] = auxSeleccionList;
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldTelefonoContacto.getText(), "\\d");
                listaVerdades[2] = Administrador.validarCamposTextos(jTextFieldCelularContacto.getText(), "\\d" );
                listaVerdades[3] = Administrador.validarCorreoE(jTextFieldCorreoContacto.getText());
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==4){
                    jTextFieldIuContactoCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldTelefonoContacto.setBorder(new LineBorder(Color.green));
                    jTextFieldCelularContacto.setBorder(new LineBorder(Color.green));
                    jTextFieldCorreoContacto.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    crearObjContactoCartera();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorContactoCartera.eliminarTablaContactoCartera(_objContactoCartera)==true){
               
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
                                    jTextFieldIuCartera.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuCartera.setBorder(new LineBorder(Color.red));
                                    if(jTextFieldIuCartera.getText().length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;        
                            case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldTelefonoContacto.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldTelefonoContacto.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldCelularContacto.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCelularContacto.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldCorreoContacto.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCorreoContacto.setBorder(new LineBorder(Color.red));
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
        jTextFieldIuCartera.setBorder(null);
        jTextFieldTelefonoContacto.setBorder(null);
        jTextFieldIuContactoCartera.setBorder(null);
        jTextFieldCelularContacto.setBorder(null);
        jTextFieldCorreoContacto.setBorder(null);
        limpiarCampos();
        jButtonAgregarContactoCartera.setEnabled(true);
        jButtonEditarContactoCartera.setEnabled(false);
        jButtonBorrarContactoCartera.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldIuCartera.setEditable(true);
        jTextFieldTelefonoContacto.setEditable(true);
        jTextFieldIuContactoCartera.setEditable(false);
        jTextFieldCelularContacto.setEditable(true);
        jTextFieldCorreoContacto.setEditable(true);
        jButtonRegCartera.setEnabled(true);
        jListCartera.setVisible(true);
        jPanelListaCartera.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarGuardadoExitosoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarGuardadoErroneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoErroneoActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelGuardadoErroneo.setBounds(-260, 193, 250, 100);
                jButtonAgregarContactoCartera.setEnabled(true);
                jButtonEditarContactoCartera.setEnabled(false);
                jButtonBorrarContactoCartera.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuCartera.setEditable(true);
                jTextFieldTelefonoContacto.setEditable(true);
                jTextFieldIuContactoCartera.setEditable(false);
                jTextFieldCelularContacto.setEditable(true);
                jTextFieldCorreoContacto.setEditable(true);
                jButtonRegCartera.setEnabled(true);
                jListCartera.setVisible(true);
                jPanelListaCartera.setVisible(true);
            break;
            
            case 2:
                jPanelGuardadoErroneo.setBounds(-260, 193, 250, 100);
                jButtonAgregarContactoCartera.setEnabled(true);
                jButtonEditarContactoCartera.setEnabled(false);
                jButtonBorrarContactoCartera.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuCartera.setEditable(true);
                jTextFieldTelefonoContacto.setEditable(true);
                jTextFieldIuContactoCartera.setEditable(false);
                jTextFieldCelularContacto.setEditable(true);
                jTextFieldCorreoContacto.setEditable(true);
                jButtonRegCartera.setEnabled(false);
                jListCartera.setVisible(false);

            break;
            
            case 3: 
                jPanelGuardadoErroneo.setBounds(-260, 193, 250, 100);
                jButtonAgregarContactoCartera.setEnabled(true);
                jButtonEditarContactoCartera.setEnabled(false);
                jButtonBorrarContactoCartera.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuCartera.setEditable(true);
                jTextFieldTelefonoContacto.setEditable(true);
                jTextFieldIuContactoCartera.setEditable(false);
                jTextFieldCelularContacto.setEditable(true);
                jTextFieldCorreoContacto.setEditable(true);
                jButtonRegCartera.setEnabled(false);
                jListCartera.setVisible(false);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarGuardadoErroneoActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarErrorBaseDeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarErrorBaseDeDatosActionPerformed
        
        jPanelErrorBaseDeDatos.setBounds(-260, 193, 250, 100);
        jButtonAgregarContactoCartera.setEnabled(true);
        jButtonEditarContactoCartera.setEnabled(false);
        jButtonBorrarContactoCartera.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldIuCartera.setEditable(true);
        jTextFieldTelefonoContacto.setEditable(true);
        jTextFieldIuContactoCartera.setEditable(false);
        jTextFieldCelularContacto.setEditable(true);
        jTextFieldCorreoContacto.setEditable(true);
        jButtonRegCartera.setEnabled(true);
        jListCartera.setVisible(true);
        jPanelListaCartera.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarErrorBaseDeDatosActionPerformed

// se acomoda los objetos del frame para continuar trabajando. se habilitan los campos y botones
    private void jButtonAceptarElementoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoExistenteActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelElementoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarContactoCartera.setEnabled(true);
                jButtonEditarContactoCartera.setEnabled(false);
                jButtonBorrarContactoCartera.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuCartera.setEditable(true);
                jTextFieldTelefonoContacto.setEditable(true);
                jTextFieldIuContactoCartera.setEditable(false);
                jTextFieldCelularContacto.setEditable(true);
                jTextFieldCorreoContacto.setEditable(true);
                jButtonRegCartera.setEnabled(true);
                jListCartera.setVisible(true);
                jPanelListaCartera.setVisible(true);
            break;
            
            case 2:
                jPanelElementoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarContactoCartera.setEnabled(false);
                jButtonEditarContactoCartera.setEnabled(true);
                jButtonBorrarContactoCartera.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuCartera.setEditable(false);
                jTextFieldTelefonoContacto.setEditable(true);
                jTextFieldIuContactoCartera.setEditable(false);
                jTextFieldCelularContacto.setEditable(true);
                jTextFieldCorreoContacto.setEditable(true);
                jButtonRegCartera.setEnabled(false);
                jListCartera.setVisible(false);
   
            break;
            
            case 3: 
                jPanelElementoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarContactoCartera.setEnabled(false);
                jButtonEditarContactoCartera.setEnabled(false);
                jButtonBorrarContactoCartera.setEnabled(true);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuCartera.setEditable(true);
                jTextFieldTelefonoContacto.setEditable(true);
                jTextFieldIuContactoCartera.setEditable(false);
                jTextFieldCelularContacto.setEditable(true);
                jTextFieldCorreoContacto.setEditable(true);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarElementoExistenteActionPerformed

// se acomoda los objetos del frame para continuar trabajando. 
    private void jButtonAceptarItemNoSeleccionado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

        jTableContactoCartera.setEnabled(true);
        jPanelItemNoSeleccionado.setBounds(-260, 193, 250, 100); 
    }//GEN-LAST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

    private void jButtonAceptarElementoNoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoNoExistenteActionPerformed
        switch(auxAbm){
            
            case 1:
                jPanelElementoNoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarContactoCartera.setEnabled(true);
                jButtonEditarContactoCartera.setEnabled(false);
                jButtonBorrarContactoCartera.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuCartera.setEditable(true);
                jTextFieldTelefonoContacto.setEditable(true);
                jTextFieldIuContactoCartera.setEditable(false);
                jTextFieldCelularContacto.setEditable(true);
                jTextFieldCorreoContacto.setEditable(true);
                jListCartera.setVisible(true);
                jPanelListaCartera.setVisible(true);
                jButtonRegCartera.setEnabled(true);
            break;
            
            case 2:
                jPanelElementoNoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarContactoCartera.setEnabled(false);
                jButtonEditarContactoCartera.setEnabled(true);
                jButtonBorrarContactoCartera.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(true);
                jTextFieldIuCartera.setEditable(false);
                jTextFieldTelefonoContacto.setEditable(true);
                jTextFieldIuContactoCartera.setEditable(false);
                jTextFieldCelularContacto.setEditable(true);
                jTextFieldCorreoContacto.setEditable(true);
                jListCartera.setVisible(false);
                jButtonRegCartera.setEnabled(false);
            break;
            
            case 3: 
                jPanelElementoNoExistente.setBounds(-260, 193, 250, 100);
                jButtonAgregarContactoCartera.setEnabled(false);
                jButtonEditarContactoCartera.setEnabled(false);
                jButtonBorrarContactoCartera.setEnabled(false);
                jButtonTraerPanelBuscar.setEnabled(false);
                jTextFieldIuCartera.setEditable(false);
                jTextFieldTelefonoContacto.setEditable(true);
                jTextFieldIuContactoCartera.setEditable(false);
                jTextFieldCelularContacto.setEditable(false);
                jListCartera.setVisible(false);
                jButtonRegCartera.setEnabled(false);
            break;
        } 
    }//GEN-LAST:event_jButtonAceptarElementoNoExistenteActionPerformed

    private void jListCarteraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListCarteraFocusGained

        jPanelListaCartera.setBounds(250,138, 200, 50);
    }//GEN-LAST:event_jListCarteraFocusGained

    private void jListCarteraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListCarteraMouseClicked
        int auxCCMV = 0;
        int indexList = jListCartera.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList = true;
            jTextFieldIuCartera.setText("");
            auxListasIuCartera = jListCartera.getSelectedValue();
            jTextFieldIuCartera.setText(auxListasIuCartera);
            auxCCMV = _administradorCartera.obtenerIuCartera(auxListasIuCartera);
            jTextFieldIuCartera.setText(_administradorCartera.obtenerDniOCuit(auxCCMV));
            jPanelListaCartera.setBounds(-300, 138, 200, 50);
        } else{
            auxSeleccionList = false;
        }
      
    }//GEN-LAST:event_jListCarteraMouseClicked

    private void jTextFieldIuCarteraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuCarteraFocusGained

        jListCartera.setModel(_administradorCartera.cargarLista(jTextFieldIuCartera.getText()));
        jPanelListaCartera.setBounds(250,138, 200, 50);
    }//GEN-LAST:event_jTextFieldIuCarteraFocusGained

    private void jTextFieldIuCarteraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuCarteraFocusLost

        jPanelListaCartera.setBounds(-300,138, 200, 50);
    }//GEN-LAST:event_jTextFieldIuCarteraFocusLost

    private void jTextFieldIuCarteraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIuCarteraKeyReleased

        jListCartera.setModel(_administradorCartera.cargarLista(jTextFieldIuCartera.getText()));
        jPanelListaCartera.setBounds(250,138, 200, 50);
    }//GEN-LAST:event_jTextFieldIuCarteraKeyReleased

    private void jButtonRegCarteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegCarteraActionPerformed
        JFrameRegistroCartera obj = new JFrameRegistroCartera();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegCarteraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAceptarElementoExistente;
    private javax.swing.JButton jButtonAceptarElementoNoExistente;
    private javax.swing.JButton jButtonAceptarErrorBaseDeDatos;
    private javax.swing.JButton jButtonAceptarGuardadoErroneo;
    private javax.swing.JButton jButtonAceptarGuardadoExitoso;
    private javax.swing.JButton jButtonAceptarItemNoSeleccionado2;
    private javax.swing.JButton jButtonAceptarValidarCambios;
    private javax.swing.JButton jButtonAgregarContactoCartera;
    private javax.swing.JButton jButtonBorrarContactoCartera;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelarValidarCambios;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonEditarContactoCartera;
    private javax.swing.JButton jButtonMinimizar;
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
    private javax.swing.JLabel jLabelTituloBuscarContactoCartera;
    private javax.swing.JLabel jLabelTituloCelularContacto;
    private javax.swing.JLabel jLabelTituloCorreoContacto;
    private javax.swing.JLabel jLabelTituloIuCartera;
    private javax.swing.JLabel jLabelTituloIuContactoCartera;
    private javax.swing.JLabel jLabelTituloTelefonoContacto;
    private javax.swing.JLabel jLabelTituloVentana;
    private javax.swing.JLabel jLabelToolKitMarca;
    private javax.swing.JList<String> jListCartera;
    private javax.swing.JPanel jPanelBarraTitulo;
    private javax.swing.JPanel jPanelCuerpo;
    private javax.swing.JPanel jPanelElementoExistente;
    private javax.swing.JPanel jPanelElementoNoExistente;
    private javax.swing.JPanel jPanelErrorBaseDeDatos;
    private javax.swing.JPanel jPanelGuardadoErroneo;
    private javax.swing.JPanel jPanelGuardadoExitoso;
    private javax.swing.JPanel jPanelItemNoSeleccionado;
    private javax.swing.JPanel jPanelListaCartera;
    private javax.swing.JPanel jPanelMensajeCerrar;
    private javax.swing.JPanel jPanelMensajeValidarABM;
    private javax.swing.JPanel jPanelVentanaBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparatorBuscarContactoCartera;
    private javax.swing.JSeparator jSeparatorCelularContacto;
    private javax.swing.JSeparator jSeparatorCorreoContacto;
    private javax.swing.JSeparator jSeparatorIuCartera;
    private javax.swing.JSeparator jSeparatorIuContactoCartera;
    private javax.swing.JSeparator jSeparatorTelefonoContacto;
    private javax.swing.JTable jTableContactoCartera;
    private javax.swing.JTextField jTextFieldBuscarContactoCartera;
    private javax.swing.JTextField jTextFieldCelularContacto;
    private javax.swing.JTextField jTextFieldCorreoContacto;
    private javax.swing.JTextField jTextFieldIuCartera;
    private javax.swing.JTextField jTextFieldIuContactoCartera;
    private javax.swing.JTextField jTextFieldTelefonoContacto;
    // End of variables declaration//GEN-END:variables
}
