//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Pair {
    public int first;
    public int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution
{
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        int N = grid.length;
        int M = grid[0].length;
        int[][] vis = new int[N][M];
       
        // Code here
        Queue<Pair>q = new ArrayDeque();
        int res = 0;
        List<Pair> directions = Arrays.asList(
            new Pair(-1, 0),  // up
            new Pair(1, 0),   // down
            new Pair(0, -1),  // left
            new Pair(0, 1),   // right
            new Pair(-1, -1), // up-left
            new Pair(-1, 1),  // up-right
            new Pair(1, -1),  // down-left
            new Pair(1, 1)    // down-right
        );
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    vis[i][j] = 1;
                    int count = 0;
                    q.offer(new Pair(i, j));
                    while(!q.isEmpty()){
                        count++;
                        Pair it = q.poll();
                        int row = it.first;
                        int col = it.second;
                        
                        for(Pair dir : directions){
                            int nrow = row + dir.first;
                            int ncol = col + dir.second;
                            
                            if(nrow>=0 && nrow<N && ncol>=0 && ncol<M && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                                q.offer(new Pair(nrow, ncol));
                                vis[nrow][ncol] = 1;
                            }
                        }
                    }
                    res = Math.max(res,count);
                    
                }
            }
        }
        return res;
    }
}