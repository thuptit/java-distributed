/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import enums.LoginStatus;
import serviecs.AccountService;
import serviecs.LoggerSevice;
import serviecs.MailerService;

/**
 *
 * @author thunv
 */
public class Main {
    public static void main(String[] args) {
        AccountService account1 = createAccount("contact@gpcoder.com", "127.0.0.1");
        account1.login();
        account1.changeStatus(LoginStatus.EXPIRED);
 
        System.out.println("---");
        AccountService account2 = createAccount("contact@gpcoder.com", "116.108.77.231");
        account2.login();
    }
 
    private static AccountService createAccount(String email, String ip) {
        AccountService account = new AccountService(email, ip);
        account.attach(new LoggerSevice());
        account.attach(new MailerService());
        return account;
    }
}
