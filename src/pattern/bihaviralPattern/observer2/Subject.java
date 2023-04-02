/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.observer2;
public interface Subject { 
    void attachMethod(Observer observer); 
    void detachMethod(Observer observer); 
    void notifyAllObserver();
}