/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dijalmasilva.pos.aplicacao.ditribuida.corba;

import helloApp.Hello;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author dijalmasilva
 */
public class Consumer {

    public static void main(String[] args) {

        try {
            Bus bus = new Bus();

            Hello helloImpl = bus.discovery("Hello");
            String helloTo = helloImpl.helloTo("Ricardo Job");
            JOptionPane.showMessageDialog(null, helloTo);

        } catch (NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName | InvalidName ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
