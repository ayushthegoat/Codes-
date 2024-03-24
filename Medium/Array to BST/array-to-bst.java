//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{     int idx=0;
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
            int n=nums.length;
            int[] res=new int[n];
            int left=0;int right=n-1;
    
            solve(nums,res,left,right);
            return res;
    }
    public void solve(int[] nums,int[] res,int l,int r){
        if(l>r){
            return ;
        }
        int mid=l+(r-l)/2;
        res[idx++]=nums[mid];
        solve(nums,res,l,mid-1);
        solve(nums,res,mid+1,r);
        
    
    }
   
}