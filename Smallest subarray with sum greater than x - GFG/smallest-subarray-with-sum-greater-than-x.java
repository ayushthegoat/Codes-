//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.smallestSubWithSum(a, n, m));
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int smallestSubWithSum(int a[], int n, int x) {
        // Your code goes here 
        
    int i=0;
    int j=0;
     int min=Integer.MAX_VALUE;
     int total=0;
     
       while(i<a.length){
          total=total+a[i];
          
               while(total>x ){
                   min=Math.min(min,(i-j+1));
                    total=total-a[j];
                   j++;
                   
                   
                
               }
               i++;
       }
       return min==Integer.MAX_VALUE?0:min;
     
    }
}
//  int i=0 , j=0, sum=0 , ans = n+1;
//       while(i<n)
//       {
//           sum = sum + arr[i];
//           while(sum>x && j<=i)
//           {
               
//               ans = min(ans,i-j+1);   
//               sum = sum-arr[j++];      
//           }   
//           i++;
//       }
//       return ans;

