//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void dfs(char a[][],boolean[][] vis, int row, int col){
        Queue<int[]> q = new ArrayDeque();
        q.offer(new int[]{row, col});
        
        int []delrow = {1, -1, 0, 0};
        int []delcol = {0, 0, 1, -1};
        
        while(!q.isEmpty()){
            int []temp = q.poll();
            int curRow = temp[0];
            int curCol = temp[1];
            
            vis[curRow][curCol] = true;
            
            for(int i=0;i<4;i++){
                int nrow = curRow + delrow[i];
                int ncol = curCol + delcol[i];
                
                 if (nrow >= 0 && nrow < a.length && ncol >= 0 && ncol < a[0].length && !vis[nrow][ncol] && a[nrow][ncol] == 'O') {
          //      vis[nrow][ncol] = true;
                q.offer(new int[]{nrow, ncol});
               }
            }
            
        }
    }
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        boolean[][] vis = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(a[i][j]=='O' && !vis[i][j]){
                        dfs(a, vis, i, j);
                    }
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]=='O' && !vis[i][j]){
                    a[i][j] = 'X';
                }
            }
        }
        return a;
        
    }
//       static void bfs(char [][]a, boolean [][]visited, int r, int c) {
//         Queue<int []> q = new LinkedList<>();
//         q.offer(new int[]{r, c});
        
//         int []row = {1, -1, 0, 0};
//         int []col = {0, 0, 1, -1};
        
//         int n = a.length;
//         int m = a[0].length;
        
//         while(!q.isEmpty()) {
//             int []pos = q.poll();
//             int x = pos[0];
//             int y = pos[1];
            
//             visited[x][y] = true;
            
//             for(int i = 0; i < 4; i++) {
//                 int dx = x + row[i];
//                 int dy = y + col[i];
                
//                 if(dx >= 0 && dx < n && dy >= 0 && dy < m && !visited[dx][dy] && a[dx][dy] == 'O') {
//                     q.offer(new int[]{dx, dy});
//                 }
//             }
//         }
//     }
    
//     static char[][] fill(int n, int m, char a[][])
//     {
//         // code here
        
//         boolean [][]visited = new boolean[n][m];
        
//         for(int i = 0; i < n; i++) {
//             for(int j = 0; j < m; j++) {
//                 if(i == 0 || i == n - 1 || j == 0 || j == m - 1) {
//                     if(a[i][j] == 'O' && !visited[i][j]) {
//                         bfs(a, visited, i, j);
//                     }
//                 }
//             }
//         }
        
//         for(int i = 0; i < n; i++) {
//             for(int j = 0; j < m; j++) {
//                 if(a[i][j] == 'O' && !visited[i][j])
//                     a[i][j] = 'X';
//             }
//         }
        
//         return a;
        
//     }
// }
}