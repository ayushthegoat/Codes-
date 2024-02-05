//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(str[i]);
            }

            Solution ob = new Solution();
            
            long res[] = ob.factorial(a,n);
            
            for (int i=0; i<n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long[] factorial(long a[], int n) {
        // code here
        int max=0;
        long mod=(long)1e9  + 7;
        long[] res=new long[n];
           for(long i :a){
               max=Math.max(max,(int)i);
           }
          long[] fact=new long[max+1];
          fact[0]=1;
           fact[1] = 1;
        fact[2] = 2;
          for(int i=3;i<=max;i++){
              fact[i]=(fact[i-1]*i) % mod;
              
             }
             
          for(int i=0;i<res.length;i++){
              res[i]=fact[(int)a[i]];
          }
           
           return res;
    }
}