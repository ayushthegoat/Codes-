//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

    
            long ans = new Solution().maxProduct(arr, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    long maxProduct(int[] arr, int n) {
        // code here
       
      int fmax = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        int tmax = Integer.MIN_VALUE;

        int fmin=Integer.MAX_VALUE;
        int smin=Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > fmax) {
                tmax = smax;
                smax = fmax;
                fmax = arr[i];
            } else if (arr[i] > smax) {
                tmax = smax;
                smax = arr[i];
            } else if (arr[i] > tmax) {
                tmax = arr[i];
            }
            if(arr[i]<fmin){
                smin=fmin;
                fmin=arr[i];
            }else if(arr[i]<smin){
                smin=arr[i];
            }
        }
        

        return Math.max((long) tmax * smax * fmax,(long)fmin*smin*fmax);
    }
}
