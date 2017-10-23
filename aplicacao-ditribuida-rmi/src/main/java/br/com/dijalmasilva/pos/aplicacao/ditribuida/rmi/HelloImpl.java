/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dijalmasilva.pos.aplicacao.ditribuida.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author dijalmasilva
 */
public class HelloImpl extends UnicastRemoteObject implements Hello, Serializable {

    protected HelloImpl() throws RemoteException {
        super();
    }

    @Override
    public String helloTo(String name) throws RemoteException {
        return "Hello, " + name + "! \n Welcome to application in RMI!";
    }
}
