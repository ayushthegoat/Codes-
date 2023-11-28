//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int ans[] = ob.sumClosest(arr, x);
            System.out.print(ans[0]+" "+ans[1]);
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int[] sumClosest(int[] arr, int x) {
        int low=0;
        int high=arr.length-1;
        int min=Integer.MAX_VALUE;
      int [] res=new int[2];
      
     int sumclose=0;
        while(low<high){
        int sum=arr[low]+arr[high];
        int diff=Math.abs(sum-x);
         if(diff<min){
            min=diff;
            res[0]=arr[low];
            res[1]=arr[high];
        }
        if(sum>x){
              high--   ; 
        }else{
            low++;
        }
       
        }
        
        return res;
            
            
        
    }
}