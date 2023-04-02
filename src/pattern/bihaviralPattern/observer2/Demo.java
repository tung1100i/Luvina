/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.observer2;

public class Demo {
 
    public static void main(String[] args) {
        AccountService account1 = createAccount("contact@gmail.com", "127.0.0.1");
        account1.login();  
        System.out.println("---"); 
        
        AccountService account2 = createAccount("contact@gmail.com", "127.0.0.2");
        account2.login(); 
        System.out.println("---");
        
        AccountService account3 = createAccount("contact1@gmail.com", "127.0.0.1");
        account3.login(); 
        System.out.println("###---");
        
         AccountService account4 = createAccount("contact@gmail.com", "127.0.0.1");
         account4.login();
         account4.changeStatus(LoginStatus.EXPIRED);
    }
 
    private static AccountService createAccount(String email, String ip) {
        AccountService account = new AccountService(email, ip);
   
        account.attachMethod(new Logger());
        account.attachMethod(new Mailer());
        account.attachMethod(new Protector());
        // account: login, m
        return account;
    }
}