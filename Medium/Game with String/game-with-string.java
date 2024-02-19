//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        Queue<Integer>q=new PriorityQueue<>((b,a)->a-b);
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            arr[ch-'a']++;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
            q.add(arr[i]);
            }
        }
         while (k > 0 && !q.isEmpty()) {
            int highestFreq = q.poll(); 
            highestFreq--; 
            if (highestFreq > 0) {
                q.add(highestFreq);
            }
            k--; 
        }
        int res=0;
        while(!q.isEmpty()){
            int top=q.poll();
            res+=top*top;
        }
        return res;
    }
}