public class Solution {
   
  public List<Tuple<int, int>> directions = new List<Tuple<int, int>> {
        Tuple.Create(-1, 0),
        Tuple.Create(0, -1),
        Tuple.Create(1, 0),
        Tuple.Create(0, 1)
    };

    public int LongestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.Length == 0 || matrix[0].Length == 0) return 0;
        
        int n = matrix.Length;
        int m = matrix[0].Length;
        int[,] memo = new int[n, m];
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curr = DFS(matrix, i, j, memo);
                max = Math.Max(curr, max);
            }
        }

        return max;
    }

    private int DFS(int[][] matrix, int row, int col, int[,] memo) {
        if (memo[row, col] != 0) return memo[row, col];

        int max = 1;

        foreach (var dir in directions) {
            int nrow = row + dir.Item1;
            int ncol = col + dir.Item2;

            if (nrow >= 0 && nrow < matrix.Length && ncol >= 0 && ncol < matrix[0].Length && matrix[nrow][ncol] > matrix[row][col]) {
                int len = 1 + DFS(matrix, nrow, ncol, memo);
                max = Math.Max(max, len);
            }
        }

        memo[row, col] = max;
        return max;
    }
}