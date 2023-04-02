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

public class NameServiceImpl extends UnicastRemoteObject
        
        implements NameService {
    final int maxSize = 100;
    private String[] names = new String[maxSize];
    private String[] hosts = new String[maxSize];
    private int[] ports = new int[maxSize];
    private int dirsize = 0;
    public NameServiceImpl() throws RemoteException {
    }
    @Override
    public int search(String s) throws RemoteException {
        for (int i = 0; i < dirsize; i++)
            if (names[i].equals(s)) return i;
        return -1;
    }
    @Override
    public int insert(String s, String hostName, int portNumber)
            throws RemoteException {
        int oldIndex = search(s); // is it already there
        if ((oldIndex == -1) && (dirsize < maxSize)) {
            names[dirsize] = s;
            hosts[dirsize] = hostName;
            ports[dirsize] = portNumber;
            dirsize++;
            return 1;
        } else
            return 0;
    }
    @Override
    public int getPort(int index) throws RemoteException {
        return ports[index];
    }
    @Override
    public String getHostName(int index) throws RemoteException {
        return hosts[index];
    }
    public static void main(String args[]) {
        // create security manager
        System.setSecurityManager(new RMISecurityManager());
        try {
            Registry registry = LocateRegistry.createRegistry(5000);
            NameServiceImpl obj = new NameServiceImpl();
            
            UnicastRemoteObject.exportObject(obj,0);
           // Naming.rebind("rmi://localhost:5000/MyNameServer", obj);
            registry.rebind("rmi://localhost:5000/MyNameServer", obj);
            System.out.println("MyNameServer bound in registry");
        } catch (Exception e) {
            System.out.println("NameServiceImpl err: " + e.getMessage());
        }
    }
}
