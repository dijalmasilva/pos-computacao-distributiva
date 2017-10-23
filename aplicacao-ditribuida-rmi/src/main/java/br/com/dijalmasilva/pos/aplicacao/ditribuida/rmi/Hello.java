/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dijalmasilva.pos.aplicacao.ditribuida.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author dijalmasilva
 */
public interface Hello extends Remote {

    public String helloTo(String name) throws RemoteException;
}
