/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread.Unknown;


import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NameRmiClient {
    public static void main(String args[]) {
        try {
            Registry registry = LocateRegistry.createRegistry(5000);
            NameService r = (NameService)
                                Naming.lookup("rmi://localhost:5000/MyNameServer");
            int i = r.insert("p1", "tick.ece", 2058);
            int j = r.search("p1");
            if (j != -1)
                System.out.println(r.getHostName(j) + ":" + r.getPort(j));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}