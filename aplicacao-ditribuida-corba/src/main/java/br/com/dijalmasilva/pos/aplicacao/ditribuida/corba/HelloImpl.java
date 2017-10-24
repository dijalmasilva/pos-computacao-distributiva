/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dijalmasilva.pos.aplicacao.ditribuida.corba;

import org.omg.CORBA.ORB;

/**
 *
 * @author dijalmasilva
 */
public class HelloImpl extends helloApp.HelloPOA {

    private ORB orb;

    public void setORB(ORB orb) {
        this.orb = orb;
    }

    @Override
    public String helloTo(String name) {
        return "Hello, " + name + "! \n Welcome to application in CORBA!";
    }

}
