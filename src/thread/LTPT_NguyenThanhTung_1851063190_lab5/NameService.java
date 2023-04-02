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
public interface NameService extends Remote {
    public int search(String s) throws RemoteException;
    public String SapXep(int [] a) throws RemoteException;
    public int getPort(int index) throws RemoteException;
    public String getHostName(int index) throws RemoteException;

}
