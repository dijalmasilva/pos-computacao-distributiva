/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dijalmasilva.pos.aplicacao.ditribuida.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dijalmasilva
 */
public class Consumer {

    public static void main(String[] args) {

        try {
            Bus bus = new Bus();
            Hello helloService = (Hello) bus.discovery("Hello");
            String helloTo = helloService.helloTo("Ricardo Job!");
            JOptionPane.showMessageDialog(null, helloTo);
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
