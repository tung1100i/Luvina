/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadDemo;

/**
 *
 * @author Admin
 */
public class ThreadInterupts_StopWhenException extends Thread { 
    ThreadInterupts_StopWhenException(String st) {
        super.setName(st);
    } 
    public void run() {
        System.out.println("Thread running " + this.getName());
        try {
            Thread.sleep(1000000); //
        } catch (InterruptedException e) {
            Thread self = Thread.currentThread();
           System.out.println("Thread " + self.getName() );
            System.out.println("I'm about to stop");
            return;
        }
    } 
    public static void main(String args[]) {
        ThreadInterupts_StopWhenException t1 = new ThreadInterupts_StopWhenException("Test");
        t1.start();
        t1.interrupt();
    }
}
