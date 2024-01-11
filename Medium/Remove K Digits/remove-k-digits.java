//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int K) {
        // code here
        Stack<Character>st=new Stack<>();
        //1002991
        
        for(int i=0;i<S.length();i++) {
		   char c=S.charAt(i);
		   while(!st.isEmpty() && st.peek()>c && K>0) {
			   st.pop();
			   K--;
		   }
		   
		   if(!st.isEmpty() || c!='0') 
			   st.push(c);
	   }	   
	   
	   
	   while(!st.isEmpty() && K>0) {
		   st.pop();
		   K--;
	   }   	  
	   
	   if(st.size()==0)return "0";  
	   
	   StringBuilder ans=new StringBuilder();
	   for(char chr: st) 
		   ans.append(chr);
	   
	  return ans.toString();
    }
}