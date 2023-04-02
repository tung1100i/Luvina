/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread.Unknown;

/**
 *
 * @author hp
 */
import java.net.*;
import java.io.*;
public class DatagramServer {
    public static String chia(int[] a){
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
    public static void main(String[] args) {
        DatagramPacket datapacket, returnpacket;
        int port = 2018;
        int len = 1024;
        try {
            DatagramSocket datasocket = new DatagramSocket(port);
            byte[] buf = new byte[len];
            datapacket = new DatagramPacket(buf, buf.length);
            while (true) {
                try {
                    datasocket.receive(datapacket);
                    var Nhan= new String(datapacket.getData());
                    String Nhantrim = Nhan.trim();
                    
                    String[] abc;
                    abc = Nhantrim.split("\\s");
                    int[] abcd=new int[abc.length];
                    for(int i=0;i<abcd.length;i++){
                       abcd[i]=Integer.parseInt(abc[i],10);
                    }
                      
                    String strReturn;
                    strReturn = chia(abcd);
                    System.out.println("Proc: "+strReturn);
                    returnpacket = new DatagramPacket(
                            strReturn.getBytes(),
                            strReturn.length(),
                            datapacket.getAddress(),
                            datapacket.getPort());
                    datasocket.send(returnpacket);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        } catch (SocketException se) {
            System.err.println(se);
        }
    }
}
