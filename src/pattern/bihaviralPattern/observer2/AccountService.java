/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.observer2;

import java.util.ArrayList;
import java.util.List; 
 
enum LoginStatus {
    SUCCESS, FAILURE, INVALID, EXPIRED
}  
public class AccountService implements Subject { 
    private User user;
    
    private List<Observer> observers = new ArrayList<>(); 
    
    public AccountService(String email, String ip) {
        user = new User();
        user.setEmail(email);
        user.setIp(ip);
    }
 
     
  @Override
    public void attachMethod(Observer observer) {
         if (!observers.contains(observer))
            observers.add(observer);
    }

    @Override
    public void detachMethod(Observer observer) {
         if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }
    @Override
    public void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update(user);
        }
    }
 
    public void changeStatus(LoginStatus status) {
        user.setStatus(status);
        System.out.println("Status is changed");
        this.notifyAllObserver();
    }
 
    public void login() { 
        if (!this.isValidIP()) {
            user.setStatus(LoginStatus.INVALID);
        } else if (this.isValidEmail()) {
            user.setStatus(LoginStatus.SUCCESS);
           } else {
            user.setStatus(LoginStatus.FAILURE);
           }
 
        System.out.println("Login is handled");
        this.notifyAllObserver();//update of Logger, Mailer, Protector
    }
 
    private boolean isValidIP() {
        return "127.0.0.1".equals(user.getIp());
    }
 
    private boolean isValidEmail() {
        return "contact@gmail.com".equalsIgnoreCase(user.getEmail());
    }

   

  

     
}
