//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

  public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ar1 = new int[n], ar2 = new int[n];
            String[] inputLine = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                ar1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                ar2[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().findMidSum(ar1, ar2, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMidSum(int[] ar1, int[] ar2, int n) {
        // code here
        int index=0;
    int[]arr=new int[n*2];
    for(int i=0;i<n;i++)
    {
        arr[index]=ar1[i];
        index++;
    }
    for(int i=0;i<n;i++)
    {
        arr[index]=ar2[i];
        index++;
    }
    Arrays.sort(arr);
    
    int low=0;
    int high=arr.length;
    
    int mid=low+(high-low)/2;
    int nextmid=mid-1;
    return arr[mid]+arr[nextmid];
        }
}