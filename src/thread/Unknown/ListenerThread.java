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
import java.io.*;
public class ListenerThread extends Thread {
    int channel;
    MsgHandler process;
    public ListenerThread(int channel, MsgHandler process) {
        this.channel = channel;
        this.process = process;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Msg m = process.receiveMsg(channel);             
                process.handleMsg(m, m.getSrcId(), m.getTag());
            } catch (IOException e) {
                System.err.println(e);            
            }
        }
    }
}