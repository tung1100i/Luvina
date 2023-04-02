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
public class PortAddr { 
    String hostname; 
    int portnum ; 
    
    public PortAddr( String s, int i ) { 
        hostname = new String(s); 
        portnum = i; 
    }  
    public String gethostname () { 
        return hostname ; 
    }
    public int getportnum () { 
        return portnum ; 
        }
}