//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
 {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] string1 = str1.toCharArray();
        char[] string2 = str2.toCharArray();

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < string1.length; i++) {
            char char1 = string1[i];
            char char2 = string2[i];

            if (map.containsKey(char1)) {
                if (map.get(char1) != char2) {
                    return false; 
                }
            } else {
                if (map.containsValue(char2)) {
                    return false; 
                }
                map.put(char1, char2);
            }
        }

        return true;
    }
    
}
        
