/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dijalmasilva.pos.aplicacao.ditribuida.corba;

import helloApp.Hello;
import helloApp.HelloHelper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

/**
 *
 * @author dijalmasilva
 */
public class Bus {

    private ORB orb;
    private POA rootpoa;

    public Bus() {

        String[] config = new String[]{
            "-ORBInitialPort", "9095",
            "-ORBInitialHost", "localhost"
        };
        try {
            orb = ORB.init(config, System.getProperties());
            rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
        } catch (InvalidName | AdapterInactive ex) {
            Logger.getLogger(Bus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ORB getOrb() {
        return orb;
    }

    public void setOrb(ORB orb) {
        this.orb = orb;
    }

    public void registry(String name, org.omg.PortableServer.Servant objImpl) throws ServantNotActive, WrongPolicy, InvalidName, NotFound, CannotProceed {
        Object servant_to_reference = rootpoa.servant_to_reference(objImpl);
        Hello href = HelloHelper.narrow(servant_to_reference);
        Object objRef = orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
        try {
            NameComponent[] path = ncRef.to_name(name);
            ncRef.rebind(path, href);
            System.out.println("Hello is ready and waiting...");
            orb.run();
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(Bus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Hello discovery(String nameService) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {
        Object services = orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(services);
        return HelloHelper.narrow(ncRef.resolve_str(nameService));
    }
}
