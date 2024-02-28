//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while(t-- > 0){
            String s = sc.nextLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.reverseAlternate(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String reverseAlternate(String s) 
    {
        // code here
       
        String [] str=s.split(" ");
        for(int i=1; i<str.length; i+=2){
            str[i]=reverse(str[i]);
        }
        return String.join(" ",str);
        
       
    }
     String reverse(String sb){
            StringBuilder str=new StringBuilder(sb);
            return str.reverse().toString();
        }
} 