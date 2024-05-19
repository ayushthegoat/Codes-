//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        // code here
          boolean vis[] = new boolean[n];
         boolean paths[] = new boolean[n];

         for(int i=0;i<n;i++){
            if(dfs(i,vis,paths,adj))return true;
         }
         return false;
    }
     private boolean dfs(int curr,boolean vis[],boolean paths[],ArrayList<ArrayList<Integer>> graph){
        if(paths[curr])return true;
        if(vis[curr])return false;

        vis[curr] = true;
        paths[curr] = true;

        for(int neighbour : graph.get(curr)){
            if(dfs(neighbour,vis,paths,graph))return true;
        }
        paths[curr] = false;
        return false;
    }
}