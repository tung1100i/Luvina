/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadDemo.multiThreadWithoutSyncronized;

import threadDemo.multiThreadUsingSynchronized.*;

/**
 *
 * @author Hung
 */
public class Bank {
    public static final int MAX_ACCOUNT = 10;
    public static final int MAX_AMOUNT = 10;//10
    public static final int INITIAL_BALANCE = 100;
 
    private Account[] accounts = new Account[MAX_ACCOUNT];
 
    public Bank() {
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(INITIAL_BALANCE);
        }
    }
 
    public void transfer(int from, int to, int amount) {
        if (amount <= accounts[from].getBalance()) {
            accounts[from].withdraw(amount);
            accounts[to].deposit(amount);
 
            String message = "%s transfered %d from %s to %s. Total balance: %d\n";
            String threadName = Thread.currentThread().getName();
            System.out.printf(message, threadName, amount, from, to, getTotalBalance());
        }
    }
 
    public int getTotalBalance() {
        int total = 0;
 
        for (int i = 0; i < accounts.length; i++) {
            total += accounts[i].getBalance();
        }
 
        return total;
    }
    
     
    
}
