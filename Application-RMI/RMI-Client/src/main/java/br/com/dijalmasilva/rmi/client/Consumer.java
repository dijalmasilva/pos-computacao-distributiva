/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dijalmasilva.rmi.client;

import br.com.dijalmasilva.rmi.Hello;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dijalmasilva
 */
public class Consumer {

    public static void main(String[] args) {

        try {
//            System.setProperty("java.rmi.server.hostname", "register-host");
            Registry registry = LocateRegistry.getRegistry("register-host", 9091);
            Hello helloImpl = (Hello) registry.lookup("Hello");
            String helloTo = helloImpl.helloTo("Ricardo Job!");
            System.out.println("Receveid message from producer: " + helloTo);
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
