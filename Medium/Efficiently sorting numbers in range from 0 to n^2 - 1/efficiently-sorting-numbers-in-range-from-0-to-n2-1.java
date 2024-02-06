//{ Driver Code Starts
//Initial Template for Java
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
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            
            Solution ob = new Solution();
            
            ob.sort(arr,n);
            
            for(int i =0;i<n;i++)
                System.out.print(arr[i]+ " ");
            System.out.println();    
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void sort(int nums[], int n)
    {
        // your code here
         int max=Integer.MIN_VALUE;
       for(int i=0;i<nums.length;i++){
           max=Math.max(max,nums[i]);
       }
       for(int exp=1;max/exp>0;exp*=10){
           countingSort(nums,exp);
       }
    }
     void countingSort(int[]nums,int exp){
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
        for(int i=0;i<output.length;i++){
            nums[i]=output[i];
        }
        }
}