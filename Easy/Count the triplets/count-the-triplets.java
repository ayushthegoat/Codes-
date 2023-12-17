//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.countTriplet(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countTriplet(int arr[], int n) {
        // code here
        int start=0;
        int end=0;
        int ctr=0;
        int sum=0;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            start=0;
            end=arr.length-1;;
            while(start<end){
                sum=arr[start]+arr[end];
                if(arr[i]==sum){
                    ctr++;
                    start++;
                    end--;
                }else if(arr[i]>sum){
                    start++;
                }else {
                    end--;
                }
            }
        }
        return ctr;
    }
}