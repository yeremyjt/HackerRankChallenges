package org.yeremy.hackerrank.algorithms.implementation;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
 * Julius Caesar protected his confidential information by encrypting it in a cipher. Caesar's cipher rotated every letter in a string by a fixed number, KK, making it unreadable by his enemies. Given a string, SS, and a number, KK, encrypt SS and print the resulting string.

Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.

Input Format

The first line contains an integer, NN, which is the length of the unencrypted string. 
The second line contains the unencrypted string, SS. 
The third line contains the integer encryption key, KK, which is the number of letters to rotate.

Constraints 
1≤N≤1001≤N≤100 
0≤K≤1000≤K≤100 
SS is a valid ASCII string and doesn't contain any spaces.

Output Format

For each test case, print the encoded string.

Sample Input

11
middle-Outz
2
Sample Output

okffng-Qwvb
 */
public class CaesarCipher
{
    private final static String PATTERN = "[a-zA-Z]";
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String unencryptedString = sc.next();
        int key = sc.nextInt();
        
        System.out.println(encrypt(n, unencryptedString, key));
        
    }

    private static String encrypt(int n, String unencryptedString, int key)
    {
        char[] charArray = unencryptedString.toCharArray();
        String encryptedString = "";
        
        for (int i = 0; i < n; i++) 
        {
            if (isAlphanumeric(charArray[i]))
            {
                encryptedString += rotate(charArray[i], key);
            }
            else
            {
                encryptedString += charArray[i];
            }
        }
        return encryptedString;
    }

    private static String rotate(char c, int key)
    {
 
        int ascii = (int) c;
        int newAscii = 0;
        
        // Lower case letter
        if (ascii >= 97 && ascii <= 122)
        {
            newAscii = ascii;
            for (int i = 0; i < key; i++)
            {
                newAscii++;
                
                if (newAscii > 122)
                    newAscii = 97;
            }
            
            return Character.toString((char) newAscii);
        }
        
        // Upper case letter
        if (ascii >= 65 && ascii <= 90)
        {
            newAscii = ascii;
            for (int i = 0; i < key; i++)
            {
                newAscii++;
                
                if (newAscii > 90)
                    newAscii = 65;
            }
            
            return Character.toString((char) newAscii);
        }
        
        return "";
        
    }

    private static boolean isAlphanumeric(char c)
    {
        String line = c + "";
        Pattern regex = Pattern.compile(PATTERN);
        Matcher matcher = regex.matcher(line);
        
        if (matcher.find())
            return true;
        return false;
    }
}
