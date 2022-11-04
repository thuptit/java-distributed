/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author thunv
 */
public class HandleString {
    public static void main(String[] args) {
        String str = "123cccaaabbb~!@";
        char[] characters = str.toCharArray();
        Set<Character> linkHash = new LinkedHashSet<Character>();
        for(char c: characters){
            if((c >= 'a' && c <= 'z') || (c >='A' && c<='z')){
                linkHash.add(c);
            }
        }
        StringBuilder strBuilder = new StringBuilder();
        for(Character character : linkHash){
            strBuilder.append(character);
        }
        System.out.println(strBuilder.toString());
    }
}
