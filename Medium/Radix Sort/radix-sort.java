//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String str[] = read.readLine().trim().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
                
            Solution obj = new Solution();
            obj.radixSort(arr, n);
            for(int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
                
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    static void radixSort(int arr[], int n) 
    { 
        // code here 
       int max=Integer.MIN_VALUE;
       for(int i=0;i<arr.length;i++){
           max=Math.max(max,arr[i]);
       }
       for(int exp=1;max/exp>0;exp*=10){
           countingSort(arr,exp);
       }
    }
    static void countingSort(int[] nums,int exp){
        int count[]=new int[10];
        
        int output[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            count[(nums[i]/exp)%10]++;
        }
        for(int i=1;i<count.length;i++){
            count[i]=count[i]+count[i-1];
        }
        for(int i=nums.length-1;i>=0;i--){
            output[count[(nums[i]/exp)%10]-1]=nums[i];
            count[(nums[i]/exp)%10]--;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=output[i];
        }
        
        
    }
}

