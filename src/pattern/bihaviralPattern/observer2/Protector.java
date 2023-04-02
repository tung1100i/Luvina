/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.observer2;
public class Protector implements Observer {
 
    @Override
    public void update(User user) {
        if (user.getStatus() == LoginStatus.INVALID) {
            System.out.println("Protector: User "  
                    + "IP " + user.getIp() + " is blocked"); // 
        }
        else
            if (user.getStatus() == LoginStatus.FAILURE) {
            System.out.println("Protector: User " + user.getEmail() 
                    + " is invalid. " );
          } 
    }
}