//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.reverseWords (s));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseWords(String S)
    {   
        S+='.';
      char[] arr=S.toCharArray();
      StringBuilder res=new StringBuilder();
      Stack<Character>stk=new Stack<>();
      for(int i=0;i<arr.length;i++){
          if(arr[i]=='.' ){
              if(!stk.isEmpty()){
              while(!stk.isEmpty()){
              res.append(stk.pop());
              }
             
          }
           res.append(arr[i]);
          }else{
          stk.push(arr[i]);
          }
      }
      
      return res.substring(0,res.length()-1).toString();  
    }
}