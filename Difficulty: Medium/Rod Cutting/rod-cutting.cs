//{ Driver Code Starts
using System;

using System.Collections.Generic;

public class IntArray {
    public static void input(int[] A, int n) {
        string[] stringArray = Console.ReadLine().Split(' ');
        for (int i = 0; i < n; i++) {
            A[i] = int.Parse(stringArray[i]);
        }
    }

    public static void print(List<int> A) {
        for (int i = 0; i < A.Count; i++) {
            Console.Write(A[i] + " ");
        }
        Console.WriteLine();
    }

    public static void print(int[] A) {
        for (int i = 0; i < A.Length; i++) {
            Console.Write(A[i] + " ");
        }
        Console.WriteLine();
    }
}

namespace DriverCode {
class GFG {
    static void Main(string[] args) {
        int testcases;
        testcases = Convert.ToInt32(Console.ReadLine());
        while (testcases-- > 0) {

            int n = Convert.ToInt32(Console.ReadLine().Trim());

            int[] price = new int[n];
            IntArray.input(price, n);
            Solution obj = new Solution();
            int res = obj.cutRod(n, price);
            Console.WriteLine(res);
        }
    }
}
}

// } Driver Code Ends



class Solution {
  
    private int Solve(int[] price, int[] wt, int n, int w, int[,] memo) {
        if(n == 0 || w == 0){
            return 0;
        }
        if(memo[n, w] != -1) {
            return memo[n, w];
        }
        
        int currWeight = wt[n - 1];
        if(currWeight <= w) {
            int take = price[n-1] + Solve(price, wt, n, w - currWeight, memo);
            int notTake = Solve(price, wt, n-1, w, memo);
            
            memo[n, w] = Math.Max(take, notTake);
            return memo[n, w];
        } else {
            memo[n, w] = Solve(price, wt, n-1, w, memo);
            return memo[n, w];
        }
    }
    public int cutRod(int N, int[] price) {
        // code here
        int[] wt = new int[N];
        

        for(int i=0;i<N;i++){
            wt[i] = i+1;
        }
    
        int[,] memo = new int[N + 1, N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                memo[i, j] = -1;
            }
        }
        return Solve(price, wt, N, N, memo);
        
    }
}
