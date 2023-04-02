/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread.LTPT_NguyenThanhTung_1851063190_lab5;

/**
 *
 * @author hp
 */
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
    public String SapXep(int[] a) throws RemoteException {
        int ic=0;
        int il=0;
        int jc=0,jl=0;
        String strReturn="";
        int[] chan= new int[a.length];
        int[] le= new int[a.length];
        for(int i=0;i<a.length;i++){
            
            if(a[i] % 2 ==0){
                chan[ic]=a[i];
                ic++;
            }
            else{
                le[il]=a[i];
                il++;
            }
        }
        for(int i=0;i<a.length;i++){
            if(i%2==0 && jc<ic){
                strReturn+=chan[jc]+" ";
                jc++;
            }
            if(i%2!=0 && jl<il){
                strReturn+=le[jl]+" ";
                jl++;
            }
        }
        return strReturn.trim();
    }
    @Override
    public int getPort(int index) throws RemoteException {
        return ports[index];
    }
    @Override
    public String getHostName(int index) throws RemoteException {
        return hosts[index];
    }
    
    public static void main(String args[]) throws RemoteException {
        // create security manager
//        System.setSecurityManager(new RMISecurityManager());
               
        try {
            Registry registry = LocateRegistry.createRegistry(5000);
            NameServiceImpl obj = new NameServiceImpl();
            
            registry.rebind("rmi://localhost:5000/MyNameServer", obj);
            System.out.println("MyNameServer bound in registry");
        } catch (Exception e) {
            System.out.println("NameServiceImpl err: " + e.getMessage());
        }
    }

    
}
