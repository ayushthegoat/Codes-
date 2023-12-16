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
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.secFrequent(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String secFrequent(String arr[], int N)
    {int max=0;
   
         // your code here
        Map<String,Integer>map=new HashMap<>();
        String result="";
    for(int i=0;i<arr.length;i++){
        map.put(arr[i],map.getOrDefault(arr[i],0)+1);
      
        
        
        
    }
    ArrayList<Integer>list=new ArrayList<>(map.values());
    Collections.sort(list);
    int secondmax=list.get(list.size()-2);
    for(String i:map.keySet())
     if(map.get(i)==secondmax){
         return i;
     }
 return result;   
    
}
}