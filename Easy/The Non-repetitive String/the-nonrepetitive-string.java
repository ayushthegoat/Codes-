//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String S = br.readLine();
                    Solution ob = new Solution();
                    if(ob.nonRepetitive(S)==true)
                        System.out.println(1);
                    else
                        System.out.println(0);
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean nonRepetitive(String S)
    {
       
        // Your code goes here
        char[] arr=S.toCharArray();
        
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i]) && map.get(arr[i])!=i-1){
               
                return false;
                
            }else{
                 map.put(arr[i],i);
               
            }
        }
       return true;
    }
}