/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dijalmasilva.pos.aplicacao.ditribuida.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author dijalmasilva
 */
public class Bus extends UnicastRemoteObject {

    private Registry registry;

    public Bus() throws RemoteException {
        try {
            System.out.println("Creating registry in port 9091...");
            registry = LocateRegistry.createRegistry(9091);
            System.out.println("Registry created! \n");
        } catch (RemoteException ex) {
            System.out.println("Registry already exists.");
            System.out.println("Recovering registry in port 9091...");
            registry = LocateRegistry.getRegistry(9091);
            System.out.println("Recovered registry! \n");
        }
    }

    public void registry(String nameService, Remote remoteImplementation) throws RemoteException, AlreadyBoundException {
        System.out.println("Registering service: " + nameService);
        registry.bind(nameService, remoteImplementation);
        System.out.println("Registered... \n");
    }

    public Remote discovery(String nameService) throws RemoteException, NotBoundException {
        return registry.lookup(nameService);
    }
}
