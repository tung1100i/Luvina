/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadDemo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hung
 */
public class ArrListMultiThread1 implements Runnable { 
    List<String> arrLst; 
    ArrListMultiThread1(List<String> lst) {
        this.arrLst = lst;
    } 
    public void run() {
        for (int i = 1; i <= 500; i++) {
            arrLst.add("This is message #" + i);
        }
    } 
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        Thread t2 = new Thread(new ArrListMultiThread1(lst));
        t2.start();

        Thread t1 = new Thread(new ArrListMultiThread1(lst));
        t1.start(); 
        try { 
            t1.join();
            t2.join();

        } catch (InterruptedException ex) {
            // do nothing
        }
        System.out.println(lst.toString());
        System.out.println("I'm " + Thread.currentThread().getName());
    }
}
