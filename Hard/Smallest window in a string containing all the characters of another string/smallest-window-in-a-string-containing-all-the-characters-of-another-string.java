//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {   
        // Your code here
       int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (char c : p.toCharArray()) {
            map1[c - 'a']++;
        }

        String res = "";
        int mct = 0;
        int rmct = p.length();
        int i = -1;
        int j = 0;
        
        while (i < s.length() - 1 || mct == rmct) {
            if (mct < rmct) {
                char c = s.charAt(++i);
                map2[c - 'a']++;
                if (map2[c - 'a'] <= map1[c - 'a']) {
                    mct++;
                }
            } else {
                String substring = s.substring(j, i + 1);
                if (res.isEmpty() || substring.length() < res.length()) {
                    res = substring;
                }
                char leftChar = s.charAt(j++);
                map2[leftChar - 'a']--;
                if (map2[leftChar - 'a'] < map1[leftChar - 'a']) {
                    mct--;
                }
            }
        }
        if(res=="")return new StringBuilder("-1").toString();
        return res;
    }
}