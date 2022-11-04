/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author thunv
 */
public class Leetcode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "babad";
        int n = s.length();
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < n; i++){
            /* at a[i] --  j = i => a[j-1] and a[j+1] 
                           j++   => a[j-1] == a[j+1] increase j & stop j < 1 || a[j-1] != a[j+1]    
            */
            int j = 1;
            while(true){
                char charMid = s.charAt(i);
                char charNext = s.charAt(i+j);
                if((i-j) > 0){
                    char charPrev = s.charAt(i-j);
                    if(charPrev == charNext){
                        result.append(charPrev);
                        result.append(charMid);
                        result.append(charNext);
                    }
                    else{
                        break;
                    }
                }
                else{
                    if(charMid == charNext && j == 1){
                        result.append(charMid);
                        result.append(charNext);
                    }
                    else
                        break;
                }
                j++;
            }
        }
        System.out.println("");
    }
    
}
