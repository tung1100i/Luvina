/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread.Unknown;

public class LamportClock { 
    public  int c; 
    
    public LamportClock() { 
    c = 1; 
    }
    public int getValue() { 
        return c; 
        }
    public void tick () { // on internal events 
        c=c+1; 
    }
    public void sendAction () { 
    // include c in message 
       c=c+1; 
    } 
    public void receiveAction (int src , int sentvalue) { 
        c = Util.max(c, sentvalue) + 1; 
    }
}

