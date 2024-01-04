//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxIndexDiff(int A[], int N) {
        // code here
          int[] rmax=new int[N];
        int[] lmax=new int[N];
        lmax[0]=A[0];
        rmax[N-1]=A[N-1];
      
       for (int i = 1; i < N; i++) {
        lmax[i] = Math.min(lmax[i - 1], A[i]);
        rmax[N - i - 1] = Math.max(rmax[N - i], A[N - i - 1]);
    }
        int ans = 0, i = 0, j = 0;
    while (i < N && j < N) {
        if (lmax[i] <= rmax[j]) {
            ans = Math.max(ans, j - i);
            j++;
        } else {
            i++;
        }
    }
    return ans;
        
    }
}