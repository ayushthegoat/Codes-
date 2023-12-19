//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();
            
            Solution ob = new Solution();
            
            out.println(ob.reverseEqn(s));    
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseEqn(String S)
    {
        S=S+"+";
        char aux[] = new char[S.length()];
        int index=0;
        // your code here
        Stack<String>stk=new Stack<>();
        StringBuilder sb=new StringBuilder();
          int i=0;
          int j=0;
          while(j<S.length()){
              char c=S.charAt(j);
                   if(!Character.isDigit(c)){
                    aux[index++]=c;         
                       stk.push(S.substring(i,j));
                       i=j+1;
                   }
                  
            j++ ;           
          }
          //for(int x=0;x<aux.length;x++)System.out.println(aux[x]);
          index=index-2;
       // System.out.println(index);
          while(!stk.isEmpty()){
            sb.append(stk.pop());
            if (index >= 0) {
                sb.append(aux[index]);
                index--;
            }

            }
       
            return sb.toString();
    
    }

    
}