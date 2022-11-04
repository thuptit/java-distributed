/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviecs;

import interfaces.IObserver;
import models.User;

/**
 *
 * @author thunv
 */
public class MailerService implements IObserver{

    @Override
    public void update(User user) {
        System.out.println("Logger: "+ user);
    }
    
}
