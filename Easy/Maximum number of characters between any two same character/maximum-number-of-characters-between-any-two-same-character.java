//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.maxChars(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maxChars(String s)
    {
        //code here
        int max=-1;
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0; i<=s.length()-1; i++){
            if(map.containsKey(s.charAt(i))){
                max=Math.max(max,i-map.get(s.charAt(i))-1);
                
            }else{
                map.put(s.charAt(i),i);
            }
        }
        return max;
    }
}