//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String arr[] = br.readLine().split(" ");
                    String A = arr[0];
                    String B = arr[1];
                    Solution obj = new Solution();
                    System.out.println(obj.transform (A, B));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int transform (String A, String B)
    {
        // code here
        int n = A.length();
        int m = B.length();
        
        // If lengths are different, transformation is not possible
        if (n != m) return -1;

        // Check if both strings contain the same characters
        int[] countA = new int[256];
        int[] countB = new int[256];
        for (int i = 0; i < n; i++) {
            countA[A.charAt(i)]++;
            countB[B.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (countA[i] != countB[i]) return -1;
        }

        // Count minimum moves
        int i = n - 1;
        int j = m - 1;
        int moves = 0;

        while (i >= 0) {
            if (A.charAt(i) == B.charAt(j)) {
                j--;
            } else {
                moves++;
            }
            i--;
        }

        return moves;
        
    }
    
}