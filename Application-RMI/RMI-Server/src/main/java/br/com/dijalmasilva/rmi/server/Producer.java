/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dijalmasilva.rmi.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dijalmasilva
 */
public class Producer {

    public static void main(String[] args) {

        try {
            System.setProperty("java.rmi.server.hostname", "register-host");
            System.setProperty("com.sun.management.jmxremote.host", "register-host");
            Registry registry = LocateRegistry.createRegistry(9091);
            System.out.println("Registrando serviço HELLO");
            registry.bind("Hello", new HelloImpl());
            String[] list = registry.list();
            for (String l : list) {
                System.out.println(l);
            }
            System.out.println("Serviço Registrado!");
        } catch (RemoteException | AlreadyBoundException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
