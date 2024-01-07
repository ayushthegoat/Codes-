//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int a[][] = new int[n][n];
		    
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            a[i][j] = Integer.parseInt(sc.next());
		        }
		    }
		    
		    int k = Integer.parseInt(sc.next());
		    Solution T = new Solution();
		    System.out.println(T.Maximum_Sum(a,n,k));
		}
	}
}
// } Driver Code Ends


class Solution
{
    public int Maximum_Sum(int mat[][],int N,int K){
        // Your code goes here
        int max=Integer.MIN_VALUE;
        int[][] arr=new int[N+1][N+1];
        
        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++){
                  if (i == 0 || j == 0) {
                arr[i][j] = 0;
            } else {
                arr[i][j] = mat[i - 1][j - 1] + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
            }

            if (i >= K && j >= K) {
                int curr = arr[i][j] - arr[i - K][j] - arr[i][j - K] + arr[i - K][j - K];
                max = Math.max(max, curr);
            }
        }
    }

        return max;
    }
}
