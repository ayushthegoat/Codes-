//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        // code here
        if(S.length()<=1){
            return S;
        }
   
        
        int low=0;
        int high=0;
        
        String res="";
        for(int i=1;i<S.length();i++){
             
             low=i;
             high=i;
             
             while(S.charAt(low)==S.charAt(high)){
                 low--;
                 high++;
                 if(low==-1 || high==S.length()){
                     break;
                 }
             }
             String pallin=S.substring(low+1,high);
             if(res.length()<pallin.length()){
                 res=pallin;
             }
             low=i-1;
             high=i;
              while(S.charAt(low)==S.charAt(high)){
                 low--;
                 high++;
                 if(low==-1 || high==S.length()){
                     break;
                 }
             }
              pallin=S.substring(low+1,high);
             if(res.length()<pallin.length()){
                 res=pallin;
             }
            
            
           
        }
         if(res.length()==1)return String.valueOf(S.charAt(0));
        return res;
    }
}