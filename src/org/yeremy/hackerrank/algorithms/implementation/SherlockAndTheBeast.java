package org.yeremy.hackerrank.algorithms.implementation;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class SherlockAndTheBeast {

    private static String calculateDecentNumber(int digits) {
        if (digits < 3)
            return "-1";
        
        StringBuilder decentNumber = new StringBuilder(digits);
        
        // Since numbers in groups of 3 will always be larger than those in groups of 5,
        // Let's try to find the maximum amount of 5-digit groups of 3 we can fit,
        // while we can at least fit one 3-digit group of 5.
                
        int modulo = digits % 3;
        int fiveDigits = 0;
        //Need to fill the digits with 5s, and then substract 5 digits twice and fill them with 3s.
        if (modulo == 1) {
        	fiveDigits = digits - (5 * 2);
        	
        	if (fiveDigits < 0) { 
        		decentNumber.append("-1");
        	}
        	
        	else {
	        	for (int i = 0; i < fiveDigits; i+= 3) {
	        		decentNumber.append("555");
	        	}
	        	
	        	for (int i = 0; i < (5 * 2); i+= 5) {
	        		decentNumber.append("33333");
	        	}
        	}
        }
        
        //Need to fill the digits with 5s, and then substract 5 digits once and fill them with 3s.
        if (modulo == 2) {
        	fiveDigits = digits - (5);
        	
        	for (int i = 0; i < fiveDigits; i+= 3) {
        		decentNumber.append("555");
        	}
        	
        	for (int i = 0; i < (5); i+= 5) {
        		decentNumber.append("33333");
        	}
        }
        
        
        //Need to fill the all digits with 5s
        if (modulo == 0) {
        	for (int i = 0; i < digits; i+= 3) {
        		decentNumber.append("555");
        	}
        }
        
        return decentNumber.toString();  
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        for (int i = 0; i < n; i++) {
            int digits = in.nextInt();
            
            System.out.println(calculateDecentNumber(digits));
        }  
    }
}
