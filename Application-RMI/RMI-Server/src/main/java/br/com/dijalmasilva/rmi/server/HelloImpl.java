/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dijalmasilva.rmi.server;

import br.com.dijalmasilva.rmi.Hello;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author dijalmasilva
 */
public class HelloImpl extends UnicastRemoteObject implements Hello {

    protected HelloImpl() throws RemoteException {
    }

    @Override
    public String helloTo(String name) {
        return "Hello, " + name + " ! Welcome to application RMI!";
    }

}
