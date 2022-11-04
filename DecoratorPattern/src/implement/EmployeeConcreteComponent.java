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
public class EmployeeConcreteComponent implements EmployeeComponent{
    
    private String name;
     
    public EmployeeConcreteComponent (String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void doTask() {
       
    }

    @Override
    public void join(Date joinDate) {
        System.out.println(this.getName() + " joined on " + formatDate(joinDate));
    }

    @Override
    public void terminate(Date terminateDate) {
        System.out.println(this.getName() + " terminated on " + formatDate(terminateDate));
    }
    
}
