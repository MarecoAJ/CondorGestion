/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;

/**
 *
 * @author ALEJO
 */
class FocusTraversalOnArray extends FocusTraversalPolicy {

    public FocusTraversalOnArray(Component[] component) {
    }

    @Override
    public Component getComponentAfter(Container aContainer, Component aComponent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Component getComponentBefore(Container aContainer, Component aComponent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Component getFirstComponent(Container aContainer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Component getLastComponent(Container aContainer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Component getDefaultComponent(Container aContainer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
