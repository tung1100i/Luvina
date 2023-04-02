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
import java. util .*; 
public class Msg { 
    int srcId, destId; 
    String tag ; 
    String msgBuf; 
    public Msg(int s, int t, String msgType, String buf) { 
    this. srcId = s; 
    destId = t; 
    tag = msgType; 
    msgBuf = buf; 
    }
    public int getSrcId () { 
    return srcId ;
    }
    public int getDestId () { 
    return destId ; 
    }
    public String getTag() { 
    return tag; 
    }
    public String getMessage () { 
    return msgBuf ; 
    }
    public int getMessageInt () { 
        StringTokenizer st = new StringTokenizer (msgBuf); 
        return Integer. parseInt (st. nextToken());
    }
    public static Msg parsehlsg( StringTokenizer st ){ 
        int srcId = Integer. parseInt (st. nextToken()); 
        int destId = Integer. parseInt (st. nextToken());
        String tag = st. nextToken (); 
        String buf = st. nextToken("#"); 
        return new Msg( srcId , destId , tag, buf); 
    }
    public String tostring (){ 
        String s = String.valueOf(srcId)+" "+ 
        String.valueOf ( destId )+ " "+ 
        tag + " " + msgBuf +"#"; 
        return s; 
    }
}