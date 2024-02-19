//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        int start = Arrays.stream(A).max().orElse(Integer.MIN_VALUE);
        int end = Arrays.stream(A).sum();

      
        if (N < M) 
            return -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int currS = allocated(A, mid);
            if (currS <= M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int allocated(int[] arr, int pages) {
        int students = 1, studentPages = 0;
        for (int i = 0; i < arr.length; i++) {
            if (studentPages + arr[i] <= pages) 
                studentPages += arr[i];
            else {
                students++;
                studentPages = arr[i];
            }
        }
        return students;
    }
};