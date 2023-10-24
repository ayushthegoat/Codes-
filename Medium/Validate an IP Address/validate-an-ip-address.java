//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.io.*;

  public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String s) {
        String[] str=s.split("\\.");
        int count=0;
        int countofdot=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='.'){
                countofdot++;
            }
        }
        for(int i=0;i<str.length;i++)
        { if(str[i].equals("0000") || str[i].equals("000") || str[i].equals("00")){return false;}
           if(str[i].isEmpty()){return false;}
           if((str[i].length()>1) && (str[i].charAt(1)!='0') && (str[i].charAt(0)=='0')){return false;}
           if((str[i].length()>2) && (str[i].charAt(2)!='0') && (str[i].charAt(1)=='0')){return false;}
          for (int j = 0; j < str[i].length(); j++) {
            if (!Character.isDigit(str[i].charAt(j))) {
                return false; // Non-numeric characters are invalid
            }
        }
            int numbes=Integer.parseInt(str[i]);
                 
                if((numbes>=0) && (numbes<=255) )
                {
                    count++;
                }
            
        }
        if(count==4&& countofdot==3)
        {
            return true;
        }
        return false;
        
    }
}