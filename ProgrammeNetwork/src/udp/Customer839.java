/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import java.io.Serializable;

/**
 *
 * @author thunv
 */
public class Customer839 implements Serializable{
    public String id,code, name, dayOfBirth, userName;

    public Customer839(String id, String code, String name, String dayOfBirth, String userName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.userName = userName;
    }
}
