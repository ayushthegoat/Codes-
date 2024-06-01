//{ Driver Code Starts
// Initial Template for Java

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
            int i = sc.nextInt();

            Solution obj = new Solution();
            obj.bitManipulation(n, i);
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static void bitManipulation(int num, int i) {
        // code here
         int getith = (1<<i-1);
         int aftermaskGET = num & getith;
         if(aftermaskGET==0){
             System.out.print(0 + " ");
         }else{
             System.out.print(1 + " ");
         }
         
         int setith = (1<<i-1);
         int aftermaskSET = num | setith;
         System.out.print(aftermaskSET + " ");
         
         int clearith = ~(1<<i-1);
         int aftermaskCLEAR = num & clearith;
         System.out.print(aftermaskCLEAR);
         
    }
}
