//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{

    private static Boolean[][] memo;
    private static boolean solve(int[] arr, int index, int sum, int N) {
        if(sum == 0) {
            return true;
        } else if (sum < 0 || index >= N) {
            return false;
        }
        
        if(memo[index][sum] != null) {
            return memo[index][sum];
        }
        
        //take 
        boolean take = solve(arr, index+1, sum-arr[index], N);
        boolean notTake = solve(arr, index+1, sum, N);
        
        return memo[index][sum] = take || notTake;
        
    }
    
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
       memo = new Boolean[N+1][sum+1];
       return solve(arr, 0, sum, N);
    }
}