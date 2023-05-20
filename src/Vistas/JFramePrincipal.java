
package Vistas;

import administradorClases.Administrador;
import administradorClases.AdministradorCaja;
import administradorClases.AdministradorCatalogoCristales;
import administradorClases.AdministradorDetallesCaja;
import administradorClases.AdministradorExamenVehiculo;
import administradorClases.AdministradorModeloVehiculo;
import administradorClases.AdministradorPresupuesto;
import administradorClases.AdministradorServiciosPrestados;
import administradorClases.AdministradorTipoCaja;
import administradorClases.AdministradorTipoFactura;
import administradorClases.AdministradorTurnos;
import administradorClases.AdministradorMarcasCristales;
import administradorClases.AdministradorCartera;
import administradorClases.AdministradorVehiculos;
import clasesDatos.Caja;
import clasesDatos.DetallesDeCaja;
import clasesDatos.ExamenVehiculo;
import clasesDatos.Presupuestos;
import com.mysql.jdbc.Connection;
import static controladorBD.ConectorMySql.getConection;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public final class JFramePrincipal extends javax.swing.JFrame {
   
    private final Administrador _administrador;
    private final AdministradorTurnos _administradorTurnos;
    private final AdministradorTipoCaja _administradorTipoCaja;
    private final AdministradorTipoFactura _administradorTipoFactura;
    private final AdministradorExamenVehiculo _administradorExamenVehiculo;
    private final AdministradorCaja _administradorCaja;
    private final AdministradorCatalogoCristales _administradorCatalogoCristales;
    private final AdministradorDetallesCaja _administradorDetallesCaja;
    private final AdministradorPresupuesto _administradorPresupuesto;
    private final AdministradorModeloVehiculo _administradorModeloVehiculo;
    private final AdministradorServiciosPrestados _administradorServiciosPrestados;
    private final AdministradorMarcasCristales _administradorMarcasCristales;
    private final AdministradorCartera _administradorCartera;
    private final AdministradorVehiculos _administradorVehiculos;        
    private Caja _objCaja;
    private ExamenVehiculo _objExamen;
    private Presupuestos _objPresup;
    private TableModel modeloTablaC;
    private TableModel modeloTablaE;
    private TableModel modeloTablaP;
    private String iuCaja;
    private int auxAbm;
    private int auxBttDetalle;
    private boolean auxSeleccionList;
    private boolean auxSeleccionList2;
    private boolean auxSeleccionList3;
    private Connection _conectarSql;  
    Thread hilo2;
    
    public JFramePrincipal() {
        initComponents();  
        
        _administrador = new Administrador();
        _administradorTurnos = new AdministradorTurnos();
        _administradorCaja = new AdministradorCaja();
        _administradorCatalogoCristales = new AdministradorCatalogoCristales();
        _administradorTipoCaja = new AdministradorTipoCaja();
        _administradorTipoFactura = new AdministradorTipoFactura(); 
        _administradorDetallesCaja = new AdministradorDetallesCaja();
        _administradorPresupuesto = new AdministradorPresupuesto();
        _administradorModeloVehiculo = new AdministradorModeloVehiculo();
        _administradorServiciosPrestados = new AdministradorServiciosPrestados();
        _administradorMarcasCristales = new AdministradorMarcasCristales();
        _administradorExamenVehiculo = new AdministradorExamenVehiculo();
        _administradorCartera = new AdministradorCartera();
        _administradorVehiculos = new AdministradorVehiculos();
        
        jButtonMenuCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jButtonMenuCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jButtonMenuCatalogo.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jButtonMenuInformes.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jButtonMenuMovimientos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jButtonMenuVehiculo.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        
        jButtonAgregarTurnos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jButtonVerTodos.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
         
        jLabelTituloBuscarCatalogo.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jTextFieldBuscarCatalogo.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldANombreDe.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldBuscarCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldBuscarCatalogo.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldBuscarExamen.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldBuscarPresup.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldCodModeloVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldCodigoCristal.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldDescrCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldDescrPresup.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldDirigidoA.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldDominioVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldFechaCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldFechaExamen.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldFechaFactura.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldFechaPresup.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldIuCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldIuCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldIuMarcaCris.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldIuPresupuesto.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldIuServicios.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldIuTipoCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldIuTipoFactura.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldIuTipoPresupuesto.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldNombExaminador.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldNumExamenVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldNumFactura.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldPatenteVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldPosibleRetirador.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldTotalCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        jTextFieldTotalPresup.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 7));
        
        jLabelTituloANombreDe.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloBuscarCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloBuscarCatalogo.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloBuscarExamen.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloBuscarPresup.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloCodModeloVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloCodigoCristal.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloDescrCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloDescrPresup.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloDirigidoA.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloDominioVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloFechaCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloFechaExamen.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloFechaFactura.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloFechaPresup.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloIuCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloIuCartera.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloIuMarcaCris.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloIuPresupuesto.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloIuServicios.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloIuTipoCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloIuTipoCaja1.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloIuTipoFactura.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloNombExaminador.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloNumExamenVeh.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloNumFactura.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloPatente.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloPosibleRetirador.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloTotalCaja.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
        jLabelTituloTotalPresup.setFont(Administrador.fuentesPersonalizada("/Multimedia/tipografias/OPENSANS-BOLDITALIC.otf", 0, 6));
 
        cargarTurnosTotal(_administrador.obtenerFechaMaquina());
        popupMenuJTableCaja();
        popupMenuJTableExamen();
        popupMenuJTablePresup();
        popupMenuJTableCatalogo();
        jTable1.setModel(_administradorCatalogoCristales.cargarJTabla());
    
// carga lista detalleCaja  
        Thread hilo = new Thread(runnable);
        hilo.start();
       
    }

public void apagar(){

hilo2.stop();

}
    
    public void cargaListaDetalleCaja(int auxCarga, String iuCajaCargada){
        
        if(auxCarga==1){
            jListDetalleCaja.removeAll();
            if(iuCajaCargada.equals("AUTOMATICO")){
            
                jListDetalleCaja.setModel(_administradorDetallesCaja.cargarListaDetalles(_administradorCaja.obtenerUltimoId()));
                jListDetalleCaja.repaint();
            } else{
            
                jListDetalleCaja.setModel(_administradorDetallesCaja.cargarListaDetalles(iuCajaCargada));
            }   jListDetalleCaja.repaint();
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroupTipoPresupuesto = new javax.swing.ButtonGroup();
        jPanelMensajeCerrar = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jLabelIconoAlerta = new javax.swing.JLabel();
        jLabelMensajeUno = new javax.swing.JLabel();
        jLabelMensajeDos = new javax.swing.JLabel();
        jLabelFondoIconoMensajeCerrar = new javax.swing.JLabel();
        jButtonMenuCaja = new javax.swing.JButton();
        jPanelMenuDesplegableCaja = new javax.swing.JPanel();
        jButtonRegistroCheques = new javax.swing.JButton();
        jButtonRegistroEmisoresDeTarjetas = new javax.swing.JButton();
        jButtonRegistroTarjetas = new javax.swing.JButton();
        jButtonRegistroTipoCaja = new javax.swing.JButton();
        jButtonRegistroTipoFacturas = new javax.swing.JButton();
        jButtonRegistroTipoPago = new javax.swing.JButton();
        jButtonMenuCartera = new javax.swing.JButton();
        jPanelMenuDesplegableCartera = new javax.swing.JPanel();
        jButtonRegistroCartera = new javax.swing.JButton();
        jButtonRegistroContacto = new javax.swing.JButton();
        jButtonRegistroTipoCartera = new javax.swing.JButton();
        jButtonMenuCatalogo = new javax.swing.JButton();
        jPanelMenuDesplegableCatalogo = new javax.swing.JPanel();
        jButtonRegistroCatalogo = new javax.swing.JButton();
        jButtonRegistroMarcaCris = new javax.swing.JButton();
        jButtonRegistroPedidos = new javax.swing.JButton();
        jButtonMenuVehiculo = new javax.swing.JButton();
        jPanelMenuDesplegableVehiculo = new javax.swing.JPanel();
        jButtonRegistroMarcaVeh = new javax.swing.JButton();
        jButtonRegistroModeloVeh = new javax.swing.JButton();
        jButtonRegistroVehiculos = new javax.swing.JButton();
        jButtonMenuMovimientos = new javax.swing.JButton();
        jPanelMenuDesplegableMovimientos = new javax.swing.JPanel();
        jButtonRegistroMovimientos = new javax.swing.JButton();
        jButtonRegistroPolizaSiniestro = new javax.swing.JButton();
        jButtonRegistroSeguros = new javax.swing.JButton();
        jButtonMenuInformes = new javax.swing.JButton();
        jPanelMenuDesplegableInformes = new javax.swing.JPanel();
        jButtonRegistroMovStock = new javax.swing.JButton();
        jButtonRegistroInformes = new javax.swing.JButton();
        jButtonRegistroMovStock1 = new javax.swing.JButton();
        jButtonCerrarJFramePreincipal = new javax.swing.JButton();
        jButtonMinimizarJFramePrincipal = new javax.swing.JButton();
        jPanelTurnos = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButtonVerTodos = new javax.swing.JButton();
        jButtonAgregarTurnos = new javax.swing.JButton();
        jLabelFondoIconoTurnos = new javax.swing.JLabel();
        jPanelGlobalExamenes = new javax.swing.JPanel();
        jPanelListaIuCartera = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jListCartera = new javax.swing.JList<>();
        jPanelListaDominioVeh = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jListDominioVeh = new javax.swing.JList<>();
        jPanelElementoNoExistenteExamen = new javax.swing.JPanel();
        jButtonAceptarElementoNoExistente2 = new javax.swing.JButton();
        jLabelIconoErrorElementoNoExistente2 = new javax.swing.JLabel();
        jLabelMensajeElementoNoExistente4 = new javax.swing.JLabel();
        jLabelMensajeElementoNoExistente5 = new javax.swing.JLabel();
        jLabelFondoIconoElementoNoExitente2 = new javax.swing.JLabel();
        jPanelElementoExistenteExamen = new javax.swing.JPanel();
        jButtonAceptarElementoExistente2 = new javax.swing.JButton();
        jLabelIconoErrorElementoExistente2 = new javax.swing.JLabel();
        jLabelMensajeElementoExistente4 = new javax.swing.JLabel();
        jLabelMensajeElementoExistente5 = new javax.swing.JLabel();
        jLabelFondoIconoElementoExitente2 = new javax.swing.JLabel();
        jPanelErrorBaseDeDatosExamen = new javax.swing.JPanel();
        jButtonAceptarErrorBaseDeDatos3 = new javax.swing.JButton();
        jLabelIconoErrorBaseDeDatos3 = new javax.swing.JLabel();
        jLabelMensajeErrorBaseDeDatos6 = new javax.swing.JLabel();
        jLabelMensajeErrorBaseDeDatos7 = new javax.swing.JLabel();
        jLabelFondoIconoErrorBaseDeDatos3 = new javax.swing.JLabel();
        jPanelGuardadoErroneoExamen = new javax.swing.JPanel();
        jButtonAceptarGuardadoErroneo3 = new javax.swing.JButton();
        jLabelIconoError3 = new javax.swing.JLabel();
        jLabelMensajeGuardadoErroneo6 = new javax.swing.JLabel();
        jLabelMensajeGuardadoErroneo7 = new javax.swing.JLabel();
        jLabelFondoIconoGuardadoErroneo3 = new javax.swing.JLabel();
        jPanelGuardadoExitosoExamen = new javax.swing.JPanel();
        jButtonAceptarGuardadoExitoso2 = new javax.swing.JButton();
        jLabelIconoExito2 = new javax.swing.JLabel();
        jLabelMensajeGuardadoCorrecto2 = new javax.swing.JLabel();
        jLabelFondoIconoGuardadoExitoso2 = new javax.swing.JLabel();
        jPanelMensajeValidarABMExamen = new javax.swing.JPanel();
        jButtonCancelarValidarCambios2 = new javax.swing.JButton();
        jButtonAceptarValidarCambios2 = new javax.swing.JButton();
        jLabelIconoAlertaValidarCambios2 = new javax.swing.JLabel();
        jLabelMensajeValidarCambios4 = new javax.swing.JLabel();
        jLabelMensajeValidarCambios5 = new javax.swing.JLabel();
        jLabelFondoIconoMensajeValidarCambios2 = new javax.swing.JLabel();
        jLabelTituloPosibleRetirador = new javax.swing.JLabel();
        jTextFieldPosibleRetirador = new javax.swing.JTextField();
        jSeparatorPosibleRetirador = new javax.swing.JSeparator();
        jLabelTituloDominioVeh = new javax.swing.JLabel();
        jTextFieldDominioVeh = new javax.swing.JTextField();
        jSeparatorDominioVeh = new javax.swing.JSeparator();
        jButtonRegVehiculo = new javax.swing.JButton();
        jLabelTituloIuCartera = new javax.swing.JLabel();
        jTextFieldIuCartera = new javax.swing.JTextField();
        jSeparatorIuCartera = new javax.swing.JSeparator();
        jLabelTituloFechaExamen = new javax.swing.JLabel();
        jTextFieldFechaExamen = new javax.swing.JTextField();
        jSeparatorFechaExamen = new javax.swing.JSeparator();
        jLabelTituloNombExaminador = new javax.swing.JLabel();
        jTextFieldNombExaminador = new javax.swing.JTextField();
        jSeparatorNombExaminador = new javax.swing.JSeparator();
        jSeparatorNumExamenVeh = new javax.swing.JSeparator();
        jLabelTituloNumExamenVeh = new javax.swing.JLabel();
        jTextFieldNumExamenVeh = new javax.swing.JTextField();
        jButtonRegCartera = new javax.swing.JButton();
        jButtonAgregarExamen = new javax.swing.JButton();
        jButtonEditarExamen = new javax.swing.JButton();
        jButtonBorrarExamen = new javax.swing.JButton();
        jButtonTraerPanelBuscar1 = new javax.swing.JButton();
        jLabelFondoExamen = new javax.swing.JLabel();
        jPanelVentanaBuscarExamen = new javax.swing.JPanel();
        jPanelItemNoSeleccionadoExamen = new javax.swing.JPanel();
        jButtonAceptarItemNoSeleccionado3 = new javax.swing.JButton();
        jLabelIconoErrorItemNoSeleccionado1 = new javax.swing.JLabel();
        jLabelMensajeItemNoSeleccionado1 = new javax.swing.JLabel();
        jLabelFondoIconoItemNoSeleccionado1 = new javax.swing.JLabel();
        jSeparatorBuscarExamen = new javax.swing.JSeparator();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTableExamen = new javax.swing.JTable();
        jLabelTituloBuscarExamen = new javax.swing.JLabel();
        jTextFieldBuscarExamen = new javax.swing.JTextField();
        jButtonTraerPanelCuerpo1 = new javax.swing.JButton();
        jLabelFondoExamen1 = new javax.swing.JLabel();
        jPanelVentanaBuscarPresup = new javax.swing.JPanel();
        jPanelItemNoSeleccionadoPresup = new javax.swing.JPanel();
        jButtonAceptarItemNoSeleccionado4 = new javax.swing.JButton();
        jLabelIconoErrorItemNoSeleccionado2 = new javax.swing.JLabel();
        jLabelMensajeItemNoSeleccionado2 = new javax.swing.JLabel();
        jLabelFondoIconoItemNoSeleccionado2 = new javax.swing.JLabel();
        jSeparatorBuscarPresup = new javax.swing.JSeparator();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTablePresup = new javax.swing.JTable();
        jLabelTituloBuscarPresup = new javax.swing.JLabel();
        jTextFieldBuscarPresup = new javax.swing.JTextField();
        jButtonTraerPanelCuerpoPresup = new javax.swing.JButton();
        jLabelFondoPresup1 = new javax.swing.JLabel();
        jPanelGlobalCaja = new javax.swing.JPanel();
        jPanelListaIuTipoCaja = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListTipoCaja = new javax.swing.JList<>();
        jPanelListaIuTipoFactura = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListTipoFactura = new javax.swing.JList<>();
        jPanelElementoNoExistenteCaja = new javax.swing.JPanel();
        jButtonAceptarElementoNoExistente = new javax.swing.JButton();
        jLabelIconoErrorElementoNoExistente = new javax.swing.JLabel();
        jLabelMensajeElementoNoExistente = new javax.swing.JLabel();
        jLabelMensajeElementoNoExistente2 = new javax.swing.JLabel();
        jLabelFondoIconoElementoNoExitente = new javax.swing.JLabel();
        jPanelElementoExistenteCaja = new javax.swing.JPanel();
        jButtonAceptarElementoExistente = new javax.swing.JButton();
        jLabelIconoErrorElementoExistente = new javax.swing.JLabel();
        jLabelMensajeElementoExistente = new javax.swing.JLabel();
        jLabelMensajeElementoExistente2 = new javax.swing.JLabel();
        jLabelFondoIconoElementoExitente = new javax.swing.JLabel();
        jPanelErrorBaseDeDatosCaja = new javax.swing.JPanel();
        jButtonAceptarErrorBaseDeDatos1 = new javax.swing.JButton();
        jLabelIconoErrorBaseDeDatos1 = new javax.swing.JLabel();
        jLabelMensajeErrorBaseDeDatos2 = new javax.swing.JLabel();
        jLabelMensajeErrorBaseDeDatos3 = new javax.swing.JLabel();
        jLabelFondoIconoErrorBaseDeDatos1 = new javax.swing.JLabel();
        jPanelGuardadoErroneoCaja = new javax.swing.JPanel();
        jButtonAceptarGuardadoErroneo = new javax.swing.JButton();
        jLabelIconoError = new javax.swing.JLabel();
        jLabelMensajeGuardadoErroneo = new javax.swing.JLabel();
        jLabelMensajeGuardadoErroneo2 = new javax.swing.JLabel();
        jLabelFondoIconoGuardadoErroneo = new javax.swing.JLabel();
        jPanelGuardadoExitosoCaja = new javax.swing.JPanel();
        jButtonAceptarGuardadoExitoso = new javax.swing.JButton();
        jLabelIconoExito = new javax.swing.JLabel();
        jLabelMensajeGuardadoCorrecto = new javax.swing.JLabel();
        jLabelFondoIconoGuardadoExitoso = new javax.swing.JLabel();
        jPanelDatosErroneoCaja = new javax.swing.JPanel();
        jButtonAceptarGuardadoErroneo2 = new javax.swing.JButton();
        jLabelIconoError2 = new javax.swing.JLabel();
        jLabelMensajeGuardadoErroneo4 = new javax.swing.JLabel();
        jLabelMensajeGuardadoErroneo5 = new javax.swing.JLabel();
        jLabelFondoIconoGuardadoErroneo2 = new javax.swing.JLabel();
        jPanelMensajeValidarABMCaja = new javax.swing.JPanel();
        jButtonCancelarValidarCambios = new javax.swing.JButton();
        jButtonAceptarValidarCambios = new javax.swing.JButton();
        jLabelIconoAlertaValidarCambios = new javax.swing.JLabel();
        jLabelMensajeValidarCambios = new javax.swing.JLabel();
        jLabelMensajeValidarCambios1 = new javax.swing.JLabel();
        jLabelFondoIconoMensajeValidarCambios = new javax.swing.JLabel();
        jLabelTituloTotalCaja = new javax.swing.JLabel();
        jTextFieldTotalCaja = new javax.swing.JTextField();
        jSeparatorTotalCaja = new javax.swing.JSeparator();
        jLabelTituloDescrCaja = new javax.swing.JLabel();
        jTextFieldDescrCaja = new javax.swing.JTextField();
        jSeparatorDescrCaja = new javax.swing.JSeparator();
        jLabelTituloNumFactura = new javax.swing.JLabel();
        jTextFieldNumFactura = new javax.swing.JTextField();
        jSeparatorNumFactura = new javax.swing.JSeparator();
        jLabelTituloANombreDe = new javax.swing.JLabel();
        jTextFieldANombreDe = new javax.swing.JTextField();
        jSeparatorANombreDe = new javax.swing.JSeparator();
        jLabelTituloFechaFactura = new javax.swing.JLabel();
        jTextFieldFechaFactura = new javax.swing.JTextField();
        jSeparatorFechaFactura = new javax.swing.JSeparator();
        jButtonRegTipoFactura = new javax.swing.JButton();
        jLabelTituloIuTipoFactura = new javax.swing.JLabel();
        jTextFieldIuTipoFactura = new javax.swing.JTextField();
        jSeparatorIuTipoFactura = new javax.swing.JSeparator();
        jLabelTituloFechaCaja = new javax.swing.JLabel();
        jTextFieldFechaCaja = new javax.swing.JTextField();
        jSeparatorFechaCaja = new javax.swing.JSeparator();
        jButtonRegTipoCaja = new javax.swing.JButton();
        jLabelTituloIuTipoCaja = new javax.swing.JLabel();
        jTextFieldIuTipoCaja = new javax.swing.JTextField();
        jSeparatorIuTipoCaja = new javax.swing.JSeparator();
        jSeparatorIuCaja = new javax.swing.JSeparator();
        jLabelTituloIuCaja = new javax.swing.JLabel();
        jTextFieldIuCaja = new javax.swing.JTextField();
        jButtonAgregarCaja = new javax.swing.JButton();
        jButtonEditarCaja = new javax.swing.JButton();
        jButtonBorrarCaja = new javax.swing.JButton();
        jButtonTraerPanelBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListDetalleCaja = new javax.swing.JList<>();
        jButtonRegDetalleCaja = new javax.swing.JButton();
        jLabelFondoCaja = new javax.swing.JLabel();
        jPanelVentanaBuscarCaja = new javax.swing.JPanel();
        jPanelItemNoSeleccionadoCaja = new javax.swing.JPanel();
        jButtonAceptarItemNoSeleccionado2 = new javax.swing.JButton();
        jLabelIconoErrorItemNoSeleccionado = new javax.swing.JLabel();
        jLabelMensajeItemNoSeleccionado = new javax.swing.JLabel();
        jLabelFondoIconoItemNoSeleccionado = new javax.swing.JLabel();
        jPanelErrorBaseDeDatosCaja1 = new javax.swing.JPanel();
        jButtonAceptarErrorBaseDeDatos4 = new javax.swing.JButton();
        jLabelIconoErrorBaseDeDatos4 = new javax.swing.JLabel();
        jLabelMensajeErrorBaseDeDatos8 = new javax.swing.JLabel();
        jLabelMensajeErrorBaseDeDatos9 = new javax.swing.JLabel();
        jLabelFondoIconoErrorBaseDeDatos4 = new javax.swing.JLabel();
        jSeparatorBuscarCaja = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCaja = new javax.swing.JTable();
        jLabelTituloBuscarCaja = new javax.swing.JLabel();
        jTextFieldBuscarCaja = new javax.swing.JTextField();
        jButtonTraerPanelCuerpo = new javax.swing.JButton();
        jLabelFondoCaja1 = new javax.swing.JLabel();
        jPanelGlobalPresupuesto = new javax.swing.JPanel();
        jPanelListaIuMarcaCris = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListMarcasCristales = new javax.swing.JList<>();
        jPanelListaIuServicios = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jListServiciosPrestados = new javax.swing.JList<>();
        jPanelListaCodModeloVeh = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListModeloVeh = new javax.swing.JList<>();
        jPanelListaCodigoCristal = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListCodigoCrstal = new javax.swing.JList<>();
        jPanelElementoNoExistentePresup = new javax.swing.JPanel();
        jButtonAceptarElementoNoExistente1 = new javax.swing.JButton();
        jLabelIconoErrorElementoNoExistente1 = new javax.swing.JLabel();
        jLabelMensajeElementoNoExistente1 = new javax.swing.JLabel();
        jLabelMensajeElementoNoExistente3 = new javax.swing.JLabel();
        jLabelFondoIconoElementoNoExitente1 = new javax.swing.JLabel();
        jPanelElementoExistentePresup = new javax.swing.JPanel();
        jButtonAceptarElementoExistente1 = new javax.swing.JButton();
        jLabelIconoErrorElementoExistente1 = new javax.swing.JLabel();
        jLabelMensajeElementoExistente1 = new javax.swing.JLabel();
        jLabelMensajeElementoExistente3 = new javax.swing.JLabel();
        jLabelFondoIconoElementoExitente1 = new javax.swing.JLabel();
        jPanelErrorBaseDeDatosPresup = new javax.swing.JPanel();
        jButtonAceptarErrorBaseDeDatos2 = new javax.swing.JButton();
        jLabelIconoErrorBaseDeDatos2 = new javax.swing.JLabel();
        jLabelMensajeErrorBaseDeDatos4 = new javax.swing.JLabel();
        jLabelMensajeErrorBaseDeDatos5 = new javax.swing.JLabel();
        jLabelFondoIconoErrorBaseDeDatos2 = new javax.swing.JLabel();
        jPanelGuardadoErroneoPresup = new javax.swing.JPanel();
        jButtonAceptarGuardadoErroneo1 = new javax.swing.JButton();
        jLabelIconoError1 = new javax.swing.JLabel();
        jLabelMensajeGuardadoErroneo1 = new javax.swing.JLabel();
        jLabelMensajeGuardadoErroneo3 = new javax.swing.JLabel();
        jLabelFondoIconoGuardadoErroneo1 = new javax.swing.JLabel();
        jPanelGuardadoExitosoPresup = new javax.swing.JPanel();
        jButtonAceptarGuardadoExitoso1 = new javax.swing.JButton();
        jLabelIconoExito1 = new javax.swing.JLabel();
        jLabelMensajeGuardadoCorrecto1 = new javax.swing.JLabel();
        jLabelFondoIconoGuardadoExitoso1 = new javax.swing.JLabel();
        jPanelMensajeValidarABMPresup = new javax.swing.JPanel();
        jButtonCancelarValidarCambios1 = new javax.swing.JButton();
        jButtonAceptarValidarCambios1 = new javax.swing.JButton();
        jLabelIconoAlertaValidarCambios1 = new javax.swing.JLabel();
        jLabelMensajeValidarCambios2 = new javax.swing.JLabel();
        jLabelMensajeValidarCambios3 = new javax.swing.JLabel();
        jLabelFondoIconoMensajeValidarCambios1 = new javax.swing.JLabel();
        jLabelTituloTotalPresup = new javax.swing.JLabel();
        jTextFieldTotalPresup = new javax.swing.JTextField();
        jSeparatorTotalPresup = new javax.swing.JSeparator();
        jLabelTituloDescrPresup = new javax.swing.JLabel();
        jTextFieldDescrPresup = new javax.swing.JTextField();
        jSeparatorDescrPresup = new javax.swing.JSeparator();
        jLabelTituloCodigoCristal = new javax.swing.JLabel();
        jTextFieldCodigoCristal = new javax.swing.JTextField();
        jSeparatorCodigoCristal = new javax.swing.JSeparator();
        jLabelTituloPatente = new javax.swing.JLabel();
        jTextFieldPatenteVeh = new javax.swing.JTextField();
        jSeparatorPatenteVeh = new javax.swing.JSeparator();
        jLabelTituloIuMarcaCris = new javax.swing.JLabel();
        jTextFieldIuMarcaCris = new javax.swing.JTextField();
        jSeparatorIuMarcaCris = new javax.swing.JSeparator();
        jButtonRegMarcaCristal = new javax.swing.JButton();
        jLabelTituloCodModeloVeh = new javax.swing.JLabel();
        jTextFieldCodModeloVeh = new javax.swing.JTextField();
        jSeparatorCodModeloVeh = new javax.swing.JSeparator();
        jLabelTituloDirigidoA = new javax.swing.JLabel();
        jTextFieldDirigidoA = new javax.swing.JTextField();
        jSeparatorDirigidoA = new javax.swing.JSeparator();
        jLabelTituloIuTipoCaja1 = new javax.swing.JLabel();
        jTextFieldIuTipoPresupuesto = new javax.swing.JTextField();
        jSeparatorIuTipoPresupuesto = new javax.swing.JSeparator();
        jSeparatorIuPresupuesto = new javax.swing.JSeparator();
        jLabelTituloIuPresupuesto = new javax.swing.JLabel();
        jTextFieldIuPresupuesto = new javax.swing.JTextField();
        jButtonAgregarPresupuesto = new javax.swing.JButton();
        jButtonEditarPresupuesto = new javax.swing.JButton();
        jButtonBorrarPresupuesto = new javax.swing.JButton();
        jButtonTraerPanelBuscarPresup = new javax.swing.JButton();
        jLabelTituloFechaPresup = new javax.swing.JLabel();
        jTextFieldFechaPresup = new javax.swing.JTextField();
        jSeparatorFechaFactura2 = new javax.swing.JSeparator();
        jButtonRegModeloVehiculo = new javax.swing.JButton();
        jButtonRegCatalogo = new javax.swing.JButton();
        jLabelTituloIuServicios = new javax.swing.JLabel();
        jTextFieldIuServicios = new javax.swing.JTextField();
        jSeparatorIuServicios = new javax.swing.JSeparator();
        jButtonRegServiciosPrestados = new javax.swing.JButton();
        jLabelFondoPresup = new javax.swing.JLabel();
        jPanelBuscarCatalogo = new javax.swing.JPanel();
        jLabelTituloBuscarCatalogo = new javax.swing.JLabel();
        jTextFieldBuscarCatalogo = new javax.swing.JTextField();
        jSeparatorBuscarCatalogo = new javax.swing.JSeparator();
        jLabelFondoCatalogo1 = new javax.swing.JLabel();
        jScrollPaneListaCatalogo = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelErrorBaseDeDatos = new javax.swing.JPanel();
        jButtonAceptarErrorBaseDeDatos = new javax.swing.JButton();
        jLabelIconoErrorBaseDeDatos = new javax.swing.JLabel();
        jLabelMensajeErrorBaseDeDatos = new javax.swing.JLabel();
        jLabelMensajeErrorBaseDeDatos1 = new javax.swing.JLabel();
        jLabelFondoIconoErrorBaseDeDatos = new javax.swing.JLabel();
        jLabelBarraHerramientas = new javax.swing.JLabel();
        jButtonGlobalCatalogo = new javax.swing.JButton();
        jButtonGlobalPresupuesto = new javax.swing.JButton();
        jButtonGlobalExamenes = new javax.swing.JButton();
        jButtonCajaPricipal = new javax.swing.JButton();
        jLabelFondoIcono = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMensajeCerrar.setOpaque(false);
        jPanelMensajeCerrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOff.png"))); // NOI18N
        jButtonCancelar.setBorder(null);
        jButtonCancelar.setBorderPainted(false);
        jButtonCancelar.setContentAreaFilled(false);
        jButtonCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOn.png"))); // NOI18N
        jButtonCancelar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOn.png"))); // NOI18N
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelMensajeCerrar.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptar.setBorder(null);
        jButtonAceptar.setBorderPainted(false);
        jButtonAceptar.setContentAreaFilled(false);
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

        jButtonMenuCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jButtonMenuCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDeplegabeCentrales140x26Off.png"))); // NOI18N
        jButtonMenuCaja.setText("Caja");
        jButtonMenuCaja.setBorder(null);
        jButtonMenuCaja.setBorderPainted(false);
        jButtonMenuCaja.setContentAreaFilled(false);
        jButtonMenuCaja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonMenuCaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonMenuCaja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDesplegableCentrales140x26On.png"))); // NOI18N
        jButtonMenuCaja.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDesplegableCentrales140x26On.png"))); // NOI18N
        jButtonMenuCaja.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jButtonMenuCajaMouseDragged(evt);
            }
        });
        jButtonMenuCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonMenuCajaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonMenuCajaMouseExited(evt);
            }
        });
        jButtonMenuCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuCajaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenuCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2, -1, -1));

        jPanelMenuDesplegableCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegistroCheques.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroCheques.setText("Registro de cheques");
        jButtonRegistroCheques.setBorder(null);
        jButtonRegistroCheques.setBorderPainted(false);
        jButtonRegistroCheques.setContentAreaFilled(false);
        jButtonRegistroCheques.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroCheques.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroCheques.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroCheques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroChequesActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableCaja.add(jButtonRegistroCheques, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 25));

        jButtonRegistroEmisoresDeTarjetas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroEmisoresDeTarjetas.setText("Registro de emisores de tarjetas");
        jButtonRegistroEmisoresDeTarjetas.setBorder(null);
        jButtonRegistroEmisoresDeTarjetas.setBorderPainted(false);
        jButtonRegistroEmisoresDeTarjetas.setContentAreaFilled(false);
        jButtonRegistroEmisoresDeTarjetas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroEmisoresDeTarjetas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroEmisoresDeTarjetas.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroEmisoresDeTarjetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroEmisoresDeTarjetasActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableCaja.add(jButtonRegistroEmisoresDeTarjetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 250, 25));

        jButtonRegistroTarjetas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroTarjetas.setText("Registro de tarjetas");
        jButtonRegistroTarjetas.setBorder(null);
        jButtonRegistroTarjetas.setBorderPainted(false);
        jButtonRegistroTarjetas.setContentAreaFilled(false);
        jButtonRegistroTarjetas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroTarjetas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroTarjetas.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroTarjetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroTarjetasActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableCaja.add(jButtonRegistroTarjetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 25));

        jButtonRegistroTipoCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroTipoCaja.setText("Registro de tipos de cajas");
        jButtonRegistroTipoCaja.setBorder(null);
        jButtonRegistroTipoCaja.setBorderPainted(false);
        jButtonRegistroTipoCaja.setContentAreaFilled(false);
        jButtonRegistroTipoCaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroTipoCaja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroTipoCaja.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroTipoCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroTipoCajaActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableCaja.add(jButtonRegistroTipoCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 75, 250, 25));

        jButtonRegistroTipoFacturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroTipoFacturas.setText("Registro de tipos de facturas");
        jButtonRegistroTipoFacturas.setBorder(null);
        jButtonRegistroTipoFacturas.setBorderPainted(false);
        jButtonRegistroTipoFacturas.setContentAreaFilled(false);
        jButtonRegistroTipoFacturas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroTipoFacturas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroTipoFacturas.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroTipoFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroTipoFacturasActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableCaja.add(jButtonRegistroTipoFacturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 250, 25));

        jButtonRegistroTipoPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroTipoPago.setText("Registro de tipos de pagos");
        jButtonRegistroTipoPago.setBorder(null);
        jButtonRegistroTipoPago.setBorderPainted(false);
        jButtonRegistroTipoPago.setContentAreaFilled(false);
        jButtonRegistroTipoPago.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroTipoPago.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroTipoPago.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroTipoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroTipoPagoActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableCaja.add(jButtonRegistroTipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 125, 250, 25));

        getContentPane().add(jPanelMenuDesplegableCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 27, 250, 150));

        jButtonMenuCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jButtonMenuCartera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDeplegabeCentrales140x26Off.png"))); // NOI18N
        jButtonMenuCartera.setText("Cartera");
        jButtonMenuCartera.setBorder(null);
        jButtonMenuCartera.setBorderPainted(false);
        jButtonMenuCartera.setContentAreaFilled(false);
        jButtonMenuCartera.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonMenuCartera.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonMenuCartera.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDesplegableCentrales140x26On.png"))); // NOI18N
        jButtonMenuCartera.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDesplegableCentrales140x26On.png"))); // NOI18N
        jButtonMenuCartera.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jButtonMenuCarteraMouseDragged(evt);
            }
        });
        jButtonMenuCartera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonMenuCarteraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonMenuCarteraMouseExited(evt);
            }
        });
        jButtonMenuCartera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuCarteraActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenuCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 2, -1, -1));

        jPanelMenuDesplegableCartera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegistroCartera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroCartera.setText("Registro de Carteras");
        jButtonRegistroCartera.setBorder(null);
        jButtonRegistroCartera.setBorderPainted(false);
        jButtonRegistroCartera.setContentAreaFilled(false);
        jButtonRegistroCartera.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroCartera.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroCartera.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroCartera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroCarteraActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableCartera.add(jButtonRegistroCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButtonRegistroContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroContacto.setText("Registro de contactos de carteras");
        jButtonRegistroContacto.setBorder(null);
        jButtonRegistroContacto.setBorderPainted(false);
        jButtonRegistroContacto.setContentAreaFilled(false);
        jButtonRegistroContacto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroContacto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroContacto.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroContactoActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableCartera.add(jButtonRegistroContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, -1, -1));

        jButtonRegistroTipoCartera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroTipoCartera.setText("Registro de tipos de carteras");
        jButtonRegistroTipoCartera.setBorder(null);
        jButtonRegistroTipoCartera.setBorderPainted(false);
        jButtonRegistroTipoCartera.setContentAreaFilled(false);
        jButtonRegistroTipoCartera.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroTipoCartera.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroTipoCartera.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroTipoCartera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroTipoCarteraActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableCartera.add(jButtonRegistroTipoCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        getContentPane().add(jPanelMenuDesplegableCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 28, 250, 75));

        jButtonMenuCatalogo.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jButtonMenuCatalogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDeplegabeCentrales140x26Off.png"))); // NOI18N
        jButtonMenuCatalogo.setText("Catalogo");
        jButtonMenuCatalogo.setBorder(null);
        jButtonMenuCatalogo.setBorderPainted(false);
        jButtonMenuCatalogo.setContentAreaFilled(false);
        jButtonMenuCatalogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonMenuCatalogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonMenuCatalogo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDesplegableCentrales140x26On.png"))); // NOI18N
        jButtonMenuCatalogo.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDesplegableCentrales140x26On.png"))); // NOI18N
        jButtonMenuCatalogo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jButtonMenuCatalogoMouseDragged(evt);
            }
        });
        jButtonMenuCatalogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonMenuCatalogoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonMenuCatalogoMouseExited(evt);
            }
        });
        jButtonMenuCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuCatalogoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenuCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 2, -1, -1));

        jPanelMenuDesplegableCatalogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegistroCatalogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroCatalogo.setText("Registro de catalogo");
        jButtonRegistroCatalogo.setBorder(null);
        jButtonRegistroCatalogo.setBorderPainted(false);
        jButtonRegistroCatalogo.setContentAreaFilled(false);
        jButtonRegistroCatalogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroCatalogo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroCatalogo.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroCatalogoActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableCatalogo.add(jButtonRegistroCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButtonRegistroMarcaCris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroMarcaCris.setText("Registro de marcas de cristales");
        jButtonRegistroMarcaCris.setBorder(null);
        jButtonRegistroMarcaCris.setBorderPainted(false);
        jButtonRegistroMarcaCris.setContentAreaFilled(false);
        jButtonRegistroMarcaCris.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroMarcaCris.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroMarcaCris.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroMarcaCris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroMarcaCrisActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableCatalogo.add(jButtonRegistroMarcaCris, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, -1, -1));

        jButtonRegistroPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroPedidos.setText("Registro de pedidos");
        jButtonRegistroPedidos.setBorder(null);
        jButtonRegistroPedidos.setBorderPainted(false);
        jButtonRegistroPedidos.setContentAreaFilled(false);
        jButtonRegistroPedidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroPedidos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroPedidos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroPedidosActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableCatalogo.add(jButtonRegistroPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        getContentPane().add(jPanelMenuDesplegableCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 28, 250, 75));

        jButtonMenuVehiculo.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jButtonMenuVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDeplegabeCentrales140x26Off.png"))); // NOI18N
        jButtonMenuVehiculo.setText("Vehiculo");
        jButtonMenuVehiculo.setBorder(null);
        jButtonMenuVehiculo.setBorderPainted(false);
        jButtonMenuVehiculo.setContentAreaFilled(false);
        jButtonMenuVehiculo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonMenuVehiculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonMenuVehiculo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDesplegableCentrales140x26On.png"))); // NOI18N
        jButtonMenuVehiculo.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDesplegableCentrales140x26On.png"))); // NOI18N
        jButtonMenuVehiculo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jButtonMenuVehiculoMouseDragged(evt);
            }
        });
        jButtonMenuVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonMenuVehiculoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonMenuVehiculoMouseExited(evt);
            }
        });
        jButtonMenuVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuVehiculoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenuVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 2, -1, -1));

        jPanelMenuDesplegableVehiculo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegistroMarcaVeh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroMarcaVeh.setText("Registro de marcas de vehiculos");
        jButtonRegistroMarcaVeh.setBorder(null);
        jButtonRegistroMarcaVeh.setBorderPainted(false);
        jButtonRegistroMarcaVeh.setContentAreaFilled(false);
        jButtonRegistroMarcaVeh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroMarcaVeh.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroMarcaVeh.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroMarcaVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroMarcaVehActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableVehiculo.add(jButtonRegistroMarcaVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButtonRegistroModeloVeh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroModeloVeh.setText("Registro de modelos de vehiculos");
        jButtonRegistroModeloVeh.setBorder(null);
        jButtonRegistroModeloVeh.setBorderPainted(false);
        jButtonRegistroModeloVeh.setContentAreaFilled(false);
        jButtonRegistroModeloVeh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroModeloVeh.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroModeloVeh.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroModeloVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroModeloVehActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableVehiculo.add(jButtonRegistroModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, -1, -1));

        jButtonRegistroVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroVehiculos.setText("Registro de vehiculos");
        jButtonRegistroVehiculos.setBorder(null);
        jButtonRegistroVehiculos.setBorderPainted(false);
        jButtonRegistroVehiculos.setContentAreaFilled(false);
        jButtonRegistroVehiculos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroVehiculos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroVehiculos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroVehiculosActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableVehiculo.add(jButtonRegistroVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        getContentPane().add(jPanelMenuDesplegableVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 28, 250, 75));

        jButtonMenuMovimientos.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jButtonMenuMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDeplegabeCentrales140x26Off.png"))); // NOI18N
        jButtonMenuMovimientos.setText("Movimientos");
        jButtonMenuMovimientos.setBorder(null);
        jButtonMenuMovimientos.setBorderPainted(false);
        jButtonMenuMovimientos.setContentAreaFilled(false);
        jButtonMenuMovimientos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonMenuMovimientos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonMenuMovimientos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDesplegableCentrales140x26On.png"))); // NOI18N
        jButtonMenuMovimientos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDesplegableCentrales140x26On.png"))); // NOI18N
        jButtonMenuMovimientos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jButtonMenuMovimientosMouseDragged(evt);
            }
        });
        jButtonMenuMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonMenuMovimientosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonMenuMovimientosMouseExited(evt);
            }
        });
        jButtonMenuMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuMovimientosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenuMovimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 2, -1, -1));

        jPanelMenuDesplegableMovimientos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegistroMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroMovimientos.setText("Registro de movimientos");
        jButtonRegistroMovimientos.setToolTipText("");
        jButtonRegistroMovimientos.setBorder(null);
        jButtonRegistroMovimientos.setBorderPainted(false);
        jButtonRegistroMovimientos.setContentAreaFilled(false);
        jButtonRegistroMovimientos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroMovimientos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroMovimientos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroMovimientosActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableMovimientos.add(jButtonRegistroMovimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButtonRegistroPolizaSiniestro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroPolizaSiniestro.setText("Registro de polizas y siniestros");
        jButtonRegistroPolizaSiniestro.setBorder(null);
        jButtonRegistroPolizaSiniestro.setBorderPainted(false);
        jButtonRegistroPolizaSiniestro.setContentAreaFilled(false);
        jButtonRegistroPolizaSiniestro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonRegistroPolizaSiniestro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroPolizaSiniestro.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroPolizaSiniestro.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroPolizaSiniestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroPolizaSiniestroActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableMovimientos.add(jButtonRegistroPolizaSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, -1, -1));

        jButtonRegistroSeguros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroSeguros.setText("Registro de seguros");
        jButtonRegistroSeguros.setBorder(null);
        jButtonRegistroSeguros.setBorderPainted(false);
        jButtonRegistroSeguros.setContentAreaFilled(false);
        jButtonRegistroSeguros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroSeguros.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroSeguros.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroSeguros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroSegurosActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableMovimientos.add(jButtonRegistroSeguros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        getContentPane().add(jPanelMenuDesplegableMovimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 28, 250, 75));

        jButtonMenuInformes.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jButtonMenuInformes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDeplegabeCentrales140x26Off.png"))); // NOI18N
        jButtonMenuInformes.setText("Informes");
        jButtonMenuInformes.setBorder(null);
        jButtonMenuInformes.setBorderPainted(false);
        jButtonMenuInformes.setContentAreaFilled(false);
        jButtonMenuInformes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonMenuInformes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonMenuInformes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDesplegableCentrales140x26On.png"))); // NOI18N
        jButtonMenuInformes.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDesplegableCentrales140x26On.png"))); // NOI18N
        jButtonMenuInformes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jButtonMenuInformesMouseDragged(evt);
            }
        });
        jButtonMenuInformes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonMenuInformesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonMenuInformesMouseExited(evt);
            }
        });
        jButtonMenuInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuInformesActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenuInformes, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 2, -1, -1));

        jPanelMenuDesplegableInformes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegistroMovStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroMovStock.setText("Informe cristales con sobre stock hoy");
        jButtonRegistroMovStock.setBorder(null);
        jButtonRegistroMovStock.setBorderPainted(false);
        jButtonRegistroMovStock.setContentAreaFilled(false);
        jButtonRegistroMovStock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroMovStock.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroMovStock.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroMovStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroMovStockActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableInformes.add(jButtonRegistroMovStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        jButtonRegistroInformes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroInformes.setText("Informes de ventas");
        jButtonRegistroInformes.setBorder(null);
        jButtonRegistroInformes.setBorderPainted(false);
        jButtonRegistroInformes.setContentAreaFilled(false);
        jButtonRegistroInformes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroInformes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroInformes.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroInformesActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableInformes.add(jButtonRegistroInformes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, -1, -1));

        jButtonRegistroMovStock1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25Off.png"))); // NOI18N
        jButtonRegistroMovStock1.setText("Informe cristales sin stock hoy");
        jButtonRegistroMovStock1.setBorder(null);
        jButtonRegistroMovStock1.setBorderPainted(false);
        jButtonRegistroMovStock1.setContentAreaFilled(false);
        jButtonRegistroMovStock1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistroMovStock1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroMovStock1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/botonMenuDespegable250x25On.png"))); // NOI18N
        jButtonRegistroMovStock1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroMovStock1ActionPerformed(evt);
            }
        });
        jPanelMenuDesplegableInformes.add(jButtonRegistroMovStock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanelMenuDesplegableInformes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 28, 250, 75));

        jButtonCerrarJFramePreincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonCerrarOff.png"))); // NOI18N
        jButtonCerrarJFramePreincipal.setBorder(null);
        jButtonCerrarJFramePreincipal.setBorderPainted(false);
        jButtonCerrarJFramePreincipal.setContentAreaFilled(false);
        jButtonCerrarJFramePreincipal.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonCerrarOn.png"))); // NOI18N
        jButtonCerrarJFramePreincipal.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonCerrarOn.png"))); // NOI18N
        jButtonCerrarJFramePreincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarJFramePreincipalActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCerrarJFramePreincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 3, -1, -1));

        jButtonMinimizarJFramePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMinimizarOff.png"))); // NOI18N
        jButtonMinimizarJFramePrincipal.setBorder(null);
        jButtonMinimizarJFramePrincipal.setBorderPainted(false);
        jButtonMinimizarJFramePrincipal.setContentAreaFilled(false);
        jButtonMinimizarJFramePrincipal.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMinimizarOn.png"))); // NOI18N
        jButtonMinimizarJFramePrincipal.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMinimizarOn.png"))); // NOI18N
        jButtonMinimizarJFramePrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinimizarJFramePrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMinimizarJFramePrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 3, -1, -1));

        jPanelTurnos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jList1.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jScrollPane13.setViewportView(jList1);

        jPanelTurnos.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 250, 250));

        jButtonVerTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDeplegabeCentrales140x26Off.png"))); // NOI18N
        jButtonVerTodos.setText("TODOS LOS TURNOS");
        jButtonVerTodos.setToolTipText("Listado de los turnos.");
        jButtonVerTodos.setBorder(null);
        jButtonVerTodos.setBorderPainted(false);
        jButtonVerTodos.setContentAreaFilled(false);
        jButtonVerTodos.setFocusPainted(false);
        jButtonVerTodos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonVerTodos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDesplegableCentrales140x26On.png"))); // NOI18N
        jButtonVerTodos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDesplegableCentrales140x26On.png"))); // NOI18N
        jButtonVerTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerTodosActionPerformed(evt);
            }
        });
        jPanelTurnos.add(jButtonVerTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 300, -1, -1));

        jButtonAgregarTurnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDeplegabeCentrales140x26Off.png"))); // NOI18N
        jButtonAgregarTurnos.setText("Agregar turno");
        jButtonAgregarTurnos.setBorder(null);
        jButtonAgregarTurnos.setBorderPainted(false);
        jButtonAgregarTurnos.setContentAreaFilled(false);
        jButtonAgregarTurnos.setFocusPainted(false);
        jButtonAgregarTurnos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAgregarTurnos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDesplegableCentrales140x26On.png"))); // NOI18N
        jButtonAgregarTurnos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/menu/barraMenuDesplegableCentrales140x26On.png"))); // NOI18N
        jButtonAgregarTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarTurnosActionPerformed(evt);
            }
        });
        jPanelTurnos.add(jButtonAgregarTurnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 340, -1, -1));

        jLabelFondoIconoTurnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondoCuerpo270x430.png"))); // NOI18N
        jPanelTurnos.add(jLabelFondoIconoTurnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanelTurnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 270, 430));

        jPanelGlobalExamenes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelListaIuCartera.setOpaque(false);
        jPanelListaIuCartera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane10.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane10.setPreferredSize(new java.awt.Dimension(200, 45));

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
        jScrollPane10.setViewportView(jListCartera);

        jPanelListaIuCartera.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 45));

        jPanelGlobalExamenes.add(jPanelListaIuCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 241, 200, 45));

        jPanelListaDominioVeh.setOpaque(false);
        jPanelListaDominioVeh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane11.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane11.setPreferredSize(new java.awt.Dimension(200, 45));

        jListDominioVeh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListDominioVehFocusGained(evt);
            }
        });
        jListDominioVeh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListDominioVehMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jListDominioVeh);

        jPanelListaDominioVeh.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 45));

        jPanelGlobalExamenes.add(jPanelListaDominioVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 241, 100, 45));

        jPanelElementoNoExistenteExamen.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelElementoNoExistenteExamen.setOpaque(false);
        jPanelElementoNoExistenteExamen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarElementoNoExistente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarElementoNoExistente2.setToolTipText("Has click para continuar.");
        jButtonAceptarElementoNoExistente2.setBorder(null);
        jButtonAceptarElementoNoExistente2.setBorderPainted(false);
        jButtonAceptarElementoNoExistente2.setContentAreaFilled(false);
        jButtonAceptarElementoNoExistente2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarElementoNoExistente2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarElementoNoExistente2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarElementoNoExistente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarElementoNoExistente2ActionPerformed(evt);
            }
        });
        jPanelElementoNoExistenteExamen.add(jButtonAceptarElementoNoExistente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorElementoNoExistente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelElementoNoExistenteExamen.add(jLabelIconoErrorElementoNoExistente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeElementoNoExistente4.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeElementoNoExistente4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeElementoNoExistente4.setText("No se guardo.");
        jPanelElementoNoExistenteExamen.add(jLabelMensajeElementoNoExistente4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeElementoNoExistente5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeElementoNoExistente5.setText(" Revise. Los datos no existen.");
        jPanelElementoNoExistenteExamen.add(jLabelMensajeElementoNoExistente5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 35, -1, 25));

        jLabelFondoIconoElementoNoExitente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelElementoNoExistenteExamen.add(jLabelFondoIconoElementoNoExitente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalExamenes.add(jPanelElementoNoExistenteExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jPanelElementoExistenteExamen.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelElementoExistenteExamen.setOpaque(false);
        jPanelElementoExistenteExamen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarElementoExistente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarElementoExistente2.setToolTipText("Has click para continuar.");
        jButtonAceptarElementoExistente2.setBorder(null);
        jButtonAceptarElementoExistente2.setBorderPainted(false);
        jButtonAceptarElementoExistente2.setContentAreaFilled(false);
        jButtonAceptarElementoExistente2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarElementoExistente2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarElementoExistente2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarElementoExistente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarElementoExistente2ActionPerformed(evt);
            }
        });
        jPanelElementoExistenteExamen.add(jButtonAceptarElementoExistente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorElementoExistente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelElementoExistenteExamen.add(jLabelIconoErrorElementoExistente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeElementoExistente4.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeElementoExistente4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeElementoExistente4.setText("No se guardo.");
        jPanelElementoExistenteExamen.add(jLabelMensajeElementoExistente4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeElementoExistente5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeElementoExistente5.setText(" Revise. Los datos ya existen.");
        jPanelElementoExistenteExamen.add(jLabelMensajeElementoExistente5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 35, -1, 25));

        jLabelFondoIconoElementoExitente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelElementoExistenteExamen.add(jLabelFondoIconoElementoExitente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalExamenes.add(jPanelElementoExistenteExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jPanelErrorBaseDeDatosExamen.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelErrorBaseDeDatosExamen.setOpaque(false);
        jPanelErrorBaseDeDatosExamen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarErrorBaseDeDatos3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarErrorBaseDeDatos3.setToolTipText("Has click para continuar.");
        jButtonAceptarErrorBaseDeDatos3.setBorder(null);
        jButtonAceptarErrorBaseDeDatos3.setBorderPainted(false);
        jButtonAceptarErrorBaseDeDatos3.setContentAreaFilled(false);
        jButtonAceptarErrorBaseDeDatos3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarErrorBaseDeDatos3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarErrorBaseDeDatos3.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarErrorBaseDeDatos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarErrorBaseDeDatos3ActionPerformed(evt);
            }
        });
        jPanelErrorBaseDeDatosExamen.add(jButtonAceptarErrorBaseDeDatos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorBaseDeDatos3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelErrorBaseDeDatosExamen.add(jLabelIconoErrorBaseDeDatos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeErrorBaseDeDatos6.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeErrorBaseDeDatos6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeErrorBaseDeDatos6.setText("Verifique que la Base de datos ");
        jPanelErrorBaseDeDatosExamen.add(jLabelMensajeErrorBaseDeDatos6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 190, 25));

        jLabelMensajeErrorBaseDeDatos7.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeErrorBaseDeDatos7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeErrorBaseDeDatos7.setText("este conectada. Vuelva a intentar.");
        jPanelErrorBaseDeDatosExamen.add(jLabelMensajeErrorBaseDeDatos7, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 35, 200, 25));

        jLabelFondoIconoErrorBaseDeDatos3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelErrorBaseDeDatosExamen.add(jLabelFondoIconoErrorBaseDeDatos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalExamenes.add(jPanelErrorBaseDeDatosExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jPanelGuardadoErroneoExamen.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelGuardadoErroneoExamen.setOpaque(false);
        jPanelGuardadoErroneoExamen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarGuardadoErroneo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarGuardadoErroneo3.setToolTipText("Has click para continuar.");
        jButtonAceptarGuardadoErroneo3.setBorder(null);
        jButtonAceptarGuardadoErroneo3.setBorderPainted(false);
        jButtonAceptarGuardadoErroneo3.setContentAreaFilled(false);
        jButtonAceptarGuardadoErroneo3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarGuardadoErroneo3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarGuardadoErroneo3.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarGuardadoErroneo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarGuardadoErroneo3ActionPerformed(evt);
            }
        });
        jPanelGuardadoErroneoExamen.add(jButtonAceptarGuardadoErroneo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoError3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelGuardadoErroneoExamen.add(jLabelIconoError3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeGuardadoErroneo6.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeGuardadoErroneo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeGuardadoErroneo6.setText("No se guardo.");
        jPanelGuardadoErroneoExamen.add(jLabelMensajeGuardadoErroneo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeGuardadoErroneo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeGuardadoErroneo7.setText(" Revise los datos ingresados.");
        jPanelGuardadoErroneoExamen.add(jLabelMensajeGuardadoErroneo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 35, -1, 25));

        jLabelFondoIconoGuardadoErroneo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelGuardadoErroneoExamen.add(jLabelFondoIconoGuardadoErroneo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalExamenes.add(jPanelGuardadoErroneoExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jPanelGuardadoExitosoExamen.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelGuardadoExitosoExamen.setOpaque(false);
        jPanelGuardadoExitosoExamen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarGuardadoExitoso2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarGuardadoExitoso2.setToolTipText("Has click para continuar.");
        jButtonAceptarGuardadoExitoso2.setBorder(null);
        jButtonAceptarGuardadoExitoso2.setBorderPainted(false);
        jButtonAceptarGuardadoExitoso2.setContentAreaFilled(false);
        jButtonAceptarGuardadoExitoso2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarGuardadoExitoso2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarGuardadoExitoso2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarGuardadoExitoso2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarGuardadoExitoso2ActionPerformed(evt);
            }
        });
        jPanelGuardadoExitosoExamen.add(jButtonAceptarGuardadoExitoso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoExito2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoExito25x25.png"))); // NOI18N
        jPanelGuardadoExitosoExamen.add(jLabelIconoExito2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeGuardadoCorrecto2.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeGuardadoCorrecto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeGuardadoCorrecto2.setText("Se guardo exitosamente.");
        jPanelGuardadoExitosoExamen.add(jLabelMensajeGuardadoCorrecto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 160, 25));

        jLabelFondoIconoGuardadoExitoso2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelGuardadoExitosoExamen.add(jLabelFondoIconoGuardadoExitoso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalExamenes.add(jPanelGuardadoExitosoExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jPanelMensajeValidarABMExamen.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelMensajeValidarABMExamen.setOpaque(false);
        jPanelMensajeValidarABMExamen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCancelarValidarCambios2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOff.png"))); // NOI18N
        jButtonCancelarValidarCambios2.setToolTipText("Has click para volver.");
        jButtonCancelarValidarCambios2.setBorder(null);
        jButtonCancelarValidarCambios2.setBorderPainted(false);
        jButtonCancelarValidarCambios2.setContentAreaFilled(false);
        jButtonCancelarValidarCambios2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelarValidarCambios2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOn.png"))); // NOI18N
        jButtonCancelarValidarCambios2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOn.png"))); // NOI18N
        jButtonCancelarValidarCambios2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarValidarCambios2ActionPerformed(evt);
            }
        });
        jPanelMensajeValidarABMExamen.add(jButtonCancelarValidarCambios2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        jButtonAceptarValidarCambios2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarValidarCambios2.setToolTipText("Has click para continuar.");
        jButtonAceptarValidarCambios2.setBorder(null);
        jButtonAceptarValidarCambios2.setBorderPainted(false);
        jButtonAceptarValidarCambios2.setContentAreaFilled(false);
        jButtonAceptarValidarCambios2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarValidarCambios2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarValidarCambios2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarValidarCambios2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarValidarCambios2ActionPerformed(evt);
            }
        });
        jPanelMensajeValidarABMExamen.add(jButtonAceptarValidarCambios2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabelIconoAlertaValidarCambios2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelMensajeValidarABMExamen.add(jLabelIconoAlertaValidarCambios2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeValidarCambios4.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeValidarCambios4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeValidarCambios4.setText("Revise los datos antes.");
        jPanelMensajeValidarABMExamen.add(jLabelMensajeValidarCambios4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeValidarCambios5.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeValidarCambios5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeValidarCambios5.setText("¿Seguro de realizar esta acción? ");
        jPanelMensajeValidarABMExamen.add(jLabelMensajeValidarCambios5, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 35, 190, 25));

        jLabelFondoIconoMensajeValidarCambios2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelMensajeValidarABMExamen.add(jLabelFondoIconoMensajeValidarCambios2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalExamenes.add(jPanelMensajeValidarABMExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jLabelTituloPosibleRetirador.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloPosibleRetirador.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloPosibleRetirador.setText("Lo retira:");
        jLabelTituloPosibleRetirador.setToolTipText("");
        jPanelGlobalExamenes.add(jLabelTituloPosibleRetirador, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 286, -1, 25));

        jTextFieldPosibleRetirador.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldPosibleRetirador.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldPosibleRetirador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPosibleRetirador.setToolTipText("Ingrese solo texto. Ej.: gastos");
        jTextFieldPosibleRetirador.setBorder(null);
        jTextFieldPosibleRetirador.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldPosibleRetirador.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldPosibleRetirador.setOpaque(false);
        jTextFieldPosibleRetirador.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldPosibleRetirador.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelGlobalExamenes.add(jTextFieldPosibleRetirador, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 306, 200, 20));

        jSeparatorPosibleRetirador.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorPosibleRetirador.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorPosibleRetirador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorPosibleRetirador.setOpaque(true);
        jPanelGlobalExamenes.add(jSeparatorPosibleRetirador, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 327, 200, -1));

        jLabelTituloDominioVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloDominioVeh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloDominioVeh.setText("Dominio:");
        jLabelTituloDominioVeh.setToolTipText("");
        jPanelGlobalExamenes.add(jLabelTituloDominioVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 201, -1, 25));

        jTextFieldDominioVeh.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldDominioVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldDominioVeh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDominioVeh.setToolTipText("Ingrese solo texto. Ej.: alejandro");
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
        jPanelGlobalExamenes.add(jTextFieldDominioVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 221, 100, 20));

        jSeparatorDominioVeh.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorDominioVeh.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorDominioVeh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorDominioVeh.setOpaque(true);
        jPanelGlobalExamenes.add(jSeparatorDominioVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 241, 100, -1));

        jButtonRegVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x25Off.png"))); // NOI18N
        jButtonRegVehiculo.setBorder(null);
        jButtonRegVehiculo.setBorderPainted(false);
        jButtonRegVehiculo.setContentAreaFilled(false);
        jButtonRegVehiculo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegVehiculo.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegVehiculoActionPerformed(evt);
            }
        });
        jPanelGlobalExamenes.add(jButtonRegVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 216, -1, -1));

        jLabelTituloIuCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuCartera.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuCartera.setText("Cartera:");
        jLabelTituloIuCartera.setToolTipText("");
        jPanelGlobalExamenes.add(jLabelTituloIuCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 201, -1, 25));

        jTextFieldIuCartera.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuCartera.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuCartera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuCartera.setToolTipText("Seleccione un item de la lista.");
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
        jPanelGlobalExamenes.add(jTextFieldIuCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 221, 200, 20));

        jSeparatorIuCartera.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuCartera.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuCartera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuCartera.setOpaque(true);
        jPanelGlobalExamenes.add(jSeparatorIuCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 241, 200, -1));

        jLabelTituloFechaExamen.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloFechaExamen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloFechaExamen.setText("Fecha de caja:");
        jLabelTituloFechaExamen.setToolTipText("");
        jPanelGlobalExamenes.add(jLabelTituloFechaExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 25, -1, 25));

        jTextFieldFechaExamen.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldFechaExamen.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldFechaExamen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldFechaExamen.setToolTipText("Ingrese solo numeros y guion(-). Ej.: 01-02-1999");
        jTextFieldFechaExamen.setBorder(null);
        jTextFieldFechaExamen.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaExamen.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaExamen.setOpaque(false);
        jTextFieldFechaExamen.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaExamen.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelGlobalExamenes.add(jTextFieldFechaExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 45, 100, 20));

        jSeparatorFechaExamen.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorFechaExamen.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorFechaExamen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorFechaExamen.setOpaque(true);
        jPanelGlobalExamenes.add(jSeparatorFechaExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 66, 100, -1));

        jLabelTituloNombExaminador.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloNombExaminador.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloNombExaminador.setText("Nombre examinador:");
        jLabelTituloNombExaminador.setToolTipText("");
        jPanelGlobalExamenes.add(jLabelTituloNombExaminador, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 113, -1, 25));

        jTextFieldNombExaminador.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldNombExaminador.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldNombExaminador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNombExaminador.setToolTipText("Seleccione un item de la lista.");
        jTextFieldNombExaminador.setBorder(null);
        jTextFieldNombExaminador.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldNombExaminador.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldNombExaminador.setOpaque(false);
        jTextFieldNombExaminador.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldNombExaminador.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelGlobalExamenes.add(jTextFieldNombExaminador, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 133, 200, 20));

        jSeparatorNombExaminador.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorNombExaminador.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorNombExaminador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorNombExaminador.setOpaque(true);
        jPanelGlobalExamenes.add(jSeparatorNombExaminador, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 153, 200, -1));

        jSeparatorNumExamenVeh.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorNumExamenVeh.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorNumExamenVeh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorNumExamenVeh.setOpaque(true);
        jPanelGlobalExamenes.add(jSeparatorNumExamenVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 66, 100, -1));

        jLabelTituloNumExamenVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloNumExamenVeh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloNumExamenVeh.setText("Codigo identificacion:");
        jLabelTituloNumExamenVeh.setToolTipText("");
        jPanelGlobalExamenes.add(jLabelTituloNumExamenVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 25, -1, 25));

        jTextFieldNumExamenVeh.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldNumExamenVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldNumExamenVeh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNumExamenVeh.setText("AUTOMATICO");
        jTextFieldNumExamenVeh.setToolTipText("");
        jTextFieldNumExamenVeh.setBorder(null);
        jTextFieldNumExamenVeh.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldNumExamenVeh.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldNumExamenVeh.setOpaque(false);
        jTextFieldNumExamenVeh.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldNumExamenVeh.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelGlobalExamenes.add(jTextFieldNumExamenVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 45, 100, 20));

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
        jPanelGlobalExamenes.add(jButtonRegCartera, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 216, -1, -1));

        jButtonAgregarExamen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOff.png"))); // NOI18N
        jButtonAgregarExamen.setToolTipText("Has click para agregar.");
        jButtonAgregarExamen.setBorder(null);
        jButtonAgregarExamen.setBorderPainted(false);
        jButtonAgregarExamen.setContentAreaFilled(false);
        jButtonAgregarExamen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregarExamen.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarExamen.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarExamenActionPerformed(evt);
            }
        });
        jPanelGlobalExamenes.add(jButtonAgregarExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 475, -1, -1));

        jButtonEditarExamen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOff.png"))); // NOI18N
        jButtonEditarExamen.setToolTipText("Has click para editar.");
        jButtonEditarExamen.setBorder(null);
        jButtonEditarExamen.setBorderPainted(false);
        jButtonEditarExamen.setContentAreaFilled(false);
        jButtonEditarExamen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditarExamen.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarExamen.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarExamenActionPerformed(evt);
            }
        });
        jPanelGlobalExamenes.add(jButtonEditarExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 475, -1, -1));

        jButtonBorrarExamen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOff.png"))); // NOI18N
        jButtonBorrarExamen.setToolTipText("Has click para borrar.");
        jButtonBorrarExamen.setBorder(null);
        jButtonBorrarExamen.setBorderPainted(false);
        jButtonBorrarExamen.setContentAreaFilled(false);
        jButtonBorrarExamen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBorrarExamen.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarExamen.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarExamenActionPerformed(evt);
            }
        });
        jPanelGlobalExamenes.add(jButtonBorrarExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 475, -1, -1));

        jButtonTraerPanelBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOff.png"))); // NOI18N
        jButtonTraerPanelBuscar1.setToolTipText("Menu buscar");
        jButtonTraerPanelBuscar1.setBorder(null);
        jButtonTraerPanelBuscar1.setBorderPainted(false);
        jButtonTraerPanelBuscar1.setContentAreaFilled(false);
        jButtonTraerPanelBuscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTraerPanelBuscar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOn.png"))); // NOI18N
        jButtonTraerPanelBuscar1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOn.png"))); // NOI18N
        jButtonTraerPanelBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTraerPanelBuscar1ActionPerformed(evt);
            }
        });
        jPanelGlobalExamenes.add(jButtonTraerPanelBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 10, -1, -1));

        jLabelFondoExamen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondoContenedorGlobal700x525Blanco.png"))); // NOI18N
        jPanelGlobalExamenes.add(jLabelFondoExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(-700, 0, -1, -1));

        getContentPane().add(jPanelGlobalExamenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-700, 0, 700, 525));

        jPanelVentanaBuscarExamen.setBackground(new java.awt.Color(245, 245, 245));
        jPanelVentanaBuscarExamen.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanelVentanaBuscarExamen.setMaximumSize(new java.awt.Dimension(700, 525));
        jPanelVentanaBuscarExamen.setPreferredSize(new java.awt.Dimension(500, 226));
        jPanelVentanaBuscarExamen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelItemNoSeleccionadoExamen.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelItemNoSeleccionadoExamen.setOpaque(false);
        jPanelItemNoSeleccionadoExamen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarItemNoSeleccionado3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarItemNoSeleccionado3.setToolTipText("Has click para continuar.");
        jButtonAceptarItemNoSeleccionado3.setBorder(null);
        jButtonAceptarItemNoSeleccionado3.setBorderPainted(false);
        jButtonAceptarItemNoSeleccionado3.setContentAreaFilled(false);
        jButtonAceptarItemNoSeleccionado3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarItemNoSeleccionado3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarItemNoSeleccionado3.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarItemNoSeleccionado3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarItemNoSeleccionado3ActionPerformed(evt);
            }
        });
        jPanelItemNoSeleccionadoExamen.add(jButtonAceptarItemNoSeleccionado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorItemNoSeleccionado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelItemNoSeleccionadoExamen.add(jLabelIconoErrorItemNoSeleccionado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeItemNoSeleccionado1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeItemNoSeleccionado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeItemNoSeleccionado1.setText("No selecciono un item de la tabla.");
        jPanelItemNoSeleccionadoExamen.add(jLabelMensajeItemNoSeleccionado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 20, 200, 25));

        jLabelFondoIconoItemNoSeleccionado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelItemNoSeleccionadoExamen.add(jLabelFondoIconoItemNoSeleccionado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelVentanaBuscarExamen.add(jPanelItemNoSeleccionadoExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jSeparatorBuscarExamen.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorBuscarExamen.setForeground(new java.awt.Color(0, 0, 0));
        jPanelVentanaBuscarExamen.add(jSeparatorBuscarExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 55, 100, 2));

        jScrollPane12.setBackground(new java.awt.Color(245, 245, 245));

        jTableCaja = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jTableExamen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nº examen", "Fecha examen", "Examinador", "Cartera", "Dominio", "Lo retira"
            }
        ));
        jTableExamen.setToolTipText("Has click derecho para opciones.");
        jTableExamen.setAutoscrolls(false);
        jTableExamen.setFocusable(false);
        jTableExamen.setMaximumSize(new java.awt.Dimension(480, 450));
        jTableExamen.setMinimumSize(new java.awt.Dimension(480, 450));
        jTableExamen.setPreferredSize(new java.awt.Dimension(480, 450));
        jTableExamen.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jTableExamen.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jTableExamen.getTableHeader().setReorderingAllowed(false);
        jScrollPane12.setViewportView(jTableExamen);

        jPanelVentanaBuscarExamen.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 680, 440));

        jLabelTituloBuscarExamen.setText("Parametro de busqueda:");
        jPanelVentanaBuscarExamen.add(jLabelTituloBuscarExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 10, -1, 25));

        jTextFieldBuscarExamen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBuscarExamen.setToolTipText("ingresa parametros de busqueda. Ej: vent");
        jTextFieldBuscarExamen.setBorder(null);
        jTextFieldBuscarExamen.setDisabledTextColor(new java.awt.Color(194, 4, 48));
        jTextFieldBuscarExamen.setOpaque(false);
        jTextFieldBuscarExamen.setSelectionColor(new java.awt.Color(73, 73, 73));
        jTextFieldBuscarExamen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarExamenKeyReleased(evt);
            }
        });
        jPanelVentanaBuscarExamen.add(jTextFieldBuscarExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 35, 100, 20));

        jButtonTraerPanelCuerpo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOff.png"))); // NOI18N
        jButtonTraerPanelCuerpo1.setToolTipText("Has click para volver al area de carga.");
        jButtonTraerPanelCuerpo1.setBorder(null);
        jButtonTraerPanelCuerpo1.setBorderPainted(false);
        jButtonTraerPanelCuerpo1.setContentAreaFilled(false);
        jButtonTraerPanelCuerpo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTraerPanelCuerpo1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOn.png"))); // NOI18N
        jButtonTraerPanelCuerpo1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOn.png"))); // NOI18N
        jButtonTraerPanelCuerpo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTraerPanelCuerpo1ActionPerformed(evt);
            }
        });
        jPanelVentanaBuscarExamen.add(jButtonTraerPanelCuerpo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 10, -1, -1));

        jLabelFondoExamen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondoContenedorGlobal700x525Blanco.png"))); // NOI18N
        jPanelVentanaBuscarExamen.add(jLabelFondoExamen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-700, 0, -1, -1));

        getContentPane().add(jPanelVentanaBuscarExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(-700, 65, 700, 525));

        jPanelVentanaBuscarPresup.setBackground(new java.awt.Color(245, 245, 245));
        jPanelVentanaBuscarPresup.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanelVentanaBuscarPresup.setMaximumSize(new java.awt.Dimension(700, 525));
        jPanelVentanaBuscarPresup.setPreferredSize(new java.awt.Dimension(500, 226));
        jPanelVentanaBuscarPresup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelItemNoSeleccionadoPresup.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelItemNoSeleccionadoPresup.setOpaque(false);
        jPanelItemNoSeleccionadoPresup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarItemNoSeleccionado4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarItemNoSeleccionado4.setToolTipText("Has click para continuar.");
        jButtonAceptarItemNoSeleccionado4.setBorder(null);
        jButtonAceptarItemNoSeleccionado4.setBorderPainted(false);
        jButtonAceptarItemNoSeleccionado4.setContentAreaFilled(false);
        jButtonAceptarItemNoSeleccionado4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarItemNoSeleccionado4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarItemNoSeleccionado4.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarItemNoSeleccionado4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarItemNoSeleccionado4ActionPerformed(evt);
            }
        });
        jPanelItemNoSeleccionadoPresup.add(jButtonAceptarItemNoSeleccionado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorItemNoSeleccionado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelItemNoSeleccionadoPresup.add(jLabelIconoErrorItemNoSeleccionado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeItemNoSeleccionado2.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeItemNoSeleccionado2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeItemNoSeleccionado2.setText("No selecciono un item de la tabla.");
        jPanelItemNoSeleccionadoPresup.add(jLabelMensajeItemNoSeleccionado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 20, 200, 25));

        jLabelFondoIconoItemNoSeleccionado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelItemNoSeleccionadoPresup.add(jLabelFondoIconoItemNoSeleccionado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelVentanaBuscarPresup.add(jPanelItemNoSeleccionadoPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jSeparatorBuscarPresup.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorBuscarPresup.setForeground(new java.awt.Color(0, 0, 0));
        jPanelVentanaBuscarPresup.add(jSeparatorBuscarPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 55, 100, 2));

        jScrollPane9.setBackground(new java.awt.Color(245, 245, 245));

        jTableCaja = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jTablePresup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nº registro", "Tipo caja", "Factura", "Fecha caja", "Fecha fac.", "A nombre", "Nº fac.", "Descripcion", "Total"
            }
        ));
        jTablePresup.setToolTipText("Has click derecho para opciones.");
        jTablePresup.setAutoscrolls(false);
        jTablePresup.setFocusable(false);
        jTablePresup.setMaximumSize(new java.awt.Dimension(480, 450));
        jTablePresup.setMinimumSize(new java.awt.Dimension(480, 450));
        jTablePresup.setPreferredSize(new java.awt.Dimension(480, 450));
        jTablePresup.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jTablePresup.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jTablePresup.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(jTablePresup);

        jPanelVentanaBuscarPresup.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 680, 440));

        jLabelTituloBuscarPresup.setText("Parametro de busqueda:");
        jPanelVentanaBuscarPresup.add(jLabelTituloBuscarPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 10, -1, 25));

        jTextFieldBuscarPresup.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBuscarPresup.setToolTipText("ingresa parametros de busqueda. Ej: vent");
        jTextFieldBuscarPresup.setBorder(null);
        jTextFieldBuscarPresup.setDisabledTextColor(new java.awt.Color(194, 4, 48));
        jTextFieldBuscarPresup.setOpaque(false);
        jTextFieldBuscarPresup.setSelectionColor(new java.awt.Color(73, 73, 73));
        jTextFieldBuscarPresup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarPresupKeyReleased(evt);
            }
        });
        jPanelVentanaBuscarPresup.add(jTextFieldBuscarPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 35, 100, 20));

        jButtonTraerPanelCuerpoPresup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOff.png"))); // NOI18N
        jButtonTraerPanelCuerpoPresup.setToolTipText("Has click para volver al area de carga.");
        jButtonTraerPanelCuerpoPresup.setBorder(null);
        jButtonTraerPanelCuerpoPresup.setBorderPainted(false);
        jButtonTraerPanelCuerpoPresup.setContentAreaFilled(false);
        jButtonTraerPanelCuerpoPresup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTraerPanelCuerpoPresup.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOn.png"))); // NOI18N
        jButtonTraerPanelCuerpoPresup.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOn.png"))); // NOI18N
        jButtonTraerPanelCuerpoPresup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTraerPanelCuerpoPresupActionPerformed(evt);
            }
        });
        jPanelVentanaBuscarPresup.add(jButtonTraerPanelCuerpoPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 10, -1, -1));

        jLabelFondoPresup1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondoContenedorGlobal700x525Blanco.png"))); // NOI18N
        jPanelVentanaBuscarPresup.add(jLabelFondoPresup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-700, 0, -1, -1));

        getContentPane().add(jPanelVentanaBuscarPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1000, 65, 700, 525));

        jPanelGlobalCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelListaIuTipoCaja.setOpaque(false);
        jPanelListaIuTipoCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(200, 45));

        jListTipoCaja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListTipoCajaFocusGained(evt);
            }
        });
        jListTipoCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListTipoCajaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListTipoCaja);

        jPanelListaIuTipoCaja.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 45));

        jPanelGlobalCaja.add(jPanelListaIuTipoCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 138, 200, 45));

        jPanelListaIuTipoFactura.setOpaque(false);
        jPanelListaIuTipoFactura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(200, 45));

        jListTipoFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListTipoFacturaFocusGained(evt);
            }
        });
        jListTipoFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListTipoFacturaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jListTipoFactura);

        jPanelListaIuTipoFactura.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 45));

        jPanelGlobalCaja.add(jPanelListaIuTipoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 216, 100, 45));

        jPanelElementoNoExistenteCaja.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelElementoNoExistenteCaja.setOpaque(false);
        jPanelElementoNoExistenteCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanelElementoNoExistenteCaja.add(jButtonAceptarElementoNoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorElementoNoExistente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelElementoNoExistenteCaja.add(jLabelIconoErrorElementoNoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeElementoNoExistente.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeElementoNoExistente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeElementoNoExistente.setText("No se guardo.");
        jPanelElementoNoExistenteCaja.add(jLabelMensajeElementoNoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeElementoNoExistente2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeElementoNoExistente2.setText(" Revise. Los datos no existen.");
        jPanelElementoNoExistenteCaja.add(jLabelMensajeElementoNoExistente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 35, -1, 25));

        jLabelFondoIconoElementoNoExitente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelElementoNoExistenteCaja.add(jLabelFondoIconoElementoNoExitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalCaja.add(jPanelElementoNoExistenteCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jPanelElementoExistenteCaja.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelElementoExistenteCaja.setOpaque(false);
        jPanelElementoExistenteCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanelElementoExistenteCaja.add(jButtonAceptarElementoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorElementoExistente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelElementoExistenteCaja.add(jLabelIconoErrorElementoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeElementoExistente.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeElementoExistente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeElementoExistente.setText("No se guardo.");
        jPanelElementoExistenteCaja.add(jLabelMensajeElementoExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeElementoExistente2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeElementoExistente2.setText(" Revise. Los datos ya existen.");
        jPanelElementoExistenteCaja.add(jLabelMensajeElementoExistente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 35, -1, 25));

        jLabelFondoIconoElementoExitente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelElementoExistenteCaja.add(jLabelFondoIconoElementoExitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalCaja.add(jPanelElementoExistenteCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jPanelErrorBaseDeDatosCaja.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelErrorBaseDeDatosCaja.setOpaque(false);
        jPanelErrorBaseDeDatosCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarErrorBaseDeDatos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarErrorBaseDeDatos1.setToolTipText("Has click para continuar.");
        jButtonAceptarErrorBaseDeDatos1.setBorder(null);
        jButtonAceptarErrorBaseDeDatos1.setBorderPainted(false);
        jButtonAceptarErrorBaseDeDatos1.setContentAreaFilled(false);
        jButtonAceptarErrorBaseDeDatos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarErrorBaseDeDatos1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarErrorBaseDeDatos1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarErrorBaseDeDatos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarErrorBaseDeDatos1ActionPerformed(evt);
            }
        });
        jPanelErrorBaseDeDatosCaja.add(jButtonAceptarErrorBaseDeDatos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorBaseDeDatos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelErrorBaseDeDatosCaja.add(jLabelIconoErrorBaseDeDatos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeErrorBaseDeDatos2.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeErrorBaseDeDatos2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeErrorBaseDeDatos2.setText("Verifique que la Base de datos ");
        jPanelErrorBaseDeDatosCaja.add(jLabelMensajeErrorBaseDeDatos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 190, 25));

        jLabelMensajeErrorBaseDeDatos3.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeErrorBaseDeDatos3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeErrorBaseDeDatos3.setText("este conectada. Vuelva a intentar.");
        jPanelErrorBaseDeDatosCaja.add(jLabelMensajeErrorBaseDeDatos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 35, 200, 25));

        jLabelFondoIconoErrorBaseDeDatos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelErrorBaseDeDatosCaja.add(jLabelFondoIconoErrorBaseDeDatos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalCaja.add(jPanelErrorBaseDeDatosCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jPanelGuardadoErroneoCaja.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelGuardadoErroneoCaja.setOpaque(false);
        jPanelGuardadoErroneoCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanelGuardadoErroneoCaja.add(jButtonAceptarGuardadoErroneo, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelGuardadoErroneoCaja.add(jLabelIconoError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeGuardadoErroneo.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeGuardadoErroneo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeGuardadoErroneo.setText("No se guardo.");
        jPanelGuardadoErroneoCaja.add(jLabelMensajeGuardadoErroneo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeGuardadoErroneo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeGuardadoErroneo2.setText(" Revise los datos ingresados.");
        jPanelGuardadoErroneoCaja.add(jLabelMensajeGuardadoErroneo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 35, -1, 25));

        jLabelFondoIconoGuardadoErroneo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelGuardadoErroneoCaja.add(jLabelFondoIconoGuardadoErroneo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalCaja.add(jPanelGuardadoErroneoCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jPanelGuardadoExitosoCaja.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelGuardadoExitosoCaja.setOpaque(false);
        jPanelGuardadoExitosoCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanelGuardadoExitosoCaja.add(jButtonAceptarGuardadoExitoso, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoExito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoExito25x25.png"))); // NOI18N
        jPanelGuardadoExitosoCaja.add(jLabelIconoExito, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeGuardadoCorrecto.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeGuardadoCorrecto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeGuardadoCorrecto.setText("Se guardo exitosamente.");
        jPanelGuardadoExitosoCaja.add(jLabelMensajeGuardadoCorrecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 160, 25));

        jLabelFondoIconoGuardadoExitoso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelGuardadoExitosoCaja.add(jLabelFondoIconoGuardadoExitoso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalCaja.add(jPanelGuardadoExitosoCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jPanelDatosErroneoCaja.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelDatosErroneoCaja.setOpaque(false);
        jPanelDatosErroneoCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarGuardadoErroneo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarGuardadoErroneo2.setToolTipText("Has click para continuar.");
        jButtonAceptarGuardadoErroneo2.setBorder(null);
        jButtonAceptarGuardadoErroneo2.setBorderPainted(false);
        jButtonAceptarGuardadoErroneo2.setContentAreaFilled(false);
        jButtonAceptarGuardadoErroneo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarGuardadoErroneo2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarGuardadoErroneo2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarGuardadoErroneo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarGuardadoErroneo2ActionPerformed(evt);
            }
        });
        jPanelDatosErroneoCaja.add(jButtonAceptarGuardadoErroneo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoError2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelDatosErroneoCaja.add(jLabelIconoError2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeGuardadoErroneo4.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeGuardadoErroneo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeGuardadoErroneo4.setText("Se necesita un minimo ");
        jPanelDatosErroneoCaja.add(jLabelMensajeGuardadoErroneo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeGuardadoErroneo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeGuardadoErroneo5.setText("       de datos correctos.");
        jPanelDatosErroneoCaja.add(jLabelMensajeGuardadoErroneo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 35, -1, 25));

        jLabelFondoIconoGuardadoErroneo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelDatosErroneoCaja.add(jLabelFondoIconoGuardadoErroneo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalCaja.add(jPanelDatosErroneoCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jPanelMensajeValidarABMCaja.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelMensajeValidarABMCaja.setOpaque(false);
        jPanelMensajeValidarABMCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanelMensajeValidarABMCaja.add(jButtonCancelarValidarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

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
        jPanelMensajeValidarABMCaja.add(jButtonAceptarValidarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabelIconoAlertaValidarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelMensajeValidarABMCaja.add(jLabelIconoAlertaValidarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeValidarCambios.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeValidarCambios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeValidarCambios.setText("Revise los datos antes.");
        jPanelMensajeValidarABMCaja.add(jLabelMensajeValidarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeValidarCambios1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeValidarCambios1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeValidarCambios1.setText("¿Seguro de realizar esta acción? ");
        jPanelMensajeValidarABMCaja.add(jLabelMensajeValidarCambios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 35, 190, 25));

        jLabelFondoIconoMensajeValidarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelMensajeValidarABMCaja.add(jLabelFondoIconoMensajeValidarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalCaja.add(jPanelMensajeValidarABMCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jLabelTituloTotalCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloTotalCaja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloTotalCaja.setText("Total:");
        jLabelTituloTotalCaja.setToolTipText("");
        jPanelGlobalCaja.add(jLabelTituloTotalCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 256, -1, 25));

        jTextFieldTotalCaja.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldTotalCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldTotalCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTotalCaja.setToolTipText("Ingrese solo numero deciales. Ej.: 233.00");
        jTextFieldTotalCaja.setBorder(null);
        jTextFieldTotalCaja.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldTotalCaja.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldTotalCaja.setOpaque(false);
        jTextFieldTotalCaja.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldTotalCaja.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelGlobalCaja.add(jTextFieldTotalCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 276, 100, 20));

        jSeparatorTotalCaja.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorTotalCaja.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorTotalCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorTotalCaja.setOpaque(true);
        jPanelGlobalCaja.add(jSeparatorTotalCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 296, 100, -1));

        jLabelTituloDescrCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloDescrCaja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloDescrCaja.setText("Descripcion:");
        jLabelTituloDescrCaja.setToolTipText("");
        jPanelGlobalCaja.add(jLabelTituloDescrCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 256, -1, 25));

        jTextFieldDescrCaja.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldDescrCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldDescrCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDescrCaja.setToolTipText("Ingrese solo texto. Ej.: gastos");
        jTextFieldDescrCaja.setBorder(null);
        jTextFieldDescrCaja.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldDescrCaja.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldDescrCaja.setOpaque(false);
        jTextFieldDescrCaja.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldDescrCaja.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelGlobalCaja.add(jTextFieldDescrCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 276, 200, 20));

        jSeparatorDescrCaja.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorDescrCaja.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorDescrCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorDescrCaja.setOpaque(true);
        jPanelGlobalCaja.add(jSeparatorDescrCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 297, 200, -1));

        jLabelTituloNumFactura.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloNumFactura.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloNumFactura.setText("Numero de factura:");
        jLabelTituloNumFactura.setToolTipText("");
        jPanelGlobalCaja.add(jLabelTituloNumFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 176, -1, 25));

        jTextFieldNumFactura.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldNumFactura.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldNumFactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNumFactura.setToolTipText("Ingrese solo numeros. Ej.: 0033");
        jTextFieldNumFactura.setBorder(null);
        jTextFieldNumFactura.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldNumFactura.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldNumFactura.setOpaque(false);
        jTextFieldNumFactura.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldNumFactura.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelGlobalCaja.add(jTextFieldNumFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 196, 100, 20));

        jSeparatorNumFactura.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorNumFactura.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorNumFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorNumFactura.setOpaque(true);
        jPanelGlobalCaja.add(jSeparatorNumFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 217, 100, -1));

        jLabelTituloANombreDe.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloANombreDe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloANombreDe.setText("A nombre de:");
        jLabelTituloANombreDe.setToolTipText("");
        jPanelGlobalCaja.add(jLabelTituloANombreDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 176, -1, 25));

        jTextFieldANombreDe.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldANombreDe.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldANombreDe.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldANombreDe.setToolTipText("Ingrese solo texto. Ej.: alejandro");
        jTextFieldANombreDe.setBorder(null);
        jTextFieldANombreDe.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldANombreDe.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldANombreDe.setOpaque(false);
        jTextFieldANombreDe.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldANombreDe.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelGlobalCaja.add(jTextFieldANombreDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 196, 200, 20));

        jSeparatorANombreDe.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorANombreDe.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorANombreDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorANombreDe.setOpaque(true);
        jPanelGlobalCaja.add(jSeparatorANombreDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 217, 200, -1));

        jLabelTituloFechaFactura.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloFechaFactura.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloFechaFactura.setText("Fecha de factura:");
        jLabelTituloFechaFactura.setToolTipText("");
        jPanelGlobalCaja.add(jLabelTituloFechaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 176, -1, 25));

        jTextFieldFechaFactura.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldFechaFactura.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldFechaFactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldFechaFactura.setToolTipText("Ingrese solo numeros y guion(-). Ej.: 01-02-1999");
        jTextFieldFechaFactura.setBorder(null);
        jTextFieldFechaFactura.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaFactura.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaFactura.setOpaque(false);
        jTextFieldFechaFactura.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaFactura.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelGlobalCaja.add(jTextFieldFechaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 196, 100, 20));

        jSeparatorFechaFactura.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorFechaFactura.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorFechaFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorFechaFactura.setOpaque(true);
        jPanelGlobalCaja.add(jSeparatorFechaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 218, 100, -1));

        jButtonRegTipoFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x25Off.png"))); // NOI18N
        jButtonRegTipoFactura.setBorder(null);
        jButtonRegTipoFactura.setBorderPainted(false);
        jButtonRegTipoFactura.setContentAreaFilled(false);
        jButtonRegTipoFactura.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegTipoFactura.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegTipoFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegTipoFacturaActionPerformed(evt);
            }
        });
        jPanelGlobalCaja.add(jButtonRegTipoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 191, -1, -1));

        jLabelTituloIuTipoFactura.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuTipoFactura.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuTipoFactura.setText("Tipo de factura:");
        jLabelTituloIuTipoFactura.setToolTipText("");
        jPanelGlobalCaja.add(jLabelTituloIuTipoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 176, -1, 25));

        jTextFieldIuTipoFactura.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuTipoFactura.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuTipoFactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuTipoFactura.setToolTipText("Seleccione un item de la lista.");
        jTextFieldIuTipoFactura.setBorder(null);
        jTextFieldIuTipoFactura.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuTipoFactura.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuTipoFactura.setOpaque(false);
        jTextFieldIuTipoFactura.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuTipoFactura.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldIuTipoFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIuTipoFacturaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldIuTipoFacturaFocusLost(evt);
            }
        });
        jTextFieldIuTipoFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldIuTipoFacturaKeyReleased(evt);
            }
        });
        jPanelGlobalCaja.add(jTextFieldIuTipoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 196, 100, 20));

        jSeparatorIuTipoFactura.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuTipoFactura.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuTipoFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuTipoFactura.setOpaque(true);
        jPanelGlobalCaja.add(jSeparatorIuTipoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 216, 100, -1));

        jLabelTituloFechaCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloFechaCaja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloFechaCaja.setText("Fecha de caja:");
        jLabelTituloFechaCaja.setToolTipText("");
        jPanelGlobalCaja.add(jLabelTituloFechaCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 98, -1, 25));

        jTextFieldFechaCaja.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldFechaCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldFechaCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldFechaCaja.setToolTipText("Ingrese solo numeros y guion(-). Ej.: 01-02-1999");
        jTextFieldFechaCaja.setBorder(null);
        jTextFieldFechaCaja.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaCaja.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaCaja.setOpaque(false);
        jTextFieldFechaCaja.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaCaja.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelGlobalCaja.add(jTextFieldFechaCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 118, 100, 20));

        jSeparatorFechaCaja.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorFechaCaja.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorFechaCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorFechaCaja.setOpaque(true);
        jPanelGlobalCaja.add(jSeparatorFechaCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 138, 100, -1));

        jButtonRegTipoCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x25Off.png"))); // NOI18N
        jButtonRegTipoCaja.setBorder(null);
        jButtonRegTipoCaja.setBorderPainted(false);
        jButtonRegTipoCaja.setContentAreaFilled(false);
        jButtonRegTipoCaja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegTipoCaja.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegTipoCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegTipoCajaActionPerformed(evt);
            }
        });
        jPanelGlobalCaja.add(jButtonRegTipoCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 115, -1, -1));

        jLabelTituloIuTipoCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuTipoCaja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuTipoCaja.setText("Tipo de caja:");
        jLabelTituloIuTipoCaja.setToolTipText("");
        jPanelGlobalCaja.add(jLabelTituloIuTipoCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 98, -1, 25));

        jTextFieldIuTipoCaja.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuTipoCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuTipoCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuTipoCaja.setToolTipText("Seleccione un item de la lista.");
        jTextFieldIuTipoCaja.setBorder(null);
        jTextFieldIuTipoCaja.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuTipoCaja.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuTipoCaja.setOpaque(false);
        jTextFieldIuTipoCaja.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuTipoCaja.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldIuTipoCaja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIuTipoCajaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldIuTipoCajaFocusLost(evt);
            }
        });
        jTextFieldIuTipoCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldIuTipoCajaKeyReleased(evt);
            }
        });
        jPanelGlobalCaja.add(jTextFieldIuTipoCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 118, 200, 20));

        jSeparatorIuTipoCaja.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuTipoCaja.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuTipoCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuTipoCaja.setOpaque(true);
        jPanelGlobalCaja.add(jSeparatorIuTipoCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 138, 200, -1));

        jSeparatorIuCaja.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuCaja.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuCaja.setOpaque(true);
        jPanelGlobalCaja.add(jSeparatorIuCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 66, 100, -1));

        jLabelTituloIuCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuCaja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuCaja.setText("Codigo identificacion:");
        jLabelTituloIuCaja.setToolTipText("");
        jPanelGlobalCaja.add(jLabelTituloIuCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 25, -1, 25));

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
        jPanelGlobalCaja.add(jTextFieldIuCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 45, 100, 20));

        jButtonAgregarCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOff.png"))); // NOI18N
        jButtonAgregarCaja.setToolTipText("Has click para agregar.");
        jButtonAgregarCaja.setBorder(null);
        jButtonAgregarCaja.setBorderPainted(false);
        jButtonAgregarCaja.setContentAreaFilled(false);
        jButtonAgregarCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregarCaja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarCaja.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarCajaActionPerformed(evt);
            }
        });
        jPanelGlobalCaja.add(jButtonAgregarCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 475, -1, -1));

        jButtonEditarCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOff.png"))); // NOI18N
        jButtonEditarCaja.setToolTipText("Has click para editar.");
        jButtonEditarCaja.setBorder(null);
        jButtonEditarCaja.setBorderPainted(false);
        jButtonEditarCaja.setContentAreaFilled(false);
        jButtonEditarCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditarCaja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarCaja.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarCajaActionPerformed(evt);
            }
        });
        jPanelGlobalCaja.add(jButtonEditarCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 475, -1, -1));

        jButtonBorrarCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOff.png"))); // NOI18N
        jButtonBorrarCaja.setToolTipText("Has click para borrar.");
        jButtonBorrarCaja.setBorder(null);
        jButtonBorrarCaja.setBorderPainted(false);
        jButtonBorrarCaja.setContentAreaFilled(false);
        jButtonBorrarCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBorrarCaja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarCaja.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarCajaActionPerformed(evt);
            }
        });
        jPanelGlobalCaja.add(jButtonBorrarCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 475, -1, -1));

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
        jPanelGlobalCaja.add(jButtonTraerPanelBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 10, -1, -1));

        jScrollPane2.setViewportView(jListDetalleCaja);

        jPanelGlobalCaja.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 342, 400, 70));

        jButtonRegDetalleCaja.setFont(new java.awt.Font("Open Sans Extrabold", 0, 12)); // NOI18N
        jButtonRegDetalleCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonAgregarDetalles120x25Off.png"))); // NOI18N
        jButtonRegDetalleCaja.setToolTipText("Has click para detallar.");
        jButtonRegDetalleCaja.setBorder(null);
        jButtonRegDetalleCaja.setBorderPainted(false);
        jButtonRegDetalleCaja.setContentAreaFilled(false);
        jButtonRegDetalleCaja.setFocusable(false);
        jButtonRegDetalleCaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegDetalleCaja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonAgregarDetalles120x25On.png"))); // NOI18N
        jButtonRegDetalleCaja.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonAgregarDetalles120x25Off.png"))); // NOI18N
        jButtonRegDetalleCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegDetalleCajaActionPerformed(evt);
            }
        });
        jPanelGlobalCaja.add(jButtonRegDetalleCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 347, 120, 25));

        jLabelFondoCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondoContenedorGlobal700x525Blanco.png"))); // NOI18N
        jPanelGlobalCaja.add(jLabelFondoCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(-700, 0, -1, -1));

        getContentPane().add(jPanelGlobalCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(-700, 65, 700, 525));

        jPanelVentanaBuscarCaja.setBackground(new java.awt.Color(245, 245, 245));
        jPanelVentanaBuscarCaja.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanelVentanaBuscarCaja.setMaximumSize(new java.awt.Dimension(700, 525));
        jPanelVentanaBuscarCaja.setMinimumSize(new java.awt.Dimension(700, 525));
        jPanelVentanaBuscarCaja.setPreferredSize(new java.awt.Dimension(500, 226));
        jPanelVentanaBuscarCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelItemNoSeleccionadoCaja.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelItemNoSeleccionadoCaja.setOpaque(false);
        jPanelItemNoSeleccionadoCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanelItemNoSeleccionadoCaja.add(jButtonAceptarItemNoSeleccionado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorItemNoSeleccionado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelItemNoSeleccionadoCaja.add(jLabelIconoErrorItemNoSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeItemNoSeleccionado.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeItemNoSeleccionado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeItemNoSeleccionado.setText("No selecciono un item de la tabla.");
        jPanelItemNoSeleccionadoCaja.add(jLabelMensajeItemNoSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 20, 200, 25));

        jLabelFondoIconoItemNoSeleccionado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelItemNoSeleccionadoCaja.add(jLabelFondoIconoItemNoSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelVentanaBuscarCaja.add(jPanelItemNoSeleccionadoCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jPanelErrorBaseDeDatosCaja1.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelErrorBaseDeDatosCaja1.setOpaque(false);
        jPanelErrorBaseDeDatosCaja1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarErrorBaseDeDatos4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarErrorBaseDeDatos4.setToolTipText("Has click para continuar.");
        jButtonAceptarErrorBaseDeDatos4.setBorder(null);
        jButtonAceptarErrorBaseDeDatos4.setBorderPainted(false);
        jButtonAceptarErrorBaseDeDatos4.setContentAreaFilled(false);
        jButtonAceptarErrorBaseDeDatos4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarErrorBaseDeDatos4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarErrorBaseDeDatos4.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarErrorBaseDeDatos4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarErrorBaseDeDatos4ActionPerformed(evt);
            }
        });
        jPanelErrorBaseDeDatosCaja1.add(jButtonAceptarErrorBaseDeDatos4, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorBaseDeDatos4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelErrorBaseDeDatosCaja1.add(jLabelIconoErrorBaseDeDatos4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeErrorBaseDeDatos8.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeErrorBaseDeDatos8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeErrorBaseDeDatos8.setText("Verifique que la Base de datos ");
        jPanelErrorBaseDeDatosCaja1.add(jLabelMensajeErrorBaseDeDatos8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 190, 25));

        jLabelMensajeErrorBaseDeDatos9.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeErrorBaseDeDatos9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeErrorBaseDeDatos9.setText("este conectada. Vuelva a intentar.");
        jPanelErrorBaseDeDatosCaja1.add(jLabelMensajeErrorBaseDeDatos9, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 35, 200, 25));

        jLabelFondoIconoErrorBaseDeDatos4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelErrorBaseDeDatosCaja1.add(jLabelFondoIconoErrorBaseDeDatos4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelVentanaBuscarCaja.add(jPanelErrorBaseDeDatosCaja1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jSeparatorBuscarCaja.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorBuscarCaja.setForeground(new java.awt.Color(0, 0, 0));
        jPanelVentanaBuscarCaja.add(jSeparatorBuscarCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 55, 100, 2));

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));

        jTableCaja = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jTableCaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nº registro", "Tipo caja", "Factura", "Fecha caja", "Fecha fac.", "A nombre", "Nº fac.", "Descripcion", "Total"
            }
        ));
        jTableCaja.setToolTipText("Has click derecho para opciones.");
        jTableCaja.setAutoscrolls(false);
        jTableCaja.setFocusable(false);
        jTableCaja.setMaximumSize(new java.awt.Dimension(480, 450));
        jTableCaja.setMinimumSize(new java.awt.Dimension(480, 450));
        jTableCaja.setPreferredSize(new java.awt.Dimension(480, 450));
        jTableCaja.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jTableCaja.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jTableCaja.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableCaja);

        jPanelVentanaBuscarCaja.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 680, 440));

        jLabelTituloBuscarCaja.setText("Parametro de busqueda:");
        jPanelVentanaBuscarCaja.add(jLabelTituloBuscarCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 10, -1, 25));

        jTextFieldBuscarCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBuscarCaja.setToolTipText("ingresa parametros de busqueda. Ej: vent");
        jTextFieldBuscarCaja.setBorder(null);
        jTextFieldBuscarCaja.setDisabledTextColor(new java.awt.Color(194, 4, 48));
        jTextFieldBuscarCaja.setOpaque(false);
        jTextFieldBuscarCaja.setSelectionColor(new java.awt.Color(73, 73, 73));
        jTextFieldBuscarCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarCajaKeyReleased(evt);
            }
        });
        jPanelVentanaBuscarCaja.add(jTextFieldBuscarCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 35, 100, 20));

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
        jPanelVentanaBuscarCaja.add(jButtonTraerPanelCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 10, -1, -1));

        jLabelFondoCaja1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondoContenedorGlobal700x525Blanco.png"))); // NOI18N
        jPanelVentanaBuscarCaja.add(jLabelFondoCaja1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-700, 0, -1, -1));

        getContentPane().add(jPanelVentanaBuscarCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1000, 65, 700, 525));

        jPanelGlobalPresupuesto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelListaIuMarcaCris.setOpaque(false);
        jPanelListaIuMarcaCris.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane7.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane7.setPreferredSize(new java.awt.Dimension(100, 45));

        jListMarcasCristales.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListMarcasCristalesFocusGained(evt);
            }
        });
        jListMarcasCristales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListMarcasCristalesMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jListMarcasCristales);

        jPanelListaIuMarcaCris.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 45));

        jPanelGlobalPresupuesto.add(jPanelListaIuMarcaCris, new org.netbeans.lib.awtextra.AbsoluteConstraints(-101, 297, 100, 45));

        jPanelListaIuServicios.setOpaque(false);
        jPanelListaIuServicios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane8.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane8.setPreferredSize(new java.awt.Dimension(200, 45));

        jListServiciosPrestados.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListServiciosPrestadosFocusGained(evt);
            }
        });
        jListServiciosPrestados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListServiciosPrestadosMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jListServiciosPrestados);

        jPanelListaIuServicios.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 45));

        jPanelGlobalPresupuesto.add(jPanelListaIuServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(-101, 297, 100, 45));

        jPanelListaCodModeloVeh.setOpaque(false);
        jPanelListaCodModeloVeh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane5.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane5.setPreferredSize(new java.awt.Dimension(200, 45));

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
        jScrollPane5.setViewportView(jListModeloVeh);

        jPanelListaCodModeloVeh.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 45));

        jPanelGlobalPresupuesto.add(jPanelListaCodModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(-201, 216, 200, 45));

        jPanelListaCodigoCristal.setOpaque(false);
        jPanelListaCodigoCristal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane6.setMinimumSize(new java.awt.Dimension(200, 45));
        jScrollPane6.setPreferredSize(new java.awt.Dimension(200, 45));

        jListCodigoCrstal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListCodigoCrstalFocusGained(evt);
            }
        });
        jListCodigoCrstal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListCodigoCrstalMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jListCodigoCrstal);

        jPanelListaCodigoCristal.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 45));

        jPanelGlobalPresupuesto.add(jPanelListaCodigoCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(-101, 297, 100, 45));

        jPanelElementoNoExistentePresup.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelElementoNoExistentePresup.setOpaque(false);
        jPanelElementoNoExistentePresup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarElementoNoExistente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarElementoNoExistente1.setToolTipText("Has click para continuar.");
        jButtonAceptarElementoNoExistente1.setBorder(null);
        jButtonAceptarElementoNoExistente1.setBorderPainted(false);
        jButtonAceptarElementoNoExistente1.setContentAreaFilled(false);
        jButtonAceptarElementoNoExistente1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarElementoNoExistente1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarElementoNoExistente1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarElementoNoExistente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarElementoNoExistente1ActionPerformed(evt);
            }
        });
        jPanelElementoNoExistentePresup.add(jButtonAceptarElementoNoExistente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorElementoNoExistente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelElementoNoExistentePresup.add(jLabelIconoErrorElementoNoExistente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeElementoNoExistente1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeElementoNoExistente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeElementoNoExistente1.setText("No se guardo.");
        jPanelElementoNoExistentePresup.add(jLabelMensajeElementoNoExistente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeElementoNoExistente3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeElementoNoExistente3.setText(" Revise. Los datos no existen.");
        jPanelElementoNoExistentePresup.add(jLabelMensajeElementoNoExistente3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 35, -1, 25));

        jLabelFondoIconoElementoNoExitente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelElementoNoExistentePresup.add(jLabelFondoIconoElementoNoExitente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalPresupuesto.add(jPanelElementoNoExistentePresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jPanelElementoExistentePresup.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelElementoExistentePresup.setOpaque(false);
        jPanelElementoExistentePresup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarElementoExistente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarElementoExistente1.setToolTipText("Has click para continuar.");
        jButtonAceptarElementoExistente1.setBorder(null);
        jButtonAceptarElementoExistente1.setBorderPainted(false);
        jButtonAceptarElementoExistente1.setContentAreaFilled(false);
        jButtonAceptarElementoExistente1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarElementoExistente1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarElementoExistente1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarElementoExistente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarElementoExistente1ActionPerformed(evt);
            }
        });
        jPanelElementoExistentePresup.add(jButtonAceptarElementoExistente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorElementoExistente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelElementoExistentePresup.add(jLabelIconoErrorElementoExistente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeElementoExistente1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeElementoExistente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeElementoExistente1.setText("No se guardo.");
        jPanelElementoExistentePresup.add(jLabelMensajeElementoExistente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeElementoExistente3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeElementoExistente3.setText(" Revise. Los datos ya existen.");
        jPanelElementoExistentePresup.add(jLabelMensajeElementoExistente3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 35, -1, 25));

        jLabelFondoIconoElementoExitente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelElementoExistentePresup.add(jLabelFondoIconoElementoExitente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalPresupuesto.add(jPanelElementoExistentePresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jPanelErrorBaseDeDatosPresup.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelErrorBaseDeDatosPresup.setOpaque(false);
        jPanelErrorBaseDeDatosPresup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarErrorBaseDeDatos2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarErrorBaseDeDatos2.setToolTipText("Has click para continuar.");
        jButtonAceptarErrorBaseDeDatos2.setBorder(null);
        jButtonAceptarErrorBaseDeDatos2.setBorderPainted(false);
        jButtonAceptarErrorBaseDeDatos2.setContentAreaFilled(false);
        jButtonAceptarErrorBaseDeDatos2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarErrorBaseDeDatos2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarErrorBaseDeDatos2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarErrorBaseDeDatos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarErrorBaseDeDatos2ActionPerformed(evt);
            }
        });
        jPanelErrorBaseDeDatosPresup.add(jButtonAceptarErrorBaseDeDatos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoErrorBaseDeDatos2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelErrorBaseDeDatosPresup.add(jLabelIconoErrorBaseDeDatos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeErrorBaseDeDatos4.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeErrorBaseDeDatos4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeErrorBaseDeDatos4.setText("Verifique que la Base de datos ");
        jPanelErrorBaseDeDatosPresup.add(jLabelMensajeErrorBaseDeDatos4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 190, 25));

        jLabelMensajeErrorBaseDeDatos5.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeErrorBaseDeDatos5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeErrorBaseDeDatos5.setText("este conectada. Vuelva a intentar.");
        jPanelErrorBaseDeDatosPresup.add(jLabelMensajeErrorBaseDeDatos5, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 35, 200, 25));

        jLabelFondoIconoErrorBaseDeDatos2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelErrorBaseDeDatosPresup.add(jLabelFondoIconoErrorBaseDeDatos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalPresupuesto.add(jPanelErrorBaseDeDatosPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jPanelGuardadoErroneoPresup.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelGuardadoErroneoPresup.setOpaque(false);
        jPanelGuardadoErroneoPresup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarGuardadoErroneo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarGuardadoErroneo1.setToolTipText("Has click para continuar.");
        jButtonAceptarGuardadoErroneo1.setBorder(null);
        jButtonAceptarGuardadoErroneo1.setBorderPainted(false);
        jButtonAceptarGuardadoErroneo1.setContentAreaFilled(false);
        jButtonAceptarGuardadoErroneo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarGuardadoErroneo1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarGuardadoErroneo1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarGuardadoErroneo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarGuardadoErroneo1ActionPerformed(evt);
            }
        });
        jPanelGuardadoErroneoPresup.add(jButtonAceptarGuardadoErroneo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoError1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelGuardadoErroneoPresup.add(jLabelIconoError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeGuardadoErroneo1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeGuardadoErroneo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeGuardadoErroneo1.setText("No se guardo.");
        jPanelGuardadoErroneoPresup.add(jLabelMensajeGuardadoErroneo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeGuardadoErroneo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeGuardadoErroneo3.setText(" Revise los datos ingresados.");
        jPanelGuardadoErroneoPresup.add(jLabelMensajeGuardadoErroneo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 35, -1, 25));

        jLabelFondoIconoGuardadoErroneo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelGuardadoErroneoPresup.add(jLabelFondoIconoGuardadoErroneo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalPresupuesto.add(jPanelGuardadoErroneoPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jPanelGuardadoExitosoPresup.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelGuardadoExitosoPresup.setOpaque(false);
        jPanelGuardadoExitosoPresup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceptarGuardadoExitoso1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarGuardadoExitoso1.setToolTipText("Has click para continuar.");
        jButtonAceptarGuardadoExitoso1.setBorder(null);
        jButtonAceptarGuardadoExitoso1.setBorderPainted(false);
        jButtonAceptarGuardadoExitoso1.setContentAreaFilled(false);
        jButtonAceptarGuardadoExitoso1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarGuardadoExitoso1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarGuardadoExitoso1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarGuardadoExitoso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarGuardadoExitoso1ActionPerformed(evt);
            }
        });
        jPanelGuardadoExitosoPresup.add(jButtonAceptarGuardadoExitoso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 65, -1, -1));

        jLabelIconoExito1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoExito25x25.png"))); // NOI18N
        jPanelGuardadoExitosoPresup.add(jLabelIconoExito1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeGuardadoCorrecto1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeGuardadoCorrecto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeGuardadoCorrecto1.setText("Se guardo exitosamente.");
        jPanelGuardadoExitosoPresup.add(jLabelMensajeGuardadoCorrecto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 160, 25));

        jLabelFondoIconoGuardadoExitoso1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelGuardadoExitosoPresup.add(jLabelFondoIconoGuardadoExitoso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalPresupuesto.add(jPanelGuardadoExitosoPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jPanelMensajeValidarABMPresup.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelMensajeValidarABMPresup.setOpaque(false);
        jPanelMensajeValidarABMPresup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCancelarValidarCambios1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOff.png"))); // NOI18N
        jButtonCancelarValidarCambios1.setToolTipText("Has click para volver.");
        jButtonCancelarValidarCambios1.setBorder(null);
        jButtonCancelarValidarCambios1.setBorderPainted(false);
        jButtonCancelarValidarCambios1.setContentAreaFilled(false);
        jButtonCancelarValidarCambios1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelarValidarCambios1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOn.png"))); // NOI18N
        jButtonCancelarValidarCambios1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25CancelarOn.png"))); // NOI18N
        jButtonCancelarValidarCambios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarValidarCambios1ActionPerformed(evt);
            }
        });
        jPanelMensajeValidarABMPresup.add(jButtonCancelarValidarCambios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        jButtonAceptarValidarCambios1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOff.png"))); // NOI18N
        jButtonAceptarValidarCambios1.setToolTipText("Has click para continuar.");
        jButtonAceptarValidarCambios1.setBorder(null);
        jButtonAceptarValidarCambios1.setBorderPainted(false);
        jButtonAceptarValidarCambios1.setContentAreaFilled(false);
        jButtonAceptarValidarCambios1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptarValidarCambios1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarValidarCambios1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AceptarOn.png"))); // NOI18N
        jButtonAceptarValidarCambios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarValidarCambios1ActionPerformed(evt);
            }
        });
        jPanelMensajeValidarABMPresup.add(jButtonAceptarValidarCambios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabelIconoAlertaValidarCambios1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconoAlerta25x25.png"))); // NOI18N
        jPanelMensajeValidarABMPresup.add(jLabelIconoAlertaValidarCambios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelMensajeValidarCambios2.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeValidarCambios2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeValidarCambios2.setText("Revise los datos antes.");
        jPanelMensajeValidarABMPresup.add(jLabelMensajeValidarCambios2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 25));

        jLabelMensajeValidarCambios3.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMensajeValidarCambios3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensajeValidarCambios3.setText("¿Seguro de realizar esta acción? ");
        jPanelMensajeValidarABMPresup.add(jLabelMensajeValidarCambios3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 35, 190, 25));

        jLabelFondoIconoMensajeValidarCambios1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondo250x100SinLogo.png"))); // NOI18N
        jPanelMensajeValidarABMPresup.add(jLabelFondoIconoMensajeValidarCambios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        jPanelGlobalPresupuesto.add(jPanelMensajeValidarABMPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 278, 250, 100));

        jLabelTituloTotalPresup.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloTotalPresup.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloTotalPresup.setText("Total:");
        jLabelTituloTotalPresup.setToolTipText("");
        jPanelGlobalPresupuesto.add(jLabelTituloTotalPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 397, -1, 25));

        jTextFieldTotalPresup.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldTotalPresup.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldTotalPresup.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTotalPresup.setToolTipText("Ingrese solo numero deciales. Ej.: 233.00");
        jTextFieldTotalPresup.setBorder(null);
        jTextFieldTotalPresup.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldTotalPresup.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldTotalPresup.setOpaque(false);
        jTextFieldTotalPresup.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldTotalPresup.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelGlobalPresupuesto.add(jTextFieldTotalPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 417, 100, 20));

        jSeparatorTotalPresup.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorTotalPresup.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorTotalPresup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorTotalPresup.setOpaque(true);
        jPanelGlobalPresupuesto.add(jSeparatorTotalPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 437, 100, -1));

        jLabelTituloDescrPresup.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloDescrPresup.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloDescrPresup.setText("Descripcion:");
        jLabelTituloDescrPresup.setToolTipText("");
        jPanelGlobalPresupuesto.add(jLabelTituloDescrPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 340, -1, 25));

        jTextFieldDescrPresup.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldDescrPresup.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldDescrPresup.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDescrPresup.setToolTipText("Ingrese solo texto. Ej.: gastos");
        jTextFieldDescrPresup.setBorder(null);
        jTextFieldDescrPresup.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldDescrPresup.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldDescrPresup.setOpaque(false);
        jTextFieldDescrPresup.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldDescrPresup.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelGlobalPresupuesto.add(jTextFieldDescrPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 360, 200, 20));

        jSeparatorDescrPresup.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorDescrPresup.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorDescrPresup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorDescrPresup.setOpaque(true);
        jPanelGlobalPresupuesto.add(jSeparatorDescrPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 380, 200, -1));

        jLabelTituloCodigoCristal.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloCodigoCristal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloCodigoCristal.setText("Cristal elegido:");
        jLabelTituloCodigoCristal.setToolTipText("");
        jPanelGlobalPresupuesto.add(jLabelTituloCodigoCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 256, -1, 25));

        jTextFieldCodigoCristal.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldCodigoCristal.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldCodigoCristal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCodigoCristal.setToolTipText("Ingrese solo numeros. Ej.: 0033");
        jTextFieldCodigoCristal.setBorder(null);
        jTextFieldCodigoCristal.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldCodigoCristal.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldCodigoCristal.setOpaque(false);
        jTextFieldCodigoCristal.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldCodigoCristal.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldCodigoCristal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldCodigoCristalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCodigoCristalFocusLost(evt);
            }
        });
        jTextFieldCodigoCristal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCodigoCristalKeyReleased(evt);
            }
        });
        jPanelGlobalPresupuesto.add(jTextFieldCodigoCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 276, 100, 20));

        jSeparatorCodigoCristal.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorCodigoCristal.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorCodigoCristal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorCodigoCristal.setOpaque(true);
        jPanelGlobalPresupuesto.add(jSeparatorCodigoCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 297, 100, -1));

        jLabelTituloPatente.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloPatente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloPatente.setText("Dominio del vehiculo:");
        jLabelTituloPatente.setToolTipText("");
        jPanelGlobalPresupuesto.add(jLabelTituloPatente, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 176, -1, 25));

        jTextFieldPatenteVeh.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldPatenteVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldPatenteVeh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPatenteVeh.setToolTipText("Ingrese solo texto. Ej.: alejandro");
        jTextFieldPatenteVeh.setBorder(null);
        jTextFieldPatenteVeh.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldPatenteVeh.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldPatenteVeh.setOpaque(false);
        jTextFieldPatenteVeh.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldPatenteVeh.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelGlobalPresupuesto.add(jTextFieldPatenteVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 196, 100, 20));

        jSeparatorPatenteVeh.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorPatenteVeh.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorPatenteVeh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorPatenteVeh.setOpaque(true);
        jPanelGlobalPresupuesto.add(jSeparatorPatenteVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 217, 100, -1));

        jLabelTituloIuMarcaCris.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuMarcaCris.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuMarcaCris.setText("Marca del cristal:");
        jLabelTituloIuMarcaCris.setToolTipText("");
        jPanelGlobalPresupuesto.add(jLabelTituloIuMarcaCris, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 256, -1, 25));

        jTextFieldIuMarcaCris.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuMarcaCris.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuMarcaCris.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuMarcaCris.setToolTipText("Ingrese solo numeros y guion(-). Ej.: 01-02-1999");
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
        jPanelGlobalPresupuesto.add(jTextFieldIuMarcaCris, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 276, 100, 20));

        jSeparatorIuMarcaCris.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuMarcaCris.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuMarcaCris.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuMarcaCris.setOpaque(true);
        jPanelGlobalPresupuesto.add(jSeparatorIuMarcaCris, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 297, 100, -1));

        jButtonRegMarcaCristal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x25Off.png"))); // NOI18N
        jButtonRegMarcaCristal.setBorder(null);
        jButtonRegMarcaCristal.setBorderPainted(false);
        jButtonRegMarcaCristal.setContentAreaFilled(false);
        jButtonRegMarcaCristal.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegMarcaCristal.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegMarcaCristal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegMarcaCristalActionPerformed(evt);
            }
        });
        jPanelGlobalPresupuesto.add(jButtonRegMarcaCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 272, -1, -1));

        jLabelTituloCodModeloVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloCodModeloVeh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloCodModeloVeh.setText("Modelo del vehiculo:");
        jLabelTituloCodModeloVeh.setToolTipText("");
        jPanelGlobalPresupuesto.add(jLabelTituloCodModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 176, -1, 25));

        jTextFieldCodModeloVeh.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldCodModeloVeh.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldCodModeloVeh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCodModeloVeh.setToolTipText("Seleccione un item de la lista.");
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
        jPanelGlobalPresupuesto.add(jTextFieldCodModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 196, 200, 20));

        jSeparatorCodModeloVeh.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorCodModeloVeh.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorCodModeloVeh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorCodModeloVeh.setOpaque(true);
        jPanelGlobalPresupuesto.add(jSeparatorCodModeloVeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 216, 200, -1));

        jLabelTituloDirigidoA.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloDirigidoA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloDirigidoA.setText("Dirigido a:");
        jLabelTituloDirigidoA.setToolTipText("");
        jPanelGlobalPresupuesto.add(jLabelTituloDirigidoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 98, -1, 25));

        jTextFieldDirigidoA.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldDirigidoA.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldDirigidoA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDirigidoA.setToolTipText("Ingrese solo numeros y guion(-). Ej.: 01-02-1999");
        jTextFieldDirigidoA.setBorder(null);
        jTextFieldDirigidoA.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldDirigidoA.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldDirigidoA.setOpaque(false);
        jTextFieldDirigidoA.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldDirigidoA.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelGlobalPresupuesto.add(jTextFieldDirigidoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 118, 200, 20));

        jSeparatorDirigidoA.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorDirigidoA.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorDirigidoA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorDirigidoA.setOpaque(true);
        jPanelGlobalPresupuesto.add(jSeparatorDirigidoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 138, 200, -1));

        jLabelTituloIuTipoCaja1.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuTipoCaja1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuTipoCaja1.setText("Tipo de presupuesto:");
        jLabelTituloIuTipoCaja1.setToolTipText("");
        jPanelGlobalPresupuesto.add(jLabelTituloIuTipoCaja1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 98, -1, 25));

        jTextFieldIuTipoPresupuesto.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuTipoPresupuesto.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuTipoPresupuesto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuTipoPresupuesto.setToolTipText("Seleccione un item de la lista.");
        jTextFieldIuTipoPresupuesto.setBorder(null);
        jTextFieldIuTipoPresupuesto.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuTipoPresupuesto.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuTipoPresupuesto.setOpaque(false);
        jTextFieldIuTipoPresupuesto.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuTipoPresupuesto.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelGlobalPresupuesto.add(jTextFieldIuTipoPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 118, 200, 20));

        jSeparatorIuTipoPresupuesto.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuTipoPresupuesto.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuTipoPresupuesto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuTipoPresupuesto.setOpaque(true);
        jPanelGlobalPresupuesto.add(jSeparatorIuTipoPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 138, 200, -1));

        jSeparatorIuPresupuesto.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuPresupuesto.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuPresupuesto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuPresupuesto.setOpaque(true);
        jPanelGlobalPresupuesto.add(jSeparatorIuPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 66, 100, -1));

        jLabelTituloIuPresupuesto.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuPresupuesto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuPresupuesto.setText("Codigo identificacion:");
        jLabelTituloIuPresupuesto.setToolTipText("");
        jPanelGlobalPresupuesto.add(jLabelTituloIuPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 25, -1, 25));

        jTextFieldIuPresupuesto.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuPresupuesto.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuPresupuesto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuPresupuesto.setText("AUTOMATICO");
        jTextFieldIuPresupuesto.setToolTipText("");
        jTextFieldIuPresupuesto.setBorder(null);
        jTextFieldIuPresupuesto.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuPresupuesto.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuPresupuesto.setOpaque(false);
        jTextFieldIuPresupuesto.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuPresupuesto.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelGlobalPresupuesto.add(jTextFieldIuPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 45, 100, 20));

        jButtonAgregarPresupuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOff.png"))); // NOI18N
        jButtonAgregarPresupuesto.setToolTipText("Has click para agregar.");
        jButtonAgregarPresupuesto.setBorder(null);
        jButtonAgregarPresupuesto.setBorderPainted(false);
        jButtonAgregarPresupuesto.setContentAreaFilled(false);
        jButtonAgregarPresupuesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregarPresupuesto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarPresupuesto.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25AgregarOn.png"))); // NOI18N
        jButtonAgregarPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarPresupuestoActionPerformed(evt);
            }
        });
        jPanelGlobalPresupuesto.add(jButtonAgregarPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 475, -1, -1));

        jButtonEditarPresupuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOff.png"))); // NOI18N
        jButtonEditarPresupuesto.setToolTipText("Has click para editar.");
        jButtonEditarPresupuesto.setBorder(null);
        jButtonEditarPresupuesto.setBorderPainted(false);
        jButtonEditarPresupuesto.setContentAreaFilled(false);
        jButtonEditarPresupuesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditarPresupuesto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarPresupuesto.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25EditarOn.png"))); // NOI18N
        jButtonEditarPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarPresupuestoActionPerformed(evt);
            }
        });
        jPanelGlobalPresupuesto.add(jButtonEditarPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 475, -1, -1));

        jButtonBorrarPresupuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOff.png"))); // NOI18N
        jButtonBorrarPresupuesto.setToolTipText("Has click para borrar.");
        jButtonBorrarPresupuesto.setBorder(null);
        jButtonBorrarPresupuesto.setBorderPainted(false);
        jButtonBorrarPresupuesto.setContentAreaFilled(false);
        jButtonBorrarPresupuesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBorrarPresupuesto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarPresupuesto.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton100x25BorrarOn.png"))); // NOI18N
        jButtonBorrarPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarPresupuestoActionPerformed(evt);
            }
        });
        jPanelGlobalPresupuesto.add(jButtonBorrarPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 475, -1, -1));

        jButtonTraerPanelBuscarPresup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOff.png"))); // NOI18N
        jButtonTraerPanelBuscarPresup.setToolTipText("Menu buscar");
        jButtonTraerPanelBuscarPresup.setBorder(null);
        jButtonTraerPanelBuscarPresup.setBorderPainted(false);
        jButtonTraerPanelBuscarPresup.setContentAreaFilled(false);
        jButtonTraerPanelBuscarPresup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTraerPanelBuscarPresup.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOn.png"))); // NOI18N
        jButtonTraerPanelBuscarPresup.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/boton25x25MenuOn.png"))); // NOI18N
        jButtonTraerPanelBuscarPresup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTraerPanelBuscarPresupActionPerformed(evt);
            }
        });
        jPanelGlobalPresupuesto.add(jButtonTraerPanelBuscarPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 10, -1, -1));

        jLabelTituloFechaPresup.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloFechaPresup.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloFechaPresup.setText("Fecha de Presupuesto:");
        jLabelTituloFechaPresup.setToolTipText("");
        jPanelGlobalPresupuesto.add(jLabelTituloFechaPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 30, -1, 25));

        jTextFieldFechaPresup.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldFechaPresup.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldFechaPresup.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldFechaPresup.setToolTipText("Ingrese solo numeros y guion(-). Ej.: 01-02-1999");
        jTextFieldFechaPresup.setBorder(null);
        jTextFieldFechaPresup.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaPresup.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaPresup.setOpaque(false);
        jTextFieldFechaPresup.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldFechaPresup.setSelectionColor(new java.awt.Color(194, 4, 48));
        jPanelGlobalPresupuesto.add(jTextFieldFechaPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 100, 20));

        jSeparatorFechaFactura2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorFechaFactura2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorFechaFactura2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorFechaFactura2.setOpaque(true);
        jPanelGlobalPresupuesto.add(jSeparatorFechaFactura2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 100, -1));

        jButtonRegModeloVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x25Off.png"))); // NOI18N
        jButtonRegModeloVehiculo.setBorder(null);
        jButtonRegModeloVehiculo.setBorderPainted(false);
        jButtonRegModeloVehiculo.setContentAreaFilled(false);
        jButtonRegModeloVehiculo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegModeloVehiculo.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegModeloVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegModeloVehiculoActionPerformed(evt);
            }
        });
        jPanelGlobalPresupuesto.add(jButtonRegModeloVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 191, -1, -1));

        jButtonRegCatalogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x25Off.png"))); // NOI18N
        jButtonRegCatalogo.setBorder(null);
        jButtonRegCatalogo.setBorderPainted(false);
        jButtonRegCatalogo.setContentAreaFilled(false);
        jButtonRegCatalogo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegCatalogo.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegCatalogoActionPerformed(evt);
            }
        });
        jPanelGlobalPresupuesto.add(jButtonRegCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 272, -1, -1));

        jLabelTituloIuServicios.setFont(new java.awt.Font("Open Sans Extrabold", 0, 8)); // NOI18N
        jLabelTituloIuServicios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTituloIuServicios.setText("Servicio a prestar:");
        jLabelTituloIuServicios.setToolTipText("");
        jPanelGlobalPresupuesto.add(jLabelTituloIuServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 256, -1, 25));

        jTextFieldIuServicios.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldIuServicios.setFont(new java.awt.Font("Open Sans Extrabold", 0, 14)); // NOI18N
        jTextFieldIuServicios.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIuServicios.setToolTipText("Ingrese solo numeros y guion(-). Ej.: 01-02-1999");
        jTextFieldIuServicios.setBorder(null);
        jTextFieldIuServicios.setMaximumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuServicios.setMinimumSize(new java.awt.Dimension(25, 100));
        jTextFieldIuServicios.setOpaque(false);
        jTextFieldIuServicios.setPreferredSize(new java.awt.Dimension(25, 100));
        jTextFieldIuServicios.setSelectionColor(new java.awt.Color(194, 4, 48));
        jTextFieldIuServicios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIuServiciosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldIuServiciosFocusLost(evt);
            }
        });
        jTextFieldIuServicios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldIuServiciosKeyReleased(evt);
            }
        });
        jPanelGlobalPresupuesto.add(jTextFieldIuServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 276, 100, 20));

        jSeparatorIuServicios.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIuServicios.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIuServicios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparatorIuServicios.setOpaque(true);
        jPanelGlobalPresupuesto.add(jSeparatorIuServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 297, 100, -1));

        jButtonRegServiciosPrestados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x25Off.png"))); // NOI18N
        jButtonRegServiciosPrestados.setBorder(null);
        jButtonRegServiciosPrestados.setBorderPainted(false);
        jButtonRegServiciosPrestados.setContentAreaFilled(false);
        jButtonRegServiciosPrestados.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegServiciosPrestados.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/botonMasRelaciones25x2On.png"))); // NOI18N
        jButtonRegServiciosPrestados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegServiciosPrestadosActionPerformed(evt);
            }
        });
        jPanelGlobalPresupuesto.add(jButtonRegServiciosPrestados, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 272, -1, -1));

        jLabelFondoPresup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondoContenedorGlobal700x525Blanco.png"))); // NOI18N
        jPanelGlobalPresupuesto.add(jLabelFondoPresup, new org.netbeans.lib.awtextra.AbsoluteConstraints(-700, 0, -1, -1));

        getContentPane().add(jPanelGlobalPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(-700, 0, 700, 525));

        jPanelBuscarCatalogo.setBackground(new java.awt.Color(245, 245, 245));
        jPanelBuscarCatalogo.setMaximumSize(new java.awt.Dimension(700, 75));
        jPanelBuscarCatalogo.setMinimumSize(new java.awt.Dimension(700, 75));
        jPanelBuscarCatalogo.setPreferredSize(new java.awt.Dimension(700, 75));
        jPanelBuscarCatalogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTituloBuscarCatalogo.setFont(new java.awt.Font("Open Sans Extrabold", 0, 11)); // NOI18N
        jLabelTituloBuscarCatalogo.setText("Parametro de busqueda:");
        jPanelBuscarCatalogo.add(jLabelTituloBuscarCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jTextFieldBuscarCatalogo.setBackground(new java.awt.Color(245, 245, 245));
        jTextFieldBuscarCatalogo.setFont(new java.awt.Font("Open Sans Extrabold", 0, 11)); // NOI18N
        jTextFieldBuscarCatalogo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBuscarCatalogo.setBorder(null);
        jTextFieldBuscarCatalogo.setDisabledTextColor(new java.awt.Color(73, 73, 73));
        jTextFieldBuscarCatalogo.setSelectedTextColor(new java.awt.Color(245, 245, 245));
        jTextFieldBuscarCatalogo.setSelectionColor(new java.awt.Color(73, 73, 73));
        jTextFieldBuscarCatalogo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarCatalogoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarCatalogoKeyTyped(evt);
            }
        });
        jPanelBuscarCatalogo.add(jTextFieldBuscarCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 35, 200, 25));

        jSeparatorBuscarCatalogo.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorBuscarCatalogo.setForeground(new java.awt.Color(0, 0, 0));
        jPanelBuscarCatalogo.add(jSeparatorBuscarCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 61, 200, 2));

        jLabelFondoCatalogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondoContenedorGlobal700x525Blanco.png"))); // NOI18N
        jLabelFondoCatalogo1.setMaximumSize(new java.awt.Dimension(700, 75));
        jLabelFondoCatalogo1.setMinimumSize(new java.awt.Dimension(700, 75));
        jLabelFondoCatalogo1.setPreferredSize(new java.awt.Dimension(700, 75));
        jPanelBuscarCatalogo.add(jLabelFondoCatalogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 75));

        getContentPane().add(jPanelBuscarCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, 700, 75));

        jScrollPaneListaCatalogo.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPaneListaCatalogo.setOpaque(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. cristal", "Descripcion", "Marca", "Modelo", "Marca", "Cant. fija", "Cant. stock", "Precio"
            }
        ));
        jTable1.setToolTipText("");
        jTable1.setSelectionBackground(new java.awt.Color(73, 73, 73));
        jTable1.setSelectionForeground(new java.awt.Color(245, 245, 245));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPaneListaCatalogo.setViewportView(jTable1);

        getContentPane().add(jScrollPaneListaCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 700, 450));

        jPanelErrorBaseDeDatos.setMaximumSize(new java.awt.Dimension(250, 100));
        jPanelErrorBaseDeDatos.setOpaque(false);
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

        jLabelBarraHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/barraTitulo1000x30Radial.png"))); // NOI18N
        getContentPane().add(jLabelBarraHerramientas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButtonGlobalCatalogo.setFont(new java.awt.Font("Open Sans Extrabold", 0, 12)); // NOI18N
        jButtonGlobalCatalogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/solapaContenedorGlobal100x25Off.png"))); // NOI18N
        jButtonGlobalCatalogo.setText("Catalogo");
        jButtonGlobalCatalogo.setBorder(null);
        jButtonGlobalCatalogo.setBorderPainted(false);
        jButtonGlobalCatalogo.setContentAreaFilled(false);
        jButtonGlobalCatalogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGlobalCatalogo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/solapaContenedorGlobal100x25On.png"))); // NOI18N
        jButtonGlobalCatalogo.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/solapaContenedorGlobal100x25On.png"))); // NOI18N
        jButtonGlobalCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGlobalCatalogoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGlobalCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 25));

        jButtonGlobalPresupuesto.setFont(new java.awt.Font("Open Sans Extrabold", 0, 12)); // NOI18N
        jButtonGlobalPresupuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/solapaContenedorGlobal100x25Off.png"))); // NOI18N
        jButtonGlobalPresupuesto.setText("Presupuesto");
        jButtonGlobalPresupuesto.setBorder(null);
        jButtonGlobalPresupuesto.setBorderPainted(false);
        jButtonGlobalPresupuesto.setContentAreaFilled(false);
        jButtonGlobalPresupuesto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGlobalPresupuesto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/solapaContenedorGlobal100x25On.png"))); // NOI18N
        jButtonGlobalPresupuesto.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/solapaContenedorGlobal100x25On.png"))); // NOI18N
        jButtonGlobalPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGlobalPresupuestoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGlobalPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 100, 25));

        jButtonGlobalExamenes.setFont(new java.awt.Font("Open Sans Extrabold", 0, 12)); // NOI18N
        jButtonGlobalExamenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/solapaContenedorGlobal100x25Off.png"))); // NOI18N
        jButtonGlobalExamenes.setText("Examenes");
        jButtonGlobalExamenes.setBorder(null);
        jButtonGlobalExamenes.setBorderPainted(false);
        jButtonGlobalExamenes.setContentAreaFilled(false);
        jButtonGlobalExamenes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGlobalExamenes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/solapaContenedorGlobal100x25On.png"))); // NOI18N
        jButtonGlobalExamenes.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/solapaContenedorGlobal100x25On.png"))); // NOI18N
        jButtonGlobalExamenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGlobalExamenesActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGlobalExamenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 100, 25));

        jButtonCajaPricipal.setFont(new java.awt.Font("Open Sans Extrabold", 0, 12)); // NOI18N
        jButtonCajaPricipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/solapaContenedorGlobal100x25Off.png"))); // NOI18N
        jButtonCajaPricipal.setText("Caja");
        jButtonCajaPricipal.setBorder(null);
        jButtonCajaPricipal.setBorderPainted(false);
        jButtonCajaPricipal.setContentAreaFilled(false);
        jButtonCajaPricipal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCajaPricipal.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/solapaContenedorGlobal100x25On.png"))); // NOI18N
        jButtonCajaPricipal.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/botones/solapaContenedorGlobal100x25On.png"))); // NOI18N
        jButtonCajaPricipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCajaPricipalActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCajaPricipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 100, 25));

        jLabelFondoIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondos/fondoLogo1000x600.png"))); // NOI18N
        getContentPane().add(jLabelFondoIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarJFramePreincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarJFramePreincipalActionPerformed
        
        jTextFieldIuTipoCaja.setBorder(null);    
        jTextFieldANombreDe.setBorder(null);
        jTextFieldDescrCaja.setBorder(null);
        jTextFieldFechaCaja.setBorder(null);
        jTextFieldFechaFactura.setBorder(null);
        jTextFieldIuCaja.setBorder(null);
        jTextFieldIuTipoFactura.setBorder(null);
        jTextFieldNumFactura.setBorder(null);
        jTextFieldTotalCaja.setBorder(null);
        
        jTextFieldFechaPresup.setBorder(null);
        jTextFieldIuTipoPresupuesto.setBorder(null);
        jTextFieldDirigidoA.setBorder(null);
        jTextFieldCodModeloVeh.setBorder(null);
        jTextFieldPatenteVeh.setBorder(null);
        jTextFieldCodigoCristal.setBorder(null);
        jTextFieldIuMarcaCris.setBorder(null);
        jTextFieldIuServicios.setBorder(null);
        jTextFieldDescrPresup.setBorder(null);
        jTextFieldTotalPresup.setBorder(null);
                    
        jTextFieldIuPresupuesto.setBorder(null);
        jTextFieldIuCartera.setBorder(null);
        jTextFieldPosibleRetirador.setBorder(null);
        jTextFieldNombExaminador.setBorder(null);
        jTextFieldDominioVeh.setBorder(null);
        
        jPanelGlobalCaja.setBounds(-1000, 65, 700, 525);
        jPanelGlobalCaja.repaint();
        jPanelVentanaBuscarCaja.setBounds(-1000, 65, 700, 525);
        jPanelVentanaBuscarCaja.repaint();
        jPanelVentanaBuscarExamen.setBounds(-1000, 65, 700, 525);
        jPanelVentanaBuscarExamen.repaint();
        jPanelVentanaBuscarPresup.setBounds(-1000, 65, 700, 525);
        jPanelVentanaBuscarPresup.repaint();
        jPanelGlobalPresupuesto.setBounds(-1000, 65, 700, 525);
        jPanelGlobalPresupuesto.repaint();
        jPanelGlobalExamenes.setBounds(-1000, 65, 700, 525);
        jPanelGlobalExamenes.repaint();
        jPanelBuscarCatalogo.setBounds(0, 65, 700, 75);
        jScrollPaneListaCatalogo.setBounds(0, 140, 700, 450);
        jPanelBuscarCatalogo.repaint();
        jScrollPaneListaCatalogo.repaint();
        this.repaint();
        
        
        jPanelMensajeCerrar.setBounds(375, 250, 250, 100);
    }//GEN-LAST:event_jButtonCerrarJFramePreincipalActionPerformed

    private void jButtonMenuCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuCajaActionPerformed
        jPanelMenuDesplegableCaja.setBounds(-260, 28, 250, 150);
    }//GEN-LAST:event_jButtonMenuCajaActionPerformed

    private void jButtonMenuCajaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuCajaMouseEntered
        
        jPanelMenuDesplegableCaja.setBounds(20, 28, 250, 150);
        jPanelMenuDesplegableMovimientos.setBounds(-260, 28, 250, 75); 
        jPanelMenuDesplegableInformes.setBounds(-260, 28, 250, 50);
        jPanelMenuDesplegableCartera.setBounds(-260, 28, 250, 75);
        jPanelMenuDesplegableCatalogo.setBounds(-260, 28, 250, 75);
        jPanelMenuDesplegableVehiculo.setBounds(-260, 28, 250, 75);
    }//GEN-LAST:event_jButtonMenuCajaMouseEntered

    private void jButtonMenuCajaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuCajaMouseExited

        jPanelMenuDesplegableMovimientos.setBounds(-260, 28, 250, 75); 
        jPanelMenuDesplegableInformes.setBounds(-260, 28, 250, 50);
        jPanelMenuDesplegableCartera.setBounds(-260, 28, 250, 75);
        jPanelMenuDesplegableCatalogo.setBounds(-260, 28, 250, 75);
        jPanelMenuDesplegableVehiculo.setBounds(-260, 28, 250, 75);
    }//GEN-LAST:event_jButtonMenuCajaMouseExited

    private void jButtonMenuCajaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuCajaMouseDragged
       
        jPanelMenuDesplegableCaja.setBounds(20, 28, 250, 150);
    }//GEN-LAST:event_jButtonMenuCajaMouseDragged

    private void jButtonMenuCarteraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuCarteraMouseEntered
       
        jPanelMenuDesplegableCartera.setBounds(162, 28, 250, 75);
        jPanelMenuDesplegableMovimientos.setBounds(-260, 28, 250, 75); 
        jPanelMenuDesplegableCaja.setBounds(-260, 28, 250, 150);
        jPanelMenuDesplegableInformes.setBounds(-260, 28, 250, 50);
        jPanelMenuDesplegableCatalogo.setBounds(-260, 28, 250, 75);
        jPanelMenuDesplegableVehiculo.setBounds(-260, 28, 250, 75);
    }//GEN-LAST:event_jButtonMenuCarteraMouseEntered

    private void jButtonMenuCarteraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuCarteraMouseExited

        jPanelMenuDesplegableMovimientos.setBounds(-260, 28, 250, 75); 
        jPanelMenuDesplegableCaja.setBounds(-260, 28, 250, 150);
        jPanelMenuDesplegableInformes.setBounds(-260, 28, 250, 50);
        jPanelMenuDesplegableCatalogo.setBounds(-260, 28, 250, 75);
        jPanelMenuDesplegableVehiculo.setBounds(-260, 28, 250, 75);
    }//GEN-LAST:event_jButtonMenuCarteraMouseExited

    private void jButtonMenuCarteraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuCarteraMouseDragged
       
        jPanelMenuDesplegableCartera.setBounds(162, 28, 250, 75);
    }//GEN-LAST:event_jButtonMenuCarteraMouseDragged

    private void jButtonMenuCatalogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuCatalogoMouseEntered
       
        jPanelMenuDesplegableCatalogo.setBounds(304, 28, 250, 75);
        jPanelMenuDesplegableMovimientos.setBounds(-260, 28, 250,75); 
        jPanelMenuDesplegableCaja.setBounds(-260, 28, 250, 150);
        jPanelMenuDesplegableCartera.setBounds(-260, 28, 250, 75);
        jPanelMenuDesplegableInformes.setBounds(-260, 28, 250, 50);
        jPanelMenuDesplegableVehiculo.setBounds(-260, 28, 250, 75);
    }//GEN-LAST:event_jButtonMenuCatalogoMouseEntered

    private void jButtonMenuCatalogoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuCatalogoMouseExited
        
        jPanelMenuDesplegableMovimientos.setBounds(-260, 28, 250, 75); 
        jPanelMenuDesplegableCaja.setBounds(-260, 28, 250, 150);
        jPanelMenuDesplegableCartera.setBounds(-260, 28, 250, 75);
        jPanelMenuDesplegableInformes.setBounds(-260, 28, 250, 50);
        jPanelMenuDesplegableVehiculo.setBounds(-260, 28, 250, 75);  
    }//GEN-LAST:event_jButtonMenuCatalogoMouseExited

    private void jButtonMenuCatalogoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuCatalogoMouseDragged
        
        jPanelMenuDesplegableCatalogo.setBounds(304, 28, 250, 75);
    }//GEN-LAST:event_jButtonMenuCatalogoMouseDragged

    private void jButtonMenuVehiculoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuVehiculoMouseEntered
        
        jPanelMenuDesplegableVehiculo.setBounds(446, 28, 250, 75);
        jPanelMenuDesplegableMovimientos.setBounds(-260, 28, 250, 75); 
        jPanelMenuDesplegableCaja.setBounds(-260, 28, 250, 150);
        jPanelMenuDesplegableCartera.setBounds(-260, 28, 250, 75);
        jPanelMenuDesplegableInformes.setBounds(-260, 28, 250, 50);
        jPanelMenuDesplegableCatalogo.setBounds(-260, 28, 250, 75);
    }//GEN-LAST:event_jButtonMenuVehiculoMouseEntered

    private void jButtonMenuVehiculoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuVehiculoMouseExited
        
        jPanelMenuDesplegableMovimientos.setBounds(-260, 28, 250, 75); 
        jPanelMenuDesplegableCaja.setBounds(-260, 28, 250, 150);
        jPanelMenuDesplegableCartera.setBounds(-260, 28, 250, 75);
        jPanelMenuDesplegableInformes.setBounds(-260, 28, 250, 50);
        jPanelMenuDesplegableCatalogo.setBounds(-260, 28, 250, 75); 
    }//GEN-LAST:event_jButtonMenuVehiculoMouseExited

    private void jButtonMenuVehiculoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuVehiculoMouseDragged
        
        jPanelMenuDesplegableVehiculo.setBounds(446, 28, 250, 75);
    }//GEN-LAST:event_jButtonMenuVehiculoMouseDragged

    private void jButtonMenuMovimientosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuMovimientosMouseEntered
        
        jPanelMenuDesplegableMovimientos.setBounds(588, 28, 250, 75);  
        jPanelMenuDesplegableInformes.setBounds(-260, 28, 250, 50); 
        jPanelMenuDesplegableCaja.setBounds(-260, 28, 250, 150);
        jPanelMenuDesplegableCartera.setBounds(-260, 28, 250, 75);
        jPanelMenuDesplegableCatalogo.setBounds(-260, 28, 250, 75);
        jPanelMenuDesplegableVehiculo.setBounds(-260, 28, 250, 75);
    }//GEN-LAST:event_jButtonMenuMovimientosMouseEntered

    private void jButtonMenuMovimientosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuMovimientosMouseExited
        
        jPanelMenuDesplegableInformes.setBounds(-260, 28, 250, 50); 
        jPanelMenuDesplegableCaja.setBounds(-260, 28, 250, 150);
        jPanelMenuDesplegableCartera.setBounds(-260, 28, 250, 75);
        jPanelMenuDesplegableCatalogo.setBounds(-260, 28, 250, 75);
        jPanelMenuDesplegableVehiculo.setBounds(-260, 28, 250, 75); 
    }//GEN-LAST:event_jButtonMenuMovimientosMouseExited

    private void jButtonMenuMovimientosMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuMovimientosMouseDragged
        
        jPanelMenuDesplegableMovimientos.setBounds(588, 28, 250, 75);
    }//GEN-LAST:event_jButtonMenuMovimientosMouseDragged

    private void jButtonRegistroMarcaVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroMarcaVehActionPerformed
        
        JFrameRegistroMarcasVehiculos obj = new JFrameRegistroMarcasVehiculos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroMarcaVehActionPerformed

    private void jButtonRegistroMarcaCrisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroMarcaCrisActionPerformed
        
        JFrameRegistroMarcasCristales obj = new JFrameRegistroMarcasCristales();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroMarcaCrisActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        
        jPanelMensajeCerrar.setBounds(-500, 100, 250, 100);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed

        System.exit(0);
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonMinimizarJFramePrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinimizarJFramePrincipalActionPerformed
       this.setExtendedState(1);
    }//GEN-LAST:event_jButtonMinimizarJFramePrincipalActionPerformed

    private void jButtonRegistroTipoCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroTipoCajaActionPerformed
        
        JFrameRegistroTipoCaja obj = new JFrameRegistroTipoCaja();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroTipoCajaActionPerformed

    private void jButtonRegistroTipoFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroTipoFacturasActionPerformed
        
        JFrameRegistroTipoFactura obj = new JFrameRegistroTipoFactura();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroTipoFacturasActionPerformed

    private void jButtonRegistroTipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroTipoPagoActionPerformed
        
        JFrameRegistroTipoPagos obj = new JFrameRegistroTipoPagos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroTipoPagoActionPerformed

    private void jButtonRegistroSegurosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroSegurosActionPerformed
        
        JFrameRegistroSeguros obj= new JFrameRegistroSeguros();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroSegurosActionPerformed

    private void jButtonRegistroEmisoresDeTarjetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroEmisoresDeTarjetasActionPerformed
        
        JFrameRegistroEmisoresDeTarjetas obj = new JFrameRegistroEmisoresDeTarjetas();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroEmisoresDeTarjetasActionPerformed

    private void jButtonRegistroTipoCarteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroTipoCarteraActionPerformed
        
        JFrameRegistroTipoCarteras obj = new JFrameRegistroTipoCarteras();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroTipoCarteraActionPerformed

    private void jButtonRegistroPolizaSiniestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroPolizaSiniestroActionPerformed
        
        JFrameRegistroPolizaSiniestro obj = new JFrameRegistroPolizaSiniestro();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroPolizaSiniestroActionPerformed

    private void jButtonRegistroModeloVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroModeloVehActionPerformed
        
        JFrameRegistroModelosVehiculos obj = new JFrameRegistroModelosVehiculos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroModeloVehActionPerformed

    private void jButtonRegistroCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroCatalogoActionPerformed
        
        JFrameRegistroCatalogoCristales obj = new JFrameRegistroCatalogoCristales();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroCatalogoActionPerformed

    private void jButtonRegistroPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroPedidosActionPerformed
        
        JFrameRegistroPedidos obj = new JFrameRegistroPedidos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroPedidosActionPerformed

    private void jButtonRegistroVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroVehiculosActionPerformed
        
        JFrameRegistroVehiculos obj = new JFrameRegistroVehiculos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroVehiculosActionPerformed

    private void jButtonRegistroTarjetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroTarjetasActionPerformed
        
        JFrameRegistroTarjetas obj = new JFrameRegistroTarjetas();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroTarjetasActionPerformed

    private void jButtonGlobalCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGlobalCatalogoActionPerformed

        jTextFieldIuTipoCaja.setBorder(null);    
        jTextFieldANombreDe.setBorder(null);
        jTextFieldDescrCaja.setBorder(null);
        jTextFieldFechaCaja.setBorder(null);
        jTextFieldFechaFactura.setBorder(null);
        jTextFieldIuCaja.setBorder(null);
        jTextFieldIuTipoFactura.setBorder(null);
        jTextFieldNumFactura.setBorder(null);
        jTextFieldTotalCaja.setBorder(null);
        
        jTextFieldFechaPresup.setBorder(null);
        jTextFieldIuTipoPresupuesto.setBorder(null);
        jTextFieldDirigidoA.setBorder(null);
        jTextFieldCodModeloVeh.setBorder(null);
        jTextFieldPatenteVeh.setBorder(null);
        jTextFieldCodigoCristal.setBorder(null);
        jTextFieldIuMarcaCris.setBorder(null);
        jTextFieldIuServicios.setBorder(null);
        jTextFieldDescrPresup.setBorder(null);
        jTextFieldTotalPresup.setBorder(null);
                    
        jTextFieldIuPresupuesto.setBorder(null);
        jTextFieldIuCartera.setBorder(null);
        jTextFieldPosibleRetirador.setBorder(null);
        jTextFieldNombExaminador.setBorder(null);
        jTextFieldDominioVeh.setBorder(null);
        
        jPanelGlobalCaja.setBounds(-1000, 65, 700, 525);
        jPanelGlobalCaja.repaint();
        jPanelVentanaBuscarCaja.setBounds(-1000, 65, 700, 525);
        jPanelVentanaBuscarCaja.repaint();
        jPanelVentanaBuscarExamen.setBounds(-1000, 65, 700, 525);
        jPanelVentanaBuscarExamen.repaint();
        jPanelVentanaBuscarPresup.setBounds(-1000, 65, 700, 525);
        jPanelVentanaBuscarPresup.repaint();
        jPanelGlobalPresupuesto.setBounds(-1000, 65, 700, 525);
        jPanelGlobalPresupuesto.repaint();
        jPanelGlobalExamenes.setBounds(-1000, 65, 700, 525);
        jPanelGlobalExamenes.repaint();
        jPanelBuscarCatalogo.setBounds(0, 65, 700, 75);
        jScrollPaneListaCatalogo.setBounds(0, 140, 700, 450);
        jPanelBuscarCatalogo.repaint();
        jScrollPaneListaCatalogo.repaint();
        this.repaint();
    }//GEN-LAST:event_jButtonGlobalCatalogoActionPerformed

    private void jButtonRegistroCarteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroCarteraActionPerformed
        
        JFrameRegistroCartera obj = new JFrameRegistroCartera();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroCarteraActionPerformed

    private void jButtonRegistroContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroContactoActionPerformed
        
        JFrameRegistroContactoCartera obj = new JFrameRegistroContactoCartera();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroContactoActionPerformed

    private void jTextFieldBuscarCatalogoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarCatalogoKeyReleased
        
        boolean auxValidar = Administrador.validarCharDinamico(evt.getKeyChar(), "[a-zA-Z_0-9]||[\\s]");
    try {
        
        if(auxValidar==false){
               
            evt.consume();
            
            jTable1.setModel(_administradorCatalogoCristales.cargarJTabla());    
        } else{
//            System.err.println("qqqq");
//                jTable1.removeAll();
            jTable1.setModel(_administradorCatalogoCristales.buscarEnTabla(jTextFieldBuscarCatalogo.getText()));
           }
    } catch (Exception e) {
        
        jPanelErrorBaseDeDatos.setBounds(325, 200, 250, 100);  
    } 
    }//GEN-LAST:event_jTextFieldBuscarCatalogoKeyReleased

    private void jButtonRegTipoFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegTipoFacturaActionPerformed
        
        JFrameRegistroTipoFactura obj = new JFrameRegistroTipoFactura();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegTipoFacturaActionPerformed

    private void jTextFieldIuTipoFacturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuTipoFacturaFocusGained

        jListTipoFactura.setModel(_administradorTipoFactura.cargarLista(jTextFieldIuTipoFactura.getText()));
        jPanelListaIuTipoFactura.setBounds(308,218, 100, 50);
    }//GEN-LAST:event_jTextFieldIuTipoFacturaFocusGained

    private void jTextFieldIuTipoFacturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuTipoFacturaFocusLost

        jPanelListaIuTipoFactura.setBounds(-308,218, 100, 50);
    }//GEN-LAST:event_jTextFieldIuTipoFacturaFocusLost

    private void jTextFieldIuTipoFacturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIuTipoFacturaKeyReleased

        jListTipoFactura.setModel(_administradorTipoFactura.cargarLista(jTextFieldIuTipoFactura.getText()));
        jPanelListaIuTipoFactura.setBounds(308,218, 100, 50);
    }//GEN-LAST:event_jTextFieldIuTipoFacturaKeyReleased

    private void jButtonRegTipoCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegTipoCajaActionPerformed
        
        JFrameRegistroTipoCaja obj = new JFrameRegistroTipoCaja();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegTipoCajaActionPerformed

    private void jTextFieldIuTipoCajaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuTipoCajaFocusGained

        jListTipoCaja.setModel(_administradorTipoCaja.cargarLista(jTextFieldIuTipoCaja.getText()));
        jPanelListaIuTipoCaja.setBounds(157,140, 200, 50);
    }//GEN-LAST:event_jTextFieldIuTipoCajaFocusGained

    private void jTextFieldIuTipoCajaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuTipoCajaFocusLost

        jPanelListaIuTipoCaja.setBounds(-300,140, 200, 50);
    }//GEN-LAST:event_jTextFieldIuTipoCajaFocusLost

    private void jTextFieldIuTipoCajaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIuTipoCajaKeyReleased

        jListTipoCaja.setModel(_administradorTipoCaja.cargarLista(jTextFieldIuTipoCaja.getText()));
        jPanelListaIuTipoCaja.setBounds(157,140, 200, 50);
    }//GEN-LAST:event_jTextFieldIuTipoCajaKeyReleased

    private void jButtonAgregarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarCajaActionPerformed
                
        jPanelGuardadoExitosoCaja.setBounds(225, 213, 250, 100);
        auxAbm = 1;
        jButtonAgregarCaja.setEnabled(false);
        jButtonEditarCaja.setEnabled(false);
        jButtonBorrarCaja.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldIuCaja.setEditable(false);
        jTextFieldIuTipoCaja.setEditable(false);
        jTextFieldANombreDe.setEditable(false);
        jTextFieldDescrCaja.setEditable(false);
        jTextFieldFechaCaja.setEditable(false);
        jTextFieldFechaFactura.setEditable(false);
        jTextFieldNumFactura.setEditable(false);
        jTextFieldTotalCaja.setEditable(false);
        jButtonRegTipoCaja.setEnabled(false);
        jButtonRegTipoFactura.setEnabled(false);
        jButtonRegDetalleCaja.setEnabled(false);
        JFrameRegistroDetallesDeCaja obj = new JFrameRegistroDetallesDeCaja();
        obj.dispose();
        jListTipoCaja.setVisible(false);
        jListTipoFactura.setVisible(false);
    }//GEN-LAST:event_jButtonAgregarCajaActionPerformed

    private void jButtonEditarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarCajaActionPerformed

        jPanelMensajeValidarABMCaja.setBounds(225, 213, 250, 100);
        auxAbm = 2;
        
        jButtonAgregarCaja.setEnabled(false);
        jButtonEditarCaja.setEnabled(false);
        jButtonBorrarCaja.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldIuCaja.setEditable(false);
        jTextFieldIuTipoCaja.setEditable(false);
        jTextFieldANombreDe.setEditable(false);
        jTextFieldDescrCaja.setEditable(false);
        jTextFieldFechaCaja.setEditable(false);
        jTextFieldFechaFactura.setEditable(false);
        jTextFieldNumFactura.setEditable(false);
        jTextFieldTotalCaja.setEditable(false);
        jButtonRegTipoCaja.setEnabled(false);
        jButtonRegTipoFactura.setEnabled(false);
        jButtonRegDetalleCaja.setEnabled(false);
        jListTipoCaja.setVisible(false);
        jListTipoFactura.setVisible(false);
    }//GEN-LAST:event_jButtonEditarCajaActionPerformed

    private void jButtonBorrarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarCajaActionPerformed

        jPanelMensajeValidarABMCaja.setBounds(225, 213, 250, 100);
        auxAbm = 3;
        
        jButtonAgregarCaja.setEnabled(false);
        jButtonEditarCaja.setEnabled(false);
        jButtonBorrarCaja.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(false);
        jTextFieldIuCaja.setEditable(false);
        jTextFieldIuTipoCaja.setEditable(false);
        jTextFieldANombreDe.setEditable(false);
        jTextFieldDescrCaja.setEditable(false);
        jTextFieldFechaCaja.setEditable(false);
        jTextFieldFechaFactura.setEditable(false);
        jTextFieldNumFactura.setEditable(false);
        jTextFieldTotalCaja.setEditable(false);
        jButtonRegTipoCaja.setEnabled(false);
        jButtonRegTipoFactura.setEnabled(false);
        jButtonRegDetalleCaja.setEnabled(false);
        jListTipoCaja.setVisible(false);
        jListTipoFactura.setVisible(false);
    }//GEN-LAST:event_jButtonBorrarCajaActionPerformed

    private void jButtonTraerPanelBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelBuscarActionPerformed

        try {
            
            jTableCaja.setModel(_administradorCaja.cargarJTabla());
        } catch (Exception e) {
            jPanelErrorBaseDeDatos.setBounds(225, 213, 250, 100);
        }
        
        jPanelGlobalCaja.setBounds(-700, 65, 700, 525);
        jPanelVentanaBuscarCaja.setBounds( 0,65,  700, 525);
    }//GEN-LAST:event_jButtonTraerPanelBuscarActionPerformed

    private void jButtonAceptarErrorBaseDeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarErrorBaseDeDatosActionPerformed

        jPanelErrorBaseDeDatos.setBounds(-260, 213, 250, 100);
    }//GEN-LAST:event_jButtonAceptarErrorBaseDeDatosActionPerformed

    private void jTextFieldBuscarCatalogoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarCatalogoKeyTyped

    }//GEN-LAST:event_jTextFieldBuscarCatalogoKeyTyped

    private void jButtonVerTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerTodosActionPerformed
        JFrameRegistroListaTurnos obj = new JFrameRegistroListaTurnos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_jButtonVerTodosActionPerformed

    private void jButtonAgregarTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarTurnosActionPerformed

        JFrameRegistroTurnos obj = new JFrameRegistroTurnos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        this.pack();
    }//GEN-LAST:event_jButtonAgregarTurnosActionPerformed

    private void jButtonCajaPricipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCajaPricipalActionPerformed
        
        jTextFieldIuTipoCaja.setBorder(null);    
        jTextFieldANombreDe.setBorder(null);
        jTextFieldDescrCaja.setBorder(null);
        jTextFieldFechaCaja.setBorder(null);
        jTextFieldFechaFactura.setBorder(null);
        jTextFieldIuCaja.setBorder(null);
        jTextFieldIuTipoFactura.setBorder(null);
        jTextFieldNumFactura.setBorder(null);
        jTextFieldTotalCaja.setBorder(null);
        
        jTextFieldFechaPresup.setBorder(null);
        jTextFieldIuTipoPresupuesto.setBorder(null);
        jTextFieldDirigidoA.setBorder(null);
        jTextFieldCodModeloVeh.setBorder(null);
        jTextFieldPatenteVeh.setBorder(null);
        jTextFieldCodigoCristal.setBorder(null);
        jTextFieldIuMarcaCris.setBorder(null);
        jTextFieldIuServicios.setBorder(null);
        jTextFieldDescrPresup.setBorder(null);
        jTextFieldTotalPresup.setBorder(null);
                    
        jTextFieldIuPresupuesto.setBorder(null);
        jTextFieldIuCartera.setBorder(null);
        jTextFieldPosibleRetirador.setBorder(null);
        jTextFieldNombExaminador.setBorder(null);
        jTextFieldDominioVeh.setBorder(null);
        
        auxAbm = 1;
        limpiarCamposCaja();
        jButtonAgregarCaja.setEnabled(false);
        jButtonEditarCaja.setEnabled(false);
        jButtonBorrarCaja.setEnabled(false);
        
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldIuCaja.setEditable(false);
        jTextFieldIuTipoCaja.setEditable(true);
        jTextFieldANombreDe.setEditable(true);
        jTextFieldDescrCaja.setEditable(true);
        jTextFieldFechaCaja.setEditable(true);
        jTextFieldFechaFactura.setEditable(true);
        jTextFieldIuTipoFactura.setEditable(true);
        jTextFieldNumFactura.setEditable(true);
        jTextFieldTotalCaja.setEditable(true);
        jTextFieldIuTipoCaja.setBorder(null);    
        jTextFieldANombreDe.setBorder(null);
        jTextFieldDescrCaja.setBorder(null);
        jTextFieldFechaCaja.setBorder(null);
        jTextFieldFechaFactura.setBorder(null);
        jTextFieldIuCaja.setBorder(null);
        jTextFieldIuTipoFactura.setBorder(null);
        jTextFieldNumFactura.setBorder(null);
        jTextFieldTotalCaja.setBorder(null);
        jListTipoCaja.setVisible(true);
        jListTipoFactura.setVisible(true);
        jButtonRegDetalleCaja.setEnabled(true);
        jButtonRegTipoCaja.setEnabled(true);
        jButtonRegTipoFactura.setEnabled(true);
        
        jPanelVentanaBuscarCaja.setBounds(-700, 65, 700,525);
        
        jPanelBuscarCatalogo.setBounds(-1000, 65, 700, 75);
        jScrollPaneListaCatalogo.setBounds(-1000, 140, 700, 450);
        jPanelBuscarCatalogo.repaint();
        jScrollPaneListaCatalogo.repaint();
        jPanelGlobalPresupuesto.setBounds(-1000, 65, 700, 525);
        jPanelGlobalPresupuesto.repaint();
        jPanelGlobalExamenes.setBounds(-1000, 65, 700, 525);
        jPanelGlobalExamenes.repaint();
        jPanelVentanaBuscarExamen.setBounds(-1000, 65, 700, 525);
        jPanelVentanaBuscarExamen.repaint();
        jPanelVentanaBuscarPresup.setBounds(-1000, 65, 700, 525);
        jPanelVentanaBuscarPresup.repaint();
        
        jPanelGlobalCaja.setBounds(0, 65, 700, 525);
        jPanelGlobalCaja.repaint();
        this.repaint();

        
        
    }//GEN-LAST:event_jButtonCajaPricipalActionPerformed

    private void jButtonGlobalPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGlobalPresupuestoActionPerformed
       
        jTextFieldIuTipoCaja.setBorder(null);    
        jTextFieldANombreDe.setBorder(null);
        jTextFieldDescrCaja.setBorder(null);
        jTextFieldFechaCaja.setBorder(null);
        jTextFieldFechaFactura.setBorder(null);
        jTextFieldIuCaja.setBorder(null);
        jTextFieldIuTipoFactura.setBorder(null);
        jTextFieldNumFactura.setBorder(null);
        jTextFieldTotalCaja.setBorder(null);
        
        jTextFieldFechaPresup.setBorder(null);
        jTextFieldIuTipoPresupuesto.setBorder(null);
        jTextFieldDirigidoA.setBorder(null);
        jTextFieldCodModeloVeh.setBorder(null);
        jTextFieldPatenteVeh.setBorder(null);
        jTextFieldCodigoCristal.setBorder(null);
        jTextFieldIuMarcaCris.setBorder(null);
        jTextFieldIuServicios.setBorder(null);
        jTextFieldDescrPresup.setBorder(null);
        jTextFieldTotalPresup.setBorder(null);
                    
        jTextFieldIuPresupuesto.setBorder(null);
        jTextFieldIuCartera.setBorder(null);
        jTextFieldPosibleRetirador.setBorder(null);
        jTextFieldNombExaminador.setBorder(null);
        jTextFieldDominioVeh.setBorder(null);
        
        auxAbm = 0;
        limpiarCamposPresup();
        
        jButtonAgregarPresupuesto.setEnabled(true);
        jButtonEditarPresupuesto.setEnabled(false);
        jButtonBorrarPresupuesto.setEnabled(false);
        
        jButtonTraerPanelBuscarPresup.setEnabled(true);
        jTextFieldIuPresupuesto.setEditable(false);
        jTextFieldIuPresupuesto.setBorder(null);
        
        
        jPanelGlobalCaja.setBounds(-1000, 65, 700, 525);
        jPanelGlobalCaja.repaint();
        jPanelGlobalExamenes.setBounds(-1000, 65, 700, 525);
        jPanelGlobalExamenes.repaint();
        jPanelBuscarCatalogo.setBounds(-1000, 65, 700, 75);
        jScrollPaneListaCatalogo.setBounds(-1000, 140, 700, 450);
        jPanelBuscarCatalogo.repaint();
        jScrollPaneListaCatalogo.repaint();
        jPanelVentanaBuscarCaja.setBounds(-1000, 65, 700, 525);
        jPanelVentanaBuscarCaja.repaint();
        jPanelVentanaBuscarExamen.setBounds(-1000, 65, 700, 525);
        jPanelVentanaBuscarExamen.repaint();
       
        jPanelGlobalPresupuesto.setBounds(0, 65, 700, 525);
        jPanelGlobalPresupuesto.repaint();
        this.repaint();
    }//GEN-LAST:event_jButtonGlobalPresupuestoActionPerformed

    private void jButtonGlobalExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGlobalExamenesActionPerformed

        jTextFieldIuTipoCaja.setBorder(null);    
        jTextFieldANombreDe.setBorder(null);
        jTextFieldDescrCaja.setBorder(null);
        jTextFieldFechaCaja.setBorder(null);
        jTextFieldFechaFactura.setBorder(null);
        jTextFieldIuCaja.setBorder(null);
        jTextFieldIuTipoFactura.setBorder(null);
        jTextFieldNumFactura.setBorder(null);
        jTextFieldTotalCaja.setBorder(null);
        
        jTextFieldFechaPresup.setBorder(null);
        jTextFieldIuTipoPresupuesto.setBorder(null);
        jTextFieldDirigidoA.setBorder(null);
        jTextFieldCodModeloVeh.setBorder(null);
        jTextFieldPatenteVeh.setBorder(null);
        jTextFieldCodigoCristal.setBorder(null);
        jTextFieldIuMarcaCris.setBorder(null);
        jTextFieldIuServicios.setBorder(null);
        jTextFieldDescrPresup.setBorder(null);
        jTextFieldTotalPresup.setBorder(null);
                    
        jTextFieldIuPresupuesto.setBorder(null);
        jTextFieldIuCartera.setBorder(null);
        jTextFieldPosibleRetirador.setBorder(null);
        jTextFieldNombExaminador.setBorder(null);
        jTextFieldDominioVeh.setBorder(null);
        
        jPanelGlobalCaja.setBounds(-1000, 65, 700, 525);
        jPanelGlobalCaja.repaint();
        jPanelBuscarCatalogo.setBounds(-1000, 65, 700, 75);
        jScrollPaneListaCatalogo.setBounds(-1000, 140, 700, 450);
        jPanelBuscarCatalogo.repaint();
        jScrollPaneListaCatalogo.repaint(); 
        jPanelGlobalPresupuesto.setBounds(-1000, 65, 700, 525);
        jPanelGlobalPresupuesto.repaint();
        jPanelVentanaBuscarCaja.setBounds(-1000, 65, 700, 525);
        jPanelVentanaBuscarCaja.repaint();
        jPanelVentanaBuscarPresup.setBounds(-1000, 65, 700, 525);
        jPanelVentanaBuscarPresup.repaint();
        
        jPanelGlobalExamenes.setBounds(0, 65, 700, 525);
        jPanelGlobalExamenes.repaint();
        this.repaint();
        jTextFieldFechaExamen.setText(_administrador.obtenerFechaMaquina());
        jTextFieldFechaExamen.setEditable(false);
        jTextFieldNumExamenVeh.setEditable(false);
        auxAbm = 0;
        limpiarCamposExamen();
        
        jButtonAgregarExamen.setEnabled(true);
        jButtonEditarExamen.setEnabled(false);
        jButtonBorrarExamen.setEnabled(false);
        jButtonTraerPanelBuscar1.setEnabled(true);
    }//GEN-LAST:event_jButtonGlobalExamenesActionPerformed

    private void jListTipoCajaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListTipoCajaFocusGained

        jPanelListaIuTipoCaja.setBounds(157,140, 200, 50);
    }//GEN-LAST:event_jListTipoCajaFocusGained

    private void jListTipoCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTipoCajaMouseClicked
        int indexList = jListTipoCaja.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList2 = true;
            jTextFieldIuTipoCaja.setText("");
            jTextFieldIuTipoCaja.setText(jListTipoCaja.getSelectedValue());
            jPanelListaIuTipoCaja.setBounds(-300, 140, 200, 50);
        } else{
            auxSeleccionList2 = false;
        }
    }//GEN-LAST:event_jListTipoCajaMouseClicked

    private void jListTipoFacturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListTipoFacturaFocusGained

        jPanelListaIuTipoFactura.setBounds(308,218, 100, 50);
    }//GEN-LAST:event_jListTipoFacturaFocusGained

    private void jListTipoFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTipoFacturaMouseClicked
        int indexList = jListTipoFactura.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList2 = true;
            jTextFieldIuTipoFactura.setText("");
            jTextFieldIuTipoFactura.setText(jListTipoFactura.getSelectedValue());
            jPanelListaIuTipoFactura.setBounds(-308,218, 100, 50);
        } else{
            auxSeleccionList2 = false;
        }

    }//GEN-LAST:event_jListTipoFacturaMouseClicked

    private void jTextFieldBuscarCajaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarCajaKeyReleased
        boolean auxValidar = Administrador.validarCharDinamico(evt.getKeyChar(), "[a-zA-Z_0-9]||[\\s]");
        try {

            if(auxValidar==false){

                evt.consume();
                jTableCaja.setModel(_administradorCaja.cargarJTabla());

            } else{

                jTableCaja.setModel(_administradorCaja.buscarEnTabla(jTextFieldBuscarCaja.getText()));
            }
        } catch (Exception e) {

            jPanelErrorBaseDeDatosCaja1.setBounds(225, 213, 250, 100);
        }
    }//GEN-LAST:event_jTextFieldBuscarCajaKeyReleased

    private void jButtonTraerPanelCuerpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelCuerpoActionPerformed
        //llama al panel contenedor del abm
        jPanelVentanaBuscarCaja.setBounds(-700, 65, 700, 525);
        jPanelGlobalCaja.setBounds( 0,65,  700, 525);
    }//GEN-LAST:event_jButtonTraerPanelCuerpoActionPerformed

    private void jButtonMenuCarteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuCarteraActionPerformed

        jPanelMenuDesplegableCartera.setBounds(-260, 28, 250, 75);
    }//GEN-LAST:event_jButtonMenuCarteraActionPerformed

    private void jButtonAceptarElementoNoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoNoExistenteActionPerformed
        switch(auxAbm){

            case 1:
            
            if(auxBttDetalle==1){
                
                jButtonAgregarCaja.setEnabled(false);
                auxBttDetalle= 0;
            } else{
                
                jButtonAgregarCaja.setEnabled(true);
            }
            jPanelElementoNoExistenteCaja.setBounds(-260, 213, 250, 100);

            jButtonEditarCaja.setEnabled(false);
            jButtonBorrarCaja.setEnabled(false);
            jButtonTraerPanelBuscar.setEnabled(true);
            jTextFieldIuCaja.setEditable(false);
            jTextFieldIuTipoCaja.setEditable(true);
            jTextFieldIuTipoFactura.setEditable(true);
            jTextFieldFechaCaja.setEditable(true);
            jTextFieldNumFactura.setEditable(true);
            jTextFieldANombreDe.setEditable(true);
            jTextFieldDescrCaja.setEditable(true);
            jTextFieldTotalCaja.setEditable(true);
            jButtonRegTipoCaja.setEnabled(true);
            jButtonRegTipoFactura.setEnabled(true);
            jListTipoCaja.setVisible(true);
            jListTipoFactura.setVisible(true);
            break;

            case 2:
            jPanelElementoNoExistenteCaja.setBounds(-260, 213, 250, 100);
            jButtonAgregarCaja.setEnabled(false);
            jButtonEditarCaja.setEnabled(true);
            jButtonBorrarCaja.setEnabled(false);
            jButtonTraerPanelBuscar.setEnabled(true);
            jTextFieldDescrCaja.setEditable(true);
            jTextFieldIuCaja.setEditable(false);
            jTextFieldIuTipoCaja.setEditable(true);
            jTextFieldIuTipoFactura.setEditable(true);
            jTextFieldFechaCaja.setEditable(true);
            jTextFieldFechaFactura.setEditable(true);
            jTextFieldANombreDe.setEditable(true);
            jTextFieldNumFactura.setEditable(true);
            jTextFieldTotalCaja.setEditable(true);
            jButtonRegTipoCaja.setEnabled(true);
            jButtonRegTipoFactura.setEnabled(true);
            jListTipoCaja.setVisible(true);
            jListTipoFactura.setVisible(true);
            break;

            case 3:
            jPanelElementoNoExistenteCaja.setBounds(-260, 213, 250, 100);
            jButtonAgregarCaja.setEnabled(false);
            jButtonEditarCaja.setEnabled(false);
            jButtonBorrarCaja.setEnabled(true);
            jTextFieldIuCaja.setEditable(false);
            jButtonTraerPanelBuscar.setEnabled(true);
            jButtonTraerPanelBuscar.setEnabled(true);
            jTextFieldDescrCaja.setEditable(true);
            jTextFieldIuTipoCaja.setEditable(true);
            jTextFieldIuTipoFactura.setEditable(true);
            jTextFieldFechaCaja.setEditable(true);
            jTextFieldFechaFactura.setEditable(true);
            jTextFieldANombreDe.setEditable(true);
            jTextFieldNumFactura.setEditable(true);
            jTextFieldTotalCaja.setEditable(true);
            jButtonRegTipoCaja.setEnabled(true);
            jButtonRegTipoFactura.setEnabled(true);
            jListTipoCaja.setVisible(true);
            jListTipoFactura.setVisible(true);
            break;
            
            case 4:
            jPanelElementoNoExistenteCaja.setBounds(-260, 213, 250, 100);
            jPanelDatosErroneoCaja.setBounds(-260, 213, 250, 100);
            jButtonAgregarCaja.setEnabled(true);
            jButtonEditarCaja.setEnabled(false);
            jButtonBorrarCaja.setEnabled(false);
            jButtonTraerPanelBuscar.setEnabled(true);
            jTextFieldIuTipoCaja.setEditable(true);
            jTextFieldIuTipoFactura.setEditable(true);
            jTextFieldFechaCaja.setEditable(true);
            jTextFieldNumFactura.setEditable(true);
            jTextFieldANombreDe.setEditable(true);
            jTextFieldDescrCaja.setEditable(true);
            jTextFieldTotalCaja.setEditable(true);
            jButtonRegTipoCaja.setEnabled(true);
            jButtonRegTipoFactura.setEnabled(true);
            jListTipoCaja.setVisible(true);
            jListTipoFactura.setVisible(true);
            break;

        }
    }//GEN-LAST:event_jButtonAceptarElementoNoExistenteActionPerformed

    private void jButtonAceptarItemNoSeleccionado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

        jTableCaja.setEnabled(true);
        jPanelItemNoSeleccionadoCaja.setBounds(-260, 213, 250, 100);
    }//GEN-LAST:event_jButtonAceptarItemNoSeleccionado2ActionPerformed

    private void jButtonAceptarElementoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoExistenteActionPerformed

        jPanelElementoExistenteCaja.setBounds(-260, 213, 250, 100);
        jButtonAgregarCaja.setEnabled(false);
        jButtonEditarCaja.setEnabled(false);
        jButtonBorrarCaja.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldIuCaja.setEditable(false);
        jTextFieldIuTipoCaja.setEditable(true);
        jTextFieldANombreDe.setEditable(true);
        jTextFieldDescrCaja.setEditable(true);
        jTextFieldFechaCaja.setEditable(true);
        jTextFieldFechaFactura.setEditable(true);
        jTextFieldNumFactura.setEditable(true);
        jTextFieldTotalCaja.setEditable(true);
        jButtonRegTipoCaja.setEnabled(true);
        jButtonRegTipoFactura.setEnabled(true);
        jButtonRegDetalleCaja.setEnabled(true);
        jListTipoCaja.setVisible(true);
        jListTipoFactura.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarElementoExistenteActionPerformed

    private void jButtonAceptarErrorBaseDeDatos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarErrorBaseDeDatos1ActionPerformed

        jPanelErrorBaseDeDatosCaja.setBounds(-260, 213, 250, 100);
        jButtonAgregarCaja.setEnabled(false);
        jButtonEditarCaja.setEnabled(false);
        jButtonBorrarCaja.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldIuCaja.setEditable(false);
        jTextFieldIuTipoCaja.setEditable(true);
        jTextFieldANombreDe.setEditable(true);
        jTextFieldDescrCaja.setEditable(true);
        jTextFieldFechaCaja.setEditable(true);
        jTextFieldFechaFactura.setEditable(true);
        jTextFieldNumFactura.setEditable(true);
        jTextFieldTotalCaja.setEditable(true);
        jButtonRegTipoCaja.setEnabled(true);
        jButtonRegTipoFactura.setEnabled(true);
        jButtonRegDetalleCaja.setEnabled(true);
        jListTipoCaja.setVisible(true);
        jListTipoFactura.setVisible(true);
        jPanelListaIuTipoCaja.setVisible(true);
        jPanelListaIuTipoFactura.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarErrorBaseDeDatos1ActionPerformed

    private void jButtonAceptarGuardadoErroneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoErroneoActionPerformed
        switch(auxAbm){

            case 1:
            jPanelGuardadoErroneoCaja.setBounds(-260, 213, 250, 100);
            jButtonAgregarCaja.setEnabled(false);
            jButtonEditarCaja.setEnabled(false);
            jButtonBorrarCaja.setEnabled(false);
            jButtonTraerPanelBuscar.setEnabled(true);
            jTextFieldIuCaja.setEditable(false);
            jTextFieldIuTipoCaja.setEditable(true);
            jTextFieldANombreDe.setEditable(true);
            jTextFieldDescrCaja.setEditable(true);
            jTextFieldFechaCaja.setEditable(true);
            jTextFieldFechaFactura.setEditable(true);
            jTextFieldNumFactura.setEditable(true);
            jTextFieldTotalCaja.setEditable(true);
            jButtonRegTipoCaja.setEnabled(true);
            jButtonRegTipoFactura.setEnabled(true);
            jButtonRegDetalleCaja.setEnabled(true);
            jListTipoCaja.setVisible(true);
            jListTipoFactura.setVisible(true);
            jButtonRegDetalleCaja.setEnabled(true);
            jButtonRegTipoCaja.setEnabled(true);
            jButtonRegTipoFactura.setEnabled(true);

            break;

            case 2:
            jPanelGuardadoErroneoCaja.setBounds(-260, 213, 250, 100);
            jButtonAgregarCaja.setEnabled(false);
            jButtonEditarCaja.setEnabled(true);
            jButtonBorrarCaja.setEnabled(false);
            jButtonTraerPanelBuscar.setEnabled(true);
            jTextFieldIuCaja.setEditable(false);
            jTextFieldIuTipoCaja.setEditable(true);
            jTextFieldANombreDe.setEditable(true);
            jTextFieldDescrCaja.setEditable(true);
            jTextFieldFechaCaja.setEditable(false);
            jTextFieldFechaFactura.setEditable(true);
            jTextFieldNumFactura.setEditable(true);
            jTextFieldTotalCaja.setEditable(true);
            jButtonRegTipoCaja.setEnabled(true);
            jButtonRegTipoFactura.setEnabled(true);
            jButtonRegDetalleCaja.setEnabled(true);
            jListTipoCaja.setVisible(true);
            jListTipoFactura.setVisible(true);
            jButtonRegDetalleCaja.setEnabled(true);
            jButtonRegTipoCaja.setEnabled(true);
            jButtonRegTipoFactura.setEnabled(true);
            jPanelListaIuTipoCaja.setVisible(true);
            jPanelListaIuTipoFactura.setVisible(true);
            break;

            case 3:
            jPanelGuardadoErroneoCaja.setBounds(-260, 213, 250, 100);
            jButtonAgregarCaja.setEnabled(false);
            jButtonEditarCaja.setEnabled(false);
            jButtonBorrarCaja.setEnabled(true);
            jButtonTraerPanelBuscar.setEnabled(true);
            break;
        }
    }//GEN-LAST:event_jButtonAceptarGuardadoErroneoActionPerformed

    private void jButtonAceptarGuardadoExitosoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoExitosoActionPerformed

        jPanelGuardadoExitosoCaja.setBounds(-260, 213, 250, 100);
        jTextFieldIuCaja.setBorder(null);
        jTextFieldIuTipoCaja.setBorder(null);
        jTextFieldANombreDe.setBorder(null);
        jTextFieldDescrCaja.setBorder(null);
        jTextFieldFechaCaja.setBorder(null);
        jTextFieldFechaFactura.setBorder(null);
        jTextFieldIuTipoFactura.setBorder(null);
        jTextFieldNumFactura.setBorder(null);
        jTextFieldTotalCaja.setBorder(null);
        limpiarCamposCaja();
        jButtonAgregarCaja.setEnabled(false);
        jButtonEditarCaja.setEnabled(false);
        jButtonBorrarCaja.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldIuCaja.setEditable(false);
        jTextFieldIuTipoCaja.setEditable(true);
        jTextFieldANombreDe.setEditable(true);
        jTextFieldDescrCaja.setEditable(true);
        jTextFieldFechaCaja.setEditable(true);
        jTextFieldFechaFactura.setEditable(true);
        jTextFieldNumFactura.setEditable(true);
        jTextFieldTotalCaja.setEditable(true);
        jButtonRegTipoCaja.setEnabled(true);
        jButtonRegTipoFactura.setEnabled(true);
        jButtonRegDetalleCaja.setEnabled(true);
        jListTipoCaja.setVisible(true);
        jListTipoFactura.setVisible(true);
        jButtonRegDetalleCaja.setEnabled(true);
        jButtonRegTipoCaja.setEnabled(true);
        jButtonRegTipoFactura.setEnabled(true);
        jPanelListaIuTipoCaja.setVisible(true);
        jPanelListaIuTipoFactura.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarGuardadoExitosoActionPerformed

    private void jButtonCancelarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarValidarCambiosActionPerformed

        auxAbm = 1;
        limpiarCamposCaja();
        jPanelMensajeValidarABMCaja.setBounds(-260, 213, 250, 100);
        jButtonAgregarCaja.setEnabled(false);
        jButtonEditarCaja.setEnabled(false);
        jButtonBorrarCaja.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldIuTipoCaja.setEditable(true);
        jTextFieldANombreDe.setEditable(true);
        jTextFieldDescrCaja.setEditable(true);
        jTextFieldFechaCaja.setEditable(true);
        jTextFieldFechaFactura.setEditable(true);
        jTextFieldIuCaja.setEditable(false);
        jTextFieldIuTipoFactura.setEditable(true);
        jTextFieldNumFactura.setEditable(true);
        jTextFieldTotalCaja.setEditable(true);
        jTextFieldIuTipoCaja.setBorder(null);    
        jTextFieldANombreDe.setBorder(null);
        jTextFieldDescrCaja.setBorder(null);
        jTextFieldFechaCaja.setBorder(null);
        jTextFieldFechaFactura.setBorder(null);
        jTextFieldIuCaja.setBorder(null);
        jTextFieldIuTipoFactura.setBorder(null);
        jTextFieldNumFactura.setBorder(null);
        jTextFieldTotalCaja.setBorder(null);
        jListTipoCaja.setVisible(true);
        jListTipoFactura.setVisible(true);
        jButtonRegDetalleCaja.setEnabled(true);
        jButtonRegTipoCaja.setEnabled(true);
        jButtonRegTipoFactura.setEnabled(true);
        jPanelListaIuTipoCaja.setVisible(true);
        jPanelListaIuTipoFactura.setVisible(true);
        
    }//GEN-LAST:event_jButtonCancelarValidarCambiosActionPerformed

    private void jButtonAceptarValidarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarValidarCambiosActionPerformed
        boolean[] listaVerdades = new boolean[8];
        int aux = 0;
        int auxMensaje2 = 0;
        int auxMensaje = 0;
        // llama al panel y segun desde donde llamo ejecuta la accion
        jPanelMensajeValidarABMCaja.setBounds(-260, 213, 250, 100);

        switch(auxAbm){

            case 1:
            break;
            // se repite el mismo codigo solo que se edita un item de la db
            case 2:
            // se validan los datos
            validarIuTipoCaja();
            listaVerdades[0] = auxSeleccionList;
            listaVerdades[1] = Administrador.validarFecha(jTextFieldFechaCaja.getText());
            validarIuTipoFactura();
            listaVerdades[2] = auxSeleccionList2;
            listaVerdades[3] = Administrador.validarFecha(jTextFieldFechaFactura.getText());
            listaVerdades[4] = Administrador.validarCamposTextos(jTextFieldNumFactura.getText(), "[0-9]" );
            listaVerdades[5] = Administrador.validarCamposTextos(jTextFieldANombreDe.getText(), "[a-zA-Z_0-9]||[.]||[-]||[\\s]" );
            listaVerdades[6] = Administrador.validarCamposTextos(jTextFieldDescrCaja.getText(), "[a-zA-Z_0-9]||[.]||[-]||[\\s]" );
            listaVerdades[7] = Administrador.validarCamposDoubles(jTextFieldTotalCaja.getText());

            for (int i = 0; i < listaVerdades.length; i++) {
                if(listaVerdades[i]== true)aux++;

            }
            if(aux==7){
                jTextFieldIuTipoCaja.setBorder(new LineBorder(Color.green));
                jTextFieldFechaCaja.setBorder(new LineBorder(Color.green));
                jTextFieldIuTipoFactura.setBorder(new LineBorder(Color.green));
                jTextFieldFechaFactura.setBorder(new LineBorder(Color.green));
                jTextFieldNumFactura.setBorder(new LineBorder(Color.green));
                jTextFieldANombreDe.setBorder(new LineBorder(Color.green));
                jTextFieldDescrCaja.setBorder(new LineBorder(Color.green));
                jTextFieldTotalCaja.setBorder(new LineBorder(Color.green));
                auxSeleccionList = false;
                auxSeleccionList2 = false;
                crearObjCaja();
                // se avisa en caso de estar apagada la db y si no se agrega un item a la db
                try {
                    if(_administradorCaja.actualizarTablaCajas(_objCaja)==true){

                        jPanelGuardadoExitosoCaja.setBounds(225, 213, 250, 100);

                    } else{

                        jPanelElementoExistenteCaja.setBounds(225, 213, 250, 100);
                    }
                } catch (Exception e) {
                    jPanelErrorBaseDeDatos.setBounds(225, 213, 250, 100);
                }

            } else{
                for (int i = 0; i < listaVerdades.length; i++) {
                    switch(i){

                        case 0:
                        if(listaVerdades[i]==true){
                            jTextFieldIuTipoCaja.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldIuTipoCaja.setBorder(new LineBorder(Color.red));
                            if(_administradorTipoCaja.obtenerIuTipoCaja(jTextFieldIuTipoCaja.getText()).length()==0){

                                auxMensaje = 1;
                            }
                        }
                        break;
                        case 1:
                        if(listaVerdades[i]==true){
                            jTextFieldFechaCaja.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldFechaCaja.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                        case 2:
                        if(listaVerdades[i]==true){
                            jTextFieldIuTipoFactura.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldIuTipoFactura.setBorder(new LineBorder(Color.red));
                            if(_administradorTipoFactura.obtenerIuTipoFactura(jTextFieldIuTipoFactura.getText()).length()==0){

                                auxMensaje = 1;
                            }
                        }
                        break;
                        case 3:
                        if(listaVerdades[i]==true){
                            jTextFieldFechaFactura.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldFechaFactura.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                        case 4:
                        if(listaVerdades[i]==true){
                            jTextFieldNumFactura.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldNumFactura.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                        case 5:
                        if(listaVerdades[i]==true){
                            jTextFieldANombreDe.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldANombreDe.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                        case 6:
                        if(listaVerdades[i]==true){
                            jTextFieldDescrCaja.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldDescrCaja.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                        case 7:
                        if(listaVerdades[i]==true){
                            jTextFieldTotalCaja.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldTotalCaja.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                    }
                }
                if(auxMensaje==1) jPanelElementoNoExistenteCaja.setBounds(225, 213, 250, 100);
                if(auxMensaje2==1) jPanelGuardadoErroneoCaja.setBounds(225, 213, 250, 100);

            }
            break;
            // se repite el mismo codigo solo que se borra un item de la db
            case 3:
            // se validan los datos
            validarIuTipoCaja();
            listaVerdades[0] = auxSeleccionList;
            listaVerdades[1] = Administrador.validarFecha(jTextFieldFechaCaja.getText());
            validarIuTipoFactura();
            listaVerdades[2] = auxSeleccionList2;
            listaVerdades[3] = Administrador.validarFecha(jTextFieldFechaFactura.getText());
            listaVerdades[4] = Administrador.validarCamposTextos(jTextFieldNumFactura.getText(), "[0-9]" );
            listaVerdades[5] = Administrador.validarCamposTextos(jTextFieldANombreDe.getText(), "[a-zA-Z_0-9]||[.]||[-]||[\\s]" );
            listaVerdades[6] = Administrador.validarCamposTextos(jTextFieldDescrCaja.getText(), "[a-zA-Z_0-9]||[.]||[-]||[\\s]" );
            listaVerdades[7] = Administrador.validarCamposDoubles(jTextFieldTotalCaja.getText());

            for (int i = 0; i < listaVerdades.length; i++) {
                if(listaVerdades[i]== true)aux++;

            }
            if(aux==7){
                jTextFieldIuTipoCaja.setBorder(new LineBorder(Color.green));
                jTextFieldFechaCaja.setBorder(new LineBorder(Color.green));
                jTextFieldIuTipoFactura.setBorder(new LineBorder(Color.green));
                jTextFieldFechaFactura.setBorder(new LineBorder(Color.green));
                jTextFieldNumFactura.setBorder(new LineBorder(Color.green));
                jTextFieldANombreDe.setBorder(new LineBorder(Color.green));
                jTextFieldDescrCaja.setBorder(new LineBorder(Color.green));
                jTextFieldTotalCaja.setBorder(new LineBorder(Color.green));
                auxSeleccionList = false;
                auxSeleccionList2 = false;
                crearObjCaja();
                // se avisa en caso de estar apagada la db y si no se agrega un item a la db
                try {
                    if(_administradorCaja.eliminarTablaCajas(_objCaja)==true){

                        DetallesDeCaja _objDC = new DetallesDeCaja();
                        _objDC.setIuCaja(Integer.parseInt(jTextFieldIuCaja.getText()));
                        for (int i = 1; i <= _administradorDetallesCaja.obtenerUltimoId(_objDC); i++) {
                            
                            _objDC.setIuDetalleCaja(i);
                            _administradorDetallesCaja.eliminarTablaDetalleCaja(_objDC);
                        }
                        jPanelGuardadoExitosoCaja.setBounds(225, 213, 250, 100);

                    } else{

                        jPanelElementoExistenteCaja.setBounds(225, 213, 250, 100);
                    }
                } catch (Exception e) {
                    jPanelErrorBaseDeDatos.setBounds(225, 213, 250, 100);
                }

            } else{
                for (int i = 0; i < listaVerdades.length; i++) {
                    switch(i){

                        case 0:
                        if(listaVerdades[i]==true){
                            jTextFieldIuTipoCaja.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldIuTipoCaja.setBorder(new LineBorder(Color.red));
                            if(_administradorTipoCaja.obtenerIuTipoCaja(jTextFieldIuTipoCaja.getText()).length()==0){

                                auxMensaje = 1;
                            }
                        }
                        break;
                        case 1:
                        if(listaVerdades[i]==true){
                            jTextFieldFechaCaja.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldFechaCaja.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                        case 2:
                        if(listaVerdades[i]==true){
                            jTextFieldIuTipoFactura.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldIuTipoFactura.setBorder(new LineBorder(Color.red));
                            if(_administradorTipoFactura.obtenerIuTipoFactura(jTextFieldIuTipoFactura.getText()).length()==0){

                                auxMensaje = 1;
                            }
                        }
                        break;
                        case 3:
                        if(listaVerdades[i]==true){
                            jTextFieldFechaFactura.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldFechaFactura.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                        case 4:
                        if(listaVerdades[i]==true){
                            jTextFieldNumFactura.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldNumFactura.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                        case 5:
                        if(listaVerdades[i]==true){
                            jTextFieldANombreDe.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldANombreDe.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                        case 6:
                        if(listaVerdades[i]==true){
                            jTextFieldDescrCaja.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldDescrCaja.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                        case 7:
                        if(listaVerdades[i]==true){
                            jTextFieldTotalCaja.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldTotalCaja.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                    }
                }
                if(auxMensaje==1) jPanelElementoNoExistenteCaja.setBounds(225, 213, 250, 100);
                if(auxMensaje2==1) jPanelGuardadoErroneoCaja.setBounds(225, 213, 250, 100);

            }
            break;
        }
    }//GEN-LAST:event_jButtonAceptarValidarCambiosActionPerformed

    private void jButtonRegDetalleCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegDetalleCajaActionPerformed

        boolean[] listaVerdades = new boolean[8];
        int aux = 0;
        int auxMensaje2 = 0;
        int auxMensaje = 0;
        // llama al panel y segun desde donde llamo ejecuta la accion
        jPanelMensajeValidarABMCaja.setBounds(-260, 213, 250, 100);

        switch(auxAbm){

            case 1:
            auxBttDetalle = 1;
            validarIuTipoCaja();
            listaVerdades[0] = auxSeleccionList;
            listaVerdades[1] = Administrador.validarFecha(jTextFieldFechaCaja.getText());
            validarIuTipoFactura();
            listaVerdades[2] = auxSeleccionList2;
            listaVerdades[3] = Administrador.validarFecha(jTextFieldFechaFactura.getText());
            listaVerdades[4] = Administrador.validarCamposTextos(jTextFieldNumFactura.getText(), "[0-9]" );
            listaVerdades[5] = Administrador.validarCamposTextos(jTextFieldANombreDe.getText(), "[a-zA-Z_0-9]||[.]||[-]||[\\s]" );
            listaVerdades[6] = Administrador.validarCamposTextos(jTextFieldDescrCaja.getText(), "[a-zA-Z_0-9]||[.]||[-]||[\\s]" );
            listaVerdades[7] = Administrador.validarCamposDoubles(jTextFieldTotalCaja.getText());

            for (int i = 0; i < listaVerdades.length; i++) {
                if(listaVerdades[i]== true)aux++;

            }
            if(aux==8){
                jTextFieldIuTipoCaja.setBorder(new LineBorder(Color.green));
                jTextFieldFechaCaja.setBorder(new LineBorder(Color.green));
                jTextFieldIuTipoFactura.setBorder(new LineBorder(Color.green));
                jTextFieldFechaFactura.setBorder(new LineBorder(Color.green));
                jTextFieldNumFactura.setBorder(new LineBorder(Color.green));
                jTextFieldANombreDe.setBorder(new LineBorder(Color.green));
                jTextFieldDescrCaja.setBorder(new LineBorder(Color.green));
                jTextFieldTotalCaja.setBorder(new LineBorder(Color.green));
                auxSeleccionList = false;
                auxSeleccionList2 = false;
                jTextFieldIuTipoCaja.setEditable(false);
                jTextFieldFechaCaja.setEditable(false);
                jTextFieldIuTipoFactura.setEditable(false);
                jTextFieldFechaFactura.setEditable(false);
                jTextFieldNumFactura.setEditable(false);
                jTextFieldANombreDe.setEditable(false);
                jTextFieldDescrCaja.setEditable(false);
                jTextFieldTotalCaja.setEditable(false);
                jButtonRegTipoCaja.setEnabled(false);
                jButtonRegTipoFactura.setEnabled(false);
                jListTipoCaja.setVisible(false);
                jListTipoFactura.setVisible(false);
                
                _objCaja = new Caja();
                _objCaja.setIuTipoCaja(Integer.parseInt(_administradorTipoCaja.obtenerIuTipoCaja(jTextFieldIuTipoCaja.getText())));
                _objCaja.setFechaCaja(jTextFieldFechaCaja.getText());
                _objCaja.setIuTipoFactura(Integer.parseInt(_administradorTipoFactura.obtenerIuTipoFactura(jTextFieldIuTipoFactura.getText())));
                _objCaja.setFechaFactura(jTextFieldFechaFactura.getText());
                _objCaja.setANombreDe(jTextFieldANombreDe.getText());
                _objCaja.setDescrCaja(jTextFieldDescrCaja.getText());
                _objCaja.setNumFactura(Integer.parseInt(jTextFieldNumFactura.getText()));
                _objCaja.setTotalCaja(Double.parseDouble(jTextFieldTotalCaja.getText()));

                
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
                try {
                    if(_administradorCaja.insertarTablaCajas(_objCaja)==true){
                       
// carga lista detalleCaja  
        hilo2 = new Thread(runnable2);
        hilo2.start();


        
                        JFrameRegistroDetallesDeCaja obj = new JFrameRegistroDetallesDeCaja();
                        obj.setVisible(true);
                        obj.setLocationRelativeTo(null);
                        jButtonRegDetalleCaja.setEnabled(false);
                        jButtonAgregarCaja.setEnabled(true);

                    } else{

                        jPanelElementoExistenteCaja.setBounds(225, 213, 250, 100);
                    }
                } catch (Exception e) {
                    jPanelErrorBaseDeDatos.setBounds(225, 213, 250, 100);
                }

            } else{
                for (int i = 0; i < listaVerdades.length; i++) {
                    switch(i){

                        case 0:
                        if(listaVerdades[i]==true){
                            jTextFieldIuTipoCaja.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldIuTipoCaja.setBorder(new LineBorder(Color.red));
                            if(_administradorTipoCaja.obtenerIuTipoCaja(jTextFieldIuTipoCaja.getText()).length()==0){

                                auxMensaje = 1;
                            }
                        }
                        break;
                        case 1:
                        if(listaVerdades[i]==true){
                            jTextFieldFechaCaja.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldFechaCaja.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                        case 2:
                        if(listaVerdades[i]==true){
                            jTextFieldIuTipoFactura.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldIuTipoFactura.setBorder(new LineBorder(Color.red));
                            if(_administradorTipoFactura.obtenerIuTipoFactura(jTextFieldIuTipoFactura.getText()).length()==0){

                                auxMensaje = 1;
                            }
                        }
                        break;
                        case 3:
                        if(listaVerdades[i]==true){
                            jTextFieldFechaFactura.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldFechaFactura.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                        case 4:
                        if(listaVerdades[i]==true){
                            jTextFieldNumFactura.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldNumFactura.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                        case 5:
                        if(listaVerdades[i]==true){
                            jTextFieldANombreDe.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldANombreDe.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                        case 6:
                        if(listaVerdades[i]==true){
                            jTextFieldDescrCaja.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldDescrCaja.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                        case 7:
                        if(listaVerdades[i]==true){
                            jTextFieldTotalCaja.setBorder(new LineBorder(Color.green));
                        }else{
                            jTextFieldTotalCaja.setBorder(new LineBorder(Color.red));
                            auxMensaje2 = 1;
                        }
                        break;
                    }
                }
                if(auxMensaje==1) jPanelElementoNoExistenteCaja.setBounds(225, 213, 250, 100);
                if(auxMensaje2==1) jPanelDatosErroneoCaja.setBounds(225, 213, 250, 100);

            }
            break;
            // se repite el mismo codigo solo que se edita un item de la db
            case 2:
        hilo2 = new Thread(runnable2);
        hilo2.start();

            // se va a llevar los datos del iucaja
                JFrameRegistroDetallesDeCaja obj = new JFrameRegistroDetallesDeCaja();
                obj.setVisible(true);
                obj.setIuCaja(jTextFieldIuCaja.getText());
                obj.setLocationRelativeTo(null);
            break;
            
            case 3:
//                _bttDetalleCaja = 0;
            break;
        }
    }//GEN-LAST:event_jButtonRegDetalleCajaActionPerformed

    private void jButtonRegMarcaCristalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegMarcaCristalActionPerformed
        
        JFrameRegistroMarcasCristales obj = new JFrameRegistroMarcasCristales();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegMarcaCristalActionPerformed

    private void jTextFieldCodModeloVehFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodModeloVehFocusGained
        
        jListModeloVeh.setModel(_administradorModeloVehiculo.cargarLista(_administradorModeloVehiculo.obtenercodMarcaVeh(jTextFieldCodModeloVeh.getText())));
        jPanelListaCodModeloVeh.setBounds(150, 216, 200, 50);
    }//GEN-LAST:event_jTextFieldCodModeloVehFocusGained

    private void jTextFieldCodModeloVehFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodModeloVehFocusLost
     
        jPanelListaCodModeloVeh.setBounds(-300, 216, 200, 50);
    }//GEN-LAST:event_jTextFieldCodModeloVehFocusLost

    private void jTextFieldCodModeloVehKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodModeloVehKeyReleased
        
            
        jListModeloVeh.setModel(_administradorModeloVehiculo.cargarLista(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText())));
        jPanelListaIuServicios.setBounds(150, 216, 200, 50);
    }//GEN-LAST:event_jTextFieldCodModeloVehKeyReleased

    private void jButtonAgregarPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarPresupuestoActionPerformed
        
        jPanelMensajeValidarABMPresup.setBounds(225, 213, 250, 100);
        auxAbm = 1;
    }//GEN-LAST:event_jButtonAgregarPresupuestoActionPerformed

    private void jButtonEditarPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarPresupuestoActionPerformed
        
        jPanelMensajeValidarABMPresup.setBounds(225, 213, 250, 100);
        auxAbm = 2;
    }//GEN-LAST:event_jButtonEditarPresupuestoActionPerformed

    private void jButtonBorrarPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarPresupuestoActionPerformed
        
        jPanelMensajeValidarABMPresup.setBounds(225, 213, 250, 100);
        auxAbm = 3;
    }//GEN-LAST:event_jButtonBorrarPresupuestoActionPerformed

    private void jButtonTraerPanelBuscarPresupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelBuscarPresupActionPerformed
// llama al panel buscar 
    try {
        jTablePresup.setModel(_administradorPresupuesto.cargarJTabla());
    } catch (Exception e) {
        jPanelErrorBaseDeDatos.setBounds(225, 213, 250, 100);
    }
        jPanelGlobalPresupuesto.setBounds(-1000, 65, 700, 525);
        jPanelVentanaBuscarPresup.setBounds( 0,65,  700, 525);  
        jPanelVentanaBuscarPresup.repaint();
    }//GEN-LAST:event_jButtonTraerPanelBuscarPresupActionPerformed

    private void jButtonRegModeloVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegModeloVehiculoActionPerformed
        JFrameRegistroModelosVehiculos obj = new JFrameRegistroModelosVehiculos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegModeloVehiculoActionPerformed

    private void jButtonRegCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegCatalogoActionPerformed
        JFrameRegistroCatalogoCristales obj = new JFrameRegistroCatalogoCristales();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegCatalogoActionPerformed

    private void jButtonRegServiciosPrestadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegServiciosPrestadosActionPerformed
        JFrameRegistroServiciosPrestados obj = new JFrameRegistroServiciosPrestados();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegServiciosPrestadosActionPerformed

    private void jListModeloVehMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModeloVehMouseClicked
        int indexList = jListModeloVeh.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList2 = true;
            jTextFieldCodModeloVeh.setText("");
            jTextFieldCodModeloVeh.setText(jListModeloVeh.getSelectedValue());
            jPanelListaCodModeloVeh.setBounds(-300, 216, 200, 50);
        } else{
            auxSeleccionList2 = false;
        }
    
    }//GEN-LAST:event_jListModeloVehMouseClicked

    private void jListCodigoCrstalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListCodigoCrstalMouseClicked
        int indexList = jListCodigoCrstal.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList2 = true;
            jTextFieldCodigoCristal.setText("");
            jTextFieldCodigoCristal.setText(jListCodigoCrstal.getSelectedValue());
            jPanelListaCodigoCristal.setBounds(-300, 297, 100, 50);
        } else{
            auxSeleccionList2 = false;
        }
    
    }//GEN-LAST:event_jListCodigoCrstalMouseClicked

    private void jButtonAceptarElementoNoExistente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoNoExistente1ActionPerformed
               
        jPanelElementoNoExistentePresup.setBounds(-260, 100, 250, 100);
        jButtonAgregarPresupuesto.setEnabled(true);
        jButtonEditarPresupuesto.setEnabled(false);
        jButtonBorrarPresupuesto.setEnabled(false);
        jButtonTraerPanelBuscarPresup.setEnabled(true);
        
        jTextFieldIuPresupuesto.setEditable(false);
        jTextFieldFechaPresup.setEditable(true); 
        jTextFieldIuTipoPresupuesto.setEditable(true);
        jTextFieldDirigidoA.setEditable(true);
        jTextFieldCodModeloVeh.setEditable(true);
        jTextFieldPatenteVeh.setEditable(true);
        jTextFieldCodigoCristal.setEditable(true);
        jTextFieldIuMarcaCris.setEditable(true);
        jTextFieldIuServicios.setEditable(true);
        jTextFieldDescrPresup.setEditable(true);
        jTextFieldTotalPresup.setEditable(true);
            
        jButtonRegMarcaCristal.setEnabled(true);
        jButtonRegModeloVehiculo.setEnabled(true);
        jButtonRegServiciosPrestados.setEnabled(true);
        jButtonRegCatalogo.setEnabled(true);
            
        jListCodigoCrstal.setVisible(true);
        jListMarcasCristales.setVisible(true);
        jListServiciosPrestados.setVisible(true);
        jListModeloVeh.setVisible(true);
        
    }//GEN-LAST:event_jButtonAceptarElementoNoExistente1ActionPerformed

    private void jButtonAceptarElementoExistente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoExistente1ActionPerformed
        
        jPanelElementoExistentePresup.setBounds(-260, 100, 250, 100);
        jButtonAgregarPresupuesto.setEnabled(true);
        jButtonEditarPresupuesto.setEnabled(false);
        jButtonBorrarPresupuesto.setEnabled(false);
        jButtonTraerPanelBuscarPresup.setEnabled(true);
        
        jTextFieldIuPresupuesto.setEditable(false);
        jTextFieldFechaPresup.setEditable(true); 
        jTextFieldIuTipoPresupuesto.setEditable(true);
        jTextFieldDirigidoA.setEditable(true);
        jTextFieldCodModeloVeh.setEditable(true);
        jTextFieldPatenteVeh.setEditable(true);
        jTextFieldCodigoCristal.setEditable(true);
        jTextFieldIuMarcaCris.setEditable(true);
        jTextFieldIuServicios.setEditable(true);
        jTextFieldDescrPresup.setEditable(true);
        jTextFieldTotalPresup.setEditable(true);
            
        jButtonRegMarcaCristal.setEnabled(true);
        jButtonRegModeloVehiculo.setEnabled(true);
        jButtonRegServiciosPrestados.setEnabled(true);
        jButtonRegCatalogo.setEnabled(true);
            
        jListCodigoCrstal.setVisible(true);
        jListMarcasCristales.setVisible(true);
        jListServiciosPrestados.setVisible(true);
        jListModeloVeh.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarElementoExistente1ActionPerformed

    private void jButtonAceptarErrorBaseDeDatos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarErrorBaseDeDatos2ActionPerformed
        
        jPanelErrorBaseDeDatosPresup.setBounds(-260, 100, 250, 100);
        jButtonAgregarPresupuesto.setEnabled(true);
        jButtonEditarPresupuesto.setEnabled(false);
        jButtonBorrarPresupuesto.setEnabled(false);
        jButtonTraerPanelBuscarPresup.setEnabled(true);
        
        jTextFieldIuPresupuesto.setEditable(false);
        jTextFieldFechaPresup.setEditable(true); 
        jTextFieldIuTipoPresupuesto.setEditable(true);
        jTextFieldDirigidoA.setEditable(true);
        jTextFieldCodModeloVeh.setEditable(true);
        jTextFieldPatenteVeh.setEditable(true);
        jTextFieldCodigoCristal.setEditable(true);
        jTextFieldIuMarcaCris.setEditable(true);
        jTextFieldIuServicios.setEditable(true);
        jTextFieldDescrPresup.setEditable(true);
        jTextFieldTotalPresup.setEditable(true);
            
        jButtonRegMarcaCristal.setEnabled(true);
        jButtonRegModeloVehiculo.setEnabled(true);
        jButtonRegServiciosPrestados.setEnabled(true);
        jButtonRegCatalogo.setEnabled(true);
            
        jListCodigoCrstal.setVisible(true);
        jListMarcasCristales.setVisible(true);
        jListServiciosPrestados.setVisible(true);
        jListModeloVeh.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarErrorBaseDeDatos2ActionPerformed

    private void jButtonAceptarGuardadoErroneo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoErroneo1ActionPerformed
        
        switch(auxAbm){
            
            case 1:
                jPanelGuardadoErroneoPresup.setBounds(-260, 100, 250, 100);       
                jButtonAgregarPresupuesto.setEnabled(true);
                jButtonEditarPresupuesto.setEnabled(false);
                jButtonBorrarPresupuesto.setEnabled(false);
                jButtonTraerPanelBuscarPresup.setEnabled(true);
        
                jTextFieldIuPresupuesto.setEditable(false);
                jTextFieldFechaPresup.setEditable(true); 
                jTextFieldIuTipoPresupuesto.setEditable(true);
                jTextFieldDirigidoA.setEditable(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jTextFieldPatenteVeh.setEditable(true);
                jTextFieldCodigoCristal.setEditable(true);
                jTextFieldIuMarcaCris.setEditable(true);
                jTextFieldIuServicios.setEditable(true);
                jTextFieldDescrPresup.setEditable(true);
                jTextFieldTotalPresup.setEditable(true);
            
                jButtonRegMarcaCristal.setEnabled(true);
                jButtonRegModeloVehiculo.setEnabled(true);
                jButtonRegServiciosPrestados.setEnabled(true);
                jButtonRegCatalogo.setEnabled(true);
            
                jListCodigoCrstal.setVisible(true);
                jListMarcasCristales.setVisible(true);
                jListServiciosPrestados.setVisible(true);
                jListModeloVeh.setVisible(true);

            break;
        
            case 2:
                
                jPanelGuardadoErroneoPresup.setBounds(-260, 100, 250, 100);       
                jButtonAgregarPresupuesto.setEnabled(false);
                jButtonEditarPresupuesto.setEnabled(true);
                jButtonBorrarPresupuesto.setEnabled(false);
                jButtonTraerPanelBuscarPresup.setEnabled(true);
        
                jTextFieldIuPresupuesto.setEditable(false);
                jTextFieldFechaPresup.setEditable(false); 
                jTextFieldIuTipoPresupuesto.setEditable(false);
                jTextFieldDirigidoA.setEditable(false);
                jTextFieldCodModeloVeh.setEditable(true);
                jTextFieldPatenteVeh.setEditable(true);
                jTextFieldCodigoCristal.setEditable(true);
                jTextFieldIuMarcaCris.setEditable(true);
                jTextFieldIuServicios.setEditable(true);
                jTextFieldDescrPresup.setEditable(true);
                jTextFieldTotalPresup.setEditable(true);
            
                jButtonRegMarcaCristal.setEnabled(true);
                jButtonRegModeloVehiculo.setEnabled(true);
                jButtonRegServiciosPrestados.setEnabled(true);
                jButtonRegCatalogo.setEnabled(true);
            
                jListCodigoCrstal.setVisible(true);
                jListMarcasCristales.setVisible(true);
                jListServiciosPrestados.setVisible(true);
                jListModeloVeh.setVisible(true);;
            break;
            
            case 3:
                jPanelGuardadoErroneoPresup.setBounds(-260, 100, 250, 100);
                jButtonAgregarPresupuesto.setEnabled(false);
                jButtonEditarPresupuesto.setEnabled(false);
                jButtonBorrarPresupuesto.setEnabled(true);
                jButtonTraerPanelBuscarPresup.setEnabled(true);
        
                jTextFieldIuPresupuesto.setEditable(false);
                jTextFieldFechaPresup.setEditable(false); 
                jTextFieldIuTipoPresupuesto.setEditable(false);
                jTextFieldDirigidoA.setEditable(false);
                jTextFieldCodModeloVeh.setEditable(false);
                jTextFieldPatenteVeh.setEditable(false);
                jTextFieldCodigoCristal.setEditable(false);
                jTextFieldIuMarcaCris.setEditable(false);
                jTextFieldIuServicios.setEditable(false);
                jTextFieldDescrPresup.setEditable(false);
                jTextFieldTotalPresup.setEditable(false);
            
                jButtonRegMarcaCristal.setEnabled(false);
                jButtonRegModeloVehiculo.setEnabled(false);
                jButtonRegServiciosPrestados.setEnabled(false);
                jButtonRegCatalogo.setEnabled(false);
            break;
            
            default:
                jPanelGuardadoErroneoPresup.setBounds(-260, 100, 250, 100);
                break;
        
        }

    }//GEN-LAST:event_jButtonAceptarGuardadoErroneo1ActionPerformed

    private void jButtonAceptarGuardadoExitoso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoExitoso1ActionPerformed
                
        if(auxAbm!=3){
        
            if(jTextFieldIuPresupuesto.getText().length()!=0){
        
             _conectarSql = getConection();
            
            if(jTextFieldIuPresupuesto.getText().equalsIgnoreCase("AUTOMATICO")){
            
                try {

                String path = "C:/CondorGestion/reportes/Presupuestos.jrxml";
                
                JasperReport jr = JasperCompileManager.compileReport(path);
                
                 HashMap <String, Object> mapa = new HashMap <> ();
                 mapa = new HashMap<>();
                 mapa.put("iuPresup", Integer.parseInt( _administradorPresupuesto.obtenerUltimoId()));
                 
                JasperPrint jp = JasperFillManager.fillReport(jr, mapa, _conectarSql);
                JasperViewer viewer = new JasperViewer(jp, false);
                viewer.setTitle("Reporte de presupuesto");
                viewer.setVisible(true);

                } catch (JRException ex ) {
System.err.println(ex);
                JOptionPane.showMessageDialog(this, ex);
                }
            
            
            } else{
            
                try {

                String path = "C:/CondorGestion/reportes/Presupuestos.jrxml";
                
                JasperReport jr = JasperCompileManager.compileReport(path);
                
                 HashMap <String, Object> mapa = new HashMap <String, Object> ();
                 mapa = new HashMap<>();
                 mapa.put("iuPresup", Integer.parseInt(jTextFieldIuPresupuesto.getText()));

                 
                JasperPrint jp = JasperFillManager.fillReport(jr, mapa, _conectarSql);
                JasperViewer viewer = new JasperViewer(jp, false);
                viewer.setTitle("Reporte de presupuesto");
                viewer.setVisible(true);

                } catch (JRException ex ) {
                             System.err.println(ex);
                            JOptionPane.showMessageDialog(this, ex);
                }
            
            
            }

        }
        
        }
        
        jPanelGuardadoExitosoPresup.setBounds(-260, 100, 250, 100);   
                limpiarCamposPresup();
                
                jTextFieldIuPresupuesto.setBorder(null);
                jTextFieldFechaPresup.setBorder(null); 
                jTextFieldIuTipoPresupuesto.setBorder(null);
                jTextFieldDirigidoA.setBorder(null);
                jTextFieldCodModeloVeh.setBorder(null);
                jTextFieldPatenteVeh.setBorder(null);
                jTextFieldCodigoCristal.setBorder(null);
                jTextFieldIuMarcaCris.setBorder(null);
                jTextFieldIuServicios.setBorder(null);
                jTextFieldDescrPresup.setBorder(null);
                jTextFieldTotalPresup.setBorder(null);
                
                jButtonAgregarPresupuesto.setEnabled(true);
                jButtonEditarPresupuesto.setEnabled(false);
                jButtonBorrarPresupuesto.setEnabled(false);
                jButtonTraerPanelBuscarPresup.setEnabled(true);
        
                jTextFieldIuPresupuesto.setEditable(false);
                jTextFieldFechaPresup.setEditable(true); 
                jTextFieldIuTipoPresupuesto.setEditable(true);
                jTextFieldDirigidoA.setEditable(true);
                jTextFieldCodModeloVeh.setEditable(true);
                jTextFieldPatenteVeh.setEditable(true);
                jTextFieldCodigoCristal.setEditable(true);
                jTextFieldIuMarcaCris.setEditable(true);
                jTextFieldIuServicios.setEditable(true);
                jTextFieldDescrPresup.setEditable(true);
                jTextFieldTotalPresup.setEditable(true);
            
                jButtonRegMarcaCristal.setEnabled(true);
                jButtonRegModeloVehiculo.setEnabled(true);
                jButtonRegServiciosPrestados.setEnabled(true);
                jButtonRegCatalogo.setEnabled(true);
            
                jListCodigoCrstal.setVisible(true);
                jListMarcasCristales.setVisible(true);
                jListServiciosPrestados.setVisible(true);
                jListModeloVeh.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarGuardadoExitoso1ActionPerformed

    private void jButtonCancelarValidarCambios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarValidarCambios1ActionPerformed
        
        auxAbm = 0;
        limpiarCamposPresup();
        jPanelMensajeValidarABMPresup.setBounds(-260, 213, 250, 100);
        jButtonTraerPanelBuscarPresup.setEnabled(true);
       
        jTextFieldFechaCaja.setEnabled(true); 
        jTextFieldIuTipoPresupuesto.setEnabled(true);
        jTextFieldDirigidoA.setEnabled(true);
        jTextFieldCodModeloVeh.setEnabled(true);
        jTextFieldPatenteVeh.setEnabled(true);
        jTextFieldCodigoCristal.setEnabled(true);
        jTextFieldIuMarcaCris.setEnabled(true);
        jTextFieldIuServicios.setEnabled(true);
        jTextFieldDescrPresup.setEnabled(true);
        jTextFieldTotalPresup.setEnabled(true);
        
        jTextFieldFechaCaja.setBorder(null); 
        jTextFieldIuTipoPresupuesto.setBorder(null);
        jTextFieldDirigidoA.setBorder(null);
        jTextFieldCodModeloVeh.setBorder(null);
        jTextFieldPatenteVeh.setBorder(null);
        jTextFieldCodigoCristal.setBorder(null);
        jTextFieldIuMarcaCris.setBorder(null);
        jTextFieldIuServicios.setBorder(null);
        jTextFieldDescrPresup.setBorder(null);
        jTextFieldTotalPresup.setBorder(null);
        jTextFieldIuPresupuesto.setBorder(null);

    }//GEN-LAST:event_jButtonCancelarValidarCambios1ActionPerformed

    private void jButtonAceptarValidarCambios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarValidarCambios1ActionPerformed
        boolean[] listaVerdades = new boolean[10];
        int aux = 0;
        int auxMensaje2 = 0;
        int auxMensaje = 0;
                
// llama al panel y segun desde donde llamo ejecuta la accion        
        jPanelMensajeValidarABMPresup.setBounds(-260, 213, 250, 100);     
        switch(auxAbm){
            
            case 1:
                listaVerdades[0] = Administrador.validarFecha(jTextFieldFechaPresup.getText(), "\\d{1,2}-\\d{1,2}-\\d{4}" );
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldIuTipoPresupuesto.getText(), "[a-zA-Z_0-9]||[\\s]" );
                listaVerdades[2] = Administrador.validarCamposTextos(jTextFieldDirigidoA.getText(), "[a-zA-Z_0-9]||[\\s]" );
                validarCodModeloVeh();
                listaVerdades[3] = auxSeleccionList;
                listaVerdades[4] = Administrador.validarCamposTextos(jTextFieldPatenteVeh.getText(), "[a-zA-Z_0-9]||[-]" );
                validarCodigoCristal();
                listaVerdades[5] = auxSeleccionList3;
                validarIuMarcaCris();
                listaVerdades[6] = auxSeleccionList2;
                validarIuSevicios();
                listaVerdades[7] = auxSeleccionList;
                listaVerdades[8] = Administrador.validarCamposTextos(jTextFieldDescrPresup.getText(), "[a-zA-Z_0-9]||[\\s]" );
                
                String aux2 = jTextFieldTotalPresup.getText();
                listaVerdades[9] = Administrador.validarCamposDoubles(aux2);
                
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                }
                if(aux==10){
                    
                    jTextFieldFechaPresup.setBorder(new LineBorder(Color.green));
                    jTextFieldIuTipoPresupuesto.setBorder(new LineBorder(Color.green));
                    jTextFieldDirigidoA.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldPatenteVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.green));
                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.green));
                    jTextFieldIuServicios.setBorder(new LineBorder(Color.green));
                    jTextFieldDescrPresup.setBorder(new LineBorder(Color.green));
                    jTextFieldTotalPresup.setBorder(new LineBorder(Color.green));
                    jTextFieldIuPresupuesto.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    auxSeleccionList2 = false;
                    auxSeleccionList3 = false;
                    
                    _objPresup = new Presupuestos();
                    _objPresup.setFechaPresu(jTextFieldFechaPresup.getText());
                    _objPresup.setTipoPresu(jTextFieldIuTipoPresupuesto.getText());
                    _objPresup.setDirigidoA(jTextFieldDirigidoA.getText());
                    _objPresup.setCodModeloVeh(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()));
                    _objPresup.setPatenteVeh(jTextFieldPatenteVeh.getText());
                    _objPresup.setCodigoCristal(_administradorCatalogoCristales.obtenerCodigoCristal(jTextFieldCodigoCristal.getText()));
                    _objPresup.setIuMarcaCris(Integer.parseInt(_administradorMarcasCristales.obtenerIuMarcaCris(jTextFieldIuMarcaCris.getText())));
                    _objPresup.setIuServicios(Integer.parseInt(_administradorServiciosPrestados.obtenerIuServicio(jTextFieldIuServicios.getText())));
                    _objPresup.setDescrPresup(jTextFieldDescrPresup.getText());
                    _objPresup.setTotalPresu(Double.parseDouble(jTextFieldTotalPresup.getText()));

        
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorPresupuesto.insertarTablaPresupuesto(_objPresup)==true){
               
                           jPanelGuardadoExitosoPresup.setBounds(225, 213, 250, 100);
                    
                    } else{

                            jPanelElementoExistentePresup.setBounds(225, 213, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatosPresup.setBounds(225, 213, 250, 100);
    }
                
                
                } else{
                    for (int i = 0; i < listaVerdades.length; i++) {
                        switch(i){
                            
                            case 0:
                                if(listaVerdades[i]==true){
                                    jTextFieldFechaPresup.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldFechaPresup.setBorder(new LineBorder(Color.red));
                                }
                        break;
                            case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuTipoPresupuesto.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuTipoPresupuesto.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldDirigidoA.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDirigidoA.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                                    if(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 4:
                                if(listaVerdades[i]==true){
                                    jTextFieldPatenteVeh.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldPatenteVeh.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                        case 5:
                                if(listaVerdades[i]==true){
                                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.red));
                                    if(_administradorCatalogoCristales.obtenerCodigoCristal(jTextFieldCodigoCristal.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                        case 6:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.red));
                                    if(_administradorMarcasCristales.obtenerIuMarcaCris(jTextFieldIuMarcaCris.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                        case 7:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuServicios.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuServicios.setBorder(new LineBorder(Color.red));
                                    if(_administradorServiciosPrestados.obtenerIuServicio(jTextFieldIuServicios.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                        case 8:
                                if(listaVerdades[i]==true){
                                    jTextFieldDescrPresup.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDescrPresup.setBorder(new LineBorder(Color.red));
                                }
                        break;
                            case 9:
                                if(listaVerdades[i]==true){
                                    jTextFieldTotalPresup.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldTotalPresup.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                        }
                    }
                    if(auxMensaje==1) jPanelElementoNoExistentePresup.setBounds(225, 213, 250, 100);
                    if(auxMensaje2==1) jPanelGuardadoErroneoPresup.setBounds(225, 213, 250, 100);
                    
                }               
            break;
// se repite el mismo codigo solo que se edita un item de la db 
            case 2:
// se validan los datos
                listaVerdades[0] = Administrador.validarFecha(jTextFieldFechaPresup.getText(), "\\d{1,2}-\\d{1,2}-\\d{4}" );
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldIuTipoPresupuesto.getText(), "[a-zA-Z_0-9]||[\\s]" );
                listaVerdades[2] = Administrador.validarCamposTextos(jTextFieldDirigidoA.getText(), "[a-zA-Z_0-9]||[\\s]" );
                validarCodModeloVeh();
                listaVerdades[3] = auxSeleccionList;
                listaVerdades[4] = Administrador.validarCamposTextos(jTextFieldPatenteVeh.getText(), "[a-zA-Z_0-9]||[-]" );
                validarCodigoCristal();
                listaVerdades[5] = auxSeleccionList3;
                validarIuMarcaCris();
                listaVerdades[6] = auxSeleccionList2;
                validarIuSevicios();
                listaVerdades[7] = auxSeleccionList;
                listaVerdades[8] = Administrador.validarCamposTextos(jTextFieldDescrPresup.getText(), "[a-zA-Z_0-9]||[\\s]" );
                
                String aux3 = jTextFieldTotalPresup.getText();
                listaVerdades[9] = Administrador.validarCamposDoubles(aux3);
                
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==10){
                    
                    jTextFieldFechaPresup.setBorder(new LineBorder(Color.green)); 
                    jTextFieldIuTipoPresupuesto.setBorder(new LineBorder(Color.green));
                    jTextFieldDirigidoA.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldPatenteVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.green));
                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.green));
                    jTextFieldIuServicios.setBorder(new LineBorder(Color.green));
                    jTextFieldDescrPresup.setBorder(new LineBorder(Color.green));
                    jTextFieldTotalPresup.setBorder(new LineBorder(Color.green));
                    jTextFieldIuPresupuesto.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    auxSeleccionList2 = false;
                    auxSeleccionList3 = false;
                    
                    crearObjPresup();

// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorPresupuesto.actualizarTablaPresupuestos(_objPresup)==true){
               
                           jPanelGuardadoExitosoPresup.setBounds(225, 213, 250, 100);
                    
                    } else{

                            jPanelElementoExistentePresup.setBounds(225, 213, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatosPresup.setBounds(225, 213, 250, 100);
    }
                
                
                } else{
                    for (int i = 0; i < listaVerdades.length; i++) {
                        switch(i){
                            
                            case 0:
                                if(listaVerdades[i]==true){
                                    jTextFieldFechaPresup.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldFechaPresup.setBorder(new LineBorder(Color.red));
                                }
                        break;
                            case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuTipoPresupuesto.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuTipoPresupuesto.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldDirigidoA.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDirigidoA.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                                    if(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 4:
                                if(listaVerdades[i]==true){
                                    jTextFieldPatenteVeh.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldPatenteVeh.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                        case 5:
                                if(listaVerdades[i]==true){
                                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.red));
                                    if(_administradorCatalogoCristales.obtenerCodigoCristal(jTextFieldCodigoCristal.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                        case 6:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.red));
                                    if(_administradorMarcasCristales.obtenerIuMarcaCris(jTextFieldIuMarcaCris.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                        case 7:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuServicios.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuServicios.setBorder(new LineBorder(Color.red));
                                    if(_administradorServiciosPrestados.obtenerIuServicio(jTextFieldIuServicios.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                        case 8:
                                if(listaVerdades[i]==true){
                                    jTextFieldDescrPresup.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDescrPresup.setBorder(new LineBorder(Color.red));
                                }
                        break;
                            case 9:
                                if(listaVerdades[i]==true){
                                    jTextFieldTotalPresup.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldTotalPresup.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                        }
                    }
                    if(auxMensaje==1) jPanelElementoNoExistentePresup.setBounds(225, 213, 250, 100);
                    if(auxMensaje2==1) jPanelGuardadoErroneoPresup.setBounds(225, 213, 250, 100);
                    
                }                
            break;
// se repite el mismo codigo solo que se borra un item de la db         
            case 3:
// se validan los datos
                listaVerdades[0] = Administrador.validarFecha(jTextFieldFechaPresup.getText(), "\\d{1,2}-\\d{1,2}-\\d{4}" );
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldIuTipoPresupuesto.getText(), "[a-zA-Z_0-9]||[\\s]" );
                listaVerdades[2] = Administrador.validarCamposTextos(jTextFieldDirigidoA.getText(), "[a-zA-Z_0-9]||[\\s]" );
                validarCodModeloVeh();
                listaVerdades[3] = auxSeleccionList;
                listaVerdades[4] = Administrador.validarCamposTextos(jTextFieldPatenteVeh.getText(), "[a-zA-Z_0-9]||[-]" );
                validarCodigoCristal();
                listaVerdades[5] = auxSeleccionList3;
                validarIuMarcaCris();
                listaVerdades[6] = auxSeleccionList2;
                validarIuSevicios();
                listaVerdades[7] = auxSeleccionList;
                listaVerdades[8] = Administrador.validarCamposTextos(jTextFieldDescrPresup.getText(), "[a-zA-Z_0-9]||[\\s]" );
                
                String aux4 = jTextFieldTotalPresup.getText();
                listaVerdades[9] = Administrador.validarCamposDoubles(aux4);
                
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==10){
                    
                    jTextFieldFechaPresup.setBorder(new LineBorder(Color.green)); 
                    jTextFieldIuTipoPresupuesto.setBorder(new LineBorder(Color.green));
                    jTextFieldDirigidoA.setBorder(new LineBorder(Color.green));
                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldPatenteVeh.setBorder(new LineBorder(Color.green));
                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.green));
                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.green));
                    jTextFieldIuServicios.setBorder(new LineBorder(Color.green));
                    jTextFieldDescrPresup.setBorder(new LineBorder(Color.green));
                    jTextFieldTotalPresup.setBorder(new LineBorder(Color.green));
                    jTextFieldIuPresupuesto.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    auxSeleccionList2 = false;
                    auxSeleccionList3 = false;
                    
                    crearObjPresup();

        
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorPresupuesto.eliminarTablaPresupuestos(_objPresup)==true){
               
                           jPanelGuardadoExitosoPresup.setBounds(225, 213, 250, 100);
                    
                    } else{

                            jPanelElementoExistentePresup.setBounds(225, 213, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatosPresup.setBounds(225, 213, 250, 100);
    }
                
                
                } else{
                    for (int i = 0; i < listaVerdades.length; i++) {
                        switch(i){
                            
                            case 0:
                                if(listaVerdades[i]==true){
                                    jTextFieldFechaPresup.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldFechaPresup.setBorder(new LineBorder(Color.red));
                                }
                        break;
                            case 1:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuTipoPresupuesto.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuTipoPresupuesto.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldDirigidoA.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDirigidoA.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            case 3:
                                if(listaVerdades[i]==true){
                                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCodModeloVeh.setBorder(new LineBorder(Color.red));
                                    if(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                            case 4:
                                if(listaVerdades[i]==true){
                                    jTextFieldPatenteVeh.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldPatenteVeh.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                        case 5:
                                if(listaVerdades[i]==true){
                                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldCodigoCristal.setBorder(new LineBorder(Color.red));
                                    if(_administradorCatalogoCristales.obtenerCodigoCristal(jTextFieldCodigoCristal.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                        case 6:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuMarcaCris.setBorder(new LineBorder(Color.red));
                                    if(_administradorMarcasCristales.obtenerIuMarcaCris(jTextFieldIuMarcaCris.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                        case 7:
                                if(listaVerdades[i]==true){
                                    jTextFieldIuServicios.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldIuServicios.setBorder(new LineBorder(Color.red));
                                    if(_administradorServiciosPrestados.obtenerIuServicio(jTextFieldIuServicios.getText()).length()==0){
                        
                                        auxMensaje = 1;
                                    }
                                }
                        break;
                        case 8:
                                if(listaVerdades[i]==true){
                                    jTextFieldDescrPresup.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldDescrPresup.setBorder(new LineBorder(Color.red));
                                }
                        break;
                            case 9:
                                if(listaVerdades[i]==true){
                                    jTextFieldTotalPresup.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldTotalPresup.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                        }
                    }
                    if(auxMensaje==1) jPanelElementoNoExistentePresup.setBounds(225, 213, 250, 100);
                    if(auxMensaje2==1) jPanelGuardadoErroneoPresup.setBounds(225, 213, 250, 100);
                    
                }                
            break;   
        }
    }//GEN-LAST:event_jButtonAceptarValidarCambios1ActionPerformed

    private void jListMarcasCristalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListMarcasCristalesMouseClicked
        int indexList = jListMarcasCristales.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList2 = true;
            jTextFieldIuMarcaCris.setText("");
            jTextFieldIuMarcaCris.setText(jListMarcasCristales.getSelectedValue());
            jPanelListaIuMarcaCris.setBounds(-300, 290, 100, 50);
        } else{
            auxSeleccionList2 = false;
        }
    
    }//GEN-LAST:event_jListMarcasCristalesMouseClicked

    private void jListServiciosPrestadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListServiciosPrestadosMouseClicked
        int indexList = jListServiciosPrestados.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList2 = true;
            jTextFieldIuServicios.setText("");
            jTextFieldIuServicios.setText(jListServiciosPrestados.getSelectedValue());
            jPanelListaIuServicios.setBounds(-300, 297, 100, 50);
        } else{
            auxSeleccionList2 = false;
        }
    
    }//GEN-LAST:event_jListServiciosPrestadosMouseClicked

    private void jButtonAceptarGuardadoErroneo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoErroneo2ActionPerformed

        jPanelDatosErroneoCaja.setBounds(-260, 213, 250, 100);
        jButtonAgregarCaja.setEnabled(false);
        jButtonEditarCaja.setEnabled(false);
        jButtonBorrarCaja.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldIuCaja.setEditable(false);
        jTextFieldIuTipoCaja.setEditable(true);
        jTextFieldANombreDe.setEditable(true);
        jTextFieldDescrCaja.setEditable(true);
        jTextFieldFechaCaja.setEditable(true);
        jTextFieldFechaFactura.setEditable(true);
        jTextFieldNumFactura.setEditable(true);
        jTextFieldTotalCaja.setEditable(true);
        jButtonRegTipoCaja.setEnabled(true);
        jButtonRegTipoFactura.setEnabled(true);
        jButtonRegDetalleCaja.setEnabled(true);
        jListTipoCaja.setVisible(true);
        jListTipoFactura.setVisible(true);
        jButtonRegDetalleCaja.setEnabled(true);
        jButtonRegTipoCaja.setEnabled(true);
        jButtonRegTipoFactura.setEnabled(true);
        jPanelListaIuTipoCaja.setVisible(true);
        jPanelListaIuTipoFactura.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarGuardadoErroneo2ActionPerformed

    private void jButtonRegistroMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroMovimientosActionPerformed
        
        JFrameRegistroMovimientoSeguros obj = new JFrameRegistroMovimientoSeguros();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroMovimientosActionPerformed

    private void jButtonAceptarItemNoSeleccionado4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarItemNoSeleccionado4ActionPerformed
       
        jTablePresup.setEnabled(true);
        jPanelItemNoSeleccionadoPresup.setBounds(-260, 213, 250, 100);
    }//GEN-LAST:event_jButtonAceptarItemNoSeleccionado4ActionPerformed

    private void jTextFieldBuscarPresupKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarPresupKeyReleased
                boolean auxValidar = Administrador.validarCharDinamico(evt.getKeyChar(), "[a-zA-Z_0-9]||[\\s]");
    try {
        
        if(auxValidar==false){
               
            evt.consume();
            jTablePresup.setModel(_administradorPresupuesto.cargarJTabla());
               
        } else{
           
            jTablePresup.setModel(_administradorPresupuesto.buscarEnTabla(jTextFieldBuscarPresup.getText()));
           }
    } catch (Exception e) {
        
        jPanelErrorBaseDeDatosCaja.setBounds(225, 213, 250, 100);  
    } 
    }//GEN-LAST:event_jTextFieldBuscarPresupKeyReleased

    private void jButtonTraerPanelCuerpoPresupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelCuerpoPresupActionPerformed
        
        jPanelGlobalPresupuesto.setBounds(0, 65, 700, 525);
        jPanelVentanaBuscarPresup.setBounds( -1000,65,  700, 525);  
    }//GEN-LAST:event_jButtonTraerPanelCuerpoPresupActionPerformed

    private void jTextFieldIuServiciosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuServiciosFocusGained
            
        jListServiciosPrestados.setModel(_administradorServiciosPrestados.cargarLista(_administradorServiciosPrestados.obtenerIuServicio(jTextFieldIuServicios.getText())));
        jPanelListaIuServicios.setBounds(490, 297, 100, 50);
    }//GEN-LAST:event_jTextFieldIuServiciosFocusGained

    private void jTextFieldIuServiciosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuServiciosFocusLost
        
        jPanelListaIuServicios.setBounds(-300, 297, 100, 50);
    }//GEN-LAST:event_jTextFieldIuServiciosFocusLost

    private void jTextFieldIuServiciosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIuServiciosKeyReleased
        
        jListServiciosPrestados.setModel(_administradorServiciosPrestados.cargarLista(_administradorServiciosPrestados.obtenerIuServicio(jTextFieldIuServicios.getText())));
        jPanelListaIuServicios.setBounds(490, 297, 100, 50);
    }//GEN-LAST:event_jTextFieldIuServiciosKeyReleased

    private void jTextFieldIuMarcaCrisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuMarcaCrisFocusGained
                      
        jListMarcasCristales.setModel(_administradorMarcasCristales.cargarLista(_administradorMarcasCristales.obtenerIuMarcaCris(jTextFieldIuMarcaCris.getText())));
        jPanelListaIuMarcaCris.setBounds(290, 297, 100, 50);
    }//GEN-LAST:event_jTextFieldIuMarcaCrisFocusGained

    private void jTextFieldIuMarcaCrisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuMarcaCrisFocusLost
        
        jPanelListaIuMarcaCris.setBounds(-300, 297, 100, 50);
    }//GEN-LAST:event_jTextFieldIuMarcaCrisFocusLost

    private void jTextFieldIuMarcaCrisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIuMarcaCrisKeyReleased
        
                              
        jListMarcasCristales.setModel(_administradorMarcasCristales.cargarLista(_administradorMarcasCristales.obtenerIuMarcaCris(jTextFieldIuMarcaCris.getText())));
        jPanelListaIuMarcaCris.setBounds(290, 297, 100, 50);
    }//GEN-LAST:event_jTextFieldIuMarcaCrisKeyReleased

    private void jTextFieldCodigoCristalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodigoCristalFocusGained
        
        jListCodigoCrstal.setModel(_administradorCatalogoCristales.cargarListaCodigoCristal(_administradorCatalogoCristales.obtenerCodigoCristal(jTextFieldCodigoCristal.getText())));
        jPanelListaCodigoCristal.setBounds(80, 297, 100, 50);
    }//GEN-LAST:event_jTextFieldCodigoCristalFocusGained

    private void jTextFieldCodigoCristalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodigoCristalFocusLost
        
        jPanelListaCodigoCristal.setBounds(-300, 297, 100, 50);
    }//GEN-LAST:event_jTextFieldCodigoCristalFocusLost

    private void jTextFieldCodigoCristalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoCristalKeyReleased
        
        jListCodigoCrstal.setModel(_administradorCatalogoCristales.cargarListaCodigoCristal( _administradorCatalogoCristales.obtenerCodigoCristal(jTextFieldCodigoCristal.getText())));
        jPanelListaCodigoCristal.setBounds(80, 297, 100, 50);
    }//GEN-LAST:event_jTextFieldCodigoCristalKeyReleased

    private void jListMarcasCristalesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListMarcasCristalesFocusGained
        
        jPanelListaIuMarcaCris.setBounds(290, 297, 100, 50);
    }//GEN-LAST:event_jListMarcasCristalesFocusGained

    private void jListServiciosPrestadosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListServiciosPrestadosFocusGained
        
        jPanelListaIuServicios.setBounds(490, 297, 100, 50);
    }//GEN-LAST:event_jListServiciosPrestadosFocusGained

    private void jListModeloVehFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListModeloVehFocusGained
        
        jPanelListaCodModeloVeh.setBounds(150, 216, 200, 50);
    }//GEN-LAST:event_jListModeloVehFocusGained

    private void jListCodigoCrstalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListCodigoCrstalFocusGained
       
        jPanelListaCodigoCristal.setBounds(80, 297, 100, 50);
    }//GEN-LAST:event_jListCodigoCrstalFocusGained

    private void jButtonRegistroChequesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroChequesActionPerformed
        JFrameRegistroCheques obj = new JFrameRegistroCheques();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroChequesActionPerformed

    private void jListCarteraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListCarteraFocusGained
        
        jPanelListaIuCartera.setBounds(130, 241, 200, 50);
    }//GEN-LAST:event_jListCarteraFocusGained

    private void jListCarteraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListCarteraMouseClicked
        int indexList = jListCartera.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList2 = true;
            jTextFieldIuCartera.setText("");
            jTextFieldIuCartera.setText(jListCartera.getSelectedValue());
            jPanelListaIuCartera.setBounds(-1000, 241, 200, 50);
        } else{
            auxSeleccionList2 = false;
        }

    }//GEN-LAST:event_jListCarteraMouseClicked

    private void jListDominioVehFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListDominioVehFocusGained
        
        jPanelListaDominioVeh.setBounds(450, 241, 100, 50);
    }//GEN-LAST:event_jListDominioVehFocusGained

    private void jListDominioVehMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListDominioVehMouseClicked
        int indexList = jListDominioVeh.getSelectedIndex();
        if(indexList>=0){
            auxSeleccionList = true;
            jTextFieldDominioVeh.setText("");
            jTextFieldDominioVeh.setText(jListDominioVeh.getSelectedValue());
            jPanelListaDominioVeh.setBounds(-1000, 241, 100, 50);
        } else{
            auxSeleccionList = false;
        }

    }//GEN-LAST:event_jListDominioVehMouseClicked

    private void jButtonAceptarElementoNoExistente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoNoExistente2ActionPerformed
        switch(auxAbm){

            case 1:
                
            jPanelElementoNoExistenteExamen.setBounds(-260, 213, 250, 100);

            jButtonEditarExamen.setEnabled(false);
            jButtonBorrarExamen.setEnabled(false);
            jButtonAgregarExamen.setEnabled(true);
            jButtonTraerPanelBuscar1.setEnabled(true);
            
            jTextFieldNumExamenVeh.setEditable(false);
            jTextFieldFechaExamen.setEditable(false);
            jTextFieldNombExaminador.setEditable(true);
            jTextFieldIuCartera.setEditable(true);
            jTextFieldDominioVeh.setEditable(true);
            jTextFieldPosibleRetirador.setEditable(true);

            jButtonRegCartera.setEnabled(true);
            jButtonRegVehiculo.setEnabled(true);
            jListCartera.setVisible(true);
            jListDominioVeh.setVisible(true);
            break;

            case 2:
                
            jPanelElementoNoExistenteExamen.setBounds(-260, 213, 250, 100);

            jButtonEditarExamen.setEnabled(true);
            jButtonBorrarExamen.setEnabled(false);
            jButtonAgregarExamen.setEnabled(false);
            jButtonTraerPanelBuscar1.setEnabled(true);
            
            jTextFieldNumExamenVeh.setEditable(false);
            jTextFieldFechaExamen.setEditable(false);
            jTextFieldNombExaminador.setEditable(false);
            jTextFieldIuCartera.setEditable(true);
            jTextFieldDominioVeh.setEditable(true);
            jTextFieldPosibleRetirador.setEditable(true);

            jButtonRegCartera.setEnabled(true);
            jButtonRegVehiculo.setEnabled(true);
            jListCartera.setVisible(true);
            jListDominioVeh.setVisible(true);
            
            break;

            case 3:
                
            jPanelElementoNoExistenteExamen.setBounds(-260, 213, 250, 100);

            jButtonEditarExamen.setEnabled(false);
            jButtonBorrarExamen.setEnabled(true);
            jButtonAgregarExamen.setEnabled(false);
            jButtonTraerPanelBuscar1.setEnabled(true);
            
            jTextFieldNumExamenVeh.setEditable(false);
            jTextFieldFechaExamen.setEditable(false);
            jTextFieldNombExaminador.setEditable(false);
            jTextFieldIuCartera.setEditable(false);
            jTextFieldDominioVeh.setEditable(false);
            jTextFieldPosibleRetirador.setEditable(false);

            jButtonRegCartera.setEnabled(false);
            jButtonRegVehiculo.setEnabled(false);
            jListCartera.setVisible(false);
            jListDominioVeh.setVisible(false);
            break;
        }
    }//GEN-LAST:event_jButtonAceptarElementoNoExistente2ActionPerformed

    private void jButtonAceptarElementoExistente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarElementoExistente2ActionPerformed
        
        jPanelElementoExistenteExamen.setBounds(-260, 213, 250, 100);
        jButtonAgregarExamen.setEnabled(true);
        jButtonEditarExamen.setEnabled(false);
        jButtonBorrarExamen.setEnabled(false);
        jButtonTraerPanelBuscar1.setEnabled(true);
        jTextFieldNumExamenVeh.setEditable(false);
        jTextFieldFechaExamen.setEditable(false);
        jTextFieldNombExaminador.setEditable(true);
        jTextFieldIuCartera.setEditable(true);
        jTextFieldDominioVeh.setEditable(true);
        jTextFieldPosibleRetirador.setEditable(true);
        
        jButtonRegCartera.setEnabled(true);
        jButtonRegVehiculo.setEnabled(true);
        
        jListCartera.setVisible(true);
        jListDominioVeh.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarElementoExistente2ActionPerformed

    private void jButtonAceptarErrorBaseDeDatos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarErrorBaseDeDatos3ActionPerformed
        jPanelErrorBaseDeDatosExamen.setBounds(-260, 213, 250, 100);
        jButtonAgregarExamen.setEnabled(true);
        jButtonEditarExamen.setEnabled(false);
        jButtonBorrarExamen.setEnabled(false);
        jButtonTraerPanelBuscar1.setEnabled(true);
        jTextFieldNumExamenVeh.setEditable(false);
        jTextFieldFechaExamen.setEditable(false);
        jTextFieldNombExaminador.setEditable(true);
        jTextFieldIuCartera.setEditable(true);
        jTextFieldDominioVeh.setEditable(true);
        jTextFieldPosibleRetirador.setEditable(true);
        
        jButtonRegCartera.setEnabled(true);
        jButtonRegVehiculo.setEnabled(true);
        
        jListCartera.setVisible(true);
        jListDominioVeh.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarErrorBaseDeDatos3ActionPerformed

    private void jButtonAceptarGuardadoErroneo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoErroneo3ActionPerformed
         switch(auxAbm){

            case 1:
                
            jPanelGuardadoErroneoExamen.setBounds(-260, 213, 250, 100);

            jButtonEditarExamen.setEnabled(false);
            jButtonBorrarExamen.setEnabled(false);
            jButtonAgregarExamen.setEnabled(true);
            jButtonTraerPanelBuscar1.setEnabled(true);
            
            jTextFieldNumExamenVeh.setEditable(false);
            jTextFieldFechaExamen.setEditable(false);
            jTextFieldNombExaminador.setEditable(true);
            jTextFieldIuCartera.setEditable(true);
            jTextFieldDominioVeh.setEditable(true);
            jTextFieldPosibleRetirador.setEditable(true);

            jButtonRegCartera.setEnabled(true);
            jButtonRegVehiculo.setEnabled(true);
            jListCartera.setVisible(true);
            jListDominioVeh.setVisible(true);
            break;

            case 2:
                
            jPanelGuardadoErroneoExamen.setBounds(-260, 213, 250, 100);

            jButtonEditarExamen.setEnabled(true);
            jButtonBorrarExamen.setEnabled(false);
            jButtonAgregarExamen.setEnabled(false);
            jButtonTraerPanelBuscar1.setEnabled(true);
            
            jTextFieldNumExamenVeh.setEditable(false);
            jTextFieldFechaExamen.setEditable(false);
            jTextFieldNombExaminador.setEditable(false);
            jTextFieldIuCartera.setEditable(true);
            jTextFieldDominioVeh.setEditable(true);
            jTextFieldPosibleRetirador.setEditable(true);

            jButtonRegCartera.setEnabled(true);
            jButtonRegVehiculo.setEnabled(true);
            jListCartera.setVisible(true);
            jListDominioVeh.setVisible(true);
            
            break;

            case 3:
                
            jPanelGuardadoErroneoExamen.setBounds(-260, 213, 250, 100);

            jButtonEditarExamen.setEnabled(false);
            jButtonBorrarExamen.setEnabled(true);
            jButtonAgregarExamen.setEnabled(false);
            jButtonTraerPanelBuscar1.setEnabled(true);
            
            jTextFieldNumExamenVeh.setEditable(false);
            jTextFieldFechaExamen.setEditable(false);
            jTextFieldNombExaminador.setEditable(false);
            jTextFieldIuCartera.setEditable(false);
            jTextFieldDominioVeh.setEditable(false);
            jTextFieldPosibleRetirador.setEditable(false);

            jButtonRegCartera.setEnabled(false);
            jButtonRegVehiculo.setEnabled(false);
            jListCartera.setVisible(false);
            jListDominioVeh.setVisible(false);
            break;
            
            default:
                jPanelGuardadoErroneoPresup.setBounds(-260, 100, 250, 100);
            break;
        }
    }//GEN-LAST:event_jButtonAceptarGuardadoErroneo3ActionPerformed

    private void jButtonAceptarGuardadoExitoso2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarGuardadoExitoso2ActionPerformed

        if(auxAbm!=3){
        
                    if(jTextFieldNumExamenVeh.getText().length()!=0){
        
             _conectarSql = getConection();
            
            if(jTextFieldNumExamenVeh.getText().equalsIgnoreCase("AUTOMATICO")){
            
                try {

                String path = "C:/CondorGestion/reportes/Examenes.jrxml";
                
                JasperReport jr = JasperCompileManager.compileReport(path);
                
                 HashMap <String, Object> mapa = new HashMap <> ();
                 mapa = new HashMap<>();
                 mapa.put("numExamenVeh", Integer.parseInt( _administradorExamenVehiculo.obtenerUltimoId()));
                JasperPrint jp = JasperFillManager.fillReport(jr, mapa, _conectarSql);
                JasperViewer viewer = new JasperViewer(jp, false);
                viewer.setTitle("Reporte de Examen de vehiculo");
                viewer.setVisible(true);

                } catch (JRException ex ) {
                Logger.getLogger(JFrameRegistroGeneradorPedido.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println(ex);
                JOptionPane.showMessageDialog(this, ex);
                
                }
            
            
            } else{
            
                try {

                String path = "C:/CondorGestion/reportes/Examenes.jrxml";
                
                JasperReport jr = JasperCompileManager.compileReport(path);
                
                 HashMap <String, Object> mapa = new HashMap <> ();
                 mapa = new HashMap<>();
                 mapa.put("numExamenVeh", Integer.parseInt(jTextFieldNumExamenVeh.getText()));

                 
                JasperPrint jp = JasperFillManager.fillReport(jr, mapa, _conectarSql);
                JasperViewer viewer = new JasperViewer(jp, false);
                viewer.setTitle("Reporte de Examen de vehiculo");
                viewer.setVisible(true);

                } catch (JRException ex ) {
                Logger.getLogger(JFrameRegistroGeneradorPedido.class.getName()).log(Level.SEVERE, null, ex);
               System.err.println(ex);
                JOptionPane.showMessageDialog(this, ex);
                }
            
            
            }      
        
        }
        
        
        }
         

            jPanelGuardadoExitosoExamen.setBounds(-260, 213, 250, 100);

            limpiarCamposExamen();
          
            jTextFieldNumExamenVeh.setBorder(null);
            jTextFieldFechaExamen.setBorder(null);
            jTextFieldNombExaminador.setBorder(null);
            jTextFieldIuCartera.setBorder(null);
            jTextFieldDominioVeh.setBorder(null);
            jTextFieldPosibleRetirador.setBorder(null);
            
            jButtonEditarExamen.setEnabled(false);
            jButtonBorrarExamen.setEnabled(false);
            jButtonAgregarExamen.setEnabled(true);
            jButtonTraerPanelBuscar1.setEnabled(true);
            
            jTextFieldNumExamenVeh.setEditable(false);
            jTextFieldFechaExamen.setEditable(false);
            jTextFieldNombExaminador.setEditable(true);
            jTextFieldIuCartera.setEditable(true);
            jTextFieldDominioVeh.setEditable(true);
            jTextFieldPosibleRetirador.setEditable(true);

            jButtonRegCartera.setEnabled(true);
            jButtonRegVehiculo.setEnabled(true);
            jListCartera.setVisible(true);
            jListDominioVeh.setVisible(true);

    }//GEN-LAST:event_jButtonAceptarGuardadoExitoso2ActionPerformed

    private void jButtonCancelarValidarCambios2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarValidarCambios2ActionPerformed
        jPanelMensajeValidarABMExamen.setBounds(-260, 213, 250, 100);

            limpiarCamposExamen();
          
            jTextFieldNumExamenVeh.setBorder(null);
            jTextFieldFechaExamen.setBorder(null);
            jTextFieldNombExaminador.setBorder(null);
            jTextFieldIuCartera.setBorder(null);
            jTextFieldDominioVeh.setBorder(null);
            jTextFieldPosibleRetirador.setBorder(null);
            
            jButtonEditarExamen.setEnabled(false);
            jButtonBorrarExamen.setEnabled(false);
            jButtonAgregarExamen.setEnabled(true);
            jButtonTraerPanelBuscar1.setEnabled(true);
            
            jTextFieldNumExamenVeh.setEditable(false);
            jTextFieldFechaExamen.setEditable(false);
            jTextFieldNombExaminador.setEditable(true);
            jTextFieldIuCartera.setEditable(true);
            jTextFieldDominioVeh.setEditable(true);
            jTextFieldPosibleRetirador.setEditable(true);

            jButtonRegCartera.setEnabled(true);
            jButtonRegVehiculo.setEnabled(true);
            jListCartera.setVisible(true);
            jListDominioVeh.setVisible(true);
    }//GEN-LAST:event_jButtonCancelarValidarCambios2ActionPerformed

    private void jButtonAceptarValidarCambios2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarValidarCambios2ActionPerformed
        boolean[] listaVerdades = new boolean[4];
        int aux = 0;
        int auxMensaje2 = 0;
        int auxMensaje = 0;
                
// llama al panel y segun desde donde llamo ejecuta la accion        
        jPanelMensajeValidarABMExamen.setBounds(-260, 213, 250, 100);     
        switch(auxAbm){
            
            case 1:
                validarIuCartera();
                listaVerdades[0] = auxSeleccionList;
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldNombExaminador.getText(), "[a-zA-Z]||[\\s]" );
                listaVerdades[2] = Administrador.validarCamposTextos(jTextFieldPosibleRetirador.getText(), "[a-zA-Z]||[\\s]" );
                validarDominioVeh();
                listaVerdades[3] = auxSeleccionList2;
                
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==4){
                    
                    jTextFieldIuCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldPosibleRetirador.setBorder(new LineBorder(Color.green));
                    jTextFieldNombExaminador.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    auxSeleccionList2 = false;
                    
                    _objExamen = new ExamenVehiculo();
                    _objExamen.setIuCartera(_administradorCartera.obtenerIuCartera2(jTextFieldIuCartera.getText()));
                    _objExamen.setPosibleRetirador(jTextFieldPosibleRetirador.getText());
                    _objExamen.setNombExaminador(jTextFieldNombExaminador.getText());
                    _objExamen.setDominioVeh(_administradorVehiculos.obtenerDominioVeh(jTextFieldDominioVeh.getText()));
                    _objExamen.setFechaExamen(jTextFieldFechaExamen.getText());
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorExamenVehiculo.insertarTablaExamenVehiculo(_objExamen)==true){
               
                            jPanelGuardadoExitosoExamen.setBounds(225, 213, 250, 100);
                    
                    } else{

                            jPanelElementoExistenteExamen.setBounds(225, 213, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatosExamen.setBounds(225, 213, 250, 100);
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
                                    jTextFieldNombExaminador.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNombExaminador.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldPosibleRetirador.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldPosibleRetirador.setBorder(new LineBorder(Color.red));
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
                        }
                    }
                    if(auxMensaje==1) jPanelElementoNoExistenteExamen.setBounds(225, 213, 250, 100);
                    if(auxMensaje2==1) jPanelGuardadoErroneoExamen.setBounds(225, 213, 250, 100);
                    
                }               
            break;
// se repite el mismo codigo solo que se edita un item de la db 
            case 2:
// se validan los datos
                validarIuCartera();
                listaVerdades[0] = auxSeleccionList;
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldNombExaminador.getText(), "[a-zA-Z]||[\\s]" );
                listaVerdades[2] = Administrador.validarCamposTextos(jTextFieldPosibleRetirador.getText(), "[a-zA-Z]||[\\s]" );
                validarDominioVeh();
                listaVerdades[3] = auxSeleccionList2;
                
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==4){
                    
                    jTextFieldIuCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldPosibleRetirador.setBorder(new LineBorder(Color.green));
                    jTextFieldNombExaminador.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    auxSeleccionList2 = false;
                    
                   crearObjExamen();
        
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorExamenVehiculo.actualizarTablaExamenVehiculo(_objExamen)==true){
               
                            jPanelGuardadoExitosoExamen.setBounds(225, 213, 250, 100);
                    
                    } else{

                            jPanelElementoExistenteExamen.setBounds(225, 213, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatosExamen.setBounds(225, 213, 250, 100);
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
                                    jTextFieldNombExaminador.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNombExaminador.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldPosibleRetirador.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldPosibleRetirador.setBorder(new LineBorder(Color.red));
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
                        }
                    }
                    if(auxMensaje==1) jPanelElementoNoExistenteExamen.setBounds(225, 213, 250, 100);
                    if(auxMensaje2==1) jPanelGuardadoErroneoExamen.setBounds(225, 213, 250, 100);
                    
                }               
            break;
// se repite el mismo codigo solo que se borra un item de la db         
            case 3:
// se validan los datos
                validarIuCartera();
                listaVerdades[0] = auxSeleccionList;
                listaVerdades[1] = Administrador.validarCamposTextos(jTextFieldNombExaminador.getText(), "[a-zA-Z]||[\\s]" );
                listaVerdades[2] = Administrador.validarCamposTextos(jTextFieldPosibleRetirador.getText(), "[a-zA-Z]||[\\s]" );
                validarDominioVeh();
                listaVerdades[3] = auxSeleccionList2;
                
                for (int i = 0; i < listaVerdades.length; i++) {
                    if(listaVerdades[i]== true)aux++;
                    
                }
                if(aux==4){
                    
                    jTextFieldIuCartera.setBorder(new LineBorder(Color.green));
                    jTextFieldPosibleRetirador.setBorder(new LineBorder(Color.green));
                    jTextFieldNombExaminador.setBorder(new LineBorder(Color.green));
                    jTextFieldDominioVeh.setBorder(new LineBorder(Color.green));
                    auxSeleccionList = false;
                    auxSeleccionList2 = false;

                    crearObjExamen();
// se avisa en caso de estar apagada la db y si no se agrega un item a la db
    try {
                    if(_administradorExamenVehiculo.eliminarTablaExamenVehiculo(_objExamen)==true){
               
                            jPanelGuardadoExitosoExamen.setBounds(225, 213, 250, 100);
                    
                    } else{

                            jPanelElementoExistenteExamen.setBounds(225, 213, 250, 100);
                    }
    } catch (Exception e) {
                        jPanelErrorBaseDeDatosExamen.setBounds(225, 213, 250, 100);
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
                                    jTextFieldNombExaminador.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldNombExaminador.setBorder(new LineBorder(Color.red));
                                    auxMensaje2 = 1;
                                }
                        break;
                            
                            case 2:
                                if(listaVerdades[i]==true){
                                    jTextFieldPosibleRetirador.setBorder(new LineBorder(Color.green));
                                }else{
                                    jTextFieldPosibleRetirador.setBorder(new LineBorder(Color.red));
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
                        }
                    }
                    if(auxMensaje==1) jPanelElementoNoExistenteExamen.setBounds(225, 213, 250, 100);
                    if(auxMensaje2==1) jPanelGuardadoErroneoExamen.setBounds(225, 213, 250, 100);
                    
                }               
            break;   
        }
    }//GEN-LAST:event_jButtonAceptarValidarCambios2ActionPerformed

    private void jButtonRegVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegVehiculoActionPerformed
       JFrameRegistroVehiculos obj = new JFrameRegistroVehiculos();
       obj.setVisible(true);
       obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegVehiculoActionPerformed

    private void jTextFieldIuCarteraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuCarteraFocusGained
       
        jListCartera.setModel(_administradorCartera.cargarLista2(jTextFieldIuCartera.getText()));
        jPanelListaIuCartera.setBounds(130, 241, 200, 50);
    }//GEN-LAST:event_jTextFieldIuCarteraFocusGained

    private void jTextFieldIuCarteraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIuCarteraFocusLost
        
        jPanelListaIuCartera.setBounds(-1000, 241, 200, 50);
    }//GEN-LAST:event_jTextFieldIuCarteraFocusLost

    private void jTextFieldIuCarteraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIuCarteraKeyReleased
       
        jListCartera.setModel(_administradorCartera.cargarLista2(jTextFieldIuCartera.getText()));
        jPanelListaIuCartera.setBounds(130, 241, 200, 50);
    }//GEN-LAST:event_jTextFieldIuCarteraKeyReleased

    private void jButtonAgregarExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarExamenActionPerformed

        jTextFieldNombExaminador.setEditable(false);
        jTextFieldNumExamenVeh.setEditable(false);
        jTextFieldFechaExamen.setEditable(false);
        jTextFieldIuCartera.setEditable(false);
        jTextFieldDominioVeh.setEditable(false);
        jTextFieldPosibleRetirador.setEditable(false);
        jButtonRegCartera.setEnabled(false);
        jButtonRegVehiculo.setEnabled(false);
        jListCartera.setVisible(false);
        jListDominioVeh.setVisible(false);
        
        auxAbm = 1;
        jPanelMensajeValidarABMExamen.setBounds(225, 213, 250, 100);
    }//GEN-LAST:event_jButtonAgregarExamenActionPerformed

    private void jButtonEditarExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarExamenActionPerformed
        jTextFieldNombExaminador.setEditable(false);
        jTextFieldNumExamenVeh.setEditable(false);
        jTextFieldFechaExamen.setEditable(false);
        jTextFieldIuCartera.setEditable(false);
        jTextFieldDominioVeh.setEditable(false);
        jTextFieldPosibleRetirador.setEditable(false);
        jButtonRegCartera.setEnabled(false);
        jButtonRegVehiculo.setEnabled(false);
        jListCartera.setVisible(false);
        jListDominioVeh.setVisible(false);
        
        auxAbm = 2;
        jPanelMensajeValidarABMExamen.setBounds(225, 213, 250, 100);
    }//GEN-LAST:event_jButtonEditarExamenActionPerformed

    private void jButtonBorrarExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarExamenActionPerformed
        jTextFieldNombExaminador.setEditable(false);
        jTextFieldNumExamenVeh.setEditable(false);
        jTextFieldFechaExamen.setEditable(false);
        jTextFieldIuCartera.setEditable(false);
        jTextFieldDominioVeh.setEditable(false);
        jTextFieldPosibleRetirador.setEditable(false);
        jButtonRegCartera.setEnabled(false);
        jButtonRegVehiculo.setEnabled(false);
        jListCartera.setVisible(false);
        jListDominioVeh.setVisible(false);
        
        auxAbm = 3;
        jPanelMensajeValidarABMExamen.setBounds(225, 213, 250, 100);
    }//GEN-LAST:event_jButtonBorrarExamenActionPerformed

    private void jButtonTraerPanelBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelBuscar1ActionPerformed
                // llama al panel buscar
        try {
            jTableExamen.setModel(_administradorExamenVehiculo.cargarJTabla());
        } catch (Exception e) {
            jPanelErrorBaseDeDatosExamen.setBounds(225, 213, 250, 100);
        }
        
        jPanelGlobalExamenes.setBounds(-700, 65, 700, 525);
        jPanelVentanaBuscarExamen.setBounds( 0,65,  700, 525);
        jPanelVentanaBuscarExamen.repaint();
    }//GEN-LAST:event_jButtonTraerPanelBuscar1ActionPerformed

    private void jButtonRegCarteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegCarteraActionPerformed
       JFrameRegistroCartera obj = new JFrameRegistroCartera();
       obj.setVisible(true);
       obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegCarteraActionPerformed

    private void jButtonAceptarItemNoSeleccionado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarItemNoSeleccionado3ActionPerformed
        
        jTableExamen.setEnabled(true);
        jPanelItemNoSeleccionadoExamen.setBounds(-260, 213, 250, 100);
    }//GEN-LAST:event_jButtonAceptarItemNoSeleccionado3ActionPerformed

    private void jTextFieldBuscarExamenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarExamenKeyReleased
               boolean auxValidar = Administrador.validarCharDinamico(evt.getKeyChar(), "[a-zA-Z_0-9]||[\\s]");
        try {

            if(auxValidar==false){

                evt.consume();
                jTableExamen.setModel(_administradorExamenVehiculo.buscarEnTabla(jTextFieldBuscarExamen.getText()));

            } else{

                jTableExamen.setModel(_administradorExamenVehiculo.buscarEnTabla(jTextFieldBuscarExamen.getText()));
            }
        } catch (Exception e) {

            jPanelErrorBaseDeDatosExamen.setBounds(225, 213, 250, 100);
        }
    }//GEN-LAST:event_jTextFieldBuscarExamenKeyReleased

    private void jButtonTraerPanelCuerpo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraerPanelCuerpo1ActionPerformed
//llama al panel contenedor del abm
        jPanelVentanaBuscarExamen.setBounds(-700, 65, 700, 525);
        jPanelGlobalExamenes.setBounds( 0,65,  700, 525);
    }//GEN-LAST:event_jButtonTraerPanelCuerpo1ActionPerformed

    private void jTextFieldDominioVehFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDominioVehFocusLost
       
        jPanelListaDominioVeh.setBounds(-1000, 241, 100, 50);
    }//GEN-LAST:event_jTextFieldDominioVehFocusLost

    private void jTextFieldDominioVehFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDominioVehFocusGained

        jListDominioVeh.setModel(_administradorVehiculos.cargarLista(jTextFieldDominioVeh.getText()));
        jPanelListaDominioVeh.setBounds(450, 241, 100, 50);
    }//GEN-LAST:event_jTextFieldDominioVehFocusGained

    private void jTextFieldDominioVehKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDominioVehKeyReleased

        jListDominioVeh.setModel(_administradorVehiculos.cargarLista(jTextFieldDominioVeh.getText()));
        jPanelListaDominioVeh.setBounds(450, 241, 100, 50);
    }//GEN-LAST:event_jTextFieldDominioVehKeyReleased

    private void jButtonRegistroMovStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroMovStockActionPerformed
        
        _conectarSql = getConection();
             
            try {
                
                
              _conectarSql = getConection();  
                String path = "C:/CondorGestion/reportes/SinStock.jrxml";
               
                JasperReport jr = JasperCompileManager.compileReport(path);
   
                JasperPrint jp = JasperFillManager.fillReport(jr, null, _conectarSql);
                JasperViewer viewer = new JasperViewer(jp, false);
                viewer.setTitle("Reporte de Stock");
                viewer.setVisible(true);

            } catch (JRException ex ) {
                System.err.println(ex);
                JOptionPane.showMessageDialog(this, ex);
            }
    }//GEN-LAST:event_jButtonRegistroMovStockActionPerformed

    private void jButtonRegistroInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroInformesActionPerformed
       JFrameRegistroGeneradorInformeVentas obj = new JFrameRegistroGeneradorInformeVentas();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonRegistroInformesActionPerformed

    private void jButtonMenuMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuMovimientosActionPerformed
        jPanelMenuDesplegableMovimientos.setBounds(-260, 28, 250, 75); 
        
    }//GEN-LAST:event_jButtonMenuMovimientosActionPerformed

    private void jButtonMenuInformesMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuInformesMouseDragged
        jPanelMenuDesplegableInformes.setBounds(730, 28, 250, 75); 
    }//GEN-LAST:event_jButtonMenuInformesMouseDragged

    private void jButtonMenuInformesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuInformesMouseEntered
        jPanelMenuDesplegableInformes.setBounds(730, 28, 250, 75); 
        jPanelMenuDesplegableMovimientos.setBounds(-260, 28, 250, 50); 
        jPanelMenuDesplegableCaja.setBounds(-260, 28, 250, 50);
        jPanelMenuDesplegableCartera.setBounds(-260, 28, 250, 50);
        jPanelMenuDesplegableCatalogo.setBounds(-260, 28, 250, 50);
        jPanelMenuDesplegableVehiculo.setBounds(-260, 28, 250, 50);
    }//GEN-LAST:event_jButtonMenuInformesMouseEntered

    private void jButtonMenuInformesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenuInformesMouseExited
        jPanelMenuDesplegableMovimientos.setBounds(-260, 28, 250, 50); 
        jPanelMenuDesplegableCaja.setBounds(-260, 28, 250, 50);
        jPanelMenuDesplegableCartera.setBounds(-260, 28, 250, 50);
        jPanelMenuDesplegableCatalogo.setBounds(-260, 28, 250, 50);
        jPanelMenuDesplegableVehiculo.setBounds(-260, 28, 250, 50);
    }//GEN-LAST:event_jButtonMenuInformesMouseExited

    private void jButtonMenuInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuInformesActionPerformed
        jPanelMenuDesplegableInformes.setBounds(-260, 28, 250, 75); 
    }//GEN-LAST:event_jButtonMenuInformesActionPerformed

    private void jButtonMenuCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuCatalogoActionPerformed
        jPanelMenuDesplegableCatalogo.setBounds(-260, 28, 250, 75); 
    }//GEN-LAST:event_jButtonMenuCatalogoActionPerformed

    private void jButtonMenuVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuVehiculoActionPerformed
        jPanelMenuDesplegableVehiculo.setBounds(-260, 28, 250, 75);
    }//GEN-LAST:event_jButtonMenuVehiculoActionPerformed

    private void jButtonRegistroMovStock1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroMovStock1ActionPerformed
        
        _conectarSql = getConection();
             
            try {
                
                
             _conectarSql = getConection();   
                String path = "C:/CondorGestion/reportes/SobreStock.jrxml";
                
                JasperReport jr = JasperCompileManager.compileReport(path);                
                JasperPrint jp = JasperFillManager.fillReport(jr, null, _conectarSql);
                JasperViewer viewer = new JasperViewer(jp, false);
                viewer.setTitle("Reporte de Stock");
                viewer.setVisible(true);

            } catch (JRException ex ) {
                JOptionPane.showMessageDialog(null, ex);
                System.out.println(ex);
            }
    }//GEN-LAST:event_jButtonRegistroMovStock1ActionPerformed

    private void jButtonAceptarErrorBaseDeDatos4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarErrorBaseDeDatos4ActionPerformed
        
        jPanelErrorBaseDeDatosCaja1.setBounds(-260, 213, 250, 100);
        jButtonAgregarCaja.setEnabled(false);
        jButtonEditarCaja.setEnabled(false);
        jButtonBorrarCaja.setEnabled(false);
        jButtonTraerPanelBuscar.setEnabled(true);
        jTextFieldIuCaja.setEditable(false);
        jTextFieldIuTipoCaja.setEditable(true);
        jTextFieldANombreDe.setEditable(true);
        jTextFieldDescrCaja.setEditable(true);
        jTextFieldFechaCaja.setEditable(true);
        jTextFieldFechaFactura.setEditable(true);
        jTextFieldNumFactura.setEditable(true);
        jTextFieldTotalCaja.setEditable(true);
        jButtonRegTipoCaja.setEnabled(true);
        jButtonRegTipoFactura.setEnabled(true);
        jButtonRegDetalleCaja.setEnabled(true);
        jListTipoCaja.setVisible(true);
        jListTipoFactura.setVisible(true);
        jPanelListaIuTipoCaja.setVisible(true);
        jPanelListaIuTipoFactura.setVisible(true);
    }//GEN-LAST:event_jButtonAceptarErrorBaseDeDatos4ActionPerformed

// carga lista de detalleCaja    
Runnable runnable = new Runnable() {
  @Override
  public void run() {
    // Esto se ejecuta en segundo plano una única vez
    while (true) {
      // Pero usamos un truco y hacemos un ciclo infinito
      try {
        // En él, hacemos que el hilo duerma
        Thread.sleep(5000);

          cargarTurnosTotal(_administrador.obtenerFechaMaquina());
      } catch (InterruptedException e) {
      }
    }
  }
};

Runnable runnable2 = new Runnable() {
  @Override
  public void run() {
    // Esto se ejecuta en segundo plano una única vez
    while (true) {
      // Pero usamos un truco y hacemos un ciclo infinito
      try {
        // En él, hacemos que el hilo duerma
        Thread.sleep(5000);
        
         cargaListaDetalleCaja(1, jTextFieldIuCaja.getText());  
      } catch (InterruptedException e) {
      }
    }
  }
};
    
    public void cargarTurnosTotal( String buscar){

        int y = 0;
        
        ArrayList copiaArray =  _administradorTurnos.cargarListaHoy(buscar);
        int aux = copiaArray.size();
        DefaultListModel modelo = new DefaultListModel();
        modelo.clear();
        
        for (int i = 0; i < aux; i++) {
            modelo.addElement(copiaArray.get(i));  
        }
        
        jList1.setModel(modelo);
       
    }
    
// limpia los jtextfield usados
    public void limpiarCamposCaja(){

        jTextFieldIuCaja.setText("AUTOMATICO");
        jTextFieldIuTipoCaja.setText(""); 
        jTextFieldIuTipoFactura.setText("");
        jTextFieldANombreDe.setText("");
        jTextFieldDescrCaja.setText("");
        jTextFieldFechaCaja.setText("");
        jTextFieldFechaFactura.setText("");
        jTextFieldNumFactura.setText("");
        jTextFieldTotalCaja.setText("");
        }
    
// limpia los jtextfield usados
    public void limpiarCamposExamen(){

        jTextFieldNumExamenVeh.setText("AUTOMATICO");
        jTextFieldFechaExamen.setText(_administrador.obtenerFechaMaquina()); 
        jTextFieldNombExaminador.setText("");
        jTextFieldIuCartera.setText("");
        jTextFieldDominioVeh.setText("");
        jTextFieldPosibleRetirador.setText("");
        }
    
// limpia los jtextfield usados
    public void limpiarCamposPresup(){

        jTextFieldIuPresupuesto.setText("AUTOMATICO");
        jTextFieldFechaPresup.setText(""); 
        jTextFieldIuTipoPresupuesto.setText("");
        jTextFieldDirigidoA.setText("");
        jTextFieldCodModeloVeh.setText("");
        jTextFieldPatenteVeh.setText("");
        jTextFieldCodigoCristal.setText("");
        jTextFieldIuMarcaCris.setText("");
        jTextFieldIuServicios.setText("");
        jTextFieldDescrPresup.setText("");
        jTextFieldTotalPresup.setText("");
        }

// valida codModeloVeh en caso de no hacer cick en a lista
    public void validarIuTipoCaja(){
        auxSeleccionList = _administradorTipoCaja.obtenerIuTipoCaja(jTextFieldIuTipoCaja.getText()).length() != 0;
    }
   
// valida codModeloVeh en caso de no hacer cick en a lista
    public void validarIuCartera(){
        auxSeleccionList = _administradorCartera.obtenerIuCartera2(jTextFieldIuCartera.getText()) != 0;
    }
    
// valida codModeloVeh en caso de no hacer cick en a lista
    public void validarCodModeloVeh(){
        auxSeleccionList = _administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()).length() != 0;
    }
    
// valida codModeloVeh en caso de no hacer cick en a lista
    public void validarIuMarcaCris(){
        auxSeleccionList2 = _administradorMarcasCristales.obtenerIuMarcaCris(jTextFieldIuMarcaCris.getText()).length() != 0;
    }
    
// valida codModeloVeh en caso de no hacer cick en a lista
    public void validarCodigoCristal(){
        auxSeleccionList3 = _administradorCatalogoCristales.obtenerCodigoCristal(jTextFieldCodigoCristal.getText()).length() != 0;
    }
    
// valida codModeloVeh en caso de no hacer cick en a lista
    public void validarDominioVeh(){
        auxSeleccionList2 = _administradorVehiculos.obtenerDominioVeh(jTextFieldDominioVeh.getText()).length() != 0;
    }
    
// valida codModeloVeh en caso de no hacer cick en a lista
    public void validarIuTipoFactura(){
        auxSeleccionList = _administradorTipoFactura.obtenerIuTipoFactura(jTextFieldIuTipoFactura.getText()).length() != 0;
    }

// valida codModeloVeh en caso de no hacer cick en a lista
    public void validarIuSevicios(){
        auxSeleccionList = _administradorServiciosPrestados.obtenerIuServicio(jTextFieldIuServicios.getText()).length() != 0;
    }     
    
// se crea un objeto de la clase utilizada    
    public void crearObjCaja(){
     
        _objCaja = new Caja();
        _objCaja.setIuCaja(Integer.parseInt(iuCaja));
        _objCaja.setIuTipoCaja(Integer.parseInt(_administradorTipoCaja.obtenerIuTipoCaja(jTextFieldIuTipoCaja.getText())));
        _objCaja.setFechaCaja(jTextFieldFechaCaja.getText());
        _objCaja.setIuTipoFactura(Integer.parseInt(_administradorTipoFactura.obtenerIuTipoFactura(jTextFieldIuTipoFactura.getText())));
        _objCaja.setFechaFactura(jTextFieldFechaFactura.getText());
        _objCaja.setANombreDe(jTextFieldANombreDe.getText());
        _objCaja.setDescrCaja(jTextFieldDescrCaja.getText());
        _objCaja.setNumFactura(Integer.parseInt(jTextFieldNumFactura.getText()));
        _objCaja.setTotalCaja(Double.parseDouble(jTextFieldTotalCaja.getText()));
     }
    
// se crea un objeto de la clase utilizada    
    public void crearObjExamen(){
     
        _objExamen = new ExamenVehiculo();
        _objExamen.setNumExamenVeh(Integer.parseInt(jTextFieldNumExamenVeh.getText()));
        _objExamen.setFechaExamen(jTextFieldFechaExamen.getText());
        _objExamen.setIuCartera(_administradorCartera.obtenerIuCartera2(jTextFieldIuCartera.getText()));
        _objExamen.setDominioVeh(jTextFieldDominioVeh.getText());
        _objExamen.setPosibleRetirador(jTextFieldPosibleRetirador.getText());
        _objExamen.setNombExaminador(jTextFieldNombExaminador.getText());
     }
    
// se crea un objeto de la clase utilizada    
    public void crearObjPresup(){
     
        _objPresup = new Presupuestos();
        _objPresup.setIuPresupuesto(Integer.parseInt(jTextFieldIuPresupuesto.getText()));
        _objPresup.setFechaPresu(jTextFieldFechaPresup.getText());
        _objPresup.setTipoPresu(jTextFieldIuTipoPresupuesto.getText());
        _objPresup.setDirigidoA(jTextFieldDirigidoA.getText());
        _objPresup.setCodModeloVeh(_administradorModeloVehiculo.obtenerCodModeloVeh(jTextFieldCodModeloVeh.getText()));
        _objPresup.setPatenteVeh(jTextFieldPatenteVeh.getText());
        _objPresup.setCodigoCristal(_administradorCatalogoCristales.obtenerCodigoCristal(jTextFieldCodigoCristal.getText()));
        _objPresup.setIuMarcaCris(Integer.parseInt(_administradorMarcasCristales.obtenerIuMarcaCris(jTextFieldIuMarcaCris.getText())));
        _objPresup.setIuServicios(Integer.parseInt(_administradorServiciosPrestados.obtenerIuServicio(jTextFieldIuServicios.getText())));
        _objPresup.setDescrPresup(jTextFieldDescrPresup.getText());
        _objPresup.setTotalPresu(Double.parseDouble(jTextFieldTotalPresup.getText()));
     }

// este metodo crea menu de opciones al usar click secundario   
    public final void popupMenuJTableCaja(){
//se crean las opciones del menu
        JPopupMenu jPopupMenuTableHC = new JPopupMenu();
        JMenuItem jMenuItemEliminarCaja = new JMenuItem("Eliminar"); // cambiar x ico 
        JMenuItem jMenuItemModificarCaja = new JMenuItem("Modificar");
        JMenuItem jMenuOrdenar = new JMenu("Ordenar por");
        JMenuItem jMenuItemPrimerosAgregados = new JMenuItem("Primeros agregados");
        JMenuItem jMenuItemUltimosAgregados= new JMenuItem("Ultimos agregados"); 
        jMenuOrdenar.add(jMenuItemPrimerosAgregados);
        jMenuOrdenar.add(jMenuItemUltimosAgregados); 
        
// se generan las acciones de cada opcion
        jMenuItemEliminarCaja.addActionListener((ActionEvent e) -> {
        
        if(seleccionarItemJTablaCaja()!= -1){
        
            cargaListaDetalleCaja(1, jTextFieldIuCaja.getText());
            jTextFieldIuTipoCaja.setBorder(null);
            jTextFieldFechaCaja.setBorder(null);
            jTextFieldIuTipoFactura.setBorder(null);
            jTextFieldFechaFactura.setBorder(null);
            jTextFieldNumFactura.setBorder(null);
            jTextFieldANombreDe.setBorder(null);
            jTextFieldDescrCaja.setBorder(null);
            jTextFieldTotalCaja.setBorder(null);
        
            jPanelVentanaBuscarCaja.setBounds(-700, 65, 700, 525);
            jPanelGlobalCaja.setBounds(0, 65, 700, 525);
            
            auxAbm = 3;
            
            jButtonAgregarCaja.setEnabled(false);
            jButtonEditarCaja.setEnabled(false);
            jButtonBorrarCaja.setEnabled(true);
            
            jButtonTraerPanelBuscar.setEnabled(true);
            jTextFieldIuTipoCaja.setEditable(false);
            jTextFieldANombreDe.setEditable(false);
            jTextFieldDescrCaja.setEditable(false);
            jTextFieldFechaCaja.setEditable(false);
            jTextFieldFechaFactura.setEditable(false);
            jTextFieldIuCaja.setEditable(false);
            jTextFieldIuTipoFactura.setEditable(false);
            jTextFieldNumFactura.setEditable(false);
            jTextFieldTotalCaja.setEditable(false);
            jListTipoCaja.setVisible(false);
            jListTipoFactura.setVisible(false);
            jButtonRegDetalleCaja.setEnabled(false);
            jButtonRegTipoCaja.setEnabled(false);
            jButtonRegTipoFactura.setEnabled(false);  
        
             }
         });
         
        jMenuItemModificarCaja.addActionListener((ActionEvent e) -> {
            
        if(seleccionarItemJTablaCaja()!= -1){
            
            cargaListaDetalleCaja(1, jTextFieldIuCaja.getText());
            jTextFieldIuTipoCaja.setBorder(null);
            jTextFieldFechaCaja.setBorder(null);
            jTextFieldIuTipoFactura.setBorder(null);
            jTextFieldFechaFactura.setBorder(null);
            jTextFieldNumFactura.setBorder(null);
            jTextFieldANombreDe.setBorder(null);
            jTextFieldDescrCaja.setBorder(null);
            jTextFieldTotalCaja.setBorder(null);
            
            jPanelVentanaBuscarCaja.setBounds(-700, 65, 700, 525);
            jPanelGlobalCaja.setBounds( 0, 65, 700, 525);
            jButtonTraerPanelBuscar.setEnabled(true);
            
            auxAbm = 2 ;
            
            jButtonAgregarCaja.setEnabled(false);
            jButtonBorrarCaja.setEnabled(false);
            jButtonEditarCaja.setEnabled(true);
            jButtonTraerPanelBuscar.setEnabled(true);
            jTextFieldIuTipoCaja.setEditable(true);
            jTextFieldANombreDe.setEditable(true);
            jTextFieldDescrCaja.setEditable(true);
            jTextFieldFechaCaja.setEditable(true);
            jTextFieldFechaFactura.setEditable(true);
            jTextFieldIuCaja.setEditable(false);
            jTextFieldIuTipoFactura.setEditable(true);
            jTextFieldNumFactura.setEditable(true);
            jTextFieldTotalCaja.setEditable(true);
            jListTipoCaja.setVisible(true);
            jListTipoFactura.setVisible(true);
            jButtonRegDetalleCaja.setEnabled(true);
            jButtonRegTipoCaja.setEnabled(true);
   
        }
        });
             
        jMenuItemUltimosAgregados.addActionListener((ActionEvent e) -> {
            _administradorCaja.ordenarTabla(jMenuItemUltimosAgregados.getText());
            jTableCaja.setModel( _administradorCaja.cargarJTabla());
        });
                          
        jMenuItemPrimerosAgregados.addActionListener((ActionEvent e) -> {
            _administradorCaja.ordenarTabla(jMenuItemPrimerosAgregados.getText());
            jTableCaja.setModel( _administradorCaja.cargarJTabla());
        });
// se construye el menu completo y se le asigna si jTable
        jPopupMenuTableHC.add(jMenuItemEliminarCaja);
        jPopupMenuTableHC.add(jMenuItemModificarCaja);
        jPopupMenuTableHC.add(jMenuOrdenar);
        jTableCaja.setComponentPopupMenu(jPopupMenuTableHC);  
     }
    
// este metodo crea menu de opciones al usar click secundario   
    public final void popupMenuJTableExamen(){
//se crean las opciones del menu
        JPopupMenu jPopupMenuTableHE = new JPopupMenu();
        JMenuItem jMenuItemEliminarExamen = new JMenuItem("Eliminar"); // cambiar x ico 
        JMenuItem jMenuItemModificarExamen = new JMenuItem("Modificar");
        JMenuItem jMenuOrdenar = new JMenu("Ordenar por");
        JMenuItem jMenuItemPrimerosAgregados = new JMenuItem("Primeros agregados");
        JMenuItem jMenuItemUltimosAgregados= new JMenuItem("Ultimos agregados"); 
        jMenuOrdenar.add(jMenuItemPrimerosAgregados);
        jMenuOrdenar.add(jMenuItemUltimosAgregados); 
        
// se generan las acciones de cada opcion
        jMenuItemEliminarExamen.addActionListener((ActionEvent e) -> {
        
        if(seleccionarItemJTablaExamen()!= -1){

            jTextFieldNumExamenVeh.setBorder(null);
            jTextFieldFechaExamen.setBorder(null);
            jTextFieldNumExamenVeh.setBorder(null);
            jTextFieldIuCartera.setBorder(null);
            jTextFieldDominioVeh.setBorder(null);
            jTextFieldPosibleRetirador.setBorder(null);

            jPanelVentanaBuscarExamen.setBounds(-700, 65, 700, 525);
            jPanelGlobalExamenes.setBounds(0, 65, 700, 525);
            
            auxAbm = 3;
            
            jButtonAgregarExamen.setEnabled(false);
            jButtonEditarExamen.setEnabled(false);
            jButtonBorrarExamen.setEnabled(true);
            
            jButtonTraerPanelBuscar1.setEnabled(true);
            jTextFieldNumExamenVeh.setEditable(false);
            jTextFieldNombExaminador.setEditable(false);
            jTextFieldFechaExamen.setEditable(false);
            jTextFieldIuCartera.setEditable(false);
            jTextFieldDominioVeh.setEditable(false);
            jTextFieldPosibleRetirador.setEditable(false);
            
            jListCartera.setVisible(false);
            jListDominioVeh.setVisible(false);
            jButtonRegCartera.setEnabled(false);
            jButtonRegVehiculo.setEnabled(false);
        
             }
         });
         
        jMenuItemModificarExamen.addActionListener((ActionEvent e) -> {
            
        if(seleccionarItemJTablaExamen()!= -1){

            jTextFieldNumExamenVeh.setBorder(null);
            jTextFieldFechaExamen.setBorder(null);
            jTextFieldNumExamenVeh.setBorder(null);
            jTextFieldIuCartera.setBorder(null);
            jTextFieldDominioVeh.setBorder(null);
            jTextFieldPosibleRetirador.setBorder(null);
            
            jPanelVentanaBuscarExamen.setBounds(-700, 65, 700, 525);
            jPanelGlobalExamenes.setBounds( 0, 65, 700, 525);
            jButtonTraerPanelBuscar1.setEnabled(true);
            
            auxAbm = 2 ;
            
            jButtonAgregarExamen.setEnabled(false);
            jButtonBorrarExamen.setEnabled(false);
            jButtonEditarExamen.setEnabled(true);
            jButtonTraerPanelBuscar1.setEnabled(true);
            
            jTextFieldIuCartera.setEditable(true);
            jTextFieldDominioVeh.setEditable(true);
            jTextFieldPosibleRetirador.setEditable(true);
            jTextFieldFechaExamen.setEditable(false);
            jTextFieldNumExamenVeh.setEditable(false);
            jTextFieldNombExaminador.setEditable(false);
            
            jListCartera.setVisible(true);
            jListDominioVeh.setVisible(true);
            jButtonRegCartera.setEnabled(true);
            jButtonRegVehiculo.setEnabled(true);
   
        }
        });
             
        jMenuItemUltimosAgregados.addActionListener((ActionEvent e) -> {
            _administradorExamenVehiculo.ordenarTabla(jMenuItemUltimosAgregados.getText());
            jTableExamen.setModel( _administradorExamenVehiculo.cargarJTabla());
        });
                          
        jMenuItemPrimerosAgregados.addActionListener((ActionEvent e) -> {
            _administradorExamenVehiculo.ordenarTabla(jMenuItemPrimerosAgregados.getText());
            jTableExamen.setModel( _administradorExamenVehiculo.cargarJTabla());
        });
// se construye el menu completo y se le asigna si jTable
        jPopupMenuTableHE.add(jMenuItemEliminarExamen);
        jPopupMenuTableHE.add(jMenuItemModificarExamen);
        jPopupMenuTableHE.add(jMenuOrdenar);
        jTableExamen.setComponentPopupMenu(jPopupMenuTableHE);  
     }

    // este metodo crea menu de opciones al usar click secundario   
    public final void popupMenuJTablePresup(){
//se crean las opciones del menu
        JPopupMenu jPopupMenuTableHP = new JPopupMenu();
        JMenuItem jMenuItemEliminarPresup = new JMenuItem("Eliminar"); // cambiar x ico 
        JMenuItem jMenuItemModificarPresup = new JMenuItem("Modificar");
        JMenuItem jMenuOrdenar = new JMenu("Ordenar por");
        JMenuItem jMenuItemPrimerosAgregados = new JMenuItem("Primeros agregados");
        JMenuItem jMenuItemUltimosAgregados= new JMenuItem("Ultimos agregados"); 
        jMenuOrdenar.add(jMenuItemPrimerosAgregados);
        jMenuOrdenar.add(jMenuItemUltimosAgregados); 
        
// se generan las acciones de cada opcion
        jMenuItemEliminarPresup.addActionListener((ActionEvent e) -> {
        
        if(seleccionarItemJTablaPresup()!= -1){

            jTextFieldIuPresupuesto.setBorder(null);
            jTextFieldFechaCaja.setBorder(null); 
            jTextFieldIuTipoPresupuesto.setBorder(null);
            jTextFieldDirigidoA.setBorder(null);
            jTextFieldCodModeloVeh.setBorder(null);
            jTextFieldPatenteVeh.setBorder(null);
            jTextFieldCodigoCristal.setBorder(null);
            jTextFieldIuMarcaCris.setBorder(null);
            jTextFieldIuServicios.setBorder(null);
            jTextFieldDescrPresup.setBorder(null);
            jTextFieldTotalPresup.setBorder(null);
        
            jPanelVentanaBuscarPresup.setBounds(-700, 65, 700, 525);
            jPanelGlobalPresupuesto.setBounds(0, 65, 700, 525);

            jButtonAgregarPresupuesto.setEnabled(false);
            jButtonEditarPresupuesto.setEnabled(false);
            jButtonBorrarPresupuesto.setEnabled(true);
            
            jButtonTraerPanelBuscarPresup.setEnabled(true);
            jTextFieldIuPresupuesto.setEditable(false);
            jTextFieldFechaCaja.setEditable(false); 
            jTextFieldIuTipoPresupuesto.setEditable(false);
            jTextFieldDirigidoA.setEditable(false);
            jTextFieldCodModeloVeh.setEditable(false);
            jTextFieldPatenteVeh.setEditable(false);
            jTextFieldCodigoCristal.setEditable(false);
            jTextFieldIuMarcaCris.setEditable(false);
            jTextFieldIuServicios.setEditable(false);
            jTextFieldDescrPresup.setEditable(false);
            jTextFieldTotalPresup.setEditable(false);
            
            jButtonRegMarcaCristal.setEnabled(false);
            jButtonRegModeloVehiculo.setEnabled(false);
            jButtonRegServiciosPrestados.setEnabled(false);
            jButtonRegCatalogo.setEnabled(false);
            
            jListCodigoCrstal.setVisible(false);
            jListMarcasCristales.setVisible(false);
            jListServiciosPrestados.setVisible(false);
            jListModeloVeh.setVisible(false);
            
             }
         });
         
        jMenuItemModificarPresup.addActionListener((ActionEvent e) -> {
            
        if(seleccionarItemJTablaPresup()!= -1){
            
            jTextFieldIuPresupuesto.setBorder(null);
            jTextFieldFechaCaja.setBorder(null); 
            jTextFieldIuTipoPresupuesto.setBorder(null);
            jTextFieldDirigidoA.setBorder(null);
            jTextFieldCodModeloVeh.setBorder(null);
            jTextFieldPatenteVeh.setBorder(null);
            jTextFieldCodigoCristal.setBorder(null);
            jTextFieldIuMarcaCris.setBorder(null);
            jTextFieldIuServicios.setBorder(null);
            jTextFieldDescrPresup.setBorder(null);
            jTextFieldTotalPresup.setBorder(null);
        
            jPanelVentanaBuscarPresup.setBounds(-700, 65, 700, 525);
            jPanelGlobalPresupuesto.setBounds(0, 65, 700, 525);

            jButtonAgregarPresupuesto.setEnabled(false);
            jButtonEditarPresupuesto.setEnabled(true);
            jButtonBorrarPresupuesto.setEnabled(false);
            
            jButtonTraerPanelBuscarPresup.setEnabled(true);
            jTextFieldIuPresupuesto.setEditable(false);
            jTextFieldFechaCaja.setEditable(false); 
            jTextFieldIuTipoPresupuesto.setEditable(false);
            jTextFieldDirigidoA.setEditable(false);
            jTextFieldCodModeloVeh.setEditable(true);
            jTextFieldPatenteVeh.setEditable(true);
            jTextFieldCodigoCristal.setEditable(true);
            jTextFieldIuMarcaCris.setEditable(true);
            jTextFieldIuServicios.setEditable(true);
            jTextFieldDescrPresup.setEditable(true);
            jTextFieldTotalPresup.setEditable(true);
            
            jButtonRegMarcaCristal.setEnabled(true);
            jButtonRegModeloVehiculo.setEnabled(true);
            jButtonRegServiciosPrestados.setEnabled(true);
            jButtonRegCatalogo.setEnabled(true);
            
            jListCodigoCrstal.setVisible(true);
            jListMarcasCristales.setVisible(true);
            jListServiciosPrestados.setVisible(true);
            jListModeloVeh.setVisible(true);
   
        }
        });
             
        jMenuItemUltimosAgregados.addActionListener((ActionEvent e) -> {
            _administradorPresupuesto.ordenarTabla(jMenuItemUltimosAgregados.getText());
            jTablePresup.setModel( _administradorPresupuesto.cargarJTabla());
        });
                          
        jMenuItemPrimerosAgregados.addActionListener((ActionEvent e) -> {
            _administradorPresupuesto.ordenarTabla(jMenuItemPrimerosAgregados.getText());
            jTablePresup.setModel( _administradorPresupuesto.cargarJTabla());
        });
// se construye el menu completo y se le asigna si jTable
        jPopupMenuTableHP.add(jMenuItemEliminarPresup);
        jPopupMenuTableHP.add(jMenuItemModificarPresup);
        jPopupMenuTableHP.add(jMenuOrdenar);
        jTablePresup.setComponentPopupMenu(jPopupMenuTableHP);  
     }
    
// este metodo crea menu de opciones al usar click secundario   
    public final void popupMenuJTableCatalogo(){
//se crean las opciones del menu
        JPopupMenu jPopupMenuTableHP = new JPopupMenu();
        JMenuItem jMenuOrdenar = new JMenu("Ordenar por");
        JMenuItem jMenuItemPrimerosAgregados = new JMenuItem("Primeros agregados");
        JMenuItem jMenuItemUltimosAgregados= new JMenuItem("Ultimos agregados"); 
        JMenuItem jMenuItemMarcaCris= new JMenuItem("Marca cristal"); 
        JMenuItem jMenuItemModeloVeh= new JMenuItem("Modelo vehiculo"); 
        jMenuOrdenar.add(jMenuItemPrimerosAgregados);
        jMenuOrdenar.add(jMenuItemUltimosAgregados); 
        jMenuOrdenar.add(jMenuItemMarcaCris);
        jMenuOrdenar.add(jMenuItemModeloVeh);  
        
        jMenuItemUltimosAgregados.addActionListener((ActionEvent e) -> {
            _administradorCatalogoCristales.ordenarTabla(jMenuItemUltimosAgregados.getText());
            jTable1.setModel( _administradorCatalogoCristales.cargarJTabla());
        });
                          
        jMenuItemPrimerosAgregados.addActionListener((ActionEvent e) -> {
            _administradorCatalogoCristales.ordenarTabla(jMenuItemPrimerosAgregados.getText());
            jTable1.setModel( _administradorCatalogoCristales.cargarJTabla());
        });
        
        jMenuItemMarcaCris.addActionListener((ActionEvent e) -> {
            _administradorCatalogoCristales.ordenarTabla(jMenuItemMarcaCris.getText());
            jTable1.setModel( _administradorCatalogoCristales.cargarJTabla());
        });
                          
        jMenuItemModeloVeh.addActionListener((ActionEvent e) -> {
            _administradorCatalogoCristales.ordenarTabla(jMenuItemModeloVeh.getText());
            jTable1.setModel( _administradorCatalogoCristales.cargarJTabla());
        });
// se construye el menu completo y se le asigna si jTable
        jPopupMenuTableHP.add(jMenuOrdenar);
        jTable1.setComponentPopupMenu(jPopupMenuTableHP);  
     }
    
// se obtiene los datos del item seleccionado en la tabla
    public int seleccionarItemJTablaCaja(){
// se obtiene el modelo y se verifica que se haya seleccionado un item   
        modeloTablaC = jTableCaja.getModel();
        int auxSeleccion = jTableCaja.getSelectedRow();
        if (auxSeleccion != -1) {
            jTableCaja.setEnabled(true);
// se cargan los campos con los valores selcionados
            iuCaja =  (String)modeloTablaC.getValueAt(jTableCaja.getSelectedRow(), 0);
            jTextFieldIuCaja.setText(iuCaja);
            jTextFieldIuTipoCaja.setText((String)modeloTablaC.getValueAt(jTableCaja.getSelectedRow(), 1));
            jTextFieldIuTipoFactura.setText((String)modeloTablaC.getValueAt(jTableCaja.getSelectedRow(), 2));
            jTextFieldFechaCaja.setText((String)modeloTablaC.getValueAt(jTableCaja.getSelectedRow(), 3));
            jTextFieldFechaFactura.setText((String)modeloTablaC.getValueAt(jTableCaja.getSelectedRow(), 4));
            jTextFieldANombreDe.setText((String)modeloTablaC.getValueAt(jTableCaja.getSelectedRow(), 5));
            jTextFieldNumFactura.setText((String)modeloTablaC.getValueAt(jTableCaja.getSelectedRow(), 6));
            jTextFieldDescrCaja.setText((String)modeloTablaC.getValueAt(jTableCaja.getSelectedRow(), 7));
            jTextFieldTotalCaja.setText((String)modeloTablaC.getValueAt(jTableCaja.getSelectedRow(), 8));
            return auxSeleccion;
            
        }else {
// si no selecciona mensaje error 
            jTableCaja.setEnabled(false);
            jPanelItemNoSeleccionadoCaja.setBounds(260, 213, 250, 100);
            return auxSeleccion;
        }
    }

// se obtiene los datos del item seleccionado en la tabla
    public int seleccionarItemJTablaExamen(){
// se obtiene el modelo y se verifica que se haya seleccionado un item   
        modeloTablaE = jTableExamen.getModel();
        int auxSeleccion = jTableExamen.getSelectedRow();
        if (auxSeleccion != -1) {
            jTableExamen.setEnabled(true);
// se cargan los campos con los valores selcionados
            jTextFieldNumExamenVeh.setText((String)modeloTablaE.getValueAt(jTableExamen.getSelectedRow(), 0));
            jTextFieldFechaExamen.setText((String)modeloTablaE.getValueAt(jTableExamen.getSelectedRow(), 1));
            jTextFieldNombExaminador.setText((String)modeloTablaE.getValueAt(jTableExamen.getSelectedRow(), 2));
            jTextFieldIuCartera.setText((String)modeloTablaE.getValueAt(jTableExamen.getSelectedRow(), 3));
            jTextFieldDominioVeh.setText((String)modeloTablaE.getValueAt(jTableExamen.getSelectedRow(), 4));
            jTextFieldPosibleRetirador.setText((String)modeloTablaE.getValueAt(jTableExamen.getSelectedRow(), 5));
            return auxSeleccion;
            
        }else {
// si no selecciona mensaje error 
            jTableExamen.setEnabled(false);
            jPanelItemNoSeleccionadoExamen.setBounds(260, 213, 250, 100);
            return auxSeleccion;
        }
    }
    
// se obtiene los datos del item seleccionado en la tabla
    public int seleccionarItemJTablaPresup(){
// se obtiene el modelo y se verifica que se haya seleccionado un item   
        modeloTablaP = jTablePresup.getModel();
        int auxSeleccion = jTablePresup.getSelectedRow();
        if (auxSeleccion != -1) {
            jTablePresup.setEnabled(true);
// se cargan los campos con los valores selcionados
            jTextFieldIuPresupuesto.setText((String)modeloTablaP.getValueAt(jTablePresup.getSelectedRow(), 0));
            jTextFieldFechaPresup.setText((String)modeloTablaP.getValueAt(jTablePresup.getSelectedRow(), 1));
            jTextFieldIuTipoPresupuesto.setText((String)modeloTablaP.getValueAt(jTablePresup.getSelectedRow(), 2));
            jTextFieldDirigidoA.setText((String)modeloTablaP.getValueAt(jTablePresup.getSelectedRow(), 3));
            jTextFieldCodModeloVeh.setText((String)modeloTablaP.getValueAt(jTablePresup.getSelectedRow(), 4));
            jTextFieldPatenteVeh.setText((String)modeloTablaP.getValueAt(jTablePresup.getSelectedRow(), 5));
            jTextFieldCodigoCristal.setText((String)modeloTablaP.getValueAt(jTablePresup.getSelectedRow(), 6));
            jTextFieldIuMarcaCris.setText((String)modeloTablaP.getValueAt(jTablePresup.getSelectedRow(), 7));
            jTextFieldIuServicios.setText((String)modeloTablaP.getValueAt(jTablePresup.getSelectedRow(), 8));
            jTextFieldDescrPresup.setText((String)modeloTablaP.getValueAt(jTablePresup.getSelectedRow(), 9));
            jTextFieldTotalPresup.setText((String)modeloTablaP.getValueAt(jTablePresup.getSelectedRow(), 10));
            return auxSeleccion;
            
        }else {
// si no selecciona mensaje error 
            jTablePresup.setEnabled(false);
            jPanelItemNoSeleccionadoPresup.setBounds(260, 213, 250, 100);
            return auxSeleccion;
        }
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupTipoPresupuesto;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAceptarElementoExistente;
    private javax.swing.JButton jButtonAceptarElementoExistente1;
    private javax.swing.JButton jButtonAceptarElementoExistente2;
    private javax.swing.JButton jButtonAceptarElementoNoExistente;
    private javax.swing.JButton jButtonAceptarElementoNoExistente1;
    private javax.swing.JButton jButtonAceptarElementoNoExistente2;
    private javax.swing.JButton jButtonAceptarErrorBaseDeDatos;
    private javax.swing.JButton jButtonAceptarErrorBaseDeDatos1;
    private javax.swing.JButton jButtonAceptarErrorBaseDeDatos2;
    private javax.swing.JButton jButtonAceptarErrorBaseDeDatos3;
    private javax.swing.JButton jButtonAceptarErrorBaseDeDatos4;
    private javax.swing.JButton jButtonAceptarGuardadoErroneo;
    private javax.swing.JButton jButtonAceptarGuardadoErroneo1;
    private javax.swing.JButton jButtonAceptarGuardadoErroneo2;
    private javax.swing.JButton jButtonAceptarGuardadoErroneo3;
    private javax.swing.JButton jButtonAceptarGuardadoExitoso;
    private javax.swing.JButton jButtonAceptarGuardadoExitoso1;
    private javax.swing.JButton jButtonAceptarGuardadoExitoso2;
    private javax.swing.JButton jButtonAceptarItemNoSeleccionado2;
    private javax.swing.JButton jButtonAceptarItemNoSeleccionado3;
    private javax.swing.JButton jButtonAceptarItemNoSeleccionado4;
    private javax.swing.JButton jButtonAceptarValidarCambios;
    private javax.swing.JButton jButtonAceptarValidarCambios1;
    private javax.swing.JButton jButtonAceptarValidarCambios2;
    private javax.swing.JButton jButtonAgregarCaja;
    private javax.swing.JButton jButtonAgregarExamen;
    private javax.swing.JButton jButtonAgregarPresupuesto;
    private javax.swing.JButton jButtonAgregarTurnos;
    private javax.swing.JButton jButtonBorrarCaja;
    private javax.swing.JButton jButtonBorrarExamen;
    private javax.swing.JButton jButtonBorrarPresupuesto;
    private javax.swing.JButton jButtonCajaPricipal;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelarValidarCambios;
    private javax.swing.JButton jButtonCancelarValidarCambios1;
    private javax.swing.JButton jButtonCancelarValidarCambios2;
    private javax.swing.JButton jButtonCerrarJFramePreincipal;
    private javax.swing.JButton jButtonEditarCaja;
    private javax.swing.JButton jButtonEditarExamen;
    private javax.swing.JButton jButtonEditarPresupuesto;
    private javax.swing.JButton jButtonGlobalCatalogo;
    private javax.swing.JButton jButtonGlobalExamenes;
    private javax.swing.JButton jButtonGlobalPresupuesto;
    private javax.swing.JButton jButtonMenuCaja;
    private javax.swing.JButton jButtonMenuCartera;
    private javax.swing.JButton jButtonMenuCatalogo;
    private javax.swing.JButton jButtonMenuInformes;
    private javax.swing.JButton jButtonMenuMovimientos;
    private javax.swing.JButton jButtonMenuVehiculo;
    private javax.swing.JButton jButtonMinimizarJFramePrincipal;
    private javax.swing.JButton jButtonRegCartera;
    private javax.swing.JButton jButtonRegCatalogo;
    private javax.swing.JButton jButtonRegDetalleCaja;
    private javax.swing.JButton jButtonRegMarcaCristal;
    private javax.swing.JButton jButtonRegModeloVehiculo;
    private javax.swing.JButton jButtonRegServiciosPrestados;
    private javax.swing.JButton jButtonRegTipoCaja;
    private javax.swing.JButton jButtonRegTipoFactura;
    private javax.swing.JButton jButtonRegVehiculo;
    private javax.swing.JButton jButtonRegistroCartera;
    private javax.swing.JButton jButtonRegistroCatalogo;
    private javax.swing.JButton jButtonRegistroCheques;
    private javax.swing.JButton jButtonRegistroContacto;
    private javax.swing.JButton jButtonRegistroEmisoresDeTarjetas;
    private javax.swing.JButton jButtonRegistroInformes;
    private javax.swing.JButton jButtonRegistroMarcaCris;
    private javax.swing.JButton jButtonRegistroMarcaVeh;
    private javax.swing.JButton jButtonRegistroModeloVeh;
    private javax.swing.JButton jButtonRegistroMovStock;
    private javax.swing.JButton jButtonRegistroMovStock1;
    private javax.swing.JButton jButtonRegistroMovimientos;
    private javax.swing.JButton jButtonRegistroPedidos;
    private javax.swing.JButton jButtonRegistroPolizaSiniestro;
    private javax.swing.JButton jButtonRegistroSeguros;
    private javax.swing.JButton jButtonRegistroTarjetas;
    private javax.swing.JButton jButtonRegistroTipoCaja;
    private javax.swing.JButton jButtonRegistroTipoCartera;
    private javax.swing.JButton jButtonRegistroTipoFacturas;
    private javax.swing.JButton jButtonRegistroTipoPago;
    private javax.swing.JButton jButtonRegistroVehiculos;
    private javax.swing.JButton jButtonTraerPanelBuscar;
    private javax.swing.JButton jButtonTraerPanelBuscar1;
    private javax.swing.JButton jButtonTraerPanelBuscarPresup;
    private javax.swing.JButton jButtonTraerPanelCuerpo;
    private javax.swing.JButton jButtonTraerPanelCuerpo1;
    private javax.swing.JButton jButtonTraerPanelCuerpoPresup;
    private javax.swing.JButton jButtonVerTodos;
    private javax.swing.JLabel jLabelBarraHerramientas;
    private javax.swing.JLabel jLabelFondoCaja;
    private javax.swing.JLabel jLabelFondoCaja1;
    private javax.swing.JLabel jLabelFondoCatalogo1;
    private javax.swing.JLabel jLabelFondoExamen;
    private javax.swing.JLabel jLabelFondoExamen1;
    private javax.swing.JLabel jLabelFondoIcono;
    private javax.swing.JLabel jLabelFondoIconoElementoExitente;
    private javax.swing.JLabel jLabelFondoIconoElementoExitente1;
    private javax.swing.JLabel jLabelFondoIconoElementoExitente2;
    private javax.swing.JLabel jLabelFondoIconoElementoNoExitente;
    private javax.swing.JLabel jLabelFondoIconoElementoNoExitente1;
    private javax.swing.JLabel jLabelFondoIconoElementoNoExitente2;
    private javax.swing.JLabel jLabelFondoIconoErrorBaseDeDatos;
    private javax.swing.JLabel jLabelFondoIconoErrorBaseDeDatos1;
    private javax.swing.JLabel jLabelFondoIconoErrorBaseDeDatos2;
    private javax.swing.JLabel jLabelFondoIconoErrorBaseDeDatos3;
    private javax.swing.JLabel jLabelFondoIconoErrorBaseDeDatos4;
    private javax.swing.JLabel jLabelFondoIconoGuardadoErroneo;
    private javax.swing.JLabel jLabelFondoIconoGuardadoErroneo1;
    private javax.swing.JLabel jLabelFondoIconoGuardadoErroneo2;
    private javax.swing.JLabel jLabelFondoIconoGuardadoErroneo3;
    private javax.swing.JLabel jLabelFondoIconoGuardadoExitoso;
    private javax.swing.JLabel jLabelFondoIconoGuardadoExitoso1;
    private javax.swing.JLabel jLabelFondoIconoGuardadoExitoso2;
    private javax.swing.JLabel jLabelFondoIconoItemNoSeleccionado;
    private javax.swing.JLabel jLabelFondoIconoItemNoSeleccionado1;
    private javax.swing.JLabel jLabelFondoIconoItemNoSeleccionado2;
    private javax.swing.JLabel jLabelFondoIconoMensajeCerrar;
    private javax.swing.JLabel jLabelFondoIconoMensajeValidarCambios;
    private javax.swing.JLabel jLabelFondoIconoMensajeValidarCambios1;
    private javax.swing.JLabel jLabelFondoIconoMensajeValidarCambios2;
    private javax.swing.JLabel jLabelFondoIconoTurnos;
    private javax.swing.JLabel jLabelFondoPresup;
    private javax.swing.JLabel jLabelFondoPresup1;
    private javax.swing.JLabel jLabelIconoAlerta;
    private javax.swing.JLabel jLabelIconoAlertaValidarCambios;
    private javax.swing.JLabel jLabelIconoAlertaValidarCambios1;
    private javax.swing.JLabel jLabelIconoAlertaValidarCambios2;
    private javax.swing.JLabel jLabelIconoError;
    private javax.swing.JLabel jLabelIconoError1;
    private javax.swing.JLabel jLabelIconoError2;
    private javax.swing.JLabel jLabelIconoError3;
    private javax.swing.JLabel jLabelIconoErrorBaseDeDatos;
    private javax.swing.JLabel jLabelIconoErrorBaseDeDatos1;
    private javax.swing.JLabel jLabelIconoErrorBaseDeDatos2;
    private javax.swing.JLabel jLabelIconoErrorBaseDeDatos3;
    private javax.swing.JLabel jLabelIconoErrorBaseDeDatos4;
    private javax.swing.JLabel jLabelIconoErrorElementoExistente;
    private javax.swing.JLabel jLabelIconoErrorElementoExistente1;
    private javax.swing.JLabel jLabelIconoErrorElementoExistente2;
    private javax.swing.JLabel jLabelIconoErrorElementoNoExistente;
    private javax.swing.JLabel jLabelIconoErrorElementoNoExistente1;
    private javax.swing.JLabel jLabelIconoErrorElementoNoExistente2;
    private javax.swing.JLabel jLabelIconoErrorItemNoSeleccionado;
    private javax.swing.JLabel jLabelIconoErrorItemNoSeleccionado1;
    private javax.swing.JLabel jLabelIconoErrorItemNoSeleccionado2;
    private javax.swing.JLabel jLabelIconoExito;
    private javax.swing.JLabel jLabelIconoExito1;
    private javax.swing.JLabel jLabelIconoExito2;
    private javax.swing.JLabel jLabelMensajeDos;
    private javax.swing.JLabel jLabelMensajeElementoExistente;
    private javax.swing.JLabel jLabelMensajeElementoExistente1;
    private javax.swing.JLabel jLabelMensajeElementoExistente2;
    private javax.swing.JLabel jLabelMensajeElementoExistente3;
    private javax.swing.JLabel jLabelMensajeElementoExistente4;
    private javax.swing.JLabel jLabelMensajeElementoExistente5;
    private javax.swing.JLabel jLabelMensajeElementoNoExistente;
    private javax.swing.JLabel jLabelMensajeElementoNoExistente1;
    private javax.swing.JLabel jLabelMensajeElementoNoExistente2;
    private javax.swing.JLabel jLabelMensajeElementoNoExistente3;
    private javax.swing.JLabel jLabelMensajeElementoNoExistente4;
    private javax.swing.JLabel jLabelMensajeElementoNoExistente5;
    private javax.swing.JLabel jLabelMensajeErrorBaseDeDatos;
    private javax.swing.JLabel jLabelMensajeErrorBaseDeDatos1;
    private javax.swing.JLabel jLabelMensajeErrorBaseDeDatos2;
    private javax.swing.JLabel jLabelMensajeErrorBaseDeDatos3;
    private javax.swing.JLabel jLabelMensajeErrorBaseDeDatos4;
    private javax.swing.JLabel jLabelMensajeErrorBaseDeDatos5;
    private javax.swing.JLabel jLabelMensajeErrorBaseDeDatos6;
    private javax.swing.JLabel jLabelMensajeErrorBaseDeDatos7;
    private javax.swing.JLabel jLabelMensajeErrorBaseDeDatos8;
    private javax.swing.JLabel jLabelMensajeErrorBaseDeDatos9;
    private javax.swing.JLabel jLabelMensajeGuardadoCorrecto;
    private javax.swing.JLabel jLabelMensajeGuardadoCorrecto1;
    private javax.swing.JLabel jLabelMensajeGuardadoCorrecto2;
    private javax.swing.JLabel jLabelMensajeGuardadoErroneo;
    private javax.swing.JLabel jLabelMensajeGuardadoErroneo1;
    private javax.swing.JLabel jLabelMensajeGuardadoErroneo2;
    private javax.swing.JLabel jLabelMensajeGuardadoErroneo3;
    private javax.swing.JLabel jLabelMensajeGuardadoErroneo4;
    private javax.swing.JLabel jLabelMensajeGuardadoErroneo5;
    private javax.swing.JLabel jLabelMensajeGuardadoErroneo6;
    private javax.swing.JLabel jLabelMensajeGuardadoErroneo7;
    private javax.swing.JLabel jLabelMensajeItemNoSeleccionado;
    private javax.swing.JLabel jLabelMensajeItemNoSeleccionado1;
    private javax.swing.JLabel jLabelMensajeItemNoSeleccionado2;
    private javax.swing.JLabel jLabelMensajeUno;
    private javax.swing.JLabel jLabelMensajeValidarCambios;
    private javax.swing.JLabel jLabelMensajeValidarCambios1;
    private javax.swing.JLabel jLabelMensajeValidarCambios2;
    private javax.swing.JLabel jLabelMensajeValidarCambios3;
    private javax.swing.JLabel jLabelMensajeValidarCambios4;
    private javax.swing.JLabel jLabelMensajeValidarCambios5;
    private javax.swing.JLabel jLabelTituloANombreDe;
    private javax.swing.JLabel jLabelTituloBuscarCaja;
    private javax.swing.JLabel jLabelTituloBuscarCatalogo;
    private javax.swing.JLabel jLabelTituloBuscarExamen;
    private javax.swing.JLabel jLabelTituloBuscarPresup;
    private javax.swing.JLabel jLabelTituloCodModeloVeh;
    private javax.swing.JLabel jLabelTituloCodigoCristal;
    private javax.swing.JLabel jLabelTituloDescrCaja;
    private javax.swing.JLabel jLabelTituloDescrPresup;
    private javax.swing.JLabel jLabelTituloDirigidoA;
    private javax.swing.JLabel jLabelTituloDominioVeh;
    private javax.swing.JLabel jLabelTituloFechaCaja;
    private javax.swing.JLabel jLabelTituloFechaExamen;
    private javax.swing.JLabel jLabelTituloFechaFactura;
    private javax.swing.JLabel jLabelTituloFechaPresup;
    private javax.swing.JLabel jLabelTituloIuCaja;
    private javax.swing.JLabel jLabelTituloIuCartera;
    private javax.swing.JLabel jLabelTituloIuMarcaCris;
    private javax.swing.JLabel jLabelTituloIuPresupuesto;
    private javax.swing.JLabel jLabelTituloIuServicios;
    private javax.swing.JLabel jLabelTituloIuTipoCaja;
    private javax.swing.JLabel jLabelTituloIuTipoCaja1;
    private javax.swing.JLabel jLabelTituloIuTipoFactura;
    private javax.swing.JLabel jLabelTituloNombExaminador;
    private javax.swing.JLabel jLabelTituloNumExamenVeh;
    private javax.swing.JLabel jLabelTituloNumFactura;
    private javax.swing.JLabel jLabelTituloPatente;
    private javax.swing.JLabel jLabelTituloPosibleRetirador;
    private javax.swing.JLabel jLabelTituloTotalCaja;
    private javax.swing.JLabel jLabelTituloTotalPresup;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jListCartera;
    private javax.swing.JList<String> jListCodigoCrstal;
    private javax.swing.JList<String> jListDetalleCaja;
    private javax.swing.JList<String> jListDominioVeh;
    private javax.swing.JList<String> jListMarcasCristales;
    private javax.swing.JList<String> jListModeloVeh;
    private javax.swing.JList<String> jListServiciosPrestados;
    private javax.swing.JList<String> jListTipoCaja;
    private javax.swing.JList<String> jListTipoFactura;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanelBuscarCatalogo;
    private javax.swing.JPanel jPanelDatosErroneoCaja;
    private javax.swing.JPanel jPanelElementoExistenteCaja;
    private javax.swing.JPanel jPanelElementoExistenteExamen;
    private javax.swing.JPanel jPanelElementoExistentePresup;
    private javax.swing.JPanel jPanelElementoNoExistenteCaja;
    private javax.swing.JPanel jPanelElementoNoExistenteExamen;
    private javax.swing.JPanel jPanelElementoNoExistentePresup;
    private javax.swing.JPanel jPanelErrorBaseDeDatos;
    private javax.swing.JPanel jPanelErrorBaseDeDatosCaja;
    private javax.swing.JPanel jPanelErrorBaseDeDatosCaja1;
    private javax.swing.JPanel jPanelErrorBaseDeDatosExamen;
    private javax.swing.JPanel jPanelErrorBaseDeDatosPresup;
    private javax.swing.JPanel jPanelGlobalCaja;
    private javax.swing.JPanel jPanelGlobalExamenes;
    private javax.swing.JPanel jPanelGlobalPresupuesto;
    private javax.swing.JPanel jPanelGuardadoErroneoCaja;
    private javax.swing.JPanel jPanelGuardadoErroneoExamen;
    private javax.swing.JPanel jPanelGuardadoErroneoPresup;
    private javax.swing.JPanel jPanelGuardadoExitosoCaja;
    private javax.swing.JPanel jPanelGuardadoExitosoExamen;
    private javax.swing.JPanel jPanelGuardadoExitosoPresup;
    private javax.swing.JPanel jPanelItemNoSeleccionadoCaja;
    private javax.swing.JPanel jPanelItemNoSeleccionadoExamen;
    private javax.swing.JPanel jPanelItemNoSeleccionadoPresup;
    private javax.swing.JPanel jPanelListaCodModeloVeh;
    private javax.swing.JPanel jPanelListaCodigoCristal;
    private javax.swing.JPanel jPanelListaDominioVeh;
    private javax.swing.JPanel jPanelListaIuCartera;
    private javax.swing.JPanel jPanelListaIuMarcaCris;
    private javax.swing.JPanel jPanelListaIuServicios;
    private javax.swing.JPanel jPanelListaIuTipoCaja;
    private javax.swing.JPanel jPanelListaIuTipoFactura;
    private javax.swing.JPanel jPanelMensajeCerrar;
    private javax.swing.JPanel jPanelMensajeValidarABMCaja;
    private javax.swing.JPanel jPanelMensajeValidarABMExamen;
    private javax.swing.JPanel jPanelMensajeValidarABMPresup;
    private javax.swing.JPanel jPanelMenuDesplegableCaja;
    private javax.swing.JPanel jPanelMenuDesplegableCartera;
    private javax.swing.JPanel jPanelMenuDesplegableCatalogo;
    private javax.swing.JPanel jPanelMenuDesplegableInformes;
    private javax.swing.JPanel jPanelMenuDesplegableMovimientos;
    private javax.swing.JPanel jPanelMenuDesplegableVehiculo;
    private javax.swing.JPanel jPanelTurnos;
    private javax.swing.JPanel jPanelVentanaBuscarCaja;
    private javax.swing.JPanel jPanelVentanaBuscarExamen;
    private javax.swing.JPanel jPanelVentanaBuscarPresup;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JScrollPane jScrollPaneListaCatalogo;
    private javax.swing.JSeparator jSeparatorANombreDe;
    private javax.swing.JSeparator jSeparatorBuscarCaja;
    private javax.swing.JSeparator jSeparatorBuscarCatalogo;
    private javax.swing.JSeparator jSeparatorBuscarExamen;
    private javax.swing.JSeparator jSeparatorBuscarPresup;
    private javax.swing.JSeparator jSeparatorCodModeloVeh;
    private javax.swing.JSeparator jSeparatorCodigoCristal;
    private javax.swing.JSeparator jSeparatorDescrCaja;
    private javax.swing.JSeparator jSeparatorDescrPresup;
    private javax.swing.JSeparator jSeparatorDirigidoA;
    private javax.swing.JSeparator jSeparatorDominioVeh;
    private javax.swing.JSeparator jSeparatorFechaCaja;
    private javax.swing.JSeparator jSeparatorFechaExamen;
    private javax.swing.JSeparator jSeparatorFechaFactura;
    private javax.swing.JSeparator jSeparatorFechaFactura2;
    private javax.swing.JSeparator jSeparatorIuCaja;
    private javax.swing.JSeparator jSeparatorIuCartera;
    private javax.swing.JSeparator jSeparatorIuMarcaCris;
    private javax.swing.JSeparator jSeparatorIuPresupuesto;
    private javax.swing.JSeparator jSeparatorIuServicios;
    private javax.swing.JSeparator jSeparatorIuTipoCaja;
    private javax.swing.JSeparator jSeparatorIuTipoFactura;
    private javax.swing.JSeparator jSeparatorIuTipoPresupuesto;
    private javax.swing.JSeparator jSeparatorNombExaminador;
    private javax.swing.JSeparator jSeparatorNumExamenVeh;
    private javax.swing.JSeparator jSeparatorNumFactura;
    private javax.swing.JSeparator jSeparatorPatenteVeh;
    private javax.swing.JSeparator jSeparatorPosibleRetirador;
    private javax.swing.JSeparator jSeparatorTotalCaja;
    private javax.swing.JSeparator jSeparatorTotalPresup;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableCaja;
    private javax.swing.JTable jTableExamen;
    private javax.swing.JTable jTablePresup;
    private javax.swing.JTextField jTextFieldANombreDe;
    private javax.swing.JTextField jTextFieldBuscarCaja;
    private javax.swing.JTextField jTextFieldBuscarCatalogo;
    private javax.swing.JTextField jTextFieldBuscarExamen;
    private javax.swing.JTextField jTextFieldBuscarPresup;
    private javax.swing.JTextField jTextFieldCodModeloVeh;
    private javax.swing.JTextField jTextFieldCodigoCristal;
    private javax.swing.JTextField jTextFieldDescrCaja;
    private javax.swing.JTextField jTextFieldDescrPresup;
    private javax.swing.JTextField jTextFieldDirigidoA;
    private javax.swing.JTextField jTextFieldDominioVeh;
    private javax.swing.JTextField jTextFieldFechaCaja;
    private javax.swing.JTextField jTextFieldFechaExamen;
    private javax.swing.JTextField jTextFieldFechaFactura;
    private javax.swing.JTextField jTextFieldFechaPresup;
    private javax.swing.JTextField jTextFieldIuCaja;
    private javax.swing.JTextField jTextFieldIuCartera;
    private javax.swing.JTextField jTextFieldIuMarcaCris;
    private javax.swing.JTextField jTextFieldIuPresupuesto;
    private javax.swing.JTextField jTextFieldIuServicios;
    private javax.swing.JTextField jTextFieldIuTipoCaja;
    private javax.swing.JTextField jTextFieldIuTipoFactura;
    private javax.swing.JTextField jTextFieldIuTipoPresupuesto;
    private javax.swing.JTextField jTextFieldNombExaminador;
    private javax.swing.JTextField jTextFieldNumExamenVeh;
    private javax.swing.JTextField jTextFieldNumFactura;
    private javax.swing.JTextField jTextFieldPatenteVeh;
    private javax.swing.JTextField jTextFieldPosibleRetirador;
    private javax.swing.JTextField jTextFieldTotalCaja;
    private javax.swing.JTextField jTextFieldTotalPresup;
    // End of variables declaration//GEN-END:variables

    void updateUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
