//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        
     
        int sum=0;
        int j=0;
        ArrayList <Integer>list=new ArrayList <>();
           int i=0;
           while(i<arr.length){
                       if(i-j+1==k){
                          list.add(findmax(arr,j,i+1));
                          j++;
                       }
                       i++;
            }
            
        return list;
           
    }
    
    
    static int findmax(int[] nums,int start,int end){
        
      int max = Integer.MIN_VALUE;
    
    for (int i = start; i < end; i++) {
        max = Math.max(max, nums[i]);
    }
    
    return max;
      
    }
}