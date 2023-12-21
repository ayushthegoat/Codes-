//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.reverse(s));                        
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String reverse(String str)
    {
        //complete the function here
        
        Stack<Character>stk=new Stack<>();
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            
            if(Character.isLetter(c)){
                stk.push(c);
            }
        }
         for(int i=0;i<str.length();i++){
             if(Character.isLetter(str.charAt(i))){
                 sb.append(stk.pop());
             }else{
                 sb.append(str.charAt(i));
             }
         }
         return sb.toString();
    }
}