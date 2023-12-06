//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().smallestSumSubarray(arr, n)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static int smallestSumSubarray(int arr[], int size)
    {
        // your code here
        int i=0;
        int j=0;
        int min=Integer.MAX_VALUE;
        int sum=0;
        while(i<size){
              sum=sum+arr[i];
              
          min=Math.min(sum,min);
             if(sum>0){sum =0;}
             i++;
        }
        return min;
    }
}