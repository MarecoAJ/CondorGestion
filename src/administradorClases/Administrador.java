/*
* esta clase contiene metodos generales aplicables a todas las vistas. 
*como son cargar fuentes de letras y validaciones
*/
package administradorClases;

import controladorBD.ConectorMySql;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;

public class Administrador extends ConectorMySql{

    private static Font auxFuente;
    private static boolean resultadoValidar;
    private final DefaultListModel _modeloJList;
    private final DefaultListModel _modeloJList2; 
    
    public Administrador() {
    
        _modeloJList = new DefaultListModel();
        _modeloJList2 = new DefaultListModel();
    }
    
// esre metodo carga las fuentes necesarias para las vistas
    public static Font fuentesPersonalizada(String nombFuente, int estiloFuente, float tamañoFuente){
        
 
        
       try {
// pasamos las fuentes a usar directo de los src           
              InputStream auxIS = ClassLoader.class.getResourceAsStream(nombFuente);
              auxFuente = Font.createFont(Font.TRUETYPE_FONT, auxIS);
      
       } catch (FontFormatException | IOException e ) {
// pasamos valores por defecto en caso de no allar los archivos           
           auxFuente = new Font("Arial",Font.PLAIN, 12);

       }
       
// pasamos los tamaños y estilos elegidos       
       Font auxFont = auxFuente.deriveFont(estiloFuente, tamañoFuente);
       
       return auxFont;

        }
     
// se validan los datos ingresados por el usuario para ello se utiliza parametros de validacion 
    public static boolean validarCamposTextos(String textoValidar, String parametrosValidar){
                 
            resultadoValidar=false;
                    if(textoValidar.length()!=0){
                       char auxValidar[]= textoValidar.toCharArray();  
                        for (int i = 0; i < auxValidar.length; i++) {
// se valida caracter a caracter en caso de ser negativo sale del recorrido sino termina normalmente                        
                             String aux = String.valueOf(auxValidar[i]);
                             resultadoValidar = aux.matches(parametrosValidar);
                            if(resultadoValidar==false)break;
                    }
                    
                    }
                    
               
           return resultadoValidar;
     }

// se valida caracter ingresado por el usuario para ello se utiliza parametros de validacion    
    public static boolean validarCharDinamico(char caracter, String parametrosValidar){
           resultadoValidar=false;
           System.err.println("xxx");
           String auxValidar =String.valueOf(caracter); 
// se valida caracter a caracter en caso de ser negativo sale del recorrido sino termina normalmente                                   
           resultadoValidar = auxValidar.matches(parametrosValidar);
           return resultadoValidar;
     }
    
//
    public static boolean validarCamposDoubles(String textoValidar){
                 
            resultadoValidar=false;     
            resultadoValidar = textoValidar.matches("^[0-9]+([.][0-9]{2})?$");
               
           return resultadoValidar;   
    
    
    
    }

    public static boolean validarFecha(String datos, String parametrosValidar){
           resultadoValidar=false;
           String auxValidar =String.valueOf(datos); 
// se valida caracter a caracter en caso de ser negativo sale del recorrido sino termina normalmente                                   
           resultadoValidar = auxValidar.matches(parametrosValidar);
           return resultadoValidar;
    }
    
    public static boolean validarFecha(String datos){
        boolean verdad = false;
        String dia = " "; 
        String mes = " "; 
        String anio = " ";
        
        if(datos.length()!=0){
            
            String[] parts = datos.split("-");
            if(parts.length==3){
                
                dia = parts[0]; 
                mes = parts[1]; 
                anio = parts[2];
            }
            
        }
        
        
            if(validarCamposTextos(dia, "\\d") && validarCamposTextos(mes, "\\d") && validarCamposTextos(anio, "\\d") ){
                if(dia.length() == 2 && mes.length() == 2 && anio.length() == 4){
                verdad =true;
            }
            
        } else if(validarCamposTextos(dia, "\\d") && validarCamposTextos(mes, "\\d") && validarCamposTextos(anio, "\\d") ){
            
            if(dia.length() == 1 && mes.length() == 1 && anio.length() == 4){
                dia = "0" + dia;
                mes = "0" + mes;
                anio = "0" + anio;
                verdad =true;
            }
        } 
        
        return verdad;
    }

    public String obtenerFechaMaquina(){
    
        Calendar fecha = new GregorianCalendar();
        String dia, mes;
        dia = fecha.get(Calendar.DAY_OF_MONTH) + "";
        mes = "" + (fecha.get(Calendar.MONTH) + 1);
        
        if(Integer.parseInt(dia)<10){
   
            dia = "0" + dia;
        }
        if(Integer.parseInt(mes)<10){
   
            mes = "0" + mes;
        }
        
        String auxFechaActual = dia + "-" + mes + "-" + fecha.get(Calendar.YEAR);
        return auxFechaActual;
    }

    public static boolean validarCorreoE(String email) {
       
        boolean valido = false;
       
        Pattern patronEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
   
        Matcher mEmail = patronEmail.matcher(email.toLowerCase());
        
        return mEmail.find();
    }

    public DefaultListModel cargarListaMeses(String busqueda){      
// se genera la coneccion y el query de consulta        
        ArrayList<String> registros = new ArrayList<>();
        _modeloJList.clear();  

        String  meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String sSubCadena= " ";
        if(busqueda.length()!=0 && busqueda.length()<5){
            
            for (int j = 0; j < 12; j++) {
 
            sSubCadena = meses[j].substring(0,busqueda.length());
            
                if(sSubCadena.equalsIgnoreCase(busqueda)){
                    
                    registros.add(meses[j]);
                }
            }      
        } else{
                
            for (int j = 0; j < 12; j++) {
                registros.add(meses[j]);
            }
        }
        
        for (int i = 0; i < registros.size(); i++) {
            
            _modeloJList.add(i,registros.get(i));
        }
        
        return _modeloJList;
    }
   
    public DefaultListModel cargarListaAños(String busqueda){      
// se genera la coneccion y el query de consulta        
        ArrayList<String> registros = new ArrayList<>();
        _modeloJList2.clear();  
        int aux = 0;

        String  anios[] = new String[100];
            for (int i = 0; i < 100; i++) {
                
                aux = 2014 + i;
                anios[i] = "" + aux;
            }
        String sSubCadena= "";
        
        if(busqueda.length()!=0 && busqueda.length()<5){

            for (int j = 0; j < 100; j++) {
                
               
                sSubCadena = anios[j].substring(0,busqueda.length());
                
                if(sSubCadena.equalsIgnoreCase(busqueda)){
                
                    registros.add(anios[j]);
                
                }
            
            }      
        } else{
                
            for (int j = 0; j < 100; j++) {

                registros.add(anios[j]);
           
            }
        }
        
        for (int i = 0; i < registros.size(); i++) {

            _modeloJList2.add(i,registros.get(i));
        }
        
        return _modeloJList2;
    }
        
    public  Date conversorFechas(String fecha) throws java.text.ParseException
    {
        SimpleDateFormat formato = new SimpleDateFormat("aaaa.MM.dd HH: mm: ss zzz");
        Date fechaDate = null;
        fechaDate = (Date) formato.parse(fecha);
        
        return fechaDate;
    }
    
    public String obtenerNumMes(String mes){
    
        String  meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String aux = "";
        for (int i = 0; i < meses.length; i++) {
            
            if(meses[i].equalsIgnoreCase(mes)){
            
               if(i+1 < 10){
               
                   aux = "0" + (i + 1);
               
               } else{
               
                   aux = (i+1) + "";
               }
            
               
               
            }
        }
    return aux;
        
    }
    
}
