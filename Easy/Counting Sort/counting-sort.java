//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class CountSort
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            String arr = "";
            arr = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.countSort(arr));
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to arrange all letters of a string in lexicographical 
    //order using Counting Sort.
    public static String countSort(String arr)
    {
        // code here
        StringBuilder str=new StringBuilder();
        char[] ch=new char[26];
        for(int i=0;i<arr.length();i++){
            char c=arr.charAt(i);
            ch[c-'a']++;
        }
        for(int i=0;i<ch.length;i++){
           while(ch[i]>0){
               char curr=(char)('a'+i);
               str.append(curr);
               ch[i]--;
           }
        }
        return str.toString();
    }
}