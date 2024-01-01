//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            String a = "";
            a = sc.next();
            System.out.println(new Solution().modified(a));
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find minimum number of characters which Ishaan must insert  
    //such that string doesn't have three consecutive same characters.
    public static long modified(String a)
    {
        // Your code here
        int count=0;
        int continous=1;
        
        char last=a.charAt(0);
        for(int i=1;i<a.length();i++){
            char first=a.charAt(i);
            if(last==first){
                continous++;
                if(continous==3){
                    count++;
                    continous=1;
                }
            }
            else{
                continous=1;
            }
            last=first;
        }
        return count;
    }
}