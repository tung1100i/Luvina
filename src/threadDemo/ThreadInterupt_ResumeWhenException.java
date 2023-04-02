/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadDemo;

/**
 *
 * @author Hung
 */
 
public class ThreadInterupt_ResumeWhenException extends Thread { 
    ThreadInterupt_ResumeWhenException(String st){
        super.setName(st);
    }
    public void run() {
        System.out.println("Thread running "+ this.getName());
        try { 
             Thread.sleep(1000000); //
        } catch (InterruptedException e) {
              Thread self = Thread.currentThread();
              System.out.println("Thread "+self.getName()+" resumed"); // tiếp tục thực thi
              System.out.println("Thread "+ self.getName() + " is " + self.getState());   
        }         
    }
 
    public static void main(String args[]) {
        ThreadInterupt_ResumeWhenException 
                t1 = new ThreadInterupt_ResumeWhenException("Test");
         t1.start(); 
         t1.interrupt();
    }
}