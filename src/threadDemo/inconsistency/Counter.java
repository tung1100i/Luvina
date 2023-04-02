/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadDemo.inconsistency;

/**
 *
 * @author Hung
 */
public class Counter {
    private int value;
 
    public void increment() {
        value++;
    }
 
    public void decrement() {
        value--;
    }
 
    public int get() {
        return value;
    }
}
