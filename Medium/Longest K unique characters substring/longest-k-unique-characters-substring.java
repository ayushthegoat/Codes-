//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
           if (s == null || s.length() == 0 || k <= 0) {
            return -1;
    }
      int i = 0, j = 0;
        int length = -1;
        Map<Character, Integer> map = new HashMap<>();

        while (i < s.length()) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            while (map.size() > k) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0) {
                    map.remove(s.charAt(j));
                }
                j++;
            }
           if(map.size()==k){
            length = Math.max(length, i - j + 1);
           }
            i++;
        }

        return length;
    }
}