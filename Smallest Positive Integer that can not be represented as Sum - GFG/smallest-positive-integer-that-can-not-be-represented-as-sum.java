//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            long array[] = new long[n];
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextLong();
            }
            Solution ob = new Solution();
            System.out.println(ob.smallestpositive(array,n));
            t--;
        }
    } 
} 

// } Driver Code Ends


//User function Template for Java

class Solution { 
    long smallestpositive(long[] arr, int n){ 
    long sum=1;
    long s=0;
        // Your code goes here
        int low=0;
       
      
         Arrays.sort(arr);
         for(int i=0;i<n;i++){
             if(arr[i]>sum){
                 return sum;
             }
             sum=sum+arr[i];
         }
        
        
        return sum;
    }
} 