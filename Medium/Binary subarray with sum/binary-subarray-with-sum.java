//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int target = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      
      Solution obj = new Solution();
      int ans = obj.numberOfSubarrays(a, n, target);
      System.out.println(ans);
    }
  }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int numberOfSubarrays(int arr[], int N, int target){
        // code here
        HashMap<Integer,Integer>map=new HashMap<>();
        int cursum=0;
        int res=0;
        map.put(0,1);
        for(int i=0;i<N;i++){
            cursum=cursum+arr[i];
            if(map.containsKey(cursum-target)){
                res+=map.get(cursum-target);
            }
            map.put(cursum,map.getOrDefault(cursum,0)+1);
        }
        return res;
    }
}