/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread.LTPT_NguyenThanhTung_1851063190_lab4;

/**
 *
 * @author hp
 */
import java.net.*;
import java.io.*;
import java.util.Random;
public class DatagramClient {
    public static void main(String[] args) throws InterruptedException {
        String hostname;
        int port = 2018;
        int len = 1024;
        DatagramPacket sPacket, rPacket;
        if (args.length > 0)
            hostname = args[0];
        else
            hostname = "localhost";
        try {
            InetAddress ia = InetAddress.getByName(hostname);
            DatagramSocket datasocket = new DatagramSocket();
            BufferedReader stdinp = new BufferedReader(
                                        new InputStreamReader(System.in));
            Random rand = new Random();
            while (true) {
                try {
                    String str="";
                    for(int i=0;i<10;i++){
                        str+=rand.nextInt(10)+1+" ";
                    }
//                    String echoline = stdinp.readLine();//doc du lieu tu console
//                    
//                    if (echoline.equals("done")) break;
//                    byte[] buffer = new byte[echoline.length()];
                    byte[] buffer = new byte[str.length()];
                    buffer = str.getBytes();
                    sPacket = new DatagramPacket(buffer, buffer.length, ia, port);
                    System.out.println("send:"+str);
                    datasocket.send(sPacket);
                    Thread.sleep(1000);
                    byte[] rbuffer = new byte[len];
                    rPacket = new DatagramPacket(rbuffer, rbuffer.length);
                    datasocket.receive(rPacket);
                    String retstring = new String(rPacket.getData());
                    System.out.println("receive: "+retstring);//string gửi về
                } catch (IOException e) {
                    System.err.println(e);
                }
            } // while
        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (SocketException se) {
            System.err.println(se);
        }
    }  // end main
}
