/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group;

import component.EmployeeComponent;
import implement.EmployeeDecorator;

/**
 *
 * @author thunv
 */
public class TeamLeader extends EmployeeDecorator {
 
    public TeamLeader(EmployeeComponent employee) {
        super(employee);
    }
 
    public void planing() {
        System.out.println(this.employee.getName() + " is planing.");
    }
 
    public void motivate() {
        System.out.println(this.employee.getName() + " is motivating his members.");
    }
 
    public void monitor() {
        System.out.println(this.employee.getName() + " is monitoring his members.");
    }
 
    @Override
    public void doTask() {
        employee.doTask();
        planing();
        motivate();
        monitor();
    }
}
