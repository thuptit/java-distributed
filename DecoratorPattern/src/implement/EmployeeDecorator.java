/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import component.EmployeeComponent;
import java.util.Date;

/**
 *
 * @author thunv
 */
public abstract class EmployeeDecorator implements EmployeeComponent{
    protected EmployeeComponent employee;
    
    protected EmployeeDecorator(EmployeeComponent employee) {
        this.employee = employee;
    }

    @Override
    public String getName() {
        return employee.getName();
    }

    @Override
    public void doTask() {
        //employee.join(joinDate);
    }

    @Override
    public void join(Date joinDate) {
        employee.join(joinDate);
    }

    @Override
    public void terminate(Date terminateDate) {
        employee.terminate(terminateDate);
    }
    
}
