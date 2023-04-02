/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.observer2;

public class Logger implements Observer {
 
    @Override
    public void update(User user) {
        System.out.println(" Logger: " + user);
    }
}