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
import java.util.Scanner;

public class NameRmiClient {
    public static void main(String args[]) {
        int[] a = new int[10];
        Scanner obj = new Scanner(System.in);

            
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",5000);
            NameService r = (NameService)registry.lookup("rmi://localhost:5000/MyNameServer");
            System.out.println("Nhap mang A: ");
            for(int i=0;i<a.length;i++){
                System.out.print("A["+i+"] = ");
                a[i]=obj.nextInt();
            }
            String z= r.SapXep(a);
            System.out.println(z);
        } catch (Exception e) { System.out.println(e);}
    }
}