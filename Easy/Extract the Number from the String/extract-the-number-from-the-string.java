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
            String S=read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    long ExtractNumber(String S){
        //code here
        long max=-1;
       String[]sp=S.split(" ");
     
        for(int i=0;i<sp.length;i++){
            if(Character.isDigit(sp[i].charAt(0))){
                if(!sp[i].contains("9")){
            max=Math.max(max,(Long.valueOf(sp[i])));
            }}}
            return max;
                    }
            }