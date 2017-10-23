/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dijalmasilva.pos.aplicacao.ditribuida.rmi;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dijalmasilva
 */
public class Producer extends UnicastRemoteObject implements Hello, Serializable {

    protected Producer() throws RemoteException {
        super();
    }

    @Override
    public String helloTo(String name) throws RemoteException {
        return "Olá, " + name + "! \n Bem vindo à aplicação RMI!";
    }

    public static void main(String[] args) {
        try {
            Registry registryRMI = LocateRegistry.createRegistry(9091);
            registryRMI.bind("hello", new Producer());
            System.out.print("Server is ready!");
        } catch (RemoteException | AlreadyBoundException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
