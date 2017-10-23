/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dijalmasilva.pos.aplicacao.ditribuida.corba;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

/**
 *
 * @author dijalmasilva
 */
public class Producer {

    public static void main(String[] args) {
        try {
            Bus bus = new Bus();
            HelloImpl helloImpl = new HelloImpl();
            helloImpl.setORB(bus.getOrb());
            bus.registry("Hello", helloImpl);
        } catch (ServantNotActive | WrongPolicy | InvalidName | NotFound | CannotProceed ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
