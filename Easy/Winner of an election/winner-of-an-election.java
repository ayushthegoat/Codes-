//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends




//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {int counter=0;
    
        int max=0;
         Map<String,Integer>map=new TreeMap<>();
         for(int i=0;i<arr.length;i++){
             map.put(arr[i],map.getOrDefault(arr[i],0)+1);
         }
       
  
         String[] res=new String[2];
         for(String i:map.keySet()){
            max=Math.max(max,map.get(i));
         }

        for(String i:map.keySet()){
            if(map.containsKey(i) && map.get(i)==max){
                 res[0]=i;
                 res[1]=String.valueOf(map.get(i));
                 break;
            }
        }
    
         return res;
    }
}

