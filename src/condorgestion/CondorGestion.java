/*
Esta clase conecta la db e inicializa el sistema de manera grafica y desconecta la db
*/
package condorgestion;

import Vistas.JFramePrincipal;
import controladorBD.ConectorMySql;

public class CondorGestion extends ConectorMySql{
   
    public static void main(String[] args) {

//iniciamos la interfaz grafica       
           JFramePrincipal objJFPrincipal = new JFramePrincipal();
           objJFPrincipal.setVisible(true);

    }   
}
