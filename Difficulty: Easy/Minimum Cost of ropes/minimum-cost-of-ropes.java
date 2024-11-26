//{ Driver Code Starts

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int[] a = new int[input.length]; // Change long to int

            for (int i = 0; i < input.length; i++) {
                a[i] = Integer.parseInt(
                    input[i]); // Change Long.parseLong to Integer.parseInt
            }

            Solution ob = new Solution();
            System.out.println(
                ob.minCost(a)); // Ensure minCost accepts int[] as argument
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return the minimum cost of connecting the ropes.
    public int minCost(int[] arr) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
        }
        
       while (q.size() > 1)  {
            int first = q.poll();
            int second = q.poll();
            sum += first + second;
            q.add(first + second);
        }
        return sum;
    }
}