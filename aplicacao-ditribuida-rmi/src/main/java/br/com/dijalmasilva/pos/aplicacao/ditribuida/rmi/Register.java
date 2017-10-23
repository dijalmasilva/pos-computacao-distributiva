/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dijalmasilva.pos.aplicacao.ditribuida.rmi;

import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dijalmasilva
 */
public class Register {

    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry(9091);
            Hello p = (Hello) registry.lookup("hello");
            String helloTo = p.helloTo("Dijalma");
            JOptionPane.showMessageDialog(null, helloTo);
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
