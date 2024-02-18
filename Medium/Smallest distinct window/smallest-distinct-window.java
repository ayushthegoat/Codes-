//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String str) {
        // Your code goes here
        char[] arr = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : arr) set.add(c);
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int len = Integer.MAX_VALUE; 
        while (i < arr.length) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            while (map.size()==set.size()) {
                len = Math.min(len, i - j + 1);
                map.put(arr[j], map.get(arr[j]) - 1);
                if (map.get(arr[j]) == 0) {
                    map.remove(arr[j]);
                }
                j++;
            }
            i++;
        }
        return (len == Integer.MAX_VALUE) ? 0 : len;
    }
        
       
}