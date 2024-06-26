//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private void dfs(int i,int j, int[][] grid,ArrayList<Integer>list, int row, int col){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0){
            return ;
        }
        grid[i][j] = 0;   //marking visited;
        
        int rowCord = i-row;
        int colCord = j-col;
        list.add(rowCord);
        list.add(colCord);
        
        dfs(i+1,j,grid,list,row,col);
        dfs(i-1,j,grid,list,row,col);
        dfs(i,j+1,grid,list,row,col);
        dfs(i,j-1,grid,list,row,col);
        
        
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        Set<List<Integer>>set = new HashSet();
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ArrayList<Integer>list = new ArrayList();
                if(grid[i][j]==1){
                    dfs(i, j, grid, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
        
    }
}
