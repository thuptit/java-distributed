/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviecs;

import enums.LoginStatus;
import interfaces.IObserver;
import models.User;

/**
 *
 * @author thunv
 */
public class LoggerSevice implements IObserver{

    @Override
    public void update(User user) {
        if(user.getStatus() == LoginStatus.EXPIRED){
            System.out.println("Mailer: User " + user.getEmail() + " " + user.getIp());
        }
    }
    
}
