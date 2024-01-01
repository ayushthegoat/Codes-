//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            char ch = read.readLine().charAt(0);
            int count = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            String result = ob.printString(s,ch,count);
            
            System.out.println(result);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String printString(String S, char ch, int count) {
        // code here
        if(count==0)return S;
          if(S.length()==1 && ch ==S.charAt(0))return S;
        String s="Empty string";
        if(S.length()<count)return s;
        int index=Integer.MIN_VALUE;
        int counter=1;
        for(int i=0;i<S.length();i++){
        char c=S.charAt(i);
        if(c==ch)count--;
        if(count==0){
            index=i;
            break;
        }
        }
        if(index==S.length()-1)return s;
      
        if(index!=Integer.MIN_VALUE)return S.substring(index+1);
        return "Empty string";
    }
}