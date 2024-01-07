//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            out.println(obj.countSubArrayProductLessThanK(a, n, k));
        }
        out.close();
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long countSubArrayProductLessThanK(long arr[], int n, long k)
    {
        int i=0,j=0;
        long product=1,count=0;
        while(i<n){
            product*=arr[i];
            while(product>=k && j<=i){
               product/=arr[j];
               j++;
            } 
            count+=(i-j+1);
            i++;
        }
        return count;
    }
}