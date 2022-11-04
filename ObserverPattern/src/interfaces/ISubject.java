/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


/**
 *
 * @author thunv
 */
public interface ISubject {
    void attach(IObserver observer);
 
    void detach(IObserver observer);
 
    void notifyAllObserver();
}
