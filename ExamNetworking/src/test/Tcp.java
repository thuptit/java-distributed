/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author thunv
 */
public class Tcp {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("203.162.10.109", 2208);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        
        String masv = "B18DCCN655;916";
        
        out.write(masv);
        out.newLine();
        out.flush();
        
        String st = "";
        StringBuilder st1 = new StringBuilder();
        while((st = in.readLine()) != null){
            st1.append(st);
        }
        Set<Character> listNotDuplicate = new LinkedHashSet<Character>();
        StringBuilder results = new StringBuilder();
        for(Character c: st1.toString().toCharArray()){
            if( (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') ){
                listNotDuplicate.add(c);
            }
        }
        for(Character c: listNotDuplicate){
            results.append(c+"");
        }
        
        out.write(results.toString());
        out.newLine();
        out.flush();
        
        in.close();
        out.close();
        client.close();
    }
}
